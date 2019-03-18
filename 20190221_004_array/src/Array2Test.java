
public class Array2Test {
	public static void main(String[] args) {
		int intArray1 [][];
		int [][] intArray2;

		intArray1 = new int[2][5];
		intArray2 = intArray1;

		intArray1[0][0] = 1;

		System.out.println(intArray1.length);
		System.out.println(intArray1[0].length);

		int [][] intArray3 = {{1, 2, 3},
				{4, 5, 6},
				{7, 8, 9}};
		for (int iTest[] : intArray3) {
			for(int k : iTest) {
				System.out.print(k + " ");
			}System.out.println();
		}
		

	}
}
