package Arena_Container_Systems;

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
