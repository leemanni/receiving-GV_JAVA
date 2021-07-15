import java.util.Scanner;

public class SpiralArray {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("행 열의 크기 ==>");
		int run = scanner.nextInt();
		
		int x = 0; //행
		int y = -1; // 열
		int num = 0; // 숫자 채워주는 변수
		int sw = 1; // 채워주는 방향 정해줌
		int[][] spiralArray = new int[run][run];
		while(true) {
			for (int i = 0; i < run; i++) {
				y += sw;
				spiralArray[x][y] = num++;
			}
			run-=1;
			if(run <= 0) {
				break;
			}
			
			for(int i = 0 ; i < run ; i ++) {
				x += sw;
				spiralArray[x][y] = num++;
			}
			sw *= -1;
		}
		// 출력
		for (int i = 0; i < spiralArray.length; i++) {

			for (int j = 0; j < spiralArray[0].length; j++) {
				System.out.printf("%02d  ",spiralArray[i][j]);
			}
			System.out.println();
		}

	}
}
