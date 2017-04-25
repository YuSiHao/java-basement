package fileIO;

import java.io.IOException;
import java.io.StringReader;

public class MemoryInput {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		StringReader in = new StringReader(BufferedInputFile.read("C:/Users/cyu088/workspace/javaIO/src/fileIO/BufferedInputFile.java"));
		int c ;
		while((c = in.read())!= -1)
			System.out.print((char)c);//read()是以int形式返回下一字节，所以要改成char
	}

}
