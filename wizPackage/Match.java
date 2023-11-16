package wizPackage;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import Credentials.WizCredentials;

import AeonStats.AeonAmuletStats;
import AeonStats.AeonAthameStats;
import AeonStats.AeonBootsStats;
import AeonStats.AeonClass;
import AeonStats.AeonDeckStats;
import AeonStats.AeonHatStats;
import AeonStats.AeonRingStats;
import AeonStats.AeonRobeStats;
import AeonStats.AeonWandStats;
import CustomExceptions.TypeException;
import DragoonStats.DragoonClass;
import EternalStats.EternalClass;
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
import JadeStats.JadeClass;
import NightMireStats.NightMireClass;
import wizPackage.LinkedListTeam1.Node;
import wiz_threading.Team1Runnable;
import wiz_threading.Team1vsTeam2;
import wiz_threading.Team2Runnable;
import PlayerStats.Player;
import SchoolSpells.Spell;
import SchoolSpells.schoolSpells;
import Sockets.Socket;
import SpookyStats.SpookyClass;
import SpringBoot.SpringBootExecutable;
public class Match implements MooshuArena, DragonSpyreArena, GrizzleheimArena, HeapArena, Arena, AvalonArena {
	
	//Arrays to store information about the firstTeam and secondTeam. 
	int teamSize; 
	private String[] team; 
	private String[] teamLevels; 
	private String[] teamSchools; 

	
	private StopWatch watch = new StopWatch(); 
	public Proposition statement = new Proposition(); 
	public String inputReceived = null; 
	
	private static ArrayList<Spectator> spectators; 
	
	private String[] wizSchools = {"Balance", "Death", "Storm", "Myth", "Ice", "Fire", "Life"}; 
	
	private String[] firstTeamOrder = new String[4]; 
	private String[] secondTeamOrder = {}; 
	
	public static HashMap<String, List<Spell>> decks = new HashMap<String, List<Spell>>(); 

	//Declare a Spell list that contains BalanceSpells, FireSpells, LifeSpells, IceSpells, Deathspells, MythSpells, and StormSpells
	//private ArrayList<Spells> spells; 
	
	int startCountDown; 
	
	public static int spectatorCount = 0; 
	public static int countDownNumber = 10; 
	
	public String retrieveFirstTeamName; 
	public String retrieveSecondTeamName; 

	public char[] randomVariable;

	private static int countTeamsRegistered = 1; 
	private static int firstIteration = 1; 
	
	public void enroll2Teams() throws InterruptedException
	{
		String[] teamStr = {"First", "Second"};  
		for(int i = 0; i < 2; i++)
		{
			enrollTeamPlayers(teamStr[i], firstIteration, countTeamsRegistered);
		}
		System.out.println(retrieveFirstTeamName + " will be competing against " + retrieveSecondTeamName); 
		randomizeArenaSelection(); 
		matchCountDown(retrieveFirstTeamName, retrieveSecondTeamName); 
		//fillDecks(); 
		beginMatch();
	}
	
	
	public void enrollTeamPlayers(String str, int firstIteration, int countTeamsRegistered) throws InterruptedException
	{
		Scanner sc = new Scanner(System.in);

		boolean iterate = true; 

		while(iterate)
		{
			System.out.println("Select the game mode you intend to play."); 
			Thread.sleep(1000); 
			System.out.println("--------------OPTIONS-------------------"); 
			Thread.sleep(1000); 
			System.out.println("----------------1v1---------------------"); 
			Thread.sleep(1000); 
			System.out.println("----------------2v2---------------------");
			Thread.sleep(1000); 
			System.out.println("----------------3v3----------------------"); 
			Thread.sleep(1000); 
			System.out.println("----------------4v4----------------------");
			Thread.sleep(1000);  
			System.out.println("Choose which one to play based on those options."); 
			String gameMode = sc.nextLine(); 
			if(isNumeric(gameMode))
			{
				System.out.println("Not a valid input entered for game mode: " + gameMode); 
				iterate = true; 
				continue; 
			}
			if(!((gameMode.equals("1v1") || gameMode.equals("2v2") || gameMode.equals("3v3") || gameMode.equals("4v4"))))
			{
				System.out.println("Game Mode: " + gameMode + " doesn't exist."); 
				iterate = true; 
				continue; 
			}
			System.out.println("Game Mode selection chosen is " + gameMode); 
			if(gameMode.equals("1v1"))
			{
				teamSize = _1v1_.teamSize(); 
				team = new String[teamSize]; 
				teamLevels = new String[teamSize]; 
				teamSchools = new String[teamSize]; 
			}
			else if(gameMode.equals("2v2"))
			{
				teamSize = _2v2_.teamSize(); 
				team = new String[teamSize]; 
				teamLevels = new String[teamSize]; 
				teamSchools = new String[teamSize]; 
			}
			else if(gameMode.equals("3v3"))
			{
				teamSize = _3v3_.teamSize(); 
				team = new String[teamSize]; 
				teamLevels = new String[teamSize]; 
				teamSchools = new String[teamSize];
			}
			else if(gameMode.equals("4v4"))
			{
				teamSize = _4v4_.teamSize(); 
				team = new String[teamSize]; 
				teamLevels = new String[teamSize]; 
				teamSchools = new String[teamSize]; 
			}
			break; 
		}

		System.out.println(str + " Team");
		System.out.println("-------------------"); 
		System.out.println("What is the name of your team?"); 
		
		retrieveFirstTeamName = sc.nextLine(); 		
		
		boolean checkPlayerNames = true; 
		
		System.out.println("INSTRUCTIONS FOR REGISTERING A TEAM. Follow carefully."); 
		System.out.println("First, please write down the names of your players."
				+ "After this step is completed, write down the corresponding levels of each player." + "Then proceed"
						+ "to write down the school identities of every player."); 
		System.out.println("We humbly request it is done in this order as we would hope to avoid any technical "
				+ "issues on our end for registering all teams. Thank you! "); 
		
		while(checkPlayerNames)
		{
			for(int i = 0; i < teamSize; i++)
			{
				System.out.println("Please write down player " + (i+1) + " of your team."); 
				String player = sc.nextLine(); 
				if(isNumeric(player))
				{
					System.out.println("Not a valid name for " + player); 
					checkPlayerNames = true; 
					break;
				}
				else
				{
					team[i] = player; 
				}
			}
			checkPlayerNames = false; 
		}

		boolean checkPlayerLevels = true; 
		while(checkPlayerLevels)
		{
			for(int i = 0; i < teamSize; i++)
			{
				System.out.println("Write down " + team[i] + " level."); 
				String playerLevel = sc.nextLine(); 
				if(!(isNumeric(playerLevel)))
				{
					System.out.println("Level " + playerLevel + " not recognizable."); 
					checkPlayerLevels = true; 
					break;
				}
				else if(Integer.parseInt(playerLevel) > 160)
				{
					System.out.println("Player Level Chosen " + playerLevel + " exceeds 160"); 
				}
				else {
					teamLevels[i] = playerLevel; 
					System.out.println("Added " + teamLevels[i] + " level of " + "player " + team[i]); 
					checkPlayerLevels = false;
				}
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
			
			boolean checkIdentities = true; 
			while(checkIdentities)
			{
				for(int i = 0; i < teamSize; i++)
				{
					System.out.println("Write down " + team[i] + " school"); 
					String playerSchool = sc.nextLine(); 
					if(isNumeric(playerSchool))
					{
						System.out.println("Player School " + playerSchool + " cannot be a number."); 
						checkIdentities = true; 
						break;
					}
					else if((playerSchool.equals("Ice")) || (playerSchool.equals("Fire")) || (playerSchool.equals("Death"))
					|| (playerSchool.equals("Balance")) || (playerSchool.equals("Life")) || (playerSchool.equals("Myth")) 
					|| (playerSchool.equals("Storm")))
					{
						System.out.println("Player School added of type " + playerSchool); 
						teamSchools[i] = playerSchool; 
						checkIdentities = false; 
					}
					else 
					{
						checkIdentities = true;
						break;
					}
				}
			}
		System.out.println();
		System.out.println(); 
		System.out.println(); 
		System.out.println(); 
		System.out.println("You are now clear to now create a deck for each player on your team."); 
		
		for(int i = 0; i < teamSize; i++)
		{
			createDeck(teamSchools[i], (i+1)); 
		}

		System.out.println("The decks are now created for all schools specified.");
		System.out.println(); 
		System.out.println(); 

		System.out.println("The files are created for all decks specified."); 

		System.out.println();
		System.out.println(); 
		System.out.println(); 
		System.out.println(); 
		System.out.println("The next step will involve player stats to be recorded of every individual."); 
		System.out.println("This is expected to take around 10-15 minutes in total, so please be patient."); 

		int iter = 4; 
		HashMap<String, List<String>> gearSets = new HashMap<String, List<String>>(); 
		int place = 0; 
		firstIteration = 1; 
		String saveDuplicateKey = ""; 
		LinkedListTeam1 list1 = new LinkedListTeam1(); 
		LinkedListTeam2 list2 = new LinkedListTeam2(); 
		HashMap<Integer, List<String>> keywords = new HashMap<Integer, List<String>>(); 
		for(int i = 0; i < team.length; i++)
		{
			System.out.println(teamSchools[i]); 
			String fullGearString = computePlayerInformation(team[i], teamSchools[i], Integer.parseInt(teamLevels[i]), keywords, iter);
			iter--; 
			ArrayList<String> storeGearPieces = new ArrayList<String>(); 
			String gearToAdd = ""; 
			int start = 1; 
			while(start <= 9)
			{
				for(int j = place; j < fullGearString.indexOf(',', 1); j++)
				{
					gearToAdd += fullGearString.substring(j, j+1); 
				}

				if(start == 9)
				{
					for(int x = 0; x < fullGearString.length(); x++)
					{
						gearToAdd += fullGearString.substring(x, x+1); 
					}
				}		
				System.out.println(gearToAdd); 
				storeGearPieces.add(gearToAdd); 
				if(start < 9)
				{
					gearToAdd += ","; 
				}
				fullGearString = cutPartOfString(gearToAdd, fullGearString); 
				gearToAdd = ""; 
				start = start + 1; 
			}
			System.out.println(team[i]); 
			boolean checkIfExists = searchInGearSets(gearSets, team[i]); 
			if(checkIfExists == true)
			{
				if(firstIteration == 1)
				{
					saveDuplicateKey = team[i]; 
					List<String> gearItems = retrieveDuplicateKeyInfo(gearSets, team[i]);
					LinkedListTeam1.Node node = new LinkedListTeam1.Node(team[i], gearItems); 
					list1.insert(node); 
					LinkedListTeam1.Node anotherNode = new LinkedListTeam1.Node(team[i], storeGearPieces); 
					list1.insert(anotherNode); 
					firstIteration = 0; 
				}
				else 
				{
					if(countTeamsRegistered == 1)
					{
						LinkedListTeam1.Node node = new LinkedListTeam1.Node(team[i], storeGearPieces); 
						list1.insert(node); 
					}
					else 
					{
						LinkedListTeam2.Node node = new LinkedListTeam2.Node(team[i], storeGearPieces); 
						list2.insert(node); 
					}
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
				gearSets.put(team[i], storeGearPieces);
			}
		}
		LinkedListTeam1.Node current1;
		LinkedListTeam2.Node current2;
		if(countTeamsRegistered == 1)
		{
			list1.printNodeData();
			current1 = LinkedListTeam1.head; 
			int count = 1; 
			String modified_wizardName = ""; 
			while(current1.next != null)
			{
				modified_wizardName = current1.wizard + " " + count; 
				gearSets.put(modified_wizardName, current1.data); 
				current1 = current1.next; 
				count = count + 1; 
			}
			modified_wizardName = current1.wizard + " " + count;
			gearSets.put(modified_wizardName, current1.data); 
			gearSets.remove(saveDuplicateKey); 
		}
		else
		{
			list2.printNodeData();
			current2 = LinkedListTeam2.head; 
			int count = 1; 
			String modified_wizardName = ""; 
			while(current2.next != null)
			{
				modified_wizardName = current2.wizard + " " + count; 
				gearSets.put(modified_wizardName, current2.data); 
				current2 = current2.next; 
				count = count + 1; 
			}
			modified_wizardName = current2.wizard + " " + count;
			gearSets.put(modified_wizardName, current2.data); 
		}
		
		for(String wizard: gearSets.keySet())
		{
			System.out.println(wizard); 
			System.out.println(gearSets.get(wizard).get(0)); 
			System.out.println(gearSets.get(wizard).get(1)); 
			System.out.println(gearSets.get(wizard).get(2)); 
			System.out.println(gearSets.get(wizard).get(3)); 
			System.out.println(gearSets.get(wizard).get(4)); 
			System.out.println(gearSets.get(wizard).get(5)); 
			System.out.println(gearSets.get(wizard).get(6)); 
			System.out.println(gearSets.get(wizard).get(7)); 
		}
		System.out.println("Computing stats information now."); 
		for(int number: keywords.keySet())
		{
			System.out.println(keywords.get(number).get(0)); 
			System.out.println(keywords.get(number).get(1)); 
			System.out.println(keywords.get(number).get(2)); 
			System.out.println(keywords.get(number).get(3)); 
			System.out.println(keywords.get(number).get(4)); 
			System.out.println(keywords.get(number).get(5)); 
			System.out.println(keywords.get(number).get(6)); 
			System.out.println(keywords.get(number).get(7)); 
		}
		computeStatsInformation(gearSets, keywords);
		
		
		
		System.out.println("Now, for the final step of registration, enter the order your team "
				+ "would like to be placed in during the match."); 
		
		System.out.println("Just quickly before that, here is a list of potential orders, you may be interested in " + 
		"ordering your team."); 

		HashMap<Integer, List<String>> orderDetail = new HashMap<Integer, List<String>>(); 

		int left = 0; 
		int right = 0; 
		int length = teamSchools.length; 
		int firstLoopIteration = 1; 
		String[]orderCreated = new String[4]; 

		generatePossibleOrders(left, right, length, firstLoopIteration, orderCreated, Arrays.asList(teamSchools), orderDetail);
		int setCount = 1; 
		for(int number: orderDetail.keySet())
		{
			System.out.println("Order "  + setCount +  ": " + orderDetail.get(number)); 
			setCount++; 
		}

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
			System.out.println("Player # " + start + ": " + firstTeamOrder[i] + "," + teamLevels[i] + "," + teamSchools[i] +  " successfully enrolled in " + retrieveFirstTeamName); 
			start = start + 1; 
		}
		System.out.println("Congratulations, team " + retrieveFirstTeamName + " is enrolled officially.");
		countTeamsRegistered++; 
		
	}
	
	private void generatePossibleOrders(int left, int right, int length, int firstIteration, String[]orderCreated, List<String> firstTeamSchools, HashMap<Integer, List<String>> orderDetail) {

		//Implement a backtracking algorithm that generates all the possible combinations of orders that one can look at.
		//Use hashmap to store the information of each order. 
		//Make sure to terminate the base case if there are duplicates and no other potential combinations can be created. 
		//Use a randomization metric from 0-3 to decide which two elements to swap

		if(firstIteration == 1)
		{
			orderCreated = firstTeamSchools.toArray(orderCreated); 
			firstIteration = 0; 
		}

		if(orderDetail.size() == 0)
		{
			System.out.println(orderCreated[0]); 
			System.out.println(orderCreated[1]); 
			System.out.println(orderCreated[2]); 
			System.out.println(orderCreated[3]); 
			orderDetail.put(left+1, Arrays.asList(orderCreated)); 
		}
		else 
		{
			orderDetail.put(left+1, Arrays.asList(orderCreated));
		}
		
		/*if(searchForDuplicates(orderCreated, orderDetail) == true && firstIteration == 0)
			{
				return; 
			}*/

		if(left < length)
		{
			int firstRandomNumber = (int)(Math.random() * 3) + 1; 
			int secondRandomNumber = (int)(Math.random() * 3) + 1; 

			String temp = orderCreated[firstRandomNumber]; 
			orderCreated[firstRandomNumber] = orderCreated[secondRandomNumber];
			orderCreated[secondRandomNumber] = temp; 

			generatePossibleOrders(left+1, right, length, firstIteration, Arrays.copyOf(orderCreated, orderCreated.length), Arrays.asList(orderCreated), orderDetail);
		}

		if(right < length)
		{
			int firstRandomNumber = (int)(Math.random() * 3) + 1; 
			int secondRandomNumber = (int)(Math.random() * 3) + 1; 

			String temp = orderCreated[firstRandomNumber]; 
			orderCreated[firstRandomNumber] = orderCreated[secondRandomNumber]; 
			orderCreated[secondRandomNumber] = temp; 
		
			generatePossibleOrders(left, right+1, length, firstIteration, Arrays.copyOf(orderCreated, orderCreated.length), Arrays.asList(orderCreated), orderDetail);

		}
		
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

	private HashMap<String, List<Spell>> createDeck(String str, int deckNo) {
		
		new schoolSpells(str); 
		
		switch(str.toLowerCase()) {
		
		case "balance": 
			decks.put("balance", schoolSpells.allSchoolSpells.get(schoolSpells.balanceIndex)); 
			System.out.println("Success, balance deck is in!"); 
			break;
		
		case "fire": 
			decks.put("fire", schoolSpells.allSchoolSpells.get(schoolSpells.fireIndex));
			System.out.println("Success, fire deck is in!"); 
			break;
			
		case "ice": 
			decks.put("ice", schoolSpells.allSchoolSpells.get(schoolSpells.stormIndex));
			System.out.println("Success, ice deck is in!"); 
			break;
		
		case "life": 
			decks.put("life", schoolSpells.allSchoolSpells.get(schoolSpells.lifeIndex)); 
			System.out.println("Success, life deck is in!"); 
			break;
		
		case "death": 
			decks.put("death", schoolSpells.allSchoolSpells.get(schoolSpells.deathIndex)); 
			System.out.println("Success, death deck is in!"); 
			break;
		
		case "storm": 
			decks.put("storm", schoolSpells.allSchoolSpells.get(schoolSpells.stormIndex));
			System.out.println("Success, storm deck is in!"); 
			break;
			
		case "myth": 
			decks.put("myth", schoolSpells.allSchoolSpells.get(schoolSpells.mythIndex)); 
			System.out.println("Success, myth deck is in!"); 
			break;

		default: 
			TypeException ex = new TypeException(); 
			ex.message(str); 
		}

		Thread th = new Thread(new SpringBootExecutable()); 
		th.start();

		return decks;
		
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
		System.out.println("It is official."); 
		System.out.println("Team " + firstTeamName + " will be versing " + secondTeamName); 
		
		System.out.println("Setting thread here for the countdown from 15 to 1.");
		System.out.println("Just for personal note, potential data analysis will be conducted there.");
		System.out.println("Also look into separate terminals for threading."); 
		
		Thread th = new Thread(new Team1vsTeam2());
    th.start(); 

    try {
      th.join(); 
    }catch(InterruptedException e)
    {
      //System.out.println("Execution will now resume in the main thread."); 
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
		
		String[] checkIfSorted = sortTeamsAlphabetically(team); 
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
			for(int i = 0; i < team.length; i++)
			{
				if(playerName.equals(team[i]))
				{
					team[startIndex] = ""; 
					check = true; 
					break;
				}
			}
			return true; 
		}
		return false; 
	}
	
	public String computePlayerInformation(String wizard, String school, int level, HashMap<Integer, List<String>> keywords, int count)
	{
		System.out.println("Inside computePlayerInformation Method."); 

		StringBuilder gearType1 = new StringBuilder(""); 
		StringBuilder gearType2 = new StringBuilder(""); 
		StringBuilder gearType3 = new StringBuilder(""); 
		StringBuilder gearType4 = new StringBuilder(""); 
		StringBuilder gearType5 = new StringBuilder(""); 
		StringBuilder gearType6 = new StringBuilder(""); 
		StringBuilder gearType7 = new StringBuilder(""); 
		StringBuilder gearType8 = new StringBuilder(""); 

		String[] listGear = {"hat", "robe", "boot", "wand", "athame", "amulet", "ring", "deck", "pet"};  

		Hat hat = (Hat)instantiateGearPiece(listGear[0], school, level, gearType1); 
		System.out.println("Hat gearType: " + gearType1);  
		Robe robe = (Robe)instantiateGearPiece(listGear[1], school, level, gearType2); 
		System.out.println("Robe gearType: " + gearType2); 
		Boot boot = (Boot)instantiateGearPiece(listGear[2], school, level, gearType3);
		System.out.println("Boot gearType: " + gearType3); 
		Wand wand = (Wand)instantiateGearPiece(listGear[3], school, level, gearType4); 
		System.out.println("Wand gearType: " + gearType4); 
		Athame athame = (Athame)instantiateGearPiece(listGear[4], school, level, gearType5);
		System.out.println("Athame gearType: " + gearType5); 
		Amulet amulet = (Amulet)instantiateGearPiece(listGear[5], school, level, gearType6); 
		System.out.println("Amulet gearType: " + gearType6); 
		Ring ring = (Ring)instantiateGearPiece(listGear[6], school, level, gearType7); 
		System.out.println("Ring gearType: " + gearType7); 
		Deck deck = (Deck)instantiateGearPiece(listGear[7], school, level, gearType8); 
		System.out.println("Deck gearType: " + gearType8); 
		Pet pet = (Pet)instantiateGearPiece(listGear[8], school, level, gearType1);
		
		keywords.put(count, Arrays.asList(gearType1.toString(), gearType2.toString(), gearType3.toString(), gearType4.toString(), gearType5.toString(), gearType6.toString(), gearType7.toString(), gearType8.toString())); 

		Gear gear = new Gear(hat, robe, boot, wand, athame, amulet, ring, deck, pet); 

		System.out.println("The gear information for player "  + wizard + " is now completed."); 
		System.out.println(gear.toString()); 

		return gear.toString();  
	}

	public boolean verifyHealthRequirements(int health, int level)
	{
		return true; 
	}

	public void computeStatsInformation(HashMap<String, List<String>> gearSets, HashMap<Integer, List<String>> keywords)
	{
		System.out.println("Before the loop.");
		String[] listItems = {"hat", "robe", "boots", "wand", "athame", "amulet", "ring", "deck"};

		Iterator<Integer> numberIterator = keywords.keySet().iterator(); 
		Iterator<String> wizardIterator = gearSets.keySet().iterator(); 
		int number = 0; 
		String wizard = ""; 

		while(numberIterator.hasNext() && wizardIterator.hasNext())
		{
				number = numberIterator.next();
				wizard = wizardIterator.next(); 
				String word1 = keywords.get(number).get(0); 
				String gearName1 = gearSets.get(wizard).get(0); 
				String word2 = keywords.get(number).get(1); 
				String gearName2 = gearSets.get(wizard).get(1); 
				String word3 = keywords.get(number).get(2); 
				String gearName3 = gearSets.get(wizard).get(2); 
				String word4 = keywords.get(number).get(3); 
				String gearName4 = gearSets.get(wizard).get(3); 
				String word5 = keywords.get(number).get(4); 
				String gearName5 = gearSets.get(wizard).get(4); 
				String word6 = keywords.get(number).get(5); 
				String gearName6 = gearSets.get(wizard).get(5); 
				String word7 = keywords.get(number).get(6); 
				String gearName7 = gearSets.get(wizard).get(6); 
				String word8 = keywords.get(number).get(7); 
				String gearName8 = gearSets.get(wizard).get(7); 

				findGearClass(word1, gearName1, listItems[0]); 
				findGearClass(word2, gearName2, listItems[1]); 
				findGearClass(word3, gearName3, listItems[2]); 
				findGearClass(word4, gearName4, listItems[3]); 
				findGearClass(word5, gearName5, listItems[4]); 
				findGearClass(word6, gearName6, listItems[5]); 
				findGearClass(word7, gearName7, listItems[6]); 
				findGearClass(word8, gearName8, listItems[7]); 
		}
	}

	private void findGearClass(String word, String gearName, String pieceOfGear) {
				if(word.toLowerCase().equals("aeon"))
				{
					new AeonClass(gearName, pieceOfGear); 
				}
				else if(word.toLowerCase().equals("eternal"))
				{
					new EternalClass(gearName, pieceOfGear); 
				}
				else if(word.toLowerCase().equals("dragoon"))
				{
					new DragoonClass(gearName, pieceOfGear); 
				}	
				else if(word.toLowerCase().equals("spooky"))
				{
					new SpookyClass(gearName, pieceOfGear); 
				}
				else if(word.toLowerCase().equals("night mire"))
				{
					new NightMireClass(gearName, pieceOfGear); 
				}
				else if(word.toLowerCase().equals("jade"))
				{
					new JadeClass(gearName, pieceOfGear);
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

	public Object instantiateGearPiece(String gearName, String school, int level, StringBuilder extractGearType)
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

		String[] jadeGear = {"Sword Of Kings", "Stone Of The Other Side", "Pepper Grass Blade", "Celestian Sliver Of Power", "Ring Of The Dying Star"}; 


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
				boolean isJadeGear = Arrays.stream(jadeGear).anyMatch(gear->gear.equals(hatName)); 
				boolean check1 = hatName.contains("Aeon"); 
				boolean check2 = hatName.contains("Eternal"); 
				boolean check3 = hatName.contains("Dragoon"); 
				boolean check4 = hatName.contains("Spooky"); 
				boolean check5 = hatName.contains("Night Mire"); 
				if(isJadeGear == true)
				{
					extractGearType.append("jade"); 
				}
				else 
				{
					extractGearType = filterByKeyword(check1, check2, check3, check4, check5, hatName, extractGearType); 
					System.out.println("Gear Type here: " + extractGearType);
				}
				boolean res1 = checkGearName(hatName, gearName, extractGearType, school, level); 
				if(res1 == true)
				{
					Hat hat = new Hat(hatName); 
					System.out.println("Hat: " + hatName + " created."); 
					return hat; 
				}
				extractGearType = new StringBuilder(""); 
				Hat hat = (Hat)instantiateGearPiece(gearName, school, level, extractGearType);
				return hat;
			case "robe": 
				robeName = sc.nextLine();
				if(!(sc.hasNextLine()))
				{
					sc.close(); 
				}
				isJadeGear = Arrays.stream(jadeGear).anyMatch(gear->gear.equals(robeName)); 
				check1 = robeName.contains("Aeon"); 
				check2 = robeName.contains("Eternal"); 
				check3 = robeName.contains("Dragoon"); 
				check4 = robeName.contains("Spooky");
				check5 = robeName.contains("Night Mire"); 
				if(isJadeGear == true)
				{
					extractGearType.append("jade"); 
				}
				else 
				{
					extractGearType = filterByKeyword(check1, check2, check3, check4, check5, robeName, extractGearType); 
					System.out.println("Gear Type here: " + extractGearType);
				} 
				boolean res2 = checkGearName(robeName, gearName, extractGearType, school, level); 
				if(res2 == true)
				{
					Robe robe = new Robe(robeName); 
					System.out.println("Robe: " + robeName + " created."); 
					return robe;
				}
				extractGearType = new StringBuilder(""); 
				Robe robe = (Robe)instantiateGearPiece(gearName, school, level,  extractGearType);
				return robe;
			case "boot": 
				bootName = sc.nextLine();
				if(!(sc.hasNextLine()))
				{
					sc.close(); 
				}
				isJadeGear = Arrays.stream(jadeGear).anyMatch(gear->gear.equals(bootName)); 
				check1 = bootName.contains("Aeon"); 
				check2 = bootName.contains("Eternal"); 
				check3 = bootName.contains("Dragoon"); 
				check4 = bootName.contains("Spooky"); 
				check5 = bootName.contains("Night Mire"); 
				if(isJadeGear == true)
				{
					extractGearType.append("jade");  
				}
				else 
				{
					extractGearType = filterByKeyword(check1, check2, check3, check4, check5, bootName, extractGearType); 
					System.out.println("Gear Type here: " + extractGearType);
				}
				boolean res3 = checkGearName(bootName, gearName, extractGearType, school, level); 
				if(res3 == true)
				{
					Boot boot = new Boot(bootName); 
					System.out.println("Boot: " + bootName + " created."); 
					return boot;
				}
				extractGearType = new StringBuilder(""); 
				Boot boot = (Boot)instantiateGearPiece(gearName, school, level, extractGearType);
				return boot;
			case "wand": 
				wandName = sc.nextLine();
				if(!(sc.hasNextLine()))
				{
					sc.close(); 
				}
				isJadeGear = Arrays.stream(jadeGear).anyMatch(gear->gear.equals(wandName)); 
				check1 = wandName.contains("Aeon"); 
				check2 = wandName.contains("Eternal"); 
				check3 = wandName.contains("Dragoon"); 
				check4 = wandName.contains("Spooky"); 
				check5 = wandName.contains("Night Mire"); 
				if(isJadeGear == true)
				{
					extractGearType.append("jade"); 
				}
				else 
				{
					extractGearType = filterByKeyword(check1, check2, check3, check4, check5, wandName, extractGearType); 
					System.out.println("Gear Type here: " + extractGearType);
				}
				boolean res4 = checkGearName(wandName, gearName, extractGearType, school, level); 
				if(res4 == true)
				{
					Wand wand = new Wand(wandName); 
					System.out.println("Boot: " + wandName + " created."); 
					return wand;
				}
				extractGearType = new StringBuilder(""); 
				Wand wand = (Wand)instantiateGearPiece(gearName, school, level, extractGearType);
				return wand;
			case "athame": 
				athameName = sc.nextLine();
				if(!(sc.hasNextLine()))
				{
					sc.close(); 
				}
				isJadeGear = Arrays.stream(jadeGear).anyMatch(gear->gear.equals(athameName)); 
				check1 = athameName.contains("Aeon"); 
				check2 = athameName.contains("Eternal"); 
				check3 = athameName.contains("Dragoon"); 
				check4 = athameName.contains("Spooky"); 
				check5 = athameName.contains("Night Mire"); 
				if(isJadeGear == true)
				{
					extractGearType.append("jade");  
				}
				else 
				{
					extractGearType = filterByKeyword(check1, check2, check3, check4, check5, athameName, extractGearType); 
					System.out.println("Gear Type here: " + extractGearType);
				}
				boolean res5 = checkGearName(athameName, gearName, extractGearType, school, level); 
				if(res5 == true)
				{
					Athame athame = new Athame(athameName); 
					System.out.println("Athame: " + athameName + " created."); 
					return athame;
				}
				extractGearType = new StringBuilder(""); 
				Athame athame = (Athame)instantiateGearPiece(gearName, school, level, extractGearType);
				return athame;
			case "amulet": 
				amuletName = sc.nextLine();
				if(!(sc.hasNextLine()))
				{
					sc.close(); 
				}
				isJadeGear = Arrays.stream(jadeGear).anyMatch(gear->gear.equals(amuletName)); 
				check1 = amuletName.contains("Aeon"); 
				check2 = amuletName.contains("Eternal"); 
				check3 = amuletName.contains("Dragoon"); 
				check4 = amuletName.contains("Spooky"); 
				check5 = amuletName.contains("Night Mire"); 
				if(isJadeGear == true)
				{
					extractGearType.append("jade"); 
				}
				else 
				{
					extractGearType = filterByKeyword(check1, check2, check3, check4, check5, amuletName, extractGearType); 
					System.out.println("Gear Type here: " + extractGearType);
				}
				boolean res6 = checkGearName(amuletName, gearName, extractGearType, school, level); 
				if(res6 == true)
				{
					Amulet amulet = new Amulet(amuletName); 
					System.out.println("Amulet: " + amuletName + " created."); 
					return amulet;
				}
				extractGearType = new StringBuilder(""); 
				Amulet amulet = (Amulet)instantiateGearPiece(gearName, school, level, extractGearType);
				return amulet;
			case "ring": 
				ringName = sc.nextLine();
				if(!(sc.hasNextLine()))
				{
					sc.close(); 
				}
				isJadeGear = Arrays.stream(jadeGear).anyMatch(gear->gear.equals(ringName)); 
				check1 = ringName.contains("Aeon"); 
				check2 = ringName.contains("Eternal"); 
				check3 = ringName.contains("Dragoon"); 
				check4 = ringName.contains("Spooky"); 
				check5 = ringName.contains("Night Mire"); 
				if(isJadeGear == true)
				{
					extractGearType.append("jade");  
				}
				else 
				{
					extractGearType = filterByKeyword(check1, check2, check3, check4, check5, ringName, extractGearType); 
					System.out.println("Gear Type here: " + extractGearType);
				}
				boolean res7 = checkGearName(ringName, gearName, extractGearType, school, level); 
				if(res7 == true)
				{
					Ring ring = new Ring(ringName); 
					System.out.println("Ring: " + ringName + " created.");
					return ring;
				}
				extractGearType = new StringBuilder(""); 
				Ring ring = (Ring)instantiateGearPiece(gearName, school, level, extractGearType);
				return ring;
			case "deck": 
				deckName = sc.nextLine(); 
				if(!(sc.hasNextLine()))
				{
					sc.close(); 
				}
				isJadeGear = Arrays.stream(jadeGear).anyMatch(gear->gear.equals(deckName)); 
				check1 = deckName.contains("Aeon"); 
				check2 = deckName.contains("Eternal"); 
				check3 = deckName.contains("Dragoon"); 
				check4 = deckName.contains("Spooky"); 
				check5 = deckName.contains("Night Mire"); 
				if(isJadeGear == true)
				{
					extractGearType.append("jade"); 
				}
				else 
				{
					extractGearType = filterByKeyword(check1, check2, check3, check4, check5, deckName, extractGearType); 
					System.out.println("Gear Type here: " + extractGearType);
				}
				boolean res8 = checkGearName(deckName, gearName, extractGearType, school, level);
				if(res8 == true)
				{
					Deck deck = new Deck(deckName); 
					System.out.println("Deck: " + deckName + " created.");  
					return deck;
				}
				extractGearType = new StringBuilder(""); 
				Deck deck = (Deck)instantiateGearPiece(gearName, school, level, extractGearType);
				return deck;
			case "pet": 
				petName = sc.nextLine(); 
				if(!(sc.hasNextLine()))
				{
					sc.close(); 
				}
				boolean res9 = checkGearName(petName, gearName, null, school, level); 
				if(res9 == true)
				{
					Pet pet = new Pet(petName); 
					System.out.println("Pet: " + petName + " created."); 
					return pet; 
				}
				Pet pet = (Pet)instantiateGearPiece(gearName, school, level, extractGearType); 
				return pet; 
		}
		sc.close();
		TypeException ex = new TypeException();
		ex.message(gearName); 
		return null;
	}

	public static void main(String[]args)
	{
		//new Match().checkGearName("Eternal Inspired Helm", "hat", new StringBuilder("eternal"), "life", 160);
		new Match().createDeck("ice", 1); 
		//Thread th = new Thread(new SpringBootExecutable()); 
		//th.start();
		/*File f1 = new File("deck1.txt"); 
		File[] files = new File[1]; 
		files[0] = f1; 
		//Loops through the Hashmap
		try{
			int countSpells = 0; 
			for(String school: decks.keySet())
			{
				int fileIndex = 0; 
				FileWriter f = new FileWriter(files[fileIndex]); 
				System.out.println("School: " + school); 
				f.write(school + "\n"); 
				for(int i = 0; i < 64; i++)
				{
					System.out.println("Spell Name: " + decks.get(school).get(i).getName()); 
					countSpells++; 
					f.write(decks.get(school).get(i) + "\n"); 
					System.out.println("Spell Counter: " + countSpells); 
				}
				fileIndex++;
				f.close(); 
			}
		}catch(IOException e)
		{
			System.err.println("IOException occurred."); 
		}*/

	}

	public boolean checkGearName(String gearName, String pieceOfGear, StringBuilder gearType, String school, int level)
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
				if(pieceOfGear.equals("pet"))
				{
					Scanner sc = new Scanner(System.in); 
					String petType; 
					System.out.println("Enter the type of your pet here. Make sure to spell it correctly. Otherwise, an error will occur."); 
					petType = sc.nextLine(); 
					if(!(sc.hasNextLine()))
					{
						sc.close();
					}
					//Create a sql string
					String sqlToExecute = "SELECT typeName, school FROM wizard_schema.pets WHERE typename = ?";
					//Execute the sql string above, but create a statement first.
					PreparedStatement createStatement = conn1.prepareStatement(sqlToExecute); 
					createStatement.setString(1, petType); 
					//Store the result inside a result set to access the database column's data
					ResultSet rs = createStatement.executeQuery();  

					boolean iterate = false; 
					while(rs.next())
					{
						//Retrieve the typename of the pet
						String typeName = rs.getString("typeName"); 
						if(petType.equals(typeName))
						{
							Pet.typeName = typeName; 
						}
						else 
						{
							System.out.println("Sorry name in database for pet type: " + typeName + " does not match " + petType);
							break;
						}
						//Retrieve the school of the pet 
						String schoolOfPet = rs.getString("school"); 
						Pet.school = schoolOfPet; 

						iterate = true; 
					}
					conn1.close(); 
					return iterate; 
				}
				else 
				{
					CallableStatement stmt = null;
					System.out.println(gearType); 
					if(gearType.toString().toLowerCase().equals("aeon"))
					{
						stmt = (CallableStatement) conn1.prepareCall("{call extractgear(?,?,?,?,?)}"); 
					}
					else if(gearType.toString().toLowerCase().equals("eternal"))
					{
						stmt = (CallableStatement) conn1.prepareCall("{call extractEternalGear(?,?,?,?,?)}"); 
					}
					else if(gearType.toString().toLowerCase().equals("dragoon"))
					{
						stmt = (CallableStatement) conn1.prepareCall("{call extractDragoonGear(?,?,?,?,?)}"); 
						level = 130; 
					}
					else if(gearType.toString().toLowerCase().equals("spooky"))
					{
						stmt = (CallableStatement) conn1.prepareCall("{call extractSpookyGear(?,?,?,?,?)}"); 
						level = 130; 
					}
					else if(gearType.toString().toLowerCase().equals("night mire"))
					{
						stmt = (CallableStatement) conn1.prepareCall("{call extractNightMireGear(?,?,?,?,?)}"); 
						level = 160;
					}
					else if(gearType.toString().toLowerCase().equals("jade"))
					{
						stmt = (CallableStatement) conn1.prepareCall("{call extractJadeGear(?,?,?,?,?)}"); 
						if(gearName.equals("Stone Of The Other Side") || gearName.equals("Pepper Grass Blade") || gearName.equals("Celestian Sliver Of Power") || gearName.equals("Ring Of The Dying Star"))
						{
							school = "Any";
						}
						level = 160; 
					}
					System.out.println(school); 
					System.out.println(pieceOfGear); 
					System.out.println(String.valueOf(level)); 
					System.out.println(gearName); 
					stmt.setString(1, gearName); 
			 		stmt.setString(2, school); 
					stmt.setString(3, pieceOfGear);
					stmt.setString(4, String.valueOf(level)); 
					stmt.registerOutParameter(5, Types.VARCHAR); 

					stmt.execute(); 
				
					String databaseGearName = stmt.getString(5); 

					if(databaseGearName == null)
					{
						System.out.println("Gear Name entered " + gearName + " does not match " + "database gearName " + databaseGearName + " of given school " + school); 
						conn1.close(); 
						return false;
					}

			 		if(gearName.equals(databaseGearName))
					{
						conn1.close(); 
						return true; 
					}
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

	public StringBuilder filterByKeyword(boolean check1, boolean check2, boolean check3, boolean check4, boolean check5, String name, StringBuilder extractGearType)
	{
		String toCheckfor = ""; 
		String stopCharacter = ""; 
		if(check1 == true)
				{
					toCheckfor = "Aeon"; 
					stopCharacter = "n"; 
				}
				else if(check2 == true)
				{
					toCheckfor = "Eternal"; 
					stopCharacter = "l"; 
				}
				else if(check3 == true)
				{
					toCheckfor = "Dragoon"; 
					stopCharacter = "n"; 
				}
				else if(check4 == true)
				{
					toCheckfor = "Spooky"; 
					stopCharacter = "y"; 
				}
				else if(check5 == true)
				{
					toCheckfor = "Night Mire"; 
					stopCharacter = "e"; 
				}
				int findWordIndex = name.indexOf(toCheckfor); 
				if(findWordIndex != -1)
				{
					int findNextSpace = name.indexOf(stopCharacter, findWordIndex); 
					if(findNextSpace != -1)
					{
						extractGearType.append(name.substring(findWordIndex, findNextSpace+1)); 
						return extractGearType;
					}
					return null;
				}
				System.out.println(extractGearType); 
				return null;
	}

	

}
