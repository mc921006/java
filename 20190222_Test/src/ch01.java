import java.util.*;
public class ch01 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("������ �Է��ϼ��� : ");
		int num = scanner.nextInt();
		
		if (num % 2 == 0 && num != 0) {
			System.out.println("¦���Դϴ�.");
		}else if (num == 0){
			System.out.println("����");
		}else {
			System.out.println("Ȧ���Դϴ�.");
		}
	}
}