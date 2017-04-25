package Lambda;

import java.util.Comparator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class Lambda4 {
	  static int outerStaticNum;
	    int outerNum;
	    void testScopes() {
	        Converter<Integer, String> stringConverter1 = (from) -> {
	            outerNum = 23;
	            return String.valueOf(from);
	        };
	        Converter<Integer, String> stringConverter2 = (from) -> {
	            outerStaticNum = 72;
	            return String.valueOf(from);
	        };
	    }
	    public static void main(String[] args) {
	    	System.out.println(outerStaticNum);//外部无法访问内部的变量
	    	Function<String, Integer> toInteger = Integer::valueOf;//Function 接口有一个参数并且返回一个结果，并附带了一些可以和其他函数组合的默认方法（compose, andThen）
	    	Function<String, String> backToString = toInteger.andThen(String::valueOf);
	    	System.out.println(toInteger.apply("345"));
	    	System.out.println(backToString.apply("345"));
	    	Supplier<Person> personSupplier = Person::new;//Supplier 接口返回一个任意范型的值，和Function接口不同的是该接口没有任何参数
	    	personSupplier.get().setFirstName("fuck");//personSupplier.get()每次运行都会生成一个新的实例
	    	System.out.println("Supplier:"+personSupplier.get().getFirstName());
	    	Consumer<Person> greeter = (p)->System.out.println("hello:"+p.getFirstName());//Consumer 接口表示执行在单个参数上的操作
	    	greeter.accept(new Person("jack","lam"));
	    	Comparator<Person> comparator = (p1,p2)->p1.firstName.compareTo(p2.firstName);
	    	Person p1 = new Person("susan","su");
	    	Person p2 = new Person("jacki","xue");
	    	System.out.println(comparator.compare(p1, p2));
	    	System.out.println(comparator.reversed().compare(p1, p2));
	    }	    
}
