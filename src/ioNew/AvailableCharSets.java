package ioNew;

import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.SortedMap;

public class AvailableCharSets {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SortedMap<String, Charset> charSets = Charset.availableCharsets();
		Iterator<String> it = charSets.keySet().iterator();
		while(it.hasNext()){
			String csName = it.next();
			System.out.println(csName);
			Iterator aliases = charSets.get(csName).aliases().iterator();//aliases()将Charset转换为set<String>
			if(aliases.hasNext())
				System.out.println(":");
			while(aliases.hasNext()){
				System.out.println(aliases.hasNext());
				if(aliases.hasNext())
					System.out.println(",");
			}
			System.out.println();
		}
	}

}
