package Main;

import java.awt.Image;
import java.awt.Rectangle;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class Character implements ICharacter {

	public ArrayList<Image> getImgAbility1() {
		return imgAbility1;
	}

	public void setImgAbility1(ArrayList<Image> imgAbility1) {
		this.imgAbility1 = imgAbility1;
	}

	public ArrayList<Image> getImgAbility2() {
		return imgAbility2;
	}

	public void setImgAbility2(ArrayList<Image> imgAbility2) {
		this.imgAbility2 = imgAbility2;
	}

	public ArrayList<Image> getImgAbility3() {
		return imgAbility3;
	}

	public void setImgAbility3(ArrayList<Image> imgAbility3) {
		this.imgAbility3 = imgAbility3;
	}

	public ArrayList<Image> getImgAbility4() {
		return imgAbility4;
	}

	public void setImgAbility4(ArrayList<Image> imgAbility4) {
		this.imgAbility4 = imgAbility4;
	}

	public ArrayList<Image> getImgMove() {
		return imgMove;
	}

	public void setImgMove(ArrayList<Image> imgMove) {
		this.imgMove = imgMove;
	}

	public ArrayList<Image> getImgIdle() {
		return imgIdle;
	}

	public void setImgIdle(ArrayList<Image> imgIdle) {
		this.imgIdle = imgIdle;
	}

	private int hp = 100;
	private int[] location = new int[2];
	public Image currentImage;
	private Rectangle bodyHitbox;
	private Rectangle attackHitbox;
	private String name;
	private int movementUnits = 20;
	private int direction;

	private ArrayList<Image> imgAbility1 = new ArrayList<Image>();
	private ArrayList<Image> imgAbility2 = new ArrayList<Image>();
	private ArrayList<Image> imgAbility3 = new ArrayList<Image>();
	private ArrayList<Image> imgAbility4 = new ArrayList<Image>();
	private ArrayList<Image> imgMove = new ArrayList<Image>();
	private ArrayList<Image> imgIdle = new ArrayList<Image>();
	private ArrayList<Image> imgJump = new ArrayList<Image>();
	private ArrayList<Image> imgDown = new ArrayList<Image>();

	public ArrayList<Image> getImgJump() {
		return imgJump;
	}

	public void setImgJump(ArrayList<Image> imgJump) {
		this.imgJump = imgJump;
	}

	public ArrayList<Image> getImgDown() {
		return imgDown;
	}

	public void setImgDown(ArrayList<Image> imgDown) {
		this.imgDown = imgDown;
	}

	public Chunk[] move(Directions direction) {
		Chunk[] chunks = new Chunk[imgMove.size()];
		System.out.println(direction);
		for (int i = 0; i < imgMove.size(); i++) {
			int[] movement = new int[2];
			switch (direction) {
			case Right:
				this.direction = 1;
				movement[0] += this.movementUnits;
				movement[1] = 0;
				break;
			case Left:
				System.out.println("here");
				this.direction = -1;
				movement[0] -= this.movementUnits;
				movement[1] = 0;
				break;
			default:
				break;
			}
			if (direction == Directions.Left || direction == Directions.Right) {
				Chunk moveChunk = new Chunk(imgMove.get(i), null, null, 0, movement);
				chunks[i] = moveChunk;
			}
		}

		return chunks;
	}

	public Chunk[] idle() {
		Chunk[] chunks = new Chunk[imgIdle.size()];
		for (int i = 0; i < imgIdle.size(); i++) {
			Chunk idleChunk = new Chunk(imgIdle.get(i), null, null, 0, null);
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
		System.out.println("Changed attack hitbox");
		System.out.println(this.attackHitbox.toString());
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

	public void setCurrentImage(Image currentImage) {
		this.currentImage = currentImage;
	}

	@Override
	public Chunk[] ability1() {
		Chunk[] chunks = new Chunk[imgAbility1.size()];

		for (int i = 0; i < imgAbility1.size(); i++) {
			Chunk abilityChunk = new Chunk(imgAbility1.get(i), null, null, 0, null);
			chunks[i] = abilityChunk;
		}

		return chunks;
	}

	@Override
	public Chunk[] ability2() {
		Chunk[] chunks = new Chunk[imgAbility2.size()];

		for (int i = 0; i < imgAbility2.size(); i++) {
			Chunk abilityChunk = new Chunk(imgAbility2.get(i), null, null, 0, null);
			chunks[i] = abilityChunk;
		}

		return chunks;
	}

	public int getDirection() {
		return this.direction;
	}

	public void setDirection(int direction) {
		this.direction = direction;
	}

	@Override
	public Chunk[] ability3() {
		Chunk[] chunks = new Chunk[imgAbility3.size()];

		for (int i = 0; i < imgAbility3.size(); i++) {
			Chunk abilityChunk = new Chunk(imgAbility3.get(i), null, null, 0, null);
			chunks[i] = abilityChunk;
		}

		return chunks;
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
