import java.util.Scanner;

public class BookList {
	public static void main(String[] args) {
		BookLink bookHead = null;
		BookLink rBookNext;

		// 데이터 삽입
		rBookNext = bookHead;
		//		for (int i = 0; i < 3; i++) {
		if (rBookNext == null) {
			//				bookHead = new BookLink();
			bookHead = new BookLink("엄마가", "섬그늘에", 1000, "굴따러가면");
			rBookNext = bookHead;
			//				continue;
		}
		rBookNext.rNext = new BookLink("아기는", "혼자남아", 2000, "집을 보다가");
		rBookNext = rBookNext.rNext;
		rBookNext.rNext = new BookLink("니가뭔데", "집을보냐", 3000, "어린넘이");
		rBookNext = rBookNext.rNext;
		//		}//출력
		rBookNext = bookHead;
		while (rBookNext != null) {
			rBookNext.print();
			rBookNext = rBookNext.rNext;
		}
		/*
		//데이터 검색
		Scanner scanner = new Scanner(System.in);
		System.out.println("책 이름 입력 : ");
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
			System.out.println(rBookName+"없음");
		}
		 */


		////////////////
		//제일 앞에 삽입할 경우
		System.out.println("========================================");
		BookLink rBookNew = new BookLink("승진아", "올때는", 4000, "메로나");
		rBookNew.rNext = bookHead;
		bookHead = rBookNew;
		//출력
		rBookNext = bookHead;
		while (rBookNext != null) {
			rBookNext.print();
			rBookNext = rBookNext.rNext;
		}

		////////////////
		//
		System.out.println("+++++++++++++++++++++++++++++++++++++++++");
		rBookNew = new BookLink("유석이", "멍청해서", 5000, "바보다");
		rBookNext = bookHead;//이동 시작 : 승진이
		rBookNext = rBookNext.rNext; //이동2 : 엄마
		rBookNew.rNext = rBookNext.rNext;
		rBookNext.rNext = rBookNew;
		//출력
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