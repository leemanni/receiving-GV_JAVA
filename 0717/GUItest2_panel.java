package guiStudy;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Panel;

// || Panel ||
//※ 컴포넌트 : 화면을 구성하는 부품
//(컨테이너=> 컴포넌트로 부터 상속받은 하나의 윈도우 영역)

/* - 컴포넌트들을 그룹별로 묶어서 처리할 때 주로 사용
* - 일반적으로 Frame 컴포넌트들을 직접 붙이지 않고 Panel 에 그룹별로
* 	 붙이고  Panel을 Frame에 다시 붙임
*/
public class GUItest2_panel extends Frame {
//	public GUItest2() {
//		super("두번째 프레임");
//		setBounds(200,200,300,300);
//		setVisible(true);
//	}
	
	public GUItest2_panel(String string) {
		Panel panel = new Panel();
		
		//색을 지정
		panel.setBackground(Color.CYAN);
		
		//add 메소드를 실행하지 않으면
//		Frame에 붙여지지 않는듯
		add(panel);
		
		//크기 지정
		setSize(300, 300);
		// 보여주기 권한 지정
		setVisible(true);
	}
	
	
	
	
	
	
	
	
	public static void main(String[] args) {
//		GUItest2 ob = new GUItest2();
		new GUItest2_panel("패널테스트");
	}
}
