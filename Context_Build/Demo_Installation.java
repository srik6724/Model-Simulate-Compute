package Context_Build;

public interface Demo_Installation {
	
	static int ArenaNumber()
	{
		return (int)(Math.random()*6) + 1; 
	}
	
	default String ArenaName()
	{
		return "Arena";
	}
}
