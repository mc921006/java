
public class WeaponOverriding {
	public static void main(String[] args) {
		Weapon weapon;
		weapon = new Weapon();
		System.out.println("기본 무기 살상 능력은 : " + weapon.fire());
		
		weapon = new Cannon();
		System.out.println("대포 살상 능력은 : " + weapon.fire());
	}
}

class Weapon {
	protected int fire() {
		return 1;
	}
}

class Cannon extends Weapon {
	protected int fire() {
		return 10;
	}
}
