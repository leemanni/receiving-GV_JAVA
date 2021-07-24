package com.leemani.exercise;

public class GenericExercise {
	
	
	public static void main(String[] args) {
		Car<Dissel> santafe = new Car<Dissel>();
		Car<Gasoline> sonata = new Car<Gasoline>();
		sonata.setMeterial(new Gasoline());
		santafe.setMeterial(new Dissel());
		
		System.out.println(santafe.getMeterial());
		System.out.println(sonata.getMeterial());
		
	}
		
}
