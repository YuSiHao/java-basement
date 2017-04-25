package Serializable;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class ThawAlien {
	private static final String filePath = "C:/Project/javaProject/test/test.txt";
	
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		ObjectInputStream in = new ObjectInputStream(new FileInputStream(filePath));
		Object mystery = in.readObject();
		System.out.println(mystery.getClass());
	}
}
