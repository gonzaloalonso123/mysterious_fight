package Main;

public interface ICharacter {
	
	public Chunk[] move(Directions direction);
	public Chunk[] idle();
	public Chunk[] ability1();
	public Chunk[] ability2();
	public Chunk[] ability3();
	public Chunk[] ability4();
	public void substractHP(int hp);	
}