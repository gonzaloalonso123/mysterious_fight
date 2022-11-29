package Main;

import java.util.Arrays;

import javax.swing.ImageIcon;

public class PossessedMonk extends Character {

	public boolean flying = false;

	public PossessedMonk() {
		super.getImgIdle().add(new ImageIcon(getClass().getResource("/Images/PossessedMonk/idle1.png")).getImage());
		super.getImgIdle().add(new ImageIcon(getClass().getResource("/Images/PossessedMonk/idle2.png")).getImage());
		super.getImgMove().add(new ImageIcon(getClass().getResource("/Images/PossessedMonk/move1.png")).getImage());
		super.getImgMove().add(new ImageIcon(getClass().getResource("/Images/PossessedMonk/move2.png")).getImage());
//		super.getImgAbility1().add(new ImageIcon(getClass().getResource("/Images/PossessedMonk/punch1.png")).getImage());
		super.getImgAbility1()
				.add(new ImageIcon(getClass().getResource("/Images/PossessedMonk/punch2.png")).getImage());
//		super.getImgAbility1().add(new ImageIcon(getClass().getResource("/Images/PossessedMonk/punch3.png")).getImage());
		super.getImgAbility1()
				.add(new ImageIcon(getClass().getResource("/Images/PossessedMonk/punch4.png")).getImage());

		super.getImgAbility2()
				.add(new ImageIcon(getClass().getResource("/Images/PossessedMonk/dodge1.png")).getImage());
		super.getImgAbility2()
				.add(new ImageIcon(getClass().getResource("/Images/PossessedMonk/dodge1.png")).getImage());
		super.getImgAbility2()
				.add(new ImageIcon(getClass().getResource("/Images/PossessedMonk/dodge1.png")).getImage());
		super.getImgAbility2()
				.add(new ImageIcon(getClass().getResource("/Images/PossessedMonk/dodge1.png")).getImage());

		super.getImgAbility3().add(new ImageIcon(getClass().getResource("/Images/PossessedMonk/ulti1.png")).getImage());
		super.getImgAbility3().add(new ImageIcon(getClass().getResource("/Images/PossessedMonk/ulti2.png")).getImage());
		super.getImgAbility3().add(new ImageIcon(getClass().getResource("/Images/PossessedMonk/ulti3.png")).getImage());
		super.getImgAbility3().add(new ImageIcon(getClass().getResource("/Images/PossessedMonk/ulti4.png")).getImage());
		super.getImgAbility3().add(new ImageIcon(getClass().getResource("/Images/PossessedMonk/ulti5.png")).getImage());
		super.getImgJump().add(new ImageIcon(getClass().getResource("/Images/PossessedMonk/jump1.png")).getImage());
		super.getImgJump().add(new ImageIcon(getClass().getResource("/Images/PossessedMonk/jump2.png")).getImage());
	}

	@Override
	public Chunk[] ability1() {
		// TODO Auto-generated method stub
		Chunk[] chunks = super.ability1();
		return chunks;
	}

	@Override
	public Chunk[] move(Directions direction) {
		// TODO Auto-generated method stub
		Chunk[] chunks = super.move(direction);
		switch (direction) {
		case Up:
			if (!flying) {
				flying = true;
				super.getImgIdle().clear();
				super.getImgIdle()
						.add(new ImageIcon(getClass().getResource("/Images/PossessedMonk/jump1.png")).getImage());
				super.getImgIdle()
						.add(new ImageIcon(getClass().getResource("/Images/PossessedMonk/jump2.png")).getImage());
				super.getImgMove().clear();
				super.getImgMove()
						.add(new ImageIcon(getClass().getResource("/Images/PossessedMonk/jump1.png")).getImage());
				super.getImgMove()
						.add(new ImageIcon(getClass().getResource("/Images/PossessedMonk/jump2.png")).getImage());
			}
			for (int i = 0; i < super.getImgMove().size(); i++) {
				int[] movement = new int[2];
				if (super.getLocation()[1] > 30) {
					movement[0] += 0;
					movement[1] = -30;
				}
				chunks[i] = new Chunk(super.getImgMove().get(i), null, null, 0, movement);
			}
			break;
		case Down:
			System.out.println(super.getImgMove().size());
			for (int i = 0; i < super.getImgMove().size(); i++) {
				int[] movement = new int[2];
				if (super.getLocation()[1] <= 170) {
					movement[0] += 0;
					movement[1] = 30;
				}
				chunks[i] = new Chunk(super.getImgMove().get(i), null, null, 0, movement);
			}
			if (flying && super.getLocation()[1] >= 200) {
				super.getLocation()[1] = 200;
				flying = false;
				super.getImgIdle().clear();
				super.getImgIdle()
						.add(new ImageIcon(getClass().getResource("/Images/PossessedMonk/idle1.png")).getImage());
				super.getImgIdle()
						.add(new ImageIcon(getClass().getResource("/Images/PossessedMonk/idle2.png")).getImage());
				super.getImgMove().clear();
				super.getImgMove()
						.add(new ImageIcon(getClass().getResource("/Images/PossessedMonk/move1.png")).getImage());
				super.getImgMove()
						.add(new ImageIcon(getClass().getResource("/Images/PossessedMonk/move2.png")).getImage());
			}
			break;
		default:
			break;
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
		Chunk[] chunks = super.ability3();
		chunks[4].setMovement(new int[] { 100 * super.getDirection(), 0 });

		return chunks;
	}

	@Override
	public Chunk[] ability4() {
		// TODO Auto-generated method stub
		return super.ability4();
	}

}
