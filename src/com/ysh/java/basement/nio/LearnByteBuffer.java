package com.ysh.java.basement.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class LearnByteBuffer {

	public static void main(String[] args) throws Exception {
		ByteBuffer buffer = ByteBuffer.allocate(512);
		System.out.println("buffer:" + buffer);
		byte[] testByte = { 'a', 'b', 'c' };
		buffer.put(testByte);
		System.out.println("afterWriteBuffer:" + buffer);
		buffer.flip();
		buffer.position(1);
		System.out.println("flip:" + buffer);
		// buffer.clear();
		// System.out.println("cleanBuffer:" + buffer);
		FileChannel fc1 = new FileInputStream("C:/Users/cyu088/git/java-basement/test.txt").getChannel();
		fc1.read(buffer);
		System.out.println(buffer.get(0));
		System.out.println(buffer);
		System.out.println("afterFlipBuffer:" + buffer);
		String sendString = "hello world";
		ByteBuffer sendBuffer = ByteBuffer.wrap(sendString.getBytes("UTF-16"));
		System.out.println("sendBuffer:" + sendBuffer);
		FileChannel fc = new FileOutputStream("C:/Users/cyu088/git/java-basement/test.txt").getChannel();
		fc.write(sendBuffer);
		System.out.println("afterSendBuffer:" + sendBuffer);
	}

}
