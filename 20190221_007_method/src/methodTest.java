import java.util.*;
public class methodTest {
	static void javaAppWeb() {
		System.out.println("Method");
		return;
	}
	static Scanner scanner;
	static int num;
	public static void main(String[] args) {
		javaAppWeb();
		scanner= new Scanner(System.in);
		System.out.print("���� �Է��ϼ��� : ");
		gugudan(scanner.nextInt());
		return;
	}

	static void gugudan(int iDan) {
		if (iDan < 0 || iDan > 9) {
			System.out.println("0���� ũ�Ű� 9���� ���� ���� �־��ֽʽÿ�");
			scanner= new Scanner(System.in);
			System.out.print("���� �Է��ϼ��� : ");
			gugudan(scanner.nextInt());
			return;
		}else {
			for (int i = 1; i < 10; i++) {
				System.out.println(iDan+"*"+i+"="+iDan*i);
			}	
		}

	}
}
