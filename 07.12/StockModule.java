package stock;

import java.util.ArrayList;

public class StockModule {
	String name; // 종목명
	int pPrice ; // 매입단가
	int cPrice ; // 현재 단가
	float profitRatio; // 수익률
	ArrayList<Object> stocks = new ArrayList<Object>();
	String returnMsg ;
	StockModule nextStock;
	
	// # 기본 생성자
	public StockModule(String name, int pPrice, int cPrice) {
		this.name = name;
		this.pPrice = pPrice;
		this.cPrice = cPrice;
		profitRatio = ((float)cPrice - pPrice)  / pPrice *100 ;
		returnMsg = name + " => " + "수익률 :  "+ String.format("%.2f%%", profitRatio) + "\n현재단가 : "+String.format("%,d", pPrice)+ 
				"\n매입단가 : " + String.format("%,d", cPrice);
		stocks.add(returnMsg);
	}
	
	
	//주식 입력
	void insert(String name, int pPrice, int cPrice) {
		if(nextStock == null) {
			nextStock = new StockModule(name,pPrice,cPrice);
			stocks.add(nextStock.returnMsg);
		}
	}
	
	void view() {
		for (int i = 0; i < stocks.size(); i++) {
			System.out.println("["+(i+1)+"]");
			System.out.println(stocks.get(i));
		}
	}
	
	

	
	
	
	
}
