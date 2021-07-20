package exercise;

import java.util.ArrayList;
import java.util.Scanner;

public class Soinsoo {
	// 소인수 분해 후 소인수 분해 결과를 출력하는 프로그램
	/*
	 * <출력예시> 입력 132 ==> 출력 : 2 * 2 * 3 * 11 입력 20 ==> 출력 : 2 * 2 * 5
	 * 
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (true) {
			int remN = 0;
			ArrayList<Integer> ar = new ArrayList<Integer>();
			System.out.println("숫자를 입력하세요 : ");
			int number = scanner.nextInt();
			remN = number;
			scanner.nextLine(); // 키보드 버퍼 없애기
			int c = 0; // 소인수 게산 처리를 위한 변수

			if (number < 2) {
				break;
			}

			while (true) {
				int k = 2; // 나누어 주는 수
				while (true) {
					if (number % k == 0) {
						break;
					}
					k++;
				}
				c += 1;
				ar.add(k);
				number /= k;
				
				if(number ==1 ) {
					break;
				}


			}
			System.out.print(remN+ "==> ");
			if (c == 1) {
				System.out.print("소수 \n");
			} else {
				for (int i = 0; i < ar.size() - 1; i++) {
					System.out.print(ar.get(i) + " * ");
				}
				System.out.println(ar.get(ar.size() - 1));
			}

		}

	}
}
