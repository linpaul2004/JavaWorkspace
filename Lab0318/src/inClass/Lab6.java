package inClass;

import java.util.Scanner;

public class Lab6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Please input x:");
		int x = keyboard.nextInt();
		System.out.println("Please input n:");
		int n = keyboard.nextInt();
		System.out.println("y = " + x * x * n);
		System.out.println("Please input factorial n:");
		n = keyboard.nextInt();
		for (int i = n - 1; i > 1; i--) {
			n *= i;
		}
		System.out.println(n);

		String a = "X=123456";
		int num = Integer.parseInt(a.substring(2));
		System.out.println(num);

		keyboard.close();
	}

}
