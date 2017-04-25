package Steam;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class SteamMap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> stringCollection = new ArrayList<>();
		stringCollection.add("ddd2");
		stringCollection.add("aaa2");
		stringCollection.add("bbb1");
		stringCollection.add("aaa1");
		stringCollection.add("bbb3");
		stringCollection.add("ccc");
		stringCollection.add("bbb2");
		stringCollection.add("ddd1");
		stringCollection//fanga
		.stream()
		.map(String::toUpperCase)
		.sorted((a,b)->b.compareTo(a))
		.forEach(str->System.out.println(str));
		System.out.println("--------------");
		Optional<String> reduced = 
		stringCollection
		.stream()
		.sorted()
		.reduce((s1,s2)->s1+"#"+s2);
		reduced.ifPresent(System.out::println);
	}

}
