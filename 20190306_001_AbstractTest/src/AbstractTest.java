
public class AbstractTest {
	public static void main(String[] args) {
		//Abstrac aAbstrac = new Abstrac();
		Abstrac1 aAbstrac = new Abstrac1();
		aAbstrac.print();
	}
}

abstract class Abstrac { //�߻� Ŭ����
	public void print() {
		System.out.println("Abstrac::print");
	}
}

class Abstrac1 extends Abstrac {
	
}

