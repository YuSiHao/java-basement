package Serializable;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class SerialCtl implements Serializable{
	private String a;
	private transient String b;
	public SerialCtl(String aa, String bb){
		a = "Not Transient:"+aa;
		b = "Transient:"+bb;
	}
	public String toString(){
		return a + "\n" + b;
	}
	private void writeObject(ObjectOutputStream stream) throws IOException{
		stream.defaultWriteObject();//Not Transient走这个方法
		stream.writeObject(b);//Transient走这个方法
	}
	private void readObject(ObjectInputStream stream) throws IOException,ClassNotFoundException{
		stream.defaultReadObject();
		b = (String) stream.readObject();
	}
	public static void main(String[] args) throws IOException,ClassNotFoundException{
		// TODO Auto-generated method stub
		SerialCtl sc = new SerialCtl("Test1", "Test2");
		System.out.println("Bofore :\n"+sc);
		ByteArrayOutputStream buf = new ByteArrayOutputStream();
		ObjectOutputStream o = new ObjectOutputStream(buf);
		o.writeObject(sc);
		//now get it back
		ObjectInputStream in = new ObjectInputStream(new ByteArrayInputStream(buf.toByteArray()));
		SerialCtl sc2 = (SerialCtl) in.readObject();
		System.out.println("After:\n"+sc2);
	}

}
