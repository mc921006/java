import java.awt.*;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class SliderChangeEx extends JFrame{
	private JLabel colorlabel;
	private JSlider [] sl = new JSlider[3];
	
	public SliderChangeEx() {
		setTitle("�����̴� ����");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		colorlabel = new JLabel("     �����̴� ����            ");
		for (int i = 0; i < sl.length; i++) {
			sl[i] = new JSlider(JSlider.HORIZONTAL, 0, 255, 128);
			sl[i].setPaintLabels(true);
			sl[i].setPaintTicks(true);
			sl[i].setPaintTrack(true);
			sl[i].setMajorTickSpacing(50);
			sl[i].setMinorTickSpacing(10);
			
			sl[i].addChangeListener(new MyChangeListener());
			c.add(sl[i]);
		}
		sl[0].setForeground(Color.red);
		sl[1].setForeground(Color.green);
		sl[2].setForeground(Color.blue);
		
		int r = sl[0].getValue();
		int g = sl[1].getValue();
		int b = sl[2].getValue();
		colorlabel.setOpaque(true);
		colorlabel.setBackground(new Color(r, g, b));
		
		c.add(colorlabel);
		setSize(300, 230);
		setVisible(true);
	}
	
	class MyChangeListener implements ChangeListener {
		public void stateChanged(ChangeEvent e) {
			int r = sl[0].getValue();
			int g = sl[1].getValue();
			int b = sl[2].getValue();
			colorlabel.setBackground(new Color(r,g,b));
		}
	}
	public static void main(String[] args) {
		new SliderChangeEx();
	}
}
