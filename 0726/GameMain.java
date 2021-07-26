package com.leemani.game;

public class GameMain {
	public static void main(String[] args) {
		GameThread game = new GameThread();
		BGMThread bgm = new BGMThread();
		Thread thread =  new Thread(bgm);
		
		game.setDaemon(true);
		thread.setDaemon(true);
		game.start();
		thread.start();
		
		for (int i = 0; i < 200; i++) {
			if(i == 7) {
				break;
			}
			System.out.println(i);
			
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}
