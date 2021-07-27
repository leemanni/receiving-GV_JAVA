package com.leemanni.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class WindowTest2 extends Frame{
	Dimension dimension, dim = null;
	public WindowTest2() {
		this("2번째~");
	}

	public WindowTest2(String string) {
		setTitle(string);
		setBounds(800, 100, 400, 300);
		setBackground(Color.DARK_GRAY);
		
		
		addWindowListener(new WindowAdapter() {
			
			@Override
			public void windowClosing(WindowEvent e) {
				dispose();
			}
		});
		dim =getSize();
		dimension = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation((dimension.width-dim.width)/2 ,(dimension.height-dim.height)/2 );
		
		setVisible(true);
	}
	
	public static void main(String[] args) {
		WindowTest2 test2 = new WindowTest2();
	}
	
}
