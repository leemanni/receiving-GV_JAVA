package com.leemani.exercise;

public class Car<T extends Meterial> {
	
	private T meterial;

	public T getMeterial() {
		return meterial;
	}

	public void setMeterial(T meterial) {
		this.meterial = meterial;
	}
	
	
}
