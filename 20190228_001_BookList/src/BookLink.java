
public class BookLink {
	Book rBook;
	BookLink rNext;

	//책 검색
	public static BookLink Search(BookLink Head, String BookName) {
		BookLink Current = Head;
		while (Current != null) {
			if (BookName.equals(Current.rBook.GetBookName())) {
				break;
			}
			Current = Current.rNext;
		}
		if (Current != null) {
			Current.print();
		}else {
			System.out.println(BookName+"가 존재하지 않음.");
		}
		return Head;
	}

	public static BookLink Del(BookLink Head, String BookName) {
		BookLink Current = Head;
		BookLink Prev = Head;
		//삭제할 위치 검색
		while (null != Current) { //연결리스트 끝까지 검색
			if (BookName.equals(Current.rBook.GetBookName())) {
				break;
			}
			Prev = Current;
			Current = Current.rNext;
		}
		//Current == null 책 없음.
		if (Current == null) {
			System.out.println("찾으시는 ["+BookName+"]은 없습니다.");

		}
		//Current != null 책 찾음(삭제).
		else if (Current == Head) {// 제일 앞 삭제
			Head = Head.rNext;
		}
		else {
			Prev.rNext = Current.rNext;
		}
		return Head;
	}
	public static BookLink Insert(BookLink Head, BookLink New) {

		if(Head != null) { // 끝 삽입
			BookLink Current = Head;
			//앞을 가리키는 변수
			BookLink Prev = Current; //double linked list

			//삽입할 위치 검색
			while (null != Current) { //연결리스트 끝까지 검색
				if (0 > New.rBook.GetBookName()
						.compareTo(Current.rBook.GetBookName())) { //삽입할 위치 결정
					break;
				}
				Prev = Current;
				Current = Current.rNext;
			}
			if (Current == Head) { //맨 앞 삽입
				New.rNext = Head;
				Head = New;
			}
			else { //중간 삽입
				Prev.rNext = New;
				New.rNext = Current;
			}
		}
		else {
			Head = New;
		}
		return Head;
	}
	public BookLink(String rName, String rAuthor, int iPrice, String rPub){
		rBook = new Book(rName, rAuthor, iPrice, rPub);
		rNext = null;
	}

	BookLink() {
		rBook = new Book();
		rNext = null;
		//		rBook.print();
	}

	public void print() {

		BookLink Current = this; //현재객체 this는 Head
		System.out.println("==================================");
		System.out.println("============BookList==============");
		System.out.println();
		while (null != Current) {
			Current.rBook.print();
			Current = Current.rNext;
		}
		System.out.println();
		System.out.println("===================================");
		System.out.println();
	}
}
