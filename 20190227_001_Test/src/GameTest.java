import javax.swing.*; 

public class GameTest extends JFrame 
{   
 void Go() 
 { 
  setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); 
  setTitle("���� ��׶��� �׽�Ʈ"); 
  setSize(800, 600); 
  setResizable(false); 
  setVisible(true); 
 } 
 public static void main(String[] rArg) 
 { 
  GameTest rGameTest = new GameTest(); 
  rGameTest.Go(); 
 }//main 
}