package com.graphviz;

import static guru.nidi.graphviz.model.Factory.graph;
import static guru.nidi.graphviz.model.Factory.node;

import java.io.File;

import guru.nidi.graphviz.engine.Format;
import guru.nidi.graphviz.engine.Graphviz;
import guru.nidi.graphviz.model.Graph;

//使用nidi jar包
public class Test1 {
	public static void main(String[] args) {
		try {
			Graph g = graph("example1").directed().with(node("a").link(node("b")));
			File f = new File("example/ex1.png");
			Graphviz.fromGraph(g).width(200).render(Format.PNG).toFile(f);
			System.out.println(f.getAbsolutePath());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
