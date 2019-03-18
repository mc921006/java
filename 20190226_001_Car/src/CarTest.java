
public class CarTest {

	public static void main(String[] args) {
		Car myCar = new Car("빨간색", 100, 5); // 18번 라인이 불러진다.
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
		//this 메소드 호출은 맨 윗줄에 있어야함
		this("색 지정안함.", 0, 0); //성능은 20번보다 조금 좋다.
//		this("색 지정안함.");
	}
	
	Car(String rColor){
		this(rColor, 0, 0);
	}

	Car(String rColor, int iSpeed, int iGear){
		this.rColor = rColor;
		this.iSpeed = iSpeed;
		this.iGear = iGear;
		System.out.println("Car 인자 3개 호출.");
	}
	
	void print() {
		System.out.println("색 : " +rColor+"\n속도 : "
				+iSpeed+"\n기어 : " +iGear);
	}

}