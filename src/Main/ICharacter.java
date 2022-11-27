package Main;

import java.util.ArrayList;

import javax.swing.ImageIcon;

public interface ICharacter {
	
	public void moveTo(int[] location);
	public void attemptDamage(int[] bounds);
	public void changeInputHitBox(int[] bounds);
	public void ability1();
	public void ability2();
	public void ability3();
	public void substractHP();
	
	public ArrayList<ImageIcon> imgAbility1 = new ArrayList<ImageIcon>();
	public ArrayList<ImageIcon> imgAbility2 = new ArrayList<ImageIcon>();
	public ArrayList<ImageIcon> imgAbility3 = new ArrayList<ImageIcon>();
	public ArrayList<ImageIcon> imgMove = new ArrayList<ImageIcon>();
	public ArrayList<ImageIcon> imgIdle = new ArrayList<ImageIcon>();
	
}