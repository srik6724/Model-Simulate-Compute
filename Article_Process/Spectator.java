package Article_Process;

public class Spectator {
	
	//Attributes are name and level of spectator.
	String name; 
	int level; 
	
	
	public Spectator()
	{
		System.out.println("Spectator Area."); 
		name = "Spectator "; 
		level = (int)(Math.random() * 160) + 1; 
		
	}
	
	
}
