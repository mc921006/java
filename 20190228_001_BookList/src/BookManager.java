import java.util.Scanner;

public class BookManager {
	public void Menu() {
		System.out.println("==============================");
		System.out.println("===== ���� ���� ���α׷� =====");
		System.out.println("=----------------------------=");
		System.out.println("= 1. å �߰�                 =");
		System.out.println("= 2. å ����                 =");
		System.out.println("= 3. å �˻�                 =");
		System.out.println("= 4. å ���                 =");
		System.out.println("= 9. ��   ��                 =");
		System.out.println("==============================");
	}
	public void Run() {
		Scanner Command = new Scanner(System.in);
		Scanner BookInfo = new Scanner(System.in);
		int iCmd;
		BookLink Head = null;
		BookLink Temp;
		
		while(true) {
			Menu();
			System.out.print("����� �Է��ϼ��� : ");
			iCmd = Command.nextInt();
			if (iCmd == 1) {
				System.out.println("å ��ȣ, �̸�, ����, ���ǻ縦 �Է��ϼ���");
				System.out.print("å ��ȣ : ");
				String BookNum = BookInfo.nextLine();
				System.out.print("å �̸� : ");
				String BookNa = BookInfo.nextLine();
				System.out.print("å ���� : ");
				int BookPri = BookInfo.nextInt();
//				BookInfo.nextLine();
				System.out.print("å ���ǻ� : ");
				String BookAth = BookInfo.next();
				BookInfo.nextLine();

				Temp = new BookLink(BookNum, BookNa, BookPri, BookAth); //å �ֱ�
				Head = BookLink.Insert(Head, Temp);
				System.out.println("�Է��Ͻ� å ������ �߰��߽��ϴ�.");
			}
			else if (iCmd == 2) {
				System.out.print("������ å ��ȣ�� �Է����ּ��� : ");
				String BookNum = BookInfo.next();
				Head = BookLink.Del(Head, BookNum);
			}
			else if (iCmd == 3) {
				System.out.print("�˻��� å ��ȣ�� �Է��ϼ��� : ");
				String BookNum = BookInfo.next();		
				Head = BookLink.Search(Head, BookNum);
			}
			else if (iCmd == 4) {
				if (Head == null) {
					System.out.println("å ����� �����ϴ�.");
				}
				else {
					Head.print();	
				}
			}
			else if (iCmd == 9) {
				System.out.println("���� ���� ���α׷� �����մϴ�.");
				break;
			}else {
				System.out.println("��Ͽ� �����ִ� ��ȣ�� �Է����ּ���");
			}
		}
	}
}
