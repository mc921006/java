import java.util.Scanner;

public class add2 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int x; int y; int z;
		
		System.out.print("첫번째 숫자를 입려 : ");
		x = input.nextInt();
		System.out.print("두번째 숫자를 입려 : ");
		y = input.nextInt();

		z = x+y;
		System.out.print(z);
	}
}