package Main;

import java.awt.Image;
import java.awt.Rectangle;

public class Character implements ICharacter {

	private int hp = 100;
	private int[] location = new int[2];
	public Image currentImage;
	private Rectangle bodyHitbox;
	private Rectangle attackHitbox;
	
	@Override
	public void moveTo(int[] location) {
		this.location[0] = location[0];
		this.location[1] = location[1];
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
	public void attemptDamage(int[] bounds) {
		GameEngine.dealDmg(0);
	}

	@Override
	public void ability1() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void ability2() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void ability3() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void substractHP() {
		// TODO Auto-generated method stub
		
	}

}
