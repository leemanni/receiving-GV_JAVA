package remind0707;

import java.util.Scanner;

public class Euclid_pTOj {
// 유클리드 호재법으로 최대공약수, 최대 공배수 계산
//	숫자 2개를 입력받는다
//	큰수를 작은수를 나눠 떨어지면 작은수가 최대 공약수가되고
//	나눠 떨어지지 않으면 큰수를 기억하던 기억장소에 작은수를 넣어주고
//	작은 수를 기억하던 기억장소에 나머지를 넣어준 후 작업을 반복한다
//	최대 공약수가 계산되면 입력받은 숫자 2개를 곱한 결과를 최대공약수로
//	나눠주면 최소 공배수를 얻을 수 있더,

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("숫자 2개를 입력하세요 : ");
		int leftNum = scanner.nextInt();
		int rightNum = scanner.nextInt();
		int bigNum = 0;
		int smallNum = 0;

		if (leftNum > rightNum) {
			bigNum = leftNum;
			smallNum = rightNum;
		} else {
			bigNum = rightNum;
			smallNum = leftNum;
		}

		while (true) {
			int r = bigNum % smallNum;
			if (r == 0) {
				break;
			}else {
				bigNum = smallNum;
				smallNum = r;
			}
		}
		
		System.out.println("최대 공약수 :" + smallNum);
		System.out.println("최소 공배수 :" + (rightNum * leftNum / smallNum));

	}
}
