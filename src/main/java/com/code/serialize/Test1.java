package com.code.serialize;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Test1 {
	public static void main(String args[]) {
		writer();// 自己可以注释掉代码试试
		reader();
	}

	public static void writer() {
		Map<Integer, Student1> students = new HashMap<Integer, Student1>();
		students.put(1, new Student1("A"));
		students.put(2, new Student1("B"));
		File stuInfo = new File("stuInfo.txt");
		ObjectOutputStream oos = null;
		try {
			oos = new ObjectOutputStream(new FileOutputStream(stuInfo));
			oos.writeObject(students);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				oos.flush();
				oos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static void reader() {
		Map<Integer, Student1> students = null;
		File stuInfo = new File("stuInfo.txt");
		ObjectInputStream ois = null;
		try {
			ois = new ObjectInputStream(new FileInputStream(stuInfo));
			Object o = ois.readObject();
			students = (Map<Integer, Student1>) o;

			System.out.println(students);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				ois.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}

class Student1 implements Serializable {
	Student1(String name) {
		this.name = name;
	}

	private String name;

	@Override
	public String toString() {

		return "Student name:" + name;
	}
}