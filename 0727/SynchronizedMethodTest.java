package com.leemani.ThreadPra.copy;

public class SynchronizedMethodTest {
	
	public static Bank myBank = new Bank();
	
	public static void main(String[] args) {
		Lee lee = new Lee();
		lee.start();
		
		Park park = new Park();
		park.start();
		
	}
		
	
}
