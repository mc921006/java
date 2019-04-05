import java.io.*; 
 
public class BookSave 
{ 
 public static void main(String[] AAAA) 
 throws Exception  
 { 
  Book aBook1 = new Book("이름 111", "저자 111", 11111, "출판사 111"); 
  Book aBook2 = new Book("이름 222", "저자 222", 22222, "출판사 222"); 
  Book aBook3 = new Book("이름 3333", "저자 3333", 333333, "출판사 3333"); 
 
  ///////////////////////////////////////////////// 
  //////// File 생성 /////////////////////////////// 
  FileOutputStream OFileStream = new FileOutputStream("Book.data"); 
  //////// File Header 생성 //////////////////////// 
  byte[] WMagicNumber = {32,25,1,40,0,32,25,7,41}; 
  OFileStream.write(WMagicNumber); 
  OFileStream.write(3); 
  //////// File Data 생성 ////////////////////////// 
  ObjectOutputStream FileSave = new ObjectOutputStream(OFileStream);  
  FileSave.writeObject(aBook1); 
  FileSave.writeObject(aBook2); 
  FileSave.writeObject(aBook3); 
  FileSave.close(); 
  //////////////////////////////////////////////// 
   
  ///////////////////////////////////////////////// 
  //////// File 읽기 /////////////////////////////// 
  FileInputStream IFileStream = new FileInputStream("Book.data"); 
  //////// File Header 읽기 //////////////////////// 
  byte[] RMagicNumber = new byte[9]; 
  IFileStream.read(RMagicNumber); 
  int RecordNum = IFileStream.read(); 
  //////// File Data 읽기 ////////////////////////// 
  ObjectInputStream FileLoad = new ObjectInputStream(IFileStream); 
  Book aBookload; 
  for(int iCnt = 0; RecordNum > iCnt; ++iCnt) 
  { 
   aBookload = (Book)FileLoad.readObject(); 
   System.out.println(aBookload); 
  } 
  FileLoad.close(); 
  ///////////////////////////////////////////////// 
 
  return; 
 } 
 
}