package hugeint;

public class Homework6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String input = args[0];
		String[] formula = input.split(" ");
		String result = formula[0];
		IOperation add = new Addition(), sub = new Subtraction(), com = new Comparison();
		for (int i = 1; i < formula.length; i += 2) {
			if (formula[i].equals("+")) {
				if (result.charAt(0) == '-' && formula[i + 1].charAt(0) != '-') {
					result = sub.perform(formula[i + 1], result.substring(1));
				} else if (result.charAt(0) != '-' && formula[i + 1].charAt(0) == '-') {
					result = sub.perform(result, formula[i + 1].substring(1));
				} else if (result.charAt(0) == '-' && formula[i + 1].charAt(0) == '-') {
					result = "-" + add.perform(result.substring(1), formula[i + 1].substring(1));
				} else {
					result = add.perform(result, formula[i + 1]);
				}
			} else if (formula[i].equals("-")) {
				if (result.charAt(0) == '-' && formula[i + 1].charAt(0) != '-') {
					result = "-" + add.perform(result.substring(1), formula[i + 1]);
				} else if (result.charAt(0) != '-' && formula[i + 1].charAt(0) == '-') {
					result = add.perform(result, formula[i + 1].substring(1));
				} else if (result.charAt(0) == '-' && formula[i + 1].charAt(0) == '-') {
					result = sub.perform(formula[i + 1].substring(1), result.substring(1));
				} else {
					result = sub.perform(result, formula[i + 1]);
				}
			} else if (formula[i].equals("<")) {
				result = com.perform(result, formula[i + 1]);
				result = Boolean.toString(result.equals("-1"));
			} else if (formula[i].equals(">")) {
				result = com.perform(result, formula[i + 1]);
				result = Boolean.toString(result.equals("1"));
			} else {
				result = com.perform(result, formula[i + 1]);
				result = Boolean.toString(result.equals("0"));
			}
		}
		System.out.println(result);
	}

}
