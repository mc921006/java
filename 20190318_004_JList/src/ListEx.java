import java.awt.*;
import javax.swing.*;

public class ListEx extends JFrame{
	private String [] fruits = {"사과", "바나나", "키위", "망고", "배",
			"복숭자", "체리", "딸기", "블래체리"};
	private ImageIcon [] images = {new ImageIcon("icon1.png"),
			new ImageIcon("icon2.png"), 
			new ImageIcon("icon3.png"), 
			new ImageIcon("icon4.png")};
	public ListEx() {
		setTitle("리스트 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		JList<String> strlist = new JList<String>(fruits);
		c.add(strlist);
		
		JList<ImageIcon> imagelist = new JList<ImageIcon>();
		imagelist.setListData(images);
		c.add(imagelist);
		
		JList<String> scrolllist = new JList<String>(fruits);
		c.add(new JScrollPane(scrolllist));
		
		setSize(300, 300);
		setVisible(true);
	}
		public static void main(String[] args) {
			new ListEx();
		}

}
