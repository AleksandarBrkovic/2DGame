package main;

import javax.swing.JFrame;

public class GameWindow {
	private JFrame jframe;

	public GameWindow(GamePanel gamePanel) {

		jframe = new JFrame();

		
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jframe.add(gamePanel);
		jframe.setLocationRelativeTo(null);
		jframe.setResizable(false);
		jframe.pack(); //setta le dimensioni della finestra in quelle preferite del jpanel
		jframe.setVisible(true);

	}

}