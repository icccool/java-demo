package com.algorithms.sort;

import java.util.LinkedList;
import java.util.Queue;

import com.graphviz.GraphUtil;

/***
 * 二叉查找树 p252
 * 
 * @author wang
 *
 * @param <K>
 * @param <V>
 */
public class BST<K extends Comparable<K>, V> {

	private Node root;

	private class Node {

		private K key;
		private V val;
		private Node left, right;
		private int N;

		public Node(K key, V val, int n) {
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

	public V get(K key) {
		return get(root, key);
	}

	/**
	 * 根据key获得节点
	 * 
	 * @param x
	 * @param key
	 * @return
	 */
	private V get(Node x, K key) {
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

	/**
	 * 插入元素 <br>
	 * 如果插入相同的key会更新val
	 * 
	 * @param key
	 * @param val
	 */
	public void put(K key, V val) {
		root = put(root, key, val);
	}

	private Node put(Node x, K key, V val) {
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

	// 按层次遍历
	public void levelOrderGraph() {
		level_order_graph(root);
	}

	// 生成graphviz图
	private void level_order_graph(Node x) {
		StringBuffer sb = new StringBuffer();
		if (x != null) {
			Queue<Node> queue = new LinkedList<Node>();
			queue.add(x);
			while (!queue.isEmpty()) {
				Node p = queue.poll();
				if (p.left != null) {
					queue.add(p.left);
					sb.append(p.key + " -> " + p.left.key + ";\n");
				} else {
					// 如果没有节点用一个虚节点代替
					int l = (int) (Math.random() * 1000);
					sb.append(p.key + " -> " + l + "[style=invis];\n");
					sb.append(l + "[style=invis];\n");
				}

				if (p.right != null) {
					queue.add(p.right);
					sb.append(p.key + " -> " + p.right.key + ";\n");
				} else {
					// 如果没有节点用一个虚节点代替
					int r = (int) (Math.random() * 1000);
					sb.append(p.key + " -> " + r + "[style=invis];\n");
					sb.append(r + "[style=invis];\n");
				}
			}
		}
		GraphUtil.printDotGraph(sb.toString(), "inOrderGraph");
	}

	/**
	 * 中序遍历
	 */
	public void inOrderPrint() {
		in_order(root);
	}
	
	private void in_order(Node x) {
		if (x != null) {
			in_order(x.left);
			System.out.println(x.key);
			in_order(x.right);
		}
	}

	/**
	 * 按层次遍历
	 * 
	 */
	public void levelOrderPrint() {
		level_order(root);
	}
	
	private void level_order(Node x) {
		if (x != null) {
			Queue<Node> queue = new LinkedList<Node>();
			queue.add(x);
			while (!queue.isEmpty()) {
				Node p = queue.poll();
				System.out.println(p.key);
				if (p.left != null) {
					queue.add(p.left);
				}
				if (p.right != null) {
					queue.add(p.right);
				}
			}
		}
	}

	/**
	 *  删除最小节点
	 */
	public void deleteMin() {
		root = deleteMin(root);
	}

	public Node deleteMin(Node x) {
		if (x.left == null) {
			return x.right;
		}
		x.left = deleteMin(x.left);
		x.N = size(x.left) + 1 + size(x.right);
		return x;

	}

	/**
	 *  x子树的最小节点
	 */
	private Node min(Node x) {
		if (x.left == null) {
			return x;
		}
		return min(x.left);
	}

	/**
	 *  删除指定key
	 * @param key
	 */
	public void delete(K key) {
		root = deleteNode(root, key);
	}

	private Node deleteNode(Node x, K key) {
		if (x == null) {
			return null;
		}
		int cmp = key.compareTo(x.key);
		if (cmp < 0) {
			x.left = deleteNode(x.left, key);
		} else if (cmp > 0) {
			x.right = deleteNode(x.right, key);
		} else {
			// x只有左节点的情况
			if (x.right == null) {
				return x.left;
			}
			// x只有右节点的情况
			if (x.left == null) {
				return x.right;
			}
			// x有两个节点的情况
			Node t = x;
			x = min(t.right); // 用右子树最小节点代替 x
			x.right = deleteMin(t.right); // 删除右子树最小节点
			x.left = t.left; // 左子树不变
		}
		x.N = size(x.left) + 1 + size(x.right);
		return x;
	}

	/**
	 * 树的高度
	 * 
	 * @return
	 */
	public int height() {
		return height(root);
	}

	private int height(Node x) {
		if (x != null) {
			int l = height(x.left) + 1;
			int r = height(x.right) + 1;
			if (l > r) {
				return l;
			} else {
				return r;
			}
		}
		return 0;
	}
}
