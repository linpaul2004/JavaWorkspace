import java.text.NumberFormat;
import java.util.Locale;

public class CurrencyFormatDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Taiwan as location");
		NumberFormat moneyFormater2 = NumberFormat.getCurrencyInstance(Locale.TAIWAN);
		System.out.println(moneyFormater2.format(19.8));
		System.out.println(moneyFormater2.format(19.81111));
		System.out.println(moneyFormater2.format(19.89999));
		System.out.println(moneyFormater2.format(19));
	}

}
