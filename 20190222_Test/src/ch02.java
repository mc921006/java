import java.util.Scanner;

public class ch02 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("년도를 입력하세요 : ");		
		int year = scanner.nextInt();
		if (year < 0) {
			System.out.println("년도를 다시 입력해주세요");
			year = scanner.nextInt();
		}
		else if (year % 100 == 0 || year % 4 == 0) {
			System.out.println(year +"년도는 윤년입니다.");
		}
		else {
			System.out.println(year+"는 윤년이 아닙니다.");
		}
		
	}
}
