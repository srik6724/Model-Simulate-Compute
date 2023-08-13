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
import java.util.Map;
import java.util.Set;

import dataStructures.WizHeap;

public class FireSpells {
	
	private WizHeap hp = new WizHeap(); 
	
	public ArrayList<Spell> fireSpells = new ArrayList<Spell>(); 
	
	FireSpells()
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
            		ResultSet rs = st1.executeQuery("SELECT * FROM wizard_schema.fire_spells");
            		while(rs.next())
            		{
            			String name = rs.getString("name"); 
            			String level = rs.getString("level"); 
            			String description = rs.getString("description"); 
            			String pip_chance = rs.getString("pip_chance");
            			String pips = rs.getString("pips"); 
            			String fire_typeSpell = rs.getString("fire_typeSpell"); 
            			
            			Spell spell = new Spell(name, level, description, pip_chance, pips, fire_typeSpell); 
            			
            			fireSpells.add(spell); 
            			 
            			//List<List<Spell>> updatedFireSpells = defaultDeck(fireSpells); 
            			
            			System.out.println("Deck has been successfully created."); 
            			System.out.println("Here is the following information about your main Deck, tc Deck"); 
            			
            			//deckInformation(updatedFireSpells); 
            			
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
	
	public ArrayList<Spell> retrieveFireSpells()
	{
		return fireSpells; 
	}
	
	/*public List<List<Spell>> defaultDeck(ArrayList<Spell> spells)
	{
		Spell[] collectSpells = new Spell[spells.size()]; 
		
		Spell[] orderedSpells = performHeapOperations(collectSpells); 
		
		List<List<Spell>> deckOfSpells = hp.buildDeckYESoption(orderedSpells, "fire"); 
		
		return deckOfSpells;
		
	}
	
	public Spell[] performHeapOperations(Spell[] spells)
	{
		Spell[] modifiedSpells = hp.buildHeap(spells); 
		
		return modifiedSpells;
	}*/
	
	public void deckInformation(List<Map<String,List<String>>> setOfSpells)
	{
		if(setOfSpells != null)
		{
			//computeTCInformation(setOfSpells); 
			computeMainDeckInformation(setOfSpells); 
		}
		
	}
	
	public Set<String> computeTCInformation(List<Map<String,List<String>>> setOfSpells)
	{
		if(setOfSpells != null)
		{
			for(String spell: setOfSpells.get(0).keySet())
			{
				System.out.println("Spell Name: " + spell); 
				System.out.println("Count of Spell: " + setOfSpells.get(0).get(spell).get(0)); 
				System.out.println("Pip Chance: " + setOfSpells.get(0).get(spell).get(1)); 
				System.out.println("Pips of Spell: " + setOfSpells.get(0).get(spell).get(2)); 
				System.out.println("School Name: " + setOfSpells.get(0).get(spell).get(3));
				System.out.println("---------------------------------------------------------"); 
			}
		}
		return null; 
	}
	
	public Set<String> computeMainDeckInformation(List<Map<String,List<String>>> setOfSpells)
	{
		if(setOfSpells != null)
		{
			int cardNumber = 0; 
			for(String spellName: setOfSpells.get(0).keySet())
			{
				cardNumber = cardNumber + Integer.parseInt(setOfSpells.get(0).get(spellName).get(0)); 
				System.out.println("Spell Name: " + spellName); 
				System.out.println("Count Of Spell: " + setOfSpells.get(0).get(spellName).get(0)); 
				System.out.println("Pip Chance: " + setOfSpells.get(0).get(spellName).get(1)); 
				System.out.println("Pips Of Spell: " + setOfSpells.get(0).get(spellName).get(2)); 
				System.out.println("School Name: " + setOfSpells.get(0).get(spellName).get(3)); 
				System.out.println(cardNumber + "/" + "64 main deck spells"); 
				System.out.println("---------------------------------------------------------"); 
			}
		}
		return null; 
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
		new FireSpells(); 
	}
	
	
}

