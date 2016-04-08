package homework;

import java.util.Scanner;

public class Homework5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner keyboard = new Scanner(System.in);
		Document doc;
		char mode;
		String documentType;
		mode = keyboard.nextLine().charAt(0);
		documentType = keyboard.nextLine();
		if (documentType.equals("Document")) {
			doc = new Document();
			doc.setText(keyboard.nextLine());
		} else if (documentType.equals("Email")) {
			doc = new Email();
			((Email) doc).setSender(keyboard.nextLine());
			((Email) doc).setRecipient(keyboard.nextLine());
			((Email) doc).setTitle(keyboard.nextLine());
			doc.setText(keyboard.nextLine());
		} else {
			doc = new File();
			((File) doc).setPathname(keyboard.nextLine());
			doc.setText(keyboard.nextLine());
		}
		if (mode == 'A') {
			System.out.println(doc.toString());
		} else if (mode == 'B') {
			System.out.println(doc.toString().contains(keyboard.nextLine()));
		} else {
			String modifyVariable = keyboard.nextLine();
			if (modifyVariable.equals("text")) {
				doc.setText(keyboard.nextLine());
			} else if (modifyVariable.equals("sender")) {
				((Email) doc).setSender(keyboard.nextLine());
			} else if (modifyVariable.equals("recipient")) {
				((Email) doc).setRecipient(keyboard.nextLine());
			} else if (modifyVariable.equals("title")) {
				((Email) doc).setTitle(keyboard.nextLine());
			} else {
				((File) doc).setPathname(keyboard.nextLine());
			}
			System.out.println(doc.toString());
		}
		keyboard.close();
	}

}
