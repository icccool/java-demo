package com.framework.mybatis;

import java.util.ArrayList;
import java.util.List;

public class Menu {
	String id;
	String name;
	List<Menu> children = new ArrayList<Menu>();

	public Menu() {
		super();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}


	public List<Menu> getChildren() {
		return children;
	}

	public void setChildren(List<Menu> children) {
		this.children = children;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Menu(String id, String name, List<Menu> children) {
		super();
		this.id = id;
		this.name = name;
		this.children = children;
	}

	@Override
	public String toString() {
		return "Menu [id=" + id + ", name=" + name + ", children=" + children + "]";
	}

}
