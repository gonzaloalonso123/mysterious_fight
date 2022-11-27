package Main;

import java.awt.Image;
import java.awt.Rectangle;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class Character implements ICharacter {

	private int hp = 100;
	private int[] location = new int[2];
	public Image currentImage;
	private Rectangle bodyHitbox;
	private Rectangle attackHitbox;
	private String name;
	private int movementUnits = 10;
	private int direction;
	
	private ArrayList<Image> imgAbility1 = new ArrayList<Image>();
	private ArrayList<Image> imgAbility2 = new ArrayList<Image>();
	private ArrayList<Image> imgAbility3 = new ArrayList<Image>();
	private ArrayList<Image> imgAbility4 = new ArrayList<Image>();
	private ArrayList<Image> imgMove = new ArrayList<Image>();
	private ArrayList<Image> imgIdle = new ArrayList<Image>();
	
	public Chunk[] move(Directions direction)
	{
		Chunk[] chunks = new Chunk[imgMove.size()];
		for (int i = 0; i < imgMove.size(); i++)
		{
			int[] movement = new int[2];
			switch (direction) {
				case Right:
					this.direction = 1;
					movement[0] += this.movementUnits;
					movement[1] = 0;
				case Left:
					this.direction = -1;
					movement[0] -= this.movementUnits;
					movement[1] = 0;
				default:
					break;
			}
			
			Chunk moveChunk = new Chunk (imgMove.get(i), null, null, 0, movement);
			chunks[i] = moveChunk;
		}
		
		return chunks;
	}
	
	public Chunk[] idle()
	{
		Chunk[] chunks = new Chunk[imgIdle.size()];
		for (int i = 0; i < imgIdle.size(); i++)
		{
			Chunk idleChunk = new Chunk (imgIdle.get(i), null, null, 0, null);
			chunks[i] = idleChunk;
		}
		
		return chunks;
	}
	
	public int getHp() {
		return hp;
	}

	public Rectangle getBodyHitbox() {
		return bodyHitbox;
	}

	public void setBodyHitbox(Rectangle bodyHitbox) {
		this.bodyHitbox = bodyHitbox;
	}

	public Rectangle getAttackHitbox() {
		return attackHitbox;
	}

	public void setAttackHitbox(Rectangle attackHitbox) {
		this.attackHitbox = attackHitbox;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public int[] getLocation() {
		return location;
	}

	public void setLocation(int[] location) {
		this.location = location;
	}

	public Image getCurrentImage() {
		return currentImage;
	}

	public void setCurrentImage (Image currentImage) {
		this.currentImage = currentImage;
	}

	@Override
	public Chunk[] ability1() {
		return null;
	}

	@Override
	public Chunk[] ability2() {
		return null;
	}

	@Override
	public Chunk[] ability3() {
		return null;		
	}
	
	@Override
	public Chunk[] ability4() {
		return null;		
	}

	@Override
	public void substractHP(int hp) {
		this.hp -= hp;
	}
}
