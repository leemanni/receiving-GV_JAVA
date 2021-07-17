package guiStudy;

import java.awt.Dialog;
import java.awt.Frame;

public class GUItest3_Dialog extends Frame {
//	||Dialog||
/* - 메인 윈도우 외에 메세지를 출력하거나 사용자로부터 자료를
 * 	입력 받을 때 사용하는 컨테이너
 * (컨테이너=> 컴포넌트로 부터 상속받은 하나의 윈도우 영역)
 * 
 */
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public GUItest3_Dialog() {
	// 이거의 의미는 생성자에 파일이름 넣을 수 잇는 거 있어서가능
//		프레임의 제목을 지정
		super("Dialog Test"); 
		// 객체 생성(제목을 갖은 객체를 생성)
		Dialog dialog =  new Dialog(this, "모덜러스");
		// 위치와 크기 설정(x축 ,y축, 가로, 세로)-프레임
		setBounds(0,0,400,400);
		// 창을 화면에 보이게 함-프레임의 권한 허용
		setVisible(true);
		// 크기 설정 - Dialog 크기 설정
		dialog.setSize(600, 200);
		// 다이어로그 보이게 할 프레임 권한 허용
		dialog.setVisible(true);
		
	}
	
	public static void main(String[] args) {
		new GUItest3_Dialog();
	}
}
