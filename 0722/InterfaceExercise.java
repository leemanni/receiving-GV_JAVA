package exercise;

public class InterfaceExercise {
	public static void main(String[] args) {
		int money = 20_000_000;
		Building building = new House_Lee();
		
		building.billElectrocity(money);
		building.billGas(money);
		building.billWater(money);
	}
	
}
