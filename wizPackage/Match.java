package wizPackage;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import org.python.apache.commons.compress.harmony.pack200.NewAttributeBands.Callable;

import Credentials.WizCredentials;

import com.mysql.cj.jdbc.CallableStatement;
import com.mysql.cj.x.protobuf.MysqlxPrepare.Prepare;

import CustomExceptions.TypeException;
import Gear.Amulet;
import Gear.Athame;
import Gear.Boot;
import Gear.Deck;
import Gear.Gear;
import Gear.Hat;
import Pets.Pet; 
import Gear.Ring;
import Gear.Robe;
import Gear.Wand;
import Stats.AeonAmuletStats;
import Stats.AeonAthameStats;
import Stats.AeonBootsStats;
import Stats.AeonDeckStats;
import Stats.AeonHatStats;
import Stats.AeonRingStats;
import Stats.AeonRobeStats;
import Stats.AeonWandStats;
import wizPackage.LinkedList.Node;
import PlayerStats.Player;
import SchoolSpells.Spell;
import SchoolSpells.schoolSpells;
import Sockets.Socket; 
public class Match implements MooshuArena, DragonSpyreArena, GrizzleheimArena, HeapArena, Arena, AvalonArena {
	
	//Arrays to store information about the firstTeam and secondTeam. 
	private String[] firstTeam = new String[4]; 
	private String[] firstTeamLevels = new String[4]; 
	private String[] firstTeamSchools = new String[4]; 
	private String[] secondTeam = new String[4]; 
	private String[] secondTeamLevels = new String[4]; 
	private String[] thirdTeamLevels = new String[4]; 
	
	private StopWatch watch = new StopWatch(); 
	public Proposition statement = new Proposition(); 
	public String inputReceived = null; 
	
	private static ArrayList<Spectator> spectators; 
	
	private String[] wizSchools = {"Balance", "Death", "Storm", "Myth", "Ice", "Fire", "Life"}; 
	
	private String[] firstTeamOrder = new String[4]; 
	private String[] secondTeamOrder = {}; 
	
	private static HashMap<String, List<Spell>> decks = new HashMap<String, List<Spell>>(); 

	//Declare a Spell list that contains BalanceSpells, FireSpells, LifeSpells, IceSpells, Deathspells, MythSpells, and StormSpells
	//private ArrayList<Spells> spells; 
	
	int startCountDown; 
	
	public static int spectatorCount = 0; 
	public static int countDownNumber = 10; 
	
	public String retrieveFirstTeamName; 
	public String retrieveSecondTeamName; 
	
	
	String T1firstPlayer; 
	String T1firstPlayerLevel; 
	String T1firstPlayerSchool;
	
	String T1secondPlayer; 
	String T1secondPlayerLevel; 
	String T1secondPlayerSchool;
	
	String T1thirdPlayer; 
	String T1thirdPlayerLevel;
	String T1thirdPlayerSchool;
	
	String T1fourthPlayer; 
	String T1fourthPlayerLevel; 
	String T1fourthPlayerSchool;
	
	String T2firstPlayer; 
	String T2firstPlayerLevel;
	String T2firstPlayerSchool;
	
	String T2secondPlayer; 
	String T2secondPlayerLevel; 
	String T2secondPlayerSchool;
	
	String T2thirdPlayer; 
	String T2thirdPlayerLevel; 
	String T2thirdPlayerSchool;
	
	String T2fourthPlayer; 
	String T2fourthPlayerLevel; 
	String T2fourthPlayerSchool;
	
	
	public void enroll2Teams()
	{
		enrollFirstTeamPlayers(); 
		enrollSecondTeamPlayers(); 
		System.out.println(retrieveFirstTeamName + " will be competing against " + retrieveSecondTeamName); 
		randomizeArenaSelection(); 
		matchCountDown(retrieveFirstTeamName, retrieveSecondTeamName); 
		//fillDecks(); 
		beginMatch();
	}
	
	
	public void enrollFirstTeamPlayers()
	{
		Scanner sc = new Scanner(System.in);
		
		System.out.println("First Team");
		System.out.println("-------------------"); 
		System.out.println("What is the name of your team?"); 
		
		retrieveFirstTeamName = sc.nextLine(); 		
		
		boolean checkPlayer = true; 
		
		System.out.println("INSTRUCTIONS FOR REGISTERING A TEAM. Follow carefully."); 
		System.out.println("First, please write down the names of your players."
				+ "After this step is completed, write down the corresponding levels of each player." + "Then proceed"
						+ "to write down the school identities of every player."); 
		System.out.println("We humbly request it is done in this order as we would hope to avoid any technical "
				+ "issues on our end for registering all teams. Thank you! "); 
		
		while(checkPlayer)
		{
			System.out.println("Please write down the names of the 4 players of your team."); 
			T1firstPlayer = sc.nextLine(); 
			T1secondPlayer = sc.nextLine(); 
			T1thirdPlayer = sc.nextLine(); 
			T1fourthPlayer = sc.nextLine(); 
			
			if(isNumeric(T1firstPlayer) == true)
			{
				System.out.println("Not a valid name for " + T1firstPlayer);
				checkPlayer = true; 
			}
			else if(isNumeric(T1secondPlayer) == true)
			{
				System.out.println("Not a valid name for " + T1secondPlayer); 
				checkPlayer = true; 
			}
			else if(isNumeric(T1thirdPlayer) == true)
			{
				System.out.println("Not a valid name for " + T1thirdPlayer); 
				checkPlayer = true; 
			}
			else if(isNumeric(T1fourthPlayer) == true)
			{
				System.out.println("Not a valid name for " + T1fourthPlayer); 
				checkPlayer = true; 
			}
			else
			{
				checkPlayer = false; 
				System.out.println("Success, now write down the levels of each player given the order you registered the players."); 
				firstTeam[0] = T1firstPlayer; 
				firstTeam[1] = T1secondPlayer; 
				firstTeam[2] = T1thirdPlayer; 
				firstTeam[3] = T1fourthPlayer; 
			}
			
			while(!checkPlayer)
			{
				System.out.println("Write down the levels of each player for Team 1.\t");
				System.out.println("\t"); 
				System.out.println("Write down " + T1firstPlayer + " level.\t"); 
				T1firstPlayerLevel = sc.nextLine(); 
				System.out.println("Write down " + T1secondPlayer + " level.\t"); 
				T1secondPlayerLevel = sc.nextLine(); 
				System.out.println("Write down " + T1thirdPlayer + " level.\t"); 
				T1thirdPlayerLevel = sc.nextLine(); 
				System.out.println("Write down " + T1fourthPlayer + " level.\t"); 
				T1fourthPlayerLevel = sc.nextLine(); 
				
				if(isNumeric(T1firstPlayerLevel) == false)
				{
					System.out.println("Not a valid level entered for " + T1firstPlayer);
					checkPlayer = false; 
				}
				else if(isNumeric(T1secondPlayerLevel) == false)
				{
					System.out.println("Not a valid level entered for " + T1secondPlayer); 
					checkPlayer = false; 
				}
				else if(isNumeric(T1thirdPlayerLevel) == false)
				{
					System.out.println("Not a valid level entered for " + T1thirdPlayer); 
					checkPlayer = false; 
				}
				else if(isNumeric(T1fourthPlayerLevel) == false)
				{
					System.out.println("Not a valid level entered for " + T1fourthPlayer); 
					checkPlayer = false; 
				}
				else
				{
					checkPlayer = true;
					firstTeamLevels[0] = T1firstPlayerLevel; 
					firstTeamLevels[1] = T1secondPlayerLevel; 
					firstTeamLevels[2] = T1thirdPlayerLevel; 
					firstTeamLevels[3] = T1fourthPlayerLevel; 
				}
			}
			
			System.out.println("Success, now proceed to write down each of the school identities of the players."); 
			System.out.println(); 
			System.out.println(); 
			System.out.println(); 
			System.out.println(); 
			System.out.println("Just a note. The following school names allowed to be entered are: "
					+ "Ice, Fire, Death, Balance, Life, Myth, and Storm."
					+ "Any other schools will not be accepted.");
			
			while(checkPlayer)
			{
				System.out.println("\t"); 
				System.out.println("Write down " + T1firstPlayer + " school.\t"); 
				T1firstPlayerSchool = sc.nextLine(); 
				System.out.println("Write down " + T1secondPlayer + " school.\t"); 
				T1secondPlayerSchool = sc.nextLine(); 
				System.out.println("Write down " + T1thirdPlayer + " school.\t"); 
				T1thirdPlayerSchool = sc.nextLine(); 
				System.out.println("Write down " + T1fourthPlayer + " school.\t"); 
				T1fourthPlayerSchool = sc.nextLine(); 
				
				boolean checkSchool1 = findSchool(wizSchools, T1firstPlayerSchool); 
				boolean checkSchool2 = findSchool(wizSchools, T1secondPlayerSchool); 
				boolean checkSchool3 = findSchool(wizSchools, T1thirdPlayerSchool); 
				boolean checkSchool4 = findSchool(wizSchools, T1fourthPlayerSchool); 
				
				if(isNumeric(T1firstPlayerSchool) == true || checkSchool1 == false)
				{
					System.out.println("Not a valid school name entered for " + T1firstPlayer);
					checkPlayer = true; 
				}
				else if(isNumeric(T1secondPlayerSchool) == true || checkSchool2 == false)
				{
					System.out.println("Not a valid school name entered for " + T1secondPlayer); 
					checkPlayer = false; 
				}
				else if(isNumeric(T1thirdPlayerSchool) == true || checkSchool3 == false)
				{
					System.out.println("Not a valid school name entered for " + T1thirdPlayer); 
					checkPlayer = false; 
				}
				else if(isNumeric(T1fourthPlayerSchool) == true || checkSchool4 == false)
				{
					System.out.println("Not a valid school name entered for " + T1fourthPlayer); 
					checkPlayer = false; 
				}
				else
				{
					checkPlayer = false;
					firstTeamSchools[0] = T1firstPlayerSchool; 
					firstTeamSchools[1] = T1secondPlayerSchool; 
					firstTeamSchools[2] = T1thirdPlayerSchool; 
					firstTeamSchools[3] = T1fourthPlayerSchool; 
				}
			}
			
		}
		System.out.println();
		System.out.println(); 
		System.out.println(); 
		System.out.println(); 
		System.out.println("You are now clear to now create a deck for each player on your team."); 
		
		int index = 0; 
		createDeck(firstTeamSchools[0]);
		/*while(index < firstTeamSchools.length)
		{
			createDeck(firstTeamSchools[index]); 
			System.out.println("Deck created for " + firstTeamSchools[index]); 
			index = index + 1; 
		}*/
		System.out.println("The decks are now created for all schools specified.");
		System.out.println();
		System.out.println(); 
		System.out.println(); 
		System.out.println(); 
		System.out.println("The next step will involve player stats to be recorded of every individual."); 
		System.out.println("This is expected to take around 10-15 minutes in total, so please be patient."); 

		HashMap<String, List<String>> gearSets = new HashMap<String, List<String>>(); 
		int place = 0; 
		int firstIteration = 1; 
		String saveDuplicateKey = ""; 
		LinkedList list = new LinkedList(); 
		for(int i = 0; i < firstTeam.length; i++)
		{
			String fullGearString = computePlayerInformation(firstTeam[i], firstTeamSchools[i], Integer.parseInt(firstTeamLevels[i]));
			ArrayList<String> storeGearPieces = new ArrayList<String>(); 
			String gearToAdd = ""; 
			int start = 1; 
			while(start <= 8)
			{
				for(int j = place; j < fullGearString.indexOf(',', 1); j++)
				{
					gearToAdd += fullGearString.substring(j, j+1); 
				}

				if(start == 8)
				{
					for(int x = 0; x < fullGearString.length(); x++)
					{
						gearToAdd += fullGearString.substring(x, x+1); 
					}
				}		
				System.out.println(gearToAdd); 
				storeGearPieces.add(gearToAdd); 
				if(start < 8)
				{
					gearToAdd += ","; 
				}
				fullGearString = cutPartOfString(gearToAdd, fullGearString); 
				gearToAdd = ""; 
				start = start + 1; 
			}
			System.out.println(firstTeam[i]); 
			boolean checkIfExists = searchInGearSets(gearSets, firstTeam[i]); 
			if(checkIfExists == true)
			{
				if(firstIteration == 1)
				{
					saveDuplicateKey = firstTeam[i]; 
					List<String> gearItems = retrieveDuplicateKeyInfo(gearSets, firstTeam[i]);
					LinkedList.Node node = new LinkedList.Node(firstTeam[i], gearItems); 
					list.insert(node); 
					LinkedList.Node anotherNode = new LinkedList.Node(firstTeam[i], storeGearPieces); 
					list.insert(anotherNode); 
					firstIteration = 0; 
				}
				else 
				{
					LinkedList.Node node = new LinkedList.Node(firstTeam[i], storeGearPieces); 
					list.insert(node); 
				}
				/*if(LinkedList.root != null)
				{
					String modify_Contents = LinkedList.root.wizard + " " + count; 
					gearSets.put(modify_Contents, storeGearPieces); 
					count = count + 1; 
				}*/
			}
			else 
			{
				gearSets.put(firstTeam[i], storeGearPieces);
			}
		}
		list.printNodeData();
		Node current = LinkedList.head; 
		int count = 1; 
		String modified_wizardName = ""; 
		while(current.next != null)
		{
			modified_wizardName = current.wizard + " " + count; 
			gearSets.put(modified_wizardName, current.data); 
			current = current.next; 
			count = count + 1; 
		}
		modified_wizardName = current.wizard + " " + count; 
		gearSets.put(modified_wizardName, current.data); 
		gearSets.remove(saveDuplicateKey); 
		for(String wizard: gearSets.keySet())
		{
			System.out.println(wizard); 
			System.out.println(gearSets.get(wizard).get(0)); 
		}
		computeStatsInformation(gearSets);
		
		
		
		System.out.println("Now, for the final step of registration, enter the order your team "
				+ "would like to be placed in during the match."); 
		
		int playerOrderCount = 4; 
		int startIndex = 0; 
		String retrievePlayerName = ""; 
		boolean cont = true; 
		while(startIndex < playerOrderCount && cont == true)
		{
			System.out.println("Enter " + (startIndex+1) + "st player"); 
			retrievePlayerName = sc.nextLine(); 
			boolean checkPlayer1 = validatePlayer(retrievePlayerName, startIndex);
			if(checkPlayer1 == true)
			{
				cont = true; 
				firstTeamOrder[startIndex] = retrievePlayerName; 
				startIndex = startIndex + 1; 
				System.out.println("Player " + startIndex + ": " + retrievePlayerName + " registered successfully.");
			}
			else
			{
				System.out.println("Error occurred with registering Player " + startIndex);
				System.out.print("Try again.");
			}
			
		}
		
		int start = 1; 
		for(int i = 0; i < firstTeamOrder.length; i++)
		{
			System.out.println("Player # " + start + ": " + firstTeamOrder[i] + "," + firstTeamLevels[i] + "," + firstTeamSchools[i] +  " successfully enrolled in " + retrieveFirstTeamName); 
			start = start + 1; 
		}
		System.out.println("Congratulations, team " + retrieveFirstTeamName + " is enrolled officially.");
		
	}
	
	private List<String> retrieveDuplicateKeyInfo(HashMap<String, List<String>> gearSets, String string) {
		List<String> gearItems = new ArrayList<String>(); 
		for(String wizard: gearSets.keySet())
		{
			if(wizard.equals(string))
			{
				gearItems.add(gearSets.get(wizard).get(0)); //hat
				gearItems.add(gearSets.get(wizard).get(1)); //robe
				gearItems.add(gearSets.get(wizard).get(2)); //boots
				gearItems.add(gearSets.get(wizard).get(3)); //wand
				gearItems.add(gearSets.get(wizard).get(4)); //athame
				gearItems.add(gearSets.get(wizard).get(5)); //amulet
				gearItems.add(gearSets.get(wizard).get(6)); //ring
				gearItems.add(gearSets.get(wizard).get(7)); //deck
				break;
			}
		}
		return gearItems;
	}


	private void createDeck(String str) {
		
		schoolSpells spells = new schoolSpells(); 
		
		switch(str.toLowerCase()) {
		
		case "balance": 
			decks.put("balance", schoolSpells.allSchoolSpells.get(0)); 
			System.out.println("Success, balance deck is in!"); 
			break;
		
		case "fire": 
			decks.put("fire", schoolSpells.allSchoolSpells.get(1));
			System.out.println("Success, fire deck is in!"); 
			break;
			
		case "ice": 
			decks.put("storm", schoolSpells.allSchoolSpells.get(2)); 
			System.out.println("Success, ice deck is in!"); 
			break;
		
		/*case "life": 
			decks.put("life", schoolSpells.allSchoolSpells.get(3)); 
			System.out.println("Success, life deck is in!"); 
			break;*/
		
		case "death": 
			decks.put("death", schoolSpells.allSchoolSpells.get(4)); 
			System.out.println("Success, death deck is in!"); 
			break;
		
		/*case "storm": 
			decks.put("storm", schoolSpells.allSchoolSpells.get(5));
			System.out.println("Success, storm deck is in!"); 
			break;*/
			
		/*case "myth": 
			decks.put("myth", schoolSpells.allSchoolSpells.get(6)); 
			System.out.println("Success, myth deck is in!"); 
			break;*/
		default: 
			TypeException ex = new TypeException(); 
			ex.message(str); 
		
		}
		
		
	}


	public void enrollSecondTeamPlayers()
	{
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Second Team");
		System.out.println("-------------------"); 
		System.out.println("What is the name of your team?"); 
		
		retrieveSecondTeamName = sc.nextLine(); 
		
		System.out.println("Please write down the names of the 4 players of your team."); 
		
		boolean checkPlayer = true; 
		
		while(checkPlayer)
		{
			T2firstPlayer = sc.nextLine(); 
			T2secondPlayer = sc.nextLine(); 
			T2thirdPlayer = sc.nextLine(); 
			T2fourthPlayer = sc.nextLine(); 
			
			if(isNumeric(T2firstPlayer) == true)
			{
				System.out.println("Not a valid name for " + T2firstPlayer);
				checkPlayer = true; 
			}
			else if(isNumeric(T2secondPlayer) == true)
			{
				System.out.println("Not a valid name for " + T2secondPlayer); 
				checkPlayer = true; 
			}
			else if(isNumeric(T2thirdPlayer) == true)
			{
				System.out.println("Not a valid name for " + T2thirdPlayer); 
				checkPlayer = true; 
			}
			else if(isNumeric(T2fourthPlayer) == true)
			{
				System.out.println("Not a valid name for " + T2fourthPlayer); 
				checkPlayer = true; 
			}
			else
			{
				checkPlayer = false; 
				secondTeam[0] = T2firstPlayer; 
			  secondTeam[1] = T2secondPlayer; 
				secondTeam[2] = T2thirdPlayer; 
				secondTeam[3] = T2fourthPlayer; 
			}
			
		}
		int start = 1; 
		for(int i = 0; i < secondTeam.length; i++)
		{
			System.out.println("Player # " + start + ": " + secondTeam[i] + " successfully enrolled in " + retrieveSecondTeamName); 
			start = start + 1; 
		}
		System.out.println("Congratulations, team " + retrieveSecondTeamName + " is enrolled officially.");
		
		
	}
	
	public boolean isNumeric(String str)
	{
		if(str == null)
		{
			return false; 
		}
		
		try {
			Double.parseDouble(str); 
			return true; 
		} catch(NumberFormatException exception)
		{
			return false; 
		}
	}
	
	public boolean findSchool(String[]arr, String schoolEntered)
	{
		boolean check = true; 
		
		for(int i = 0; i < arr.length; i++)
		{
			if(arr[i].toLowerCase().equals(schoolEntered.toLowerCase()))
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
	
	public void randomizeArenaSelection()
	{
		int ArenaNumber = Arena.ArenaNumber();
		int AvalonArenaNumber = AvalonArena.returnAvalonArenaNumber(); 
		int DragonSpyreArenaNumber = DragonSpyreArena.DragonSpyreArenaNumber(); 
		int GrizzleheimArenaNumber = GrizzleheimArena.GrizzleheimArenaNumber(); 
		int HeapArenaNumber = HeapArena.HeapArenaNumber(); 
		
		int MooshuArenaNumber = MooshuArena.MooshuaArenaNumber(); 
		
		String arenaName = " "; 
		int ArenaNumberSelected = (int)(Math.random() * 6) + 1; 
		
		int[] arenaNumbers = {ArenaNumber, AvalonArenaNumber, DragonSpyreArenaNumber, GrizzleheimArenaNumber, HeapArenaNumber, MooshuArenaNumber};
		String[] arenaNames = {ArenaName(), AvalonArenaName(), DragonSpyreArenaName(), GrizzleheimArenaName(), HeapArenaName(), MooshuArenaName()}; 
		
		
		boolean matchArenaNumber = true; 
	
		
		for(int i = 0; i < arenaNumbers.length; i++)
		{
			if(arenaNumbers[i] == ArenaNumberSelected)
			{
				arenaName = arenaNames[i]; 
				ArenaNumberSelected = arenaNumbers[i]; 
				break; 
			}
		}
		
		System.out.println("The chosen Arena Number is " + ArenaNumberSelected);
		System.out.println("This corresponds to the arena of " + arenaName);
	}
	
	public void matchCountDown(String firstTeamName, String secondTeamName)
	{
		int randomNumberGenerated = (int) (Math.random() * 6) + 1;  
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("It is official."); 
		System.out.println("Team " + firstTeam + " will be versing " + secondTeam); 
		
		System.out.println("You start the countdown from 10 to 1 for when you want the match to begin."); 
		System.out.println("Make sure to do this; Otherwise, the match will not START."); 
		
		boolean startAtRightCount = true; 
			
		while(startAtRightCount)
		{
			System.out.println("Start countdown at " + countDownNumber);
			startCountDown = sc.nextInt(); 
				
			if(startCountDown == countDownNumber && startCountDown != 0 && countDownNumber != 0)
			{
				countDownNumber = countDownNumber - 1; 
				addSpectator(randomNumberGenerated);
				startAtRightCount = true; 
			}
				
			if(countDownNumber == 0 && startCountDown == 0)
			{
				addSpectator(randomNumberGenerated);
				System.out.println("Match has started."); 
				startAtRightCount = false; 
			}
		}
		int numberOfSpectators = countSpectators(); 
		System.out.println("We will have " + numberOfSpectators + " spectators " + "watching the match. "); 
		boolean checkPlausibleBets = placeBets(); 
		if(checkPlausibleBets == false)
		{
			System.out.println("No bids have been made as of now."); 
		}
		else
		{
			System.out.println("The bids have been placed for the time being."); 
			System.out.println("Bets have been placed for this following team: " + inputReceived); 
		}
		
		String[] checkIfSorted = sortTeamsAlphabetically(firstTeam); 
		for(int i = 0; i < checkIfSorted.length; i++)
		{
			System.out.println("Sorted element " + i + ": " + checkIfSorted[i]); 
		}
		//watch.startWatch(); 
		
	}
	
	public int countSpectators()
	{
		return spectatorCount; 
	}
	
	
	public void addSpectator(int randomNumberGenerated)
	{
		int randomNumber = (int) ((Math.random() * 6) + 1);
		
		if(randomNumber == randomNumberGenerated)
		{
			spectatorCount = spectatorCount + 1; 
			System.out.println("Spectator " + spectatorCount + " randomly generated."); 
		}
		
	}
	
	public boolean placeBets()
	{
		String isRightInput = statement.establishStatement(retrieveFirstTeamName, retrieveSecondTeamName);
		
		if(isRightInput == "")
		{
			return false; 
		}
		inputReceived = isRightInput; 
		return true; 
	}
	
	
	public Spectator[] sortedArray()
	{
		return null; 
	}
	
	public String[] sortTeamsAlphabetically(String[]firstTeam)
	{
		//Before Insertion Sort Algorithm 
		for(int i = 0; i < firstTeam.length; i++)
		{
			System.out.println("Player Element " + i + ": " + firstTeam[i]);
		}
		
		
		//Insertion Sort algorithm 
		//We are going to sort the two teams alphabetically in order. 
		//First Team: Cowan Shadowsteed, Miguel Pearlhunter, Travis Waterblood, Anthony Firestone
		
		for(int i = 1; i < firstTeam.length; i++)
		{
			String retrieveKey = firstTeam[i]; //Cowan Shadowsteed
			
			//Store the index i in variable j
			int j = i - 1;  //0
			
			//Compare the first Character to the second character
			while(j >= 0 && retrieveKey.compareTo(firstTeam[j]) < 0) 
			{
				firstTeam[j+1] = firstTeam[j]; 
				j = j - 1; 
			}
			firstTeam[j+1] = retrieveKey; 
		}
		return firstTeam; 
	}
	
	public String returnFirstLetter(String retrieveKey)
	{
		return retrieveKey.substring(0,1); 
	}
	
	public void beginMatch()
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Match between " + retrieveFirstTeamName + " and " + retrieveSecondTeamName + "has begun."); 
		System.out.println("We now spin a wheel to decide who starts first. We will do this "
				+ "the traditional way.");
		System.out.println("Heads or Tails Style."); 
		
		System.out.println("TEAM " + retrieveFirstTeamName + ": " + "Heads or Tails");
		String input1 = sc.nextLine(); 
		System.out.println("TEAM " + retrieveSecondTeamName + ": " + "Heads or Tails");
		String input2 = sc.nextLine(); 
		String inputAnswer = randomizeHeadsOrTails(); 
		if(inputAnswer.equals(input1))
		{
			System.out.println("TEAM " + retrieveFirstTeamName + " is starting first."); 
			String teamFirst = retrieveFirstTeamName; 
			String teamSecond = retrieveSecondTeamName; 
			startRound(teamFirst, teamSecond); 
			
		}
		else if(inputAnswer.equals(input2))
		{
			System.out.println("TEAM " + retrieveSecondTeamName + " is starting first."); 
			String teamFirst = retrieveSecondTeamName; 
			String teamSecond = retrieveFirstTeamName; 
			startRound(teamFirst, teamSecond); 
		}
	}
	
	public void startRound(String teamFirst, String teamSecond)
	{
		System.out.println("This is round 1 of our match between " + teamFirst + " and " + teamSecond); 
		
		for(int i = 0; i < firstTeamOrder.length; i++)
		{
			System.out.println("Player " + firstTeamOrder[i] + ": Choose your card. "); 
			System.out.println("You have 7 cards that have been generated."); 
		}
		
	}
	
	public String randomizeHeadsOrTails()
	{
		String[] inputs = {"Heads", "Tails"}; 
		
		int number = (int) ( (Math.random() * 2) + 1);
		
		return inputs[number]; 
	}
	
	
	public boolean validatePlayer(String playerName, int startIndex)
	{
		if(playerName instanceof String)
		{
			boolean check = false; 
			for(int i = 0; i < firstTeam.length; i++)
			{
				if(playerName.equals(firstTeam[i]))
				{
					firstTeam[startIndex] = ""; 
					check = true; 
					break;
				}
			}
			return true; 
		}
		return false; 
	}
	
	public String computePlayerInformation(String wizard, String school, int level)
	{
		String[] listGear = {"hat", "robe", "boot", "wand", "athame", "amulet", "ring", "deck", "pet"};  

		Hat hat = (Hat)instantiateGearPiece(listGear[0], school, level); 
		Robe robe = (Robe)instantiateGearPiece(listGear[1], school, level); 
		Boot boot = (Boot)instantiateGearPiece(listGear[2], school, level);
		Wand wand = (Wand)instantiateGearPiece(listGear[3], school, level); 
		Athame athame = (Athame)instantiateGearPiece(listGear[4], school, level);
		Amulet amulet = (Amulet)instantiateGearPiece(listGear[5], school, level); 
		Ring ring = (Ring)instantiateGearPiece(listGear[6], school, level); 
		Deck deck = (Deck)instantiateGearPiece(listGear[7], school, level); 
		Pet pet = (Pet)instantiateGearPiece(listGear[8], school, level); 

		Gear gear = new Gear(hat, robe, boot, wand, athame, amulet, ring, deck, pet); 

		System.out.println("The gear information for player "  + wizard + " is now completed."); 
		System.out.println(gear.toString()); 

		return gear.toString();  

	}

	public boolean verifyHealthRequirements(int health, int level)
	{
		return true; 
	}

	public void computeStatsInformation(HashMap<String, List<String>> gearSets)
	{
			//Open connection to database
			try 
			{
				Connection conn1 = null; 
				String url1 = "jdbc:mysql://localhost:3306/wizard_schema";
				String user = "srik6724";
				String password = "28892K0shair!";

				if (WizCredentials.authenticate(user, password)) {
					System.out.println("Authentication successful");
				} else {
					System.out.println("Authentication failed");
				}

				conn1 = DriverManager.getConnection(url1, user, password); 

				if(conn1 != null)
				{
					Hat hat = null; 
					Robe robe = null; 
					Boot boot = null; 
					Wand wand = null; 
					Athame athame = null; 
					Amulet amulet = null; 
					Ring ring = null; 
					Deck deck = null; 
					for(String wizard: gearSets.keySet())
					{
						int i = 0; 
						int schoolIndex = 3; 
						while(i < 8 && schoolIndex >= 0)
						{
							String[] listItems = {"hats", "robes", "boots", "wands", "athames", "amulets", "rings", "decks"};
							String gearItem = gearSets.get(wizard).get(i);
							System.out.println("Here are the stats for wizard: " + wizard); 
							System.out.println("GearItem: " + gearItem); 
							

							if(listItems[i].equals("hats"))
							{
								String sql = "SELECT health, power_pip, block, resist, accuracy, pierce, critical, damage, school, socket1, socket2, socket3 FROM wizard_schema.aeon_hats WHERE name = ?";								
								PreparedStatement stmt = conn1.prepareStatement(sql); 
								stmt.setString(1, gearItem); 
								ResultSet rs = stmt.executeQuery();
								while(rs.next())
								{
									int health = Integer.parseInt(rs.getString("health")); 
									int powerPip = Integer.parseInt(rs.getString("power_pip")); 
									int block = Integer.parseInt(rs.getString("block")); 
									int resist = Integer.parseInt(rs.getString("resist")); 
									int accuracy = Integer.parseInt(rs.getString("accuracy")); 
									int pierce = Integer.parseInt(rs.getString("pierce")); 
									int critical = Integer.parseInt(rs.getString("critical"));
									int damage = Integer.parseInt(rs.getString("damage")); 
									String school = rs.getString("school"); 
									String socket1 = rs.getString("socket1"); 
									String socket2 = rs.getString("socket2"); 
									String socket3 = rs.getString("socket3"); 

									Socket firstSocket = new Socket("", "shield", firstTeamSchools[schoolIndex], socket1); 
									Socket secondSocket = new Socket("", "sword", firstTeamSchools[schoolIndex], socket2); 
									Socket thirdSocket = new Socket("", "sword", firstTeamSchools[schoolIndex], socket3); 

									AeonHatStats.health = health; 
									AeonHatStats.power_pip = powerPip; 
									AeonHatStats.block = block; 
									AeonHatStats.resist = resist; 
									AeonHatStats.accuracy = accuracy; 
									AeonHatStats.pierce = pierce; 
									AeonHatStats.critical = critical; 
									AeonHatStats.damage = damage; 
									AeonHatStats.school = school; 
									AeonHatStats.socket1 = firstSocket; 
									AeonHatStats.socket2 = secondSocket; 
									AeonHatStats.socket3 = thirdSocket; 

									firstSocket = createSocketAttachment(firstSocket);
									AeonHatStats.socket1 = firstSocket;
									secondSocket = createSocketAttachment(secondSocket);
									AeonHatStats.socket2 = secondSocket;
									thirdSocket = createSocketAttachment(thirdSocket);
									AeonHatStats.socket3 = thirdSocket;

								}	
								hat = new Hat(gearItem); 
								hat.statsInformation();
							}
							if(listItems[i].equals("robes"))
							{
								String sql = "SELECT health, power_pip, block, resist, accuracy, pierce, critical, damage, school, socket1, socket2, socket3 FROM wizard_schema.aeon_robes WHERE name = ?";								
								PreparedStatement stmt = conn1.prepareStatement(sql); 
								stmt.setString(1, gearItem); 
								ResultSet rs = stmt.executeQuery();
								while(rs.next())
								{

									int health = Integer.parseInt(rs.getString("health")); 
									int powerPip = Integer.parseInt(rs.getString("power_pip")); 
									int block = Integer.parseInt(rs.getString("block")); 
									int resist = Integer.parseInt(rs.getString("resist")); 
									int accuracy = Integer.parseInt(rs.getString("accuracy")); 
									int pierce = Integer.parseInt(rs.getString("pierce")); 
									int critical = Integer.parseInt(rs.getString("critical")); 
									int damage = Integer.parseInt(rs.getString("damage")); 
									String school = rs.getString("school"); 
									String socket1 = rs.getString("socket1"); 
									String socket2 = rs.getString("socket2"); 
									String socket3 = rs.getString("socket3"); 

									Socket firstSocket = new Socket("", "sword", firstTeamSchools[schoolIndex], socket1); 
									Socket secondSocket = new Socket("", "power", firstTeamSchools[schoolIndex], socket2); 
									Socket thirdSocket = new Socket("", "sword", firstTeamSchools[schoolIndex], socket3); 

									AeonRobeStats.health = health; 
									AeonRobeStats.power_pip = powerPip; 
									AeonRobeStats.block = block; 
									AeonRobeStats.resist = resist; 
									AeonRobeStats.accuracy = accuracy; 
									AeonRobeStats.pierce = pierce; 
									AeonRobeStats.critical = critical;
									AeonRobeStats.damage = damage; 
									AeonRobeStats.school = school; 
									AeonRobeStats.socket1 = firstSocket; 
									AeonRobeStats.socket2 = secondSocket; 
									AeonRobeStats.socket3 = thirdSocket; 

									firstSocket = createSocketAttachment(firstSocket);
									AeonRobeStats.socket1 = firstSocket;
									secondSocket = createSocketAttachment(secondSocket);
									AeonRobeStats.socket2 = secondSocket;
									thirdSocket = createSocketAttachment(thirdSocket);
									AeonRobeStats.socket3 = thirdSocket;

								}
								robe = new Robe(gearItem); 
								robe.statsInformation();
							}	
							if(listItems[i].equals("boots"))
							{

								String sql = "SELECT health, power_pip, block, resist, accuracy, pierce, critical, damage, school, socket1, socket2, socket3 FROM wizard_schema.aeon_boots WHERE name = ?";								
								PreparedStatement stmt = conn1.prepareStatement(sql); 
								stmt.setString(1, gearItem); 
								ResultSet rs = stmt.executeQuery();
								while(rs.next())
								{

									int health = Integer.parseInt(rs.getString("health")); 
									int powerPip = Integer.parseInt(rs.getString("power_pip")); 
									int block = Integer.parseInt(rs.getString("block")); 
									int resist = Integer.parseInt(rs.getString("resist")); 
									int accuracy = Integer.parseInt(rs.getString("accuracy")); 
									int pierce = Integer.parseInt(rs.getString("pierce")); 
									int critical = Integer.parseInt(rs.getString("critical")); 
									int damage = Integer.parseInt(rs.getString("damage")); 
									String school = rs.getString("school"); 
									String socket1 = rs.getString("socket1"); 
									String socket2 = rs.getString("socket2"); 
									String socket3 = rs.getString("socket3"); 

									Socket firstSocket = new Socket("", "sword", firstTeamSchools[schoolIndex], socket1); 
									Socket secondSocket = new Socket("", "power", firstTeamSchools[schoolIndex], socket2); 
									Socket thirdSocket = new Socket("", "sword", firstTeamSchools[schoolIndex], socket3); 

									AeonBootsStats.health = health; 
									AeonBootsStats.power_pip = powerPip; 
									AeonBootsStats.block = block; 
									AeonBootsStats.resist = resist; 
									AeonBootsStats.accuracy = accuracy; 
									AeonBootsStats.pierce = pierce; 
									AeonBootsStats.critical = critical; 
									AeonBootsStats.damage = damage; 
									AeonBootsStats.school = school; 
									AeonBootsStats.socket1 = firstSocket; 
									AeonBootsStats.socket2 = secondSocket; 
									AeonBootsStats.socket3 = thirdSocket; 

									firstSocket = createSocketAttachment(firstSocket);
									AeonRobeStats.socket1 = firstSocket;
									secondSocket = createSocketAttachment(secondSocket);
									AeonRobeStats.socket2 = secondSocket;
									thirdSocket = createSocketAttachment(thirdSocket);
									AeonRobeStats.socket3 = thirdSocket;

								}
								boot = new Boot(gearItem); 
								boot.statsInformation();
							}	
							if(listItems[i].equals("wands"))
							{
								String sql = "SELECT block, pierce, critical, damage, pip_conversion, critical_school, school_damage1, school_damage2, pip_gain, school, socket1 FROM wizard_schema.aeon_wands WHERE name = ?";								
								PreparedStatement stmt = conn1.prepareStatement(sql); 
								stmt.setString(1, gearItem); 
								ResultSet rs = stmt.executeQuery();
								while(rs.next())
								{

									int block = Integer.parseInt(rs.getString("block")); 
									int pierce = Integer.parseInt(rs.getString("pierce")); 
									int critical = Integer.parseInt(rs.getString("critical")); 
									int damage = Integer.parseInt(rs.getString("damage")); 
									int pip_conversion = Integer.parseInt(rs.getString("pip_conversion")); 
									String critical_school = rs.getString("critical_school"); 
									String school_damage1 = rs.getString("school_damage1"); 
									String school_damage2 = rs.getString("school_damage2"); 
									String pip_gain = rs.getString("pip_gain"); 
									String school = rs.getString("school"); 
									String socket1 = rs.getString("socket1"); 

									Socket firstSocket = new Socket("", "square", firstTeamSchools[schoolIndex], socket1); 

									AeonWandStats.block = block; 
									AeonWandStats.pierce = pierce; 
									AeonWandStats.critical = critical; 
									AeonWandStats.damage = damage; 
									AeonWandStats.pip_conversion = pip_conversion; 
									AeonWandStats.critical_school = critical_school;
									AeonWandStats.school_damage1 = school_damage1; 
									AeonWandStats.school_damage2 = school_damage2; 
									AeonWandStats.pip_gain = pip_gain; 
									AeonWandStats.school = school;
									AeonWandStats.socket1 = firstSocket; 

									firstSocket = createSocketAttachment(firstSocket);
									AeonRobeStats.socket1 = firstSocket;

								}
								wand = new Wand(gearItem); 
								wand.statsInformation();
							}	
							if(listItems[i].equals("athames"))
							{
								String sql = "SELECT health, mana, power_pip, block, damage, school_damage1, school, socket1, socket2, socket3, socket4 FROM wizard_schema.aeon_athames WHERE name = ?";								
								PreparedStatement stmt = conn1.prepareStatement(sql); 
								stmt.setString(1, gearItem); 
								ResultSet rs = stmt.executeQuery();
								while(rs.next())
								{
									
									int health = Integer.parseInt(rs.getString("health")); 
									int mana = Integer.parseInt(rs.getString("mana")); 
									int power_pip = Integer.parseInt(rs.getString("power_pip")); 
									int block = Integer.parseInt(rs.getString("block")); 
									int damage = Integer.parseInt(rs.getString("damage")); 
									String school_damage1 = rs.getString("school_damage1"); 
									String school = rs.getString("school"); 
									String socket1 = rs.getString("socket1"); 
									String socket2 = rs.getString("socket2"); 
									String socket3 = rs.getString("socket3");
									String socket4 = rs.getString("socket4"); 

									Socket firstSocket = new Socket("", "tear", firstTeamSchools[schoolIndex], socket1); 
									Socket secondSocket = new Socket("", "circle", firstTeamSchools[schoolIndex], socket2); 
									Socket thirdSocket = new Socket("", "circle", firstTeamSchools[schoolIndex], socket3); 
									Socket fourthSocket = new Socket("", "triangle", firstTeamSchools[schoolIndex], socket4); 


									AeonAthameStats.health = health; 
									AeonAthameStats.mana = mana; 
									AeonAthameStats.power_pip = power_pip; 
									AeonAthameStats.block = block; 
									AeonAthameStats.damage = damage; 
									AeonAthameStats.school_damage1 = school_damage1; 
									AeonAthameStats.school = school; 
									AeonAthameStats.socket1 = firstSocket; 
									AeonAthameStats.socket2 = secondSocket; 
									AeonAthameStats.socket3 = thirdSocket; 
									AeonAthameStats.socket4 = fourthSocket; 

									firstSocket = createSocketAttachment(firstSocket);
									AeonAthameStats.socket1 = firstSocket;
									secondSocket = createSocketAttachment(secondSocket);
									AeonAthameStats.socket2 = secondSocket;
									thirdSocket = createSocketAttachment(thirdSocket);
									AeonAthameStats.socket3 = thirdSocket;
									fourthSocket = createSocketAttachment(fourthSocket);
									AeonAthameStats.socket4 = fourthSocket;

								}
								athame = new Athame(gearItem); 
								athame.statsInformation();

							}	
							if(listItems[i].equals("amulets"))
							{
								String sql = "SELECT block, resist, pip_conversion, health, socket1, socket2, school FROM wizard_schema.aeon_amulets WHERE name = ?";								
								PreparedStatement stmt = conn1.prepareStatement(sql); 
								stmt.setString(1, gearItem); 
								ResultSet rs = stmt.executeQuery();
								while(rs.next())
								{

									int block = Integer.parseInt(rs.getString("block")); 
									int resist = Integer.parseInt(rs.getString("resist"));
									int pip_conversion = Integer.parseInt(rs.getString("pip_conversion"));
									int health = Integer.parseInt(rs.getString("health")); 
									String school = rs.getString("school"); 
									String socket1 = rs.getString("socket1"); 
									String socket2 = rs.getString("socket2"); 

									Socket firstSocket = new Socket("", "square", firstTeamSchools[schoolIndex], socket1); 
									Socket secondSocket = new Socket("", "square", firstTeamSchools[schoolIndex], socket2); 

									AeonAmuletStats.block = block; 
									AeonAmuletStats.resist = resist; 
									AeonAmuletStats.pip_conversion = pip_conversion; 
									AeonAmuletStats.health = health; 
									AeonAmuletStats.school = school; 
									AeonAmuletStats.socket1 = firstSocket; 
									AeonAmuletStats.socket2 = secondSocket; 

									firstSocket = createSocketAttachment(firstSocket);
									AeonAmuletStats.socket1 = firstSocket;
									secondSocket = createSocketAttachment(secondSocket);
									AeonAmuletStats.socket2 = secondSocket;
								}
								amulet = new Amulet(gearItem); 
								amulet.statsInformation();
							}	
							if(listItems[i].equals("rings"))
							{
								String sql = "SELECT health, mana, power_pip, critical, damage, school_damage1, school, socket1, socket2, socket3 FROM wizard_schema.aeon_rings WHERE name = ?";								
								PreparedStatement stmt = conn1.prepareStatement(sql); 
								stmt.setString(1, gearItem); 
								ResultSet rs = stmt.executeQuery();
								while(rs.next())
								{

									int health = Integer.parseInt(rs.getString("health")); 
									int mana = Integer.parseInt(rs.getString("mana")); 
									int power_pip = Integer.parseInt(rs.getString("power_pip")); 
									int critical = Integer.parseInt(rs.getString("critical"));
									int damage = Integer.parseInt(rs.getString("damage")); 
									String school_damage1 = rs.getString("school_damage1"); 
									String school = rs.getString("school"); 
									String socket1 = rs.getString("socket1"); 
									String socket2 = rs.getString("socket2"); 
									String socket3 = rs.getString("socket3");

									Socket firstSocket = new Socket("", "tear", firstTeamSchools[schoolIndex], socket1); 
									Socket secondSocket = new Socket("", "circle", firstTeamSchools[schoolIndex], socket2); 
									Socket thirdSocket = new Socket("", "square", firstTeamSchools[schoolIndex], socket3); 


									AeonRingStats.health = health; 
									AeonRingStats.mana = mana; 
									AeonRingStats.power_pip = power_pip; 
									AeonRingStats.critical = critical; 
									AeonRingStats.damage = damage; 
									AeonRingStats.school_damage1 = school_damage1; 
									AeonRingStats.school = school; 
									AeonRingStats.socket1 = firstSocket; 
									AeonRingStats.socket2 = secondSocket; 
									AeonRingStats.socket3 = thirdSocket; 

									firstSocket = createSocketAttachment(firstSocket);
									AeonRingStats.socket1 = firstSocket;
									secondSocket = createSocketAttachment(secondSocket);
									AeonRingStats.socket2 = secondSocket;
									thirdSocket = createSocketAttachment(thirdSocket);
									AeonRingStats.socket3 = thirdSocket;

								}
								ring = new Ring(gearItem); 
								ring.statsInformation();
							}	
							if(listItems[i].equals("decks"))
							{
								String sql = "SELECT max_spells, max_copies, max_schoolcopies, sideboard, health, block, critical, school, pip_gain, archmastery_rating, socket1 FROM wizard_schema.aeon_decks WHERE name = ?";								
								PreparedStatement stmt = conn1.prepareStatement(sql); 
								stmt.setString(1, gearItem); 
								ResultSet rs = stmt.executeQuery();
								while(rs.next())
								{

									int max_spells = Integer.parseInt(rs.getString("max_spells")); 
									int max_copies = Integer.parseInt(rs.getString("max_copies")); 
									int max_schoolCopies = Integer.parseInt(rs.getString("max_schoolcopies")); 
									int sideboard = Integer.parseInt(rs.getString("sideboard")); 
									int health = Integer.parseInt(rs.getString("health")); 
									int block = Integer.parseInt(rs.getString("block")); 
									int critical = Integer.parseInt(rs.getString("critical")); 
									String school = rs.getString("school");
									String pip_gain = rs.getString("pip_gain"); 
									int archmasteryRating = Integer.parseInt(rs.getString("archmastery_rating"));
									String socket1 = rs.getString("socket1");

									Socket firstSocket = new Socket("", "tear", firstTeamSchools[schoolIndex], socket1); 

									AeonDeckStats.max_spells = max_spells;
									AeonDeckStats.max_copies = max_copies; 
									AeonDeckStats.max_schoolCopies = max_schoolCopies;
									AeonDeckStats.sideboard = sideboard; 
									AeonDeckStats.health = health; 
									AeonDeckStats.block = block;
									AeonDeckStats.critical = critical; 
									AeonDeckStats.school = school; 
									AeonDeckStats.pip_gain = pip_gain; 
									AeonDeckStats.archmastery_rating = archmasteryRating;
									AeonDeckStats.socket1 = firstSocket; 

									firstSocket = createSocketAttachment(firstSocket);
									AeonDeckStats.socket1 = firstSocket;


								}
								deck = new Deck(gearItem); 
								deck.statsInformation();
							}
							i = i + 1; 
							schoolIndex = schoolIndex - 1; 
						}
					}		
					Gear gear = new Gear(hat, robe, boot, wand, athame, amulet, ring, deck, null);
					gear.calculateFinalStats();
				}
			}catch(SQLException e)
			{
				System.out.println("Sorry, an exception occurred."); 
			}
		}

	private Socket createSocketAttachment(Socket socket) {

		if(socket.getDescription().equals("unused"))
		{
			try {
				Connection conn1 = null; 
				String url1 = "jdbc:mysql://localhost:3306/wizard_schema";
				String user = "srik6724";
				String password = "28892K0shair!";

				if (WizCredentials.authenticate(user, password)) {
					System.out.println("Authentication successful");
				} else {
					System.out.println("Authentication failed");
				}
	
				conn1 = DriverManager.getConnection(url1, user, password); 

				if(conn1 != null)
				{
					Scanner sc = new Scanner(System.in); 

					String firstInput; 
					String addAttachment; 
					System.out.println("Would you like to add socket attachments to your gear?"); 
					System.out.println("Keep in mind, you can only add sockets of type: " + socket.getType()); 
					System.out.println("You will have to use the exact name for the time being. So, please make sure to spell it correctly.");
					firstInput = sc.nextLine(); 
					if(firstInput.equals("NO"))
					{
						if(!(sc.hasNextLine()))
						{
							sc.close();
						}
						return socket;
					}
					else 
					{
						boolean cont = true; 
						String nameOfSocket = ""; 
						String school = ""; 
						String description = ""; 
						while(cont && firstInput.equals("YES"))
						{
							System.out.println("Choose a socket of type " + socket.getType()); 
							addAttachment = sc.nextLine(); 
							if(!(sc.hasNextLine()))
							{
								sc.close();
							}
							Statement statement = conn1.createStatement();
							String sqlString = "SELECT * FROM wizard_schema." + socket.getType() + "_sockets";
							ResultSet rs = statement.executeQuery(sqlString); 
							while(rs.next())
							{
								nameOfSocket = rs.getString("name"); 
								school = rs.getString("school");
								description = rs.getString("description"); 
								if(nameOfSocket.toLowerCase().equals(addAttachment.toLowerCase()) && socket.getSchool().toLowerCase().equals(school.toLowerCase()))
								{
									cont = false;
									break; 
								}
							}
							if(!(nameOfSocket.equals(addAttachment)))
							{
								System.out.println("Name of socket in database: " + nameOfSocket + " does not match " + addAttachment);
								System.out.println("Try again."); 
								cont = true; 
							}
							else 
							{
								System.out.println("Name of socket in database: " + nameOfSocket + " matches " + addAttachment); 
								if(!(socket.getSchool().toLowerCase().equals(school)))
								{
									System.out.println("Name of socket school in database: " + school + " does not match " + socket.getSchool());
									System.out.println("Try again."); 
									cont = true; 
								}
								else 
								{
									System.out.println("Name of socket school in database: " + school + " matches " + socket.getSchool()); 
								}
							}
						}
						socket.setDescription(description);
						socket = new Socket(nameOfSocket, socket.getType(), socket.getSchool(), socket.getDescription()); 
						System.out.println("Socket of type " + socket.getType() + " of school " + socket.getSchool() + " and of description " + socket.getDescription() + " added."); 
						return socket;
					}
				}
				return null;
			}
			catch(SQLException e)
			{
				System.out.println("An exception occurred here."); 
				return null;
			}
		}
		else 
		{
			return socket;
		}

	}


	public String cutPartOfString(String str, String gearString)
	{
		int index = 0; 
		String createNewString = ""; 
		for(int i = 0; i < gearString.length(); i++)
		{
			if(index < str.length())
			{
				if(gearString.substring(i, i+1).equals(str.substring(index, index+1)))
				{
					createNewString += ""; 
				}
				index = index + 1; 
			}
			else 
			{
				createNewString += gearString.substring(i, i+1); 
			}
		}
		return createNewString; 
	}

	public Object instantiateGearPiece(String gearName, String school, int level)
	{
		String hatName; 
		String robeName; 
		String bootName; 
		String wandName;
		String athameName; 
		String amuletName; 
		String ringName; 
		String deckName; 
		String petName; 


		Scanner sc = new Scanner(System.in); 
	
		System.out.println("Please try to space out each word to ensure name of gear inputted can be fixed if written incorrectly."); 
		System.out.println("If you happen to fail to follow these instructions, you will be redirected back to the same page."); 
		System.out.println("Thank you for this understanding."); 
		System.out.println("Enter the name of your " + gearName); 
		
		switch(gearName) 
		{
			case "hat": 
				hatName = sc.nextLine();
				if(!(sc.hasNextLine()))
				{
						sc.close();
				}
				boolean res1 = checkGearName(hatName, gearName, school, level); 
				if(res1 == true)
				{
					Hat hat = new Hat(hatName); 
					System.out.println("Hat: " + hatName + " created."); 
					return hat; 
				}
				Hat hat = (Hat)instantiateGearPiece(gearName, school, level);
				return hat;
			case "robe": 
				robeName = sc.nextLine();
				if(!(sc.hasNextLine()))
				{
					sc.close();
				}
				boolean res2 = checkGearName(robeName, gearName, school, level); 
				if(res2 == true)
				{
					Robe robe = new Robe(robeName); 
					System.out.println("Robe: " + robeName + " created."); 
					return robe;
				}
				Robe robe = (Robe)instantiateGearPiece(gearName, school, level);
				return robe;
			case "boot": 
				bootName = sc.nextLine();
				if(!(sc.hasNextLine()))
				{
					sc.close();
				}
				boolean res3 = checkGearName(bootName, gearName, school, level); 
				if(res3 == true)
				{
					Boot boot = new Boot(bootName); 
					System.out.println("Boot: " + bootName + " created."); 
					return boot;
				}
				Boot boot = (Boot)instantiateGearPiece(gearName, school, level);
				return boot;
			case "wand": 
				wandName = sc.nextLine();
				if(!(sc.hasNextLine()))
				{
					sc.close();
				}
				boolean res4 = checkGearName(wandName, gearName, school, level); 
				if(res4 == true)
				{
					Wand wand = new Wand(wandName); 
					System.out.println("Boot: " + wandName + " created."); 
					return wand;
				}
				Wand wand = (Wand)instantiateGearPiece(gearName, school, level);
				return wand;
			case "athame": 
				athameName = sc.nextLine();
				if(!(sc.hasNextLine()))
				{
					sc.close();
				}
				boolean res5 = checkGearName(athameName, gearName, school, level); 
				if(res5 == true)
				{
					Athame athame = new Athame(athameName); 
					System.out.println("Athame: " + athameName + " created."); 
					return athame;
				}
				Athame athame = (Athame)instantiateGearPiece(gearName, school, level);
				return athame;
			case "amulet": 
				amuletName = sc.nextLine();
				if(!(sc.hasNextLine()))
				{
					sc.close();
				}
				boolean res6 = checkGearName(amuletName, gearName, school, level); 
				if(res6 == true)
				{
					Amulet amulet = new Amulet(amuletName); 
					System.out.println("Amulet: " + amuletName + " created.");
					return amulet;
				}
				Amulet amulet = (Amulet)instantiateGearPiece(gearName, school, level);
				return amulet;
			case "ring": 
				ringName = sc.nextLine();
				if(!(sc.hasNextLine()))
				{
					sc.close(); 
				}
				boolean res7 = checkGearName(ringName, gearName, school, level); 
				if(res7 == true)
				{
					Ring ring = new Ring(ringName); 
					System.out.println("Ring: " + ringName + " created.");
					return ring;
				}
				Ring ring = (Ring)instantiateGearPiece(gearName, school, level);
				return ring;
			case "deck": 
				deckName = sc.nextLine(); 
				if(!(sc.hasNextLine()))
				{
					sc.close();
				}
				boolean res8 = checkGearName(deckName, gearName, school, level);
				if(res8 == true)
				{
					Deck deck = new Deck(deckName); 
					System.out.println("Deck: " + deckName + " created."); 
					return deck;
				}
				Deck deck = (Deck)instantiateGearPiece(gearName, school, level);
				return deck;
			case "pet": 
				petName = sc.nextLine(); 
				if(!(sc.hasNextLine()))
				{
					sc.close(); 
				}
				boolean res9 = checkGearName(petName, gearName, school, level); 
				if(res9 == true)
				{
					Pet pet = new Pet(petName); 
					System.out.println("Pet: " + petName + " created."); 
					sc.close(); 
					return pet; 
				}
				Pet pet = (Pet)instantiateGearPiece(gearName, school, level); 
				return pet; 
		}
		sc.close();
		TypeException ex = new TypeException();
		ex.message(gearName); 
		return null;
	}

	public boolean checkGearName(String gearName, String pieceOfGear, String school, int level)
	{
		//Open connection to database 
		try {
			Connection conn1 = null; 
			String url1 = "jdbc:mysql://localhost:3306/wizard_schema";
			String user = "srik6724";
			String password = "28892K0shair!";

			if (WizCredentials.authenticate(user, password)) {
				System.out.println("Authentication successful");
			} else {
				System.out.println("Authentication failed");
			}

			conn1 = DriverManager.getConnection(url1, user, password); 

			if(conn1 != null)
			{
				if(gearName.equals("pet"))
				{
					//Create a sql string
					String sqlToExecute = "SELECT typeName, school, description FROM wizard_schema.pets";
					//Execute the sql string above, but create a statement first.
					Statement createStatement = conn1.createStatement(); 
					//Store the result inside a result set to access the database column's data
					ResultSet rs = createStatement.executeQuery(sqlToExecute); 

					boolean iterate = false; 
					while(rs.next())
					{
						//Retrieve the typename of the pet
						String typeName = rs.getString("typeName"); 
						Pet.typeName = typeName; 

						//Retrieve the school of the pet 
						String schoolOfPet = rs.getString("school"); 
						Pet.school = schoolOfPet; 

						iterate = true; 
					}
					conn1.close(); 
					if(iterate == false)
					{
						System.out.println("Pet Type: " + Pet.typeName + " does not exist inside database.");
					}
					return iterate; 
				}
				else 
				{
					CallableStatement stmt = (CallableStatement) conn1.prepareCall("{call extractgear(?,?,?,?)}"); 
			 		stmt.setString(1, school); 
					stmt.setString(2, pieceOfGear);
					stmt.setString(3, String.valueOf(level)); 
					stmt.registerOutParameter(4, Types.VARCHAR); 

					stmt.execute(); 
				
					String databaseGearName = stmt.getString(4); 

			 		if(gearName.equals(databaseGearName))
					{
						conn1.close(); 
						return true; 
					}
					System.out.println("Gear Name entered " + gearName + " does not match " + "database gearName " + databaseGearName + "of given school " + school); 
					conn1.close(); 
					return false; 
				}
			}
			return false; 
		}
		catch(SQLException e)
		{
			System.out.println("Invalid username/password"); 
			return false;
		}
	}

	public boolean searchInGearSets(HashMap<String, List<String>> gearSets, String person)
	{
		boolean var = false;
		for(String wizard: gearSets.keySet())
		{
			if(wizard.equals(person))
			{
				var = true; 
				break;
			}
			else 
			{
				var = false; 
			}
		}
		return var; 
	}

	

}
