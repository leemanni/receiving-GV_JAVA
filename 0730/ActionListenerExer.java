package com.leemanni.animation;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ActionListenerExer extends JFrame implements ActionListener{
	
	
	JButton [] buttons = new JButton[5];
	String [] titles = {"삽입","검색","삭제","수정","종료"};
	
	
	public ActionListenerExer() {
		setTitle("DataBase");
		setBounds(300,100,400,600);
		for (int i = 0; i < buttons.length; i++) {
			buttons[i] =new JButton(titles[i]);
			buttons[i].setBackground(Color.blue);
			buttons[i].setForeground(Color.yellow);
			buttons[i].setFont(new Font("나눔고딕", Font.BOLD, 80));
			add(buttons[i]);
		}
		setLayout(new GridLayout(buttons.length,1));
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		for (int i = 0; i < buttons.length; i++) {
			buttons[i].addActionListener(this);
		}
		
	}
	
	public static void main(String[] args) {
		ActionListenerExer window = new ActionListenerExer();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object object = e.getSource();
		JButton button = (JButton)e.getSource();
		for (int i = 0; i < buttons.length; i++) {
			if(button == buttons[i]) {
				JOptionPane.showMessageDialog(buttons[i], titles[i] + " 작업이 실행", "Action",JOptionPane.PLAIN_MESSAGE);
				if(i==4) { // 종료버튼이 눌리면 종료작업실행~
					System.exit(0);
				}
			}
		}
		
	}

}
