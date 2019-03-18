import java.util.Scanner;

public class ch05 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("2개의 정수를 입력하세요 : ");
		int num1 = scanner.nextInt();
		int num2 = scanner.nextInt();
		
		if (num1 > num2) {
			System.out.println(num1+"-"+num2+"="+(num1-num2));
		}else if (num1 < num2) {
			System.out.println(num2+"-"+num1+"="+(num2-num1));
		}else {
			System.out.println("정수를 입력하세요");
		}
	}
}
