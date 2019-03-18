import javax.swing.*; 
import java.awt.event.*; 
import java.awt.*; 
 
public class KeyListenerEx2 extends JFrame implements KeyListener 
{ 
 public KeyListenerEx2() 
 { 
  setTitle("keyListener 예제"); 
  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
   
  Container c = getContentPane(); 
  c.setLayout(new FlowLayout()); 
  c.addKeyListener(this);  
   
  setSize(300,150); 
  setVisible(true); 
   
  c.setFocusable(true); 
  c.requestFocus(); 
 } 
  
 // Key 리스너 구현 
 public void keyPressed(KeyEvent e) 
 { 
  System.out.println("KeyPressed"); // 콘솔창에 메소드 이름 출력 
 } 
 public void keyReleased(KeyEvent e) 
 { 
  System.out.println("KeyReleased"); // 콘솔창에 메소드 이름 출력 
 } 
 public void keyTyped(KeyEvent e) 
 { 
  System.out.println("KeyTyped"); // 콘솔창에 메소드 이름 출력 
 } 
 
  
 public static void main(String [] args) 
 { 
  new KeyListenerEx2(); 
 } 
}