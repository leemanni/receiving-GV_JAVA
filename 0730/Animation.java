package com.leemanni.animation;

import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Animation extends JPanel implements Runnable {
	Image roket,bg;
	int w = 488 / 4;
	int h = 65;
	int xpos = 60 ;
	int index;
	int xsw = 1;
	
	public Animation() {
		String filePath =".\\src\\com\\leemanni\\images\\bg.png";
		bg = Toolkit.getDefaultToolkit().getImage(filePath);
		filePath =".\\src\\com\\leemanni\\images\\ship.png";
		roket = Toolkit.getDefaultToolkit().getImage(filePath);
	}
	
	public static void main(String[] args) {
		Frame window = new JFrame("Roket");
		// 메인에서 FRame 를 만들기
		window.setBounds(400,160,720,320);
		Animation graphicExer = new Animation();
		window.add(graphicExer);
		window.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		window.setVisible(true);
		
		Thread thread =  new Thread(graphicExer);
		thread.start();
	}
	
	
	@Override
	public void paint(Graphics g) {
		g.drawImage(bg, 0, 0, this);
		
		g.drawImage(roket, xpos, 50, w + xpos, 50 + h, w * index, 0, w *(index+1), h, this);
		
	}

	@Override
	public void run() {
		while(true) {
			if(xpos++ > getSize().width) {
				xpos = -w; // x좌표의 첫번째 자리가 w + xpos기 때문에 -w 해주면 0
			}
			index = ++index % 3;
			repaint();
			try {Thread.sleep(10);} catch (InterruptedException e) {e.printStackTrace();}
		}
		
		
	}
	
	
	
}
