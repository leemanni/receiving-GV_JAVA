package remind;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

public class ChangeToHangle {
	
//	숫자를 받으면 한글로 바꿔주는 메소드
	String changeType(String inputNum) {
		String hangle = "공일이삼사오육칠팔구";
		String changeToHangle = "";
		for(int i = 0;i<inputNum.length();i++){
			if(inputNum.charAt(i)=='-') {
				changeToHangle += "-";
			}else {
				if(i==6) {
					changeToHangle += "-";
				}
				changeToHangle += hangle.charAt(Integer.parseInt("" + inputNum.charAt(i)));
			}
		}
		return changeToHangle;
	}
		
//	주민등록 번호를 받으면 몇년 몇일 생인지 반환해주는 메소드
	void juminNum(String jumin) {
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd(E)");
		int year = 0;
		int month =0;
		int day = 0 ;
		year = Integer.parseInt(jumin.substring(0, 2));
		month = Integer.parseInt(jumin.substring(2, 4));
		day = Integer.parseInt(jumin.substring(4, 6));
		int index = jumin.indexOf("-") > -1 ? 7 : 6; // 혹시라도 "-" 입력한 사람을 방지하기 위한 장치
		if (jumin.charAt(index) != '1' && jumin.charAt(index) != '2') {
			year += 2000;
		}else {
			year += 1900;
		}
		System.out.println(year);
		calendar.set(year, month, day);
		System.out.println("당신이 태어난 날짜 => " + sdf.format(calendar.getTime()));
	}
	
	
//	메인 단
	public static void main(String[] args) {
		ChangeToHangle c = new ChangeToHangle();
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("주민등록번호를 입력하세요 : ");
		String jumin = scanner.nextLine();
		System.out.println(c.changeType(jumin));
		c.juminNum(jumin);
	}
	
	
	
	
	
	
}
