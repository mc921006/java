import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;

public class BorderLayoutEx extends JFrame{
	public BorderLayoutEx() {
		setTitle("BorderLayoutEx");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		
		c.setLayout(new BorderLayout(30, 20));
		c.add(new JButton("aa"), BorderLayout.CENTER);
		c.add(new JButton("bb"), BorderLayout.NORTH);
		c.add(new JButton("cc"), BorderLayout.SOUTH);
		c.add(new JButton("dd"), BorderLayout.EAST);
		c.add(new JButton("ee"), BorderLayout.WEST);
		
		setSize(300, 200);
		setVisible(true);
	}
	public static void main(String[] args) {
		new BorderLayoutEx();
	}
}
