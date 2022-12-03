package Main;

import java.awt.Image;
import java.awt.Rectangle;
import java.util.Vector;

import javax.swing.ImageIcon;

public class Chunk {

	private Image image;
	private Rectangle bodyHitbox;
	private Rectangle attackHitbox;
	private int[] movement;
	private int damage;
	private String sound;
	
	public Chunk(Image image, Rectangle bodyHitbox, Rectangle attackHitbox, int damage, int[] movement, String sound) {
		this.image = image;
		this.bodyHitbox = bodyHitbox;
		this.attackHitbox = attackHitbox;
		this.damage = damage;
		this.movement = movement;
		this.sound = sound;
	}
	
	public String getSound() {
		return sound;
	}

	public void setSound(String sound) {
		this.sound = sound;
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

	public void setImage(Image image) {
		this.image = image;
	}

	public void setBodyHitbox(Rectangle bodyHitbox) {
		this.bodyHitbox = bodyHitbox;
	}

	public void setAttackHitbox(Rectangle attackHitbox) {
		this.attackHitbox = attackHitbox;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}
}
