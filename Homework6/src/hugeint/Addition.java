package hugeint;

public class Addition implements IOperation {
	public String perform(String num1, String num2) {
		StringBuilder buf = new StringBuilder();
		byte carry = 0;
		int i, j;
		for (i = num1.length() - 1, j = num2.length() - 1, carry = 0; i >= 0 || j >= 0 || carry != 0; i--, j--) {
			byte dig1 = i < 0 ? 0 : Byte.parseByte(num1.substring(i, i + 1));
			byte dig2 = j < 0 ? 0 : Byte.parseByte(num2.substring(j, j + 1));
			byte digit = (byte) (dig1 + dig2 + carry);
			if (digit > 9) {
				carry = 1;
				digit -= 10;
			} else {
				carry = 0;
			}
			buf.append(digit);
		}
		return buf.reverse().toString();
	}
}
