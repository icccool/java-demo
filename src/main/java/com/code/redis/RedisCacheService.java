package com.code.redis;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import redis.clients.jedis.Jedis;

public class RedisCacheService {

	private static final Jedis jedis = new Jedis("192.168.8.5", 6379);
	private static final String CHARSET = "utf-8";

	public static byte[] toBytes(Object obj) {
		ByteArrayOutputStream baos = null;
		ObjectOutputStream oos = null;
		try {
			baos = new ByteArrayOutputStream();
			oos = new ObjectOutputStream(baos);
			oos.writeObject(obj);
			return baos.toByteArray();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (oos != null) {
				try {
					oos.close();
				} catch (IOException e) {
				}
			}
			if (baos != null) {
				try {
					oos.close();
				} catch (IOException e) {
				}
			}
		}
		return null;
	}

	public static Object toObject(byte[] bts) {
		ObjectInputStream ois = null;
		try {
			ois = new ObjectInputStream(new ByteArrayInputStream(bts));
			return ois.readObject();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			if (ois != null) {
				try {
					ois.close();
				} catch (IOException e) {
				}
			}
		}
		return null;
	}

	public static String set(String key, byte[] bytes) {
		try {
			return jedis.set(key.getBytes(CHARSET), bytes);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/***
	 * 
	 * @param key
	 * @param object
	 */
	public static String set(String key, Object object) {
		try {
			return jedis.set(key.getBytes(CHARSET), toBytes(object));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/***
	 * 
	 * @param key
	 * @param object
	 */
	public static byte[] get(String key) {
		try {
			return jedis.get(key.getBytes(CHARSET));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
