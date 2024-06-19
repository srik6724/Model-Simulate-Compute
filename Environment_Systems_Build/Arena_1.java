package Environment_Systems_Build;

public interface Arena_1 {
	
	static int returnAvalonArenaNumber() 
	{
		return (int)(Math.random()*6) + 1; 
	}
	
	default String AvalonArenaName()
	{
		return "Avalon Arena"; 
	}
}
