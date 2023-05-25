package SchoolSpells;

import java.util.ArrayList;
import java.util.List;

public class schoolSpells {
	
	public static ArrayList<List<Spell>> allSchoolSpells = new ArrayList<List<Spell>>(); 
	
	ArrayList<Spell> balanceSpells = new BalanceSpells().retrieveBalanceSpells();
	//ArrayList<Spell> lifeSpells = new LifeSpells().retrieveLifeSpells(); 
	ArrayList<Spell> deathSpells = new DeathSpells().retrieveDeathSpells(); 
	ArrayList<Spell> iceSpells = new IceSpells().retrieveIceSpells(); 
	//ArrayList<Spell> stormSpells = new FireSpells().retrieveFireSpells(); 

	/*ArrayList<Spell> fireSpells = new FireSpells().retrieveFireSpells(); 
	ArrayList<Spell> iceSpells = new IceSpells().retrieveIceSpells(); 
	ArrayList<Spell> lifeSpells = new LifeSpells().retrieveLifeSpells(); 
	ArrayList<Spell> deathSpells = new DeathSpells().retrieveDeathSpells(); 
	ArrayList<Spell> stormSpells = new StormSpells().retrieveStormSpells(); 
	ArrayList<Spell> mythSpells = new MythSpells().retrieveMythSpells(); */
	
	
	public schoolSpells()
	{
		allSchoolSpells.add(balanceSpells); 
		//allSchoolSpells.add(lifeSpells); 
		allSchoolSpells.add(deathSpells); 
		allSchoolSpells.add(iceSpells); 
		//allSchoolSpells.add(stormSpells);
		/*allSchoolSpells.add(fireSpells); 
		allSchoolSpells.add(iceSpells); 
		allSchoolSpells.add(lifeSpells); 
		allSchoolSpells.add(deathSpells); 
		allSchoolSpells.add(stormSpells); 
		allSchoolSpells.add(mythSpells); */
	}
	
	
}

