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
		////���⿡ �����ѹ� Ȯ�� �ڵ� ���� //////////////
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
		System.out.println("======== ���� ���� ���α׷� ========");
		System.out.println("=---------------------------=");
		System.out.println("= 1. å �߰�                                          =");
		System.out.println("= 2. å ����                                          =");
		System.out.println("= 3. å �˻�                                          =");
		System.out.println("= 4. å ���                                          =");
		System.out.println("= 9. ��    ��                                          =");
		System.out.println("=============================");
	}
	public void Run() throws IOException {
		Scanner Command = new Scanner(System.in);
		Scanner BookInfo = new Scanner(System.in);

		int iCmd;
		//		BookLink Head = null;
		//		BookLink Temp;
		
		/* �̰� ���� Ǯ�����
				FileOutputStream OFileStream;

				ObjectOutputStream FileSave;
		 */
		
		while(true) {			
			Menu();
			System.out.print("����� �Է��ϼ��� : ");
			iCmd = Command.nextInt();
			if (iCmd == 1) {
				/* �̰� ���� Ǯ�����
				OFileStream = new FileOutputStream(FileName);
				byte[] WMagicNumber = {32,25,1,40,0,32,25,7,41}; 
				OFileStream.write(WMagicNumber); 
				OFileStream.write(RecordNum);
				*/
				System.out.println("<< å ��ȣ, �̸�, ����, ���ǻ縦 �Է��ϼ��� >>");
				System.out.print("å ��ȣ : ");
				String BookNum = BookInfo.nextLine();
				System.out.print("å �̸� : ");
				String BookNa = BookInfo.nextLine();
				System.out.print("å ���� : ");
				int BookPri = BookInfo.nextInt();
				BookInfo.nextLine();
				System.out.print("å ���ǻ� : ");
				String BookAth = BookInfo.nextLine();
				
				Temp = new BookLink(BookNum, BookNa, BookPri, BookAth); //å �ֱ�
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
//				Temp = new BookLink(BookNum, BookNa, BookPri, BookAth); //å �ֱ�
//
//				Head = BookLink.Insert(Head, Temp);
//				RecordNum++;
//				BookLink current = Head;
//				FileSave.writeObject(current.rBook);				
//				current= current.rnext;			
//				FileSave.close();
//				
//				System.out.println(RecordNum+" ��");
//				System.out.println("�Է��Ͻ� å ������ �߰��߽��ϴ�.");

			}
			else if (iCmd == 2) {
				System.out.print("������ å ��ȣ�� �Է����ּ��� : ");
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
				System.out.print("�˻��� å ��ȣ�� �Է��ϼ��� : ");
				String BookNum = BookInfo.next();		
				Head = BookLink.Search(Head, BookNum);
			}
			else if (iCmd == 4) {
				if (Head == null) {
					System.out.println("å ����� �����ϴ�.");
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
				System.out.println("���� ���� ���α׷� �����մϴ�.");				
				break;
			}
		}
	}
}