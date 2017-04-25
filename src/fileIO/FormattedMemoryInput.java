package fileIO;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.IOException;

public class FormattedMemoryInput {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		try {
			DataInputStream inputStream = new DataInputStream(
					new ByteArrayInputStream(
							BufferedInputFile.read(
									"C:/Users/cyu088/workspace/javaIO/src/fileIO/BufferedInputFile.java").getBytes()));
			while(true)
				System.out.println((char)inputStream.readByte());//一次一个字节读取字符，返回值不能用来检测输入是否结束
		} catch (EOFException e) {
			// TODO: handle exception
			System.err.println("end of stream");
		}
	}

}
