import java.util.Scanner;

public class BreakEx {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("exit를 입력하면 종료");
		while (true) {
			System.out.print(">>");
			String text = scanner.nextLine();
			if (text.equals("exit")) {
				break;
			}
		}
		System.out.println("종료한다.");
	}

}
