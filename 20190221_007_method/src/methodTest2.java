
public class methodTest2 {
	public static void main(String[] args) {
		//MethodTestFull();
		int iNum = Add(4, 5);
		System.out.println(iNum);
		int[] iArray = ArrayReturnTest();
		for (int iTest : iArray) {
			System.out.println(iTest);	
		}
		
	}
	static void MethodTest2(int iNum, String sString) {
		System.out.println("Test2 : ["+iNum+"]"+"["+sString+"]");
		System.out.println("Test2 : 변환값 없습니다.");
		return;
	}
	
	static int MethodTest3() {
		System.out.println("Test3 : 인자/인수/매개변수 없음");
		System.out.println("Test3 : 반환값  100");
		
		return 100;
	}
	
	static int MethodTest4(int iNum, String sString) {
		System.out.println("Test4 : ["+iNum+"]"+"["+sString+"]");
		System.out.println("Test4 : 반환값있음.");
		
		return iNum + 1;
	}
	
	static void MethodTestFull() {
		MethodTest2(100, "내가바보임");
		int iNum = MethodTest3();
		System.out.println("함수의 반환 값 : ["+iNum+"]");
		iNum = MethodTest4(999, "내가천재임");
		System.out.println("함수의 반환 값 : ["+iNum+"]");
	}
	
	static int Add(int iNum1, int iNum2) {
		return iNum1 + iNum2;
	}
	
	static int[] ArrayReturnTest() {
		int[] Temp = {10, 50, 30, 20, 11};
		return Temp;
	}
}
