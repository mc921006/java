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
		System.out.print("단을 입력하세요 : ");
		gugudan(scanner.nextInt());
		return;
	}

	static void gugudan(int iDan) {
		if (iDan < 0 || iDan > 9) {
			System.out.println("0보다 크거가 9보다 작은 값을 넣어주십시요");
			scanner= new Scanner(System.in);
			System.out.print("단을 입력하세요 : ");
			gugudan(scanner.nextInt());
			return;
		}else {
			for (int i = 1; i < 10; i++) {
				System.out.println(iDan+"*"+i+"="+iDan*i);
			}	
		}

	}
}
