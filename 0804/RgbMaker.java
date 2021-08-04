package com.leemanni.exercise;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class RgbMaker extends JFrame implements MouseWheelListener{
	
	JPanel colorPanel = new JPanel();						// RGB 올려놓는 패널
	JPanel controlPanel = new JPanel(new GridLayout(1,3));	// 색을 표현
	JPanel redPanel = new JPanel();							// RED 패널
	JPanel greenPanel = new JPanel();						// Green 패널
	JPanel bluePanel = new JPanel();						// Blue 패널
	
	int r= 126, g=126, b = 126;
	String view = String.format("R : %d  G : %d  B : %d", r,g,b);
	JLabel redLabel = new JLabel(r + "");
	JLabel greenLabel = new JLabel(g + "");
	JLabel blueLabel = new JLabel(b + "");
	JLabel viewLabel = new JLabel(view);
	Dimension di = new Dimension(40, 20);
	
	JButton ouputBtn = new JButton("색상 추출");
	
	public RgbMaker() {
		// Frame
		setTitle("RGB Maker");
		setBounds(400, 150, 500, 600);
		
		// Panel
		colorPanel.setPreferredSize(new Dimension(500,450));
		colorPanel.setBackground(new Color(r,g,b));
		
		controlPanel.setPreferredSize(new Dimension(500, 150));
		
		redPanel.setBackground(Color.red);
		greenPanel.setBackground(Color.green);
		bluePanel.setBackground(Color.blue);
		
		//label
		redLabel.setBackground(Color.WHITE);
		redLabel.setOpaque(true);
		redLabel.setPreferredSize(di);
		redLabel.setHorizontalAlignment(JLabel.CENTER);
		
		blueLabel.setBackground(Color.WHITE);
		blueLabel.setOpaque(true);
		blueLabel.setPreferredSize(di);
		blueLabel.setHorizontalAlignment(JLabel.CENTER);
		
		greenLabel.setBackground(Color.WHITE);
		greenLabel.setOpaque(true);
		greenLabel.setPreferredSize(di);
		greenLabel.setHorizontalAlignment(JLabel.CENTER);
		
		viewLabel.setBackground(Color.WHITE);
		viewLabel.setOpaque(true);
		viewLabel.setPreferredSize(new Dimension(130,20));
		
		//button
		ouputBtn.setBackground(Color.white);
		ouputBtn.setForeground(Color.black);
		ouputBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(colorPanel, view, "색상표", JOptionPane.INFORMATION_MESSAGE);
				
			}
		});
		//add
		add(colorPanel);
		add(controlPanel, BorderLayout.SOUTH);
		
		controlPanel.add(redPanel);
		controlPanel.add(greenPanel);
		controlPanel.add(bluePanel);
		
		
		colorPanel.add(viewLabel);
		colorPanel.add(ouputBtn);
		
		redPanel.add(redLabel);
		greenPanel.add(greenLabel);
		bluePanel.add(blueLabel);
		
		redPanel.addMouseWheelListener(this);
		bluePanel.addMouseWheelListener(this);
		greenPanel.addMouseWheelListener(this);
		
		
		
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		RgbMaker widow = new RgbMaker();
	}

	@Override
	public void mouseWheelMoved(MouseWheelEvent e) {
		JPanel panel = (JPanel) e.getSource();
		
		if(panel == redPanel) {
			if(e.getWheelRotation() > 0) {
				r = ++r > 255 ? 255 : r;
			}else {
				r = --r < 0 ? 0 : r;
			}
			redLabel.setText(r+"");
		}else if(panel == greenPanel) {
			if(e.getWheelRotation() > 0) {
				g = ++g > 255 ? 255 : g;
			}else {
				g = --g < 0 ? 0 : g;
			}
			greenLabel.setText(g+"");
		}else {
			if(e.getWheelRotation() > 0) {
				b = ++b > 255 ? 255 : b;
			}else {
				b = --b < 0 ? 0 : b;
			}
			blueLabel.setText(b+"");
		}
		colorPanel.setBackground(new Color(r, g, b));
		view = String.format("R : %d  G : %d  B : %d", r,g,b);
		viewLabel.setText(view);
	}

}
