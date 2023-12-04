package Main;

import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class Placeholder extends Character {

	public Placeholder (int x, int y)
	{
		super(x, y);
		
		this.name = "PLACEHOLDER";	
		
		this.imgsIdle.add(new ImageIcon(getClass().getResource("/Images/Placeholder/idle.png")).getImage());

		this.movementUnits = 10;
		this.imgsMove.add(new ImageIcon(getClass().getResource("/Images/Placeholder/idle.png")).getImage());

		this.imgsJump.add(new ImageIcon(getClass().getResource("/Images/Placeholder/idle.png")).getImage());

		this.imgsDown.add(new ImageIcon(getClass().getResource("/Images/Placeholder/idle.png")).getImage());

		this.imgsAbility1.add(new ImageIcon(getClass().getResource("/Images/Placeholder/attack1.png")).getImage());
		
		this.imgsOnDamage = new ImageIcon(getClass().getResource("/Images/Placeholder/ondamage.png")).getImage();
		
		this.currentImage = imgsIdle.get(0);
		int hitboxWidth = 150;
		int hitboxHeight = 356;
		this.bodyHitbox = new Rectangle(super.getLocation()[0] + super.getCurrentImage().getWidth(null) / 2 - hitboxWidth / 2, super.getLocation()[1], hitboxWidth, hitboxHeight);
	}
	
	public Chunk[] ability1() 
	{
		Chunk[] chunks = super.ability1();
		int hitboxWidth = 100;
		int hitboxHeight = 50;
		int offsetY = -20;
		
		chunks[0].setAttackHitbox(new Rectangle(
				this.bodyHitbox.x + this.bodyHitbox.width / 2,
				this.bodyHitbox.y + this.bodyHitbox.height / 2 + offsetY, 
				hitboxWidth, 
				hitboxHeight));
		chunks[0].setDamage(5);
		
		return chunks;
	}
}
