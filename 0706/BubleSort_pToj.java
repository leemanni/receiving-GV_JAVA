package remind0706;

public class BubleSort_pToj {
// 파이썬 떄 배운 버블 정렬을 java 문법으로 만들어 보기
	public static void main(String[] args) {

		int[] data = { 8, 3, 4, 9, 1 };
		System.out.print("정렬 전 = > ");
		sortPrint(data);
		
		
		
		for (int i = 0; i < data.length-1; i++) {
			for (int j = i; j < data.length; j++) {
				if (data[i] > data[j]) {
					int temp = data[i];
					data[i] = data[j];
					data[j] = temp;
				}
			}
		}
		System.out.println();
		System.out.print("정렬 후 = > ");
		sortPrint(data);
		

	}

private static void sortPrint(int[] data) {
	for (int i = 0; i < data.length; i++) {
		if(i >0) {
			System.out.print(" => ");
		}
		System.out.print(data[i]);
	}
}
}
