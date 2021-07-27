package com.leemani.ThreadPra;

public class SynchronizedBlockTest {

	public static void main(String[] args) {
		ShareArea area = new ShareArea();
		TransferThread thread = new TransferThread();
		thread.shareArea = area;
		thread.start();
		
//		try {
//			Thread.sleep(1000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
		PrintThread printThread = new PrintThread();
		printThread.shareArea = area;
		printThread.start();
	}
}
