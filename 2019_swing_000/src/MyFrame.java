import java.awt.*;
import javax.swing.*;

public class MyFrame extends JFrame{

	//	Image aImage = (new ImageIcon("1.png")).getImage();
	Image aImage = Toolkit.getDefaultToolkit().getImage("1.png");

	public MyFrame() {
		setTitle("게임 만들기");
		setSize(840+6, 600+26+3);
		setVisible(true);
		setResizable(false); //크기 고정
		setLocation(500, 250);
		//		this.aImage = Toolkit.getDefaultToolkit().getImage("1.png");
	}

	public void paint(Graphics g) {
		for (int iY = 0; iY < 10; iY++) {
			for (int iX = 0; iX < 14; iX++) {
				g.drawImage(this.aImage, iX*60+3, iY*60+26, this);				
			}
		}
	}

	public static void main(String[] args) {
		MyFrame frame = new MyFrame();
	}
}
