package homework;

import java.util.Arrays;

public class Homework3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		if (args[0].charAt(0) == 'X' || args[0].charAt(0) == 'x') {
			System.out.println(check(Integer.parseInt(args[0].substring(2))));
		} else {
			int index = Integer.parseInt(args[0].substring(2));
			int[] sequence = new int[8685];
			int cnt = 0;
			for (int i = 0; i <= 13; i++) {
				for (int j = 0; j <= 19; j++) {
					for (int k = 0; k <= 30; k++) {
						if (Math.pow(2, k) < Double.MAX_VALUE / Math.pow(3, j)) {
							double res = Math.pow(2, k) * Math.pow(3, j);
							if (res < Double.MAX_VALUE / Math.pow(5, i)) {
								res *= Math.pow(5, i);
								sequence[cnt++] = (int) res;
							}
						}
					}
				}
			}
			Arrays.sort(sequence, 0, cnt);
			System.out.println(sequence[index - 1]);
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
