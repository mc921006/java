import java.util.Scanner;

public class ch05 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("2���� ������ �Է��ϼ��� : ");
		int num1 = scanner.nextInt();
		int num2 = scanner.nextInt();
		
		if (num1 > num2) {
			System.out.println(num1+"-"+num2+"="+(num1-num2));
		}else if (num1 < num2) {
			System.out.println(num2+"-"+num1+"="+(num2-num1));
		}else {
			System.out.println("������ �Է��ϼ���");
		}
	}
}
