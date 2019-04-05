import java.io.Serializable;

public class BookLink implements Serializable{
    Book rBook;
    BookLink rnext;

    public static BookLink Search(BookLink Head, String BookName){
        BookLink Current  = Head;
        BookLink Prev   = Head;

//        System.out.print(BookName.equals(Current.rBook.GetBookName())); //false
//        System.out.print(Current.rBook.GetBookName()); // 0000

        while(null != Current) { // ���Ḯ��Ʈ ������ �˻�
            if(Current.rBook.GetBookName().equals(BookName)){
//                System.out.println(Current.rBook.GetBookName());
                System.out.println("==========================");
                Current.rBook.print();
                break;
            }
            Prev  = Current;
            Current = Current.rnext;
            
//            System.out.print(Current.rBook.GetBookName());
        }

        return Head;
    }

    public static BookLink Del(BookLink Head, String BookName){
        BookLink Current  = Head;
        BookLink Prev   = Head;

        //������ ��ġ �˻�
        while(null != Current) { // ���Ḯ��Ʈ ������ �˻�
            if(BookName.equals(Current.rBook.GetBookName())) { //������ ��ġ ����
//                System.out.println("Current:"+Current.rBook.GetBookName());
                System.out.print("å : " + Current.rBook.GetBookName()+ "���� �Ǿ����ϴ�.");
                break;
            }
            Prev  = Current;
            Current = Current.rnext;
        }
        if(null == Current) {
            System.out.println("å�� �����ϴ�.");
        }

        else if(Current == Head){
            Head = Head.rnext;
        }

        else {
            Prev.rnext = Current.rnext;
        }

        return Head;
    }

    public static BookLink Insert(BookLink Head, BookLink New) {

        if(null != Head) {
            BookLink Current = Head;
            BookLink Prev = Head;

            //������ ��ġ �˻�
            while(null != Current) { //���� ����Ʈ ������ �˻�
                if(0 > New.rBook.GetBookName().compareTo(Current.rBook.GetBookName())) { // ������ ��ġ ����

                    break;
                }
                Prev = Current;
                Current = Current.rnext;
            }
            if(Current == Head) { //�Ǿ� ����
                New.rnext = Head;
                Head = New;
            }else { //�߰�����
                Prev.rnext = New;
                New.rnext = Current;
            }
        }
        else {
            Head = New;
        }
        return Head;
    }

    //�ڵ����� �Է��ϰ� �ϴ� �Լ�
    public BookLink(String rName, String rAutho, int iPrice, String rPub) {
        rBook = new Book(rName,rAutho,iPrice,rPub);
        rnext = null;
    }
    
    public BookLink(Book NewObj) {
        rBook = NewObj;
        rnext = null;
    }

    BookLink(){
        rBook = new Book();
        rnext = null;
    }

    public void print() {

        BookLink Current = this;
        System.out.println();
        System.out.println("=================Book List=================");
        while(null != Current) {
            Current.rBook.print();
            Current = Current.rnext;
        }
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++");
        System.out.println();
    }
}