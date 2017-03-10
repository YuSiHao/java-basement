package com.ysh.java.basement.thread;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadDemo implements Runnable {
	String name;
	//	static Integer tickets = 20;
	private static AtomicInteger tickets = new AtomicInteger(20);

	public ThreadDemo(String name) {
		this.name = name;
	}

	public void run() {
		for (int i = 1; i <= 20; i++) {
			synchronized (tickets) {
				if (tickets.get() > 0) {
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
					}
					System.out.println("我取票第" + ": " + tickets.getAndDecrement() + " 张票。");
					//					tickets--;
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
					}
					System.out.println("==========现在查询还剩" + ": " + tickets.get() + " 张票。");
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		ThreadDemo demo = new ThreadDemo("hello");
		new Thread(demo).start();
		new Thread(demo).start();
		new Thread(demo).start();
	}
}