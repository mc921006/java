import java.util.*;

public class ArrayTest {
	public static void main(String[] args) {
		//int intArray[] = new int[5];
		int intArray[];
		intArray = new int[5];
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("���ڸ� �Է� : ");
		for (int i = 0; i < intArray.length; i++) {
			intArray[i] = scanner.nextInt();
		}
		System.out.print("�Է��� ���ڵ� : ");
		for (int i = 0; i < intArray.length; i++) {
			System.out.print(intArray[i]+" ");
		}
		System.out.println();
		int[] intArray2 = {5, 6, 7, 8, 9};
		for (int i = 0; i < intArray2.length; i++) {
			System.out.println(i+"��° �迭"+" ["+intArray2[i]+"]");
		}
		int[] intArray3 = {5, 6, 7, 8, 9};
		int[] ArrayTest = intArray3;
		System.out.println(intArray3[0]);
		System.out.println(ArrayTest[0]);
		ArrayTest[0] = 10;
		System.out.println(intArray3[0]);
		System.out.println(ArrayTest[0]);
		scanner.close();
	}
}
