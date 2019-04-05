import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class MenuEx extends JFrame{
	private JLabel imgLabel = new JLabel();
	public MenuEx() {
		setTitle("메뉴 예제");
		createMenu();
		getContentPane().add(imgLabel, BorderLayout.CENTER);
		setSize(250, 200);
		setVisible(true);
	}

	private void createMenu() {
		JMenuBar mb = new JMenuBar();
		JMenu screenMenu = new JMenu("Screen");

		MenuActionListener listener = new MenuActionListener();
		
		screenMenu.add(new JMenuItem("Load")).addActionListener(listener);
		screenMenu.addSeparator();
		screenMenu.add(new JMenuItem("Hide")).addActionListener(listener);
		screenMenu.addSeparator();
		screenMenu.add(new JMenuItem("Reshow")).addActionListener(listener);
		screenMenu.addSeparator();
		screenMenu.add(new JMenuItem("Exit")).addActionListener(listener);

		mb.add(screenMenu);
		mb.add(new JMenu("aa"));
		mb.add(new JMenu("bb"));
		mb.add(new JMenu("cc"));
		mb.add(new JMenu("dd"));
		
		setJMenuBar(mb);
	}

	class MenuActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			String cmd = e.getActionCommand();
			switch (cmd) {
			case "Load":
				if (imgLabel.getIcon() != null) {
					return;
				}
				imgLabel.setIcon(new ImageIcon("dog.jpg"));
				break;
			case "Hide":
				imgLabel.setVisible(false);
				break;
			case "Reshow":
				imgLabel.setVisible(true);
				break;
			case "Exit":
				System.exit(0);
				break;
			}
		}
	}
	public static void main(String[] args) {
		new MenuEx();
	}
}
