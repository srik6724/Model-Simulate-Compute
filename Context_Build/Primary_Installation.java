package Context_Build;

public interface Primary_Installation {
	
	static int returnAvalonArenaNumber() 
	{
		return (int)(Math.random()*6) + 1; 
	}
	
	default String AvalonArenaName()
	{
		return "Avalon Arena"; 
	}
}
