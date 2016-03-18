package homework;

import java.util.HashSet;

public class Homework3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		if (args[0].charAt(0) == 'X' || args[0].charAt(0) == 'x') {
			System.out.println(check(Integer.parseInt(args[0].substring(2))));
		} else {
			int index = Integer.parseInt(args[0].substring(2));
			if (index <= 6) {
				System.out.println(index);
			} else {
				HashSet<Integer> sequence = new HashSet<>();
				sequence.add(1);
				sequence.add(2);
				sequence.add(3);
				sequence.add(4);
				sequence.add(5);
				sequence.add(6);
				int i;
				for (i = 7; sequence.size() != index; i++) {
					int tmp = i;
					while (true) {
						if (tmp % 2 == 0) {
							tmp /= 2;
						} else if (tmp % 3 == 0) {
							tmp /= 3;
						} else if (tmp % 5 == 0) {
							tmp /= 5;
						} else {
							break;
						}
						if (sequence.contains(tmp)) {
							sequence.add(i);
							break;
						}
					}
				}
				System.out.println(i - 1);
			}
		}
	}

	private static boolean check(int n) {
		while (n % 2 == 0) {
			n /= 2;
		}
		while (n % 3 == 0) {
			n /= 3;
		}
		while (n % 5 == 0) {
			n /= 5;
		}
		return n == 1 ? true : false;
	}

}
