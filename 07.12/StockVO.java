package stock;


public class StockVO {
	private String name; // 종목명
	private int pPrice ; // 매입단가
	private int cPrice ; // 현재 단가
	private float profitRatio; // 수익률
	private int ownStocks; // 보유 주식 수
	private int totalpPrice; // 총 매입 금액
	private int totalcPrice; // 총 평가금액
	
	public StockVO() {;}
	
	public StockVO(String name, int pPrice, int cPrice, int ownStocks) {
		this.name = name;
		this.pPrice = pPrice;
		this.cPrice = cPrice;
		this.ownStocks = ownStocks;
		profitRatio = ((float)cPrice - pPrice)  / pPrice *100 ;
		totalcPrice = cPrice * ownStocks;
		totalpPrice = pPrice * ownStocks;
	}
	
	
	// # name
	public String getName() {
		return name;
	}

	public int getTotalpPrice() {
		return totalpPrice;
	}

	
	// # totalpPrice
	public void setTotalpPrice(int totalpPrice) {
		this.totalpPrice = totalpPrice;
	}

	public int getTotalcPrice() {
		return totalcPrice;
	}

	
	// # totalcPrice
	public void setTotalcPrice(int totalcPrice) {
		this.totalcPrice = totalcPrice;
	}

	public void setName(String name) {
		this.name = name;
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
	
}
