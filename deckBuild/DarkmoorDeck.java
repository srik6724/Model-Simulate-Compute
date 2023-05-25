package deckBuild;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import CustomExceptions.TypeException;
import SchoolSpells.Spell;

public class DarkmoorDeck implements Identity, TreasureCardSideDeck {
	
	String tcDeckType = "tcDeck"; 
	String mainDeckType = "mainDeck"; 
	
	public DarkmoorDeck(String identity)
	{
		String retrieveDeckName = DarkmoorDeckName(identity);
		System.out.println("Darkmoor Deck Name: " + retrieveDeckName);
		
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
	
	public Spell[] fillTcDeck(Spell[]spells)
	{
		Scanner sc = new Scanner(System.in);
		List<Spell> spellList = new ArrayList<Spell>(); 
		int retrieveCapacity = TreasureCardSideDeck.capacityOfDarkmoorDeck(tcDeckType); 
		String spellInput = ""; 
		
		boolean check = true; 
		int i = 0; 
		
		while(check && i < retrieveCapacity)
		{
			System.out.println("Select a spell to place inside your deck."); 
			spellInput = sc.nextLine(); 
			boolean verify = findSpell(spells, spellInput); 
			if(spellInput instanceof String && verify == true)
			{
				Spell spell = retrieveSpell(spells, spellInput); 
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
	
	public Spell[] fillMainDeck(Spell[]spells)
	{
		Scanner sc = new Scanner(System.in);
		List<Spell> spellList = new ArrayList<Spell>(); 
		int retrieveCapacity = MainDeck.maxSpells(mainDeckType); 
		String spellInput = ""; 
		
		boolean check = true; 
		int i = 0; 
		
		while(check && i < retrieveCapacity)
		{
			System.out.println("Select a spell to place inside your deck."); 
			spellInput = sc.nextLine(); 
			boolean verify = findSpell(spells, spellInput); 
			if(spellInput instanceof String && verify == true)
			{
				Spell spell = retrieveSpell(spells, spellInput); 
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
	
	public boolean findSpell(Spell[]spells, String spellInput)
	{
		boolean check = true; 
		if(spellInput instanceof String)
		{
			for(int i = 0; i < spells.length; i++)
			{
				if(spells[i].getName().toLowerCase().equals(spellInput.toLowerCase()))
				{
					check = true; 
					break; 
				}
				else 
				{
					check = false; 
				}
			}
			return check; 
		}
		else 
		{
			TypeException exception = new TypeException(); 
			exception.message(spellInput);
			return false; 
		}
	}
	
	public Spell retrieveSpell(Spell[]spells, String spellInput)
	{
		int index = 0; 
		for(int i = 0; i < spells.length; i++)
		{
			if(spells[i].getName().toLowerCase().equals(spellInput.toLowerCase()))
			{
				index = i; 
				break; 
			}
			
		}
		return spells[index]; 
	}
}
