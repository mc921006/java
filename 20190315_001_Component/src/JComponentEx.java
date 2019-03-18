import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class JComponentEx extends JFrame{
	public JComponentEx() {
		super("JComponent ¿¹Á¦");
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		JButton b1 = new JButton("magenta/yellow button");
		JButton b2 = new JButton("   disabled button   ");
		JButton b3 = new JButton("getx(), gety()");
		
		b1.setBackground(Color.yellow);
		b1.setForeground(Color.magenta);
		b1.setFont(new Font("Arial", Font.ITALIC, 20));
		b2.setEnabled(false);
		b3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JButton b = (JButton)e.getSource();
				JComponentEx frame = (JComponentEx)b.getTopLevelAncestor();
				frame.setTitle(b.getX()+","+b.getY());
			}
		});
		
		c.add(b1); c.add(b2); c.add(b3);
		setSize(260, 200);
		setVisible(true);
	}
	public static void main(String[] args) {
		new JComponentEx();
	}
}

