import java.util.Scanner;

public class ch06 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int num = 1;
		int count = 0;
		int sum = 0;
		while (num != 0) {
			System.out.print("정수를 입력하세요 : ");
			num = scanner.nextInt();
			sum += num;
			count ++;
		}
		System.out.println("총 "+(count-1)+"만큼의 평균은 " + sum/(count-1));
	}
}	

