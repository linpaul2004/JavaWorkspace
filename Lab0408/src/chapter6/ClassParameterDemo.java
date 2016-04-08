package chapter6;

public class ClassParameterDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ToyClass anObject = new ToyClass("Robot Dog", 10);
		System.out.println(anObject);
		changer(anObject);
		System.out.println(anObject);
	}

	public static void changer(ToyClass aParameter) {
		aParameter.set("Robot Cat", 20);
	}

}
