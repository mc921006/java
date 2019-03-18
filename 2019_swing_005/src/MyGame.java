import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

class MySokoban extends JFrame implements KeyListener, ActionListener{

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
	final int InfoSize = 200;
	final String Title = "게임 만들기";
	final String RTitle = "reset";
	Image IWall = Toolkit.getDefaultToolkit().getImage("Wall1.png");
	//	Image IWall = Toolkit.getDefaultToolkit().getImage("1.gif");
	Image IManF = Toolkit.getDefaultToolkit().getImage("ManF1.png");
	Image IManB = Toolkit.getDefaultToolkit().getImage("ManB1.png");
	Image IManL = Toolkit.getDefaultToolkit().getImage("ManL1.png");
	Image IManR = Toolkit.getDefaultToolkit().getImage("ManR1.png");
	Image IMan = IManF;
	Image IBox = Toolkit.getDefaultToolkit().getImage("box1.png");
	Image IDot = Toolkit.getDefaultToolkit().getImage("Dot1.png");
	Image IRoad = Toolkit.getDefaultToolkit().getImage("Road1.png");
	int iStage = 0;
	int iXMan = 0;
	int iYMan = 0;
	boolean bEndGame = true;
	int iScore;
	JLabel TitleLabel;
	JButton Upbtn, Downbtn, Leftbtn, Rightbtn, Resetbtn;

	char [][] Map = new char[BYSize][BXSize];

	String [][] Stage = {
			{
				"##############", 
				"##############", 
				"###  #   #####", 
				"### B..B #####", 
				"### B..B######", 
				"### B..B #####", 
				"###@ #   #####", 
				"##############", 
				"##############", 
				"##############"
			},
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
				"#     ## .   #",
				"#  @  #### B #",
				"#    #####   #",
				"#      ##    #",
				"#  B         #",
				"#            #",
				"####   ### B #",
				"####..####   #",
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
			},
			{
				"##############",
				"#           .#",
				"# @       ####",
				"####   B  ##.#",
				"###       B  #",
				"##           #",
				"#  B      B  #",
				"#   #####  ###",
				"#. ######.####",
				"##############"
			},
			{
				"##############",
				"#           .#",
				"# B###   B####",
				"#  .##     ###",
				"#####  @    ##",
				"####       ###",
				"###       ####",
				"##  B   B#####",
				"#.          .#",
				"##############"
			},
			{
				"##############",
				"#.    B      #",
				"#######   @  #",
				"#           .#",
				"# B  #########",
				"#            #",
				"##########   #",
				"#######    B #",
				"#..     B    #",
				"##############"
			}
	};

	public MySokoban() {
		this.setTitle(Title);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = this.getContentPane();
		c.setLayout(null);
		TitleLabel = new JLabel();
		TitleLabel.setFont(new Font("굴림", Font.ITALIC, 25));
		TitleLabel.setBounds(890, 50, 200, 50);
		c.add(TitleLabel);
		Upbtn = new JButton("▲");
		Upbtn.setBounds(920, 150, 50, 50);
		Upbtn.addActionListener(this);
		c.add(Upbtn);
		Downbtn = new JButton("▼");
		Downbtn.setBounds(920, 250, 50, 50);
		Downbtn.addActionListener(this);
		c.add(Downbtn);
		Leftbtn = new JButton("◀");
		Leftbtn.setBounds(870, 200, 50, 50);
		Leftbtn.addActionListener(this);
		c.add(Leftbtn);
		Rightbtn = new JButton("▶");
		Rightbtn.setBounds(970, 200, 50, 50);
		Rightbtn.addActionListener(this);
		c.add(Rightbtn);

		Resetbtn = new JButton(RTitle);		
		Resetbtn.setBounds(900, 350, 100, 50);
		Resetbtn.addActionListener(this);
		c.add(Resetbtn);

		c.addKeyListener(this);
		c.setFocusable(true);
		c.requestFocus();
		this.setSize(DXSize+MXSize+InfoSize, DYSize+MYSize);
		this.setVisible(true);
		this.setResizable(false); //크기 고정
		//		setLocation(500, 250);

		LoadMap();
		TitleLabel.setText("Score : " + iScore);
	}

	void LoadMap() {
		for (int i = 0; i < Stage[iStage].length; i++) {
			Map[i] = Stage[iStage][i].toCharArray();	
		}
		IMan = IManF;
		iScore = 0;
	}

	public void paint(Graphics g) {

		super.paintComponents(g);
		Container c = this.getContentPane();
		c.requestFocus();

		Image aImage;
		bEndGame = true;

		while(true) {
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
						char[] MapLine = Stage[iStage][iY].toCharArray();
						if (MapLine[iX] != '.') {
							bEndGame = false;
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
			this.setTitle(Title+" [Score : "+ iScore + "]");
			TitleLabel.setText("Score : " + iScore);

			if (true == bEndGame) {
				++iStage;
				if (Stage.length <= iStage) { //게임 종료
					System.out.println(Stage.length +", "+ iStage);
					JOptionPane.showMessageDialog(null, "종료");
					iStage = 0;
					System.exit(0);break;
				}
				JOptionPane.showMessageDialog(null, "다음판"+" [Score : "+ iScore + "]");
				LoadMap();
				continue;
			}
			break;
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
		case KeyEvent.VK_HOME:
			//			Map[iY][iX] = ' ';
			LoadMap();
			repaint();
			return;
		}
		if (Map[iY][iX] != '#') {
			if (Map[iY][iX] == 'B') {
				if (Map[2*iY-iYMan][2*iX-iXMan] == '#') {
					iY = iYMan;
					iX = iXMan;
					iScore--;
				}
				else if (Map[2*iY-iYMan][2*iX-iXMan] == 'B') {
					iY = iYMan;
					iX = iXMan;
					iScore--;
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
			iScore++;
		}
		repaint();
	}

	@Override
	public void keyTyped(KeyEvent e) 
	{}
	@Override
	public void keyReleased(KeyEvent e) {}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton Temp = (JButton)e.getSource();
		if (Temp.equals(Resetbtn)) {
			LoadMap();
			repaint();
		}else if(Temp.equals(Upbtn)) {
			KeyEvent eTemp = new KeyEvent(Temp, 0, 0, 0, 0);
			eTemp.setKeyCode(KeyEvent.VK_UP);
			keyPressed(eTemp);
		}else if(Temp.equals(Downbtn)) {
			KeyEvent eTemp = new KeyEvent(Temp, 0, 0, 0, 0);
			eTemp.setKeyCode(KeyEvent.VK_DOWN);
			keyPressed(eTemp);
		}else if(Temp.equals(Leftbtn)) {
			KeyEvent eTemp = new KeyEvent(Temp, 0, 0, 0, 0);
			eTemp.setKeyCode(KeyEvent.VK_LEFT);
			keyPressed(eTemp);
		}else if(Temp.equals(Rightbtn)) {
			KeyEvent eTemp = new KeyEvent(Temp, 0, 0, 0, 0);
			eTemp.setKeyCode(KeyEvent.VK_RIGHT);
			keyPressed(eTemp);
		}
	}

}

public class MyGame {
	public static void main(String[] args) {
		MySokoban aMySokoban = new MySokoban();
	}
}