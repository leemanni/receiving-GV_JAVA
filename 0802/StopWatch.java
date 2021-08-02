package com.leemanni.re;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class StopWatch 
extends JFrame implements Runnable, ActionListener
{
	JButton startBtn = new JButton("Start");
	JButton stopBtn = new JButton("Stop");
	JButton resetBtn = new JButton("Reset");
	
	JPanel panel = new JPanel(new GridLayout(1, 3));
	JLabel label = new JLabel();
	
	Font font = new Font("D2coding", Font.BOLD, 45);
	SimpleDateFormat sdf = new SimpleDateFormat("HH : mm : ss.SSS");
	
	// 두 메소드에서 사용하기 위해 멤버변수화
	long start , stop;
	boolean flag = true;

	static StopWatch window ; // 스레드를 Action 하기 위해  static화
	
	public StopWatch() {
		setTitle("StopWatch");
		setBounds(300,100,600,500);
		setLayout(new GridLayout(2,1));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
//		========================================================
		
		//layout
		startBtn.setFont(font);
		stopBtn.setFont(font);
		resetBtn.setFont(font);
		
		startBtn.setBackground(Color.BLACK);
		stopBtn.setBackground(Color.BLACK);
		resetBtn.setBackground(Color.black);
		startBtn.setForeground(Color.PINK);
		stopBtn.setForeground(Color.PINK);
		resetBtn.setForeground(Color.PINK);
		
		label.setOpaque(true);
		label.setText("00 : 00 : 00.000");
		label.setForeground(Color.BLACK);
		label.setBackground(Color.PINK);
		label.setFont(new Font("D2coidng" , Font.ITALIC,80));
		label.setHorizontalAlignment(JLabel.CENTER);
		//// end of layout
		
//		========================================================
		// add
		add(label);
		panel.add(startBtn);
		panel.add(stopBtn);
		panel.add(resetBtn);
		add(panel);
		
		
		startBtn.addActionListener(this);
		stopBtn.addActionListener(this);
		resetBtn.addActionListener(this);
		startBtn.setEnabled(true);
		stopBtn.setEnabled(false);
		resetBtn.setEnabled(false);
	}
	

	
	public static void main(String[] args) {
		window = new StopWatch();
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		Thread thread  =  new Thread(window);
		
		switch (e.getActionCommand()) {
			case "Start": case "ReStart":
				flag = true;
				thread.start();
				startBtn.setEnabled(false);
				stopBtn.setEnabled(true);
				resetBtn.setEnabled(false);
				break;
			case "Stop": 
				flag = false;
				startBtn.setText("ReStart");
				startBtn.setEnabled(true);
				stopBtn.setEnabled(false);
				resetBtn.setEnabled(true);
				break;
			case "Reset":
				start= 0;
				startBtn.setText("Start");
				label.setText("00 : 00 : 00.000");
				stopBtn.setEnabled(false);
				break;

		}
	}

	@Override
	public void run() {
		if(start == 0) {
			start = System.currentTimeMillis();
			stop = start ;
		}
		
		while (true) {
			
			label.setText(sdf.format(++start - stop-(60 * 9 * 60 * 1000)));
			try {Thread.sleep(1);} catch (InterruptedException e) {e.printStackTrace();}
			if (!flag) {
				break;
			}
		}
		
	}
}
