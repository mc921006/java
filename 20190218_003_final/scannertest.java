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


		System.out.println("이름, 도시, 나이, 체중, 독신 여부를 빈칸으로 분리하여 입력");
		Scanner scanner = new Scanner(System.in);

		String name = scanner.next();
		System.out.println("이름은 " + name + ",  ");		

		String city = scanner.next();
		System.out.println("도시은 " + city + ",  ");		

		int age = scanner.nextInt();
		System.out.println("나이는 " + age + "살,  ");		

		double weight = scanner.nextDouble();
		System.out.println("체중은은 " + weight + "kg,  ");		

		boolean isSingle = scanner.nextBoolean();
		System.out.println("독신 여부는 " + isSingle + "입니다.  ");		
		scanner.close();
	}
}