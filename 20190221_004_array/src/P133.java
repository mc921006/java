import java.util.*;
public class P133 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int intArray[] = new int[5];
		int max = 0;
		System.out.println("��� 5���� �Է�.");
		for (int i = 0; i < intArray.length; i++) {
			intArray[i] = scanner.nextInt();
			if (intArray[i] > max) {
				max = intArray[i];
			}
		}
		System.out.println("���� ū ���� " + max +" �Դϴ�.");
		scanner.close();
	}

}
