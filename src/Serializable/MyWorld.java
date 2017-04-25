package Serializable;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

class House implements Serializable{}

class Animal implements Serializable{
	private String name;
	private House perferRedHourse;
	Animal(String nm, House h){
		name = nm;
		perferRedHourse = h;
	}
	public String toString(){
		return name + "[" + super.toString() + "]," + perferRedHourse + "\n";
	}
}

public class MyWorld {
	public static void main(String[] args) throws IOException,ClassNotFoundException{
		// TODO Auto-generated method stub
		House hourse = new House();
		List<Animal> animals = new ArrayList<Animal>();
		animals.add(new Animal("Bosco the dog", hourse));
		animals.add(new Animal("Ralph the hamster", hourse));
		animals.add(new Animal("Molly the cat", hourse));
		System.out.println("animals:"+animals);
		ByteArrayOutputStream buf1 = new ByteArrayOutputStream();
		ObjectOutputStream o1 = new ObjectOutputStream(buf1);
		o1.writeObject(animals);
		o1.writeObject(animals);//write a 2nd set,序列化到相同的内存地址
		//write to a different system
		ByteArrayOutputStream buf2 = new ByteArrayOutputStream();
		ObjectOutputStream o2 = new ObjectOutputStream(buf2);
		o2.writeObject(animals);//序列化到不同的内存地址
		//now get them back
		ObjectInputStream in1 = new ObjectInputStream(new ByteArrayInputStream(buf1.toByteArray()));
		ObjectInputStream in2 = new ObjectInputStream(new ByteArrayInputStream(buf2.toByteArray()));
		List animals1 = (List) in1.readObject();
		List animals2 = (List) in1.readObject();
		List animals3 = (List) in2.readObject();
		System.out.println("animals1:"+animals1);
		System.out.println("animals2:"+animals2);
		System.out.println("animals3:"+animals3);
	}

}
