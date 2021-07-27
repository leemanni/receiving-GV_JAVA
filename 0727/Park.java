package com.leemani.ThreadPra.copy;

public class Park extends Thread {
	@Override
	public void run() {
	System.out.println("start minus");
	SynchronizedMethodTest.myBank.withdraw(1_000);
	System.out.println("minusMoney(1_000) : " + SynchronizedMethodTest.myBank.getMoney());
	}
}
