package com.code.concurrency.executeservice;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.*;

/**
 * @Author WANG JI BO
 * @Date 2019/3/25 下午9:19
 * @Description
 **/
public class CallableTest {

    static class MyWorker implements Callable<String> {

        private int sleepTime;

        public MyWorker(int sleepTime) {
            this.sleepTime = sleepTime;
        }

        @Override
        public String call() throws Exception {
            Thread.sleep(sleepTime * 1000);
            return "线程休息" + sleepTime + "秒!!!";
        }
    }

    public static void main(String[] args) {
        ThreadPoolExecutor executorService = (ThreadPoolExecutor) Executors.newFixedThreadPool(2);
        List<Future<String>> resultList = new ArrayList<>();
        int[] t = {5, 3, 2, 3, 6, 7};
        for (int i = 0; i < 6; i++) {
            resultList.add(executorService.submit(new MyWorker(t[i])));
        }

        int nThreads = resultList.size();
        int cnt = 0;
        do {
            try {
                Iterator<Future<String>> iterator = resultList.iterator();
                while (iterator.hasNext()) {
                    Future<String> f = iterator.next();
                    if (f.isDone()) {
                        System.out.println(f.get());
                        cnt++;
                        iterator.remove();
                    }
                }

                TimeUnit.MILLISECONDS.sleep(50);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } while (cnt < nThreads);
        System.out.println("=========================================================="+cnt);

    }
}
