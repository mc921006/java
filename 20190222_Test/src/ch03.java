import java.util.Scanner;

public class ch03 {
	static int cen;
	static int fah;
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("����(c) or ȭ��(f) : ");
		String temper = scanner.next();
		
		if (temper.equals("c")) {
			System.out.print("�����µ��� �Է��ϼ��� : ");
			cen = scanner.nextInt(); //����
			fah = (9*cen + 160)/ 5;
			System.out.println("�����µ� "+cen+"��(��) ȭ���µ���"+fah);
		}
		else if (temper.equals("f")) {
			System.out.print("ȭ���µ��� �Է��ϼ��� : ");
			fah = scanner.nextInt(); //ȭ��
			cen = 5*(fah - 32) / 9;
			System.out.println("ȭ���µ� "+fah+"��(��) �����µ��� "+cen);
		}
		else {
			System.out.print("c�� f�߿� �ϳ��� �Է��ϼ���");
		}
	}
}
