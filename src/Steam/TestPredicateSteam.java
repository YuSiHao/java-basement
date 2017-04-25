package Steam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class TestPredicateSteam {
	
	private static void displayPeople(List<Person> people, Predicate<Person> pred) {
	     System.out.println("Selected:");
	     people.forEach(p -> {
	         if (pred.test(p)) {
	             System.out.println(p.getName());
	         }
	     });
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Person> people = new ArrayList<>();
		people.add(new Person("Mohamed", 69));
		people.add(new Person("Doaa", 25));
		people.add(new Person("Malik", 6)); 
		Predicate<Person> pred = (p) -> p.getAge() > 65;
		displayPeople(people, pred);
		System.out.println("--------------------");
		people.stream()
		//.parallel()打开就是并行流
		.filter(pred)//filter取判断条件
		.forEach(p->System.out.println(p.getName()));
		System.out.println("--------------------");
		 Person[] people1 = {new Person("Mohamed", 69),
				 			 new Person("Doaa", 25),
				 			 new Person("Malik", 6)};
		 for (int i = 0; i < people1.length; i++) {
			 System.out.println(people1[i].getInfo());
		 }
		 System.out.println("--------------------");
		 System.out.println("创建数组流的方法");
		//创建数组流的方法
			Stream<Person> stream = Stream.of(people1);//Stream.of() 意思就是传入一个数组，然后将该数组包装在流中
			Stream<Person> stream1 = Arrays.stream(people1);//和上一行的方法效果一样
			stream.forEach(p->System.out.println(p.getInfo()));
			stream1.forEach(p->System.out.println(p.getInfo()));
		System.out.println("--------------------");
		System.out.println("聚合流");
		 System.out.println("Creating list");
		    List<String> strings = new ArrayList<>();
		    for (int i = 0; i < 10000; i++) {
		        strings.add("Item " + i);
		    }
		    strings.stream()
		           .forEach(str -> System.out.println(str));
		    System.out.println("--------------------");
		    strings.stream()
		    .parallel()//并行划分模块，同时进行
	        	.forEach(str -> System.out.println(str));
		}	
}
