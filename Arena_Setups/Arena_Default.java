package Arena_Setups;

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
