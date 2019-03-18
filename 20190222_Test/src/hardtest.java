
public class hardtest {
	public static void main(String[] args) {
		int num[][] = {{1, 2, 3, 4},
				{5, 6, 7, 8},
				{9, 1, 2, 3},
				{4, 5, 6, 7}};
		for (int i = 0; i < num.length; i++) {
			for (int j = 0; j < num.length; j++) {
				System.out.print(num[i][j]);	
			}System.out.println();
		}
		System.out.println();
		for (int i = 0; i < num.length; i++) {
			for (int j = 3; j >= 0; j--) {
				System.out.print(num[j][i]);
			}System.out.println();
		}
		System.out.println();
		for (int i = 3; i >= 0; i--) {
			for (int j = 3; j >= 0; j--) {
				System.out.print(num[i][j]);
			}System.out.println();
		}
		/*
		int height = 0;
		double size = 0.25;
		double total = height + size;
		char c = 'a';
		String name = "ภüนฮรถ";
		
		System.out.println(total +" "+c+" "+name);*/
	}
}
