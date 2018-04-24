package com.code.serialize;

import java.io.Serializable;

public class Book implements Serializable{
	private int isbn;
	
	public Book(int isbn) {
		super();
		this.isbn = isbn;
	}

	public int getIsbn() {
		return isbn;
	}

	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}

	@Override
	public String toString() {
		return "Book [isbn=" + isbn + "]";
	}
	
	
}
