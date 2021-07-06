package remind0706;

public class InsertrionSort0706 {
	public static void main(String[] args) {
		int[] data = { 8, 3, 4, 9, 1 };
		for (int i = 1; i < data.length; i++) {
			int key = data[i];
			int index = i;
			
			for (int j = i - 1; j > -1; j--) {
				if (key < data[j]) {
					data[j+1] = data[j];
					index --;
				}
				else {
					break;
				}

			}
			data[index] = key;
		}

		for (int i = 0; i < data.length; i++) {
			if (i > 0) {
				System.out.print(" => ");
			}
			System.out.print(data[i]);
		}

	}
}
