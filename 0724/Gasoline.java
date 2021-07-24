package com.leemani.exercise;

public class Gasoline extends Meterial {

	@Override
	void doEnginStart() {
		System.out.println("휘발유 차로 시동 켜기");
	}

	@Override
	public String toString() {
		return " 이 차량은 Gasoline";
	}
	

}
