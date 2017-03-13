package com.ysh.java.basement.thread;

public class Singleton {

	private static Singleton instance;
	private Singleton() {
	}

	public static Singleton getInstance() {
		if (instance == null) {
			System.out.println(instance);
			instance = new Singleton();
		}
		return instance;
	}
	
	public void run(){
		System.out.println(Thread.currentThread().getName()+"hello world");
		Singleton st = getInstance();
		System.out.println("st:"+st);
	}
	
	public static void main(String[] args) {

		
	}

}
