package ioNew;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;

public class IntBufferDemo {//不同类型的缓冲器读取时，数据显示的方式也不相同
	private static final int BSIZE = 1024;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ByteBuffer bb = ByteBuffer.allocate(1024);
		IntBuffer ib = bb.asIntBuffer();
		ib.put(new int[]{11,42,47,99,143,811,1016});
		System.out.println(ib.get(3));
		ib.put(3, 1811);
		ib.flip();
		while(ib.hasRemaining()){
			int i = ib.get();
			System.out.println(i);
		}
	}

}
