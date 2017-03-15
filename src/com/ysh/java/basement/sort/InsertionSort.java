package com.ysh.java.basement.sort;

public class InsertionSort {
	public static void main(String[] args) {
		System.out.println(
				"InsertionSort best time complexity is O(n), worst time complexity is O(n^2), average time complexity is O(n^2)");
		int a[] = { 8, 3, 9, 0, 2, 4, 1, 7, 6 };
		for (int i : a) {
			System.out.println(i);
		}
		for (int i = 1; i < a.length; i++) {
			int tmp = a[i];
			for (int j = i - 1; j >= 0 && a[j] > tmp; j--) {
				a[j + 1] = a[j];
				a[j] = tmp;
			}
		}
		for (int i : a) {
			System.out.println(i);
		}
	}
}
