package com.leemani.exercise;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PhoneFrame extends JFrame{

	public PhoneFrame() {
		setTitle("Telephone");
		
		// 선언
		JLabel top = new JLabel("PHONE");
		JLabel left = new JLabel("<html>A<br>P<br>P<br>L<br>E</html>");
		JLabel right = new JLabel("<html>K<br>O<br>R<br>E<br>A</html>");
			// 남쪽 => 통화 / 거절 버튼
		JLabel bottomLeft = new JLabel("통화");
		JLabel bottomRight = new JLabel("거절");
		JPanel panel = new JPanel(new GridLayout(1,2));
		panel.add(bottomLeft);
		panel.add(bottomRight);
		
			// CENTER 번호키 만들기
		NumButton button = new NumButton();
		
		
		//가시권 허용
		top.setOpaque(true);
		left.setOpaque(true);
		right.setOpaque(true);
		bottomLeft.setOpaque(true);
		bottomRight.setOpaque(true);
		
		
		//크기 지정
		Dimension diTB = new Dimension(100,40);
		Dimension di = new Dimension(50,50);
		top.setPreferredSize(diTB);
		left.setPreferredSize(di);
		right.setPreferredSize(di);
		panel.setPreferredSize(diTB);
		
		// 폰트 설정
		top.setFont(new Font("Dialog", Font.BOLD, 32));
		left.setFont(new Font("Dialog", Font.PLAIN, 24));
		right.setFont(new Font("Dialog", Font.PLAIN, 24));
		
		bottomLeft.setFont(new Font("Dialog", Font.BOLD, 32));
		bottomRight.setFont(new Font("Dialog", Font.BOLD, 32));
		
		// 폰트 위치 설정
		top.setHorizontalAlignment(JLabel.CENTER);
		left.setHorizontalAlignment(JLabel.CENTER);
		left.setVerticalAlignment(JLabel.CENTER);
		right.setHorizontalAlignment(JLabel.CENTER);
		right.setVerticalAlignment(JLabel.CENTER);
		
		bottomLeft.setHorizontalAlignment(JLabel.CENTER);
		bottomRight.setHorizontalAlignment(JLabel.CENTER);
		
		//구역 색상 설정
		top.setBackground(Color.DARK_GRAY);
		top.setForeground(Color.gray);
		left.setBackground(Color.black);
		left.setForeground(Color.gray);
		right.setBackground(Color.DARK_GRAY);
		right.setForeground(Color.gray);
		
		bottomLeft.setBackground(Color.green);
		bottomLeft.setForeground(Color.white);
		
		bottomRight.setBackground(Color.red);
		bottomRight.setForeground(Color.white);
		
		//프레임에 삽입
		add(top,BorderLayout.NORTH);
		add(left,BorderLayout.WEST);
		add(right,BorderLayout.EAST);
		add(panel,BorderLayout.SOUTH);
		add(button);
		
		//-------------------------------------------------------------
		setBounds(400,100,600,700);
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				dispose();
			}
		});
		setVisible(true);
	}
	public static void main(String[] args) {
		
		PhoneFrame frame = new PhoneFrame();
	}
	
	
}
