package chapter5;

public class Duck {
	public boolean canfly = false;

	public void quack() {
		System.out.println("Quack!!");
	}

	public Duck(boolean canfly) {
		this.canfly = canfly;
	}

	public String eat(String food) {
		String message = "Thank you " + food + " is good!";
		return message;
	}

	public void swim(int distance) {
		distance--;
		System.out.println("The distance of my swimming is " + distance);
	}

}
