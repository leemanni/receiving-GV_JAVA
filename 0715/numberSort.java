import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class numberSort {
// 숫자 배열을 정렬하기 예를들어 홀짝 순으로 정렬하고
//	홀수는 오름차순 짝수는 내림 차순으로 정렬하기
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		ArrayList<Integer> oddNumber = new ArrayList<Integer>();
		ArrayList<Integer> notOddNumber = new ArrayList<Integer>();
		while (true) {
			System.out.print("배열에 넣을 정수를 입력하세요 : ");
			int inputNumber = scanner.nextInt();
			scanner.nextLine(); // 엔터 버퍼 방지용
			if (inputNumber == 999) {
				break;
			}
			if (inputNumber % 2 == 0) {
				oddNumber.add(inputNumber);
			} else {
				notOddNumber.add(inputNumber);
			}
		}
		notOddNumber.sort(Comparator.naturalOrder());
		oddNumber.sort(Comparator.reverseOrder());
		int index = 1;
		for (int i = 0; i < oddNumber.size(); i ++ ) {
			if(index >= notOddNumber.size()) {
				notOddNumber.add(oddNumber.get(i));
			}else {
				notOddNumber.add(index, oddNumber.get(i));
			}
			index+=2;

		}
		System.out.println(notOddNumber);
	}
}
