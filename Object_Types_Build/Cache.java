package Object_Types_Build;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import Model_Knowledge.Credentials;
import Object_Types.Category;
import Second_Process.Second;
import Second_Process.Option;
import RunTime.Disruption.EmptyStringException;
import RunTime.Disruption.TypeException;

public class Cache implements Label, Primary_Storage, Secondary_Storage {
	private static Category<Unit>[] mainDeck; 
	private static Category<Unit>[] tcDeck;
	static int decksMade = 1; 
	private static HashMap<String, Integer> countOfEachSpell = new HashMap<String, Integer>();
	private String collectIdentity; 
	String tcDeckType = "tcDeck"; 
	String mainDeckType = "mainDeck"; 

	Scanner sc = new Scanner(System.in);

	private boolean initialFixIteration = true; 

	private void setInput(boolean temp, String input) {
		if(input.equals("file")) {
			Option.setFileInUse(temp);
		}
		else if(input.equals("scanner")) {
			Option.setScannerInUse(temp);
		}
	}
	
	public Cache(String identity) throws IOException, InterruptedException
	{
		System.out.println("File or Scanner for deck configuration? Select file or scanner.");
		String input = sc.nextLine(); 
		if(!sc.hasNextLine()) {
			sc.close(); 
		}
		setInput(true, input); 
		System.out.println(identity);
		collectIdentity = identity; 
		String retrieveDeckName = CacheNumberings(collectIdentity);
		System.out.println("Darkmoor Deck Name: " + retrieveDeckName + " for Wizard " + Cache.decksMade);
		mainDeck = fillPrimaryStorage();
		tcDeck = fillSecondaryStorage(); 
		Cache.decksMade++; 
		Option.setFileInUse(false);
		Option.setScannerInUse(false);
	}
	
	public String CacheNumberings(String identity)
	{
		if(Label.iceSchool().equals(identity))
		{
			return "Cache 1"; 
		}
		
		if(Label.fireSchool().equals(identity))
		{		
			return "Cache 2"; 
		}
		
		if(Label.mythSchool().equals(identity))
		{		
			return "Cache 3"; 
		}
		
		if(Label.stormSchool().equals(identity))
		{
			return "Cache 4"; 
		}
		
		if(Label.lifeSchool().equals(identity))
		{
			return "Cache 5"; 
		}
		
		if(Label.deathSchool().equals(identity))
		{
			return "Cache 6"; 
		}
		
		if(Label.balanceSchool().equals(identity))
		{
			return "Cache 7"; 
		}
		else
		{
			return "Could not find a match for the given label";
		}
	}

	public static Category<Unit>[] getSecondaryStorage()
	{
		return tcDeck;
	}
	
	public Category<Unit>[] fillSecondaryStorage() throws IOException, InterruptedException
	{
		String label = "tcDeck"; 
		List<Category<Unit>> spellList = new ArrayList<Category<Unit>>(); 
		int retrieveCapacity = Secondary_Storage.capacityOfDarkmoorDeck(tcDeckType); 
		String spellInput = ""; 
		
		boolean check = true; 
		int i = 0; 
		
		while(check && i < retrieveCapacity)
		{
			System.out.println("Select a spell to place inside your tc deck."); 

			if(Option.getScannerInUse() == true) {
				spellInput = sc.nextLine();
			}

			if(Option.getFileInUse() == true) {
				if(initialFixIteration) {
					Second.getBufferReader().readLine();
					Second.getBufferReader().readLine();
					initialFixIteration = false; 
				}
				spellInput = Second.getBufferReader().readLine();
				spellInput = spellInput.trim();
				System.out.println("Spell Input Read Here: " + spellInput);  
				//Thread.sleep(1000); 
			}

			if(spellInput instanceof String)
			{
				Category<Unit> spell = retrieveSpell(spellInput, spellList, label); 
				if(spell != null)
				{
					if(!(spellList.contains(spell)))
					{
						spellList.add(spell); 
					}
					System.out.println("The following spell has been added: " + spell.getName()); 
					i = i + 1; 
					System.out.println(i + "/" + retrieveCapacity + " spells added.");
					check = true;
				} 
				else 
				{
					System.out.println("Spell: " + spellInput + " does not exist. Try again."); 
				}
			}
			else 
			{
				System.out.println("Try again to select a spell from the list of available spells."); 
				check = true; 
			}		
		}
		return spellList.toArray(new Category[spellList.size()]); 
	}
	
	private Category<Unit> countSpell(List<Category<Unit>> spellList, HashMap<String, Integer> countOfEachSpell2, String spellName) throws InterruptedException {
		Category<Unit> spell = null; 
		for(int i = 0; i < spellList.size(); i++)
		{
			if(!(spellList.get(i).getName().equals(spellName)))
			{ 
				continue; 
			}
			else 
			{
				int keyChange = countOfEachSpell2.get(spellName); 
				keyChange++; 
				countOfEachSpell2.put(spellName, keyChange); 
				return spellList.get(i); 
			}
		}
		//Thread.sleep(1000); 
		System.out.println("Occurrence of spell never located: " + spellName); 
		//Thread.sleep(1000); 
		countOfEachSpell2.put(spellName, 1);
		return spell; 
	}

	public Category<Unit>[] fillPrimaryStorage() throws IOException, InterruptedException
	{
		String label = "mainDeck"; 
		Scanner sc = new Scanner(System.in);
		List<Category<Unit>> spellList = new ArrayList<Category<Unit>>(); 
		int retrieveCapacity = Primary_Storage.maxSpells(mainDeckType); 
		String spellInput = ""; 
		
		boolean check = true; 
		int i = 0; 
		
		while(check && i < retrieveCapacity)
		{
			System.out.println("Select a spell to place inside your main deck."); 
			//Thread.sleep(1000); 

			if(Option.getScannerInUse() == true) {
				spellInput = sc.nextLine();
			}

			if(Option.getFileInUse() == true) {
				if(initialFixIteration) {
					Second.getBufferReader().readLine();
					Second.getBufferReader().readLine();
					initialFixIteration = false; 
				}
				spellInput = Second.getBufferReader().readLine();
				System.out.println("Spell Input Read Here: " + spellInput);  
				spellInput = spellInput.trim(); 
				//Thread.sleep(1000); 
			}

			if(spellInput instanceof String)
			{
				Category<Unit> spell = retrieveSpell(spellInput, spellList, label); 
				if(spell != null)
				{
					if(!(spellList.contains(spell)))
					{
						spellList.add(spell); 
					}
					System.out.println("The following spell has been added: " + spell.getName()); 
					//Thread.sleep(1000); 
					i = i + 1; 
					System.out.println(i + "/" + retrieveCapacity + " spells added.");
					//Thread.sleep(1000); 
					check = true;
				} 
				else 
				{
					System.out.println("Spell: " + spellInput + " could not be inserted either due to it not existing or could not be placed in tc or main decks. Try again."); 
				}
			}
			else 
			{
				System.out.println("Try again to select a spell from the list of available spells."); 
				check = true; 
			}	
		}
		initialFixIteration = true; 
		return spellList.toArray(new Category[spellList.size()]); 
	}

	public static Category<Unit>[] getPrimaryStorage()
	{
		return mainDeck;
	}
	
	public Category<Unit> retrieveSpell(String spellInput, List<Category<Unit>> spellList, String label) throws InterruptedException
	{
		if(!(spellInput instanceof String))
		{
			TypeException ex = new TypeException(); 
			ex.message("String");
			System.exit(1); 
		}
		Connection conn1; 
		Category<Unit> createSpell = null; 
		try{
			conn1 = DriverManager.getConnection(Credentials.getDB_URL(), Credentials.getDB_USERNAME(), Credentials.getDB_PASSWORD()); 
			if(conn1 != null)
			{
				HashMap<Integer, String> sqlTests = new HashMap<Integer, String>(); 
				String sql1 = "SELECT * FROM wizard_schema.energy_units WHERE tag = ?"; 
				String sql2 = "SELECT * FROM wizard_schema.consumer_discretionary_units WHERE tag = ?"; 
				String sql3 = "SELECT * FROM wizard_schema.financials_units WHERE tag = ?"; 
				String sql4 = "SELECT * FROM wizard_schema.materials_units WHERE tag = ?"; 
				String sql5 = "SELECT * FROM wizard_schema.information_technology_units WHERE tag = ?"; 
				String sql6 = "SELECT * FROM wizard_schema.healthcare_units WHERE tag = ?"; 
				String sql7 = "SELECT * FROM wizard_schema.industrials_units WHERE tag = ?"; 
				String sql8 = "SELECT * FROM wizard_schema.consumer_staples_units WHERE tag = ?"; 
				String sql9 = "SELECT * FROM wizard_schema.utilities_units WHERE tag = ?"; 
				sqlTests.put(1, sql1); 
				sqlTests.put(2, sql2); 
				sqlTests.put(3, sql3);
				sqlTests.put(4, sql4); 
				sqlTests.put(5, sql5);
				sqlTests.put(6, sql6); 
				sqlTests.put(7, sql7);
				sqlTests.put(8, sql8); 
				sqlTests.put(9, sql9); 
				Outer: 
				for(int num: sqlTests.keySet())
				{
					String sql = sqlTests.get(num); 
					PreparedStatement stmt = conn1.prepareStatement(sql); 
					stmt.setString(1, spellInput);
					ResultSet rs = stmt.executeQuery(); 
					while(rs.next())
					{
						String name = rs.getString("tag"); 
						System.out.println("Name: " + name); 
						String level = rs.getString("lifetime"); 
						System.out.println("Level: " + level); 
						String description = rs.getString("information"); 
						System.out.println("Description: " + description);
						String pip_chance = rs.getString("success_build_rate"); 
						System.out.println("Pip Chance: " + pip_chance);
						String pips = rs.getString("assembly_no_of_steps"); 
						System.out.println("Pips: "  + pips); 
						String school = rs.getString("category"); 
						System.out.println("School: " + school); 
						String school_typeSpell = rs.getString("industryType");
						System.out.println("Type Spell: " + school_typeSpell);
						boolean accessByOtherSchools = Boolean.parseBoolean(rs.getString("applicableToOtherCategories")); 
						System.out.println("Access By Other Schools: " + accessByOtherSchools);
						boolean accessByTC = Boolean.parseBoolean(rs.getString("accessBySecondaryStorage")); 
						System.out.println("Access By TC: " + accessByTC);
						
						if(name != null && level != null && description != null && pip_chance != null && pips != null && school != null && school_typeSpell != null)
						{
							//System.out.println("School Identity: " + collectIdentity); 
							if(school.toLowerCase().equals(collectIdentity.toLowerCase()))
							{
								createSpell = countSpell(spellList, countOfEachSpell, name); 
								if(createSpell == null)
								{
									createSpell = new Category<Unit>(name, level, description, pip_chance, pips, 1, school, school_typeSpell); 
								}
								else 
								{
									int currentCount = 0; 
									for(String spellName: countOfEachSpell.keySet())
									{
										if(createSpell.getName().equals(spellName))
										{
											currentCount = countOfEachSpell.get(spellName);
											break;
										}
									}
									System.out.println("Current Count: " + currentCount); 
									//Thread.sleep(1000); 
									createSpell = new Category<Unit>(name, level, description, pip_chance, pips, currentCount, school, school_typeSpell); 
								}
							}
							else if(!(school.equals(collectIdentity)) && accessByOtherSchools == false && label.equals("mainDeck"))
							{
								System.out.println("The card could not be inserted as only schools of " + school.toLowerCase() + " school can obtain this by spell quests."); 
							}
							else if(!(school.equals(collectIdentity)) && accessByOtherSchools == false && accessByTC == false && label.equals("tcDeck"))
							{
								System.out.println("The card could not be inserted of school " + school + " since it does not exist as tc card."); 
							}
							else if(!(school.equals(collectIdentity)) && accessByOtherSchools == true && label.equals("mainDeck"))
							{
								createSpell = countSpell(spellList, countOfEachSpell, name); 
								if(createSpell == null)
								{
									createSpell = new Category<Unit>(name, level, description, pip_chance, pips, 1, school, school_typeSpell); 
								}
								else 
								{
									int currentCount = 0; 
									for(String spellName: countOfEachSpell.keySet())
									{
										if(createSpell.getName().equals(spellName))
										{
											currentCount = countOfEachSpell.get(spellName);
											break;
										}
									}
									System.out.println("Current Count: " + currentCount); 
									//Thread.sleep(1000); 
									createSpell = new Category<Unit>(name, level, description, pip_chance, pips, currentCount, school, school_typeSpell); 
								}
							}
							else if(!(school.equals(collectIdentity)) && accessByTC == true && label.equals("tcDeck"))
							{
								createSpell = countSpell(spellList, countOfEachSpell, spellInput); 
								if(createSpell == null)
								{
									createSpell = new Category<Unit>(name, level, description, pip_chance, pips, 1, school, school_typeSpell); 
								}
								else 
								{
									int currentCount = 0; 
									for(String spellName: countOfEachSpell.keySet())
									{
										if(createSpell.getName().equals(spellName))
										{
											currentCount = countOfEachSpell.get(spellName);
											break;
										}
									}
									System.out.println("Current Count: " + currentCount); 
									//Thread.sleep(1000); 
									createSpell = new Category<Unit>(name, level, description, pip_chance, pips, currentCount, school, school_typeSpell); 
								}
							}
						}
					}
				}
				return createSpell; 
			}
		}catch(SQLException e)
		{
			System.out.println("Sorry, an error occurred here."); 
		}
		return null;
	}

	
}