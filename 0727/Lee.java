package com.leemani.ThreadPra.copy;


public class Lee extends Thread {
	@Override
	public void run() {
		System.out.println("start");
		SynchronizedMethodTest.myBank.saveMoney(1000);
		System.out.println("saveMoney(1_000) : " + SynchronizedMethodTest.myBank.getMoney());
	}
}
