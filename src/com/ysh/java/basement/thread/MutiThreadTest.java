package com.ysh.java.basement.thread;

public class MutiThreadTest extends Thread {
	@Override

	public void run() {
		System.out.println(Thread.currentThread().getName()+"hello world");
		Singleton st = Singleton.getInstance();
		System.out.println("st:"+st);
	}

	public static void main(String[] args) {

		MutiThreadTest t1 = new MutiThreadTest();
		MutiThreadTest t2 = new MutiThreadTest();
		MutiThreadTest t3 = new MutiThreadTest();
		MutiThreadTest t4 = new MutiThreadTest();
		t1.start();
		t2.start();
		t3.start();
		t4.start();
	}
}
