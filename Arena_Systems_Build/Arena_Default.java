package Arena_Systems_Build;

public interface Arena_Default {
	
	static int ArenaNumber()
	{
		return (int)(Math.random()*6) + 1; 
	}
	
	default String ArenaName()
	{
		return "Arena";
	}
}
