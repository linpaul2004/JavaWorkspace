package inClass;

public class SelectionStatements {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int number = 24;
		if (number % 2 == 0) {
			System.out.println("The condition evaluated to true!");
		} else {
			System.out.println("The condition evaluated to false!");
		}
		int grade1 = 65, grade2 = 50;
		System.out.println(grade1 >= 60 ? "Passed!" : "Failed!");
		System.out.println(grade2 >= 60 ? "Passed!" : "Failed!");
		String a = new String("Java");
		String b = new String("Java");
		if (a == b) {
			System.out.println("a==b");
		}
		if (a.equals(b)) {
			System.out.println("a equals to b");
		}
	}

}
