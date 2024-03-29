package com.algorithms.algs4th.chapter1;

public class Queue<E> {
	
	private Object[] data = null;
	private int maxSize; // 队列容量
	private int front; // 队列头，允许删除
	private int rear; // 队列尾，允许插入

	// 构造函数
	public Queue() {
		this(30);
	}
	
	public Queue(int initialSize) {
		if (initialSize >= 0) {
			this.maxSize = initialSize;
			data = new Object[initialSize];
			front = rear = 0;
		} else {
			throw new RuntimeException("初始化大小不能小于0：" + initialSize);
		}
	}

	/**
	 * 是否为空
	 * @return
	 */
	public boolean empty() {
		return rear == front ? true : false;
	}

	/**
	 * 添加元素
	 * @param e
	 * @return
	 */
	public boolean add(E e) {
		if (rear == maxSize) {
			throw new RuntimeException("队列已满，无法插入新的元素！");
		} else {
			data[rear++] = e;
			return true;
		}
	}

	/**
	 * 返回队列单不删除
	 * 
	 * @return
	 */
	public E peek() {
		if (empty()) {
			throw new RuntimeException("空队列异常！");
		} else {
			return (E) data[front];
		}
	}

	/***
	 * 出列
	 * 
	 * @return
	 */
	public E poll() {
		if (empty()) {
			throw new RuntimeException("空队列异常！");
		} else {
			E value = (E) data[front]; // 保留队列的front端的元素的值
			data[front++] = null; // 释放队列的front端的元素
			return value;
		}
	}

	/**
	 * 队列长度
	 * 
	 * @return
	 */
	public int length() {
		return rear - front;
	}
}
