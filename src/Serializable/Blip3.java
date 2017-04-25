package Serializable;

import java.io.Externalizable;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

public class Blip3 implements Externalizable{//因为Externalizable通过构造函数来恢复对象，所以属性值会被创造对象时清空，需要在readExternal中读进来，这也就是Externalizable局部化的原因
	private static final String filePath = "C:/Project/javaProject/test/test.txt";
	private int i;
	private String s;
	public Blip3(){
		System.out.println("Blip3 Constructor");
	}
	public Blip3(String x,int a){
		s = x;
		i = a;
	}
	public String toString(){
		return s+i;
	}
	public void writeExternal(ObjectOutput out) throws IOException{
		System.out.println("Blip3.writeExternal");
		//must do this
		out.writeObject(s);
		out.writeInt(i);
	}
	public void readExternal(ObjectInput in) throws ClassNotFoundException, IOException{
		System.out.println("Blip3.readExternal");
		//must do this
		s = (String) in.readObject();
		i = in.readInt();
	}
	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		// TODO Auto-generated method stub
		System.out.println("Constructing objects:");
		Blip3 b3 = new Blip3("A String",47);
		System.out.println(b3);
		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filePath));
		System.out.println("saving Objects");
		out.writeObject(b3);
		out.close();
		//Now get them back
		ObjectInputStream in = new ObjectInputStream(new FileInputStream(filePath));
		System.out.println("recover b3");
		b3 = (Blip3) in.readObject();
		System.out.println(b3);
	}

}
