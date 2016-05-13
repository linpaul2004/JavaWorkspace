package chapter12;

import java.util.HashMap;
import java.util.Iterator;
import java.util.TreeMap;

public class MapTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap<String, String> hashmap = new HashMap<String, String>();
		hashmap.put("Joy", "175");
		hashmap.put("Sandy", "178");
		hashmap.put("Blue", "166");
		Iterator<String> itr1 = hashmap.keySet().iterator();
		while (itr1.hasNext()) {
			String key = itr1.next();
			String value = hashmap.get(key);
			System.out.println(key + ":" + value);
		}
		TreeMap<String, String> treemap = new TreeMap<String, String>();
		treemap.put("Joy", "175");
		treemap.put("Sandy", "178");
		treemap.put("Blue", "166");
		Iterator<String> itr2 = treemap.keySet().iterator();
		while (itr2.hasNext()) {
			String key = itr2.next();
			String value = treemap.get(key);
			System.out.println(key + ":" + value);
		}
	}

}
