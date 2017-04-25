package ioNew;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

public class LargeMappedFiles {
	static int length = 0x8FFFFFF;// 128MB
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		//因为文件非常大，对于这个文件的创建和修改不能放到内存上去运行，所以通过这个方法（内存映射文件），一种特殊类型的直接缓冲器，就可以假定整个文件都在内存当中，
		//将文件当成非常大的byte数组来访问
		MappedByteBuffer out = new RandomAccessFile("C:/Project/javaProject/test/test.txt", "rw")
								.getChannel()
									.map(FileChannel.MapMode.READ_WRITE, 0, length);//指定映射文件的初始位置和映射宽度，就是map做的事
		for(int i=0; i<length ;i++)
			out.put((byte) 'x');//将byte类型的x放入byteBuffer
		System.out.println("Finish writing");
		for(int i = length/2; i<length/2 + 6 ; i ++)
			System.out.print((char)out.get(i));
	}

}
