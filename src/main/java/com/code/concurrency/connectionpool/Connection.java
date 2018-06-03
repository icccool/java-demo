package com.code.concurrency.connectionpool;

public class Connection {
	
	
	public Connection() {
		super();
	}

	public Connection(int id) {
		super();
		this.id = id;
	}

	private int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
}
