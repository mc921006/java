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
		System.out.print("책 이름 : ");
		rName = scanner.nextLine();
		System.out.print("저자 : ");
		rAuthor = scanner.nextLine();
		System.out.print("가격 : ");
		iPrice = scanner.nextInt();
		scanner.nextLine(); // 엔터 제거
		System.out.print("출판사 : ");
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