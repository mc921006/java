import java.util.Scanner;

public class ch02 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("�⵵�� �Է��ϼ��� : ");		
		int year = scanner.nextInt();
		if (year < 0) {
			System.out.println("�⵵�� �ٽ� �Է����ּ���");
			year = scanner.nextInt();
		}
		else if (year % 100 == 0 || year % 4 == 0) {
			System.out.println(year +"�⵵�� �����Դϴ�.");
		}
		else {
			System.out.println(year+"�� ������ �ƴմϴ�.");
		}
		
	}
}
