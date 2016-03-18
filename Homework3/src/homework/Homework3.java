package homework;

public class Homework3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] input = args[0].split("\n");
		for (int i = 0; i < input.length; i++) {
			if (input[i].charAt(0) == 'X') {
				System.out.println(check(Integer.parseInt(input[i].substring(2))));
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
		return n == 0 ? true : false;
	}

}
