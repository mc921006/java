public class ShapeTest {
	public static void main(String[] args) {
		ShapeRect rRect1 = new ShapeRect();
		ShapeRect rRect2 = new ShapeRect(10, 20);

		System.out.println("rRect1의 넓이 : "+rRect1.GetArea());
		System.out.println("rRect2의 넓이 : "+rRect2.GetArea());
	}
}

class ShapeRect {
	public int width;
	public int height;
	
	// 오버로딩 : 메소드 이름이 동일하지만 매개변수/인자/인수로 구별되는 메소드
	//생성자 메소드 오버로딩
	// 인자가 없는 생성자(디폴트 생성자)
	public ShapeRect() { //생성자 : 1.클래스와 이름이 동일 / 2. 반환값이 없다.
		width = 0;
		height = 0;
	}
	
	// 인자가 있는 생성자
	//생성자 : 1.클래스와 이름이 동일 / 2. 반환값이 없다.
	public ShapeRect(int iw, int ih) { 
		width = iw;
		height = ih;
	}

	public int GetArea() {
		return width*height;
	}
}
