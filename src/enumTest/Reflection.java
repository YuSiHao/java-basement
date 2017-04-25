package enumTest;

import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.Set;
import java.util.TreeSet;

import fileIO.OSExecute;

enum Explore{HERE,THERE}

public class Reflection {//values()不是ENUM本身的方法，而是生成enum编译器自己添加在里面的方法
	
	public static Set<String> analyze(Class<?> enumclass){
		System.out.println("--------Analyzing"+enumclass+"------");
		System.out.println("Interfaces");
		for(Type t: enumclass.getGenericInterfaces())
			System.out.println(t);
		System.out.println("Base:"+enumclass.getSuperclass());
		System.out.println("Method:");
		Set<String> methods = new TreeSet<String>();
		for(Method m : enumclass.getMethods())
			methods.add(m.getName());
		System.out.println(methods);
		return methods;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Set<String> exploreMethods = analyze(Explore.class);
		Set<String> enumMethods = analyze(Enum.class);
		System.out.println("Explore.containsAll(Enum)?"+exploreMethods.containsAll(enumMethods));
		System.out.println("Explore.removeAll(Enum):");
		exploreMethods.removeAll(enumMethods);
		System.out.println(exploreMethods);
		//Decompile the code for the enum
		OSExecute.command("javap Explore");
		
	}

}
