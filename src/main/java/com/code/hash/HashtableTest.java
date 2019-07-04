package com.code.hash;

import java.util.*;
class Obj{
	
}
public class HashtableTest {
	
	public static void main(String[] args) {



		Hashtable<String, String> tab = new Hashtable<String, String>();

		LinkedList<String> linkList = new LinkedList<String>();

        List<String> arrayList = new ArrayList<>();

        Vector vector = new Vector();

		HashMap<String, String> hashMap = new HashMap<String, String>();

		ArrayList<String> list = new ArrayList<String>();

		List<Obj> ls = new ArrayList<Obj>();
		ls.add(new Obj());
		System.out.println(ls);
		
		System.out.println(ls.get(0));
		for (Obj obj : ls) {
			System.out.println(obj);
		}
	}

	class User {

	    int id;

	    String name;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }


}
