import java.util.Scanner;

public class Fibo {

	public static void main(String[] args) {
		int ifirst1; //����1
		int ifirst2; // ����2
		int isum; // �� ����
		int iprint; //����
		
		Scanner refScanner = new Scanner(System.in);
		System.out.println("���� 1�� �Է��ϼ���.");
		ifirst1 = refScanner.nextInt();
		System.out.println("���� 2�� �Է��ϼ���.");
		ifirst2 = refScanner.nextInt();
		System.out.println("�� ������ �Է��ϼ���");
		iprint = refScanner.nextInt();
		
		isum = ifirst1 + ifirst2;
		System.out.print(ifirst1 + "\t"+ifirst2 +"\t"+ isum);
		//iprint = iprint-3; //�̹� 3�� ����� �ؼ�
		
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
