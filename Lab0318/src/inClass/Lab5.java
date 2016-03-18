package inClass;

import java.util.Random;

public class Lab5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Random rand = new Random();
		for (int i = 0; i < 100; i++) {
			int x = rand.nextInt(40);
			System.out.println(x);
		}
		String a = new String("X=1235");
		System.out.println(a.charAt(0));
	}

}
