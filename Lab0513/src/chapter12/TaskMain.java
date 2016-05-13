package chapter12;

public class TaskMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Thread thread = new Thread(new Task());
		thread.start();
	}

}
