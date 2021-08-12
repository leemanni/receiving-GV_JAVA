package com.leemanni.exer;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServerExer {
	public static void main(String[] args) {
		ServerSocket sever;
		Socket socket;
		PrintWriter printWriter = null;
		Scanner scanner = null;
				
		try {
			System.out.println("클라이언트와의 연결을 대기중");
			sever = new ServerSocket(10004);
			socket =  sever.accept();
			printWriter = new PrintWriter(socket.getOutputStream());
			scanner = new Scanner(socket.getInputStream());
			System.out.println("클라이언트 연결 완료");
			printWriter.write("반갑습니다 클러이언트님\n");
			printWriter.flush();
			
			System.out.println(scanner.nextLine());
			
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
}
