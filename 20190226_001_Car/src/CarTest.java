
public class CarTest {

	public static void main(String[] args) {
		Car myCar = new Car("������", 100, 5); // 18�� ������ �ҷ�����.
		Car myCar2 = new Car();
		myCar.print();
		myCar2.print();
	}
}

class Car {
	public String rColor;
	public int iSpeed;
	public int iGear;

	Car(){
		//this �޼ҵ� ȣ���� �� ���ٿ� �־����
		this("�� ��������.", 0, 0); //������ 20������ ���� ����.
//		this("�� ��������.");
	}
	
	Car(String rColor){
		this(rColor, 0, 0);
	}

	Car(String rColor, int iSpeed, int iGear){
		this.rColor = rColor;
		this.iSpeed = iSpeed;
		this.iGear = iGear;
		System.out.println("Car ���� 3�� ȣ��.");
	}
	
	void print() {
		System.out.println("�� : " +rColor+"\n�ӵ� : "
				+iSpeed+"\n��� : " +iGear);
	}

}