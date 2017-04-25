package Lambda;

import java.util.Arrays;
import java.util.List;

public class MapAndReduce {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> costBeforeTax = Arrays.asList(100, 200, 300, 400, 500);  
		for (Integer cost : costBeforeTax) {  
		    double price = cost + .12*cost;  
		    System.out.println(price);  
		}   
		// With Lambda expression:  
		List<Integer> costBeforeTax1 = Arrays.asList(100, 200, 300, 400, 500);  
		costBeforeTax1.stream().map((cost) -> cost + .12*cost).forEach(System.out::println); //传递一个Lambda表达式给map方法使之应用于每个元素，之后在用forEach打印结果
		// Old way: 
		double total = 0;  
		for (Integer cost : costBeforeTax) {  
		    double price = cost + .12*cost;  
		    total = total + price;  
		}  
		System.out.println("total1:"+total);
		// New way: 
		//map()方法：若这个回调函数有返回值，map()方法会产生一个新数组，
		//这个新数组由原数组元素对应的回调函数的返回值构成。若没有返回值，则新数组的所有元素为undefined。
		//forEach方法：仅仅为每个数组元素执行回调函数。
		double bill = costBeforeTax1.stream().map((cost) -> cost + .12*cost).reduce((sum, cost) -> sum  //reduce函数，可以接受一个Lambda表达式然后组合所有值
				+ cost).get();  
				System.out.println("Total : " + bill);  
	}

}
