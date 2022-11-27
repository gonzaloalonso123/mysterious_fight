package Main;

import java.awt.Image;
import java.awt.Rectangle;
import java.util.Vector;

import javax.swing.ImageIcon;

public class Chunk {

	private Image image;
	private Rectangle bodyHitbox = new Rectangle();
	private Rectangle attackHitbox = new Rectangle();
	private int[] movement;
	private int damage;
	
	public Chunk(Image image, Rectangle bodyHitbox, Rectangle attackHitbox, int damage, int[] movement) {
		this.image = image;
		this.bodyHitbox = bodyHitbox;
		this.attackHitbox = attackHitbox;
		this.damage = damage;
		this.movement = movement;
	}
	
	public void setMovement(int[] movement) {
		this.movement = movement;
	}
	
	public int[] getMovement() {
		return movement;
	}

	public Image getImage() {
		return image;
	}


	public Rectangle getBodyHitbox() {
		return bodyHitbox;
	}


	public Rectangle getAttackHitbox() {
		return attackHitbox;
	}

	public int getDamage() {
		return damage;
	}
}
