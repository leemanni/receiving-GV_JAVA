package exercise;

public abstract class House implements Building{

	@Override
	public void billWater(int money) {
		System.out.println("수도 요금은 무료" + 0 +"원");
		
	}
	
}
