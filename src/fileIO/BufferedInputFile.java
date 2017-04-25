package fileIO;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BufferedInputFile {
	public static String read(String filename) throws IOException{
		BufferedReader in = new BufferedReader(new FileReader(filename));
		String s;
		StringBuilder sBuilder = new StringBuilder();
		while((s = in.readLine())!=null)
			sBuilder.append(s + "\n");
			in.close();
			return sBuilder.toString();
		
	}
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		System.out.println(read("C:/Users/cyu088/workspace/javaIO/src/fileIO/BufferedInputFile.java"));
	}

}
