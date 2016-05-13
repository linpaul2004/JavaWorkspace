package chapter12;

public class Racer extends Thread {
	public void run() {
		RaceConditionTest.increase();
	}
}
