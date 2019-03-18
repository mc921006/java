
public class AbstractMethod {
	public static void main(String[] args) {
		Abstrac3 aAbstrac3 = new Abstrac3(); 
		aAbstrac3.print();
		aAbstrac3.print(100);
	}
}

class Abstrac3 extends Abstrac2 {
	// 추상클래스를 상속 받은 자식 클래스는
	// 반드시 부모 클래스의 추상 메소드를 구현해야 함.
	// 반드시 부모 클래스의 추상 메소드를 오버라이드 해야 함.
	public void print(int iNum) {
		System.out.println("Abtrac3::print" + iNum);
	}
	
}

abstract class Abstrac2 {
	abstract public void print(int iNum);
	public void print() {
		System.out.println("Abtrac3::print");
	}
}