import java.util.Scanner;

public class starTest {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("������ �Է��ϼ��� : ");
		int input = scanner.nextInt();
		
		for (int i = 0; i <= input+i; i++) {
			for (int j = 0; j < input; j++) {
				System.out.print("*");
			}			
			input--;
			System.out.println();
		}
		scanner.close();
	}
}
