package com.leemani.game;

public class GameThread extends Thread {

	@Override
	public void run() {
		int i = 0;
		while(true) {
			i++;
			System.out.println("스타크레프트 게임중");
			if(i == 5) {
				System.out.println("밤 10시가 돼서 게임 종료!");
				break;
			}
			try {
				sleep(300);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	
}
