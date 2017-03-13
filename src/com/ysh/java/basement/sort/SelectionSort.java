package com.ysh.java.basement.sort;

public class SelectionSort {
    public static void main(String[] args) {
    	System.out.println("SelectionSort best time complexity is O(n^2), worst time complexity is O(n^2), average time complexity is O(n^2)");
        int a[] = {8, 3, 9, 0, 2, 4, 1, 7, 6};
        for (int i : a) {
			System.out.println(i);
		}
        for (int i = 0; i < a.length; i++) {
            int min = i;
            for (int j = i + 1; j < a.length; j++) {
                if (a[min] > a[j]) {
                    min = j;
                }

            }
            int tmp = a[i];
            a[i] = a[min];
            a[min] = tmp;
        }
        for (int i : a) {
			System.out.println(i);
		}
    }
}
