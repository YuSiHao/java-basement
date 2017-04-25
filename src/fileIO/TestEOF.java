package fileIO;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class TestEOF {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		DataInputStream in = new DataInputStream(new BufferedInputStream(new FileInputStream("C:/Users/cyu088/workspace/javaIO/src/fileIO/BufferedInputFile.java")));
		while(in.available()!=0)
			System.out.println((char)in.readByte());
	}

}
