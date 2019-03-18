import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MouseListenerAllEx extends JFrame{
	private JLabel la = new JLabel("마우스 이벤트 없음");
	
	public MouseListenerAllEx() {
		setTitle("마우스 이벤트 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		MyMouseListener listener = new MyMouseListener();
		c.addMouseListener(listener);
		c.addMouseMotionListener(listener);
		
		c.add(la);
		setSize(300, 200);
		setVisible(true);
	}
	class MyMouseListener implements MouseListener, MouseMotionListener{
		@Override
		public void mouseDragged(MouseEvent e) {
			la.setText("mouseDragged (" +e.getX()+","+e.getY()+")");
		}

		@Override
		public void mouseMoved(MouseEvent e) {
			la.setText("mouseMoved (" +e.getX()+","+e.getY()+")");
		}

		@Override
		public void mouseClicked(MouseEvent e) {}

		@Override
		public void mousePressed(MouseEvent e) {
			la.setText("mousePressed (" +e.getX()+","+e.getY()+")");
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			la.setText("mouseReleased (" +e.getX()+","+e.getY()+")");			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			Component c = (Component)e.getSource();
			c.setBackground(Color.cyan);
		}

		@Override
		public void mouseExited(MouseEvent e) {
			Component c = (Component)e.getSource();
			c.setBackground(Color.yellow);
		}
	}
	public static void main(String[] args) {
		new MouseListenerAllEx();
	}

	
}
