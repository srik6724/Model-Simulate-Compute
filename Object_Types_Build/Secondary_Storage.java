package Object_Types_Build;

public interface Secondary_Storage {
	
	static int capacityOfDarkmoorDeck(String typeName)
	{
		if(typeName.equals("tcDeck"))
		{
			return 10;
		}
		return -1; 
	}
	
	
}
