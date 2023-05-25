package deckBuild;

public interface MainDeck {
	
	static int maxSpells(String deckType)
	{
		if(deckType.equals("mainDeck"))
		{
			return 64; 
		}
		return -1; 
	}
}
