package com.leemani.game;

public class BGMThread implements Runnable{

	@Override
	public void run() {
		
		while(true) {
			
			
			System.out.println("빠밤빠 ♬~~");
			
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
}
