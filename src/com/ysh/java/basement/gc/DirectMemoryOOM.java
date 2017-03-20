package com.ysh.java.basement.gc;

import java.lang.reflect.Field;

import sun.misc.Unsafe;

public class DirectMemoryOOM {//-verbose:gc -Xmx20M -XX:MaxDirectMemorySize=10M -XX:-PrintGCDetails -XX:+HeapDumpOnOutOfMemoryError
	
	private static final int _1MB = 1024 * 1024;
	
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		Field unsafeField = sun.misc.Unsafe.class.getDeclaredFields()[0];
		unsafeField.setAccessible(true);
		sun.misc.Unsafe unsafe = (Unsafe) unsafeField.get(null);
		while(true){
			unsafe.allocateMemory(_1MB);
		}
	}

}
