package com.leemani.exercise;

public class InsertSort {
//	정렬된 파일에 삽입할 데이터를 key에 삽입할 데이터의 인덱스를 index 에 넣는다.
//	key 에 저장된 데이터와 이미 정렬된 파일의 마지막 인덱스 위치의 데이터부터 첫번째 위치의 데이터 방향으로
//	비교한다.
//	key 에 저장된 데이터가 이미 정렬된 파일의 데이터 보다 작으면 정렬된 파일의 데이터를 다음 위치로보내고
//	index를 1감소 시킨다.
//	비교 작업 모두 완료된 후 key 에 저장된 데이터를 index 번째 위치에 넣어준다.
	
	public void sort(int [] array) {
	
		for (int i = 1; i < array.length; i++) {
			int key = array[i];
			int index = i;
			for (int j = i-1; j  > -1; j--) {
				if(key < array[j]) {
					array[j+1] = array[j];
					index -= 1;
				}
			}
			array[index] = key;
			for (int j = 0; j < array.length; j++) {
				System.out.print(array[j] + " ");
			}
			System.out.println();
		}
	}
	public static void main(String[] args) {
		int [] a = {8, 3, 4, 9, 1};
		InsertSort insertSort = new InsertSort();
		insertSort.sort(a);
	}
	
}
