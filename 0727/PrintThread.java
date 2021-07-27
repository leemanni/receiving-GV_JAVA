package com.leemani.ThreadPra;

public class PrintThread extends Thread{
	ShareArea shareArea = null;
	
	
	public PrintThread() {
	}
			
			
	public PrintThread(ShareArea shareArea) {
		this.shareArea = shareArea;
	}
	
	@Override
	public void run() {
		synchronized (shareArea) {
			
			for (int i = 0; i < 20; i++) {
				int sum = shareArea.lee.getMoney() + shareArea.park.getMoney();
				System.out.println("예금합계" + sum);
			}
			
			
			
			
		}
		
		
	}
			
			
	
}
