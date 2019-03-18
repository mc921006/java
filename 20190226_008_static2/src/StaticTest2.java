
public class StaticTest2 {
	
	int iNum2 = 200;
	static int iNum3 = 300;
	
	public static void main(String[] args) {
		int iNum1 = 100;
		
		StaticTest2 rStaticTest2 = new StaticTest2();
		System.out.println(iNum1);
		System.out.println(rStaticTest2.iNum2);
		System.out.println(iNum3);
	}
}
