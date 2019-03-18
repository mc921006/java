import java.util.Scanner;

public class first2 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);		
		System.out.print("출력할 구구단 수를 입력하세요.");
		int idan = scanner.nextInt();
		System.out.println(idan+"단의 구구단은");
		System.out.println(idan+"* 1 = "+ idan*1 );
		System.out.println(idan+"* 2 = "+ idan*2 );
		System.out.println(idan+"* 3 = "+ idan*3 );
		System.out.println(idan+"* 4 = "+ idan*4 );
		System.out.println(idan+"* 5 = "+ idan*5 );
		System.out.println(idan+"* 6 = "+ idan*6 );
		System.out.println(idan+"* 7 = "+ idan*7 );
		System.out.println(idan+"* 8 = "+ idan*8 );
		System.out.println(idan+"* 9 = "+ idan*9 );
	}
}