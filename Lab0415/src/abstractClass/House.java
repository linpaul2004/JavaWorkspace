package abstractClass;

public class House {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Animal dog = new Dog();
		Animal cat = new Cat();
		playWith(dog);
		playWith(cat);
		dog.sit();
		cat.sit();
	}

	public static void playWith(Animal animal) {
		animal.run();
	}

}
