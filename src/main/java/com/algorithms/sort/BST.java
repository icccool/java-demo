package com.algorithms.sort;

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
	
	private void in_order(Node x) {
		if(x != null) {
			in_order(x.left);
			System.out.println(x.key);
			in_order(x.right);
		}
	}
	
	public void graph() {
		Node x = root;
		while(x != null) {
			
		}
	}
}
