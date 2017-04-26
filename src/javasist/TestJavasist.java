package javasist;

import javassist.ClassPool;
import javassist.CtClass;

public class TestJavasist {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		ClassPool pool = ClassPool.getDefault();
		CtClass cc = pool.get("javasist.TestClass");
		cc.setSuperclass(pool.get("javasist.TestFatherClass"));
		cc.writeFile();
		byte[] b = cc.toBytecode();
		Class clazz = cc.toClass();
		CtClass newClass = pool.makeClass("JavasistMake");
		newClass.writeFile();
		System.out.println("make class success");
	}

}
