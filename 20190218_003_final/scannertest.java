import java.util.Scanner;
public class scannertest {
	public static void main(String[] args) {
		int a = 1;
		++a; // a=a+1
		System.out.println(a);
		a++;
		System.out.println(a);
		int b;
		b = ++a;
		System.out.println(a+""+b);
		b = a++;
		System.out.println(a+""+b);


		System.out.println("�̸�, ����, ����, ü��, ���� ���θ� ��ĭ���� �и��Ͽ� �Է�");
		Scanner scanner = new Scanner(System.in);

		String name = scanner.next();
		System.out.println("�̸��� " + name + ",  ");		

		String city = scanner.next();
		System.out.println("������ " + city + ",  ");		

		int age = scanner.nextInt();
		System.out.println("���̴� " + age + "��,  ");		

		double weight = scanner.nextDouble();
		System.out.println("ü������ " + weight + "kg,  ");		

		boolean isSingle = scanner.nextBoolean();
		System.out.println("���� ���δ� " + isSingle + "�Դϴ�.  ");		
		scanner.close();
	}
}