package com.leemanni.exer2;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class ClientExer2 {
	public static void main(String[] args) {
		Socket socket = null;
		PrintWriter printWriter = null;
		Scanner scanner = null;
		Scanner keyScan =null;
		
		try {
			System.out.println("서버와 연결 대기중");
			socket = new Socket("172.30.1.40", 10004);
			printWriter = new PrintWriter(socket.getOutputStream());
			scanner = new Scanner(socket.getInputStream());
			keyScan = new Scanner(System.in);
			System.out.println("서버와 연결 연결 완료");
			
			String msg ="";
			do {
				msg = scanner.nextLine();
				System.out.print("Client>>" + msg +"\n");
				
				
				if(msg.toUpperCase().equals("BYE")) {
					break;
				}
				
				
				
				System.out.print("Server>>");
				msg = keyScan.nextLine().trim();
				printWriter.write(msg+ "\n");
				printWriter.flush();
				
				
			} while (! msg.toUpperCase().equals("BYE"));
			System.out.println("연결이 종료되었습니다.");
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
		} catch (IOException e) {
			// TODO Auto-generated catch block
		}finally {
			if(socket != null) {try {socket.close();} catch (IOException e) {e.printStackTrace();}}
		}
		
		
		
	}
}
