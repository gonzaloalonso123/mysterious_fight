package Main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GameEngine extends JPanel implements ActionListener {

	final int WIDTH = 1000;
	final int HEIGHT = 600;
	
	ArrayList<ArrayList<Chunk>> allChunks = new ArrayList<ArrayList<Chunk>>();
	
	boolean gameOver = false;
	
	Character[] characters = new Character[2];
	
	
	Timer timer;
	Image background;
	
	GameEngine()
	{	
		addKeyListener(new KeyP());
        setFocusable(true);
        requestFocusInWindow();
		setPreferredSize(new Dimension(WIDTH, HEIGHT));	

		characters[0] = new Goliath();
		characters[1] = new Goliath();
		
		background = new ImageIcon(getClass().getResource("/Images/background.jpeg")).getImage();	
		timer = new Timer(250, this);
		timer.start();
	}
	
	public static void dealDmg(int damage) {
		
	}
	
	
	public void paint(Graphics g)
	{
		super.paint(g);
		Graphics2D g2D = (Graphics2D) g;	
		
		g2D.drawImage(background, 0,0,null);
		g2D.setFont(new Font("Ink free", Font.BOLD, 20));
		g2D.setColor(Color.red);
		g2D.drawString("▊▊▊▊▊▊▊▊▊▊", 5, 20);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		executeNextChunks();
		
		repaint();
	}
	
	public void executeNextChunks() {
		
		for(int i = 0; i < 2; i++) {
			Chunk currentChunk = allChunks.get(i).get(0);
			characters[i].setCurrentImage(currentChunk.getImage());
		}
	}
	
	public void executeChunk(Chunk character) {
		character.setC
	}
	
	public void checkPlayerColision()
	{
	}
	
	public void gameOver()
	{
		gameOver = true;
		timer.stop();
		repaint();
	}
	
	public class KeyP extends KeyAdapter
	{
		@Override
		public void keyPressed(KeyEvent e) {
			// TODO Auto-generated method stub
			super.keyPressed(e);
			
			switch(e.getKeyCode())
			{
			case KeyEvent.VK_UP:
				break;
			case KeyEvent.VK_DOWN:
				break;
			case KeyEvent.VK_LEFT:
				break;
			case KeyEvent.VK_RIGHT:
				break;
			case KeyEvent.VK_SPACE:
				character1.ability1();
				break;
			case KeyEvent.VK_A:
				break;
			case KeyEvent.VK_S:
				break;
			case KeyEvent.VK_D:
				break;
			case KeyEvent.VK_F:
				break;

			}	
		}
	}
}
