package com.ysh.java.basement.math;

public class InsertSort {
	
	public void insertSort() {
		int[] a = { 49, 38, 65, 97, 76, 13 };
		int temp = 0;
		for (int i = 1; i < a.length; i++) { 
			int j = i - 1;
			temp = a[i];
			for (; temp < a[j] && j > 0; j--) {
				a[j + 1] = a[j];
			}
			a[j + 1] = temp;
		}

		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}
	}
	
	public static void main(String[] args) {
		InsertSort insertSort = new InsertSort();
		insertSort.insertSort();
	}
}