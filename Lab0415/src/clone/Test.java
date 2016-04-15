package clone;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		A a = new A();
		System.out.println(a.num);
		System.out.println(a.b.speed);
		A clone_a = (A) a.clone();
		System.out.println(clone_a.num);
		System.out.println(clone_a.b.speed);
		clone_a.num = 2;
		clone_a.b.speed = 200;
		System.out.println(a.num);
		System.out.println(a.b.speed);
	}

}
