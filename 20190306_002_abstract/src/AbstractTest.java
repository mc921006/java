
public class AbstractTest {
	public static void main(String[] args) {
		Abstrac1 aAbstrac = new Abstrac1();
		// ��ü ���������� �� ���� �� �ִ�.
		Abstrac aAbstrac1; // �߻� Ŭ������ ��ü ���� ������ ���� ����
		Abstrac1 aAbstrac2; // Ŭ������ ��ü�������� ���� ���� 
		Abstrac2 aAbstrac3; // �߻� Ŭ������ ��ü ���� ������ ���� ����
		
		//aAbstrac1 = new Abstrac(); //�߻�Ŭ����
		aAbstrac2 = new Abstrac1(); //�߻� Ŭ������ ������ Ŭ���� ����
		//aAbstrac3 = new Abstrac2();
	}
}

abstract class Abstrac2 extends Abstrac {
	// ������ �߻�Ŭ������ �Ǹ� ������ ���� �� �ִ�.
}

class Abstrac1 extends Abstrac {
	public void print(int iNum) {
		System.out.println("Abtrac1::print" + iNum);
	}

}

abstract class Abstrac {
	abstract public void print(int iNum); //�߻� �޼ҵ�
	public void print() {
		System.out.println("Abtrac1::print");
	}
}

