
public class CarInfo {
	public static void main(String[] args) {
		Car car1 = new Car("��1", "red", 1);
		Car car2 = new Car("��2", "blue", 2);
		Car car3 = new Car("��3", "black", 3);
		car1.printtype();
		car1.printColor();
		car1.printNum();

		car2.printtype();
		car2.printColor();
		car2.printNum();
		
		car3.printtype();
		car3.printColor();
		car3 .printNum();
	}
}

class Vehiecle {
	private String type;
	protected String color;
	
	public Vehiecle(String atype, String acolor ) {
		type = atype;
		color = acolor;
		System.out.println("Vehiecle�� ������ ȣ��");
	}
	
	protected void printColor() {
		System.out.println("�� : "+ color);
	}
	
	protected void printtype() {
		System.out.println("Ÿ�� : "+ type);
	}
}

class Car extends Vehiecle {
	private int numberOfPerson;
	
	public Car(String atype, String acolor, int num) {
		super(atype, acolor); //�θ�(Vehiecle) ������ ���� ȣ��.
		numberOfPerson = num;
		System.out.println("car�� ������ ȣ��");
	}
	
	public void printNum() {
		System.out.println("��ȣ : " + numberOfPerson);
	}

	
	
	
}