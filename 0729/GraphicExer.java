package com.leemani.GraphicExer;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JPanel;

public class GraphicExer extends JPanel implements Runnable {
	int xpos, ypos ;
	int xpos2 = 200;
	int ypos2 = 200;
	boolean flag = true;
	Dimension di ;
	static Frame window = new Frame("graphic");
	public static void main(String[] args) {
		window.setBounds(800,100,500,600);
		GraphicExer graphicExer = new GraphicExer();
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
		g.setColor(Color.white);
		g.fillRect(0, 0, di.width, di.height);
		
		g.setColor(Color.black);
		g.drawRect(xpos + 10, ypos + 10, 50, 50);
		
		g.setColor(Color.pink);
		g.fillRect(xpos2, ypos2, 50, 50);
		
		for (int i = 0; i < 10; i++) {
			
		}
	}


	@Override
	public void run() {
		int ysw = 1;
		int xsw = 1;
		int ysw2 = 3;
		int xsw2 = 3;
		boolean flag = true;
		boolean flag2 = true;
		while (true) {
			di = getSize();
			// #1
			if(flag) {
				xpos += xsw;
				if(xpos > di.width - 70 || xpos < 0) {
					xsw *= -1;
					flag =false;
				}
			}else {
				ypos += ysw;
				if(ypos > di.height - 70 || ypos < 0) {
					ysw *= -1;
					flag = true;
				}
			}
			// #2
			if(flag2) {
				xpos2 += xsw2;
				if(xpos2 > di.width - 70 || xpos2 < 0) {
					xsw2 *= -1;
					flag2 =false;
				}
			}else {
				ypos2 += ysw2;
				if(ypos2 > di.height - 70 || ypos2 < 0) {
					ysw2 *= -1;
					flag2 = true;
				}
			}
			
			if(Math.abs(xpos - xpos2) <= 40 && Math.abs(ypos - ypos2) <= 40) {
				xsw *= -1;
				ysw *= -1;
			}
			
			
			try {Thread.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
			repaint();
			
		}
		
	}
	
	
	
}
