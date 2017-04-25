package xmlToModel;

import java.io.StringReader;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.junit.Test;

public class TestJaxb {

	@Test
	 public void beanToXML(){
		 Classroom classroom = new Classroom(1, "软件工程", 4);  
	     Student student = new Student(101, "张三", 22, classroom);
	     try {
			JAXBContext context = JAXBContext.newInstance(Student.class);//通过student类来装成特定的JAXBContext
			Marshaller marshaller = context.createMarshaller();//JAXBContext来生成Marshaller
			marshaller.marshal(student, System.out);//把student实例对象装进来，outputstream用System.out输入到里面
			System.out.println(marshaller);
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	     
	 }
	
	@Test
	public void XMLtoBean(){
		String xmlStr = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>"
								+ "<student>"
									+ "<age>22</age>"
									+ "<classroom>"
										+ "<grade>4</grade><id>1</id><name>软件工程</name>"
									+ "</classroom>"
									+ "<id>101</id>"
									+ "<name>张三</name>"
								+ "</student>";
		JAXBContext context;
		try {
			context = JAXBContext.newInstance(Student.class);
			Unmarshaller unmarshaller = context.createUnmarshaller(); 
			 Student student = (Student)unmarshaller.unmarshal(new StringReader(xmlStr));  
	         System.out.println(student.getAge());  
	         System.out.println(student.getClassroom().getName()); 
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		
	}
	
}
