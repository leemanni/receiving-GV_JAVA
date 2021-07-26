package com.leemani.exercise;

public class DigitThread extends Thread {
	@Override
	public void run() {
		for (int i = 0; i < 25; i++) {
			System.out.print(i + " ");
			try {
				sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
