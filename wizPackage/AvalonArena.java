package wizPackage;

public interface AvalonArena {
	
	static int returnAvalonArenaNumber() 
	{
		return (int)(Math.random()*6) + 1; 
	}
	
	default String AvalonArenaName()
	{
		return "Avalon Arena"; 
	}
}
