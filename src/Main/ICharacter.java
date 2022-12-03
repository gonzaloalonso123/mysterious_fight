package Main;

public interface ICharacter {
	
	public Chunk[] move(Directions direction);
	public Chunk[] jump();
	public Chunk[] down();
	public Chunk[] idle();
	public Chunk[] ability1();
	public Chunk[] ability2();
	public Chunk[] ability3();	
}