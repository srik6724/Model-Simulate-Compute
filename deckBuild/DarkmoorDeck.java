package deckBuild;

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

import Credentials.WizCredentials;
import CustomExceptions.EmptyStringException;
import CustomExceptions.TypeException;
import SchoolSpells.Spell;
import wizPackage.Match;
import wizPackage.Option;

public class DarkmoorDeck implements Identity, TreasureCardSideDeck {
	private static Spell[] mainDeck; 
	private static Spell[] tcDeck;
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
	
	public DarkmoorDeck(String identity) throws IOException, InterruptedException
	{
		System.out.println("File or Scanner for deck configuration? Select file or scanner.");
		String input = sc.nextLine(); 
		setInput(true, input); 
		System.out.println(identity);
		collectIdentity = identity; 
		String retrieveDeckName = DarkmoorDeckName(collectIdentity);
		System.out.println("Darkmoor Deck Name: " + retrieveDeckName + " for Wizard " + DarkmoorDeck.decksMade);
		mainDeck = fillMainDeck();
		tcDeck = fillTcDeck(); 
		DarkmoorDeck.decksMade++; 
		Option.setFileInUse(false);
		Option.setScannerInUse(false);
		sc.close(); 
	}
	
	public String DarkmoorDeckName(String identity)
	{
		if(Identity.iceSchool().equals(identity))
		{
			return "Villages of Carpathes Case"; 
		}
		
		if(Identity.fireSchool().equals(identity))
		{		
			return "Dragonbone PasteBoards"; 
		}
		
		if(Identity.mythSchool().equals(identity))
		{		
			return "Deck of The Bound Spirit"; 
		}
		
		if(Identity.stormSchool().equals(identity))
		{
			return "Cards of The Howling Wolf"; 
		}
		
		if(Identity.lifeSchool().equals(identity))
		{
			return "Tatyana's Lost Tarot"; 
		}
		
		if(Identity.deathSchool().equals(identity))
		{
			return "Lord Of Death's Hand"; 
		}
		
		if(Identity.balanceSchool().equals(identity))
		{
			return "Set Of The Lovelorn Spirit"; 
		}
		else
		{
			String msg = "Strings do not match. Please enter in correct format."; 
			
			return msg;
		}
	}

	public static Spell[] getTcDeck()
	{
		return tcDeck;
	}
	
	public Spell[] fillTcDeck() throws IOException, InterruptedException
	{
		String label = "tcDeck"; 
		List<Spell> spellList = new ArrayList<Spell>(); 
		int retrieveCapacity = TreasureCardSideDeck.capacityOfDarkmoorDeck(tcDeckType); 
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
					Match.getBufferReader().readLine();
					Match.getBufferReader().readLine();
					initialFixIteration = false; 
				}
				spellInput = Match.getBufferReader().readLine();
				spellInput = spellInput.trim();
				System.out.println("Spell Input Read Here: " + spellInput);  
				//Thread.sleep(1000); 
			}

			if(spellInput instanceof String)
			{
				Spell spell = retrieveSpell(spellInput, spellList, label); 
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
		return spellList.toArray(new Spell[spellList.size()]); 
	}
	
	private Spell countSpell(List<Spell> spellList, HashMap<String, Integer> countOfEachSpell2, String spellName) throws InterruptedException {
		Spell spell = null; 
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

	public Spell[] fillMainDeck() throws IOException, InterruptedException
	{
		String label = "mainDeck"; 
		Scanner sc = new Scanner(System.in);
		List<Spell> spellList = new ArrayList<Spell>(); 
		int retrieveCapacity = MainDeck.maxSpells(mainDeckType); 
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
					Match.getBufferReader().readLine();
					Match.getBufferReader().readLine();
					initialFixIteration = false; 
				}
				spellInput = Match.getBufferReader().readLine();
				System.out.println("Spell Input Read Here: " + spellInput);  
				spellInput = spellInput.trim(); 
				//Thread.sleep(1000); 
			}

			if(spellInput instanceof String)
			{
				Spell spell = retrieveSpell(spellInput, spellList, label); 
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
		return spellList.toArray(new Spell[spellList.size()]); 
	}

	public static Spell[] getMainDeck()
	{
		return mainDeck;
	}
	
	public Spell retrieveSpell(String spellInput, List<Spell> spellList, String label) throws InterruptedException
	{
		if(!(spellInput instanceof String))
		{
			TypeException ex = new TypeException(); 
			ex.message("String");
			System.exit(1); 
		}
		Connection conn1; 
		Spell createSpell = null; 
		try{
			conn1 = DriverManager.getConnection(WizCredentials.getDB_URL(), WizCredentials.getDB_USERNAME(), WizCredentials.getDB_PASSWORD()); 
			if(conn1 != null)
			{
				HashMap<Integer, String> sqlTests = new HashMap<Integer, String>(); 
				String sql1 = "SELECT * FROM wizard_schema.balance_spells WHERE name = ?"; 
				String sql2 = "SELECT * FROM wizard_schema.ice_spells WHERE name = ?"; 
				String sql3 = "SELECT * FROM wizard_schema.life_spells WHERE name = ?"; 
				String sql4 = "SELECT * FROM wizard_schema.myth_spells WHERE name = ?"; 
				String sql5 = "SELECT * FROM wizard_schema.death_spells WHERE name = ?"; 
				String sql6 = "SELECT * FROM wizard_schema.fire_spells WHERE name = ?"; 
				String sql7 = "SELECT * FROM wizard_schema.storm_spells WHERE name = ?"; 
				String sql8 = "SELECT * FROM wizard_schema.astral_spells WHERE name = ?"; 
				String sql9 = "SELECT * FROM wizard_schema.shadow_spells WHERE name = ?"; 
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
						String name = rs.getString("name"); 
						String level = rs.getString("level"); 
						String description = rs.getString("description"); 
						String pip_chance = rs.getString("pip_chance"); 
						String pips = rs.getString("pips"); 
						String school = rs.getString("school"); 
						String school_typeSpell = rs.getString("typeSpell");
						boolean accessByOtherSchools = Boolean.parseBoolean(rs.getString("accessByOtherSchools")); 
						boolean accessByTC = Boolean.parseBoolean(rs.getString("accessByTC")); 
						
						if(name != null && level != null && description != null && pip_chance != null && pips != null && school != null && school_typeSpell != null)
						{
							//System.out.println("School Identity: " + collectIdentity); 
							if(school.toLowerCase().equals(collectIdentity.toLowerCase()))
							{
								createSpell = countSpell(spellList, countOfEachSpell, name); 
								if(createSpell == null)
								{
									createSpell = new Spell(name, level, description, pip_chance, pips, 1, school, school_typeSpell); 
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
									createSpell = new Spell(name, level, description, pip_chance, pips, currentCount, school, school_typeSpell); 
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
									createSpell = new Spell(name, level, description, pip_chance, pips, 1, school, school_typeSpell); 
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
									createSpell = new Spell(name, level, description, pip_chance, pips, currentCount, school, school_typeSpell); 
								}
							}
							else if(!(school.equals(collectIdentity)) && accessByTC == true && label.equals("tcDeck"))
							{
								createSpell = countSpell(spellList, countOfEachSpell, spellInput); 
								if(createSpell == null)
								{
									createSpell = new Spell(name, level, description, pip_chance, pips, 1, school, school_typeSpell); 
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
									createSpell = new Spell(name, level, description, pip_chance, pips, currentCount, school, school_typeSpell); 
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