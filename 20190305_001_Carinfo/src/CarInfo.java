
public class CarInfo {
	public static void main(String[] args) {
		Car car1 = new Car("차1", "red", 1);
		Car car2 = new Car("차2", "blue", 2);
		Car car3 = new Car("차3", "black", 3);
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
		System.out.println("Vehiecle의 생성자 호출");
	}
	
	protected void printColor() {
		System.out.println("색 : "+ color);
	}
	
	protected void printtype() {
		System.out.println("타입 : "+ type);
	}
}

class Car extends Vehiecle {
	private int numberOfPerson;
	
	public Car(String atype, String acolor, int num) {
		super(atype, acolor); //부모(Vehiecle) 생성자 먼저 호출.
		numberOfPerson = num;
		System.out.println("car의 생성자 호출");
	}
	
	public void printNum() {
		System.out.println("번호 : " + numberOfPerson);
	}

	
	
	
}