package Main;

import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class Psycon extends Character
{
	public Psycon (int x, int y)
	{
		super(x, y);
		
		this.name = "PSYCON";	
		
		this.imgsIdle.add(new ImageIcon(getClass().getResource("/Images/Psycon/Idle/Psycon_idle_00.png")).getImage());
		this.imgsIdle.add(new ImageIcon(getClass().getResource("/Images/Psycon/Idle/Psycon_idle_01.png")).getImage());

		this.movementUnits = 10;
		this.imgsMove.add(new ImageIcon(getClass().getResource("/Images/Psycon/Move/Psycon_move_00.png")).getImage());
		this.imgsMove.add(new ImageIcon(getClass().getResource("/Images/Psycon/Move/Psycon_move_01.png")).getImage());

		this.imgsJump.add(new ImageIcon(getClass().getResource("/Images/Psycon/Jump/Psycon_jump_00.png")).getImage());
		this.imgsJump.add(new ImageIcon(getClass().getResource("/Images/Psycon/Jump/Psycon_jump_00.png")).getImage());
		this.imgsJump.add(new ImageIcon(getClass().getResource("/Images/Psycon/Jump/Psycon_jump_01.png")).getImage());
		this.imgsJump.add(new ImageIcon(getClass().getResource("/Images/Psycon/Jump/Psycon_jump_01.png")).getImage());
		this.imgsJump.add(new ImageIcon(getClass().getResource("/Images/Psycon/Jump/Psycon_jump_02.png")).getImage());

		this.imgsDown.add(new ImageIcon(getClass().getResource("/Images/Psycon/Crouch/Psycon_crouch_00.png")).getImage());

		this.imgsAbility1.add(new ImageIcon(getClass().getResource("/Images/Psycon/Ability0/Psycon_ability0_00.png")).getImage());
		this.imgsAbility1.add(new ImageIcon(getClass().getResource("/Images/Psycon/Ability0/Psycon_ability0_01.png")).getImage());
		this.imgsAbility1.add(new ImageIcon(getClass().getResource("/Images/Psycon/Ability0/Psycon_ability0_02.png")).getImage());
		
		this.imgsOnDamage = new ImageIcon(getClass().getResource("/Images/Psycon/OnDamage/Psycon_onDamage.png")).getImage();
		
		this.currentImage = imgsIdle.get(0);
		int hitboxWidth = 170;
		int hitboxHeight = 210;
		this.bodyHitbox = new Rectangle(super.getLocation()[0] + super.getCurrentImage().getWidth(null) / 2 - hitboxWidth / 2, super.getLocation()[1], hitboxWidth, hitboxHeight);
	}
	
	public Chunk[] jump()
	{
		Chunk[] chunks = super.jump();
		chunks[0].setMovement(new int []{0, -100});
		chunks[1].setMovement(new int []{0, -20});
		chunks[2].setMovement(new int []{0, -20});
		chunks[3].setMovement(new int []{0, -20});
		chunks[4].setMovement(new int []{0, 160});
		
		return chunks;
	}
	
	public Chunk[] down()
	{
		Chunk[] chunks = super.down();
		int hitboxWidth = 170;
		int hitboxHeight = 120;
		chunks[0].setBodyHitbox(new Rectangle(super.getLocation()[0] + super.getCurrentImage().getWidth(null) / 2 - hitboxWidth / 2, super.getLocation()[1] + 90, hitboxWidth, hitboxHeight));
		
		return chunks;
	}
	
	public Chunk[] idle()
	{
		Chunk[] chunks = super.idle();
		int hitboxWidth = 170;
		int hitboxHeight = 210;
		this.bodyHitbox = new Rectangle(super.getLocation()[0] + super.getCurrentImage().getWidth(null) / 2 - hitboxWidth / 2, super.getLocation()[1], hitboxWidth, hitboxHeight);
		
		return chunks;
	}
	
	public Chunk[] ability1() 
	{
		Chunk[] chunks = super.ability1();
		int hitboxWidth = 60;
		int hitboxHeight = 10;
		int offsetY = 100;
		
		chunks[0].setAttackHitbox(new Rectangle(
				this.bodyHitbox.x + this.bodyHitbox.width / 2,
				this.bodyHitbox.y + this.bodyHitbox.height / 2 + offsetY, 
				hitboxWidth, 
				hitboxHeight));
		chunks[0].setDamage(7);
		
		hitboxWidth = 150;
		chunks[1].setAttackHitbox(new Rectangle(
				this.bodyHitbox.x + this.bodyHitbox.width / 2,
				this.bodyHitbox.y + this.bodyHitbox.height / 2 + offsetY, 
				hitboxWidth, 
				hitboxHeight));
		chunks[1].setDamage(5);
		
		hitboxWidth = 200;
		chunks[2].setAttackHitbox(new Rectangle(
				this.bodyHitbox.x + this.bodyHitbox.width / 2,
				this.bodyHitbox.y + this.bodyHitbox.height / 2 + offsetY, 
				hitboxWidth, 
				hitboxHeight));
		chunks[2].setDamage(3);
		
		return chunks;
	}
}