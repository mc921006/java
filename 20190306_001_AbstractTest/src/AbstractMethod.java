
public class AbstractMethod {
	public static void main(String[] args) {
		Abstrac3 aAbstrac3 = new Abstrac3(); 
		aAbstrac3.print();
		aAbstrac3.print(100);
	}
}

class Abstrac3 extends Abstrac2 {
	// �߻�Ŭ������ ��� ���� �ڽ� Ŭ������
	// �ݵ�� �θ� Ŭ������ �߻� �޼ҵ带 �����ؾ� ��.
	// �ݵ�� �θ� Ŭ������ �߻� �޼ҵ带 �������̵� �ؾ� ��.
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