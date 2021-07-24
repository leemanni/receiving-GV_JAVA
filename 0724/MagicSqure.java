package com.leemani.exercise2;

public class MagicSqure {
	public static void main(String[] args) {

		int magic_Num = 9;
		int[][] sqiure = new int[magic_Num][magic_Num];
		int num = 1;
		int line = 0; // 행
		int col = magic_Num / 2 ; // 열
		
		while (Math.pow(magic_Num, 2) + 1 > num) {
			sqiure[line][col] = num;
			// 해당 수(num) 가 magic_Num 의 배수면 열 +1 , 아니면 행 -1
//			범위를 초과하면 j = 0 , i = magic_Num 으로 치환한다.
			if (num % magic_Num == 0) {
				line += 1;
			} else {
				line -= 1;
				col += 1;
				if (col > magic_Num - 1) {
					col = 0;
				}
				if (line < 0) {
					line = magic_Num - 1;
				}
			}
			num++;
		}

		for (int i = 0; i < sqiure.length; i++) {
			for (int j = 0; j < sqiure.length; j++) {
				System.out.printf( "  %02d",sqiure[i][j]);
			}
			System.out.println();
		}

	}
}
