package com.leemanni.exercise;

import java.awt.BorderLayout;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ComboAndListBoxExer extends JFrame implements ActionListener{
	
//	공용
	Font font = new Font("나눔고딕", Font.PLAIN, 30);
	ArrayList<String> cities = new ArrayList<>();		// 도시의 선택에 따라 배열을 다르게 입력해줌
	
	
//	# 4*1
	JLabel headLine = new JLabel("주소 입력 프로그램");
	
//	# 4*2
	JPanel secondPanel = new JPanel();		// 4*2 영역에 들어가서 second 라 명명함.
	JLabel bigCity = new JLabel();			// 시, 도 써주는 label
	Choice secondComboBox = new Choice();	// 4*2 영역에 들어가서 second 라 명명함.
	JButton thirdButton = new JButton("입력");
	static final String SEOUL = "서울시";
	static final String GYEONGGI = "경기도";
	
//	# 4*3
	JPanel thirdPanel = new JPanel();		// 4*2 영역에 들어가서 second 라 명명함.
	JLabel smallCity = new JLabel();		// 시, 도 써주는 label
	Choice thirdComboBox = new Choice();	// 4*2 영역에 들어가서 second 라 명명함.
	List smallCityList = new List(6, false);
	JButton secondButton = new JButton("입력");
	
//	# 4*4	
	JPanel fourthPanel = new JPanel(new BorderLayout());
	JLabel showLabel = new JLabel();		// 입력한 정보를 보여주는 label
	
	
	
	public ComboAndListBoxExer() {
		setTitle("CheckBox");
		setBounds(400,200,400,600);
		setLayout(new GridLayout(4,1));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
//		#4*1
		headLine.setFont(new Font("D2coding", Font.BOLD, 30));
		headLine.setHorizontalAlignment(JLabel.CENTER);
		headLine.setBackground(Color.DARK_GRAY);
		headLine.setForeground(Color.white);
		headLine.setOpaque(true);
		add(headLine);
		
//		4*2
		bigCity.setText(String.format("%12s" , "시(도)=>"));
		bigCity.setFont(font);
//		bigCity.setVerticalAlignment(JLabel.EAST);
		
		secondComboBox.add(SEOUL);
		secondComboBox.add(GYEONGGI);
		secondComboBox.setPreferredSize(new Dimension(100,125));
		
		secondPanel.setBackground(new Color(15_988_609));
		secondPanel.add(bigCity);
		secondPanel.add(secondComboBox);
		secondPanel.add(secondButton);
		add(secondPanel);
		
//		4*3
		smallCity.setText(String.format("%10s" , "동(군,시)=>"));
		smallCity.setFont(font);
		thirdComboBox.setPreferredSize(new Dimension(100,125));
		thirdPanel.setBackground(new Color(3_079_834));
		
		thirdPanel.add(smallCity);
//		thirdPanel.add(thirdComboBox);
		thirdPanel.add(smallCityList);
		thirdPanel.add(thirdButton);
		
		add(thirdPanel);
		
		
//		4*4
		showLabel.setFont(new Font("나눔고딕", Font.ITALIC , 20));
		showLabel.setText("주소가 표시됩니다.");
		showLabel.setHorizontalAlignment(JLabel.CENTER);
		showLabel.setPreferredSize(new Dimension(400,100));
		showLabel.setBackground(new Color(15_519_477));
		showLabel.setForeground(new Color(3_054_334));
		showLabel.setOpaque(true);
		
		fourthPanel.add(showLabel, BorderLayout.SOUTH);
		fourthPanel.add(thirdButton);
		add(fourthPanel);
		
		secondButton.addActionListener(this);
		thirdButton.addActionListener(this);
			
		setVisible(true);
	}
	
	public static void main(String[] args) {
		ComboAndListBoxExer window = new ComboAndListBoxExer();
	}
	
	
	public void saveSmallCity(String [] cities) {
		for (int i = 0; i < cities.length; i++) {
			smallCityList.add(cities[i]);
		}
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		String [] seoulCites = {"동대문구", "강남구","서초구","중구","양천구","서대문구","종로구",
				"구로구", "광진구"};
		
		String [] ggiCites = {"안산시","남양주시","가평군","양평군","일산시","고양시","파주시","수원시"
				,"화성시","부천시"};
		
		JButton button = (JButton)e.getSource();
		if (button == secondButton) {
//			thirdComboBox.removeAll();
			smallCityList.removeAll();
			switch (secondComboBox.getSelectedIndex()) {
				case 0:
					saveSmallCity(seoulCites);
					break;
				case 1:
					saveSmallCity(ggiCites);
					break;
	
				}
		}else {
			String msg = "당신이 사는 곳은 " + secondComboBox.getSelectedItem() +" " + smallCityList.getSelectedItem()
						+ " 입니다.";
			showLabel.setText(msg);
		}
		
	}


}
