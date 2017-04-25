package xmlToModel;

import java.io.File;
import java.util.ArrayList;

import nu.xom.Builder;
import nu.xom.Document;
import nu.xom.Element;
import nu.xom.Elements;

public class People extends ArrayList<Person>{
	private static final String filePath = "C:/Project/javaProject/test/test.txt";
	public People(String fileName) throws Exception{
		Document doc = new Builder().build((new File(filePath).toURI()).toString());//打开并且读取文件
		System.out.println((new File(filePath).toURI()).toString());
		System.out.println(new File(filePath).getAbsolutePath());
		Elements elements = doc.getRootElement().getChildElements();
		for(int i=0;i<elements.size();i++)
			add(new Person(elements.get(i)));
	}
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		People p = new People(filePath);
		System.out.println(p);
	}

}
