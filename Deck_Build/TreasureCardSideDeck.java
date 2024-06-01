package Deck_Build;

public interface TreasureCardSideDeck {
	
	static int capacityOfDarkmoorDeck(String typeName)
	{
		if(typeName.equals("tcDeck"))
		{
			return 40;
		}
		return -1; 
	}
	
	
}
