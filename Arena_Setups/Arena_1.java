package Arena_Setups;

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
