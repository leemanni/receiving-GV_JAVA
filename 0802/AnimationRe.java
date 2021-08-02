package com.leemanni.re;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class 
AnimationRe extends JPanel implements Runnable{
	
//	이미지 객체를 만들기
	Image bg ;
	Image [] dukes = new Image [10];
//	사진 배열의 인덱스를 기억하는 변수
	int index ;
	
	public AnimationRe() {
//		생성자 안에서 패널에 이미지의 주소를  입력 즉, 객체 생성자 바로 이미지 생성할 수 있게
		String filePath = ".\\src\\com\\leemanni\\images\\bg.png";
		bg = Toolkit.getDefaultToolkit().getImage(filePath);
		for (int i = 0; i < dukes.length; i++) {
			filePath = String.format(".\\\\src\\\\com\\\\leemanni\\\\images\\Duke%02d.gif", i+1);
			dukes[i] =Toolkit.getDefaultToolkit().getImage(filePath);
//			System.out.println(filePath);
		}
	}
	
	
	
	
	public static void main(String[] args) {
//	main에서 프레임 설정
		JFrame window = new JFrame("Remind");
		window.setBounds(400,100,720,320);
		AnimationRe animationRe = new AnimationRe();
		window.add(animationRe);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		window.setVisible(true);
		
		Thread thread = new Thread(animationRe);
		thread.start();
	}
	
	@Override
	public void paint(Graphics g) {
		g.drawImage(bg, 0, 0, this);
		
		g.drawImage(dukes[index], getSize().width/2, getSize().height/2, this);
	}
	 @Override
	public void run() {
		while (true) {
			index = ++index % dukes.length;
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			repaint();
		}
		
	}
	
	
}
