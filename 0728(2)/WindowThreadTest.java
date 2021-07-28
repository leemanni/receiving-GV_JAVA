package com.leemani.exercise;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.SimpleDateFormat;

import javax.swing.JFrame;

public class WindowThreadTest extends JFrame implements Runnable {

	int xpos = 0;
	int ypos = 0;
	Dimension dimension = null;

	public WindowThreadTest() {
		
		//기본 은 보더레이아웃 이지만 형식을 바꿔 보기
		setLayout(new FlowLayout());
		
		// 객체화 해서 라벨 붙이기
		JLabels labels = new JLabels("GUI 공부 하기이~");
		add(labels);
		
		
		
		
		setBounds(xpos, ypos, 400, 500);
		dimension = Toolkit.getDefaultToolkit().getScreenSize();
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				dispose();
			}
		});

		setVisible(true);
	}

	public static void main(String[] args) {
		WindowThreadTest threadTest = new WindowThreadTest();
		Thread thread = new Thread(threadTest);
		thread.start();

	}

	@Override
	public void run() {
		SimpleDateFormat sdf = new SimpleDateFormat("HH : mm : ss.SSS  E요일");
		int ySW = 1;
		int xSw = 1;
		boolean flag = true;

		while (true) {
			setTitle(sdf.format(System.currentTimeMillis()));

			if (flag) {
				xpos += xSw;
				System.out.println("xpos : " + xpos);
				if (xpos > (dimension.width - getSize().width) || xpos <= 0) {
					xSw *= -1;
					flag = false;
				}
			} else {
				ypos += ySW;
				System.out.println("ypos : "+ ypos);
				if (ypos > dimension.height - getSize().height || ypos <= 0) {
					ySW *= -1;
					flag = true;
				}
			}

			setLocation(xpos, ypos);

			try {
				Thread.sleep(4);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

}
