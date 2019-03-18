import java.awt.*;
import javax.swing.*;

public class paintJPanelEx extends JFrame{
	private MyPanel panel = new MyPanel();
	
	public paintJPanelEx() {
		setTitle("jpnel과 paintcomponent 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(panel);
		setSize(600, 600);
		setVisible(true);
	}
	
	class MyPanel extends JPanel {
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.setColor(Color.blue);
			g.drawRect(10, 10, 50, 50);
			g.drawRect(50, 50, 50, 50);
			g.setColor(Color.magenta);
			g.drawRect(90, 90, 50, 50);
			g.drawString("자바는 재미있다?",50, 30);
			g.drawString("과연?",50, 50);
			g.setColor(new Color(255, 0 ,0));
			g.setFont(new Font("Arial", Font.ITALIC, 30));
			g.drawString("what?", 50, 70);
			g.setColor(Color.red);
			g.fillOval(150, 10, 80, 80);
			g.setColor(Color.black);
			g.drawRoundRect(150, 100, 120, 80, 40, 60);
			g.drawLine(10, 120, 120, 180);
			g.fillArc(165, 25, 50, 50, 0, 270);
			int [] x = {30, 10, 30, 60};
			int [] y = {250, 275, 300, 275};
			g.fillPolygon(x, y, 4);
		}
	}
	public static void main(String[] args) {
		new paintJPanelEx();
	}
}
