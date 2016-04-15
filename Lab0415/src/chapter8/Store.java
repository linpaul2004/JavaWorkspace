package chapter8;

public class Store {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Payment p1 = new Payment();
		p1.checkout();
		payProcess(p1);
		Payment p2 = new CredictCardPayment();
		p2.checkout();
		payProcess(p2);
	}

	public static void payProcess(Payment p) {
		if (p instanceof CredictCardPayment) {
			((CredictCardPayment) p).sign();
		}
	}

}
