package com.algorithms.list;

public class MyList<E> {

	protected int size;
	Node<E> header = new Node<E>();

	class Node<E> {
		E e;
		Node next;
		Node previous;

		public Node() {

		}

		public Node(E e, Node next) {
			this.e = e;
			this.next = next;
		}
	}

	public MyList() {
		size = 0;
	}

	public E add(E e) {
		Node last = header;
		while (last.next != null) {
			last = last.next;
		}
		Node<E> node = new Node<E>(e, null);
		last.next = node;
		size++;
		return e;
	}

}
