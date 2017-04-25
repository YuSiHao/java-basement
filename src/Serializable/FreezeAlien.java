package Serializable;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class FreezeAlien {
	private static final String filePath = "C:/Project/javaProject/test/test.txt";
	
	public static void main(String[] args) throws FileNotFoundException, IOException {
		// TODO Auto-generated method stub
		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filePath));
		Alien quellek = new Alien();
		out.writeObject(quellek);
	}
}
