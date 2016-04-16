package hugeint;

public class Subtraction implements IOperation {
	public String perform(String num1, String num2) {
		StringBuilder buf = new StringBuilder();
		int i, j;
		byte carry = 0;
		String neg = "", a, b;
		IOperation check = new Comparison();
		String compare = check.perform(num1, num2);
		if (compare.equals("-1")) {
			neg = "-";
			a = num2;
			b = num1;
		} else if (compare.equals("0")) {
			return "0";
		} else {
			a = num1;
			b = num2;
		}
		for (i = a.length() - 1, j = b.length() - 1, carry = 0; i >= 0 || j >= 0 || carry != 0; i--, j--) {
			byte dig1 = i < 0 ? 0 : Byte.parseByte(a.substring(i, i + 1));
			byte dig2 = j < 0 ? 0 : Byte.parseByte(b.substring(j, j + 1));
			byte digit = (byte) (dig1 - dig2 + carry);
			if (digit < 0) {
				carry = -1;
				digit += 10;
			} else {
				carry = 0;
			}
			buf.append(digit);
		}
		return neg + buf.reverse().toString();
	}
}
