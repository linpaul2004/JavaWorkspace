package clone;

public class A implements Cloneable {
	int num = 1;
	B b = new B();

	public A(A a) {
		num = a.num;
		b.speed = a.b.speed;
	}

	public A() {
	}

	public Object clone() {
		return new A(this);
	}
}
