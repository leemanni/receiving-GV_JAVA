package com.leemani.ThreadPra;

public class TransferThread extends Thread {

	ShareArea shareArea = null;

	public TransferThread() {
		// TODO Auto-generated constructor stub
	}

	public TransferThread(ShareArea shareArea) {
		this.shareArea = shareArea;
	}

	@Override
	public void run() {
		
		synchronized (shareArea) {
			
			for (int i = 0; i < 20; i++) {
				shareArea.lee.saveMoney(100000);
				if(shareArea.park.withdraw(100000) != 0) {
					System.out.println("성공!");
				}
				
				try {
					sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
				
			}
			
			
			
		}
		
	}

}
