package Product_Process;

public interface DragonSpyreArena {
	
	static int DragonSpyreArenaNumber()
	{
		return (int)(Math.random()*6) + 1; 
	}
	
	default String DragonSpyreArenaName()
	{
		return "DragonSpyre Arena"; 
	}
}
