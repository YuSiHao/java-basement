package manageCollections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

public class Readonly {
	
	static Collection<String> data = new ArrayList<String>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Countries countries = new Countries();
		data.addAll(countries.getNames());
		Collection<String> c = Collections.unmodifiableCollection(new ArrayList<String>(data));//can not change
		System.out.println("C:"+c);
		//c.add("fuck");mistake,can not add
		//System.out.println("cadd:"+c);
		List<String> a = Collections.unmodifiableList(new ArrayList<String>(data));//can not change
		ListIterator<String> lIt = a.listIterator();
		System.out.println("next:"+lIt.next());//can read
		//lIt.add("fuck");make mistake
		
	}

}
