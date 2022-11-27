package Main;

import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class Projectile {
	public int[] location;
	public Rectangle bounds;
	public ImageIcon image;
	
	public Projectile (int[] location, Rectangle bounds) {
		this.location = location;
		this.bounds = bounds;
	}
}
