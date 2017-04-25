package ioNew;

import java.nio.ByteBuffer;

public class GetData {
	private static final int BSIZE = 1024;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ByteBuffer bb = ByteBuffer.allocate(BSIZE);
		int i = 0;
		while(i++<bb.limit())
			if(bb.get()!= 0)
				System.out.println("nonzero");
		System.out.println("i="+i);
		bb.rewind();//返回数据开始的地方
		//store and read a char array
		bb.asCharBuffer().put("Howdy!");
		char c ;
		while((c=bb.getChar()) != 0)
			System.out.println(c+"");
		bb.rewind();
		//store and read a short
		bb.asShortBuffer().put((short) 471142);
		System.out.println(bb.getShort());
		bb.rewind();
		//store and read an int
		bb.asIntBuffer().put(99471142);
		System.out.println(bb.getInt());
		bb.rewind();
		
	}

}
