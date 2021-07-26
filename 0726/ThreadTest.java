package com.leemani.exercise;

public class ThreadTest {
	public static void main(String[] args) {
		
		// # 1
		// Thread 클래스를 상속받은 멀티쓰레드 구현
		DigitThread di  =  new DigitThread();
		di.start();
		
		//#2
		//Runnable 인터페이스를 구현받은 멀티 쓰레드
		Thread thread = new Thread(new AlphaThread());
		
		thread.run();
		
		
		try {
			thread.join();
			di.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("\nHI~");
	}
}
