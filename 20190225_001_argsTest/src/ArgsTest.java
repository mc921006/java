
public class ArgsTest {
	public static void main(String[] args) {
		//		System.out.println("�Է��� ������ ���� : "+args.length);
		//		if (1 <= args.length) {
		//			System.out.println("ù��° : "+args[0]);	
		//		}
		//		if (0 == args.length) {
		//			System.out.println("����: java [-options] class [args...]");
		//		}
		//		int a = 3;
		//		int b = '3';
		//		System.out.println(a+" "+(b-48));
		//		
		//		double c = 3.14;
		//		System.out.println("c = " + c);
		//		
		//		double d = Double.parseDouble("3.14");
		//		System.out.println("d = " + d);

//		if (1 <= args.length) {
//			int iNum = Integer.parseInt(args[0]);
//			if (iNum == 0) {
//				System.out.print("�ٽ� �Է����ּ��� ");
//				return;
//			}
//			iNum = 100/iNum;
//			System.out.println("iNum = "+iNum);
//		}
		
		if (1 <= args.length) {
			int iNum = Integer.parseInt(args[0]);
			try {
				iNum = 100/iNum;
				System.out.println("iNum = "+iNum);
			} catch (ArithmeticException e) {
				System.out.println("�ٽ� �Է����ּ��� ");
			}
			finally {
				System.out.println("finally�� ����");
			}
			System.out.println("if�� ��");

		}
	}
}
