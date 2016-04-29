package chapter9;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class ObjectOutputStreamTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Student[] stu = new Student[2];
		stu[0] = new Student("Hacker1", 21);
		stu[1] = new Student("Hacker2", 22);
		try {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("output2.obj"));
			oos.writeInt(123);
			oos.writeObject(stu);
			oos.flush();
			oos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
