import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class ComboActionEx extends JFrame{
	private String [] fruites = {"사과", "바나나", "키위", "망고"};
	
	private ImageIcon [] images = {new ImageIcon("apple.jpg"),
			new ImageIcon("banana.jpg"), new ImageIcon("kiwi.jpg"),
			new ImageIcon("mango.jpg")};
	private JLabel imgLabel = new JLabel(images[0]);
	private JComboBox<String> strcombo = new JComboBox<String>(fruites);
	
	public ComboActionEx() {
		setTitle("콤보박스 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		c.add(strcombo);
		c.add(imgLabel);
		
		strcombo.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JComboBox<String> cb = (JComboBox<String>)e.getSource();
				int index = cb.getSelectedIndex();
				imgLabel.setIcon(images[index]);
						
			}
		});
		
		setSize(300, 250);
		setVisible(true);
	}
	public static void main(String[] args) {
		new ComboActionEx();
	}
}
