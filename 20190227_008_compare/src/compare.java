import java.util.Scanner;
public class compare {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("TT tt�� �Է��ϼ��� : ");
		String rName = scanner.nextLine();
		if (rName.equals("TT tt")) {
			System.out.println("����� �Է�����");
		}
		else {
			System.out.println("�߸��� �Է�.");
		}
		System.out.println("["+rName+"]");
	}
}

