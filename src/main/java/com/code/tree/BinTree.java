package com.code.tree;

import java.util.Collection;
import java.util.Comparator;

public class BinTree<T> {

	private int size;

	private Node<T> root;

	private Comparator<? super T> cpr;

	public BinTree(Comparator<? super T> comparator) {
		this.cpr = comparator;

	}

	public BinTree(Collection<T> t, Comparator<? super T> comparator) {

	}

	public BinTree(T[] t, Comparator<? super T> cpr) {
	}

	public void add(T t) {
		if (t == null) {
			throw new NullPointerException();
		}
		Node<T> n = new Node<T>(t);
		if (root == null) {
			root = n;
		} else {
			Node<T> node = root;
			Node<T> p = root;
			while (node != null) {
				p = node;
				if (cpr.compare(node.value, t) > 0) {
					node = node.right;
				} else {
					node = node.left;
				}
			}
			if (cpr.compare(p.value, t) > 0) {
				p.right = n;
			} else {
				p.left = n;
			}
		}
	}

	class Node<T> {
		T value;
		Node<T> left;
		Node<T> right;

		public T getValue() {
			return value;
		}

		public void setValue(T value) {
			this.value = value;
		}

		public Node() {
		}

		public Node(T t) {
			this.value = t;
		}

		public Node getLeft() {
			return left;
		}

		public void setLeft(Node left) {
			this.left = left;
		}

		public Node getRight() {
			return right;
		}

		public void setRight(Node right) {
			this.right = right;
		}

	}
}
