package com.leemani.exercise;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JLabel;

public class JLabels extends JLabel {

	public JLabels(String title) {
		super(title);
		
		setBackground(Color.black);
		setForeground(Color.pink);
		
		setOpaque(true);
		setLayout(new FlowLayout());
		
		setFont( new Font("D2coding",Font.BOLD, 40));
		
		setPreferredSize(new Dimension(400,120));
	}	
	
	
	
	
	
	
}
