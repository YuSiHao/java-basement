package com.ysh.java.basement.gc;

public class JavaVMStackOOM {//-verbose:gc -Xms20M -Xmx20M -Xmn10M -Xss2M -XX:-PrintGCDetails -XX:+HeapDumpOnOutOfMemoryError
	//this may not work on windows and may let system down because of windows system
	private void dontStop() {
		while (true) {
		}
	}

	public void stackleakByThread() {
		while (true) {
			Thread thread = new Thread(new Runnable() {
				@Override
				public void run() {
					dontStop();
				}
			});
			thread.start();
		}
	}

	public static void main(String[] args) {
		JavaVMStackOOM oom = new JavaVMStackOOM();
		oom.stackleakByThread();
	}
}
