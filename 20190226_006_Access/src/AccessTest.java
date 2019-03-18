public class AccessTest {
	public static void main(String[] args) {
		Access rAccess = new Access();
		Temp temp = new Temp();
		rAccess.publicA = 100;
		rAccess.protectedA = 101;
		//rAccess.privateA = 102; //클래스 내부에서만 사용가능.
		rAccess.SetprivateA(102);
		rAccess.defalutA = 103;
		temp.iPublic = 100;
		System.out.println("rAccess.publicA : "+rAccess.publicA);
		System.out.println("rAccess.protectedA : "+rAccess.protectedA);
		System.out.println("rAccess.privateA : "+rAccess.GetprivateA());
		System.out.println("rAccess.defalutA : "+rAccess.defalutA);
	}
}

class Temp{
	public int iPublic;
	private int iPrivate;
}
