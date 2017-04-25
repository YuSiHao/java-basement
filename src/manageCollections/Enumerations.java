package manageCollections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Vector;

public class Enumerations {//like Iterator

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Countries countries = new Countries();
		
		Vector<String> vector = new Vector<String>(countries.getNames());
		Enumeration<String> enumeration = vector.elements();
		while (enumeration.hasMoreElements()) 
			System.out.println(enumeration.nextElement()+",");
		enumeration = Collections.enumeration(new ArrayList<String>());
		
	}

}
