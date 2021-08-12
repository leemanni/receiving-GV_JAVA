package com.leemanni.exer2;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServerExer2 {
	public static void main(String[] args) {
		ServerSocket sever = null;
		Socket socket = null;
		PrintWriter printWriter = null;
		Scanner scanner = null;
		Scanner keyScan = null;
				
		try {
			System.out.println("클라이언트와의 연결을 대기중");
			sever = new ServerSocket(10004);
			keyScan = new Scanner(System.in);
			socket =  sever.accept();
			printWriter = new PrintWriter(socket.getOutputStream());
			scanner = new Scanner(socket.getInputStream());
			System.out.println("클라이언트 연결 완료");
			
			String msg ="";
			do {
				System.out.print("Client>>");
				msg = keyScan.nextLine().trim();
				printWriter.write(msg+ "\n");
				printWriter.flush();
				
				if(msg.toUpperCase().equals("BYE")) {
					break;
				}
				
				msg = scanner.nextLine();
				System.out.print("Client>>" + msg + "\n");
				
				
				
			} while (! msg.toUpperCase().equals("BYE"));
			System.out.println("연결이 종료되었습니다.");
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if(socket != null) {try {socket.close();} catch (IOException e) {e.printStackTrace();}}
			if(sever != null) {try {sever.close();} catch (IOException e) {e.printStackTrace();}}
		}
		
		
	}
}
