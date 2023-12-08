package Main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;
 
public class GameEngine extends JPanel implements ActionListener {

	final int WIDTH = 1000;
	final int HEIGHT = 600;
	
	final int PLAYERS = 2;
	final int MAX_ACTIONS = 2;
	
	final int MAX_HEALTH = 20;

	ArrayList<ArrayList<Chunk>> allChunks = new ArrayList<ArrayList<Chunk>>();

	boolean gameOver = false;

	Character[] characters = new Character[PLAYERS];
	int[] actions = new int[MAX_ACTIONS];

	Timer timer;
	Image background;

	GameEngine() {
		addKeyListener(new KeyP());
		setFocusable(true);
		requestFocusInWindow();
		setPreferredSize(new Dimension(WIDTH, HEIGHT));

		characters[0] = new PossessedMonk(100, HEIGHT - 100 - 400);
		characters[1] = new Psycon(WIDTH - 425/2 - 75 - 100, HEIGHT - 100 - 208);

		characters[0].setDirection(1);
		characters[1].setDirection(-1);

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
		g2D.setFont(new Font("Arial Black", Font.BOLD, 30));
		g2D.setColor(Color.black);

		for (int player = 0; player < PLAYERS; player++) {
			if (characters[player].getDirection() == 1) {
				g2D.drawImage(characters[player].currentImage, characters[player].getLocation()[0],
						characters[player].getLocation()[1], null);
			} 
			else {
				try {
					int width = characters[player].currentImage.getWidth(getFocusCycleRootAncestor());
					int height = characters[player].currentImage.getHeight(getFocusCycleRootAncestor());
					g2D.drawImage(characters[player].currentImage, characters[player].getLocation()[0] + width,
							characters[player].getLocation()[1], -width, height, null);
				} catch (Exception e) {
					System.out.println("Not loaded");
				}
			}
			if (characters[player].getAttackHitbox() != null) 
			{
				//paintHitBox(g2D, characters[player].getAttackHitbox());
			}
			if (characters[player].getBodyHitbox() != null) {
				//paintHitBox(g2D, characters[player].getBodyHitbox());
			}
			
			String playerHealth = "";
			if (player == 0)
			{
				for (int i = 0; i < MAX_HEALTH; i++)
				{
					if (characters[player].hp > i)
						playerHealth += ".";
					else
						playerHealth += " ";
				}				
			}
			else
			{
				for (int i = MAX_HEALTH - 1; i >= 0; i--)
				{
					if (characters[player].hp > i)
						playerHealth += ".";
					else
						playerHealth += " ";
				}				
			}
			g2D.drawString(playerHealth, player == 0 ? 7 : WIDTH - 225, 40);
		}
		if (gameOver)
		{
			if (characters[0].hp == 0 && characters[1].hp == 0)
				g2D.drawString("DRAW", WIDTH / 2 - 10, 40);
			else if (characters[0].hp == 0)
				g2D.drawString("PLAYER " + 2 + " WINS", WIDTH / 2 - 120, 40);
			else if (characters[1].hp == 0)
				g2D.drawString("PLAYER " + 1 + " WINS", WIDTH / 2 - 120, 40);
		}
	}

	public void paintHitBox(Graphics2D g2D, Rectangle bounds) {
		g2D.drawRect(bounds.x, bounds.y, bounds.width, bounds.height);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		executeNextChunks();
		repaint();
	}

	public void executeNextChunks() {
		if (!gameOver) {
			for (int player = 0; player < PLAYERS; player++) {
				addIdleChunkIfNeeded(player);
				move(player);
				setAttackHitbox(player);
				addSound(player);
			}
			
			for (int player = 0; player < PLAYERS; player++) {
				dealDamage(player);
			}
			
			for (int player = 0; player < PLAYERS; player++) {
				setImage(player);
				checkDead(player);
				freeSpaceForNewActionIfEnded(player);
				removeChunk(player);
			}			
		}
	}
	
	public void addIdleChunkIfNeeded(int player)
	{
		if (allChunks.get(player).size() == 0)
			addChunks(player, characters[player].idle());
	}
	
	public void setImage(int player)
	{
		characters[player].setCurrentImage(allChunks.get(player).get(0).getImage());
	}
	
	public void move(int player)
	{
		Chunk currentChunk = allChunks.get(player).get(0);
		if (currentChunk.getMovement() != null) {
			characters[player].setLocation(new int[] { characters[player].getLocation()[0] + currentChunk.getMovement()[0],
					characters[player].getLocation()[1] + currentChunk.getMovement()[1] });
		}	
		if (currentChunk.getBodyHitbox() != null) {
			characters[player].setBodyHitbox(currentChunk.getBodyHitbox());
		} else if (currentChunk.getMovement() != null) {
			Rectangle bodyHitBox = characters[player].getBodyHitbox();
			bodyHitBox.x += currentChunk.getMovement()[0];
			bodyHitBox.y += currentChunk.getMovement()[1];
			characters[player].setBodyHitbox(bodyHitBox);
		}
	}
	
	public void setAttackHitbox(int player)
	{
		Chunk currentChunk = allChunks.get(player).get(0);
		if (currentChunk.getAttackHitbox() != null) {
			Rectangle r = currentChunk.getAttackHitbox();
			if (characters[player].direction == 1)
			{
				characters[player].setAttackHitbox(new Rectangle(r.x, r.y, r.width, r.height));				
			}
			else
			{
				characters[player].setAttackHitbox(new Rectangle(r.x - r.width, r.y, r.width, r.height));
			}
		} else {
			characters[player].setAttackHitbox(null);
		}
	}
	
	public void addSound(int player)
	{
		Chunk currentChunk = allChunks.get(player).get(0);
		if (currentChunk.getSound() != null) {
			sound(currentChunk.getSound());
		}
	}

	public void addChunks(int player, Chunk[] chunks) {
		if (actions[player] < MAX_ACTIONS) {
			actions[player]++;
			for (int i = 0; i < chunks.length; i++) {
				allChunks.get(player).add(chunks[i]);
			}
		}
		
	}
	
	public void freeSpaceForNewActionIfEnded(int player)
	{
		if (allChunks.get(player).get(0).isLastChunk()) {
			actions[player]--;
		}
	}
	
	public void dealDamage(int player)
	{
		int otherPlayer = (player + 1) % PLAYERS;
		if (characters[player].getAttackHitbox() != null && characters[player].getAttackHitbox().intersects(characters[otherPlayer].getBodyHitbox())) {
			characters[otherPlayer].setHp(characters[otherPlayer].getHp() - allChunks.get(player).get(0).getDamage());
			allChunks.get(otherPlayer).clear();
			actions[otherPlayer] = 0;
			allChunks.get(otherPlayer).add(characters[otherPlayer].receiveDamage());
		}
	}
	
	public void removeChunk(int player)
	{
		allChunks.get(player).remove(0);
	}
	
	public void checkDead(int player)
	{
		if (characters[player].getHp() <= 0) {
			this.gameOver = true;
		}
	}

	public void gameOver() {
		gameOver = true;
		timer.stop();
		repaint();
	}

	public void sound(String path) {
		try {
			AudioInputStream audioInputStream = AudioSystem
					.getAudioInputStream(this.getClass().getResource("/Sounds" + path));
			Clip clip = AudioSystem.getClip();
			clip.open(audioInputStream);
			clip.start();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public class KeyP extends KeyAdapter {
		@Override
		public void keyPressed(KeyEvent e) {
			super.keyPressed(e);
			switch (e.getKeyCode()) {
				case KeyEvent.VK_UP:
					addChunks(1, characters[1].jump());
					break;
				case KeyEvent.VK_LEFT:
					addChunks(1, characters[1].move(Directions.Left));
					break;
				case KeyEvent.VK_RIGHT:
					addChunks(1, characters[1].move(Directions.Right));
					break;
				case KeyEvent.VK_DOWN:
					addChunks(1, characters[1].down());
					break;
				case KeyEvent.VK_MINUS:
					addChunks(1, characters[1].ability1());
					break;
				case KeyEvent.VK_PLUS:
					addChunks(1, characters[1].ability2());
					break;
				case KeyEvent.VK_ENTER:
					addChunks(1, characters[1].ability3());
					break;
				case KeyEvent.VK_A:
					addChunks(0, characters[0].move(Directions.Left));
					break;
				case KeyEvent.VK_D:
					addChunks(0, characters[0].move(Directions.Right));
					break;
				case KeyEvent.VK_W:
					addChunks(0, characters[0].jump());
					break;
				case KeyEvent.VK_S:
					addChunks(0, characters[0].down());
					break;
				case KeyEvent.VK_SPACE:
					addChunks(0, characters[0].ability1());
					break;
				case KeyEvent.VK_E:
					addChunks(0, characters[0].ability2());
					break;
				case KeyEvent.VK_SHIFT:
					addChunks(0, characters[0].ability3());
					break;
			}
		}
	}
}
