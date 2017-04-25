package Serializable;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Random;

	class Data implements Serializable{
		private int n;
		public Data(int n){
			this.n = n;
		}
		public String toString(){
			return Integer.toString(n);
		}
	}
	
	public class Worm implements Serializable{//对象序列化，能追踪对象内所包含的所有引用，并保存那些对象
		private static final String filePath = "C:/Project/javaProject/test/test.txt";
		private static Random rand = new Random(47);
		private Data[] d = {
				new Data(rand.nextInt(10)),
				new Data(rand.nextInt(10)),
				new Data(rand.nextInt(10))
		};
		private Worm next;
		private char c;
		public Worm(int i,char x){
			System.out.println("Worm constructor:"+i);
			c = x;
			if(--i>0)
				next = new Worm(i, (char)(x+1));
		}
		public Worm(){
			System.out.println("Default constructor");
		}
		public String toString(){
			StringBuilder result = new StringBuilder(":");
			result.append(c);
			result.append("(");
			for(Data dat:d)
				result.append(dat);
			if(next!=null)
				result.append(next);//每个对象的属性Data[] d不一样，并且因为序列化没有被回收掉，所以都保留下来了
			return result.toString();
		}
		
		public static void main(String[] args) throws ClassNotFoundException,IOException{
			// TODO Auto-generated method stub
			Worm w = new Worm(6,'a');
			System.out.println("w="+w);
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filePath));//写入到文件
			out.writeObject("Worm storage\n");
			out.writeObject(w);
			out.close();
			ObjectInputStream in = new ObjectInputStream(new FileInputStream(filePath));
			String s = (String) in.readObject();
			Worm w2 = (Worm) in.readObject();
			System.out.println(s+"w2 = "+w2);
			ByteArrayOutputStream bout = new ByteArrayOutputStream();//写入到数组
			ObjectOutputStream out2 = new ObjectOutputStream(bout);
			out2.writeObject("Worm storage\n");
			out2.writeObject(w);
			out2.flush();
			ObjectInputStream in2 = new ObjectInputStream(new ByteArrayInputStream(bout.toByteArray()));
			s = (String) in2.readObject();
			Worm w3 = (Worm) in2.readObject();
			System.out.println(s +"w3 = "+w3);
		}
	}
		
		
	
	
	


