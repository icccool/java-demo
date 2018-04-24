package com.code.nio.selector;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerializableUtil {

	public static byte[] toBytes(Object obj) {
		ByteArrayOutputStream bis = new ByteArrayOutputStream();
		ObjectOutputStream in = null;
		try {
			in = new ObjectOutputStream(bis);
			in.writeObject(obj);
			return bis.toByteArray();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				in.close();
			} catch (IOException e) {
			}
		}
		return null;
	}

	public static Object toObject(byte[] bts) {
		ObjectInputStream ois = null;
		try {
			ByteArrayInputStream bis = new ByteArrayInputStream(bts);
			ois = new ObjectInputStream(bis);
			return ois.readObject();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}finally{
			try {
				ois.close();
			} catch (IOException e) {
			}
		}
		return null;
	}
}
