import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

public class JuminNum {
	public static void main(String[] args) {
		// 주민등록 번호를 입력 받아서 몇 년 몇 월 몇 일 인지 무슨요일 인지 알려주기
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd(E)");
		Scanner scanner = new Scanner(System.in);
		
		
		System.out.print("주민등록 번호를 입력하세요 : ");
		String jummin = scanner.next();
		int year = 0;
		int month = 0;
		int day = 0;
		
		
		year = Integer.parseInt(jummin.substring(0, 2));
		month = Integer.parseInt(jummin.substring(2, 4));
		day = Integer.parseInt(jummin.substring(4, 6));

		// 주민 등록 번호 뒷자리 맨 첫 숫자의 index 를 가져옴
		int index = jummin.indexOf("-") > -1 ? 7 : 6;
		if (jummin.charAt(index) != '1' && jummin.charAt(index) != '2') {
			year += 2000;
		}else {
			year += 1900;
		}
		
		calendar.set(year, month-1, day);
		System.out.println("당신이 태어난 날짜 => " + sdf.format(calendar.getTime()));
		
		
		
	}

}
