import java.util.Scanner;

public class BookList {
	public static void main(String[] args) {
		BookLink bookHead = null;
		BookLink rBookNext;

		// ������ ����
		rBookNext = bookHead;
		//		for (int i = 0; i < 3; i++) {
		if (rBookNext == null) {
			//				bookHead = new BookLink();
			bookHead = new BookLink("������", "���״ÿ�", 1000, "����������");
			rBookNext = bookHead;
			//				continue;
		}
		rBookNext.rNext = new BookLink("�Ʊ��", "ȥ�ڳ���", 2000, "���� ���ٰ�");
		rBookNext = rBookNext.rNext;
		rBookNext.rNext = new BookLink("�ϰ�����", "��������", 3000, "�����");
		rBookNext = rBookNext.rNext;
		//		}//���
		rBookNext = bookHead;
		while (rBookNext != null) {
			rBookNext.print();
			rBookNext = rBookNext.rNext;
		}
		/*
		//������ �˻�
		Scanner scanner = new Scanner(System.in);
		System.out.println("å �̸� �Է� : ");
		String rBookName = scanner.next();
		rBookNext = bookHead;
		while (null != rBookNext) {
			if (rBookName.equals(rBookNext.rBook.GetBookName())) {
				break;
			}
			rBookNext = rBookNext.rNext;
		}
		if (rBookNext != null) {
			rBookNext.print();
		}else {
			System.out.println(rBookName+"����");
		}
		 */


		////////////////
		//���� �տ� ������ ���
		System.out.println("========================================");
		BookLink rBookNew = new BookLink("������", "�ö���", 4000, "�޷γ�");
		rBookNew.rNext = bookHead;
		bookHead = rBookNew;
		//���
		rBookNext = bookHead;
		while (rBookNext != null) {
			rBookNext.print();
			rBookNext = rBookNext.rNext;
		}

		////////////////
		//
		System.out.println("+++++++++++++++++++++++++++++++++++++++++");
		rBookNew = new BookLink("������", "��û�ؼ�", 5000, "�ٺ���");
		rBookNext = bookHead;//�̵� ���� : ������
		rBookNext = rBookNext.rNext; //�̵�2 : ����
		rBookNew.rNext = rBookNext.rNext;
		rBookNext.rNext = rBookNew;
		//���
		rBookNext = bookHead;
		while (rBookNext != null) {
			rBookNext.print();
			rBookNext = rBookNext.rNext;
		}
	}
}
//
class Book{
	private String rName;
	private String rAuthor;
	private int iPrice;
	private String rPub;

	Book(String rName, String rAuthor, int iPrice, String rPub){
		this.rName =rName; 
		this.rAuthor =rAuthor;
		this.iPrice=iPrice;
		this.rPub =rPub;
	}

	Book(){
		Scanner scanner = new Scanner(System.in);
		System.out.print("å �̸� : ");
		rName = scanner.nextLine();
		System.out.print("���� : ");
		rAuthor = scanner.nextLine();
		System.out.print("���� : ");
		iPrice = scanner.nextInt();
		scanner.nextLine(); // ���� ����
		System.out.print("���ǻ� : ");
		rPub = scanner.nextLine();
		//		scanner.close();
	}
	public void print() {
		System.out.println("["+rName+"], "+"["+rAuthor+"],"
				+ " "+"["+iPrice+"], "+"["+rPub+"]");
	}
	String GetBookName() {
		return rName;
	}
}

class BookLink {
	Book rBook;
	BookLink rNext;

	BookLink(String rName, String rAuthor, int iPrice, String rPub){
		rBook = new Book(rName, rAuthor, iPrice, rPub);
		rNext = null;
	}

	BookLink() {
		rBook = new Book();
		rNext = null;
		//		rBook.print();
	}

	public void print() {
		rBook.print();
	}
}