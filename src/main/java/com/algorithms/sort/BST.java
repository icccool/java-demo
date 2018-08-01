package com.algorithms.sort;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/***
 * 二叉查找树 p252
 * 
 * @author wang
 *
 * @param <Key>
 * @param <Value>
 */
public class BST<Key extends Comparable<Key>, Value> {

	private Node root;

	private class Node {

		private Key key;
		private Value val;
		private Node left, right;
		private int N;

		public Node(Key key, Value val, int n) {
			super();
			this.key = key;
			this.val = val;
			N = n;
		}
	}

	public int size() {
		return size(root);
	}

	public int size(Node x) {
		if (x == null) {
			return 0;
		} else {
			return x.N;
		}
	}

	public Value get(Key key) {
		return get(root, key);
	}

	/**
	 * 根据key获得节点
	 * @param x
	 * @param key
	 * @return
	 */
	private Value get(Node x, Key key) {
		if (key == null || x == null) {
			return null;
		}
		int cmp = key.compareTo(x.key);
		if (cmp < 0) {
			return get(x.left, key);
		} else if (cmp > 0) {
			return get(x.right, key);
		} else {
			return x.val;
		}
	}
	
	public void put(Key key, Value val) {
		root = put(root, key, val);
	}

	/**
	 * 插入元素
	 * 
	 * @param key
	 * @param val
	 */
	private Node put(Node x, Key key, Value val) {
		if (key == null || val == null) {
			return null;
		}
		if (x == null) {
			return new Node(key, val, 1);
		}
		int cmp = key.compareTo(x.key);
		if (cmp < 0) {
			x.left = put(x.left, key, val);
		} else if (cmp > 0) {
			x.right = put(x.right, key, val);
		} else {
			x.val = val;
		}
		x.N = size(x.left) + size(x.right) + 1;
		return x;
	}
	
	public void print() {
		in_order(root);
	}
	
	public void levelPrint() {
		level_order(root);
	}
	
	/**
	 * 前序遍历
	 * @param x
	 */
	private void pre_order(Node x) {
		if(x != null) {
			System.out.println(x.key);
			in_order(x.left);
			in_order(x.right);
		}
	}
	
	/**
	 * 中序遍历
	 * @param x
	 */
	private void in_order(Node x) {
		if(x != null) {
			in_order(x.left);
			System.out.println(x.key);
			in_order(x.right);
		}
	}
	
	
	/**
	 * 后序遍历
	 * @param x
	 */
	private void post_order(Node x) {
		if(x != null) {
			in_order(x.left);
			in_order(x.right);
			System.out.println(x.key);
		}
	}
	
	/**
	 * 层次遍历
	 * @param x
	 */
	private void level_order(Node x) {
		if(x != null) {
//			Queue<Node> queue = new Queue<Node>();
//			queue.add(x);
//			while (!queue.isEmpty()) {
//				Node p = queue.peek();
//				System.out.println(p.key);
//				if (p.left != null) {
//					queue.add(p.left);
//				}
//				if (p.right != null) {
//					queue.add(p.right);
//				}
//			}
		}
	}
	
	
	public void graph() {
		Node x = root;
		while(x != null) {
		}
	}
}
