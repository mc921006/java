
public class ArrayTest {
	public static void main(String[] args) {
		String rString = "abcdef123";
		char[] caChar = rString.toCharArray();
		for (int i = 0; i < caChar.length; i++) {
			System.out.printf("[%c] ", caChar[i]);
		}
		
		System.out.println(java.util.Arrays.toString(caChar));
	}
}
