package com.leemanni.gui;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class WindowTest {
	public static void main(String[] args) {
		
		Frame frame = new Frame();
		
		frame.setTitle("안녕~~");
		frame.setBounds(800,100,400,300);
		
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				frame.dispose();
			}
			
		});
		
		
		
		frame.setVisible(true);
		
		
	}
}
