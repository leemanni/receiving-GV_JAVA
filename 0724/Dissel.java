package com.leemani.exercise;

public class Dissel extends Meterial {

	@Override
	void doEnginStart() {
		System.out.println("경유 차로 시동 켜기");
	}

	@Override
	public String toString() {
		return "이 차량은 Dissel 입니다.";
	}
	
	
}
