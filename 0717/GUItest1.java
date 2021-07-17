package guiStudy;

import java.awt.Frame;
import java.awt.Panel;

public class GUItest1 {
	public static void main(String[] args) {
		// ||Frame|| 
	/* - 응용프로그램에 윈도우를 생성하기 위해 사용
	 * - 기본적으로 타이틀, 최소버튼, 최대버튼, 종료버튼을 지원
	 * - 상위 클래스인 window 는 타이틀 메뉴가 지워되지 않음.
	 * 	기본적으로 화면에 안보이게 설정했기 때문에 반드시 setVisible(true)
	 * - 값으로 설정해야 화면상에 보여짐
	 * - 만드는 방법은 Frame을 상속 받아도 되고, main 메소드에서 직접 작성이 가능
	*/
		
	/*	[ex]
	 * 생성자는 두가지 타입
	 * 1- 빈 생성자
	 * 2- str 타이틀을 지정하여 프레임을 생성
	 */
		
		Frame frame =  new Frame();
		frame.setTitle("나의 첫번째 GUI");
		frame.setBounds(100,100,400,400);
		frame.setVisible(true);
		
		

		
	}
}
