import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileRead {
	public static void main(String[] args) {
		Scanner scanner = null;
		String filePath = ".\\\\src\\\\hitext!.txt";

		try {
			// Scanner 생성자 안에 익명 클래스로 file 이라고 만들어줘야 읽어들여
//			익명클래스가 아니라도 상관없음 하지만 한 번만 쓸거라서 익명클래스를 사용함
			scanner = new Scanner(new File(filePath));
			while (scanner.hasNext()) {
				String s = scanner.nextLine();
				System.out.println(s);
				
			}
		} catch (FileNotFoundException e) {
			System.out.println("경로에 파일이 존재하지 않음");
		}
	}

}
