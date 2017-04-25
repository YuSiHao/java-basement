package manageCollections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Synchronization {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Collection<String> c = Collections.synchronizedCollection(new ArrayList<String>());//同步成ArrayList
		c.add("fuck");
		System.out.println(c);
	}

}
