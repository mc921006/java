
public class BookLink {
	Book rBook;
	BookLink rNext;

	//å �˻�
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
			System.out.println(BookName+"�� �������� ����.");
		}
		return Head;
	}

	public static BookLink Del(BookLink Head, String BookName) {
		BookLink Current = Head;
		BookLink Prev = Head;
		//������ ��ġ �˻�
		while (null != Current) { //���Ḯ��Ʈ ������ �˻�
			if (BookName.equals(Current.rBook.GetBookName())) {
				break;
			}
			Prev = Current;
			Current = Current.rNext;
		}
		//Current == null å ����.
		if (Current == null) {
			System.out.println("ã���ô� ["+BookName+"]�� �����ϴ�.");

		}
		//Current != null å ã��(����).
		else if (Current == Head) {// ���� �� ����
			Head = Head.rNext;
		}
		else {
			Prev.rNext = Current.rNext;
		}
		return Head;
	}
	public static BookLink Insert(BookLink Head, BookLink New) {

		if(Head != null) { // �� ����
			BookLink Current = Head;
			//���� ����Ű�� ����
			BookLink Prev = Current; //double linked list

			//������ ��ġ �˻�
			while (null != Current) { //���Ḯ��Ʈ ������ �˻�
				if (0 > New.rBook.GetBookName()
						.compareTo(Current.rBook.GetBookName())) { //������ ��ġ ����
					break;
				}
				Prev = Current;
				Current = Current.rNext;
			}
			if (Current == Head) { //�� �� ����
				New.rNext = Head;
				Head = New;
			}
			else { //�߰� ����
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

		BookLink Current = this; //���簴ü this�� Head
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
