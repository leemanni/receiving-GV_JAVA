import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FileIO {
	public static void main(String[] args) {
		// 텍스트 파일로 저장할 데이터를 입력받아줌
		Scanner scanner = null;
		// 텍스트 파일에 데이터를 저장함
		PrintWriter printWriter = null;
		//경로를 지정해준다 => 상대경로를 활용 (프로젝트 이름부터 "." 을 사용한다)
		String filePath = ".\\src\\hitext!.txt"; 
		
		
		
		try { // 안전을 위해 try-catch 에 감싸게 되어 있다
			// 생성자 안의 파일 경로로 새로운 파일은 만든다.
			printWriter =new PrintWriter(filePath);
			// 콘솔창의 키보드를 입력받아서 텍스트를 생성 그것을 printWriter에 넣어주고
			// printWrite 에 저장한 파일에 데이터를 넣어준다.
			scanner = new Scanner(System.in);
			while(true) {
				System.out.print("데이터를 입력하세요 >>");
				String str = scanner.nextLine().trim();
				if(str.toLowerCase().equals("quit")) {
					break;
				}
				if(str.length() != 0) {
					printWriter.write(str + "\n");
				}
				
			}
		} catch (FileNotFoundException e) {
			System.out.println("파일 이름이 존재합니다.");
		}finally {
			if(printWriter != null) {
				//파일로 저장하려면 반드시 닫아줘야 해
				printWriter.close();
			}
		}
		
		
	}
}
