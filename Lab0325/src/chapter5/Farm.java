package chapter5;

public class Farm {
	public static void main(String[] args) {
		Duck duck = new Duck(true);
		boolean canTheDuckFly = duck.getCanfly();
		if (canTheDuckFly == true) {
			System.out.println("The duck can fly");
		}
		duck.quack();
		duck.quack("Ga Ga Ga");
		String food = "humburger";
		System.out.println(duck.eat(food));
		int expectedDistance = 10;
		duck.swim(expectedDistance);
		System.out.println("The distance of my swimming is " + expectedDistance);
	}
}
