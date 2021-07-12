package stock;

public class StockView {
	public static void main(String[] args) {
		StockModule leeStocks = new StockModule("카카오", 54768, 160500);
		leeStocks.insert("삼성전자", 64280, 72300);
		leeStocks.view();
	}
}
