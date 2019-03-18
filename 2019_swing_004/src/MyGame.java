import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

class MySokoban extends JFrame implements KeyListener{

	final int IXSize = 60; // Image X size : Pixel
	final int IYSize = 60; // Image Y size : Pixel
	final int BXSize = 14; // Block X size
	final int BYSize = 10; // Block Y size
	final int DXSize = IXSize * BXSize; //Display X size : Pixel
	final int DYSize = IYSize * BYSize; //Display Y size : Pixel
	final int LThick = 3; // Line Thickness : Pixel
	final int MXSize = LThick+LThick; // Margin X size : Pixel(left+right)
	final int MYUpSize = 23+LThick; // Margin Y UP size : Pixel(title+top)
	final int MYSize = MYUpSize+LThick; // Margin Y size : Pixel(bottom)
	Image IWall = Toolkit.getDefaultToolkit().getImage("wall.png");
	Image IManF = Toolkit.getDefaultToolkit().getImage("ManF.png");
	Image IManB = Toolkit.getDefaultToolkit().getImage("ManB.png");
	Image IManL = Toolkit.getDefaultToolkit().getImage("ManL.png");
	Image IManR = Toolkit.getDefaultToolkit().getImage("ManR.png");
	Image IMan = IManF;
	Image IBox = Toolkit.getDefaultToolkit().getImage("Box.png");
	Image IDot = Toolkit.getDefaultToolkit().getImage("Dot.png");
	Image IRoad = Toolkit.getDefaultToolkit().getImage("Road.png");
	int iStage = 0;
	int iXMan = 0;
	int iYMan = 0;

	char [][] Map = new char[BYSize][BXSize];

	String [][] Stage = {
			{
				"##############",
				"#    ####    #",
				"#     B.     #",
				"#    @       #",
				"##   B..B   ##",
				"## .  ##  . ##",
				"##          ##",
				"## B      B ##",
				"##   ####   ##",
				"##############"
			},
			{
				"##############",
				"#    ####  @ #",
				"#            #",
				"#            #",
				"##   B..B   ##",
				"## .  ##  . ##",
				"##          ##",
				"## B  ##  B ##",
				"##   ####   ##",
				"##############"
			}

	};

	public MySokoban() {
		setTitle("게임 만들기");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = this.getContentPane();
		c.setLayout(null);
		c.addKeyListener(this);
		c.setFocusable(true);
		c.requestFocus();
		setSize(DXSize+MXSize, DYSize+MYSize);
		setVisible(true);
		setResizable(false); //크기 고정
		setLocation(500, 250);
		
		LoadMap();
	}
	
	void LoadMap() {
		for (int i = 0; i < Stage[iStage].length; i++) {
			Map[i] = Stage[iStage][i].toCharArray();	
		}
	}

	public void paint(Graphics g) {
		Image aImage;
		int iMatch = 0;
		int iBox = 0;
		for (int iY = 0; iY < BYSize; iY++) {
			for (int iX = 0; iX < BXSize; iX++) {
				switch (Map[iY][iX]) {
				case '#':
					aImage = this.IWall;	
					break;
				case '@':
					aImage = this.IMan;	
					iXMan = iX;
					iYMan = iY;
					break;
				case 'B':
					iBox++;
					char[] MapLine = Stage[iStage][iY].toCharArray();
					if (MapLine[iX] == '.') {
						iMatch++;
					}
					aImage = this.IBox;	
					break;
				case '.':
					aImage = this.IDot;		
					break;
				default:
					aImage = this.IRoad;
					break;
				}
				g.drawImage(aImage, iX*IXSize+LThick, iY*IYSize+MYUpSize, this);
			}
		}
		if (iBox == iMatch) {
			Scanner scanner = new Scanner(System.in);
			scanner.nextLine();
			
			iStage++;
			LoadMap();
			repaint();
			System.out.println("클리어");
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
//		Map[iYMan][iXMan] = ' ';
		int iX = iXMan; // ix는 뉴좌표, ixman은 올드좌표
		int iY = iYMan; // iy는 뉴좌표, iyman은 올드좌표
		switch (e.getKeyCode()) {
		case KeyEvent.VK_UP:
			IMan = IManB;
			iY--;
			break;
		case KeyEvent.VK_DOWN:
			IMan = IManF;
			iY++;
			break;
		case KeyEvent.VK_LEFT:
			IMan = IManL;
			iX--;
			break;
		case KeyEvent.VK_RIGHT:
			IMan = IManR;
			iX++;
			break;
		}
		if (Map[iY][iX] != '#') {
			if (Map[iY][iX] == 'B') {
				if (Map[2*iY-iYMan][2*iX-iXMan] == '#') {
					iY = iYMan;
					iX = iXMan;
				}
				else if (Map[2*iY-iYMan][2*iX-iXMan] == 'B') {
					iY = iYMan;
					iX = iXMan;
				}
				else {
					Map[2*iY-iYMan][2*iX-iXMan] = 'B';
				}
			}
			char[] MapLine = Stage[iStage][iYMan].toCharArray();
			if (MapLine[iXMan] == '.') {
				Map[iYMan][iXMan] = '.';
			}else {
				Map[iYMan][iXMan] = ' ';	
			}
			Map[iY][iX] = '@';
		}
		repaint();
	}

	@Override
	public void keyTyped(KeyEvent e) 
	{}
	@Override
	public void keyReleased(KeyEvent e) {}
}

public class MyGame {
	public static void main(String[] args) {
		MySokoban aMySokoban = new MySokoban();
	}
}