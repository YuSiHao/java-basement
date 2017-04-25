package Serializable;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

public class RecoverCADState {
	private static final String filePath = "C:/Project/javaProject/test/test.txt";
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		ObjectInputStream in = new ObjectInputStream(new FileInputStream(filePath));
		List<Class<? extends Shape>> shapeTypes = (List<Class<? extends Shape>>) in.readObject();
				Line.deserialStaticState(in);//这个方法能将static的变量序列化后读出来
			List<Shape> shapes = (List<Shape>) in.readObject();
			System.out.println(shapes);//普通的static序列化后，读出来都是默认构造函数的值，修改的值读不出来
	}

}
