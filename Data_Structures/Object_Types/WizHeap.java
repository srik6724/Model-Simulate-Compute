package Data_Structures.Object_Types;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
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
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Filter;

import Collections.Type_Set;
import RunTime.Failure.TypeException;
import Object_Types.Spell;
import Object_Types_Build.DarkmoorDeck;
import Object_Types_Build.MainDeck;
import Object_Types_Build.TreasureCardSideDeck;
import Object_Types_Parser.InputBuffer;
import Object_Types_Parser.LexicalAnalyzer;
import Object_Types_Parser.Parser;

public class WizHeap {

	public Map<String, List<String>> mainDeckSpells = new HashMap<String,List<String>>(); 
	public Map<String, List<String>> tcDeckSpells = new HashMap<String, List<String>>(); 
	private HeapInfo mainDeckInfo; 
	private HeapInfo tcDeckInfo; 
	
	public WizHeap()
	{
		System.out.println("WizHeap constructor called."); 
	}

	public String findDeckType()
	{
		System.out.println("Select whether you created custom deck or default deck. Type CD or DD."); 
		Scanner sc = new Scanner(System.in); 
		String optionSelected = sc.nextLine(); 
		switch(optionSelected)
		{
			case "CD": 
				break;
			case "DD": 
				break;
			default: 
				System.out.println("Sorry option you selected could not be found."); 
				break;
 		}
		sc.close(); 
		return optionSelected; 
	}

	public List<List<Element>> storeSpellsInHeap(String input, Spell[]mD, Spell[]tC, String identity, int selectionNo) throws InterruptedException, IOException
	{
		if(input.equals("CD"))
			if(mainDeckInfo.getElements() != null && tcDeckInfo.getElements() != null)
			{
				Element[] mainDeckElements = mainDeckInfo.getElements(); 
				Element[] tcDeckElements = tcDeckInfo.getElements(); 

				System.out.println("Main Deck Elements Length: " + mainDeckElements.length); 
				System.out.println("Tc Deck Elements Length: " + tcDeckElements.length);

				if(mainDeckElements.length == mD.length && tcDeckElements.length == tC.length)
				{
						int mainDeckCounter = 0; 
						for(Element e: mainDeckElements)
						{
							e.setSpellName(mD[mainDeckCounter].getName());
							e.setPipChance(mD[mainDeckCounter].getPipChance());
							e.setPips(mD[mainDeckCounter].getPips());
							e.setCount(mD[mainDeckCounter].getCount());
							e.setDescription(mD[mainDeckCounter].getDescription());
							e.setSchool(mD[mainDeckCounter].getSchool());  
							e.setTypeSpell(mD[mainDeckCounter].getTypeSpell());
							mainDeckCounter++;
						}
						int tcDeckCounter = 0; 
						for(Element e: tcDeckElements)
						{
							e.setSpellName(tC[tcDeckCounter].getName());
							e.setPipChance(tC[tcDeckCounter].getPipChance());
							e.setPips(tC[tcDeckCounter].getPips());
							e.setCount(tC[tcDeckCounter].getCount());
							e.setDescription(tC[tcDeckCounter].getDescription());
							e.setTypeSpell(tC[tcDeckCounter].getTypeSpell()); 
							tcDeckCounter++; 
						}
						mainDeckElements = buildHeap(mainDeckElements, identity, selectionNo, "main"); 
						tcDeckElements = buildHeap(tcDeckElements, identity, selectionNo, "tc"); 
						List<List<Element>> fullDeck  = new ArrayList<List<Element>>(); 
						fullDeck.add(Arrays.asList(mainDeckElements)); 
						fullDeck.add(Arrays.asList(tcDeckElements)); 

						return fullDeck; 
				}
			}
		else if(input.equals("DD"))
			if(mainDeckInfo.getElements() != null && tcDeckInfo.getElements() != null)
			{
				Element[] mainDeckElements = mainDeckInfo.getElements(); 
				Element[] tcDeckElements = tcDeckInfo.getElements(); 

				if(mainDeckElements.length == mainDeckSpells.size() && tcDeckElements.length == tcDeckSpells.size())
				{
					//int trackMainDeck = 0; 
					Iterator<String> mainDeckIterator = mainDeckSpells.keySet().iterator(); 
					Iterator<String> tcDeckIterator = tcDeckSpells.keySet().iterator();
					for(Element e: mainDeckElements)
					{
						while(mainDeckIterator.hasNext())
						{
							String mainDeckSpellName = mainDeckIterator.next(); 
							//e.spellName = mainDeckSpellName;
							//e.count = Integer.parseInt(mainDeckSpells.get(mainDeckSpellName).get(0));
							//e.pipChance = mainDeckSpells.get(mainDeckSpellName).get(1);
							//e.pips = mainDeckSpells.get(mainDeckSpellName).get(2);
							//e.school = mainDeckSpells.get(mainDeckSpellName).get(3);
						}
						//trackMainDeck++; 
					}
					buildHeap(mainDeckElements, identity, selectionNo, "main"); 
					//int trackTcDeck = 0; 
					for(Element e: tcDeckElements)
					{
						while(tcDeckIterator.hasNext())
						{
							String tcDeckSpellName = tcDeckIterator.next(); 
							//e.spellName = tcDeckSpellName;
							//e.count = Integer.parseInt(mainDeckSpells.get(tcDeckSpellName).get(0));
							//e.pipChance = mainDeckSpells.get(tcDeckSpellName).get(1);
							//e.pips = mainDeckSpells.get(tcDeckSpellName).get(2);
							//e.school = mainDeckSpells.get(tcDeckSpellName).get(3);
						}
						//trackTcDeck++; 
					}
					buildHeap(tcDeckElements, identity, selectionNo, "tc"); 
				}
				
			}

			return null; 
			
	}

	public void minHeapify(Element[]elements, int i)
	{
		try{
			int leftIndex = 2 * i; 
			int rightIndex = (2 * i) + 1; 
			int smallestIndex = i;
			if(leftIndex <= elements.length && Integer.parseInt(elements[leftIndex-1].getPips()) < Integer.parseInt(elements[i-1].getPips()))
			{
				smallestIndex = leftIndex; 
			}
			else 
			{
				smallestIndex = i; 
			}
			if(rightIndex <= elements.length && Integer.parseInt(elements[rightIndex-1].getPips()) < Integer.parseInt(elements[smallestIndex-1].getPips()))
			{
				smallestIndex = rightIndex;
			}
			if(smallestIndex != i)
			{
				Element storePipNumber = elements[i-1];
				elements[i-1] = elements[smallestIndex-1]; 
				elements[smallestIndex-1] = storePipNumber; 
				minHeapify(elements, smallestIndex);
			}
		}catch(Exception e)
		{

		}
	}

	public Element[] buildHeap(Element[]elements, String identity, int deckNo, String deckType) throws InterruptedException, IOException
	{
		for(int i = (int)Math.floor(elements.length/2); i >= 1; i--)
		{
			minHeapify(elements, i); 
		}
		System.out.println("Let's see the changes to our spells."); 
		Thread.sleep(1000);
		System.out.println("Filtering spells by pip count from lowest to highest."); 
		Thread.sleep(1000); 
		System.out.println("Here it goes."); 
		Thread.sleep(1000); 
		
			File f1 = new File("deck" + deckNo + "_" + deckType + ".txt"); 
			File[] files = new File[1]; 
			files[0] = f1; 
			FileWriter f = new FileWriter(files[0]);
			f.write(identity.toUpperCase() + " DECK\n"); 
			f.write("-----------------------------------" + "\n");
			for(Element e: elements)
			{
				System.out.println("Spell Name: " + e.getSpellName()); 
				f.write("Spell Name: " + e.getSpellName() + "\n"); 
				System.out.println("Count: " + e.getCount()); 
				f.write("Count: " + e.getCount() + "\n"); 
				System.out.println("Description: " + e.getDescription()); 
				f.write("Description: " + e.getDescription() + "\n"); 
				System.out.println("Pip Chance: " + e.getPipChance()); 
				f.write("Pip Chance: " + e.getPipChance() + "\n"); 
				System.out.println("Pips: " + e.getPips()); 
				f.write("Pips: " + e.getPips() + "\n"); 
				System.out.println("School: "  + e.getSchool()); 
				f.write("School: " + e.getSchool() + "\n"); 
				System.out.println("Type of Spell: " + e.getTypeSpell()); 
				f.write("Type Of Spell: " + e.getTypeSpell() + "\n"); 
				System.out.println("-----------------------------------"); 
				f.write("-----------------------------------" + "\n");
				System.out.println("Extracting type of spell info: " + e.getTypeSpell()); 
				Type_Set.initialize(e.getTypeSpell(), e);
			}
			f.close(); 
			System.out.println("Reading the deck file now"); 
			try(BufferedReader reader = new BufferedReader(new FileReader(files[0]))) {
				String line; 
				String[] lines = null;
				if(deckType.equals("main")) {
					lines = new String[514]; 
				}
				else if(deckType.equals("tc")) {
					lines = new String[322]; 
				}
				int index = 0; 
				while((line = reader.readLine()) != null) {
					lines[index] = line;
					index++;
				}
				new Parser(Arrays.asList(lines), deckType);
			}
			return elements; 
}

	public List<List<Element>> selectYESOption(String identity, String input, int selectionNo) throws InterruptedException, IOException
	{
		Scanner sc = new Scanner(System.in); 
		Spell[] mainDeck;
		Spell[] tcDeck;

		boolean iterate = true; 

		if(input.toLowerCase().equals("yes"))
		{
			System.out.println("Starting process to create custom deck"); 
			System.out.println("Select a Wizard101 world, and a deck chosen from there will be given to you.");
			String world = sc.nextLine(); 
			
			switch(world)
			{
				case "Celestia": 
					new DarkmoorDeck(identity); 
				case "Zafaria": 
					new DarkmoorDeck(identity); 
				case "Avalon": 
					new DarkmoorDeck(identity); 
				case "Azteca": 
					new DarkmoorDeck(identity); 
				case "Khrysalis": 
					new DarkmoorDeck(identity); 
				case "Darkmoor": 
					//Creates Darkmoor Deck by identity
					new DarkmoorDeck(identity); 
					//Retrieves main deck
					mainDeck = DarkmoorDeck.getMainDeck();
					//Retrieves tc deck
					tcDeck = DarkmoorDeck.getTcDeck(); 
					for(int i = 0; i < tcDeck.length; i++)
					{
						System.out.println("Spell Name: " + tcDeck[i].getName());
						System.out.println("Count: " + tcDeck[i].getCount()); 
						System.out.println("Description: " + tcDeck[i].getDescription()); 
						System.out.println("Pip Chance: " + tcDeck[i].getPipChance()); 
						System.out.println("Pips: " + tcDeck[i].getPips()); 
						System.out.println("Type Of Spell: " + tcDeck[i].getTypeSpell()); 
					}
					//Retrieve mainDeckInfo
					mainDeckInfo = new HeapInfo(mainDeck.length, MainDeck.maxSpells("mainDeck")); 
					//Retrieve tcDeckInfo
					tcDeckInfo = new HeapInfo(tcDeck.length, TreasureCardSideDeck.capacityOfDarkmoorDeck("tcDeck"));
					List<List<Element>> fullDeck = storeSpellsInHeap("CD", mainDeck, tcDeck, identity, selectionNo); 
					iterate = false; 
					return fullDeck; 
				case "Polaris": 
					new DarkmoorDeck(identity); 
				case "Mirage": 
					new DarkmoorDeck(identity); 
				case "Empyrea": 
					new DarkmoorDeck(identity); 
				case "Karamelle": 
					new DarkmoorDeck(identity); 
				case "Lemuria": 
					new DarkmoorDeck(identity); 
				case "Novus": 
					new DarkmoorDeck(identity);
				default: 
					System.out.println("Sorry, world could not be found."); 
					iterate = true; 
					break;
			}
		}
		return null; 
	}
	
	public List<Map<String, List<String>>> selectNOoption(String identity, String input, int selectionNo) throws InterruptedException, IOException
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
				String inputMainDeck = findDeckType(); 
				storeSpellsInHeap(inputMainDeck, null, null, null, selectionNo);
				fillTcDeck(tcDeckSpells, identity);
				String inputTcDeck = findDeckType(); 
				storeSpellsInHeap(inputTcDeck, null, null, null, selectionNo);

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
	
	public void fillTcDeck(Map<String,List<String>> spells, String identity)
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
	
	public void fillMainDeck(Map<String,List<String>> spells, String identity)
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

}
