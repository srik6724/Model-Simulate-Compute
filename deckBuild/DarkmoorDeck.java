package deckBuild;

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

public class DarkmoorDeck implements Identity, TreasureCardSideDeck {
	private static Spell[] mainDeck; 
	private static Spell[] tcDeck;
	private static HashMap<String, Integer> countOfEachSpell = new HashMap<String, Integer>();
	String tcDeckType = "tcDeck"; 
	String mainDeckType = "mainDeck"; 
	
	public DarkmoorDeck(String identity)
	{
		String retrieveDeckName = DarkmoorDeckName(identity);
		System.out.println("Darkmoor Deck Name: " + retrieveDeckName);
		fillMainDeck();
		fillTcDeck(); 
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
	
	public Spell[] fillTcDeck()
	{
		Scanner sc = new Scanner(System.in);
		List<Spell> spellList = new ArrayList<Spell>(); 
		int retrieveCapacity = TreasureCardSideDeck.capacityOfDarkmoorDeck(tcDeckType); 
		String spellInput = ""; 
		
		boolean check = true; 
		int i = 0; 
		
		while(check && i < retrieveCapacity)
		{
			System.out.println("Select a spell to place inside your tc deck."); 
			spellInput = sc.nextLine(); 
			if(spellInput instanceof String)
			{
				Spell spell = retrieveSpell(spellInput, (Spell[])spellList.toArray()); 
				spellList.add(spell); 
				System.out.println("The following spell has been added: " + spell.getName()); 
				i = i + 1; 
				System.out.println(i + "/" + retrieveCapacity + " spells added.");
				check = true; 
			}
			else 
			{
				System.out.println("Try again to select a spell from the list of available spells."); 
				check = true; 
			}		
		}
		sc.close();
		return (Spell[])spellList.toArray();
	}
	
	private int countSpell(Spell[]spellList, HashMap<String, Integer> countOfEachSpell2, String spellName) {
		int count = 0; 
		for(int i = 0; i < spellList.length; i++)
		{
			if(!(spellList[i].getName().equals(spellName)))
			{ 
				continue; 
			}
			else 
			{
				int keyChange = countOfEachSpell2.get(spellName); 
				keyChange++; 
				countOfEachSpell2.put(spellName, keyChange); 
				count = keyChange; 
				return count; 
			}
		}
		System.out.println("Occurrence of spell never located: " + spellName); 
		countOfEachSpell2.put(spellName, 1);
		return 1;
	}

	public Spell[] fillMainDeck()
	{
		Scanner sc = new Scanner(System.in);
		List<Spell> spellList = new ArrayList<Spell>(); 
		int retrieveCapacity = MainDeck.maxSpells(mainDeckType); 
		String spellInput = ""; 
		
		boolean check = true; 
		int i = 0; 
		
		while(check && i < retrieveCapacity)
		{
			System.out.println("Select a spell to place inside your main deck."); 
			spellInput = sc.nextLine(); 
			if(spellInput instanceof String)
			{
				Spell spell = retrieveSpell(spellInput, (Spell[])spellList.toArray()); 
				spellList.add(spell); 
				System.out.println("The following spell has been added: " + spell.getName()); 
				i = i + 1; 
				System.out.println(i + "/" + retrieveCapacity + " spells added.");
				check = true; 
			}
			else 
			{
				System.out.println("Try again to select a spell from the list of available spells."); 
				check = true; 
			}	
		}	
		return (Spell[])spellList.toArray(); 
	}

	public static Spell[] getMainDeck()
	{
		return mainDeck; 
	}
	
	public Spell retrieveSpell(String spellInput, Spell[] spellList)
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
				sqlTests.put(1, sql1); 
				sqlTests.put(2, sql2); 
				sqlTests.put(3, sql3);
				sqlTests.put(4, sql4); 
				sqlTests.put(5, sql5);
				sqlTests.put(6, sql6); 
				sqlTests.put(7, sql7);
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
						String school_typeSpell = rs.getString("typeSpell");
						if(name != null && level != null && description != null && pip_chance != null && school_typeSpell != null)
						{
							int count = countSpell(spellList, countOfEachSpell, spellInput); 
							createSpell = new Spell(name, level, description, pip_chance, pips, count, school_typeSpell); 
							break Outer; 
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
