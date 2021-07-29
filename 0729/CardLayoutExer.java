package com.leemini.LayoutExercise;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JLabel;

public class CardLayoutExer extends Frame{
	
	JLabel label = new JLabel("1");
	JLabel label2 = new JLabel("2");
	JLabel label3 = new JLabel("3");
	
	 public CardLayoutExer() {
		setTitle("Card");
		setBounds(800, 100, 400, 600);
		
//		======layout 설정===
		CardLayout card  = new CardLayout();
		setLayout(card);
		String name1 = "1";
		String name2 = "2";
		String name3 = "3";
		
//		=======라벨 디자인====
		label.setBackground(Color.BLUE);
		label.setForeground(Color.cyan);
		label.setOpaque(true);
		label.setFont(new Font("D2coding", Font.BOLD, 100));
		label.setHorizontalAlignment(JLabel.CENTER);
		label.setVerticalAlignment(JLabel.CENTER);
		add(name1,label);
		
		label2.setBackground(Color.yellow);
		label2.setForeground(Color.green);
		label2.setOpaque(true);
		label2.setFont(new Font("D2coding", Font.BOLD, 100));
		label2.setHorizontalAlignment(JLabel.CENTER);
		label2.setVerticalAlignment(JLabel.CENTER);
		add(name2,label2);
		
		label3.setBackground(Color.yellow);
		label3.setForeground(Color.green);
		label3.setOpaque(true);
		label3.setFont(new Font("D2coding", Font.BOLD, 100));
		label3.setHorizontalAlignment(JLabel.CENTER);
		label3.setVerticalAlignment(JLabel.CENTER);
		add(name3,label3);
		
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				dispose();
			}
		});
		
		setVisible(true);
		
		try {Thread.sleep(200);} catch (InterruptedException e1) {e1.printStackTrace();}
		card.show(this , name2);
		
		try {Thread.sleep(200);} catch (InterruptedException e1) {e1.printStackTrace();}
		card.show(this , name3);
		
		
		
	}
	public static void main(String[] args) {
		CardLayoutExer window = new CardLayoutExer();
	}
}
