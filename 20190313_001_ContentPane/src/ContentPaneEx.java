import java.awt.*;
import javax.swing.*;

public class ContentPaneEx extends JFrame{
	public ContentPaneEx() {
		setTitle("ContentPane°ú JFrame");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container contentPane = getContentPane();
		contentPane.setBackground(Color.cyan);
		contentPane.setLayout(new FlowLayout());
		
		contentPane.add(new JButton("ok"));
		contentPane.add(new JButton("cancel"));
		contentPane.add(new JButton("ignore"));
		
		setSize(300, 150);
		setVisible(true);
		
	}
	public static void main(String[] args) {
		new ContentPaneEx();
	}
}
