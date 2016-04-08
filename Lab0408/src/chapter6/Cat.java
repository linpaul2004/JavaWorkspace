package chapter6;

public class Cat {

	int age = 1;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Cat cat1 = new Cat();
		Cat cat2 = cat1;
		cat1.age = 2;
		System.out.println(cat2.age);
	}

}
