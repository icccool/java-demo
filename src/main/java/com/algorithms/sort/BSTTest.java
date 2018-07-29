package com.algorithms.sort;

public class BSTTest {
	public static void main(String[] args) {
		BST<String, String> bst = new BST<String, String>();
		bst.put("S", "SSS");
		bst.put("E", "EEE");
		bst.put("X", "xxx");
		
		// get
		System.out.println("------------get------------");
		String str = bst.get("X");
		System.out.println(str);
		// size
		System.out.println("------------size------------");
		System.out.println(bst.size());
		// delete
		System.out.println("------------delete------------");
		bst.print();
		// print
		System.out.println("------------print------------");
		bst.levelPrint();
	}
}
