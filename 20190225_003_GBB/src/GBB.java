import java.util.*;

public class GBB {
	public static void main(String[] args) {
		Random refRandom = new Random();
		Scanner refScanner = new Scanner(System.in);
		
		int iRandom;
		
//		for (int i = 0; i < 5; i++) {
			iRandom = refRandom.nextInt(3);
//			System.out.println(iRandom);
//		}
		System.out.println("가위, 바위, 보를 고르시요");
		String refInput = refScanner.next();
		
		switch (iRandom) {
		case 0:
			System.out.println("컴퓨터 : 가위");
			break;
		case 1:
			System.out.println("컴퓨터 : 바위");
			break;			
		case 2:
			System.out.println("컴퓨터 : 보");
			break;
		default:
			break;
		}
		System.out.println("사용자 : " + refInput);
	}
}
