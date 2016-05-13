package chapter12;

public class MyThread extends Thread {
	private String name;

	public MyThread(String name) {
		this.name = name;
	}

	public void run() {
		while (true) {
			System.out.println("Helo! I am " + name);
			try {
				Thread.sleep((long) Math.random() * 2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
