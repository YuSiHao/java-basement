package Serializable;

import java.io.Externalizable;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

	class Blip1 implements Externalizable{//Externalizable对象，所有普通默认构造器都会被调用；Serializable对象完全以它存储的二进制位为基础来构造，不用构造器，
		public Blip1(){
			System.out.println("Blip1 Constructor");
		}
		public void writeExternal(ObjectOutput out) throws IOException{
			System.out.println("Blip1.writeExternal");
		}
		public void readExternal(ObjectInput in) throws ClassNotFoundException{
			System.out.println("Blip1.readExternal");
		}
	}
	
	class Blip2 implements Externalizable{
		Blip2(){
			System.out.println("Blip2 Constructor");
		}
		public void writeExternal(ObjectOutput out) throws IOException{
			System.out.println("Blip2.writeExternal");
		}
		public void readExternal(ObjectInput in) throws ClassNotFoundException{
			System.out.println("Blip2.readExternal");
		}
	}
		
	public class Bilps{
		private static final String filePath = "C:/Project/javaProject/test/test.txt";
		
		public static void main(String[] args) throws IOException,ClassNotFoundException{
			// TODO Auto-generated method stub
			System.out.println("Constructing objects");
			Blip1 b1 = new Blip1();
			Blip2 b2 = new Blip2();
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filePath));
			System.out.println("saving Objects");
			out.writeObject(b1);
			out.writeObject(b2);
			out.close();
			//Now get them back
			ObjectInputStream in = new ObjectInputStream(new FileInputStream(filePath));
			System.out.println("recover b1");
			b1 = (Blip1) in.readObject();
			System.out.println("recover b2");
			b2 = (Blip2) in.readObject();//Blip2的构造器不是public的，恢复时会发生异常
		}
	}


