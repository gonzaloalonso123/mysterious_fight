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
			chunks[1].setAttackHitbox(new Rectangle((this.bodyHitbox.x + HITBOX_WIDTH / 2 + this.direction * 20),
					this.getLocation()[1] + super.getCurrentImage().getHeight(null) / 2 - 100, 150, 80));
			chunks[1].setDamage(10);
			return chunks;
		}
		return idle();
	}

	@Override
	public Chunk[] jump() {
		Chunk[] chunks = super.jump();
		if (!flying) {
			flying = true;
			this.imgsIdle.clear();
			this.imgsIdle.add(new ImageIcon(getClass().getResource("/Images/PossessedMonk/jump1.png")).getImage());
			this.imgsIdle.add(new ImageIcon(getClass().getResource("/Images/PossessedMonk/jump2.png")).getImage());
			this.imgsMove.clear();
			this.imgsMove.add(new ImageIcon(getClass().getResource("/Images/PossessedMonk/jump1.png")).getImage());
			this.imgsMove.add(new ImageIcon(getClass().getResource("/Images/PossessedMonk/jump2.png")).getImage());
		}
		for (int i = 0; i < this.imgsMove.size(); i++) {
			int[] movement = new int[2];
			if (super.getLocation()[1] > 30) {
				movement[0] += 0;
				movement[1] = -30;
				this.bodyHitbox.y -= 30;
			}
			chunks[i] = new Chunk(this.imgsMove.get(i), null, null, 0, movement, null);
		}
		return chunks;
	}

	@Override
	public Chunk[] down() {
		// TODO Auto-generated method stub
		Chunk[] chunks = super.down();
		for (int i = 0; i < this.imgsMove.size(); i++) {
			int[] movement = new int[2];
			if (super.getLocation()[1] <= 170) {
				movement[0] += 0;
				movement[1] = 30;
				this.bodyHitbox.y += 30;
			}
			chunks[i] = new Chunk(this.imgsMove.get(i), null, null, 0, movement, null);
		}
		if (flying && super.getLocation()[1] >= 200) {
			super.getLocation()[1] = 200;
			flying = false;
			this.imgsIdle.clear();
			this.imgsIdle.add(new ImageIcon(getClass().getResource("/Images/PossessedMonk/idle1.png")).getImage());
			this.imgsIdle.add(new ImageIcon(getClass().getResource("/Images/PossessedMonk/idle2.png")).getImage());
			this.imgsMove.clear();
			this.imgsMove.add(new ImageIcon(getClass().getResource("/Images/PossessedMonk/move1.png")).getImage());
			this.imgsMove.add(new ImageIcon(getClass().getResource("/Images/PossessedMonk/move2.png")).getImage());
		}
		return chunks;
	}

	@Override
	public Chunk[] ability2() {
		Chunk[] chunks = super.ability2();
		for (int i = 0; i < chunks.length; i++) {
			chunks[i].setMovement(new int[] { -40 * super.getDirection(), 0 });
			System.out.println(Arrays.toString(chunks[i].getMovement()));
		}
		return chunks;
	}

	@Override
	public Chunk[] ability3() {
		if (!flying) {
			Chunk[] chunks = super.ability3();
			chunks[4].setMovement(new int[] { 100 * super.getDirection(), 0 });
			chunks[1].setSound("/PossessedMonk/ulti.wav");
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
	}
}