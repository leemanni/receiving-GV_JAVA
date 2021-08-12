package com.leemanni.exer;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class ClientExer {
	public static void main(String[] args) {
		Socket socket;
		PrintWriter printWriter = null;
		Scanner scanner = null;
		
		try {
			System.out.println("서버와 연결 대기중");
			socket = new Socket("172.30.1.40", 10004);
			printWriter = new PrintWriter(socket.getOutputStream());
			scanner = new Scanner(socket.getInputStream());
			System.out.println("서버와 연결 연결 완료");
			
			System.out.println(scanner.nextLine());
			
			printWriter.write("반가워요 서버님");
			printWriter.flush();
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
		} catch (IOException e) {
			// TODO Auto-generated catch block
		}
		
		
		
	}
}
