package chapter12;

import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeSet;

public class SetTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeSet<String> treeset = new TreeSet<String>();
		treeset.add("c");
		treeset.add("b");
		treeset.add("a");
		Iterator<String> itr1 = treeset.iterator();
		while (itr1.hasNext()) {
			System.out.println(itr1.next());
		}
		HashSet<String> hashset = new HashSet<String>();
		hashset.add("c");
		hashset.add("b");
		hashset.add("a");
		Iterator<String> itr2 = hashset.iterator();
		while (itr2.hasNext()) {
			System.out.println(itr2.next());
		}
	}

}
