
public class InterfaceEx {
	public static void main(String[] args) {
		SmartPhone phone = new SmartPhone();
		phone.printLogo();
		phone.sendCall();
		phone.play();
		System.out.println("3�� 5�� ���ϸ� "+phone.calculate(3, 5));
		phone.schedule();
	}
}

interface PhoneInterface { //�������̽� ����
	final int TIMEOUT = 10000; //��� �ʵ� ����
	void sendCall(); //�߻� �޼ҵ�
	void receiveCall(); //�߻� �޼ҵ�
	default void printLogo() { //default �޼ҵ�
		System.out.println("** phone **");
	}
}
//�������̽� ���
interface MobilePhoneInterface extends PhoneInterface {
	void sendSMS();
	void receiveSMS();
}

interface MP3Interface { //�������̽� ����
	public void play();
	public void stop();
}

class PDA { // Ŭ���� �ۼ�
	public int calculate(int x, int y) {
		return x + y;
	}
}
//SmartPhone Ŭ������ PDA�� ��ӹް�,
//MobilePhoneInterface�� MP3Interface �������̽��� ����� �߻� �޼ҵ带 ��� �����Ѵ�.
class SmartPhone extends PDA 
		implements MobilePhoneInterface, MP3Interface {
	//MobilePhoneInterface�� �߻� �޼ҵ� ����.
	@Override
	public void sendCall() {
		System.out.println("������������~~");
	}

	@Override
	public void receiveCall() {
		System.out.println("��ȭ �Ծ��.");
	}
	
	@Override
	public void sendSMS() {
		System.out.println("���� ����.");
	}

	@Override
	public void receiveSMS() {
		System.out.println("���� �Դ�.");		
	}
	//MP3Interface�� �߻� �޼ҵ� ����.
	@Override
	public void play() {
		System.out.println("���� ����.");
	}
	// �߰��� �ۼ��� �޼ҵ�
	@Override
	public void stop() {
		System.out.println("���� �ߴ�.");
	}

	
	
	public void schedule() {
		System.out.println("���� �����Ѵ�.");
	}
	
}