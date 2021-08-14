package com.leemanni.exer;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Client extends JFrame implements Runnable , ActionListener{
//	172.30.1.40 => IP 주소
	Socket socket = null;
	Scanner scanner = null;
	PrintWriter printWriter = null;

	JLabel chatBoard = new JLabel(); // 채팅내용을 보여주는 라벨

	JPanel panel = new JPanel(new BorderLayout()); // 텍스트 필드 + 버튼 담아주는 패널
	JTextField textField = new JTextField();
	JButton button = new JButton("전송");
	String message ="";

	public Client() {
		setTitle("Client - Chat");
		setBounds(400, 100, 400, 700);

		chatBoard.setBackground(Color.pink);
		chatBoard.setForeground(Color.black);
		chatBoard.setOpaque(true);
		chatBoard.setPreferredSize(new Dimension(400, 600));
		chatBoard.setVerticalAlignment(JLabel.TOP);

		panel.setPreferredSize(new Dimension(400, 100));

		textField.setPreferredSize(new Dimension(300, 100));

		textField.setEnabled(false);
		button.setEnabled(false);
		panel.add(textField);
		panel.add(button, BorderLayout.EAST);
		
		button.addActionListener(this);
		textField.addActionListener(this);

		add(chatBoard);
		add(panel, BorderLayout.SOUTH);

		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				int result = JOptionPane.showConfirmDialog(panel, "종료하시겠습니까?", "종료안내", JOptionPane.YES_NO_OPTION);
				if(result == 0) {
					printWriter.write("클라이언트 님이 나갔습니다");
					printWriter.flush();
					System.exit(0);
				}else {
					setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
				}
			}
		});
		setVisible(true);
	}

	public static void main(String[] args) {
		Client clientWindow = new Client();

		try {
//		서버 시작
			clientWindow.socket = new Socket("172.30.1.40", 10004);

//		서버 연결 성공 메세지
			clientWindow.message += "서버와 연결 성공<br>";
			clientWindow.chatBoard.setText("<html>" +clientWindow.message +"</html>");

//		연결 성공시 채팅창 버튼과 텍스트 필드 활성화
			clientWindow.button.setEnabled(true);
			clientWindow.textField.setEnabled(true);
			clientWindow.textField.requestFocus();

//		메세지 송수신을 위한 printwrite 와 scanner 선언
			clientWindow.printWriter = new PrintWriter(clientWindow.socket.getOutputStream());
			clientWindow.scanner = new Scanner(clientWindow.socket.getInputStream());

			Thread thread = new Thread(clientWindow);
			thread.start();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	// 메세지를 보내주는 기능
	@Override
	public void actionPerformed(ActionEvent e) {
		String msg = textField.getText().trim() ;
		if(msg.length() != 0) {
			message = message + "Client>>" + msg +"<br>";
			chatBoard.setText("<html>" + message + "</html>");
			if(printWriter != null) {
				printWriter.write(msg + "\n");
				printWriter.flush();
			}
		}
		textField.setText("");
		textField.requestFocus();
	}

	// 메세지를 받아주는 기능
	@Override
	public void run() {
		
		while(socket != null) {
			String msg = "";
			try {
				msg = scanner.nextLine().trim();
			} catch (Exception e) {
				break;
			}
			if(msg.length()>0) {
				message = message + "Server>> " + msg + "<br>";
				chatBoard.setText("<html>" + message +"</html>");
				if(msg.toLowerCase().equals("bye")) {
					break;
				}
			}
			try {Thread.sleep(100);} catch (InterruptedException e) {}
		}
		textField.setEnabled(false);
		button.setEnabled(false);
		if(socket != null) {try {socket.close();} catch (IOException e) {e.printStackTrace();}}

	}
}
