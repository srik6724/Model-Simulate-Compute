package Match_Process;

public interface MooshuArena {
	
	static int MooshuaArenaNumber()
	{
		return (int)(Math.random() * 6) + 1; 
	}
	
	default String MooshuArenaName()
	{
		return "Mooshu Arena"; 
	}
}
