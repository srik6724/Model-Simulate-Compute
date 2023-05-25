package wizPackage;

public interface Arena {
	
	static int ArenaNumber()
	{
		return (int)(Math.random()*6) + 1; 
	}
	
	default String ArenaName()
	{
		return "Arena";
	}
}
