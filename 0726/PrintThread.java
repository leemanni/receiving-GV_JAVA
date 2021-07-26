package com.leemani.sychronized;

public class PrintThread extends Thread{
	
	ShareArea  area = null;
	
	public PrintThread() {
		// TODO Auto-generated constructor stub
	}
	public PrintThread(ShareArea area) {
		this.area = area;
	}
	
	
	@Override
	public void run() {
		System.out.println("계산중입니다...!");
		
		synchronized (area) {
			try {
				area.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("원주율 : "   + area.result);
		
		
		
		
	}
	
}
