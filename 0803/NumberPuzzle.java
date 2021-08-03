package com.leemanni.exercise;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class NumberPuzzle extends JFrame implements ActionListener {
	
	
	JButton[] buttons = new JButton[16];
	String[] numbers = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16" };
	JButton startBtn = new JButton("Start");

	Image [] images = new Image[16];
	
	JPanel panel = new JPanel(new GridLayout(4, 4, 1, 1));

	Font font = new Font("D2coding", Font.BOLD, 50); // 글자통일

	public NumberPuzzle(String kind) {
		//image
		for (int i = 0; i < images.length; i++) {
			String filePath =String.format(".\\src\\puzzleImage\\%s\\%02d.jpg", kind, i+1);
			images[i] = Toolkit.getDefaultToolkit().getImage(filePath);
		}
		// Frame
		setTitle("Puzzle..!");
		setBounds(400, 100, 400, 450);

		// panel
		panel.setPreferredSize(new Dimension(400, 400));

		// buttons
		makePuzzle();
		
		// 처음에 시작할 때 원본 퍼즐 버튼을 누르지 못하게 막아주기
		for (int i = 0; i < buttons.length; i++) {
			buttons[i].setEnabled(false);
			}
		
		
		startBtn.setPreferredSize(new Dimension(400, 50));
		startBtn.setBackground(Color.pink);
		startBtn.setForeground(Color.black);
		startBtn.setFont(font);
		startBtn.addActionListener(this);

		add(panel);
		add(startBtn, BorderLayout.SOUTH);

		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	// 퍼즐을 만들어주는 메소드
	private void makePuzzle() {
		for (int i = 0; i < buttons.length; i++) {
			buttons[i] = new JButton(new ImageIcon(images[Integer.parseInt(numbers[i])-1]));
			
			buttons[i].setName(numbers[i]);
			panel.add(buttons[i]);
			if (buttons[i].getName().equals("16")) {
				buttons[i].setVisible(false);
			}
			buttons[i].addActionListener(this);
		}
	}

	public static void main(String[] args) {
		// 사진의 이름을 저장하는 배열
		String [] games = {"bbororo", "bonobono","conan","doll","hero","mini", "naruto", "number", "onfice" ,"pika","poo","tiger"};
		int choice = JOptionPane.showOptionDialog(null, "퍼즐을 고르세요", "Slect Puzzle", JOptionPane.DEFAULT_OPTION
				, JOptionPane.PLAIN_MESSAGE, null, games, null);
		NumberPuzzle window = new NumberPuzzle(games[choice]);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Random random = new Random();
		JButton button = (JButton) e.getSource();
		int selectIndex = 0;
		switch (e.getActionCommand()) {
			case "Start":
				for (int i = 0; i < 20; i++) {
					int mix = random.nextInt(15) + 1;
					String s = numbers[0];
					numbers[0] = numbers[mix];
					numbers[mix] = s;
				}
				for (int i = 0; i < numbers.length; i++) {
					if (buttons[i].getName().equals("16")) {
						buttons[i].setVisible(true);
					}
					panel.remove(buttons[i]);
				}
				break;
	
			default:
				for (int i = 0; i < buttons.length; i++) {
					if(button.getName().equals(buttons[i].getName())) {
						selectIndex = i;
						break;
					}
				}
				String temp = "";
				if(selectIndex % 4 != 0 && buttons[selectIndex-1].getName().equals("16")) {
					temp = numbers[selectIndex-1];
					numbers[selectIndex-1] = numbers[selectIndex];
					numbers[selectIndex] = temp;
				}
				if(selectIndex % 4 != 3 && buttons[selectIndex+1].getName().equals("16")) {
					temp = numbers[selectIndex+1];
					numbers[selectIndex+1] = numbers[selectIndex];
					numbers[selectIndex] = temp;
				}
				if(selectIndex / 4 != 0 && buttons[selectIndex-4].getName().equals("16")) {
					temp = numbers[selectIndex-4];
					numbers[selectIndex-4] = numbers[selectIndex];
					numbers[selectIndex] = temp;
				}
				if(selectIndex / 4 != 3 && buttons[selectIndex+4].getName().equals("16")) {
					temp = numbers[selectIndex+4];
					numbers[selectIndex+4] = numbers[selectIndex];
					numbers[selectIndex] = temp;
				}
				break;
		}
		for (int i = 0; i < buttons.length; i++) {
			buttons[i].setVisible(true);
			panel.remove(buttons[i]);
		}
		makePuzzle();
		add(panel);
		revalidate();
		
		end:		// 레이블~
			while(true) {
				for (int i = 0; i < buttons.length; i++) {
					if(i+1 != Integer.parseInt(buttons[i].getName())) {
						break end;
					}
				}
				JOptionPane.showMessageDialog(panel, "정답 축하해요오~");
				System.exit(0);
			}
	}
}
