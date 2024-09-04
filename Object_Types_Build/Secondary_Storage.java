package Object_Types_Build;

public interface Secondary_Storage {
	
	static int capacityOfDarkmoorDeck(String typeName)
	{
		if(typeName.equals("tcDeck"))
		{
			return 3;
		}
		return -1; 
	}
	
	
}
