package com.leemani.ThreadPra;

public class Account {
	private String accountNo; // 계좌번호
	private String name; // 고객이름
	private int money; // 잔액

	public Account() {
	}

	public Account(String accountNo, String name, int money) {
		this.accountNo = accountNo;
		this.name = name;
		this.money = money;
	}

	public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	// 입금 메소드
	public synchronized void saveMoney(int saveMoney) {
		money += saveMoney;
		try {
			Thread.sleep(300);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(getName() + " 님  계좌에 " + saveMoney + " 원 입금 완료!");
	}

	// 출금 메소드
	public synchronized int withdraw(int outMoney) {
		try {
			Thread.sleep(300);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (outMoney > money) {
			System.out.println("잔액이 부족합니다");
			return 0;
		} else {
			money -= outMoney;
			return money;
		}
	}

}
