package dataStructures;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import CustomExceptions.TypeException;
import SchoolSpells.Spell;
import deckBuild.DarkmoorDeck;

public class WizHeap {
	
	public HashMap<String, List<String>> mainDeckSpells = new HashMap<String,List<String>>(); 
	public HashMap<String, List<String>> tcDeckSpells = new HashMap<String, List<String>>(); 

	
	public WizHeap()
	{
		System.out.println("WizHeap constructor called."); 
	}
	
	/*public void minHeapify(Spell[]spells, int index)
	{
		int leftIndex = index * 2; 
		int rightIndex = (index * 2) + 1; 
		int smallestIndex = 0; 
		
		if(!(spells[index-1].getPips().equals("X") && spells[leftIndex-1].getPips().equals("X")))
		{
			if(leftIndex <= spells.length && Integer.parseInt(spells[leftIndex-1].getPips()) <= Integer.parseInt(spells[index-1].getPips()))
			{
				smallestIndex = leftIndex; 
			}
		}
		else 
		{
			System.out.println("Any number of pips to be specified here. Will take care of function later."); 
		}
		
		if(!(spells[rightIndex-1].getPips().equals("X")))
		{
			if(rightIndex <= spells.length && Integer.parseInt(spells[rightIndex-1].getPips()) <= Integer.parseInt(spells[smallestIndex-1].getPips()))
			{
				smallestIndex = rightIndex; 
			}
		}
		
		if(smallestIndex != index)
		{
			//Swap operation between index and smallestIndex is performed. 
			Spell tempVariable = spells[index-1]; 	
			spells[index-1] = spells[smallestIndex-1];
			spells[smallestIndex-1] = tempVariable;
		}
		else 
		{
			System.out.println("Any number of pips to be specified here. Will take care of function later."); 
		}
		
	}
	
	public Spell[] buildHeap(Spell[] spells)
	{
		for(int i = (int)Math.floor(spells.length/2); i > 1; i--)
		{
			minHeapify(spells, i); 
		}
		
		return spells;
	}
	
	public List<List<Spell>> buildDeckYESoption(Spell[]spells, String identity)
	{
		TypeException exception = new TypeException(); 
		Scanner sc = new Scanner(System.in);
		String input; 
		String[] array = {"YES", "NO"}; 
		String[] deckFormats = {"Producer's Hazmat Box", "Darkmoor Deck"}; 
		String deckFormatInput = ""; 
		List<List<Spell>> fullDeck = new ArrayList<List<Spell>>(); 
		
		String typeOfInput = deckFormatInput.getClass().getName(); 
		
		System.out.println("Here is the chance for you to build your deck."); 
		
		System.out.println("If you would like to make your own deck, select YES. Otherwise, select NO."); 
		
		/*input = sc.nextLine(); 
		if(input.equals("YES"))
		{	
			boolean var = true; 
			while(var)
			{
				System.out.println("Specify the following deck formats: Producer's Hazmat Box or Darkmoor Deck");
				deckFormatInput = sc.nextLine(); 
				if(deckFormatInput instanceof String && deckFormatInput.equals("Darkmoor Deck"))
				{
					DarkmoorDeck deck = new DarkmoorDeck(identity); 
					
					Spell[] tcDeck = deck.fillTcDeck(spells);
					Spell[] mainDeck = deck.fillMainDeck(spells); 
					
					fullDeck.add(Arrays.asList(tcDeck)); 
					fullDeck.add(Arrays.asList(mainDeck)); 
					
					var = false; 
					
				}
				else 
				{
					exception.message(typeOfInput); 
				}
			}
		}
		sc.close(); 
		return fullDeck; */
	public List<Map<String, List<String>>> selectNOoption(String identity, String input)
	{
		List<Map<String, List<String>>> fullDeck = new ArrayList<>();

		if(input.toLowerCase().equals("no"))
		{
			if(identity.toLowerCase().equals("balance"))
			{
				mainDeckSpells.put("Jinn's Vexation", Arrays.asList("4", "100%", "3", "Ice")); 
				mainDeckSpells.put("Stun Block", Arrays.asList("4", "100%", "0", "Ice")); 
				mainDeckSpells.put("Jinn's Defense", Arrays.asList("3", "100%", "3", "Myth")); 
				mainDeckSpells.put("Frenzy", Arrays.asList("1", "100%", "0", "Astral")); 
				mainDeckSpells.put("Magnify", Arrays.asList("3", "100%", "0", "Astral")); 
				mainDeckSpells.put("Balance Blade", Arrays.asList("1", "100%", "0", "Balance"));
				mainDeckSpells.put("Bladestorm", Arrays.asList("1", "100%", "1", "Balance")); 
				mainDeckSpells.put("Donate Power", Arrays.asList("2", "100%", "1", "Balance")); 
				mainDeckSpells.put("Elemental Defuse", Arrays.asList("1", "100%", "5", "Balance")); 
				mainDeckSpells.put("Scion of Balance", Arrays.asList("3", "100%", "11", "Balance")); 
				mainDeckSpells.put("Judgement", Arrays.asList("3", "100%", "X", "Balance"));
				mainDeckSpells.put("King Artorius", Arrays.asList("1", "85%", "8", "Balance")); 
				mainDeckSpells.put("Mana Burn", Arrays.asList("3", "85%", "5", "Balance")); 
				mainDeckSpells.put("Mockenspiel", Arrays.asList("1", "85%", "5 and 1 Shadow Pip", "Balance")); 
				mainDeckSpells.put("Nested Fury", Arrays.asList("3", "80%", "6 and 1 Shadow Pip", "Balance")); 
				mainDeckSpells.put("Scales Of Destiny", Arrays.asList("3", "80%", "1 Life Pip and 1 Ice Pip", "Balance")); 
				mainDeckSpells.put("Power Nova", Arrays.asList("4", "85%", "7", "Balance")); 
				mainDeckSpells.put("Balance of Power", Arrays.asList("4", "100%", "2", "Balance")); 
				mainDeckSpells.put("Ra", Arrays.asList("1", "85%", "8", "Balance")); 
				mainDeckSpells.put("Eye Of Vigilance", Arrays.asList("3", "100%", "3", "Balance")); 
				mainDeckSpells.put("Oni's Shadow", Arrays.asList("1", "100%", "1", "Balance")); 
				mainDeckSpells.put("Reshuffle", Arrays.asList("1", "100%", "4", "Balance")); 
				mainDeckSpells.put("Sand Wyrm", Arrays.asList("1", "85%", "4 and 1 Shadow Pip", "Balance")); 
				mainDeckSpells.put("Iron Curse", Arrays.asList("4", "80%", "4", "Balance")); 
				mainDeckSpells.put("Super Nova", Arrays.asList("4", "60%", "4", "Balance"));
				mainDeckSpells.put("Shadow Shrike", Arrays.asList("4", "100%", "0", "Shadow")); 
				
				tcDeckSpells.put("Legion Shield", Arrays.asList("6", "100%", "1", "Ice")); 
				tcDeckSpells.put("Stun Block", Arrays.asList("4", "100%", "0", "Ice")); 
				tcDeckSpells.put("Earthquake", Arrays.asList("1", "85%", "0", "Myth"));
				tcDeckSpells.put("Infallible", Arrays.asList("4", "100%", "0", "Astral")); 
				tcDeckSpells.put("Empower",  Arrays.asList("8", "100%", "1", "Astral")); 
				tcDeckSpells.put("Feint",  Arrays.asList("2", "100%", "1", "Death"));
				tcDeckSpells.put("Balance Blade", Arrays.asList("3", "100%", "0", "Balance")); 
				tcDeckSpells.put("Power Nova", Arrays.asList("3", "100%", "7", "Balance")); 
				tcDeckSpells.put("Reshuffle", Arrays.asList("1", "100%", "4", "Balance")); 
				tcDeckSpells.put("Weakness", Arrays.asList("4", "100%", "0", "Balance"));

				fillMainDeck(mainDeckSpells, identity);
				fillTcDeck(tcDeckSpells, identity);

				fullDeck.add(mainDeckSpells); 
				fullDeck.add(tcDeckSpells); 

				return fullDeck;

			}
			if(identity.toLowerCase().equals("life"))
			{
				mainDeckSpells.put("Glacial Fortress", Arrays.asList("4", "100%", "3", "Ice")); 
				mainDeckSpells.put("Jinn's Vexation", Arrays.asList("4", "100%", "4", "Ice")); 
				mainDeckSpells.put("Volcanic Shield", Arrays.asList("4", "100%", "0", "Ice")); 
				mainDeckSpells.put("Brilliant Light", Arrays.asList("1", "100%", "1", "Life")); 
				mainDeckSpells.put("Dryad", Arrays.asList("2", "90%", "X", "Life")); 
				mainDeckSpells.put("Entangle", Arrays.asList("1", "100%", "2", "Life"));
				mainDeckSpells.put("Mass Triage", Arrays.asList("3", "100%", "2", "Life")); 
				mainDeckSpells.put("Mega Calm", Arrays.asList("3", "100%", "3", "Life")); 
				mainDeckSpells.put("Minor Blessing", Arrays.asList("4", "100%", "0", "Life")); 
				mainDeckSpells.put("Tranquility", Arrays.asList("2", "100%", "3", "Life"));
				mainDeckSpells.put("Rebirth", Arrays.asList("4", "100%", "8", "Life")); 
				mainDeckSpells.put("Regenerate", Arrays.asList("1", "90%", "5", "Life")); 
				mainDeckSpells.put("Sanctuary", Arrays.asList("2", "100%", "2", "Life")); 
				mainDeckSpells.put("Satyr", Arrays.asList("4", "90%", "4", "Life")); 
				mainDeckSpells.put("Unicorn", Arrays.asList("4", "90%", "3", "Life")); 
				mainDeckSpells.put("Wings of Fate", Arrays.asList("3", "90%", "6 (And 1 Shadow Pip)", "Life")); 
				mainDeckSpells.put("Renew", Arrays.asList("4", "100%", "0", "Astral")); 
				mainDeckSpells.put("Doom", Arrays.asList("1", "100%", "1", "Death")); 
				mainDeckSpells.put("Feint", Arrays.asList("6", "100%", "6", "Death")); 
				mainDeckSpells.put("Putrefaction", Arrays.asList("4", "100%", "4", "Death")); 
				mainDeckSpells.put("Contagion", Arrays.asList("2", "100%", "2", "Death")); 
				
				tcDeckSpells.put("Legion Shield", Arrays.asList("8", "100%", "1", "Ice")); 
				tcDeckSpells.put("Stun Block", Arrays.asList("4", "100%", "0", "Ice")); 
				tcDeckSpells.put("Guiding Light", Arrays.asList("4", "100%", "0", "Life"));
				tcDeckSpells.put("Choke", Arrays.asList("5", "85%", "2", "Fire")); 
				tcDeckSpells.put("Feint",  Arrays.asList("6", "100%", "1", "Death")); 
				tcDeckSpells.put("Reshuffle",  Arrays.asList("1", "100%", "1", "Balance"));
				tcDeckSpells.put("Empower", Arrays.asList("4", "100%", "1", "Death")); 
				tcDeckSpells.put("Weakness", Arrays.asList("4", "100%", "0", "Balance"));

				fillMainDeck(mainDeckSpells, identity);
				fillTcDeck(tcDeckSpells, identity);

				fullDeck.add(mainDeckSpells); 
				fullDeck.add(tcDeckSpells); 

				return fullDeck;

			}
			if(identity.toLowerCase().equals("death"))
			{
				mainDeckSpells.put("Stun Block", Arrays.asList("4", "100%", "0", "Ice")); 
				mainDeckSpells.put("Shift Grendel", Arrays.asList("1", "100%", "3", "Astral")); 
				mainDeckSpells.put("Beguile", Arrays.asList("3", "100%", "3", "Death")); 
				mainDeckSpells.put("Curse", Arrays.asList("2", "100%", "0", "Death")); 
				mainDeckSpells.put("Dark Pact", Arrays.asList("2", "100%", "1", "Death")); 
				mainDeckSpells.put("Doom and Gloom", Arrays.asList("1", "100%", "2", "Death"));
				mainDeckSpells.put("Feint", Arrays.asList("4", "100%", "1", "Death")); 
				mainDeckSpells.put("Mass Infection", Arrays.asList("4", "100%", "1", "Death")); 
				mainDeckSpells.put("Mega Pacify", Arrays.asList("2", "100%", "3", "Death")); 
				mainDeckSpells.put("Plague", Arrays.asList("3", "100%", "1", "Death")); 
				mainDeckSpells.put("Putrefaction", Arrays.asList("5", "100%", "3", "Death")); 
				mainDeckSpells.put("Contagion", Arrays.asList("3", "100%", "3", "Death")); 
				mainDeckSpells.put("Sacrifice", Arrays.asList("6", "85%", "3", "Death")); 
				mainDeckSpells.put("Threefold Fever", Arrays.asList("4", "100%", "2", "Death")); 
				mainDeckSpells.put("Virulent Plague", Arrays.asList("6", "90%", "2", "Death")); 
				mainDeckSpells.put("Donate Power", Arrays.asList("2", "100%", "1", "Balance")); 
				mainDeckSpells.put("Balance of Power", Arrays.asList("4", "100%", "2", "Balance")); 
				mainDeckSpells.put("Righting the Scales", Arrays.asList("1", "100%", "3", "Balance")); 
				mainDeckSpells.put("Eye Of Vigilance", Arrays.asList("1", "100%", "3", "Balance")); 
				mainDeckSpells.put("Steel Giant", Arrays.asList("4", "100%", "4", "Balance")); 
				mainDeckSpells.put("Weakness", Arrays.asList("2", "100%", "0", "Balance")); 


				tcDeckSpells.put("Legion Shield", Arrays.asList("8", "100%", "1", "Ice")); 
				tcDeckSpells.put("Stun Block", Arrays.asList("4", "100%", "0", "Ice")); 
				tcDeckSpells.put("Brilliant Light", Arrays.asList("1", "100%", "1", "Life"));
				tcDeckSpells.put("Empower", Arrays.asList("5", "100%", "1", "Death")); 
				tcDeckSpells.put("Feint",  Arrays.asList("5", "100%", "1", "Death")); 
				tcDeckSpells.put("Mass Infection",  Arrays.asList("4", "100%", "1", "Death"));
				tcDeckSpells.put("Cleanse Charm", Arrays.asList("5", "100%", "0", "Storm"));
				tcDeckSpells.put("Availing Hands", Arrays.asList("1", "100%", "4", "Balance")); 
				tcDeckSpells.put("Reshuffle", Arrays.asList("1", "100%", "4", "Balance")); 
				tcDeckSpells.put("Elemental Blade", Arrays.asList("2", "100%", "1", "Balance")); 


				fillMainDeck(mainDeckSpells, identity);
				fillTcDeck(tcDeckSpells, identity);

				fullDeck.add(mainDeckSpells); 
				fullDeck.add(tcDeckSpells); 

				return fullDeck;

			}
			if(identity.toLowerCase().equals("ice"))
			{
				mainDeckSpells.put("Balefrost", Arrays.asList("4", "100%", "2", "Ice")); 
				mainDeckSpells.put("Colossus", Arrays.asList("2", "80%", "6", "Ice")); 
				mainDeckSpells.put("Frost Giant", Arrays.asList("3", "100%", "7", "Ice")); 
				mainDeckSpells.put("Scion", Arrays.asList("1", "80%", "11", "Ice")); 
				mainDeckSpells.put("Iceburn Jinn", Arrays.asList("2", "100%", "9", "Ice")); 
				mainDeckSpells.put("Ice Trap", Arrays.asList("2", "100%", "0", "Ice"));
				mainDeckSpells.put("Wyvern", Arrays.asList("1", "100%", "4", "Ice")); 
				mainDeckSpells.put("Ice Blade", Arrays.asList("4", "100%", "0", "Ice")); 
				mainDeckSpells.put("Icespear", Arrays.asList("1", "100%", "1", "Ice")); 
				mainDeckSpells.put("Legion Shield", Arrays.asList("3", "100%", "1", "Ice"));
				mainDeckSpells.put("Lord Of Winter", Arrays.asList("1", "100%", "10", "Ice")); 
				mainDeckSpells.put("Mega Taunt", Arrays.asList("1", "100%", "5", "Ice")); 
				mainDeckSpells.put("Ice Dispel", Arrays.asList("1", "100%", "2", "Ice")); 
				mainDeckSpells.put("Glacial Fortress", Arrays.asList("3", "100%", "3", "Ice")); 
				mainDeckSpells.put("Jinn Vexation", Arrays.asList("4", "100%", "3", "Ice")); 
				mainDeckSpells.put("Oni's Destruction", Arrays.asList("1", "100%", "3", "Ice")); 
				mainDeckSpells.put("Reindeer Knight", Arrays.asList("3", "100%", "5", "Ice")); 
				mainDeckSpells.put("Frostfeather", Arrays.asList("2", "100%", "4", "Ice")); 
				mainDeckSpells.put("Snowball Barrage", Arrays.asList("1", "80%", "X", "Ice")); 
				mainDeckSpells.put("Steal Ward", Arrays.asList("3", "100%", "1", "Ice")); 
				mainDeckSpells.put("Stun Block", Arrays.asList("4", "100%", "0", "Ice")); 
				mainDeckSpells.put("Tower Shield", Arrays.asList("1", "100%", "0", "Ice")); 
				mainDeckSpells.put("Volcanic Shield", Arrays.asList("1", "100%", "0", "Ice")); 
				mainDeckSpells.put("Abominable Weaver", Arrays.asList("3", "100%", "5 (And 1 Shadow Pip)", "Ice")); 
				mainDeckSpells.put("Ether Shield", Arrays.asList("3", "100%", "0", "Myth")); 
				mainDeckSpells.put("Brace", Arrays.asList("1", "100%", "0", "Astral")); 
				mainDeckSpells.put("Sleet Storm", Arrays.asList("3", "100%", "0", "Astral")); 
				mainDeckSpells.put("Steal Pip", Arrays.asList("0", "100%", "1", "Balance")); 
				mainDeckSpells.put("Shrike", Arrays.asList("4", "100%", "0", "Shadow")); 

				tcDeckSpells.put("Snowman", Arrays.asList("2", "100%", "3", "Ice")); 
				tcDeckSpells.put("Frost Giant", Arrays.asList("4", "100%", "7", "Ice")); 
				tcDeckSpells.put("Ice Trap", Arrays.asList("1", "100%", "0", "Ice")); 
				tcDeckSpells.put("Ice Blade", Arrays.asList("4", "100%", "0", "Ice")); 
				tcDeckSpells.put("Legion Shield", Arrays.asList("4", "100%", "1", "Ice"));
				tcDeckSpells.put("Snow Angel", Arrays.asList("1", "80%", "8", "Ice")); 
				tcDeckSpells.put("Stun Block",  Arrays.asList("4", "100%", "0", "Ice")); 
				tcDeckSpells.put("Infallible",  Arrays.asList("4", "100%", "0", "Astral"));
				tcDeckSpells.put("Empower", Arrays.asList("8", "100%", "1", "Death"));
				tcDeckSpells.put("Feint", Arrays.asList("2", "100%", "1", "Death")); 
				tcDeckSpells.put("Reshuffle", Arrays.asList("2", "100%", "4", "Balance")); 
				tcDeckSpells.put("Weakness", Arrays.asList("4", "100%", "0", "Balance")); 


				fillMainDeck(mainDeckSpells, identity);
				fillTcDeck(tcDeckSpells, identity);

				fullDeck.add(mainDeckSpells); 
				fullDeck.add(tcDeckSpells); 

				return fullDeck;

			}
		}
		return null;
	}
	
	public void fillTcDeck(HashMap<String,List<String>> spells, String identity)
	{
		try {
			Connection conn1 = null; 
			String url1 = "jdbc:mysql://localhost:3306/wizard_schema";
			String user = "srik6724";
			String password = "28892K0shair!";
					
			conn1 = DriverManager.getConnection(url1, user, password);
			if(conn1 != null)
			{
    				// table doesn't exist, create it
    				String createTableSQL = "CREATE TABLE wizard_schema." + identity.toLowerCase() + "tcdeck " +
                        "(id INT NOT NULL, " +
                        " name VARCHAR(45), " + 
                        " level VARCHAR(45), " +
                        " description VARCHAR(500), " + 
                        " pip_chance VARCHAR(45), " +
                        " pips VARCHAR(45), " +
                        " school_typeSpell VARCHAR(45), " + 
                        " PRIMARY KEY ( id ))";
    					Statement statement = conn1.createStatement();
    					statement.executeUpdate(createTableSQL);
    					System.out.println("Table " + identity + "tcdeck created successfully.");
				int counter = 0; 
				String sql = "INSERT INTO wizard_schema." + identity.toLowerCase() + "tcdeck(id, name, level, description, pip_chance, pips, school_typeSpell) VALUES(?, ?, ?, ?, ?, ?, ?)"; 

				PreparedStatement st = conn1.prepareStatement(sql); 
				for(String spellName: spells.keySet())
				{
							int count = Integer.parseInt(spells.get(spellName).get(0)); 

							for(int i = 0; i < count; i++)
							{
								counter = counter + 1; 
		        		st.setInt(1, counter);
		        		st.setString(2, spellName);
		        		st.setString(3, "");
		        		st.setString(4, "");
		        		st.setString(5, spells.get(spellName).get(1));
		        		st.setString(6, spells.get(spellName).get(2));
		        		st.setString(7, spells.get(spellName).get(3));
								st.executeUpdate(); 
							}
							System.out.println(counter + "/" + "64 Main Deck Spells successfully inserted inside database."); 

		        }
						conn1.close();
			}
		}
		catch (SQLException ex) {
			ex.printStackTrace();
			System.out.println("An error occurred. Maybe user/password is invalid. Something not working here.");
	 }
	}
	
	public void fillMainDeck(HashMap<String,List<String>> spells, String identity)
	{
		try {
			Connection conn1 = null; 
			String url1 = "jdbc:mysql://localhost:3306/wizard_schema";
			String user = "srik6724";
			String password = "28892K0shair!";
					
			conn1 = DriverManager.getConnection(url1, user, password);
			if(conn1 != null)
			{
    				// table doesn't exist, create it
    				String createTableSQL = "CREATE TABLE wizard_schema." + identity.toLowerCase() + "maindeck " +
                        "(id INT NOT NULL, " +
                        " name VARCHAR(45), " + 
                        " level VARCHAR(45), " +
                        " description VARCHAR(500), " + 
                        " pip_chance VARCHAR(45), " +
                        " pips VARCHAR(45), " +
                        " school_typeSpell VARCHAR(45), " + 
                        " PRIMARY KEY ( id ))";
    					Statement statement = conn1.createStatement();
    					statement.executeUpdate(createTableSQL);
    					System.out.println("Table " + identity.toLowerCase() + "maindeck created successfully.");
				int counter = 0; 
				
				for(String spellName: spells.keySet())
				{
							String sql = "INSERT INTO wizard_schema." + identity.toLowerCase() + "maindeck(id, name, level, description, pip_chance, pips, school_typeSpell) VALUES(?, ?, ?, ?, ?, ?, ?)"; 

							PreparedStatement st = conn1.prepareStatement(sql); 
							int count = Integer.parseInt(spells.get(spellName).get(0)); 

							for(int i = 0; i < count; i++)
							{
								counter = counter + 1; 
		        		st.setInt(1, counter);
		        		st.setString(2, spellName);
		        		st.setString(3, "");
		        		st.setString(4, "");
		        		st.setString(5, spells.get(spellName).get(1));
		        		st.setString(6, spells.get(spellName).get(2));
		        		st.setString(7, spells.get(spellName).get(3));
								st.executeUpdate(); 
							}
							System.out.println(counter + "/" + "64 Main Deck Spells successfully inserted inside database."); 

		        }
						conn1.close();
			}
		}
		catch (SQLException ex) {
			ex.printStackTrace();
			System.out.println("An error occurred. Maybe user/password is invalid. Something not working. ");
	 }
	}

	public static void main(String[]args)
	{
		/*WizHeap hp = new WizHeap(); 
		System.out.println(hp.mainDeckSpells.size()); 
		System.out.println(hp.tcDeckSpells.size()); 
		hp.selectNOoption("balance", "NO");*/
		//hp.fillMainDeck(hp.mainDeckSpells, "balance");
		//hp.fillTcDeck(hp.tcDeckSpells, "balance");


	}

}
