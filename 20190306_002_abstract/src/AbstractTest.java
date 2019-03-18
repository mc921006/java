
public class AbstractTest {
	public static void main(String[] args) {
		Abstrac1 aAbstrac = new Abstrac1();
		// 객체 참조변수는 다 만들 수 있다.
		Abstrac aAbstrac1; // 추상 클래스의 객체 참조 변수는 생성 가능
		Abstrac1 aAbstrac2; // 클래스의 객체참조변수 생성 가능 
		Abstrac2 aAbstrac3; // 추상 클래스의 객체 참조 변수는 생성 가능
		
		//aAbstrac1 = new Abstrac(); //추상클래스
		aAbstrac2 = new Abstrac1(); //추상 클래스를 구현한 클래스 생성
		//aAbstrac3 = new Abstrac2();
	}
}

abstract class Abstrac2 extends Abstrac {
	// 본인이 추상클래스가 되면 에러를 피할 수 있다.
}

class Abstrac1 extends Abstrac {
	public void print(int iNum) {
		System.out.println("Abtrac1::print" + iNum);
	}

}

abstract class Abstrac {
	abstract public void print(int iNum); //추상 메소드
	public void print() {
		System.out.println("Abtrac1::print");
	}
}

