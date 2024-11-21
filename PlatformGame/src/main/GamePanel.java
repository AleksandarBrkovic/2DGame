package main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import javax.swing.JPanel;

import inputs.KeyboardInputs;
import inputs.MouseInputs;

public class GamePanel extends JPanel {

	private MouseInputs mouseInputs;
	private float xDelta = 100, yDelta = 100;
	private float xDir = 1 , yDir = 1;
	private int frames = 0;
	private long lastCheck = 0;
	private Color color = new Color(150,20,90);
	private Random random;

	public GamePanel() {
		random = new Random();
		mouseInputs = new MouseInputs(this);
		addKeyListener(new KeyboardInputs(this));
		addMouseListener(mouseInputs);
		addMouseMotionListener(mouseInputs);

	}

	public void changeXDelta(int value) {
		this.xDelta += value;
	
	}

	public void changeYDelta(int value) {
		this.yDelta += value;
		
	}
	
	public void setRectPos(int x, int y) {
		this.xDelta = x;
		this.yDelta = y;
		
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		updateRectangole();
		g.setColor(color);
		g.fillRect((int)xDelta, (int)yDelta, 200, 50);
		
	
		
		
		


	}

	private void updateRectangole() {
		xDelta +=xDir;
		
		if(xDelta > 400 || xDelta < 0 ) {
			xDir *= -1;
			color= getRandomColor();
		}
		
		yDelta +=yDir;
		
		if(yDelta > 400 || yDelta < 0) {
			yDir *= -1;
			color= getRandomColor();
		}
		
	}

	private Color getRandomColor() {
		int r = random.nextInt(255); //restituisce un random da 0 ad 255
		int g = random.nextInt(255);
		int b = random.nextInt(255);
		
		return new Color(r, g, b);
	}
	
	//loop fatto male perché non è consistente con gli FPS
	/*public void paintComponent(Graphics g) {
		super.paintComponent(g);

		g.fillRect(xDelta, yDelta, 200, 50);
		
		frames++;
		if(System.currentTimeMillis() - lastCheck>=1000) { //ti da il tempo in millisecondi
			lastCheck= System.currentTimeMillis();
			System.out.println("FPS: " + frames);
			frames = 0;
			
		}
		
		repaint();

	}*/

}