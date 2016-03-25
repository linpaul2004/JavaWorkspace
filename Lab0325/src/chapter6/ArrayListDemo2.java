package chapter6;

import java.util.ArrayList;

public class ArrayListDemo2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> names = new ArrayList<String>();
		names.add("A");
		names.add("B");
		names.add("C");
		for (int i = 0; i < names.size(); i++) {
			names.remove(i);
		}
		System.out.println(names.size());
	}

}
