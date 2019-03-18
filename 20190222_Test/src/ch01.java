import java.util.*;
public class ch01 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("정수를 입력하세요 : ");
		int num = scanner.nextInt();
		
		if (num % 2 == 0 && num != 0) {
			System.out.println("짝수입니다.");
		}else if (num == 0){
			System.out.println("제로");
		}else {
			System.out.println("홀수입니다.");
		}
	}
}