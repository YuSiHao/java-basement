package com.ysh.java.basement.nio;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

public class LearnNio {

	public static void main(String[] args) {
		byte[] params = new byte[10];
		ByteBuf buf = Unpooled.wrappedBuffer(params);
		buf.setBoolean(0, true);
		
	}
}
