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
		System.out.println(school); 
		switch(school.toLowerCase())
		{
			case "life": 
				universalIndex++; 
				lifeIndex = universalIndex; 
				allSchoolSpells.add(new LifeSpells(lifeIndex+1).retrieveLifeSpells()); 
				break;
			case "death": 
				universalIndex++;
				deathIndex = universalIndex;
				allSchoolSpells.add(new DeathSpells(deathIndex+1).retrieveDeathSpells()); 
				break;
			case "balance": 
				universalIndex++; 
				balanceIndex = universalIndex;
				allSchoolSpells.add(new BalanceSpells(balanceIndex+1).retrieveBalanceSpells());
				break;
			case "ice": 
				universalIndex++; 
				iceIndex = universalIndex;
				allSchoolSpells.add(new IceSpells(iceIndex+1).retrieveIceSpells()); 
				break;
			case "myth": 
				universalIndex++; 
				mythIndex = universalIndex;
				allSchoolSpells.add(new MythSpells(mythIndex+1).retrieveMythSpells());
				break;
			case "storm": 
				universalIndex++; 
				stormIndex = universalIndex;
				allSchoolSpells.add(new StormSpells(stormIndex+1).retrieveStormSpells()); 
				break;
			case "fire": 
				universalIndex++; 
				fireIndex = universalIndex;
				allSchoolSpells.add(new FireSpells(fireIndex+1).retrieveFireSpells()); 
				break;
			default: 
				System.out.println("Sorry, wrong school input received."); 
		}
	}
	
	
}

