import java.util.Scanner;

public class BookManager {
	public void Menu() {
		System.out.println("==============================");
		System.out.println("===== 도서 관리 프로그램 =====");
		System.out.println("=----------------------------=");
		System.out.println("= 1. 책 추가                 =");
		System.out.println("= 2. 책 삭제                 =");
		System.out.println("= 3. 책 검색                 =");
		System.out.println("= 4. 책 목록                 =");
		System.out.println("= 9. 종   료                 =");
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
			System.out.print("명력을 입력하세요 : ");
			iCmd = Command.nextInt();
			if (iCmd == 1) {
				System.out.println("책 번호, 이름, 가격, 출판사를 입력하세요");
				System.out.print("책 번호 : ");
				String BookNum = BookInfo.nextLine();
				System.out.print("책 이름 : ");
				String BookNa = BookInfo.nextLine();
				System.out.print("책 가격 : ");
				int BookPri = BookInfo.nextInt();
//				BookInfo.nextLine();
				System.out.print("책 출판사 : ");
				String BookAth = BookInfo.next();
				BookInfo.nextLine();

				Temp = new BookLink(BookNum, BookNa, BookPri, BookAth); //책 넣기
				Head = BookLink.Insert(Head, Temp);
				System.out.println("입력하신 책 정보를 추가했습니다.");
			}
			else if (iCmd == 2) {
				System.out.print("삭제할 책 번호를 입력해주세요 : ");
				String BookNum = BookInfo.next();
				Head = BookLink.Del(Head, BookNum);
			}
			else if (iCmd == 3) {
				System.out.print("검색할 책 번호를 입력하세요 : ");
				String BookNum = BookInfo.next();		
				Head = BookLink.Search(Head, BookNum);
			}
			else if (iCmd == 4) {
				if (Head == null) {
					System.out.println("책 목록이 없습니다.");
				}
				else {
					Head.print();	
				}
			}
			else if (iCmd == 9) {
				System.out.println("도서 관리 프로그램 종료합니다.");
				break;
			}else {
				System.out.println("목록에 나와있는 번호를 입력해주세요");
			}
		}
	}
}
