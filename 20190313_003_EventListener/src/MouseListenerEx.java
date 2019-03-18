import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MouseListenerEx extends JFrame{
	private JLabel la = new JLabel("�ȳ�");

	public MouseListenerEx() {
		setTitle("���콺 �̺�Ʈ ����");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.addMouseListener(new MyMouseLiener());

		c.setLayout(null);
		la.setSize(50,20);
		la.setLocation(30, 30);
		c.add(la);

		setSize(250,250);
		setVisible(true);
	}
	class MyMouseLiener extends MouseAdapter{
		
		@Override
		public void mousePressed(MouseEvent e) {
			int x = e.getX();
			int y = e.getY();
			la.setLocation(x, y);
		}
	}

	public static void main(String[] args) {
		new MouseListenerEx();
	}
}
