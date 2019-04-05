import java.io.*; 
 
public class BookSave 
{ 
 public static void main(String[] AAAA) 
 throws Exception  
 { 
  Book aBook1 = new Book("�̸� 111", "���� 111", 11111, "���ǻ� 111"); 
  Book aBook2 = new Book("�̸� 222", "���� 222", 22222, "���ǻ� 222"); 
  Book aBook3 = new Book("�̸� 3333", "���� 3333", 333333, "���ǻ� 3333"); 
 
  ///////////////////////////////////////////////// 
  //////// File ���� /////////////////////////////// 
  FileOutputStream OFileStream = new FileOutputStream("Book.data"); 
  //////// File Header ���� //////////////////////// 
  byte[] WMagicNumber = {32,25,1,40,0,32,25,7,41}; 
  OFileStream.write(WMagicNumber); 
  OFileStream.write(3); 
  //////// File Data ���� ////////////////////////// 
  ObjectOutputStream FileSave = new ObjectOutputStream(OFileStream);  
  FileSave.writeObject(aBook1); 
  FileSave.writeObject(aBook2); 
  FileSave.writeObject(aBook3); 
  FileSave.close(); 
  //////////////////////////////////////////////// 
   
  ///////////////////////////////////////////////// 
  //////// File �б� /////////////////////////////// 
  FileInputStream IFileStream = new FileInputStream("Book.data"); 
  //////// File Header �б� //////////////////////// 
  byte[] RMagicNumber = new byte[9]; 
  IFileStream.read(RMagicNumber); 
  int RecordNum = IFileStream.read(); 
  //////// File Data �б� ////////////////////////// 
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