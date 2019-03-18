import java.awt.*;
import javax.swing.*;

public class CheckBoxEx extends JFrame{
	public CheckBoxEx() {
		setTitle("üũ�ڽ� ����");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		
		c.setLayout(new FlowLayout());
		
		ImageIcon cherryIcon = new ImageIcon("cherry.jpg");
		ImageIcon selectedcherryIcon = new ImageIcon("selectedcherry.jpg");
		
		JCheckBox apple = new JCheckBox("���");
		JCheckBox pear = new JCheckBox("��", true);
		JCheckBox cherry = new JCheckBox("ü��", cherryIcon);
		
		cherry.setBorderPainted(true);
		cherry.setSelectedIcon(selectedcherryIcon);
		
		c.add(apple);
		c.add(pear);
		c.add(cherry);
		
		setSize(250, 150);
		setVisible(true);
	}
	public static void main(String[] args) {
		new CheckBoxEx();
	}

}
