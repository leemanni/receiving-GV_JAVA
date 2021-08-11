package stock;


public class StockVO {
	private int idx;
	private String name; // 종목명
	private int pPrice ; // 매입단가
	private int cPrice ; // 현재 단가
	private float profitRatio =  (float)(cPrice - pPrice) / pPrice * 100; // 수익률
	private int ownStocks; // 보유 주식 수
	private int totalpPrice; // 총 매입 금액

	private int totalcPrice ; // 총 평가금액
	
	public StockVO() {
		totalcPrice = ownStocks * pPrice;
		totalcPrice = ownStocks * cPrice;
		profitRatio = (float)(cPrice - pPrice) / pPrice * 100;
	}
	
	
	
	
	@Override
	public String toString() {
		return "StockVO [idx=" + idx + ", name=" + name + ", pPrice=" + pPrice + ", cPrice=" + cPrice + ", profitRatio="
				+ profitRatio + ", ownStocks=" + ownStocks + ", totalpPrice=" + totalpPrice + ", totalcPrice="
				+ totalcPrice + "]";
	}




	public void setIdx(int idx) {
		this.idx = idx;
	}




	// # name
	public String getName() {
		return name;
	}
	

	public void setName(String name) {
		this.name = name;
	}


	// # totalpPrice
	public int getTotalpPrice() {
		return totalpPrice;
	}

	public void setTotalpPrice(int totalpPrice) {
		this.totalpPrice = totalpPrice;
	}
	

	// # totalcPrice 
	public int getTotalcPrice() {
		return totalcPrice;
	}

	public void setTotalcPrice(int totalcPrice) {
		this.totalcPrice = totalcPrice;
	}
	


	//# pPrice
	public int getpPrice() {
		return pPrice;
	}

	public void setpPrice(int pPrice) {
		this.pPrice = pPrice;
	}

	//# cPrice
	public int getcPrice() {
		return cPrice;
	}

	public void setcPrice(int cPrice) {
		this.cPrice = cPrice;
	}

	//#profitRatio
	public float getProfitRatio() {
		return profitRatio;
	}

	
	public void setProfitRatio(float profitRatio) {
		this.profitRatio = profitRatio;
	}




	//# ownStocks
	public int getOwnStocks() {
		return ownStocks;
	}

	public void setOwnStocks(int ownStocks) {
		this.ownStocks = ownStocks;
	}
	public int getIdx() {
		return idx;
	}
	
}
