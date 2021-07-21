package com.leemani.exercise;

import java.util.ArrayList;

abstract class Stock {
	// 추상 매서드는 어차피 오버라이드 해야함으로 {} 블록을 사용하지 않는다.
	abstract public void businessModel();

	abstract public void profit();

	abstract public void kindOf();

	// 템플릿 메소드 final static 인 정적 메소드 => 하나의 시나리오가 짜여져 있고 자식클래스에서
	// 오버라이드 하지 못하게 막아줌
	final public void showInfo() {
		businessModel();
		profit();
		kindOf();
	}
}

class Kakao extends Stock {
// 추상클래스를 상속받은 자식 클래스는 추상클래스 안의 추상메서드는 무조건 오버라이딩 해야한다.
	@Override
	public void businessModel() {
		// TODO Auto-generated method stub
		System.out.println("엔터테이먼트");
		System.out.println("톡비즈");
		System.out.println("광고");
	}

	@Override
	public void profit() {
		System.out.println("주로 톡비즈에서 매출이 발생");

	}

	@Override
	public void kindOf() {
		System.out.println("IT 기업");
	}

	public void say() {
		System.out.println("kakao");
	}

}

class Asml extends Stock {

	@Override
	public void businessModel() {
		System.out.println("반도체 전공정 EUV");
	}

	@Override
	public void profit() {
		System.out.println("EUV 장비를 반도체 제조 업체에 판매");

	}

	@Override
	public void kindOf() {
		System.out.println("반도체 장비 기업");

	}

	public void say() {
		System.out.println("Asml");
	}

}

public class AbstractClassTest {
	public static void main(String[] args) {
		ArrayList<Stock> stockList = new ArrayList<Stock>();

		// upcasting => 부모 타입의 객체에 자식 클래스의 주소값을 할당받는다.
		// 반대로 자식 타입의 객체에 부모 클래스의 주소값을 새로 할당받는 건 문법 오류!
		Stock stock1 = new Kakao();
//		stock1.businessModel();
//		System.out.println("================");
//		stock1.profit();
//		System.out.println("================");
//		stock1.kindOf();
		Stock stock2 = new Asml();
		stockList.add(stock1);
		stockList.add(stock2);

		for (Stock stock : stockList) {
			stock.showInfo();
		}
		System.out.println("+=============================================+");
		for (int i = 0; i < stockList.size(); i++) {
			Stock stock = stockList.get(i);
			if (stock instanceof Kakao) {
				Kakao kakao = (Kakao) stock;
				kakao.say();
			} else if (stock instanceof Asml) {
				Asml asml = (Asml) stock;
				asml.say();
			} else {
				System.out.println("다운캐스팅 불가");
			}
		}

		new AbstractClassTest().downCasting(stockList);
	}

	public void downCasting(ArrayList<Stock> stockList) {
		for (int i = 0; i < stockList.size(); i++) {
			Stock stock = stockList.get(i);
			if (stock instanceof Kakao) {
				Kakao kakao = (Kakao) stock;
				kakao.say();
			} else if (stock instanceof Asml) {
				Asml asml = (Asml) stock;
				asml.say();
			} else {
				System.out.println("다운캐스팅 불가");
			}
		}
	}
}
