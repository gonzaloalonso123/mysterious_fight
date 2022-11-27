package Main;

import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class Chunk {

	private Image image;
	private Rectangle bodyHitbox = new Rectangle();
	private Rectangle damageHitbox = new Rectangle();
	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}

	public Rectangle getBodyHitbox() {
		return bodyHitbox;
	}

	public void setBodyHitbox(Rectangle bodyHitbox) {
		this.bodyHitbox = bodyHitbox;
	}

	public Rectangle getDamageHitbox() {
		return damageHitbox;
	}

	public void setDamageHitbox(Rectangle damageHitbox) {
		this.damageHitbox = damageHitbox;
	}

	public int[] getLocation() {
		return location;
	}

	public void setLocation(int[] location) {
		this.location = location;
	}

	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}

	private int[] location = new int[2];
	private int damage;

	public Chunk(Image image, Rectangle bodyHitbox, Rectangle damageHitbox, int damage, int[] location) {
		this.image = image;
		this.bodyHitbox = bodyHitbox;
		this.damageHitbox = damageHitbox;
		this.damage = damage;
		this.location = location;	
	}

}
