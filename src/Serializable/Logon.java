package Serializable;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Date;
import java.util.concurrent.TimeUnit;


public class Logon implements Serializable{
	private static final String filePath = "C:/Project/javaProject/test/test.txt";
	private Date date = new Date();
	private String username;
	private transient String password;//transient关闭字段的序列化，保存用户信息，但是一些敏感的信息比如说密码就不保存恢复了
	public Logon(String name, String pwd){
		username = name;
		password = pwd;
	}
	public String toString(){
		return "login info:\n username"+username+"\n date :"+date+"\n password:"+password;
	}
	public static void main(String[] args) throws Exception{
		Logon a = new Logon("Hulk", "myLittlePony");
		System.out.println("logon a =" + a);
		ObjectOutputStream o = new ObjectOutputStream(new FileOutputStream(filePath));
		o.writeObject(a);
		o.close();
		TimeUnit.SECONDS.sleep(1);//Delay
		//now get back
		ObjectInputStream in = new ObjectInputStream(new FileInputStream(filePath));
		System.out.println("Recovering object at"+new Date());
		a = (Logon) in.readObject();
		System.out.println("logon a = "+a);
	}
}
