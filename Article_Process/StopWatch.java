package Article_Process;

public class StopWatch {
	
	private static int seconds = 0; 
	
	public void startWatch()
	{
		while(true)
		{
			seconds = seconds + 1; 
		}
	}
	
	public void reset()
	{
		seconds = 0; 
	}
	
	public int accessWatch()
	{
		return seconds; 
	}
	
	
	public boolean duration(Time time)
	{
		boolean isMaxTime = false; 
		if(seconds == time.capMatchTime())
		{
			System.out.println("Match will be ended by default."); 
			isMaxTime = true; 
		}
		return isMaxTime;
	}
	
	
	
}
