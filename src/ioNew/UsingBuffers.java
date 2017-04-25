package ioNew;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;

public class UsingBuffers {
	private static void symmetricScramble(CharBuffer buffer){
		while(buffer.hasRemaining()){//limit - position
			buffer.mark();//mark at its position
			char c1 = buffer.get();
			char c2 = buffer.get();
			buffer.reset();
			buffer.put(c2).put(c1);//change the position of c1 and c2
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[] data = "UsingBuffers".toCharArray();
		ByteBuffer bb = ByteBuffer.allocate(data.length*2);
		CharBuffer cb = bb.asCharBuffer();
		cb.put(data);
		System.out.println(cb.rewind());//rewind,position set zero and discard the mark
		symmetricScramble(cb);
		System.out.println(cb.rewind());
		symmetricScramble(cb);
		System.out.println(cb.rewind());
	}

}
