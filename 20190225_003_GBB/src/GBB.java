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
		System.out.println("����, ����, ���� ���ÿ�");
		String refInput = refScanner.next();
		
		switch (iRandom) {
		case 0:
			System.out.println("��ǻ�� : ����");
			break;
		case 1:
			System.out.println("��ǻ�� : ����");
			break;			
		case 2:
			System.out.println("��ǻ�� : ��");
			break;
		default:
			break;
		}
		System.out.println("����� : " + refInput);
	}
}
