import java.util.Scanner;

public class add2 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int x; int y; int z;
		
		System.out.print("ù��° ���ڸ� �Է� : ");
		x = input.nextInt();
		System.out.print("�ι�° ���ڸ� �Է� : ");
		y = input.nextInt();

		z = x+y;
		System.out.print(z);
	}
}