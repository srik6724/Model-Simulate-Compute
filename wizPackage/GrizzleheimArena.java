package wizPackage;

public interface GrizzleheimArena {
	
	static int GrizzleheimArenaNumber()
	{
		return (int)(Math.random()*6) + 1; 
	}
	
	default String GrizzleheimArenaName()
	{
		return "Grizzleheim Arena"; 
	}
	
}
