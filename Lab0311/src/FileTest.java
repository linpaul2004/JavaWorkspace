import java.io.FileInputStream;
import java.util.Scanner;

public class FileTest {
	public static void main(String[] args) {
		try {
			Scanner scanner = new Scanner(new FileInputStream("d:\\test.txt"));
			String name = scanner.nextLine();
			String id = scanner.nextLine();
			String school = scanner.nextLine();
			System.out.println("Name:" + name);
			System.out.println("ID:" + id);
			System.out.println("School:" + school);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
