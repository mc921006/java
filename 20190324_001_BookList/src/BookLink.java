import java.io.Serializable;

public class BookLink implements Serializable{
    Book rBook;
    BookLink rnext;

    public static BookLink Search(BookLink Head, String BookName){
        BookLink Current  = Head;
        BookLink Prev   = Head;

//        System.out.print(BookName.equals(Current.rBook.GetBookName())); //false
//        System.out.print(Current.rBook.GetBookName()); // 0000

        while(null != Current) { // 연결리스트 끝까지 검색
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

        //삭제할 위치 검색
        while(null != Current) { // 연결리스트 끝까지 검색
            if(BookName.equals(Current.rBook.GetBookName())) { //삭제할 위치 결정
//                System.out.println("Current:"+Current.rBook.GetBookName());
                System.out.print("책 : " + Current.rBook.GetBookName()+ "삭제 되었습니다.");
                break;
            }
            Prev  = Current;
            Current = Current.rnext;
        }
        if(null == Current) {
            System.out.println("책이 없습니다.");
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

            //삽입할 위치 검색
            while(null != Current) { //연결 리스트 끝까지 검색
                if(0 > New.rBook.GetBookName().compareTo(Current.rBook.GetBookName())) { // 삽입할 위치 결정

                    break;
                }
                Prev = Current;
                Current = Current.rnext;
            }
            if(Current == Head) { //맨앞 삽입
                New.rnext = Head;
                Head = New;
            }else { //중간삽입
                Prev.rnext = New;
                New.rnext = Current;
            }
        }
        else {
            Head = New;
        }
        return Head;
    }

    //자동으로 입력하게 하는 함수
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