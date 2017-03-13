package com.ysh.java.basement.sort;

public class BubbleSort {
	public static void main(String[] args) {
		System.out.println("SelectionSort best time complexity is O(n), worst time complexity is O(n^2), average time complexity is O(n^2)");
        int a[] = { 8, 3, 9, 0, 2, 4, 1, 7, 6 };
		for (int i : a) {
			System.out.println(i);
		}
		for (int i = 0; i < a.length; ++i) {
			for (int j = 0; j < a.length - 1 - i; ++j) {
				if (a[j] > a[j + 1]) {
					int tmp = a[j];
					a[j] = a[j + 1];
					a[j + 1] = tmp;
				}
			}
		}
		for (int i : a) {
			System.out.println(i);
		}
	}

}