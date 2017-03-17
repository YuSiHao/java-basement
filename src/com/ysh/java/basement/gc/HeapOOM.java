package com.ysh.java.basement.gc;

import java.util.ArrayList;
import java.util.List;

public class HeapOOM {
	
	static class OOMobject{
		
	}
	//-verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:-PrintGCDetails
	//Xms:Java Heap Min Xmx:Java Heap Max Xmn:Java Heap Young
	public static void main(String[] args) {
		List<OOMobject> list = new ArrayList<>();
		while(true){
			list.add(new OOMobject());
		}
	}

}
