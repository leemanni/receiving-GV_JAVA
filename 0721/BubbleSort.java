package com.leemani.exercise;

// 버블정렬하는 프로그램 만들기-7월 21일
public class BubbleSort {
	
	public void sort(int [] array) {
		for (int i = 0; i < array.length-1; i++) {
			boolean flag = true;
			for (int j = 0; j < array.length-1; j++) {
				if(array[j+1] < array[j]) {
					int temp = array[j+1];
					array[j+1] = array[j];
					array[j] = temp;
					flag = false;
				}
			}
			if(flag) {
				break;
			}
			for (int j = 0; j < array.length; j++) {
				System.out.print(array[j] + "  ");
			}
			System.out.println();
			
		}
		
	}
	public static void main(String[] args) {
		int [] a = {8, 3, 4, 1, 9};
		
		BubbleSort bubbleSort = new BubbleSort();
		bubbleSort.sort(a);
	}
	
	
}
