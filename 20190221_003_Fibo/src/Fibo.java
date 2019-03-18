import java.util.Scanner;

public class Fibo {

	public static void main(String[] args) {
		int ifirst1; //초항1
		int ifirst2; // 초항2
		int isum; // 값 저장
		int iprint; //개수
		
		Scanner refScanner = new Scanner(System.in);
		System.out.println("초항 1을 입력하세요.");
		ifirst1 = refScanner.nextInt();
		System.out.println("초항 2을 입력하세요.");
		ifirst2 = refScanner.nextInt();
		System.out.println("총 개수를 입력하세요");
		iprint = refScanner.nextInt();
		
		isum = ifirst1 + ifirst2;
		System.out.print(ifirst1 + "\t"+ifirst2 +"\t"+ isum);
		//iprint = iprint-3; //이미 3번 출력을 해서
		
		while (true) {		
			ifirst1 = ifirst2;
			ifirst2 = isum;
			isum = ifirst1 + ifirst2;
			System.out.print("\t" + isum);
			--iprint;
			if (iprint-3 <= 0) {
				break;				
			}
		}
	}
}
