package exercise;

public class InsertSort {
	
	public static void main(String[] args) {
		int [] array = {9, 4, 0, 6, 1, 7};
		new InsertSort().sort(array);
	}
	
	
//선택 정렬 한 번 더 하기
	
	public void sort(int [] array) {
		for (int i = 1; i < array.length; i++) {
			int key = array[i];
			int index = i;
			for (int j = i-1; j > -1; j--) {
				if(key < array[j] ) {
					array[j+1] = array[j];
					index --;
				}
				array[index] = key;
			}
			
			for (int j = 0; j < array.length; j++) {
				System.out.print(array[j] + " ");
			}
			System.out.println();
			
		}
		
	}
}
