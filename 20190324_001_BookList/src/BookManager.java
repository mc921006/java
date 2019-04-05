import java.io.*;
import java.util.*;

public class BookManager implements Serializable{

	final   String FileName = "Book.data"; 
	int   RecordNum   = 0; 
	BookLink  Head    = null;
	BookLink  Temp;

	public BookManager() throws Exception{
		FileInputStream IFileStream = new FileInputStream(FileName); 
		byte[] RMagicNumber = new byte[9]; 
		IFileStream.read(RMagicNumber); 
		////////////////////////////////////////
		////여기에 매직넘버 확인 코드 삽입 //////////////
		/*
		 * if(RMagicNumber != RMagicNumber) { IFileStream.close(); return; }
		 */
		////////////////////////////////////////
		RecordNum = IFileStream.read(); 

		ObjectInputStream FileLoad = new ObjectInputStream(IFileStream); 

		Book   objBook; 
		BookLink  Temp; 
		int  iCnt;
		for(iCnt=0; RecordNum > iCnt; iCnt++){ 
			objBook = (Book)FileLoad.readObject(); 
			Temp  = new BookLink(objBook); 
			Head  = BookLink.Insert(Head, Temp); 
		} 

		if(iCnt != RecordNum) {
			Head = null;
		}

		IFileStream.close(); 
	}

	public void Menu() {
		System.out.println("=============================");
		System.out.println("======== 도서 관리 프로그램 ========");
		System.out.println("=---------------------------=");
		System.out.println("= 1. 책 추가                                          =");
		System.out.println("= 2. 책 삭제                                          =");
		System.out.println("= 3. 책 검색                                          =");
		System.out.println("= 4. 책 목록                                          =");
		System.out.println("= 9. 종    료                                          =");
		System.out.println("=============================");
	}
	public void Run() throws IOException {
		Scanner Command = new Scanner(System.in);
		Scanner BookInfo = new Scanner(System.in);

		int iCmd;
		//		BookLink Head = null;
		//		BookLink Temp;
		
		/* 이거 원본 풀어야함
				FileOutputStream OFileStream;

				ObjectOutputStream FileSave;
		 */
		
		while(true) {			
			Menu();
			System.out.print("명력을 입력하세요 : ");
			iCmd = Command.nextInt();
			if (iCmd == 1) {
				/* 이거 원본 풀어야함
				OFileStream = new FileOutputStream(FileName);
				byte[] WMagicNumber = {32,25,1,40,0,32,25,7,41}; 
				OFileStream.write(WMagicNumber); 
				OFileStream.write(RecordNum);
				*/
				System.out.println("<< 책 번호, 이름, 가격, 출판사를 입력하세요 >>");
				System.out.print("책 번호 : ");
				String BookNum = BookInfo.nextLine();
				System.out.print("책 이름 : ");
				String BookNa = BookInfo.nextLine();
				System.out.print("책 가격 : ");
				int BookPri = BookInfo.nextInt();
				BookInfo.nextLine();
				System.out.print("책 출판사 : ");
				String BookAth = BookInfo.nextLine();
				
				Temp = new BookLink(BookNum, BookNa, BookPri, BookAth); //책 넣기
				Head = BookLink.Insert(Head, Temp);
				RecordNum++;
				
				FileOutputStream OFileStream = new FileOutputStream(FileName);
				byte[] WMagicNumber = {32,25,1,40,0,32,25,7,41}; 
				OFileStream.write(WMagicNumber);
				OFileStream.write(RecordNum);
				
				ObjectOutputStream FileSave = new ObjectOutputStream(OFileStream);
				
				BookLink current = Head;
				for (int i = 0; i < RecordNum; i++) {
					FileSave.writeObject(current.rBook);
					current= current.rnext;
				}				
				FileSave.close(); 
				
//				FileSave = new ObjectOutputStream(OFileStream); 				
//				System.out.println(OFileStream);				 
//				Temp = new BookLink(BookNum, BookNa, BookPri, BookAth); //책 넣기
//
//				Head = BookLink.Insert(Head, Temp);
//				RecordNum++;
//				BookLink current = Head;
//				FileSave.writeObject(current.rBook);				
//				current= current.rnext;			
//				FileSave.close();
//				
//				System.out.println(RecordNum+" 개");
//				System.out.println("입력하신 책 정보를 추가했습니다.");

			}
			else if (iCmd == 2) {
				System.out.print("삭제할 책 번호를 입력해주세요 : ");
				String BookNum = BookInfo.next();
				Head = BookLink.Del(Head, BookNum);
				RecordNum--;
				
				FileOutputStream OFileStream = new FileOutputStream(FileName);
				byte[] WMagicNumber = {32,25,1,40,0,32,25,7,41}; 
				OFileStream.write(WMagicNumber);
				OFileStream.write(RecordNum);
				
				ObjectOutputStream FileSave = new ObjectOutputStream(OFileStream);
				
				BookLink current = Head;
				for (int i = 0; i < RecordNum; i++) {
					FileSave.writeObject(current.rBook);
					current= current.rnext;
				}				
				FileSave.close(); 
				
			}
			else if (iCmd == 3) {
				System.out.print("검색할 책 번호를 입력하세요 : ");
				String BookNum = BookInfo.next();		
				Head = BookLink.Search(Head, BookNum);
			}
			else if (iCmd == 4) {
				if (Head == null) {
					System.out.println("책 목록이 없습니다.");
					continue;
				}
				Head.print();

			}
			else if (iCmd == 9) {
				
				//				FileOutputStream OFileStream = new FileOutputStream(FileName);
				//				ObjectOutputStream FileSave = new ObjectOutputStream(OFileStream);  
				//				
				//				byte[] WMagicNumber = {32,25,1,40,0,32,25,7,41}; 
				//				OFileStream.write(WMagicNumber); 
				//				OFileStream.write(RecordNum);
				//				
				//				FileSave.close();
				System.out.println("도서 관리 프로그램 종료합니다.");				
				break;
			}
		}
	}
}