package Object_Types_Build;

public interface Primary_Storage {
	
	static int maxSpells(String deckType)
	{
		if(deckType.equals("mainDeck"))
		{
			return 64; 
		}
		return -1; 
	}
}
