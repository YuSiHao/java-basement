package Steam;

import java.util.ArrayList;
import java.util.List;

public class TestParallel {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 System.out.println("Creating list");
		    List<String> strings = new ArrayList<>();
		    for (int i = 0; i < 100000; i++) {
		        strings.add("Item " + i);
		    }
		    strings.stream()
		    		.parallel()
		           .forEach(str -> System.out.println(str));
		    long count = strings.stream().count();
	        System.out.println("Count: " + count);
	        List<Person> people = new ArrayList<>();
	        people.add(new Person("Mohamed", 69));
	        people.add(new Person("Doaa", 25));
	        people.add(new Person("Malik", 6));
	        int sum = people.stream()
	                  .mapToInt(p -> p.getAge())
	                  .sum();
	        System.out.println("Total of ages " + sum);
	}

}
