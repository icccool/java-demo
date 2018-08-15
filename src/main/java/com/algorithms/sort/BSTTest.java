package com.algorithms.sort;

import java.util.Queue;

public class BSTTest {
	public static void main(String[] args) {
		String strs = "A X C S E R H";
		String[] chs = strs.split(" ");
		BST<String, String> bst = new BST<String, String>();
		for (String s : chs) {
			bst.put(s, "A");
		}
		
//		BST<String, String> bst = new BST<String, String>();
//		bst.put("S", "AAA");
//		bst.put("E", "BBB");
//		bst.put("X", "CCC");
//		bst.put("A", "DDD");
//		bst.put("R", "EEE");
//		bst.put("C", "GGG");
//		bst.put("H", "GGG");
//		bst.put("M", "GGG");

		bst.put("S", "AAA");
		bst.put("E", "BBB");
		bst.put("X", "CCC");

		bst.put("A", "DDD");
		bst.put("R", "EEE");

		bst.put("C", "GGG");
		bst.put("H", "GGG");

		bst.put("M", "GGG");

		bst.put("L", "GGG");
		bst.put("P", "GGG");

		System.out.println("------------根据key获取值------------");
		String str = bst.get("5");
		System.out.println(str);

		System.out.println("------------节点数量------------");
		System.out.println(bst.size());

		System.out.println("------------删除最小的-----------");
		//bst.deleteMin();

		System.out.println("------------删除E------------");
		//bst.delete("E");
		
		//树的高度
		System.out.println("------------树的高度------------");
		int h = bst.height();
		System.out.println(h);

		System.out.println("------------中序遍历------------");
		bst.inOrderPrint();

		System.out.println("------------按层次遍历------------");
		bst.levelOrderPrint();

		System.out.println("------------按层次遍历------------");
		bst.levelOrderPrint();

		System.out.println("------------查找[L..P]范围------------");
		Queue<String> queue = bst.keys("L","P");
		if (!queue.isEmpty()){
			System.out.println(queue);
		}

		bst.levelOrderGraph();
	}
}
