import java.awt.*;
import javax.swing.*;

class MySokoban extends JFrame{
	
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
	Image IMan = Toolkit.getDefaultToolkit().getImage("Man.png");
	Image IBox = Toolkit.getDefaultToolkit().getImage("Box.png");
	Image IDot = Toolkit.getDefaultToolkit().getImage("Dot.png");
	Image IRoad = Toolkit.getDefaultToolkit().getImage("Road.png");
	int iStage = 0;
	
	char [][] Map = new char[BYSize][BXSize];
	
	String [][] Stage = {
						{
						"##############",
						"# @  ####    #",
						"# .  ####  . #",
						"#            #",
						"#### B..B ####",
						"###.  ##  .###",
						"###        ###",
						"###B #### B###",
						"###  ####  ###",
						"##############"
						},
						{
						"##############",
						"# @  ####  @ #",
						"# .  ####  . #",
						"#            #",
						"#### B..B ####",
						"###.  ##  .###",
						"###        ###",
						"###B #### B###",
						"###  ####  ###",
						"##############"
						}
	
					   };
	
	public MySokoban() {
		setTitle("게임 만들기");
		setSize(DXSize+MXSize, DYSize+MYSize);
		setVisible(true);
		setResizable(false); //크기 고정
		setLocation(500, 250);

		for (int i = 0; i < Stage[iStage].length; i++) {
			Map[i] = Stage[iStage][i].toCharArray();	
		}
	}

	public void paint(Graphics g) {
		Image aImage;
		for (int iY = 0; iY < BYSize; iY++) {
			for (int iX = 0; iX < BXSize; iX++) {
				switch (Map[iY][iX]) {
				case '#':
					aImage = this.IWall;	
					break;
				case '@':
					aImage = this.IMan;	
					break;
				case 'B':
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
	}
}

public class MyGame {
	public static void main(String[] args) {
		MySokoban aMySokoban = new MySokoban();
	}
}