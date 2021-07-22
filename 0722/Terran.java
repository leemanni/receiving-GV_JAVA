package exercise.maker;

public interface Terran {
	public int attack(Unit unit) ;
}

interface Mechainic {

}

class Marine extends Unit implements Terran {

	public Marine() {
		super(50);
		System.out.println(toString() + " 생산 완료");
	}

	@Override
	public int attack(Unit unit) {
		unit.current_HP-=15;
		System.out.println(this.toString() +"이 " + unit +" 공격!" );
		return unit.current_HP;
	}

	@Override
	public String toString() {
		return "Marine ";
	}
	

}

class Tank extends Unit implements Terran, Mechainic {

	public Tank() {
		super(200);
		System.out.println(toString() + " 생산 완료");
	}

	@Override
	public int attack(Unit unit) {
		unit.current_HP -= 7;
		System.out.println(this.toString() +"이 " + unit +" 공격!" );
		return unit.current_HP;
	}

	@Override
	public String toString() {
		return "Tank";
	}
	

}

class SCV extends Unit implements Terran {

	public SCV() {
		super(75);
		System.out.println(toString() + " 생산 완료");
	}

	public void repair(Mechainic mechainic) {
		Unit unit = (Unit) mechainic;
		while (unit.current_HP <= unit.HP) {

			unit.current_HP ++;
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		System.out.println(unit + "수리 완료");
	}

	@Override
	public int attack(Unit unit) {
		unit.current_HP -= 1;
		System.out.println(this.toString() +"이 " + unit +" 공격!" );
		return unit.current_HP;
	}

	@Override
	public String toString() {
		return "SCV";
	}
	
}
