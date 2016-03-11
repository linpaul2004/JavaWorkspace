import java.text.DecimalFormat;

public class DecimalFormatDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DecimalFormat df = new DecimalFormat("00.000");
		String str = df.format(1.23);
		System.out.println(str);
		DecimalFormat df2 = new DecimalFormat("#0.###");
		String str2 = df2.format(1.23);
		System.out.println(str2);
	}

}
