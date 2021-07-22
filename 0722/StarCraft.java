package exercise.maker;


public class StarCraft {
	public static void main(String[] args) {
		Tank tank = new Tank();
		Marine marine = new Marine();
		SCV scv =  new SCV();
		
		System.out.println("==================================");
		scv.attack(tank);
		marine.attack(tank);
		scv.repair(tank);
	}
}
