
public class ArgsTest {
	public static void main(String[] args) {
		//		System.out.println("입력한 인자의 개수 : "+args.length);
		//		if (1 <= args.length) {
		//			System.out.println("첫번째 : "+args[0]);	
		//		}
		//		if (0 == args.length) {
		//			System.out.println("사용법: java [-options] class [args...]");
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
//				System.out.print("다시 입력해주세요 ");
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
				System.out.println("다시 입력해주세요 ");
			}
			finally {
				System.out.println("finally문 실행");
			}
			System.out.println("if문 끝");

		}
	}
}
