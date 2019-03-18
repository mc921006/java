import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class KeyListenerEx extends JFrame{
	private JLabel [] keymessage;
	
	public KeyListenerEx() {
		setTitle("키메세지 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		c.addKeyListener(new MyKeyListener());
		
		keymessage = new JLabel[3];
		keymessage[0] = new JLabel(" getkeycode() ");
		keymessage[1] = new JLabel(" getkeychar() ");
		keymessage[2] = new JLabel(" getkeytext() ");
		
		for (int i = 0; i < keymessage.length; i++) {
			c.add(keymessage[i]);
			keymessage[i].setOpaque(true);
			keymessage[i].setBackground(Color.cyan);
		}
		
		setSize(300, 150);
		setVisible(true);
		
		c.setFocusable(true);
		c.requestFocus();
	}
	
	class MyKeyListener extends KeyAdapter {
		public void keyPressed(KeyEvent e) {
			int keyCode = e.getKeyCode();
			char keyChar = e.getKeyChar();
			keymessage[0].setText(Integer.toString(keyCode));
			keymessage[1].setText(Character.toString(keyChar));
			keymessage[2].setText(KeyEvent.getKeyText(keyCode));
			
			System.out.println("keyPressed");
		}
		public void keyReleased(KeyEvent e) {
			System.out.println("keyReleased");
		}
		public void keyTyped(KeyEvent e) {
			System.out.println("keyTyped");
		}
	}
	public static void main(String[] args) {
		new KeyListenerEx();
	}
	
}
