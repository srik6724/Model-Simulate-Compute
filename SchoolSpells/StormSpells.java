package SchoolSpells;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import dataStructures.WizHeap;

public class StormSpells {
	
	private WizHeap hp = new WizHeap(); 
	public ArrayList<Spell> stormSpells = new ArrayList<Spell>(); 
	
	StormSpells()
	{
		Connection conn1 = null;
        try {
            String url1 = "jdbc:mysql://localhost:3306/wizard_schema";
            String user = "srik6724";
            String password = "28892K0shair!";
 
            conn1 = DriverManager.getConnection(url1, user, password);
            if (conn1 != null) {
            	Statement st1 = conn1.createStatement(); 
            	if(st1 != null)
            	{
            		ResultSet rs = st1.executeQuery("SELECT * FROM wizard_schema.storm_spells");
            		while(rs.next())
            		{
            			String name = rs.getString("name"); 
            			String level = rs.getString("level"); 
            			String description = rs.getString("description"); 
            			String pip_chance = rs.getString("pip_chance");
            			String pips = rs.getString("pips"); 
            			String storm_typeSpell = rs.getString("storm_typeSpell"); 
            			
            			Spell spell = new Spell(name, level, description, pip_chance, pips, storm_typeSpell); 
            			
            			stormSpells.add(spell); 
            			 
            			//List<List<Spell>> updatedStormSpells = defaultDeck(stormSpells); 
            			
            			System.out.println("Deck has been successfully created."); 
            			System.out.println("Here is the following information about your main Deck, tc Deck"); 
            			
            			//deckInformation(updatedStormSpells); 
            			
            		}
            		System.out.println("Execution is done.");
            	}
            	else
            	{
            		System.out.println("Cannot execute database statement.");
            	}
            }
        } catch (SQLException ex) {
            System.out.println("An error occurred. Maybe user/password is invalid");
            ex.printStackTrace();
        }
	}
	
	public ArrayList<Spell> retrieveStormSpells()
	{
		return stormSpells; 
	}
	
	/*public List<List<Spell>> defaultDeck(ArrayList<Spell> spells)
	{
		Spell[] collectSpells = new Spell[spells.size()]; 
		
		Spell[] orderedSpells = performHeapOperations(collectSpells); 
		
		List<List<Spell>> deckOfSpells = hp.buildDeckYESoption(orderedSpells, "storm"); 
		
		return deckOfSpells;
		
	}
	
	public Spell[] performHeapOperations(Spell[] spells)
	{
		Spell[] modifiedSpells = hp.buildHeap(spells); 
		
		return modifiedSpells;
	}*/
	
	public void deckInformation(List<List<Spell>> spells)
	{
		Set<String> TCInfo = computeTCInformation(spells); 
		Set<String> mainDeckInfo = computeMainDeckInformation(spells); 
		
		for(Spell spell: spells.get(0))
		{
			int capacity = 40; 
			countOfEachSpell(spell.getName(), spells.get(0), capacity); 
		}
		
		for(Spell spell: spells.get(1))
		{
			int capacity = 64;  
			countOfEachSpell(spell.getName(), spells.get(1), capacity); 
		}
		
	}
	
	public Set<String> computeTCInformation(List<List<Spell>> spells)
	{
		Set<String> uniqueSpellsTC = new HashSet<String>(); 
		
		for(Spell spell: spells.get(0))
		{
			uniqueSpellsTC.add(spell.getName()); 
		}
		
		return uniqueSpellsTC;
		
	}
	
	public Set<String> computeMainDeckInformation(List<List<Spell>> spells)
	{
		Set<String> uniqueSpellsMain = new HashSet<String>(); 
		
		for(Spell spell: spells.get(1))
		{
			uniqueSpellsMain.add(spell.getName()); 
		}
		
		return uniqueSpellsMain;
	}
	
	public void countOfEachSpell(String name, List<Spell> spells, int capacity)
	{
		int count = 0; 
		for(Spell spell: spells)
		{
			if(spell.getName().equals(name))
			{
				count = count + 1; 
			}
		}
		System.out.println(count + "/" + capacity + name + "found."); 
	}
	
	public static void main(String[]args)
	{
		//FireSpells spells = new FireSpells(); 
	}
	
	
}



