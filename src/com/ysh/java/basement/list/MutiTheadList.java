package com.ysh.java.basement.list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MutiTheadList {
	static List<String> list = new ArrayList<String>();

	public static void main(String[] args) {
		list.add("a");
		list.add("b");
		list.add("c");
		list.add("d");

		new Thread() {
			public void run() {
				Iterator<String> iterator = list.iterator();
				synchronized (list) {
					while (iterator.hasNext()) {
						System.out.println(Thread.currentThread().getName() + ":" + iterator.next());
						try {
							Thread.sleep(1000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}
			};
		}.start();

		new Thread() {
			public synchronized void run() {
				Iterator<String> iterator = list.iterator();
				synchronized (list) {
					while (iterator.hasNext()) {
						String element = iterator.next();
						System.out.println(Thread.currentThread().getName() + ":" + element);
						if (element.equals("c")) {
							iterator.remove();
						}
					}
				}
			};
		}.start();

	}
}
