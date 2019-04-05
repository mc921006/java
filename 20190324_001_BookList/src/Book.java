import java.io.Serializable;
import java.util.Scanner;

public class Book implements Serializable{
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