import java.util.Scanner;

public class ch06 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int num = 1;
		int count = 0;
		int sum = 0;
		while (num != 0) {
			System.out.print("������ �Է��ϼ��� : ");
			num = scanner.nextInt();
			sum += num;
			count ++;
		}
		System.out.println("�� "+(count-1)+"��ŭ�� ����� " + sum/(count-1));
	}
}	

