package ioNew;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;


public class GetChannel {
	private static final String filePath = "C:/Project/javaProject/test/test.txt";
	private static final int BSIZE = 1024;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		//write the file
		FileChannel fc = new FileOutputStream(filePath).getChannel();
		fc.write(ByteBuffer.wrap("some text".getBytes()));
		fc.close();
		//add to the end of the file
		fc = new RandomAccessFile(filePath, "rw").getChannel();
		fc.position(fc.size());
		fc.write(ByteBuffer.wrap("some more".getBytes()));
		fc.close();
		//read the file
		fc= new FileInputStream(filePath).getChannel();
		ByteBuffer buff = ByteBuffer.allocate(BSIZE);//设置缓存的容量
		fc.read(buff);//告知FileChannel向ByteBuffer存储字节
		buff.flip();//让ByteBuffer（缓存）做好让别人读取的准备
		while(buff.hasRemaining())
			System.out.println((char)buff.get());
	
	}
}
