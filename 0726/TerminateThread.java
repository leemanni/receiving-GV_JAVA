package com.leemani.useFlag;

public class TerminateThread extends Thread{
	private boolean flag;
	
	public TerminateThread() {
		// TODO Auto-generated constructor stub
	}
	public TerminateThread(String name) {
		super(name);
	}
	
	
	
	public boolean isFlag() {
		return flag;
	}
	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	
	@Override
	public void run() {
		System.out.println(getName() + "시작");
		while (!flag) {
			for(int i =0; i < 20 ; i++) {
				
				try {
					sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
			}
		}
		System.out.println(getName() + " 종료");
	}
	
}
