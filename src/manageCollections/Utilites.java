package manageCollections;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class Utilites {
	static List<String> list = Arrays.asList("one two three four five six one".split(" "));
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(list);
		System.out.println("'list' disjoint (Four)?:"+Collections.disjoint(list, Collections.singletonList("Four")));
		System.out.println("max: "+ Collections.max(list));
		System.out.println("min: "+ Collections.min(list));
		System.out.println("max w/ comparator: " + Collections.max(list, String.CASE_INSENSITIVE_ORDER));
		System.out.println(list);
		Collections.reverse(list);
		System.out.println(list);
		System.out.println("\\");
		Collections.rotate(list, 3);
		System.out.println(list);
		System.out.println("Collections.frequery:"+Collections.frequency(list, "one"));//判断出现次数
		System.out.println();
		
	}

}
