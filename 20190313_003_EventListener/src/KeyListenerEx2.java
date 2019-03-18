import javax.swing.*; 
import java.awt.event.*; 
import java.awt.*; 
 
public class KeyListenerEx2 extends JFrame implements KeyListener 
{ 
 public KeyListenerEx2() 
 { 
  setTitle("keyListener ����"); 
  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
   
  Container c = getContentPane(); 
  c.setLayout(new FlowLayout()); 
  c.addKeyListener(this);  
   
  setSize(300,150); 
  setVisible(true); 
   
  c.setFocusable(true); 
  c.requestFocus(); 
 } 
  
 // Key ������ ���� 
 public void keyPressed(KeyEvent e) 
 { 
  System.out.println("KeyPressed"); // �ܼ�â�� �޼ҵ� �̸� ��� 
 } 
 public void keyReleased(KeyEvent e) 
 { 
  System.out.println("KeyReleased"); // �ܼ�â�� �޼ҵ� �̸� ��� 
 } 
 public void keyTyped(KeyEvent e) 
 { 
  System.out.println("KeyTyped"); // �ܼ�â�� �޼ҵ� �̸� ��� 
 } 
 
  
 public static void main(String [] args) 
 { 
  new KeyListenerEx2(); 
 } 
}