package hugeint;

public class Comparison implements IOperation {
	public String perform(String num1, String num2) {
		if (num1.charAt(0) == '-' && num2.charAt(0) != '-') {
			return "-1";
		} else if (num1.charAt(0) != '-' && num2.charAt(0) == '-') {
			return "1";
		} else if (num1.charAt(0) != '-' && num2.charAt(0) != '-') {
			if (num1.length() > num2.length()) {
				return "1";
			} else if (num1.length() < num2.length()) {
				return "-1";
			} else {
				for (int i = 0; i < num1.length(); i++) {
					if (num1.charAt(i) > num2.charAt(i)) {
						return "1";
					} else if (num1.charAt(i) < num2.charAt(i)) {
						return "-1";
					}
				}
				return "0";
			}
		} else {
			if (num1.length() > num2.length()) {
				return "-1";
			} else if (num1.length() < num2.length()) {
				return "1";
			} else {
				for (int i = 1; i < num1.length(); i++) {
					if (num1.charAt(i) > num2.charAt(i)) {
						return "-1";
					} else if (num1.charAt(i) < num2.charAt(i)) {
						return "1";
					}
				}
				return "0";
			}
		}
	}
}
