package chapter7;

import java.util.Date;

public class Company {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HourlyEmployee hourlyEmployee = new HourlyEmployee("Josephine", new Date(114, 0, 1), 100);
		System.out.println(hourlyEmployee.getName());
		Employee someEmploy = hourlyEmployee;
		printHireDate(someEmploy);
	}

	public static void printHireDate(Employee someEmploy) {
		System.out.println(someEmploy.getHireDate());
	}

}
