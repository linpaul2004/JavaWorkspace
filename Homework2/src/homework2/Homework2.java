package homework2;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Homework2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double a, b, c, deter;
		String pattern;
		Scanner keyboard = new Scanner(System.in);
		DecimalFormat outputFormat = new DecimalFormat();
		a = keyboard.nextDouble();
		b = keyboard.nextDouble();
		c = keyboard.nextDouble();
		keyboard.nextLine();
		pattern = keyboard.nextLine();
		outputFormat.applyPattern(pattern);
		deter = b * b - 4 * a * c;
		deter = Math.sqrt(deter);
		System.out.printf("%s\n%s\n",
				outputFormat.format(a > 0 ? Math.max((-b + deter) / (2 * a), (-b - deter) / (2 * a))
						: Math.min((-b + deter) / (2 * a), (-b - deter) / (2 * a))),
				outputFormat.format(a > 0 ? Math.min((-b + deter) / (2 * a), (-b - deter) / (2 * a))
						: Math.max((-b + deter) / (2 * a), (-b - deter) / (2 * a))));
		keyboard.close();
	}

}
