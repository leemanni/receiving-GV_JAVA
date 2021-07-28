package com.leemani.exercise;

import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class NumButton extends JPanel {
	JButton[] buttons = new JButton[12];
	String[] keyPad = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "*", "0", "#" };
	
	public NumButton() {
		setLayout(new GridLayout(4, 3, 2, 2));
		for (int i = 0; i < keyPad.length; i++) {
			buttons[i] = new JButton(keyPad[i]);
			buttons[i].setFont(new Font("Dialog", Font.BOLD, 30));
			add(buttons[i]);
		}
	}
}
