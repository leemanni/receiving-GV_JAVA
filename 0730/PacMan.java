package com.leemanin.Graphic;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class PacMan extends JPanel implements Runnable {
	boolean flag = true;
	Dimension di ;
	static Frame window = new JFrame("PacMan");
	int xpos = 50;		// x 좌표
	int ypos = 50;		// y 좌표
	int ysw = 1;		// y 방향
	int xsw = 1;		// x 방향
	int startP = 0 ;	// arc 의 시작 각
	int fillangle = 0;	// arc의 색이 채워지는 각도
	
	public static void main(String[] args) {
		// 메인에서 FRame 를 만들기
		window.setBounds(800,100,500,600);
		PacMan graphicExer = new PacMan();
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
		// 뒤의 배경을 설정
		g.setColor(Color.BLUE);
		g.fillRect(0, 0, di.width, di.height);
		
		// 뒤의 팩맨을 설정
		g.setColor(Color.YELLOW);
		g.fillArc(xpos, ypos, 50, 50, startP + fillangle, 360 - fillangle * 2);
		
	}

	@Override
	public void run() {
		int asw = 1;
		
		boolean flag = true; // 팩맨이 움직이는 방향을 설정
		// true => x축으로 이동, false => y축으로 이동
		while (true) {
			di = getSize();
			fillangle += asw;
			if(flag) {
				asw *= fillangle > 30 || fillangle < 0 ? -1 : 1;
				xpos += xsw;
				if(xpos  > di.width - 60 || xpos < 0) { // window 끝에 닿으면 방향을 바꾼다.
					startP = (startP -= 90) % 360;
					xsw *= -1;
					flag = false;
				}
			}else {
				asw *= fillangle > 30 || fillangle < 0 ? -1 : 1;
				ypos += ysw;
				if(ypos  > di.height - 60 || ypos < 0) { // window 끝에 닿으면 방향을 바꾼다.
					startP = (startP -= 90) % 360;
					ysw *= -1;
					flag = true;
				}
				
			}
			
			repaint();
			try {Thread.sleep(1);} catch (InterruptedException e) {e.printStackTrace();}
		}
	
	}
	
	
	
}
