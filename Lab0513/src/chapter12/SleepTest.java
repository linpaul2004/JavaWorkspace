package chapter12;

public class SleepTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Sleep for 3 seconds...");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Wake up");
	}

}
