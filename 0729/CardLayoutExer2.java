package com.leemini.LayoutExercise;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Random;

import javax.swing.JLabel;

public class CardLayoutExer2 extends Frame implements Runnable{

	JLabel [] labels = new JLabel [10];
	Random random = new Random();
	CardLayout  card = new CardLayout();
	
	public CardLayoutExer2() {
		setTitle("CardLayoutTest");
		setBounds(800, 100, 400, 600);

		
		
//	==========layout 설정============================================================================================	
//		CardLayout을 만들고 적용시킨다
		setLayout(card);
//		위의 2 문장을 아래와 같이 1문장으로 줄여서 사용할 수 있다.
//		setLayout(new CardLayout());

		for (int i = 0; i < labels.length; i++) {
			labels[i] = new JLabel(i + "");
			labels[i].setBackground(new Color(random.nextInt(256*256*256)));
			labels[i].setForeground(new Color(random.nextInt(256*256*256)));
			labels[i].setOpaque(true);
			labels[i].setHorizontalAlignment(JLabel.CENTER);
			labels[i].setVerticalAlignment(JLabel.CENTER);
			labels[i].setFont(new Font("나눔고딕", Font.BOLD, 150));
			add(labels[i], i + "");
		}
		
		
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				dispose();
			}
		});
		setVisible(true);
		
		
//	==========카드 교체============================================================================================	
		
	}

	public static void main(String[] args) {

		CardLayoutExer2 window = new CardLayoutExer2();
		Thread thread =  new Thread(window);
		thread.start();
	}

	@Override
	public void run() {
		for (int i = 0; i < labels.length; i++) {
			card.show(this, i+ "");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}

}
