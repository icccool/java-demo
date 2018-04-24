package com.code.redis;

import java.util.Collections;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.script.DigestUtils;
import org.springframework.data.redis.core.script.RedisScript;

/**
 * Created On 10/24 2017
 * Redis实现的分布式锁(不可重入)
 * 此对象非线程安全，使用时务必注意
 */
public class RedisLock {

    private static final Logger logger = LoggerFactory.getLogger(RedisLock.class);
    private final StringRedisTemplate stringRedisTemplate;
    private final String lockKey;
    private final String lockValue;
    private boolean locked = false;
    /**
     * 使用脚本在redis服务器执行这个逻辑可以在一定程度上保证此操作的原子性
     * （即不会发生客户端在执行setNX和expire命令之间，发生崩溃或失去与服务器的连接导致expire没有得到执行，发生永久死锁）
     * <p>
     * 除非脚本在redis服务器执行时redis服务器发生崩溃，不过此种情况锁也会失效
     */
    private static final RedisScript<Boolean> SETNX_AND_EXPIRE_SCRIPT;

    static {
        StringBuilder sb = new StringBuilder();
        sb.append("if (redis.call('setnx', KEYS[1], ARGV[1]) == 1) then\n");
        sb.append("\tredis.call('expire', KEYS[1], tonumber(ARGV[2]))\n");
        sb.append("\treturn true\n");
        sb.append("else\n");
        sb.append("\treturn false\n");
        sb.append("end");
        SETNX_AND_EXPIRE_SCRIPT = new RedisScriptImpl<Boolean>(sb.toString(), Boolean.class);
    }

    private static final RedisScript<Boolean> DEL_IF_GET_EQUALS;

    static {
        StringBuilder sb = new StringBuilder();
        sb.append("if (redis.call('get', KEYS[1]) == ARGV[1]) then\n");
        sb.append("\tredis.call('del', KEYS[1])\n");
        sb.append("\treturn true\n");
        sb.append("else\n");
        sb.append("\treturn false\n");
        sb.append("end");
        DEL_IF_GET_EQUALS = new RedisScriptImpl<Boolean>(sb.toString(), Boolean.class);
    }

    public RedisLock(StringRedisTemplate stringRedisTemplate, String lockKey) {
        this.stringRedisTemplate = stringRedisTemplate;
        this.lockKey = lockKey;
        this.lockValue = UUID.randomUUID().toString() + "." + System.currentTimeMillis();
    }

    private boolean doTryLock(int lockSeconds) throws Exception {
        if (locked) {
            throw new IllegalStateException("already locked!");
        }
        locked = stringRedisTemplate.execute(SETNX_AND_EXPIRE_SCRIPT, Collections.singletonList(lockKey), lockValue,
                String.valueOf(lockSeconds));
        return locked;
    }

    /**
     * 尝试获得锁，成功返回true，如果失败立即返回false
     *
     * @param lockSeconds 加锁的时间(秒)，超过这个时间后锁会自动释放
     */
    public boolean tryLock(int lockSeconds) {
        try {
            return doTryLock(lockSeconds);
        } catch (Exception e) {
            logger.error("tryLock Error", e);
            return false;
        }
    }

//    protected StringRedisTemplate redisStringTemplate;
//    // 存储到redis中的锁标志
//    private static final String LOCKED = "LOCKED";
//    // 请求锁的超时时间(ms)
//    private static final long TIME_OUT = 30000;
//    // 锁的有效时间(s)
//    public static final int EXPIRE = 60;
//    // 锁标志对应的key;
//    private String key;


//    @Override
//    public void lock() {
//        //系统当前时间，毫秒
//        long nowTime = System.nanoTime();
//        //请求锁超时时间，毫秒
//        long timeout = TIME_OUT*1000000;
//        final Random r = new Random();
//        try {
//            //不断循环向Master节点请求锁，当请求时间(System.nanoTime() - nano)超过设定的超时时间则放弃请求锁
//            //这个可以防止一个客户端在某个宕掉的master节点上阻塞过长时间
//            //如果一个master节点不可用了，应该尽快尝试下一个master节点
//            while ((System.nanoTime() - nowTime) < timeout) {
//                //将锁作为key存储到redis缓存中，存储成功则获得锁
//                if (redisStringTemplate.getConnectionFactory().getConnection().setNX(key.getBytes(),
//                        LOCKED.getBytes())) {
//                    //设置锁的有效期，也是锁的自动释放时间，也是一个客户端在其他客户端能抢占锁之前可以执行任务的时间
//                    //可以防止因异常情况无法释放锁而造成死锁情况的发生
//                    redisStringTemplate.expire(key, EXPIRE, TimeUnit.SECONDS);
//                    isLocked = true;
//                    //上锁成功结束请求
//                    break;
//                }
//                //获取锁失败时，应该在随机延时后进行重试，避免不同客户端同时重试导致谁都无法拿到锁的情况出现
//                //睡眠3毫秒后继续请求锁
//                Thread.sleep(3, r.nextInt(500));
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    @Override
//    public void unlock() {
//        //释放锁
//        //不管请求锁是否成功，只要已经上锁，客户端都会进行释放锁的操作
//        if (isLocked) {
//            redisStringTemplate.delete(key);
//        }
//    }



    /**
     * 轮询的方式去获得锁，成功返回true，超过轮询次数或异常返回false
     *
     * @param lockSeconds       加锁的时间(秒)，超过这个时间后锁会自动释放
     * @param tryIntervalMillis 轮询的时间间隔(毫秒)
     * @param maxTryCount       最大的轮询次数
     */
    public boolean tryLock(final int lockSeconds, final long tryIntervalMillis, final int maxTryCount) {
        int tryCount = 0;
        while (true) {
            if (++tryCount >= maxTryCount) {
                // 获取锁超时
                return false;
            }
            try {
                if (doTryLock(lockSeconds)) {
                    return true;
                }
            } catch (Exception e) {
                logger.error("tryLock Error", e);
                return false;
            }
            try {
                Thread.sleep(tryIntervalMillis);
            } catch (InterruptedException e) {
                logger.error("tryLock interrupted", e);
                return false;
            }
        }
    }

    /**
     * 解锁操作
     */
    public void unlock() {
        if (!locked) {
            throw new IllegalStateException("not locked yet!");
        }
        locked = false;
        // 忽略结果
        stringRedisTemplate.execute(DEL_IF_GET_EQUALS, Collections.singletonList(lockKey), lockValue);
    }

    private static class RedisScriptImpl<T> implements RedisScript<T> {
        private final String script;
        private final String sha1;
        private final Class<T> resultType;

        public RedisScriptImpl(String script, Class<T> resultType) {
            this.script = script;
            this.sha1 = DigestUtils.sha1DigestAsHex(script);
            this.resultType = resultType;
        }

        @Override
        public String getSha1() {
            return sha1;
        }

        @Override
        public Class<T> getResultType() {
            return resultType;
        }

        @Override
        public String getScriptAsString() {
            return script;
        }
    }
}