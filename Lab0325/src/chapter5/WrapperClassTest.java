package chapter5;

public class WrapperClassTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int k = 100;
		Integer it1 = new Integer(k);
		int m = it1.intValue();
		System.out.println(m * k);
		Integer it2 = new Integer(100);
		System.out.println(it2);
		double pi = Double.parseDouble("3.14");
		System.out.println(pi);
		Double d = new Double("1.5");
		String str = d.toString();
		System.out.println(str);
	}

}
