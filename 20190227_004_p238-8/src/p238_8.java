
public class p238_8 {
	public static void main(String[] args) {
		Power robot = new Power();
		robot.print(20, 30);
		Power robot1 = new Power(10, 20);
	}
}

class Power {
	public int kick;
	public int punch;
	
	Power () {
		System.out.println("생성자임");
	}
	
	Power (int k, int p) {
		kick = k;
		punch = p;
		System.out.println(kick+" "+punch);
	}
	
	void print(int k, int p) {
		kick = k;
		punch = p;
		System.out.println(kick+" "+punch);
	}
}
