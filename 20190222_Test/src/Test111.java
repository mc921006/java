import java.util.Arrays;

public class Test111 {

	public static void main(String[] args) {
//		int i[] = { 5, 25, 47, 8, 15, 8446, 666 };
		int i[][] = {{5, 25, 47, 8},
				{15, 8446, 666, 111},
				{1, 2, 3, 4},
				{5, 6, 7, 8}};
		System.out.println(Arrays.deepToString(i).replaceAll("],", "]," + System.getProperty("line.separator")));
	}
}
