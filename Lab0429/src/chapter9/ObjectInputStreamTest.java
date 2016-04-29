package chapter9;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class ObjectInputStreamTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream("output2.obj"));
			int num = ois.readInt();
			System.out.println("num=" + num);
			Student[] stu = (Student[]) ois.readObject();
			System.out.println("Student1 name=" + stu[0].getName());
			System.out.println("Student1 age=" + stu[0].getAge());
			System.out.println("Student2 name=" + stu[1].getName());
			System.out.println("Student2 age=" + stu[1].getAge());
			ois.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
