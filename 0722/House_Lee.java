package exercise;

public class House_Lee extends House {
	@Override
	public void billElectrocity(int money) {
		money -= money*TAX_REFUND_RATIO;
		System.out.printf("환급금 : %,d \n", money);
	}

	@Override
	public void billGas(int money) {
		money -= money*TAX_REFUND_RATIO*0.1;
		System.out.printf("환급금 : %,d \n" ,money);
	}


}
