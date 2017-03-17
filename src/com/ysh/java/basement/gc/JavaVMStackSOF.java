package com.ysh.java.basement.gc;

public class JavaVMStackSOF {//-verbose:gc -Xss128k 
	//Xss:stackDeep size

	private int stackDeep = 1;

	public void stackLeak() {
		stackDeep++;
		stackLeak();
	}

	public static void main(String[] args) throws Throwable {
		JavaVMStackSOF oom = new JavaVMStackSOF();
		try {
			oom.stackLeak();
		} catch (Throwable e) {
			System.out.println("stack deep is : " + oom.stackDeep);
			throw e;
		}
	}

}
