import java.util.Scanner;

public class ch03 {
	static int cen;
	static int fah;
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("¼·¾¾(c) or È­¾¾(f) : ");
		String temper = scanner.next();
		
		if (temper.equals("c")) {
			System.out.print("¼·¾¾¿Âµµ¸¦ ÀÔ·ÂÇÏ¼¼¿ä : ");
			cen = scanner.nextInt(); //¼·¾¾
			fah = (9*cen + 160)/ 5;
			System.out.println("¼·¾¾¿Âµµ "+cen+"Àº(´Â) È­¾¾¿Âµµ·Î"+fah);
		}
		else if (temper.equals("f")) {
			System.out.print("È­¾¾¿Âµµ¸¦ ÀÔ·ÂÇÏ¼¼¿ä : ");
			fah = scanner.nextInt(); //È­¾¾
			cen = 5*(fah - 32) / 9;
			System.out.println("È­¾¾¿Âµµ "+fah+"Àº(´Â) ¼·¾¾¿Âµµ·Î "+cen);
		}
		else {
			System.out.print("c¿Í fÁß¿¡ ÇÏ³ª¸¸ ÀÔ·ÂÇÏ¼¼¿ä");
		}
	}
}
