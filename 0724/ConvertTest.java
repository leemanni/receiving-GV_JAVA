package com.leemani.exercise2;
public class ConvertTest {
	
	public String convert(int  num, int convertNum) {
		int r = 0; 		// 나머지
		int m = 1 ; 	// 몫
		String num_convert = "";
		String result =  "";
		while(m != 0) {
			r = num % convertNum ;
			m = num / convertNum;
			 num_convert +=checkTenOver(r);
			 num = m;
		}
		for (int i = num_convert.length()-1 ; i > -1; i--) {
			result += num_convert.charAt(i);
		}
		
		return result;
	}
	
	private String checkTenOver(int r) {
		String [] tenOver = {"A" , "B" , "C", "D", "E", "F"};
		String outputNum = "";
		
		if(r >= 10) {
			outputNum += tenOver[r - 10];
		}else {
			outputNum += r ;
		}
		
		return outputNum;
	}
	
	public static void main(String[] args) {
		ConvertTest test = new ConvertTest();
		 System.out.println(test.convert(110, 16));
		 System.out.println(test.convert(234, 16));
	}
	
	
}
