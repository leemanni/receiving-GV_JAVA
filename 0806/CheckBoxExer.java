package com.leemanni.exercise;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CheckBoxExer extends JFrame implements ItemListener{
	
	JCheckBox morning , launch, dinner;
	JPanel panel = new JPanel(new BorderLayout());
	JPanel checkPanel = new JPanel();
	JPanel centerPanel = new JPanel();
	JLabel bottomLabel = new JLabel("식사하신 내용이 표시됩니다");
	JLabel topLabel = new JLabel("오늘 식사하신 시간대를 체크하세요");
	JLabel nameLabel = new JLabel("이름  ");
	JTextField nameField = new JTextField("이름 ");
	Font font = new Font("나눔고딕", Font.PLAIN, 16);
	
//	CheckboxGroup group = new CheckboxGroup();
	ButtonGroup group = new ButtonGroup();
	public CheckBoxExer() {
		setTitle("CheckBox");
		setBounds(400,200,500,400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		topLabel.setPreferredSize(new Dimension(400,150));
		topLabel.setHorizontalAlignment(JLabel.CENTER);
		topLabel.setBackground(Color.gray);
		topLabel.setOpaque(true);
		topLabel.setFont(new Font("나눔고딕",Font.BOLD,24));
		
		
		morning = new JCheckBox("아침" , false);
		launch = new JCheckBox("점심", false );
		dinner = new JCheckBox("저녁", false) ;
		
		group.add(morning);
		group.add(dinner);
		group.add(launch);
		
		morning.setFont(font);
		dinner.setFont(font);
		launch.setFont(font);
		
		checkPanel.add(morning);
		checkPanel.add(launch);
		checkPanel.add(dinner);
		bottomLabel.setPreferredSize(new Dimension(400, 100));
		bottomLabel.setHorizontalAlignment(JLabel.CENTER);
		bottomLabel.setBackground(Color.gray);
		bottomLabel.setOpaque(true);
		panel.add(checkPanel, BorderLayout.NORTH);
		panel.add(bottomLabel,BorderLayout.SOUTH);
		
		nameLabel.setFont(font);
		nameField.setPreferredSize(new Dimension(90,30));
		centerPanel.add(nameLabel);
		centerPanel.add(nameField);
		
		
		morning.addItemListener(this);
		launch.addItemListener(this);
		dinner.addItemListener(this);
		
		add(centerPanel);
		add(topLabel,BorderLayout.NORTH);
		add(panel,BorderLayout.SOUTH);
		
		
		
		
		
		
		setVisible(true);
	}
	
	public static void main(String[] args) {
		CheckBoxExer window = new CheckBoxExer();
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		
		String show = nameField.getText() + " 님이 ";
		JCheckBox checkbox = (JCheckBox) e.getSource();
		if(checkbox == morning) {
			show += morning.isSelected() ? "아침" : "";
		}
		if(checkbox == launch) {
			show += launch.isSelected() ? "점심" : "";
		}
		if(checkbox == dinner) {
			show += dinner.isSelected() ? "저녁" : "";
		}
		
		show += "식사를 하십니다.";
		bottomLabel.setText(show);
	}
}
