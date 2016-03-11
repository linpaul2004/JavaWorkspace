import java.util.Scanner;

public class ScannerDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		scanner.useDelimiter("##");
		int a = scanner.nextInt();
		int b = scanner.nextInt();
		System.out.println(a + "\n" + b);
	}

}
