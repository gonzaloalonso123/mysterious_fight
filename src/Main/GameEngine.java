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

	// new
	// new

	boolean gameOver = false;

	Character[] characters = new Character[2];

	Timer timer;
	Image background;

	GameEngine() {
		addKeyListener(new KeyP());
		setFocusable(true);
		requestFocusInWindow();
		setPreferredSize(new Dimension(WIDTH, HEIGHT));

		characters[0] = new PossessedMonk();
		characters[1] = new PossessedMonk();

		characters[0].setLocation(new int[] { 500, 200 });
		characters[1].setLocation(new int[] { 50, 200 });
		characters[0].setDirection(-1);
		characters[1].setDirection(1);

		allChunks.add(new ArrayList<Chunk>());
		allChunks.add(new ArrayList<Chunk>());

		background = new ImageIcon(getClass().getResource("/Images/background.jpeg")).getImage();
		timer = new Timer(250, this);
		timer.start();
	}

	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2D = (Graphics2D) g;

		g2D.drawImage(background, 0, 0, null);
		g2D.setFont(new Font("Ink free", Font.BOLD, 20));
		g2D.setColor(Color.red);
		g2D.drawString("▊▊▊▊▊▊▊▊▊▊", 5, 20);
		
		for(int i = 0; i < characters.length; i++) {
			if(characters[i].getDirection() == 1) {
				g2D.drawImage(characters[i].currentImage, characters[i].getLocation()[0], characters[0].getLocation()[1], null);				
			}
			else {			
				int width = characters[i].currentImage.getWidth(getFocusCycleRootAncestor());
				int height = characters[i].currentImage.getHeight(getFocusCycleRootAncestor());
				g2D.drawImage(characters[i].currentImage, characters[i].getLocation()[0] + width, characters[i].getLocation()[1], -width, height, null);
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		executeNextChunks();
		repaint();
	}

	public void executeNextChunks() {

		for (int i = 0; i < 2; i++) {
			if (allChunks.get(i).size() == 0) {
				this.addChunks(i, characters[i].idle());
			}

			Chunk currentChunk = allChunks.get(i).get(0);

			characters[i].setCurrentImage(currentChunk.getImage());
			if (currentChunk.getMovement() != null) {
				characters[i].setLocation(new int[] { characters[i].getLocation()[0] + currentChunk.getMovement()[0],
						characters[i].getLocation()[1] + currentChunk.getMovement()[1] });
			}
			if (currentChunk.getBodyHitbox() != null) {
				characters[i].setBodyHitbox(currentChunk.getBodyHitbox());
			}
			if (currentChunk.getAttackHitbox() != null) {
				characters[i].setAttackHitbox(currentChunk.getAttackHitbox());
			}

		}

		for (int i = 0; i < 2; i++) {
			Chunk currentChunk = allChunks.get(i).get(0);
			Chunk otherChunk = allChunks.get((i + 1) % 2).get(0);
			if (currentChunk.getDamage() != 0) {
				if (currentChunk.getAttackHitbox().intersects(otherChunk.getBodyHitbox())) {
					characters[i + 1 % 2].substractHP(currentChunk.getDamage());
				}
			}
		}

		allChunks.get(0).remove(0);
		allChunks.get(1).remove(0);

		if (characters[0].getHp() <= 0) {
			this.gameOver = true;
		}

		if (characters[1].getHp() <= 0) {
			this.gameOver = true;
		}

	}

	public void addChunks(int index, Chunk[] chunks) {
		for (int i = 0; i < chunks.length; i++) {
			allChunks.get(index).add(chunks[i]);
		}
	}

	public void gameOver() {
		gameOver = true;
		timer.stop();
		repaint();
	}

	public class KeyP extends KeyAdapter {
		@Override
		public void keyPressed(KeyEvent e) {
			super.keyPressed(e);

			switch (e.getKeyCode()) {
			case KeyEvent.VK_UP:
				addChunks(0, characters[0].move(Directions.Up));
				break;
			case KeyEvent.VK_LEFT:
				addChunks(0, characters[0].move(Directions.Left));
				break;
			case KeyEvent.VK_RIGHT:
				addChunks(0, characters[0].move(Directions.Right));
				break;
			case KeyEvent.VK_MINUS:
				addChunks(0, characters[0].ability1());
				break;
			case KeyEvent.VK_PLUS:
				addChunks(0, characters[0].ability2());
				break;
			case KeyEvent.VK_ENTER:
				addChunks(0, characters[0].ability3());
				break;
			case KeyEvent.VK_DOWN:
				addChunks(0, characters[0].ability4());
				break;
			case KeyEvent.VK_A:
				addChunks(1, characters[1].move(Directions.Left));
				break;
			case KeyEvent.VK_D:
				addChunks(1, characters[1].move(Directions.Right));
				break;
			case KeyEvent.VK_W:
				addChunks(1, characters[1].move(Directions.Up));
				break;
			case KeyEvent.VK_SPACE:
				addChunks(1, characters[1].ability1());
				break;
			case KeyEvent.VK_E:
				addChunks(1, characters[1].ability2());
				break;
			case KeyEvent.VK_SHIFT:
				addChunks(1, characters[1].ability3());
				break;
			case KeyEvent.VK_Q:
				addChunks(1, characters[1].ability4());
				break;
			}
		}
	}
}
