
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
		System.out.println("Test2 : ��ȯ�� �����ϴ�.");
		return;
	}
	
	static int MethodTest3() {
		System.out.println("Test3 : ����/�μ�/�Ű����� ����");
		System.out.println("Test3 : ��ȯ��  100");
		
		return 100;
	}
	
	static int MethodTest4(int iNum, String sString) {
		System.out.println("Test4 : ["+iNum+"]"+"["+sString+"]");
		System.out.println("Test4 : ��ȯ������.");
		
		return iNum + 1;
	}
	
	static void MethodTestFull() {
		MethodTest2(100, "�����ٺ���");
		int iNum = MethodTest3();
		System.out.println("�Լ��� ��ȯ �� : ["+iNum+"]");
		iNum = MethodTest4(999, "����õ����");
		System.out.println("�Լ��� ��ȯ �� : ["+iNum+"]");
	}
	
	static int Add(int iNum1, int iNum2) {
		return iNum1 + iNum2;
	}
	
	static int[] ArrayReturnTest() {
		int[] Temp = {10, 50, 30, 20, 11};
		return Temp;
	}
}
