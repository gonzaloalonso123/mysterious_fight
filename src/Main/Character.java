package Main;

import java.awt.Image;
import java.awt.Rectangle;
import java.util.ArrayList;

public class Character implements ICharacter 
{	
	protected String name;
	protected int hp = 20;
	protected int movementUnits = 20;
	
	protected Rectangle bodyHitbox;
	protected Rectangle attackHitbox;
	
	protected ArrayList<Image> imgsAbility1 = new ArrayList<Image>();
	protected ArrayList<Image> imgsAbility2 = new ArrayList<Image>();
	protected ArrayList<Image> imgsAbility3 = new ArrayList<Image>();
	protected ArrayList<Image> imgsMove = new ArrayList<Image>();
	protected ArrayList<Image> imgsIdle = new ArrayList<Image>();
	protected ArrayList<Image> imgsJump = new ArrayList<Image>();
	protected ArrayList<Image> imgsDown = new ArrayList<Image>();
	protected Image imgsOnDamage;
	
	protected Image currentImage;
	protected int[] location = new int[2];
	protected int direction;
	
	public Character(int x, int y) {
		this.setLocation(new int[] {x, y});
	}
	
	public Chunk[] move(Directions direction) {
		Chunk[] chunks = new Chunk[imgsMove.size()];
		for (int i = 0; i < imgsMove.size(); i++) {
			int[] movement = new int[2];
			switch (direction) {
			case Right:
				this.direction = 1;
				movement[0] += this.movementUnits;
				movement[1] = 0;
				break;
			case Left:
				this.direction = -1;
				movement[0] -= this.movementUnits;
				movement[1] = 0;
				break;
			default:
				break;
			}
			if (direction == Directions.Left || direction == Directions.Right) {
				Chunk moveChunk = new Chunk(imgsMove.get(i), null, null, 0, movement, null, 
						i == imgsMove.size() - 1 ? true : false);
				chunks[i] = moveChunk;
			}
		}

		return chunks;
	}

	public Chunk[] idle() {
		Chunk[] chunks = new Chunk[imgsIdle.size()];
		for (int i = 0; i < imgsIdle.size(); i++) {
			Chunk idleChunk = new Chunk(imgsIdle.get(i), null, null, 0, null, null, 
					i == imgsIdle.size() - 1 ? true : false);
			chunks[i] = idleChunk;
		}

		return chunks;
	}
	
	public Chunk[] jump() {
		Chunk[] chunks = new Chunk[imgsJump.size()];
		for (int i = 0; i < imgsJump.size(); i++) {
			Chunk jumpChunk = new Chunk(imgsJump.get(i), null, null, 0, null, null, 
					i == imgsJump.size() - 1 ? true : false);
			chunks[i] = jumpChunk;
		}
		
		return chunks;
	}
	
	public Chunk[] down() {
		Chunk[] chunks = new Chunk[imgsDown.size()];
		for (int i = 0; i < imgsDown.size(); i++) {
			Chunk downChunk = new Chunk(imgsDown.get(i), null, null, 0, null, null,
					i == imgsDown.size() - 1 ? true : false);
			chunks[i] = downChunk;
		}
		
		return chunks;
	}
	
	public Chunk[] ability1() {
		Chunk[] chunks = new Chunk[imgsAbility1.size()];

		for (int i = 0; i < imgsAbility1.size(); i++) {
			Chunk abilityChunk = new Chunk(imgsAbility1.get(i), null, null, 0, null, null,
					i == imgsAbility1.size() - 1 ? true : false);
			chunks[i] = abilityChunk;
		}

		return chunks;
	}

	public Chunk[] ability2() {
		Chunk[] chunks = new Chunk[imgsAbility2.size()];

		for (int i = 0; i < imgsAbility2.size(); i++) {
			Chunk abilityChunk = new Chunk(imgsAbility2.get(i), null, null, 0, null, null,
					i == imgsAbility2.size() - 1 ? true : false);
			chunks[i] = abilityChunk;
		}

		return chunks;
	}
	
	public Chunk[] ability3() {
		Chunk[] chunks = new Chunk[imgsAbility3.size()];

		for (int i = 0; i < imgsAbility3.size(); i++) {
			Chunk abilityChunk = new Chunk(imgsAbility3.get(i), null, null, 0, null, null,
					i == imgsAbility3.size() - 1 ? true : false);
			chunks[i] = abilityChunk;
		}

		return chunks;
	}
	
	public Chunk receiveDamage() {
		return new Chunk(imgsOnDamage, null, null, 0, null, null, true);
	}

	public int getHp() {
		return hp;
	}
	
	public void setHp(int hp) {
		this.hp = hp;
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

	public int[] getLocation() {
		return location;
	}

	public void setLocation(int[] location) {
		this.location = location;
	}

	public Image getCurrentImage() {
		return currentImage;
	}

	public void setCurrentImage(Image currentImage) {
		this.currentImage = currentImage;
	}
	
	public int getDirection() {
		return this.direction;
	}

	public void setDirection(int direction) {
		this.direction = direction;
	}
}
