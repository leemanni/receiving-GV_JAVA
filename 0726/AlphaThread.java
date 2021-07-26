package com.leemani.exercise;

public class AlphaThread  implements Runnable{

	@Override
	public void run() {
		
		
		for(char c = 'a' ; c <= 'z' ; c ++) {
			System.out.print(c + " ");
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		
		
	}

}
