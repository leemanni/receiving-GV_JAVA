import java.util.ArrayList;
import java.util.Scanner;

public class SquaredCycle {
	/*
	 * 입력으로 어떤 수가 주어집니다. (예시: 12) 이 수의 각 자릿수의 제곱을 각각 구합니다. (예시: 1, 4) 이 수들을 모두 더합니다.
	 * (예시: 5) 한 자리 수가 나오면 그냥 제곱만 하면 됩니다. (예시: 25) 이것을 반복합니다. (예시: 12 - 5 - 25 - 29
	 * ...) 이때, 4처럼 순환하는 경우가 있습니다. (4 - 16 - 37 - 58 - 89 - 145 - 42 - 20 - 4 [무한
	 * 반복]) 여기에서 순환할 때 지나가는 수의 개수를 출력합니다. (4에서는 8개[4, 16, 37, 58, 89, 145, 42, 20])
	 * 100번 계산해도 순환되는 것이 나오지 않으면 '100개 이상'을 출력합니다
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("처음 입력할 수 : ");
		String firstInput = scanner.next();

		// 입력한 문자를 숫자로 기억해주고, 각 자리 수의 제곱들의 합을 저장해주는 변수
		int changeInput = 0;
		// 첫번째 입력한 수를 기억해주는 변수
		int firstInputNum = Integer.parseInt(firstInput);
		// 순환횟수를 기억해주는 변수
		int cntCycle = 0;
		
		ArrayList<Integer> arSqarededCycle = new ArrayList<Integer>();
		
		while (true) {
			for (int i = 0; i < firstInput.length(); i++) {
				changeInput += Math.pow(Integer.parseInt(""+(firstInput.charAt(i))), 2);
			}
			cntCycle ++;
			arSqarededCycle.add(changeInput);
			
			if(firstInputNum==changeInput) {
				System.out.println(arSqarededCycle.size()+"개 " + arSqarededCycle);
				break;
			}else if(cntCycle>100) {
				System.out.println("100번 반복 넘음");
				break;
			}
			
			firstInput = ""+ changeInput;
			changeInput = 0;
		}
		
		
	}
}
