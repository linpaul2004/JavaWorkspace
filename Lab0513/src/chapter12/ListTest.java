package chapter12;

import java.util.ArrayList;

public class ListTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> alist = new ArrayList<String>();
		alist.add("c");
		alist.add("b");
		alist.add("a");
		for (int i = 0; i < alist.size(); i++) {
			System.out.println(alist.get(i));
		}
	}

}
