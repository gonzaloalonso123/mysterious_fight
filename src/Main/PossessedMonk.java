package Main;

import java.awt.Rectangle;
import java.util.Arrays;

import javax.swing.ImageIcon;

public class PossessedMonk extends Character {

	public boolean flying = false;
	private final int HITBOX_WIDTH = 200;
	private final int HITBOX_HEIGHT = 400;

	public PossessedMonk(int x, int y) {
		super(x, y);
		loadImages();
		super.setCurrentImage(this.imgsIdle.get(0));
		this.bodyHitbox = new Rectangle(
				super.getLocation()[0] + super.getCurrentImage().getWidth(null) / 2 - HITBOX_WIDTH / 2,
				super.getLocation()[1], HITBOX_WIDTH, HITBOX_HEIGHT);
	}

	@Override
	public Chunk[] ability1() {
		// TODO Auto-generated method stub
		if (!flying) {
			Chunk[] chunks = super.ability1();
			chunks[1].setAttackHitbox(new Rectangle(
					this.bodyHitbox.x + this.bodyHitbox.width / 2,
					this.bodyHitbox.y + this.bodyHitbox.height / 2 -120, 
					180, 
					100));
			chunks[1].setDamage(2);
			return chunks;
		}
		return idle();
	}

	@Override
	public Chunk[] jump() {
		Chunk[] chunks = super.jump();
		if (!flying) {
			flying = true;
			this.imgsIdle.set(0, new ImageIcon(getClass().getResource("/Images/PossessedMonk/jump1.png")).getImage());
			this.imgsIdle.set(1, new ImageIcon(getClass().getResource("/Images/PossessedMonk/jump2.png")).getImage());
			this.imgsMove.set(0, new ImageIcon(getClass().getResource("/Images/PossessedMonk/jump1.png")).getImage());
			this.imgsMove.set(1, new ImageIcon(getClass().getResource("/Images/PossessedMonk/jump2.png")).getImage());
			this.imgsDown.set(0, new ImageIcon(getClass().getResource("/Images/PossessedMonk/jump1.png")).getImage());
			this.imgsDown.set(1, new ImageIcon(getClass().getResource("/Images/PossessedMonk/jump2.png")).getImage());
		}
		for (int i = 0; i < this.imgsMove.size(); i++) {
			int[] movement = new int[2];
			movement[1] = -20;
			chunks[i].setMovement(movement);
		}
		return chunks;
	}

	@Override
	public Chunk[] down() {
		// TODO Auto-generated method stub
		Chunk[] chunks = super.down();
		for (int i = 0; i < this.imgsJump.size(); i++) {
			int[] movement = new int[2];
			if (super.getLocation()[1] <= 200) {
				movement[1] = 20;
			}
			
			chunks[i].setMovement(movement);
		}
		if (flying && super.getLocation()[1] >= 200) {
			super.setLocation(new int[]{super.getLocation()[0], 200});
			super.setBodyHitbox(new Rectangle(super.getBodyHitbox().x, 200, super.getBodyHitbox().width, super.getBodyHitbox().height));
			flying = false;
			this.imgsIdle.set(0, new ImageIcon(getClass().getResource("/Images/PossessedMonk/idle1.png")).getImage());
			this.imgsIdle.set(1, new ImageIcon(getClass().getResource("/Images/PossessedMonk/idle2.png")).getImage());
			this.imgsMove.set(0, new ImageIcon(getClass().getResource("/Images/PossessedMonk/move1.png")).getImage());
			this.imgsMove.set(1, new ImageIcon(getClass().getResource("/Images/PossessedMonk/move2.png")).getImage());
			this.imgsDown.set(0, new ImageIcon(getClass().getResource("/Images/PossessedMonk/idle1.png")).getImage());
			this.imgsDown.set(1, new ImageIcon(getClass().getResource("/Images/PossessedMonk/idle2.png")).getImage());
		}
		return chunks;
	}

	@Override
	public Chunk[] ability2() {
		Chunk[] chunks = super.ability2();
		for (int i = 0; i < chunks.length; i++) {
			chunks[i].setMovement(new int[] { -40 * super.getDirection(), 0 });
		}
		return chunks;
	}

	@Override
	public Chunk[] ability3() {
		if (!flying) {
			Chunk[] chunks = super.ability3();
			chunks[4].setMovement(new int[] { 100 * super.getDirection(), 0 });
			chunks[4].setAttackHitbox(new Rectangle(
					this.bodyHitbox.x + this.bodyHitbox.width / 2,
					this.bodyHitbox.y + this.bodyHitbox.height / 2 -100, 
					300, 
					200));
			chunks[4].setDamage(4);
			return chunks;
		}
		return idle();
	}


	public void loadImages() {
		this.imgsIdle.add(new ImageIcon(getClass().getResource("/Images/PossessedMonk/idle1.png")).getImage());
		this.imgsIdle.add(new ImageIcon(getClass().getResource("/Images/PossessedMonk/idle2.png")).getImage());
		this.imgsMove.add(new ImageIcon(getClass().getResource("/Images/PossessedMonk/move1.png")).getImage());
		this.imgsMove.add(new ImageIcon(getClass().getResource("/Images/PossessedMonk/move2.png")).getImage());
		this.imgsAbility1.add(new ImageIcon(getClass().getResource("/Images/PossessedMonk/punch2.png")).getImage());
		this.imgsAbility1.add(new ImageIcon(getClass().getResource("/Images/PossessedMonk/punch4.png")).getImage());
		this.imgsAbility2.add(new ImageIcon(getClass().getResource("/Images/PossessedMonk/dodge1.png")).getImage());
		this.imgsAbility2.add(new ImageIcon(getClass().getResource("/Images/PossessedMonk/dodge1.png")).getImage());
		this.imgsAbility2.add(new ImageIcon(getClass().getResource("/Images/PossessedMonk/dodge1.png")).getImage());
		this.imgsAbility2.add(new ImageIcon(getClass().getResource("/Images/PossessedMonk/dodge1.png")).getImage());
		this.imgsAbility3.add(new ImageIcon(getClass().getResource("/Images/PossessedMonk/ulti1.png")).getImage());
		this.imgsAbility3.add(new ImageIcon(getClass().getResource("/Images/PossessedMonk/ulti2.png")).getImage());
		this.imgsAbility3.add(new ImageIcon(getClass().getResource("/Images/PossessedMonk/ulti3.png")).getImage());
		this.imgsAbility3.add(new ImageIcon(getClass().getResource("/Images/PossessedMonk/ulti4.png")).getImage());
		this.imgsAbility3.add(new ImageIcon(getClass().getResource("/Images/PossessedMonk/ulti5.png")).getImage());
		this.imgsJump.add(new ImageIcon(getClass().getResource("/Images/PossessedMonk/jump1.png")).getImage());
		this.imgsJump.add(new ImageIcon(getClass().getResource("/Images/PossessedMonk/jump2.png")).getImage());
		this.imgsOnDamage = new ImageIcon(getClass().getResource("/Images/PossessedMonk/damagereceived.png")).getImage();
		this.imgsDown.add(new ImageIcon(getClass().getResource("/Images/PossessedMonk/idle1.png")).getImage());
		this.imgsDown.add(new ImageIcon(getClass().getResource("/Images/PossessedMonk/idle2.png")).getImage());
	}
}