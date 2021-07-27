package com.leemani.ThreadPra.copy;

public class Bank {
	private int money = 10000;
	
	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

		// 입금 메소드
		public synchronized void saveMoney(int saveMoney) {
			setMoney(getMoney() + saveMoney);
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		// 출금 메소드
		public synchronized void withdraw(int outMoney) {
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (outMoney > money) {
				System.out.println("잔액이 부족합니다");
				return ;
			} else {
				setMoney(getMoney() - outMoney);;
			}
		}
}
