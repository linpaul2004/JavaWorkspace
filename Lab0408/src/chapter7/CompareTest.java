package chapter7;

import java.util.Date;

public class CompareTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Employee employeeA = new Employee("Josephine", new Date(114, 0, 1));
		Employee employeeB = new Employee("Josephine", new Date(114, 0, 1));
		System.out.println(employeeA.equals(employeeB));
		System.out.println(employeeA == employeeB);
		if (employeeA instanceof Employee) {
			System.out.println(employeeA.getName() + "is an object of Employee");
		}
		System.out.println(employeeA.getClass().getName());
	}

}
