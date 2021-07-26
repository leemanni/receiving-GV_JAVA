package com.leemani.sychronized;

public class SynchronizedTest {
	public static void main(String[] args) {
		
	PrintThread  printThread = new PrintThread();
	CalulatorThread calulatorThread = new CalulatorThread();
	ShareArea area = new ShareArea();
	printThread.area = area;
	calulatorThread.area =area;
	
	
	calulatorThread.start();
	printThread.start();
	
	
	}
}
