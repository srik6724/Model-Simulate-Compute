package SchoolSpells;

import java.util.ArrayList;
import java.util.List;

public class schoolSpells {
	
	public static ArrayList<List<Spell>> allSchoolSpells = new ArrayList<List<Spell>>(); 
	static int universalIndex = -1; 
	public static int lifeIndex; 
	public static int deathIndex; 
	public static int balanceIndex; 
	public static int iceIndex; 
	public static int mythIndex; 
	public static int stormIndex; 
	public static int fireIndex; 
	
	public schoolSpells(String school)
	{
		switch(school.toLowerCase())
		{
			case "life": 
				allSchoolSpells.add(new LifeSpells().retrieveLifeSpells()); 
				universalIndex++; 
				lifeIndex = universalIndex; 
				break;
			case "death": 
				allSchoolSpells.add(new DeathSpells().retrieveDeathSpells()); 
				universalIndex++; 
				deathIndex = universalIndex;
				break;
			case "balance": 
				allSchoolSpells.add(new BalanceSpells().retrieveBalanceSpells());
				universalIndex++; 
				balanceIndex = universalIndex;
				break;
			case "ice": 
				allSchoolSpells.add(new IceSpells().retrieveIceSpells()); 
				universalIndex++; 
				iceIndex = universalIndex;
				break;
			case "myth": 
				allSchoolSpells.add(new MythSpells().retrieveMythSpells());
				universalIndex++; 
				mythIndex = universalIndex;
				break;
			case "storm": 
				allSchoolSpells.add(new StormSpells().retrieveStormSpells()); 
				universalIndex++; 
				stormIndex = universalIndex;
				break;
			case "fire": 
				allSchoolSpells.add(new FireSpells().retrieveFireSpells()); 
				universalIndex++; 
				fireIndex = universalIndex;
				break;
			default: 
				System.out.println("Sorry, wrong school input received."); 
		}
	}
	
	
}

