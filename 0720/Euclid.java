package exercise;

public class Euclid {
	// 한 번 더 연습 ==> 7월 20일
	// 유클리드 호재법을 이용한 최대 공약수 최대공배수 구하기
	// 숫자 두개를 받아서 큰수와 작은수를 구분한다
	// 큰수를 작은수로 나눠 떨어지면 작은수가 최대 공약수가 되고
	// 큰수를 작은수로 나눠 떨어지지 않으면 큰수를 기억하던 장소에 작은수를 넣고
	// 작은수를 기억하던 기억작소에 나머지를 넣어준 후 작업을 반복한다.
	// 최대 공약수가 계산되면 입력 받은 숫자 2개를 곱한 결과를 최대 공약수로 나눠주면
	// 최소 공배수를 얻을 수 잇다.
	public static void main(String[] args) {
		Euclid e = new Euclid();
		System.out.println(e.euclid(9, 6));
	}

	public String euclid(int num1, int num2) {
		int big;
		int small;
		if (num1 > num2) {
			big = num1;
			small = num2;
		} else {
			big = num2;
			small = num1;
		}
		int remBig = big;
		int remSmall = small;
		int max = 0;
		int min = 0;
//	큰수와 작은수를 받아서 몫과 나머지로 계산
		while (true) {
			if (big % small == 0) {
				max = small;
				min = remBig * remSmall / max;
				break;
			} else {
				int temp = small;
				small = big % small;
				big = temp;
			}
		}
		return "최대 공약수 =>" + max + ", 최소 공배수 => " + min;
	}

}
