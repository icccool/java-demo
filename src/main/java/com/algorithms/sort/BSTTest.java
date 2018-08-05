package com.algorithms.sort;

public class BSTTest {
	public static void main(String[] args) {
		BST<String, String> bst = new BST<String, String>();
		bst.put("S", "AAA");
		bst.put("E", "BBB");
		bst.put("X", "CCC");
		bst.put("A", "DDD");
		bst.put("R", "EEE");
		bst.put("C", "GGG");
		bst.put("H", "GGG");
		bst.put("M", "GGG");

		System.out.println("------------get------------");
		String str = bst.get("5");
		System.out.println(str);

		System.out.println("------------size------------");
		System.out.println(bst.size());

		System.out.println("------------deleteMin-----------");
		//bst.deleteMin();

		System.out.println("------------delete E------------");
		bst.delete("S");
		bst.delete("E");
		//树的高度
		System.out.println("------------树的高度------------");
		int h = bst.height();
		System.out.println(h);

		System.out.println("------------中序遍历------------");
		bst.inOrderPrint();

		System.out.println("------------按层次遍历------------");
		bst.levelOrderPrint();

		bst.levelOrderGraph();
	}
}
