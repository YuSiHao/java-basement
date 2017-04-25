package ioNew;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;

public class BufferToText {
	private static final int BSIZE = 1024;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		// write the file
		FileChannel fc = new FileOutputStream("C:/Project/javaProject/test/test.txt").getChannel();
		fc.write(ByteBuffer.wrap("some text".getBytes()));
		fc.close();
		// read the file
		fc = new FileInputStream("C:/Project/javaProject/test/test.txt").getChannel();
		ByteBuffer buff = ByteBuffer.allocate(BSIZE);// 设置缓存的容量
		fc.read(buff);// 告知FileChannel向ByteBuffer存储字节
		buff.flip();// 让ByteBuffer（缓存）做好让别人读取的准备
		//does not work
		System.out.println(buff.asCharBuffer());//字节转字符输出
		//Decode using the system's default Charset
		buff.rewind();//修改
		String encoding = System.getProperty("file.encoding");
		System.out.println("Decoded using"+encoding+":"+Charset.forName(encoding).decode(buff));//输出时进行解码
		//encode with something that will print
		fc = new FileOutputStream("C:/Project/javaProject/test/test.txt").getChannel();
		fc.write(ByteBuffer.wrap("what fuck".getBytes("UTF-16BE")));//输入时进行编码
		fc.close();
		//now try read again
		fc = new FileInputStream("C:/Project/javaProject/test/test.txt").getChannel();
		buff.clear();
		fc.read(buff);
		buff.flip();
		System.out.println(buff.asCharBuffer());
		//use a CharBuffer to write through
		fc = new FileOutputStream("C:/Project/javaProject/test/test.txt").getChannel();
		buff = ByteBuffer.allocate(24);
		buff.asCharBuffer().put("some text1");
		fc.write(buff);
		fc.close();
		//read and display
		fc = new FileInputStream("C:/Project/javaProject/test/test.txt").getChannel();
		buff.clear();
		fc.read(buff);
		buff.flip();
		System.out.println(buff.asCharBuffer());
		
	}

}
