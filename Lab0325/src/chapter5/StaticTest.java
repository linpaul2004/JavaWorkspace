package chapter5;

public class StaticTest {

	public static int port = 80;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int sum = add(1, 1);
		System.out.println(sum);
		StaticTest st = new StaticTest();
		sum = st.add2(2, 2);
		System.out.println(sum);
		StaticTest obj1 = new StaticTest();
		StaticTest obj2 = new StaticTest();
		System.out.println(StaticTest.port);
		System.out.println(obj1.port);
		System.out.println(obj2.port);
		StaticTest.port = 1234;
		System.out.println(obj1.port);
		obj2.port = 5678;
		System.out.println(obj1.port);
	}

	public static int add(int a, int b) {
		return a + b;
	}

	public int add2(int a, int b) {
		return a + b;
	}

}
