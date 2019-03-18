import java.util.Scanner;
public class compare {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("TT tt를 입력하세요 : ");
		String rName = scanner.nextLine();
		if (rName.equals("TT tt")) {
			System.out.println("제대로 입력햇음");
		}
		else {
			System.out.println("잘못된 입력.");
		}
		System.out.println("["+rName+"]");
	}
}

