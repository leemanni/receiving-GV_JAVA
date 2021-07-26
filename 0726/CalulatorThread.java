package com.leemani.sychronized;

public class CalulatorThread extends Thread{


	ShareArea  area = null;
	
	public CalulatorThread() {
		// TODO Auto-generated constructor stub
	}
	public CalulatorThread(ShareArea area) {
		this.area = area;
	}
	
	
	@Override
	public void run() {
		long startTime = System.currentTimeMillis();
		double total = 0.0;
		
		for(int i = 1 ; i < 1000000000 ; i +=2) {
			if(i / 2 % 2 == 0) {
				total += 1.0 / i;
			}else {
				total += -1.0 / i;
			}
		}
		
		// 계산 종료 시산을 저장한다.
		long endTime = System.currentTimeMillis();
		
		area.result = total  * 4 ;
//		area.ready = true;
		System.out.println(  "연산시간 : " + (endTime - startTime)/1000 + " 초");
		
		synchronized (area) {
			area.notifyAll();
		}
	}	
}
