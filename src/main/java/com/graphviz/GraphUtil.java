package com.graphviz;

import java.io.File;

public class GraphUtil {
	
	public static void main(String[] args) throws Exception {
		String dotFormat = "a->b;a->c";
		createDotGraph(dotFormat, "DotGraph");
		System.out.println("-------------");

	}
	
	public static void printDotGraph(String dotFormat, String fileName) {
		System.out.println("====================================");
		System.out.println("digraph " + fileName + " {");
		System.out.println(dotFormat);
		System.out.println("}");
		System.out.println("====================================");
	}
	
	public static void createDotGraph(String dotFormat, String fileName) {
		System.out.println(dotFormat);
		GraphViz gv = new GraphViz();
		gv.addln(gv.start_graph());
		gv.add(dotFormat);
		gv.addln(gv.end_graph());
		String type = "jpg";
		gv.decreaseDpi();
		gv.decreaseDpi();
		File out = new File(fileName + "." + type);
		gv.writeGraphToFile(gv.getGraph(gv.getDotSource(), type), out);
	}

}
