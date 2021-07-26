package com.leemani.useFlag;

import java.util.Scanner;

public class TerminnnnateTest {
	public static void main(String[] args) {
		TerminateThread ter = new TerminateThread();
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("종료 하시려면 q를 입력 : ");
		String s = scanner.nextLine();
		
		if(s.toUpperCase().equals("Q")) {
			ter.setFlag(true);
		}
		ter.start();
		
		
	}
}
