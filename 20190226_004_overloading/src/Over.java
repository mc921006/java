
public class Over {
	//메소드 오버로딩
	static void OverTest() {
		System.out.println("OverTest");
	}
	
	static void OverTest(int iNum) {
		System.out.println("OverTest(int iNum)");
	}
	
	static void OverTest(double dNum1) {
		System.out.println("OverTest(double dNum1)");
	}
	
	static void OverTest(int iNum1, int iNum2) {
		System.out.println("OverTest(int iNum1, int iNum2)");
	}
	
	static void OverTest(double dNum1, double dNum2) {
		System.out.println("OverTest(double dNum1, double dNum2)");
	}
	
	static void OverTest(double dNum, int iNum) {
		System.out.println("OverTest(double dNum, int iNum)");
	}
	
	static void OverTest(int iNum, double dNum) {
		System.out.println("OverTest(int iNum, double dNum)");
	}
	
	public static void main(String[] args) {
		OverTest();
		OverTest(1);
		OverTest(1.1);
		OverTest(1, 1);
		OverTest(1.1, 1.1);
		OverTest(1, 1.1);
		OverTest(1.1, 1);
	}
}
