package chapter8;

public class SayHello {
	public String sayHello(String name) {
		return "Hello! " + name;
	}

	public String sayHello(String name, String gender) {
		if (gender.equals("boy")) {
			return "Hello! Mr. " + name;
		} else if (gender.equals("girl")) {
			return "Hello! Miss. " + name;
		} else {
			return "Hello! " + name;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SayHello hello = new SayHello();
		System.out.println(hello.sayHello("S.J."));
		System.out.println(hello.sayHello("S.J.", "boy"));
	}

}
