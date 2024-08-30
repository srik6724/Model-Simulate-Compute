package Interrogative_Word_Process_;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
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
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

import Components.Bind_5;
import Components.Bind_6;
import Components.Bind_3;
import Components.Bind_8;
import Components.Model;
import Components.Bind_1;
import Components.Bind_7;
import Components.Bind_2;
import Components.Bind_4;
import Configuration_Specifications_1_1.TitleClass;
import Context_Build.Demo_Installation_Terrain;
import Customizations.*;
import Data_Structures.Object_Types.Element;
import Jar.Data_Store;

import java.util.logging.*;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import Mechanisms.Halt_Blocker;
import Model_Extensions.Socket;
import Model_Knowledge.Credentials;
import Object_Types.Category;
import Object_Types.Domain_Category_Product_List;
import Object_Types_Build.*;
import Interrogative_Word_Threading.*;
import RunTime.Disruption.TypeException;
import Logging_Process.LoggingStorage;
import System_State.*;
import System_Variables.*;
public class Interrogative_Word extends Demo_Installation_Terrain implements Cross_Check, Interrogative_Word_Singleton, Interrogative_Word_Recorder {

	private static File initialFile; 

	Interrogative_Word(File file) {
		Interrogative_Word.initialFile = file;
	}

	// Putting match_writer here for now
	Scanner sc = new Scanner(System.in); 

	// Store application states
	private static Queue<ApplicationState<Object>> q = new LinkedList<>(); 

	// Read from the files team_1_information.txt and team_2_information.txt
	String line_curr = ""; 
	File team1 = new File("agent_system_1_1X1_information.txt"); 
	File team2 = new File("agent_system_2_1X1_information.txt");

	// round_reading file

	// Arrays to store information about the firstTeam and secondTeam. 
	int teamSize; 
	private static String[] team; 
	private static String[] teamLevels; 
	private static String[] teamSchools;
	private static List<List<String>> teamPlayers = new ArrayList<List<String>>(); 
	private static List<List<String>> schoolsOfTeam = new ArrayList<List<String>>(); 
	private static HashMap<String, String> playerAssociationToSchool = new HashMap<String, String>(); 
	private static HashMap<String, List<String>> gearSets = new HashMap<String, List<String>>(); 

	private String gameModePath = "gameMode.ser"; 
	private String nameOfTeamPath = "nameOfTeam.ser"; 
	private String playerNamesPath = "playerNames.ser"; 
	private String playerLevelsPath = "playerLevels.ser"; 
	private String playerSchoolsPath = "playerSchools.ser";
	private String playerDecksPath = "playerDecks.ser"; 
	private String playerStatsPath = "playerStats.ser"; 
	private String playerOrderPath = "playerOrder.ser"; 
	private String arenaSelectionPath = "arenaSelection.ser"; 
	private String matchCountDownPath = "matchCountDown.ser"; 
	private String matchBeginsPath = "matchBegins.ser"; 
	private String bothTeamsRegistered = "bothTeamsRegistered.ser";

	// Setting application states here for readability purposes
	private ApplicationState<Object> gameModeState; 
	private ApplicationState<Object> nameOfTeamState; 
	private ApplicationState<Object> playerNamesState; 
	private ApplicationState<Object> playerLevelsState; 
	private ApplicationState<Object> playerSchoolsState; 
	private ApplicationState<Object> playerDecksState; 
	private ApplicationState<Object> playerStatsState; 
	private ApplicationState<Object> playerOrderState; 
	private ApplicationState<Object> arenaSelectionState; 
	private ApplicationState<Object> matchCountDownState; 
	private ApplicationState<Object> matchBeginsState; 
	private ApplicationState<Object> bothTeamsRegisteredState; 
	
	
	private StopWatch watch = new StopWatch(); 
	public Proposition statement = new Proposition(); 
	public String inputReceived = null; 
	
	private static ArrayList<Spectator> spectators; 
	
	private String[] wizSchools = {"Balance", "Death", "Storm", "Myth", "Ice", "Fire", "Life"}; 
	
	private String[] firstTeamOrder = new String[4]; 
	private String[] secondTeamOrder = {}; 
	
	public static HashMap<String, List<List<Element>>> decks = new HashMap<String, List<List<Element>>>(); 
	
	int startCountDown; 
	
	public static int spectatorCount = 0; 
	public static int countDownNumber = 10; 
	
	private String temp = ""; 
	private String retrieveFirstTeamName = ""; 
	private String retrieveSecondTeamName = "";

	public char[] randomVariable;

	private static int countTeamsRegistered = 1; 
	private static int firstIteration = 1; 

	// Creating the buffer reader
	private static BufferedReader reader; 

	private void setBufferReader(File teamFile) throws IOException {
		reader = new BufferedReader(new FileReader(teamFile)); 
	}

	public static BufferedReader getBufferReader() {
		return reader;
	}
	
	public void enroll2Teams(String[]args) throws InterruptedException, IOException
	{
		//launch(args);
		String[] teamStr = {"First", "Second"};  
		for(int i = 0; i < 2; i++)
		{
			if(i == 0) {
				setBufferReader(team1);
				enrollTeamPlayers(teamStr[i], firstIteration, countTeamsRegistered);
				retrieveFirstTeamName = temp; 
			}
			else if(i == 1) {
				setBufferReader(team2);
				enrollTeamPlayers(teamStr[i], firstIteration, countTeamsRegistered);
				retrieveSecondTeamName = temp; 
				//Thread.sleep(2000); 
				System.out.println("Team Name Of Second Team: " + retrieveSecondTeamName);
			}
		}
		System.out.println(retrieveFirstTeamName + " will be competing against " + retrieveSecondTeamName); 
		if(BreakpointVariables.getArenaSelection() == true) {
			System.out.println("Re-execute arena selection again? Y or N"); 
			String input = sc.nextLine(); 
			if(input.equals("Y")) {
				//randomizeArenaSelection(); 
			}
		}

		if(BreakpointVariables.getMatchCountDown() == true) {
			System.out.println("Re-execute match countdown? Y or N"); 
			String input = sc.nextLine(); 
			if(input.equals("Y")) {
				//randomizeArenaSelection();
			}
		}
		else {
			matchCountDown(retrieveFirstTeamName, retrieveSecondTeamName); 
		}

		if(BreakpointVariables.getMatchBegins() == true) {
			System.out.println("Re-execute match countdown? Y or N"); 
			String input = sc.nextLine(); 
			if(input.equals("Y")) {
				sc.close();
				beginMatch();
			}
		}
		else {
			beginMatch();
		}
	}

	private void setPlayerOrder() {
		System.out.println("Enter the order your team would like to be placed during the match.");
		System.out.println("Here is a list of potential orders you could be interested in for ordering your team.");

		
	}

	private void setPlayerStats() throws NumberFormatException, IOException {
		System.out.println("The next step will involve player stats to be recorded of every individual."); 
		System.out.println("This is expected to take around 10-15 minutes in total, so please be patient."); 
		int iter = 4; 
		int place = 0; 
		firstIteration = 1; 
		String saveDuplicateKey = ""; 
		LinkedListAgentSystem1 list1 = new LinkedListAgentSystem1(); 
		LinkedListAgentSystem2 list2 = new LinkedListAgentSystem2(); 
		HashMap<Integer, List<String>> keywords = new HashMap<Integer, List<String>>(); 
		for(int i = 0; i < team.length; i++)
		{
			System.out.println(teamSchools[i]); 
			//The full gear string is in the format gear1, gear2, gear3, gear4, gear5, gear6, gear7
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
				System.out.println("Gear to add: " + gearToAdd); 
				storeGearPieces.add(gearToAdd); 
				if(start < 9)
				{
					gearToAdd += ","; 
				}
				fullGearString = cutPartOfString(gearToAdd, fullGearString); 
				System.out.println("Full Gear String: " + fullGearString); 
				gearToAdd = ""; 
				start = start + 1; 
			}
			System.out.println(team[i]); 
			
			if(countTeamsRegistered == 1)
			{
				LinkedListAgentSystem1.Node node = new LinkedListAgentSystem1.Node(team[i], storeGearPieces); 
				list1.insert(node); 
				System.out.println("Inside storeGearPieces method."); 
				System.out.println(LinkedListAgentSystem1.head); 
			}
			else 
			{
				LinkedListAgentSystem2.Node node = new LinkedListAgentSystem2.Node(team[i], storeGearPieces); 
				list2.insert(node); 
			}
		}
		LinkedListAgentSystem1.Node current1;
		LinkedListAgentSystem2.Node current2;
		if(countTeamsRegistered == 1)
		{
			current1 = LinkedListAgentSystem1.head; 
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
		}
		else
		{
			list2.printNodeData();
			current2 = LinkedListAgentSystem2.head; 
			//System.out.println(current2); 
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
		LoggingStorage.getLogger().log(Level.INFO, "Player stats completed for each player on team."); 
		BreakpointVariables.setPlayerStats(true);
		playerStatsState = new ApplicationState<Object>(Interrogative_Word.gearSets, playerStatsPath); 
		q.add(playerStatsState); 
	}

	void createPlayerDecks(boolean flag) throws IOException {
		System.out.println("You are now clear to now create a deck for each player on your team."); 
		if(flag == false) {
			for(int i = 0; i < teamSize; i++)
			{
				createDeck(teamSchools[i], (i+1)); 
			}
		}
		else {
			boolean iterate = true; 
			List<String> players = new ArrayList<String>(); 
			int maxLimit = 4; 
			while(iterate)
			{
				System.out.println("Which player do you want to reset the deck for? Options are player 1, player 2, player 3, or player 4");
				String input = sc.nextLine(); 
				if(input.equals("1")){
					players.add(input); 
					maxLimit--;
				}
				else if(input.equals("2")){
					players.add(input); 
					maxLimit--;
				}
				else if(input.equals("3")) {
					players.add(input); 
					maxLimit--;
				}
				else if(input.equals("4")) {
					players.add(input); 
					maxLimit--;
				}
				System.out.println("Are you done or more?"); 
				String isFinished = sc.nextLine(); 
				if(isFinished.equals("NO")) {
					iterate = true;
				}
				else if(maxLimit == 0 || isFinished.equals("YES")) {
					iterate = false; 
				}
			}
		}

		System.out.println("The decks are now created for all schools specified.");
		System.out.println(); 
		System.out.println(); 

		System.out.println("The files are created for all decks specified."); 

		LoggingStorage.getLogger().log(Level.INFO, "Player Decks created for each player on team");
		BreakpointVariables.setPlayerDecks(true);
		playerDecksState = new ApplicationState<Object>(Interrogative_Word.decks, playerDecksPath);
		q.add(playerDecksState); 
	}

	void selectPlayerIdentitiesForTeam() throws InterruptedException {
		System.out.println("Success, now proceed to write down each of the school identities of the players."); 
		System.out.println(); 
		System.out.println(); 
		System.out.println(); 
		System.out.println(); 
		System.out.println("Just a note. The following school names allowed to be entered are: "
				+ "Ice, Fire, Death, Balance, Life, Myth, and Storm."
				+ "Any other schools will not be accepted.");
		
		Thread.sleep(1000); 

		System.out.println("Reading the player identities.");

		for(int i = 0; i < teamSchools.length; i++) {
			System.out.println("Player " + (i+1) + " School: " + teamSchools[i]); 
		}
		Interrogative_Word.schoolsOfTeam.add(Arrays.asList(teamSchools)); 
	}

	void selectPlayerLevelsForTeam() {
		for(int i = 0; i < teamLevels.length; i++) {
			System.out.println("Added " + teamLevels[i] + " level of " + "player " + team[i]); 
		}
		LoggingStorage.getLogger().log(Level.INFO, "Levels for each player on team selected."); 
		BreakpointVariables.setPlayerLevels(true);  
		playerLevelsState = new ApplicationState<Object>(Interrogative_Word.teamLevels, playerLevelsPath); 
		q.add(playerLevelsState);
	}

	void selectPlayerNamesForTeam() {
		boolean checkPlayerNames = true; 
		
		System.out.println("INSTRUCTIONS FOR REGISTERING A TEAM. Follow carefully."); 
		System.out.println("First, please write down the names of your players."
				+ "After this step is completed, write down the corresponding levels of each player." + "Then proceed"
						+ "to write down the school identities of every player."); 
		System.out.println("We humbly request it is done in this order as we would hope to avoid any technical "
				+ "issues on our end for registering all teams. Thank you! "); 
		
		List<String> playersOnTeam = new ArrayList<String>(); 
		System.out.println("Team Length: " + team.length); 
		for(int i = 0; i < team.length; i++) {
			System.out.println(team[i]);
			playersOnTeam.add(team[i]); 
		}
		teamPlayers.add(playersOnTeam); 
		playerNamesState = new ApplicationState<Object>(teamPlayers, playerNamesPath);
		q.add(playerNamesState); 
		LoggingStorage.getLogger().log(Level.INFO, "Player Names selected for players on team");
		BreakpointVariables.setPlayerNames(true); 
	}

	String selectTeamName(String str) {
		System.out.println(str + " Team");
		System.out.println("-------------------"); 
		System.out.println("What is the name of your team?"); 
		String teamName = sc.nextLine();
		LoggingStorage.getLogger().log(Level.INFO, "Name selected for team.");
		BreakpointVariables.setNameOfTeam(true); 
		nameOfTeamState = new ApplicationState<Object>(teamName, nameOfTeamPath); 
		q.add(nameOfTeamState); 
		return teamName;
	}
	
	void gameModeSelection(String line_curr) throws InterruptedException {
		boolean iterate = true; 
		String gameMode = line_curr; 
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
			if(gameMode.contains("1v1"))
			{
				teamSize = _1v1_.teamSize(); 
				team = new String[teamSize]; 
				teamLevels = new String[teamSize]; 
				teamSchools = new String[teamSize]; 
				System.out.println("Team Size Value Set Here: " + teamSize); 
			}
			else if(gameMode.contains("2v2"))
			{
				teamSize = _2v2_.teamSize(); 
				team = new String[teamSize]; 
				teamLevels = new String[teamSize]; 
				teamSchools = new String[teamSize]; 
			}
			else if(gameMode.contains("3v3"))
			{
				teamSize = _3v3_.teamSize(); 
				team = new String[teamSize]; 
				teamLevels = new String[teamSize]; 
				teamSchools = new String[teamSize];
			}
			else if(gameMode.contains("4v4"))
			{
				teamSize = _4v4_.teamSize(); 
				team = new String[teamSize]; 
				teamLevels = new String[teamSize]; 
				teamSchools = new String[teamSize]; 
			}
			break; 
		}
		System.out.println("Game-mode selection chosen is: " + gameMode); 
		LoggingStorage.getLogger().log(Level.INFO, "Game-mode selection completed."); 
		BreakpointVariables.setGameModeSelection(true);  
		gameModeState = new ApplicationState<Object>(gameMode, gameModePath); 
		StatePersistence gameModePersistence = new StatePersistence(gameModeState); 
		gameModePersistence.saveState();
		q.add(gameModeState); 
	}
	
	public void enrollTeamPlayers(String str, int firstIteration, int countTeamsRegistered) throws InterruptedException, IOException
	{
		if(BreakpointVariables.getGameModeSelection() == true && BreakpointVariables.getBothTeamsRegistered() == true) {
			System.out.println("Re-execute game mode selection again? Y or N"); 
			String input = sc.nextLine(); 
			if(input.equals("Y")) {
				BreakpointVariables.setGameModeSelection(false);
				line_curr = Interrogative_Word.getBufferReader().readLine();
				gameModeSelection(line_curr);
			}
			else {
				System.out.println("Testing the load state function. Accessing the queue");
				gameModeState = pollQueue(gameModePath); 
			}
		} else {
			line_curr = Interrogative_Word.getBufferReader().readLine();
			gameModeSelection(line_curr);
		} 

		if(BreakpointVariables.getNameOfTeam() == true && BreakpointVariables.getBothTeamsRegistered() == true) {
			System.out.println("Switch team name? Y or N"); 
			String input = sc.nextLine(); 
			if(input.equals("Y")) {
				BreakpointVariables.setNameOfTeam(false);
				temp = selectTeamName(str); 
				System.out.println("Team Name chosen is: " + temp); 
			}
		}
		else {
			System.out.println("Select your team name."); 
			temp = reader.readLine(); 
			temp = temp.replace("Team Name:", "");
			System.out.println("Team Name chosen is:" + temp); 
		}

		if(BreakpointVariables.getPlayerNames() == true && BreakpointVariables.getBothTeamsRegistered() == true) {
			System.out.println("Change player names? Y or N"); 
			String input = sc.nextLine(); 
			if(input.equals("Y")) {
				BreakpointVariables.setPlayerNames(false);
				selectPlayerNamesForTeam(); 
			}
		}
		else {
			// Collecting the player names
			System.out.println("Team Size: " + teamSize); 
			for(int i = 0; i < teamSize; i++) {
				String playerName = reader.readLine();
				System.out.println("Player Name Read: " + playerName); 
				if(playerName.contains("Player " + (i+1) + " Name: ")) {
					String x = "Player " + (i+1) + " Name: "; 
					playerName = playerName.replace(x, ""); 
					team[i] = playerName; 
				}
			}
			selectPlayerNamesForTeam();
		}

		if(BreakpointVariables.getPlayerLevels() == true && BreakpointVariables.getBothTeamsRegistered() == true) {
			System.out.println("Change player levels? Y or N"); 
			String input = sc.nextLine(); 
			if(input.equals("Y")) {
				BreakpointVariables.setPlayerLevels(false);
				selectPlayerLevelsForTeam(); 
			}
		}
		else {
			for(int i = 0; i < teamSize; i++) {
				String levelOfPlayer = reader.readLine();
				if(levelOfPlayer.contains("Player " + (i+1) + " Level: ")){
					String x = "Player " + (i+1) + " Level: "; 
					levelOfPlayer = levelOfPlayer.replace(x, ""); 
					teamLevels[i] = levelOfPlayer;
				}
			}
			selectPlayerLevelsForTeam();
		}

		if(BreakpointVariables.getPlayerSchools() == true && BreakpointVariables.getBothTeamsRegistered() == true) {
			System.out.println("Change player identities? Y or N"); 
			String input = sc.nextLine(); 
			if(input.equals("Y")) {
				BreakpointVariables.setPlayerSchools(false);
				selectPlayerIdentitiesForTeam(); 
			}
		} else {
			for(int i = 0; i < teamSize; i++) {
				String schoolOfPlayer = reader.readLine(); 
				if(schoolOfPlayer.contains("Player " + (i+1) + " School: ")) {
					String x = "Player " + (i+1) + " School: "; 
					schoolOfPlayer = schoolOfPlayer.replace(x, ""); 
					teamSchools[i] = schoolOfPlayer;
				}
			}
			selectPlayerIdentitiesForTeam(); 
		}

		if(BreakpointVariables.getPlayerDecks() == true && BreakpointVariables.getBothTeamsRegistered() == true) {
			System.out.println("Change player decks? Y or N"); 
			String input = sc.nextLine(); 
			if(input.equals("Y")) {
				BreakpointVariables.setPlayerDecks(false);
				boolean flag = BreakpointVariables.getPlayerDecks(); 
				createPlayerDecks(flag); 
			}
		} else {
			BreakpointVariables.setPlayerDecks(false);
			boolean flag = BreakpointVariables.getPlayerDecks(); 
			createPlayerDecks(flag); 
		}

		System.out.println();
		System.out.println(); 
		System.out.println(); 
		System.out.println(); 

		if(BreakpointVariables.getPlayerStats() == true && BreakpointVariables.getBothTeamsRegistered() == true) {
			System.out.println("Redo player stats for players? Y or N"); 
			String input = sc.nextLine(); 
			if(input.equals("Y")) {
				gearSets = new HashMap<String, List<String>>(); 
				setPlayerStats(); 
			}
		}
		else {
			setPlayerStats(); 
		}

		if(BreakpointVariables.getPlayerOrder() == true) {
			System.out.println("Revamp player order for team? Y or N"); 
			String input = sc.nextLine(); 
			if(input.equals("Y")) {
				setPlayerOrder(); 
			}
		}
		else {
			setPlayerOrder(); 
		}
	} 
	private ApplicationState<Object> pollQueue(String pathName) {
		return q.stream()
					 .filter(state -> state.getFilePath().equals(pathName))
					 .findFirst()
					 .orElse(null); 
	}

	private void generatePossibleOrders(int left, int right, int length, int firstIteration, String[]orderCreated, List<String> firstTeamSchools, HashMap<Integer, List<String>> orderDetail) {
		// Implement a backtracking algorithm that generates all the possible combinations of orders that one can look at.
		// Use hashmap to store the information of each order. 
		// Make sure to terminate the base case if there are duplicates and no other potential combinations can be created. 
		// Use a randomization metric from 0-3 to decide which two elements to swap

		if(firstIteration == 1)
		{
			orderCreated = firstTeamSchools.toArray(orderCreated); 
			firstIteration = 0; 
		}

		if(orderDetail.size() == 0)
		{
			orderDetail.put(left+1, Arrays.asList(orderCreated)); 
		}
		else 
		{
			orderDetail.put(left+1, Arrays.asList(orderCreated));
		}

		if(left < length)
		{
			int firstRandomNumber = (int)(Math.random() * orderCreated.length-1);
			int secondRandomNumber = (int)(Math.random() * orderCreated.length-1); 

			String temp = orderCreated[firstRandomNumber]; 
			orderCreated[firstRandomNumber] = orderCreated[secondRandomNumber];
			orderCreated[secondRandomNumber] = temp; 

			generatePossibleOrders(left+1, right, length, firstIteration, Arrays.copyOf(orderCreated, orderCreated.length), Arrays.asList(orderCreated), orderDetail);
		}

		if(right < length)
		{
			int firstRandomNumber = (int)(Math.random() * orderCreated.length-1); 
			int secondRandomNumber = (int)(Math.random() * orderCreated.length-1); 

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

	private HashMap<String, List<List<Element>>> createDeck(String str, int deckNo) throws IOException {
		
		new Domain_Category_Product_List(str); 
		
		switch(str.toLowerCase()) {
		case "balance": 
			int mainDeckCardIndex = 0; 
			int tcDeckCardIndex = 0; 

			decks.put("balance", Domain_Category_Product_List.allSchoolSpells.get(Domain_Category_Product_List.balanceIndex)); 

			for(String school: decks.keySet())
			{
				if(school.equals("balance"))
				{
					boolean iterate = true; 
					while(iterate && mainDeckCardIndex < 10 && tcDeckCardIndex < 10)
					{
						System.out.println("Main Deck Card Name: " + decks.get(school).get(0).get(mainDeckCardIndex).getSpellName()); 
						System.out.println("TC Deck Card Name: " + decks.get(school).get(1).get(tcDeckCardIndex).getSpellName());  
						mainDeckCardIndex++; 
						tcDeckCardIndex++;
					}
				}
			}

			System.out.println("Main Deck Card No: " + (mainDeckCardIndex + 1)); 
			System.out.println("TC Deck Card No: " + (tcDeckCardIndex + 1)); 

			System.out.println("Success, balance deck is in!"); 
			break;
		
		case "fire": 
			mainDeckCardIndex = 0; 
			tcDeckCardIndex = 0; 

			decks.put("fire", Domain_Category_Product_List.allSchoolSpells.get(Domain_Category_Product_List.fireIndex));

			for(String school: decks.keySet())
			{
				if(school.equals("fire"))
				{
					boolean iterate = true; 
					while(iterate && mainDeckCardIndex < 64 && tcDeckCardIndex < 40)
					{
						System.out.println("Main Deck Card Name: " + decks.get(school).get(0).get(mainDeckCardIndex).getSpellName()); 
						System.out.println("TC Deck Card Name: " + decks.get(school).get(1).get(tcDeckCardIndex).getSpellName());  
						mainDeckCardIndex++; 
						tcDeckCardIndex++;
					}
				}
			}

			System.out.println("Main Deck Card No: " + (mainDeckCardIndex + 1)); 
			System.out.println("TC Deck Card No: " + (tcDeckCardIndex + 1)); 

			System.out.println("Success, fire deck is in!"); 
			break;
			
		case "ice": 
			mainDeckCardIndex = 0; 
			tcDeckCardIndex = 0; 

			decks.put("ice", Domain_Category_Product_List.allSchoolSpells.get(Domain_Category_Product_List.stormIndex));

			for(String school: decks.keySet())
			{
				if(school.equals("ice"))
				{
					boolean iterate = true; 
					while(iterate)
					{
						System.out.println("Main Deck Card Name: " + decks.get(school).get(0).get(mainDeckCardIndex).getSpellName()); 
						System.out.println("TC Deck Card Name: " + decks.get(school).get(1).get(tcDeckCardIndex).getSpellName());  
						mainDeckCardIndex++; 
						tcDeckCardIndex++;
					}
				}
			}

			System.out.println("Main Deck Card No: " + (mainDeckCardIndex + 1)); 
			System.out.println("TC Deck Card No: " + (tcDeckCardIndex + 1)); 

			System.out.println("Success, ice deck is in!"); 
			break;
		
		case "life": 
			mainDeckCardIndex = 0; 
			tcDeckCardIndex = 0; 

			decks.put("life", Domain_Category_Product_List.allSchoolSpells.get(Domain_Category_Product_List.lifeIndex)); 

			for(String school: decks.keySet())
			{
				if(school.equals("life"))
				{
					boolean iterate = true; 
					while(iterate && mainDeckCardIndex < 10 && tcDeckCardIndex < 10)
					{
						System.out.println("Main Deck Card Name: " + decks.get(school).get(0).get(mainDeckCardIndex).getSpellName()); 
						System.out.println("TC Deck Card Name: " + decks.get(school).get(1).get(tcDeckCardIndex).getSpellName());  
						mainDeckCardIndex++; 
						tcDeckCardIndex++;
					}
				}
			}

			System.out.println("Main Deck Card No: " + (mainDeckCardIndex + 1)); 
			System.out.println("TC Deck Card No: " + (tcDeckCardIndex + 1)); 

			System.out.println("Success, life deck is in!"); 
			break;
		
		case "death": 
			mainDeckCardIndex = 0; 
			tcDeckCardIndex = 0; 

			decks.put("death", Domain_Category_Product_List.allSchoolSpells.get(Domain_Category_Product_List.deathIndex)); 

			for(String school: decks.keySet())
			{
				if(school.equals("death"))
				{
					boolean iterate = true; 
					while(iterate && mainDeckCardIndex < 64 && tcDeckCardIndex < 40)
					{
						System.out.println("Main Deck Card Name: " + decks.get(school).get(0).get(mainDeckCardIndex).getSpellName()); 
						System.out.println("TC Deck Card Name: " + decks.get(school).get(1).get(tcDeckCardIndex).getSpellName());  
						mainDeckCardIndex++; 
						tcDeckCardIndex++;
					}
				}
			}

			System.out.println("Main Deck Card No: " + (mainDeckCardIndex + 1)); 
			System.out.println("TC Deck Card No: " + (tcDeckCardIndex + 1)); 

			System.out.println("Success, death deck is in!"); 
			break;
		
		case "storm": 
			mainDeckCardIndex = 0; 
			tcDeckCardIndex = 0; 

			decks.put("storm", Domain_Category_Product_List.allSchoolSpells.get(Domain_Category_Product_List.stormIndex));

			for(String school: decks.keySet())
			{
				if(school.equals("storm"))
				{
					boolean iterate = true; 
					while(iterate && mainDeckCardIndex < 64 && tcDeckCardIndex < 40)
					{
						System.out.println("Main Deck Card Name: " + decks.get(school).get(0).get(mainDeckCardIndex).getSpellName()); 
						System.out.println("TC Deck Card Name: " + decks.get(school).get(1).get(tcDeckCardIndex).getSpellName());  
						mainDeckCardIndex++; 
						tcDeckCardIndex++;
					}
				}
			}

			System.out.println("Main Deck Card No: " + (mainDeckCardIndex + 1)); 
			System.out.println("TC Deck Card No: " + (tcDeckCardIndex + 1)); 

			System.out.println("Success, storm deck is in!"); 
			break;
			
		case "myth": 
			mainDeckCardIndex = 0; 
			tcDeckCardIndex = 0; 

			decks.put("myth", Domain_Category_Product_List.allSchoolSpells.get(Domain_Category_Product_List.mythIndex)); 

			for(String school: decks.keySet())
			{
				if(school.equals("myth"))
				{
					boolean iterate = true; 
					while(iterate && mainDeckCardIndex < 64 && tcDeckCardIndex < 40)
					{
						System.out.println("Main Deck Card Name: " + decks.get(school).get(0).get(mainDeckCardIndex).getSpellName()); 
						System.out.println("TC Deck Card Name: " + decks.get(school).get(1).get(tcDeckCardIndex).getSpellName());  
						mainDeckCardIndex++; 
						tcDeckCardIndex++;
					}
				}
			}

			System.out.println("Main Deck Card No: " + (mainDeckCardIndex + 1)); 
			System.out.println("TC Deck Card No: " + (tcDeckCardIndex + 1)); 

			System.out.println("Success, myth deck is in!"); 
			break;

		default: 
			TypeException ex = new TypeException(); 
			ex.message(str); 
		}

		Thread th = new Thread(new Data_Store()); 
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
		//int ArenaNumber = Arena_Default.ArenaNumber();
		//int AvalonArenaNumber = Arena_1.returnAvalonArenaNumber(); 
		/*int DragonSpyreArenaNumber = DragonSpyreArena.DragonSpyreArenaNumber(); 
		int GrizzleheimArenaNumber = GrizzleheimArena.GrizzleheimArenaNumber(); 
		int HeapArenaNumber = HeapArena.HeapArenaNumber(); 
		
		int MooshuArenaNumber = MooshuArena.MooshuaArenaNumber(); */
		
		String arenaName = " "; 
		int ArenaNumberSelected = (int)(Math.random() * 6) + 1; 
		
		//int[] arenaNumbers = {ArenaNumber, AvalonArenaNumber, DragonSpyreArenaNumber, GrizzleheimArenaNumber, HeapArenaNumber, MooshuArenaNumber};
		/*String[] arenaNames = {ArenaName(), AvalonArenaName(), DragonSpyreArenaName(), GrizzleheimArenaName(), HeapArenaName(), MooshuArenaName()}; 
		
		
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

		LoggingStorage.getLogger().log(Level.INFO, "Arena selection has been made."); 
		BreakpointVariables.setArenaSelection(true);
		// Storing arenaName
		arenaSelectionState = new ApplicationState<Object>(arenaName, arenaSelectionPath);
		q.add(arenaSelectionState); */
	}
	
	public void matchCountDown(String firstTeamName, String secondTeamName)
	{	
		System.out.println("It is official."); 
		System.out.println("Team " + firstTeamName + " will be versing " + secondTeamName); 
		
		System.out.println("Setting thread here for the countdown from 15 to 1.");
		System.out.println("Just for personal note, potential data analysis will be conducted there.");
		System.out.println("Also look into separate terminals for threading."); 
		
		Thread env = new Thread(new AgentSystem1XAgentSystem2());
    env.start(); 

    try {
      env.join(); 
    }catch(InterruptedException e)
    {
      //System.out.println("Execution will now resume in the main thread."); 
    }

		int numberOfSpectators = countSpectators(); 
		System.out.println("We will have " + numberOfSpectators + " spectators " + "watching the match. "); 
		
		String[] checkIfSorted = sortTeamsAlphabetically(team); 
		for(int i = 0; i < checkIfSorted.length; i++)
		{
			System.out.println("Sorted element " + i + ": " + checkIfSorted[i]); 
		}
		//watch.startWatch(); 
		LoggingStorage.getLogger().log(Level.INFO, "Match countdown for both teams versing one another completed."); 
		BreakpointVariables.setMatchCountDown(true);
		matchCountDownState = new ApplicationState<Object>("Place-holder to store match state", matchCountDownPath);
		q.add(matchCountDownState);
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
		// Before Insertion Sort Algorithm 

		for(int i = 0; i < firstTeam.length; i++)
		{
			System.out.println("Player Element " + i + ": " + firstTeam[i]); 
		}
		
		// Insertion Sort algorithm 
		// We are going to sort the two teams alphabetically in order. 
		// First Team: Cowan Shadowsteed, Miguel Pearlhunter, Travis Waterblood, Anthony Firestone
		
		for(int i = 1; i < firstTeam.length; i++)
		{
			String retrieveKey = firstTeam[i]; // Cowan Shadowsteed
			
			// Store the index i in variable j
			int j = i - 1;  // 0
			
			// Compare the first character to the second character
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

	private Set<String> extractUniqueElementsTeam(List<String> players) {
		Set<String> uniquePlayerNames = new HashSet<String>(); 

		for(String player: players) {
			uniquePlayerNames.add(player);
		}

		return uniquePlayerNames;
	}

	private void setTeamAttributes() {
		int playerIndex = 0; 
		int schoolIndex = 0;
		String playerPerson = ""; 


		System.out.println("-------------------------------------"); 
		System.out.println("#####################################"); 

		int loop = 1; 
		for(List<String> team: teamPlayers) {

			List<String> sortedTeam = new ArrayList<>(team); 
			Collections.sort(sortedTeam); 
			// Sorted Team, Mark Labels on unique entries
			Set<String> uniquePlayerNames = extractUniqueElementsTeam(sortedTeam);
			System.out.println("UNIQUE PLAYER NAMES SIZE: " + uniquePlayerNames.size()); 

			for(String uniquePlayer: uniquePlayerNames) {
				System.out.println("UNIQUE PLAYER NAME: " + uniquePlayer); 
				int counter = 0;
				for(int i = 0; i < team.size(); i++) {
					if(team.get(i).equals(uniquePlayer)) {
						team.set(i, uniquePlayer +  " BOT "  + String.valueOf(++counter) + " --> (SYSTEM " + loop + ")");
					}
				}
				counter = 0; 
			}
			loop++;
		}

		System.out.println("#####################################"); 
		System.out.println("-------------------------------------"); 

		boolean iterationTeamDone = false; 
		for(List<String> players: teamPlayers) {
			for(int i = 0; i < players.size(); i++) {
				if(i == playerIndex) {
					playerPerson = players.get(i); 
					System.out.println("Player to be inserted is: " + playerPerson); 
					for(List<String> schools: schoolsOfTeam) { 
						if(iterationTeamDone == true) {
							iterationTeamDone = false; 
							continue; 
						}
						boolean breakLoop = false; 
						for(int j = 0; j < schools.size(); j++) { 
							if(j == schoolIndex) {  
								String school = schools.get(j); 
								System.out.println("School to be inserted is: " + school); 
								playerAssociationToSchool.put(playerPerson, school); 
								breakLoop = true; 
							}
						}

						if(breakLoop == true) {
							break;
						}
	
					}
				}
				playerIndex++;
				schoolIndex++; 
			}
			iterationTeamDone = true; 
			playerIndex = 0; 
			schoolIndex = 0; 
		}
	}
	
	public void beginMatch()
	{
		// Placing team members with their respective schools depending by the team they belong to
		setTeamAttributes();

		System.out.println("TEAM ATTRIBUTES SET FOR MEMBERS OF TEAMS."); 

		System.out.println("Match between " + retrieveFirstTeamName + " and " + retrieveSecondTeamName + " has begun."); 
		System.out.println("We now spin a wheel to decide who starts first. We will do this "
				+ "the traditional way.");
		System.out.println("Heads or Tails Style."); 
		System.out.println("TEAM" + retrieveFirstTeamName + ": " + "Heads or Tails");
		String input1 = sc.nextLine(); 
		System.out.println("TEAM" + retrieveSecondTeamName + ": " + "Heads or Tails");
		String input2 = sc.nextLine(); 
		String inputAnswer = randomizeHeadsOrTails(); 

		if(inputAnswer.equals(input1)) 
		{
			System.out.println("TEAM " + retrieveFirstTeamName + " is starting first."); 

			Thread th1 = new Thread(new Agent_System_1()); 

			try {
				th1.start(); 
				th1.join(); 
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		else if(inputAnswer.equals(input2))
		{
			System.out.println("TEAM " + retrieveFirstTeamName + " is starting first."); 
			
			Thread th2 = new Thread(new Agent_System_2()); 

			try {
				th2.start(); 
				th2.join(); 
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		LoggingStorage.getLogger().log(Level.INFO, "The match has begun."); 
		BreakpointVariables.setMatchBegins(true); 
	}

	public FileWriter getMatchRecorderInstance() {
		FileWriter matchRecorder = null;
		try {
			matchRecorder = Interrogative_Word_Recorder.getFileWriter(); 
		} catch (IOException e) {
			e.printStackTrace(); 
		}
		return matchRecorder;
	}
	
	public static void startCrossCheck(int index, FileWriter productWriterFinalizer, FileReader cross_checkReading) throws IOException, InterruptedException
	{
		FileWriter cross_checkTeam1SpellsWriter = null;
		FileWriter cross_checkTeam2SpellsWriter = null;
		FileWriter productCombineWriter = null;
		FileWriter productcross_checkBycross_checkWriter = null; 
		FileWriter productExcessSpellsWriter = null;
		FileWriter productExcessSpellsTeam1Writer = null;
		FileWriter productExcessSpellsTeam2Writer = null;
		FileWriter productRemainingSpellsWriter = null;
		FileWriter productRemainingSpellsTeam1Writer = null;
		FileWriter productRemainingSpellsTeam2Writer = null;
		FileWriter productSelectionLineWriter = null;
		FileWriter productSelectionLineTeam1Writer = null;
		FileWriter productSelectionLineTeam2Writer = null;
		FileWriter cross_checkPrGraphWriter = null;
		FileWriter cross_checkPrGraphTeam1Writer = null;
		FileWriter cross_checkPrGraphTeam2Writer = null;
		FileWriter cross_checkPrFactsWriter = null;
		FileWriter cross_checkPrFactsTeam1Writer = null;
		FileWriter cross_checkPrFactsTeam2Writer = null;
		FileWriter cross_checkPrRulesWriter = null;
		FileWriter cross_checkPrRulesTeam1Writer = null;
		FileWriter cross_checkPrRulesTeam2Writer = null;
		FileWriter cross_checkPrInterpretationsWriter = null;
		FileWriter cross_checkPrInterpretationsTeam1Writer = null;
		FileWriter cross_checkPrInterpretationsTeam2Writer = null;
		FileWriter cross_checkStaticLanguageWriter = null;
		FileWriter cross_checkStaticLanguageTeam1Writer = null;
		FileWriter cross_checkStaticLanguageTeam2Writer = null;
		FileWriter cross_checkChangingLanguageWriter = null;
		FileWriter cross_checkChangingLanguageTeam1Writer = null;
		FileWriter cross_checkChangingLanguageTeam2Writer = null;
		FileWriter cross_checkStaticGrammarWriter = null;
		FileWriter cross_checkStaticGrammarTeam1Writer = null;
		FileWriter cross_checkStaticGrammarTeam2Writer = null;
		FileWriter cross_checkChangingGrammarWriter = null;
		FileWriter cross_checkChangingGrammarTeam1Writer = null;
		FileWriter cross_checkChangingGrammarTeam2Writer = null;
		FileWriter cross_checkGenerationWriter = null;
		FileWriter cross_checkGenerationTeam1Writer = null;
		FileWriter cross_checkGenerationTeam2Writer = null;
		FileWriter cross_checkOrderingPlacementsWriter = null;
		FileWriter cross_checkOrderingPlacementsTeam1Writer = null;
		FileWriter cross_checkOrderingPlacementsTeam2Writer = null;
		FileWriter cross_checkCombineWriter = null;
		FileWriter cross_checkDefaultWriter = null;
		FileWriter cross_checkTacticalApproachWriter = null;
		FileWriter cross_checkTacticalApproachTeam1Writer = null;
		FileWriter cross_checkTacticalApproachTeam2Writer = null;
		FileWriter cross_checkSelectionLineWriter = null; 
		FileWriter cross_checkSelectionLineTeam1Writer = null;
		FileWriter cross_checkSelectionLineTeam2Writer = null;
		FileWriter cross_checkRemainingSpellsWriter = null;
		FileWriter cross_checkRemainingTeam1SpellsWriter = null;
		FileWriter cross_checkRemainingTeam2SpellsWriter = null;
		FileWriter cross_checkExcessSpellsWriter = null;
		FileWriter cross_checkExcessSpellsTeam1Writer = null;
		FileWriter cross_checkExcessSpellsTeam2Writer = null;
		FileWriter cross_checkGarbageCollectionWriter = null;
		FileWriter cross_checkGarbageCollectionTeam1Writer = null;
		FileWriter cross_checkGarbageCollectionTeam2Writer = null;
		FileWriter cross_checkLexicalAnalyzerWriter = null;
		FileWriter cross_checkLexicalAnalyzerTeam1Writer = null;
		FileWriter cross_checkLexicalAnalyzerTeam2Writer = null;
		FileWriter cross_checkDFAWriter = null;
		FileWriter cross_checkDFATeam1Writer = null;
		FileWriter cross_checkDFATeam2Writer = null;
		FileWriter cross_checkNFAWriter = null;
		FileWriter cross_checkNFATeam1Writer = null;
		FileWriter cross_checkNFATeam2Writer = null;
		FileWriter cross_checkRunTimeWriter = null;
		FileWriter cross_checkRunTimeTeam1Writer = null; 
		FileWriter cross_checkRunTimeTeam2Writer = null;
		FileWriter cross_checkReferencePointersWriter = null;
		FileWriter cross_checkReferencePointersTeam1Writer = null;
		FileWriter cross_checkReferencePointersTeam2Writer = null; 
		FileWriter cross_checkComputationSpellsWriter = null;
		FileWriter cross_checkComputationSpellsTeam1Writer = null; 
		FileWriter cross_checkComputationSpellsTeam2Writer = null;
		FileWriter cross_checkPathTraceWriter = null;
		FileWriter cross_checkPathTraceTeam1Writer = null;
		FileWriter cross_checkPathTraceTeam2Writer = null;
		FileWriter cross_checkTraceToStartWriter = null;
		FileWriter cross_checkTraceToStartTeam1Writer = null;
		FileWriter cross_checkTraceToStartTeam2Writer = null;
		FileWriter cross_checkSatisfierWriter = null;
		FileWriter cross_checkSatisfierTeam1Writer = null;
		FileWriter cross_checkSatisfierTeam2Writer = null;
		FileWriter cross_checkHistoryWriter = null;
		FileWriter cross_checkHistoryTeam1Writer = null;
		FileWriter cross_checkHistoryTeam2Writer = null;
		FileWriter cross_checkIncorporationConceptWriter = null;
		FileWriter cross_checkIncorporationConceptTeam1Writer = null;
		FileWriter cross_checkIncorporationConceptTeam2Writer = null;
		FileWriter cross_checkCheckPointWriter = null;
		FileWriter cross_checkCheckPointTeam1Writer = null;
		FileWriter cross_checkCheckPointTeam2Writer= null;
		FileWriter cross_checkCompletionTimeWriter = null;
		FileWriter cross_checkCompletionTeam1Writer = null;
		FileWriter cross_checkCompletionTeam2Writer = null;
		FileWriter cross_checkContributionalEstimateWriter = null;
		FileWriter cross_checkContributionalEstimateTeam1Writer = null;
		FileWriter cross_checkContributionalEstimateTeam2Writer = null;
		FileWriter cross_checkAudienceWriter = null;
		FileWriter cross_checkAudienceTeam1Writer = null;
		FileWriter cross_checkAudienceTeam2Writer = null;
		FileWriter cross_checkModeOfOperationsWriter = null;
		FileWriter cross_checkModeOfOperationsTeam1Writer = null; 
		FileWriter cross_checkModeOfOperationsTeam2Writer = null;
		FileWriter cross_checkExtractDataWriter = null;
		FileWriter cross_checkExtractDataTeam1Writer = null;
		FileWriter cross_checkExtractDataTeam2Writer = null;
		FileWriter cross_checkLoggerWriter = null;
		FileWriter cross_checkLoggerTeam1Writer = null;
		FileWriter cross_checkLoggerTeam2Writer = null;
		FileWriter cross_checkEventOccurrenceWriter = null;
		FileWriter cross_checkEventOccurrenceTeam1Writer = null;
		FileWriter cross_checkEventOccurrenceTeam2Writer = null;

		int cross_check = Cross_Check.get_current_number(); 
		int size = 0;
		System.out.println("PLAYER ASSOCIATION TO SCHOOL SIZE: " + playerAssociationToSchool.size()); 

		try {
			if(playerAssociationToSchool.size() == 2) {
				CrossCheckPrGraphTeam1MemberWriter.get_file_writer(cross_check, 1); 
				CrossCheckPrGraphTeam1MemberWriter.file_writers[0].write(""); 
				CrossCheckPrFactsTeam1MemberWriter.get_file_writer(cross_check, 1);
				CrossCheckPrFactsTeam1MemberWriter.file_writers[0].write(""); 
				CrossCheckPrRulesTeam1MemberWriter.get_file_writer(cross_check, 1); 
				CrossCheckPrRulesTeam1MemberWriter.file_writers[0].write(""); 
				CrossCheckPrInterpretationsTeam1MemberWriter.get_file_writer(cross_check, 1); 
				CrossCheckPrInterpretationsTeam1MemberWriter.file_writers[0].write(""); 
				CrossCheckStaticLanguageTeam1MemberWriter.get_file_writer(cross_check, 1); 
				CrossCheckStaticLanguageTeam1MemberWriter.file_writers[0].write(""); 
				CrossCheckChangingLanguageTeam1MemberWriter.get_file_writer(cross_check, 1); 
				CrossCheckChangingLanguageTeam1MemberWriter.file_writers[0].write(""); 
			  CrossCheckStaticGrammarTeam1MemberWriter.get_file_writer(cross_check, 1); 
				CrossCheckStaticGrammarTeam1MemberWriter.file_writers[0].write(""); 
				CrossCheckChangingGrammarTeam1MemberWriter.get_file_writer(cross_check, 1); 
				CrossCheckChangingGrammarTeam1MemberWriter.file_writers[0].write(""); 
				CrossCheckGenerationTeam1MemberWriter.get_file_writer(cross_check, 1); 
				CrossCheckGenerationTeam1MemberWriter.file_writers[0].write(""); 
				CrossCheckOrderingPlacementsTeam1MemberWriter.get_file_writer(cross_check, 1);
				CrossCheckOrderingPlacementsTeam1MemberWriter.file_writers[0].write(""); 
				CrossCheckCombineTeam1MemberWriter.get_file_writer(cross_check, 1); 
				CrossCheckCombineTeam1MemberWriter.file_writers[0].write(""); 
				CrossCheckTeam1MemberSpellsWriter.get_file_writer(cross_check, 1); 
				CrossCheckTeam1MemberSpellsWriter.file_writers[0].write("");
				CrossCheckTacticalApproachTeam1MemberWriter.get_file_writer(cross_check, 1); 
				CrossCheckTacticalApproachTeam1MemberWriter.file_writers[0].write(""); 
				CrossCheckSelectionTeam1MemberSpellsWriter.get_file_writer(cross_check, 1); 
				CrossCheckSelectionTeam1MemberSpellsWriter.file_writers[0].write(""); 
				CrossCheckLeftOverTeam1MemberSpellsWriter.get_file_writer(cross_check, 1);
				CrossCheckLeftOverTeam1MemberSpellsWriter.file_writers[0].write(""); 
				CrossCheckDiscardTeam1MemberSpellsWriter.get_file_writer(cross_check, 1); 
				CrossCheckDiscardTeam1MemberSpellsWriter.file_writers[0].write(""); 
				CrossCheckGarbageCollectionTeam1MemberWriter.get_file_writer(cross_check, 1); 
				CrossCheckGarbageCollectionTeam1MemberWriter.file_writers[0].write(""); 
				CrossCheckLexicalAnalyzerTeam1MemberWriter.get_file_writer(cross_check, 1); 
				CrossCheckLexicalAnalyzerTeam1MemberWriter.file_writers[0].write(""); 
				CrossCheckDFATeam1MemberWriter.get_file_writer(cross_check, 1);
				CrossCheckDFATeam1MemberWriter.file_writers[0].write(""); 
				CrossCheckNFATeam1MemberWriter.get_file_writer(cross_check, 1);
				CrossCheckNFATeam1MemberWriter.file_writers[0].write(""); 
				CrossCheckRunTimeTeam1MemberWriter.get_file_writer(cross_check, 1); 
				CrossCheckRunTimeTeam1MemberWriter.file_writers[0].write("");
				CrossCheckReferencePointersTeam1MemberWriter.get_file_writer(cross_check, 1); 
				CrossCheckReferencePointersTeam1MemberWriter.file_writers[0].write(""); 
				CrossCheckOutputSpellsTeam1MemberWriter.get_file_writer(cross_check, 1); 
				CrossCheckOutputSpellsTeam1MemberWriter.file_writers[0].write(""); 
				CrossCheckPathTraceTeam1MemberWriter.get_file_writer(cross_check, 1);
				CrossCheckPathTraceTeam1MemberWriter.file_writers[0].write(""); 
				CrossCheckTraceToStartTeam1MemberWriter.get_file_writer(cross_check, 1); 
				CrossCheckTraceToStartTeam1MemberWriter.file_writers[0].write(""); 
				CrossCheckSatisfierTeam1MemberWriter.get_file_writer(cross_check, 1); 
				CrossCheckSatisfierTeam1MemberWriter.file_writers[0].write(""); 
				CrossCheckHistoryTeam1MemberWriter.get_file_writer(cross_check, 1); 
				CrossCheckHistoryTeam1MemberWriter.file_writers[0].write(""); 
				CrossCheckIncorporationConceptTeam1MemberWriter.get_file_writer(cross_check, 1); 
				CrossCheckIncorporationConceptTeam1MemberWriter.file_writers[0].write(""); 
				CrossCheckCheckPointTeam1MemberWriter.get_file_writer(cross_check, 1); 
				CrossCheckCheckPointTeam1MemberWriter.file_writers[0].write(""); 
				CrossCheckContributionalEstimateTeam1MemberWriter.get_file_writer(cross_check, 1); 
				CrossCheckContributionalEstimateTeam1MemberWriter.file_writers[0].write(""); 
				CrossCheckAudienceTeam1MemberWriter.get_file_writer(cross_check, 1); 
				CrossCheckAudienceTeam1MemberWriter.file_writers[0].write(""); 
				CrossCheckModeOfOperationsTeam1MemberWriter.get_file_writer(cross_check, 1); 
				CrossCheckModeOfOperationsTeam1MemberWriter.file_writers[0].write(""); 
				CrossCheckExtractDataTeam1MemberWriter.get_file_writer(cross_check, 1); 
				CrossCheckExtractDataTeam1MemberWriter.file_writers[0].write(""); 
				CrossCheckLoggerTeam1MemberWriter.get_file_writer(cross_check, 1); 
				CrossCheckLoggerTeam1MemberWriter.file_writers[0].write(""); 
				CrossCheckPrGraphTeam2MemberWriter.get_file_writer(cross_check, 1); 
				CrossCheckPrGraphTeam2MemberWriter.file_writers[0].write(""); 
				CrossCheckPrFactsTeam2MemberWriter.get_file_writer(cross_check, 1);
				CrossCheckPrFactsTeam2MemberWriter.file_writers[0].write(""); 
				CrossCheckPrRulesTeam2MemberWriter.get_file_writer(cross_check, 1); 
				CrossCheckPrRulesTeam2MemberWriter.file_writers[0].write(""); 
				CrossCheckPrInterpretationsTeam2MemberWriter.get_file_writer(cross_check, 1); 
				CrossCheckPrInterpretationsTeam2MemberWriter.file_writers[0].write(""); 
				CrossCheckStaticLanguageTeam2MemberWriter.get_file_writer(cross_check, 1); 
				CrossCheckStaticLanguageTeam2MemberWriter.file_writers[0].write(""); 
				CrossCheckChangingLanguageTeam2MemberWriter.get_file_writer(cross_check, 1); 
				CrossCheckChangingLanguageTeam2MemberWriter.file_writers[0].write(""); 
				CrossCheckStaticGrammarTeam2MemberWriter.get_file_writer(cross_check, 1); 
				CrossCheckStaticGrammarTeam2MemberWriter.file_writers[0].write(""); 
				CrossCheckChangingGrammarTeam2MemberWriter.get_file_writer(cross_check, 1); 
				CrossCheckChangingGrammarTeam2MemberWriter.file_writers[0].write(""); 
				CrossCheckGenerationTeam2MemberWriter.get_file_writer(cross_check, 1); 
				CrossCheckGenerationTeam2MemberWriter.file_writers[0].write(""); 
				CrossCheckOrderingPlacementsTeam2MemberWriter.get_file_writer(cross_check, 1);
				CrossCheckOrderingPlacementsTeam2MemberWriter.file_writers[0].write(""); 
				CrossCheckCombineTeam2MemberWriter.get_file_writer(cross_check, 1);
				CrossCheckCombineTeam2MemberWriter.file_writers[0].write(""); 
				CrossCheckTeam2MemberSpellsWriter.get_file_writer(cross_check, 1); 
				CrossCheckTeam2MemberSpellsWriter.file_writers[0].write(""); 
				CrossCheckTacticalApproachTeam2MemberWriter.get_file_writer(cross_check, 1); 
				CrossCheckTacticalApproachTeam2MemberWriter.file_writers[0].write(""); 
				CrossCheckSelectionTeam2MemberSpellsWriter.get_file_writer(cross_check, 1); 
				CrossCheckSelectionTeam2MemberSpellsWriter.file_writers[0].write(""); 
				CrossCheckLeftOverTeam2MemberSpellsWriter.get_file_writer(cross_check, 1); 
				CrossCheckLeftOverTeam2MemberSpellsWriter.file_writers[0].write("");
				CrossCheckDiscardTeam2MemberSpellsWriter.get_file_writer(cross_check, 1); 
				CrossCheckDiscardTeam2MemberSpellsWriter.file_writers[0].write(""); 
				CrossCheckGarbageCollectionTeam2MemberWriter.get_file_writer(cross_check, 1); 
				CrossCheckGarbageCollectionTeam2MemberWriter.file_writers[0].write(""); 
				CrossCheckLexicalAnalyzerTeam2MemberWriter.get_file_writer(cross_check, 1); 
				CrossCheckLexicalAnalyzerTeam2MemberWriter.file_writers[0].write(""); 
				CrossCheckDFATeam2MemberWriter.get_file_writer(cross_check, 1);
				CrossCheckDFATeam2MemberWriter.file_writers[0].write(""); 
				CrossCheckNFATeam2MemberWriter.get_file_writer(cross_check, 1);
				CrossCheckNFATeam2MemberWriter.file_writers[0].write(""); 
				CrossCheckRunTimeTeam2MemberWriter.get_file_writer(cross_check, 1); 
				CrossCheckRunTimeTeam2MemberWriter.file_writers[0].write("");
				CrossCheckReferencePointersTeam2MemberWriter.get_file_writer(cross_check, 1); 
				CrossCheckReferencePointersTeam2MemberWriter.file_writers[0].write(""); 
				CrossCheckOutputSpellsTeam2MemberWriter.get_file_writer(cross_check, 1); 
				CrossCheckOutputSpellsTeam2MemberWriter.file_writers[0].write(""); 
				CrossCheckPathTraceTeam2MemberWriter.get_file_writer(cross_check, 1);
				CrossCheckPathTraceTeam2MemberWriter.file_writers[0].write(""); 
				CrossCheckTraceToStartTeam2MemberWriter.get_file_writer(cross_check, 1); 
				CrossCheckTraceToStartTeam2MemberWriter.file_writers[0].write(""); 
				CrossCheckSatisfierTeam2MemberWriter.get_file_writer(cross_check, 1); 
				CrossCheckSatisfierTeam2MemberWriter.file_writers[0].write(""); 
				CrossCheckHistoryTeam2MemberWriter.get_file_writer(cross_check, 1); 
				CrossCheckHistoryTeam2MemberWriter.file_writers[0].write(""); 
				CrossCheckIncorporationConceptTeam2MemberWriter.get_file_writer(cross_check, 1); 
				CrossCheckIncorporationConceptTeam2MemberWriter.file_writers[0].write(""); 
				InterrogativeWordCheckPointTeam2MemberWriter.get_file_writer(cross_check, 1); 
				InterrogativeWordCheckPointTeam2MemberWriter.file_writers[0].write(""); 
				CrossCheckContributionalEstimateTeam2MemberWriter.get_file_writer(cross_check, 1); 
				CrossCheckContributionalEstimateTeam2MemberWriter.file_writers[0].write(""); 
				CrossCheckAudienceTeam2MemberWriter.get_file_writer(cross_check, 1); 
				CrossCheckAudienceTeam2MemberWriter.file_writers[0].write(""); 
				CrossCheckModeOfOperationsTeam2MemberWriter.get_file_writer(cross_check, 1); 
				CrossCheckModeOfOperationsTeam2MemberWriter.file_writers[0].write(""); 
				CrossCheckExtractDataTeam2MemberWriter.get_file_writer(cross_check, 1); 
				CrossCheckExtractDataTeam2MemberWriter.file_writers[0].write(""); 
				CrossCheckLoggerTeam2MemberWriter.get_file_writer(cross_check, 1); 
				CrossCheckLoggerTeam2MemberWriter.file_writers[0].write(""); 
				size = 1; 
			}
			else if(playerAssociationToSchool.size() == 4) {
				CrossCheckTeam1MemberSpellsWriter.get_file_writer(cross_check, 1); 
				CrossCheckTeam1MemberSpellsWriter.file_writers[0].write(""); 
				CrossCheckTeam1MemberSpellsWriter.get_file_writer(cross_check, 2); 
				CrossCheckTeam1MemberSpellsWriter.file_writers[1].write(""); 
				CrossCheckTeam2MemberSpellsWriter.get_file_writer(cross_check, 1);
				CrossCheckTeam2MemberSpellsWriter.file_writers[0].write(""); 
				CrossCheckTeam2MemberSpellsWriter.get_file_writer(cross_check, 2); 
				CrossCheckTeam2MemberSpellsWriter.file_writers[1].write(""); 
				size = 4; 
			}
			else if(playerAssociationToSchool.size() == 6) {
				CrossCheckTeam1MemberSpellsWriter.get_file_writer(cross_check, 1); 
				CrossCheckTeam1MemberSpellsWriter.file_writers[0].write(""); 
				CrossCheckTeam1MemberSpellsWriter.get_file_writer(cross_check, 2); 
				CrossCheckTeam1MemberSpellsWriter.file_writers[1].write(""); 
				CrossCheckTeam1MemberSpellsWriter.get_file_writer(cross_check, 3); 
				CrossCheckTeam1MemberSpellsWriter.file_writers[2].write(""); 
				CrossCheckTeam2MemberSpellsWriter.get_file_writer(cross_check, 1); 
				CrossCheckTeam2MemberSpellsWriter.file_writers[0].write(""); 
				CrossCheckTeam2MemberSpellsWriter.get_file_writer(cross_check, 2); 
				CrossCheckTeam2MemberSpellsWriter.file_writers[1].write(""); 
				CrossCheckTeam2MemberSpellsWriter.get_file_writer(cross_check, 3); 
				CrossCheckTeam2MemberSpellsWriter.file_writers[2].write(""); 
				size = 6; 
			}
			else if(playerAssociationToSchool.size() == 8) {
				CrossCheckTeam1MemberSpellsWriter.get_file_writer(cross_check, 1); 
				CrossCheckTeam1MemberSpellsWriter.file_writers[0].write(""); 
				CrossCheckTeam1MemberSpellsWriter.get_file_writer(cross_check, 2); 
				CrossCheckTeam1MemberSpellsWriter.file_writers[1].write(""); 
				CrossCheckTeam1MemberSpellsWriter.get_file_writer(cross_check, 3); 
				CrossCheckTeam1MemberSpellsWriter.file_writers[2].write(""); 
				CrossCheckTeam1MemberSpellsWriter.get_file_writer(cross_check, 4); 
				CrossCheckTeam1MemberSpellsWriter.file_writers[3].write(""); 
				CrossCheckTeam2MemberSpellsWriter.get_file_writer(cross_check, 1); 
				CrossCheckTeam2MemberSpellsWriter.file_writers[0].write(""); 
				CrossCheckTeam2MemberSpellsWriter.get_file_writer(cross_check, 2); 
				CrossCheckTeam2MemberSpellsWriter.file_writers[1].write(""); 
				CrossCheckTeam2MemberSpellsWriter.get_file_writer(cross_check, 3); 
				CrossCheckTeam2MemberSpellsWriter.file_writers[2].write(""); 
				CrossCheckTeam2MemberSpellsWriter.get_file_writer(cross_check, 4); 
				CrossCheckTeam2MemberSpellsWriter.file_writers[3].write(""); 
				size = 8; 
			}
			productCombineWriter = InterrogativeWordCombineWriter.get_file_writer();
			productCombineWriter.write(""); 
			productcross_checkBycross_checkWriter = CrossCheckByCrossCheckWriter.get_file_writer();
			productcross_checkBycross_checkWriter.write(""); 
			productExcessSpellsWriter = InterrogativeWordDiscardSpellsWriter.get_file_writer();
			productExcessSpellsWriter.write(""); 
			productExcessSpellsTeam1Writer = InterrogativeWordDiscardSpellsTeam1Writer.get_file_writer();
			productExcessSpellsTeam1Writer.write(""); 
			productExcessSpellsTeam2Writer = InterrogativeWordDiscardSpellsTeam2Writer.get_file_writer();
			productExcessSpellsTeam2Writer.write("");
			productRemainingSpellsWriter = InterrogativeWordLeftOverSpellsWriter.get_file_writer();
			productRemainingSpellsWriter.write(""); 
			productRemainingSpellsTeam1Writer = InterrogativeWordLeftOverSpellsTeam1Writer.get_file_writer();
			productRemainingSpellsTeam1Writer.write(""); 
			productRemainingSpellsTeam2Writer = InterrogativeWordLeftOverSpellsTeam2Writer.get_file_writer();
			productRemainingSpellsTeam2Writer.write(""); 
			productSelectionLineWriter = InterrogativeWordSelectionWriter.get_file_writer(); 
			productSelectionLineWriter.write(""); 
			productSelectionLineTeam1Writer = InterrogativeWordSelectionTeam1Writer.get_file_writer();
			productSelectionLineTeam1Writer.write(""); 
			productSelectionLineTeam2Writer = InterrogativeWordSelectionTeam2Writer.get_file_writer();
			productSelectionLineTeam2Writer.write(""); 
			cross_checkPrGraphWriter = CrossCheckPrGraphWriter.get_file_writer(cross_check); 
			cross_checkPrGraphWriter.write(""); 
			cross_checkPrGraphTeam1Writer = CrossCheckPrGraphTeam1Writer.get_file_writer(cross_check); 
			cross_checkPrGraphTeam1Writer.write(""); 
			cross_checkPrGraphTeam2Writer = CrossCheckPrGraphTeam2Writer.get_file_writer(cross_check); 
			cross_checkPrGraphTeam2Writer.write(""); 
			cross_checkPrFactsWriter = CrossCheckPrFactsWriter.get_file_writer(cross_check); 
			cross_checkPrFactsWriter.write(""); 
			cross_checkPrFactsTeam1Writer = CrossCheckPrFactsTeam1Writer.get_file_writer(cross_check); 
			cross_checkPrFactsTeam1Writer.write(""); 
			cross_checkPrFactsTeam2Writer = CrossCheckPrFactsTeam2Writer.get_file_writer(cross_check); 
			cross_checkPrFactsTeam2Writer.write(""); 
			cross_checkPrRulesWriter = CrossCheckPrRulesWriter.get_file_writer(cross_check); 
			cross_checkPrRulesWriter.write(""); 
			cross_checkPrRulesTeam1Writer = CrossCheckPrRulesTeam1Writer.get_file_writer(cross_check); 
			cross_checkPrRulesTeam1Writer.write(""); 
			cross_checkPrRulesTeam2Writer = CrossCheckPrRulesTeam2Writer.get_file_writer(cross_check); 
			cross_checkPrRulesTeam2Writer.write(""); 
			cross_checkPrInterpretationsWriter = CrossCheckPrInterpretationsWriter.get_file_writer(cross_check); 
			cross_checkPrInterpretationsWriter.write(""); 
			cross_checkPrInterpretationsTeam1Writer = CrossCheckPrInterpretationsTeam1Writer.get_file_writer(cross_check); 
			cross_checkPrInterpretationsTeam1Writer.write(""); 
			cross_checkPrInterpretationsTeam2Writer = CrossCheckPrInterpretationsTeam2Writer.get_file_writer(cross_check); 
			cross_checkPrInterpretationsTeam2Writer.write(""); 
			cross_checkStaticLanguageWriter = CrossCheckStaticLanguageWriter.get_file_writer(cross_check); 
			cross_checkStaticLanguageWriter.write(""); 
			cross_checkStaticLanguageTeam1Writer = CrossCheckStaticLanguageTeam1Writer.get_file_writer(cross_check); 
			cross_checkStaticLanguageTeam1Writer.write(""); 
			cross_checkStaticLanguageTeam2Writer = CrossCheckStaticLanguageTeam2Writer.get_file_writer(cross_check); 
			cross_checkStaticLanguageTeam2Writer.write(""); 
			cross_checkChangingLanguageWriter = CrossCheckChangingLanguageWriter.get_file_writer(cross_check);
			cross_checkChangingLanguageWriter.write(""); 
			cross_checkChangingLanguageTeam1Writer = CrossCheckChangingLanguageTeam1Writer.get_file_writer(cross_check); 
			cross_checkChangingLanguageTeam1Writer.write(""); 
			cross_checkChangingLanguageTeam2Writer = CrossCheckChangingLanguageTeam2Writer.get_file_writer(cross_check); 
			cross_checkChangingLanguageTeam2Writer.write(""); 
			cross_checkStaticGrammarWriter = CrossCheckStaticGrammarWriter.get_file_writer(cross_check); 
			cross_checkStaticGrammarWriter.write(""); 
			cross_checkStaticGrammarTeam1Writer = CrossCheckStaticGrammarTeam1Writer.get_file_writer(cross_check);
			cross_checkStaticGrammarTeam1Writer.write(""); 
			cross_checkStaticGrammarTeam2Writer = CrossCheckStaticGrammarTeam2Writer.get_file_writer(cross_check); 
			cross_checkStaticGrammarTeam2Writer.write(""); 
			cross_checkChangingGrammarWriter = CrossCheckChangingGrammarWriter.get_file_writer(cross_check); 
			cross_checkChangingGrammarWriter.write(""); 
			cross_checkChangingGrammarTeam1Writer = CrossCheckChangingGrammarTeam1Writer.get_file_writer(cross_check); 
			cross_checkChangingGrammarTeam1Writer.write(""); 
			cross_checkChangingGrammarTeam2Writer = CrossCheckChangingGrammarTeam2Writer.get_file_writer(cross_check); 
			cross_checkChangingGrammarTeam2Writer.write(""); 
			cross_checkGenerationWriter = CrossCheckGenerationWriter.get_file_writer(cross_check);
			cross_checkGenerationWriter.write(""); 
			cross_checkGenerationTeam1Writer = CrossCheckGenerationTeam1Writer.get_file_writer(cross_check); 
			cross_checkGenerationTeam1Writer.write(""); 
			cross_checkGenerationTeam2Writer = CrossCheckGenerationTeam2Writer.get_file_writer(cross_check); 
			cross_checkGenerationTeam2Writer.write(""); 
			cross_checkOrderingPlacementsWriter = CrossCheckOrderingPlacementsWriter.get_file_writer(cross_check); 
			cross_checkOrderingPlacementsWriter.write(""); 
			cross_checkOrderingPlacementsTeam1Writer = CrossCheckOrderingPlacementsTeam1Writer.get_file_writer(cross_check); 
			cross_checkOrderingPlacementsTeam1Writer.write(""); 
			cross_checkOrderingPlacementsTeam2Writer = CrossCheckOrderingPlacementsTeam2Writer.get_file_writer(cross_check); 
			cross_checkOrderingPlacementsTeam2Writer.write(""); 
			cross_checkCombineWriter = CrossCheckCombineWriter.get_file_writer(cross_check); 
			cross_checkCombineWriter.write(""); 
			cross_checkTeam1SpellsWriter = CrossCheckTeam1SpellsWriter.get_file_writer(cross_check); 
			cross_checkTeam1SpellsWriter.write(""); 
			cross_checkTeam2SpellsWriter = CrossCheckTeam2SpellsWriter.get_file_writer(cross_check); 
			cross_checkTeam2SpellsWriter.write(""); 
			cross_checkDefaultWriter = CrossCheckOfSpellsWriter.get_file_writer(cross_check);
			cross_checkDefaultWriter.write(""); 
			cross_checkTacticalApproachWriter = CrossCheckTacticalApproachWriter.get_file_writer(cross_check);
			cross_checkTacticalApproachWriter.write(""); 
			cross_checkTacticalApproachTeam1Writer = CrossCheckTacticalApproachTeam1Writer.get_file_writer(cross_check);  
			cross_checkTacticalApproachTeam1Writer.write(""); 
			cross_checkTacticalApproachTeam2Writer = CrossCheckTacticalApproachTeam2Writer.get_file_writer(cross_check); 
			cross_checkTacticalApproachTeam2Writer.write(""); 
			cross_checkSelectionLineWriter = CrossCheckSelectionWriter.get_file_writer(cross_check); 
			cross_checkSelectionLineWriter.write(""); 
			cross_checkSelectionLineTeam1Writer = CrossCheckSelectionTeam1Writer.get_file_writer(cross_check); 
			cross_checkSelectionLineTeam1Writer.write(""); 
			cross_checkSelectionLineTeam2Writer = CrossCheckSelectionTeam2Writer.get_file_writer(cross_check); 
			cross_checkSelectionLineTeam2Writer.write(""); 
			cross_checkRemainingSpellsWriter = CrossCheckLeftOverSpellsWriter.get_file_writer(cross_check);
			cross_checkRemainingSpellsWriter.write(""); 
			cross_checkRemainingTeam1SpellsWriter = CrossCheckLeftOverSpellsTeam1Writer.get_file_writer(cross_check); 
			cross_checkRemainingTeam1SpellsWriter.write(""); 
			cross_checkRemainingTeam2SpellsWriter = CrossCheckLeftOverSpellsTeam2Writer.get_file_writer(cross_check); 
			cross_checkRemainingTeam2SpellsWriter.write(""); 
			cross_checkExcessSpellsWriter = CrossCheckDiscardSpellsWriter.get_file_writer(cross_check); 
			cross_checkExcessSpellsWriter.write(""); 
			cross_checkExcessSpellsTeam1Writer = CrossCheckDiscardSpellsTeam1Writer.get_file_writer(cross_check); 
			cross_checkExcessSpellsTeam1Writer.write(""); 
			cross_checkExcessSpellsTeam2Writer = CrossCheckDiscardSpellsTeam2Writer.get_file_writer(cross_check); 
			cross_checkExcessSpellsTeam2Writer.write(""); 
			cross_checkGarbageCollectionWriter = CrossCheckGarbageCollectionWriter.get_file_writer(cross_check); 
			cross_checkGarbageCollectionWriter.write(""); 
			cross_checkGarbageCollectionTeam1Writer = CrossCheckGarbageCollectionTeam1Writer.get_file_writer(cross_check); 
			cross_checkGarbageCollectionTeam1Writer.write(""); 
			cross_checkGarbageCollectionTeam2Writer = CrossCheckGarbageCollectionTeam2Writer.get_file_writer(cross_check); 
			cross_checkGarbageCollectionTeam2Writer.write(""); 
			cross_checkLexicalAnalyzerWriter = CrossCheckLexicalAnalyzerWriter.get_file_writer(cross_check); 
			cross_checkLexicalAnalyzerWriter.write(""); 
			cross_checkLexicalAnalyzerTeam1Writer = CrossCheckLexicalAnalyzerTeam1Writer.get_file_writer(cross_check); 
			cross_checkLexicalAnalyzerTeam1Writer.write(""); 
			cross_checkLexicalAnalyzerTeam2Writer = CrossCheckLexicalAnalyzerTeam2Writer.get_file_writer(cross_check); 
			cross_checkLexicalAnalyzerTeam2Writer.write(""); 
			cross_checkDFAWriter = CrossCheckDFAWriter.get_file_writer(cross_check); 
			cross_checkDFAWriter.write(""); 
			cross_checkDFATeam1Writer = CrossCheckDFATeam1Writer.get_file_writer(cross_check); 
			cross_checkDFATeam1Writer.write(""); 
			cross_checkDFATeam2Writer = CrossCheckDFATeam2Writer.get_file_writer(cross_check); 
			cross_checkDFATeam2Writer.write("");
			cross_checkNFAWriter = CrossCheckNFAWriter.get_file_writer(cross_check); 
			cross_checkNFAWriter.write(""); 
			cross_checkNFATeam1Writer = CrossCheckNFATeam1Writer.get_file_writer(cross_check); 
			cross_checkNFATeam1Writer.write(""); 
			cross_checkNFATeam2Writer = CrossCheckNFATeam2Writer.get_file_writer(cross_check); 
			cross_checkNFATeam2Writer.write(""); 
			cross_checkRunTimeWriter = CrossCheckRunTimeWriter.get_file_writer(cross_check); 
			cross_checkRunTimeWriter.write(""); 
			cross_checkRunTimeTeam1Writer = CrossCheckRunTimeTeam1Writer.get_file_writer(cross_check); 
			cross_checkRunTimeTeam1Writer.write(""); 
			cross_checkRunTimeTeam2Writer = CrossCheckRunTimeTeam2Writer.get_file_writer(cross_check); 
			cross_checkRunTimeTeam2Writer.write(""); 
			cross_checkReferencePointersWriter = CrossCheckReferencePointersWriter.get_file_writer(cross_check); 
			cross_checkReferencePointersWriter.write(""); 
			cross_checkReferencePointersTeam1Writer = CrossCheckReferencePointersTeam1Writer.get_file_writer(cross_check); 
			cross_checkReferencePointersTeam1Writer.write(""); 
			cross_checkReferencePointersTeam2Writer = CrossCheckReferencePointersTeam2Writer.get_file_writer(cross_check); 
			cross_checkReferencePointersTeam2Writer.write(""); 
			cross_checkComputationSpellsWriter = CrossCheckOutputSpellsWriter.get_file_writer(cross_check); 
			cross_checkComputationSpellsWriter.write(""); 
			cross_checkComputationSpellsTeam1Writer = CrossCheckOutputSpellsTeam1Writer.get_file_writer(cross_check); 
			cross_checkComputationSpellsTeam1Writer.write(""); 
			cross_checkComputationSpellsTeam2Writer = CrossCheckOutputSpellsTeam2Writer.get_file_writer(cross_check); 
			cross_checkComputationSpellsTeam2Writer.write(""); 
			cross_checkPathTraceWriter = CrossCheckPathTraceWriter.get_file_writer(cross_check); 
			cross_checkPathTraceWriter.write(""); 
			cross_checkPathTraceTeam1Writer = CrossCheckPathTraceTeam1Writer.get_file_writer(cross_check); 
			cross_checkPathTraceTeam1Writer.write(""); 
			cross_checkPathTraceTeam2Writer = CrossCheckPathTraceTeam2Writer.get_file_writer(cross_check); 
			cross_checkPathTraceTeam2Writer.write(""); 
			cross_checkTraceToStartWriter = CrossCheckTraceToStartWriter.get_file_writer(cross_check); 
			cross_checkTraceToStartWriter.write(""); 
			cross_checkTraceToStartTeam1Writer = CrossCheckTraceToStartTeam1Writer.get_file_writer(cross_check); 
			cross_checkTraceToStartTeam1Writer.write(""); 
			cross_checkTraceToStartTeam2Writer = CrossCheckTraceToStartTeam2Writer.get_file_writer(cross_check); 
			cross_checkTraceToStartTeam2Writer.write(""); 
			cross_checkSatisfierWriter = CrossCheckSatisfierWriter.get_file_writer(cross_check); 
			cross_checkSatisfierWriter.write(""); 
			cross_checkSatisfierTeam1Writer = CrossCheckSatisfierTeam1Writer.get_file_writer(cross_check); 
			cross_checkSatisfierTeam1Writer.write(""); 
			cross_checkSatisfierTeam2Writer = CrossCheckSatisfierTeam2Writer.get_file_writer(cross_check); 
			cross_checkSatisfierTeam2Writer.write(""); 
			cross_checkHistoryWriter = CrossCheckHistoryWriter.get_file_writer(cross_check); 
			cross_checkHistoryWriter.write(""); 
			cross_checkHistoryTeam1Writer = CrossCheckHistoryTeam1Writer.get_file_writer(cross_check); 
			cross_checkHistoryTeam1Writer.write(""); 
			cross_checkHistoryTeam2Writer = CrossCheckHistoryTeam2Writer.get_file_writer(cross_check); 
			cross_checkHistoryTeam2Writer.write(""); 
			cross_checkIncorporationConceptWriter = CrossCheckIncorporationConceptTeam1Writer.get_file_writer(cross_check); 
			cross_checkIncorporationConceptWriter.write(""); 
			cross_checkIncorporationConceptTeam1Writer = CrossCheckIncorporationConceptTeam1Writer.get_file_writer(cross_check); 
			cross_checkIncorporationConceptTeam1Writer.write(""); 
			cross_checkIncorporationConceptTeam2Writer = CrossCheckIncorporationConceptTeam2Writer.get_file_writer(cross_check); 
			cross_checkIncorporationConceptTeam2Writer.write(""); 
			cross_checkCheckPointWriter = CrossCheckCheckPointWriter.get_file_writer(cross_check); 
			cross_checkCheckPointWriter.write(""); 
			cross_checkCheckPointTeam1Writer = CrossCheckCheckPointTeam1Writer.get_file_writer(cross_check); 
			cross_checkCheckPointTeam1Writer.write(""); 
			cross_checkCheckPointTeam2Writer = CrossCheckCheckPointTeam2Writer.get_file_writer(cross_check); 
			cross_checkCheckPointTeam2Writer.write(""); 
			cross_checkContributionalEstimateWriter = CrossCheckContributionalEstimateWriter.get_file_writer(cross_check);
			cross_checkContributionalEstimateWriter.write(""); 
			cross_checkContributionalEstimateTeam1Writer = CrossCheckContributionalEstimateTeam1Writer.get_file_writer(cross_check); 
			cross_checkContributionalEstimateTeam1Writer.write(""); 
			cross_checkContributionalEstimateTeam2Writer = CrossCheckContributionalEstimateTeam2Writer.get_file_writer(cross_check); 
			cross_checkContributionalEstimateTeam2Writer.write(""); 
			cross_checkAudienceWriter = CrossCheckAudienceWriter.get_file_writer(cross_check); 
			cross_checkAudienceWriter.write(""); 
			cross_checkAudienceTeam1Writer = CrossCheckAudienceTeam1Writer.get_file_writer(cross_check); 
			cross_checkAudienceTeam1Writer.write(""); 
			cross_checkAudienceTeam2Writer = CrossCheckAudienceTeam2Writer.get_file_writer(cross_check);
			cross_checkAudienceTeam2Writer.write(""); 
			cross_checkModeOfOperationsWriter = CrossCheckModeOfOperationsWriter.get_file_writer(cross_check);
			cross_checkModeOfOperationsWriter.write(""); 
			cross_checkModeOfOperationsTeam1Writer = CrossCheckModeOfOperationsTeam1Writer.get_file_writer(cross_check);
			cross_checkModeOfOperationsTeam1Writer.write(""); 
			cross_checkModeOfOperationsTeam2Writer = CrossCheckModeOfOperationsTeam2Writer.get_file_writer(cross_check); 
			cross_checkModeOfOperationsTeam2Writer.write(""); 
			cross_checkExtractDataWriter = CrossCheckExtractDataWriter.get_file_writer(cross_check);
			cross_checkExtractDataWriter.write("");
			cross_checkExtractDataTeam1Writer = CrossCheckExtractDataTeam1Writer.get_file_writer(cross_check);
			cross_checkExtractDataTeam1Writer.write("");
			cross_checkExtractDataTeam2Writer = CrossCheckExtractDataTeam2Writer.get_file_writer(cross_check);
			cross_checkExtractDataTeam2Writer.write("");
			cross_checkLoggerWriter = CrossCheckLoggerWriter.get_file_writer(cross_check);
			cross_checkLoggerWriter.write("");
			cross_checkLoggerTeam1Writer = CrossCheckLoggerTeam1Writer.get_file_writer(cross_check);
			cross_checkLoggerTeam1Writer.write(""); 
			cross_checkLoggerTeam2Writer = CrossCheckLoggerTeam2Writer.get_file_writer(cross_check); 
			cross_checkLoggerTeam2Writer.write(""); 	
		} catch (Exception e) {
			if(playerAssociationToSchool.size() == 2) {
				CrossCheckStaticLanguageTeam1MemberWriter.setWriterCreated(false);
				CrossCheckStaticLanguageTeam1MemberWriter.get_file_writer(cross_check, 1); 
				CrossCheckChangingLanguageTeam1MemberWriter.setWriterCreated(false); 
				CrossCheckChangingLanguageTeam1MemberWriter.get_file_writer(cross_check, 1); 
				CrossCheckChangingLanguageTeam1MemberWriter.file_writers[0].write(""); 
				CrossCheckStaticGrammarTeam1MemberWriter.setWriterCreated(false); 
			  CrossCheckStaticGrammarTeam1MemberWriter.get_file_writer(cross_check, 1); 
				CrossCheckChangingGrammarTeam1MemberWriter.setWriterCreated(false);
				CrossCheckChangingGrammarTeam1MemberWriter.get_file_writer(cross_check, 1); 
				CrossCheckGenerationTeam1MemberWriter.setWriterCreated(false); 
				CrossCheckGenerationTeam1MemberWriter.get_file_writer(cross_check, 1); 
				CrossCheckOrderingPlacementsTeam1MemberWriter.setWriterCreated(false);
				CrossCheckOrderingPlacementsTeam1MemberWriter.get_file_writer(cross_check, 1); 
				CrossCheckCombineTeam1MemberWriter.setWriterCreated(false);
				CrossCheckCombineTeam1MemberWriter.get_file_writer(cross_check, 1);
				CrossCheckTeam1MemberSpellsWriter.setWriterCreated(false); 
				CrossCheckTeam1MemberSpellsWriter.get_file_writer(cross_check, 1); 
				CrossCheckTacticalApproachTeam1MemberWriter.setWriterCreated(false); 
				CrossCheckTacticalApproachTeam1MemberWriter.get_file_writer(cross_check, 1); 
				CrossCheckSelectionTeam1MemberSpellsWriter.setWriterCreated(false); 
				CrossCheckSelectionTeam1MemberSpellsWriter.get_file_writer(cross_check, 1); 
				CrossCheckLeftOverTeam1MemberSpellsWriter.setWriterCreated(false); 
				CrossCheckLeftOverTeam1MemberSpellsWriter.get_file_writer(cross_check, 1);
				CrossCheckDiscardTeam1MemberSpellsWriter.setWriterCreated(false);
				CrossCheckDiscardTeam1MemberSpellsWriter.get_file_writer(cross_check, 1);
				CrossCheckGarbageCollectionTeam1MemberWriter.setWriterCreated(false); 
				CrossCheckGarbageCollectionTeam1MemberWriter.get_file_writer(cross_check, 1);
				CrossCheckLexicalAnalyzerTeam1MemberWriter.setWriterCreated(false); 
				CrossCheckLexicalAnalyzerTeam1MemberWriter.get_file_writer(cross_check, 1); 
				CrossCheckGarbageCollectionTeam1MemberWriter.setWriterCreated(false); 
				CrossCheckGarbageCollectionTeam1MemberWriter.get_file_writer(cross_check, 1); 
				CrossCheckLexicalAnalyzerTeam1MemberWriter.setWriterCreated(false); 
				CrossCheckLexicalAnalyzerTeam1MemberWriter.get_file_writer(cross_check, 1); 
				CrossCheckDFATeam1MemberWriter.setWriterCreated(false);
				CrossCheckDFATeam1MemberWriter.get_file_writer(cross_check, 1);
				CrossCheckNFATeam1MemberWriter.setWriterCreated(false);
				CrossCheckNFATeam1MemberWriter.get_file_writer(cross_check, 1);
				CrossCheckRunTimeTeam1MemberWriter.setWriterCreated(false); 
				CrossCheckRunTimeTeam1MemberWriter.get_file_writer(cross_check, 1); 
				CrossCheckReferencePointersTeam1MemberWriter.setWriterCreated(false); 
				CrossCheckReferencePointersTeam1MemberWriter.get_file_writer(cross_check, 1); 
				CrossCheckOutputSpellsTeam1MemberWriter.setWriterCreated(false);
				CrossCheckOutputSpellsTeam1MemberWriter.get_file_writer(cross_check, 1); 
				CrossCheckPathTraceTeam1MemberWriter.setWriterCreated(false);
				CrossCheckPathTraceTeam1MemberWriter.get_file_writer(cross_check, 1);
				CrossCheckTraceToStartTeam1MemberWriter.setWriterCreated(false); 
				CrossCheckTraceToStartTeam1MemberWriter.get_file_writer(cross_check, 1); 
				CrossCheckSatisfierTeam1MemberWriter.setWriterCreated(false);
				CrossCheckSatisfierTeam1MemberWriter.get_file_writer(cross_check, 1); 
				CrossCheckHistoryTeam1MemberWriter.setWriterCreated(false);
				CrossCheckHistoryTeam1MemberWriter.get_file_writer(cross_check, 1); 
				CrossCheckIncorporationConceptTeam1MemberWriter.setWriterCreated(false);
				CrossCheckIncorporationConceptTeam1MemberWriter.get_file_writer(cross_check, 1); 
				CrossCheckCheckPointTeam1MemberWriter.setWriterCreated(false);
				CrossCheckCheckPointTeam1MemberWriter.get_file_writer(cross_check, 1); 
				CrossCheckContributionalEstimateTeam1MemberWriter.setWriterCreated(false);
				CrossCheckContributionalEstimateTeam1MemberWriter.get_file_writer(cross_check, 1); 
				CrossCheckAudienceTeam1MemberWriter.setWriterCreated(false);
				CrossCheckAudienceTeam1MemberWriter.get_file_writer(cross_check, 1); 
				CrossCheckModeOfOperationsTeam1MemberWriter.setWriterCreated(false);
				CrossCheckModeOfOperationsTeam1MemberWriter.get_file_writer(cross_check, 1); 
				CrossCheckExtractDataTeam1MemberWriter.setWriterCreated(false);
				CrossCheckExtractDataTeam1MemberWriter.get_file_writer(cross_check, 1); 
				CrossCheckLoggerTeam1MemberWriter.setWriterCreated(false);
				CrossCheckLoggerTeam1MemberWriter.get_file_writer(cross_check, 1); 
				CrossCheckPrGraphTeam2MemberWriter.setWriterCreated(false);
				CrossCheckPrGraphTeam2MemberWriter.get_file_writer(cross_check, 1);
				CrossCheckPrFactsTeam2MemberWriter.setWriterCreated(false);
				CrossCheckPrFactsTeam2MemberWriter.get_file_writer(cross_check, 1);
				CrossCheckPrRulesTeam2MemberWriter.setWriterCreated(false);
				CrossCheckPrRulesTeam2MemberWriter.get_file_writer(cross_check, 1); 
				CrossCheckPrInterpretationsTeam2MemberWriter.setWriterCreated(false);
				CrossCheckPrInterpretationsTeam2MemberWriter.get_file_writer(cross_check, 1); 
				CrossCheckStaticLanguageTeam2MemberWriter.setWriterCreated(false);
				CrossCheckStaticLanguageTeam2MemberWriter.get_file_writer(cross_check, 1); 
				CrossCheckChangingLanguageTeam2MemberWriter.setWriterCreated(false);
				CrossCheckChangingLanguageTeam2MemberWriter.get_file_writer(cross_check, 1); 
				CrossCheckStaticGrammarTeam2MemberWriter.setWriterCreated(false);
				CrossCheckStaticGrammarTeam2MemberWriter.get_file_writer(cross_check, 1); 
				CrossCheckChangingGrammarTeam2MemberWriter.setWriterCreated(false);
				CrossCheckChangingGrammarTeam2MemberWriter.get_file_writer(cross_check, 1); 
				CrossCheckGenerationTeam2MemberWriter.setWriterCreated(false);
				CrossCheckGenerationTeam2MemberWriter.get_file_writer(cross_check, 1); 
				CrossCheckOrderingPlacementsTeam2MemberWriter.setWriterCreated(false);
				CrossCheckOrderingPlacementsTeam2MemberWriter.get_file_writer(cross_check, 1);
				CrossCheckCombineTeam2MemberWriter.setWriterCreated(false); 
				CrossCheckCombineTeam2MemberWriter.get_file_writer(cross_check, 1); 
				CrossCheckTeam2MemberSpellsWriter.setWriterCreated(false);
				CrossCheckTeam2MemberSpellsWriter.get_file_writer(cross_check, 1); 
				CrossCheckSelectionTeam2MemberSpellsWriter.setWriterCreated(false);
				CrossCheckSelectionTeam2MemberSpellsWriter.get_file_writer(cross_check, 1);
				CrossCheckLeftOverTeam2MemberSpellsWriter.setWriterCreated(false);
				CrossCheckLeftOverTeam2MemberSpellsWriter.get_file_writer(cross_check, 1); 
				CrossCheckDiscardTeam2MemberSpellsWriter.setWriterCreated(false); 
				CrossCheckDiscardTeam2MemberSpellsWriter.get_file_writer(cross_check, 1); 
				CrossCheckGarbageCollectionTeam2MemberWriter.setWriterCreated(false); 
				CrossCheckGarbageCollectionTeam2MemberWriter.get_file_writer(cross_check, 1);
				CrossCheckLexicalAnalyzerTeam2MemberWriter.setWriterCreated(false);
				CrossCheckLexicalAnalyzerTeam2MemberWriter.get_file_writer(cross_check, 1); 
				CrossCheckDFATeam2MemberWriter.setWriterCreated(false);
				CrossCheckDFATeam2MemberWriter.get_file_writer(cross_check, 1);
				CrossCheckNFATeam2MemberWriter.setWriterCreated(false);
				CrossCheckNFATeam2MemberWriter.get_file_writer(cross_check, 1);
				CrossCheckRunTimeTeam2MemberWriter.setWriterCreated(false);
				CrossCheckRunTimeTeam2MemberWriter.get_file_writer(cross_check, 1); 
				CrossCheckReferencePointersTeam2MemberWriter.setWriterCreated(false);
				CrossCheckReferencePointersTeam2MemberWriter.get_file_writer(cross_check, 1); 
				CrossCheckOutputSpellsTeam2MemberWriter.setWriterCreated(false);
				CrossCheckOutputSpellsTeam2MemberWriter.get_file_writer(cross_check, 1); 
				CrossCheckPathTraceTeam2MemberWriter.setWriterCreated(false);
				CrossCheckPathTraceTeam2MemberWriter.get_file_writer(cross_check, 1);
				CrossCheckTraceToStartTeam2MemberWriter.setWriterCreated(false); 
				CrossCheckTraceToStartTeam2MemberWriter.get_file_writer(cross_check, 1); 
				CrossCheckSatisfierTeam2MemberWriter.setWriterCreated(false); 
				CrossCheckSatisfierTeam2MemberWriter.get_file_writer(cross_check, 1); 
				CrossCheckHistoryTeam2MemberWriter.setWriterCreated(false); 
				CrossCheckHistoryTeam2MemberWriter.get_file_writer(cross_check, 1); 
				CrossCheckIncorporationConceptTeam2MemberWriter.setWriterCreated(false); 
				CrossCheckIncorporationConceptTeam2MemberWriter.get_file_writer(cross_check, 1); 
				InterrogativeWordCheckPointTeam2MemberWriter.setWriterCreated(false);
				InterrogativeWordCheckPointTeam2MemberWriter.get_file_writer(cross_check, 1); 
				CrossCheckContributionalEstimateTeam2MemberWriter.setWriterCreated(false); 
				CrossCheckContributionalEstimateTeam2MemberWriter.get_file_writer(cross_check, 1); 
				CrossCheckAudienceTeam2MemberWriter.setWriterCreated(false); 
				CrossCheckAudienceTeam2MemberWriter.get_file_writer(cross_check, 1); 
				CrossCheckModeOfOperationsTeam2MemberWriter.setWriterCreated(false);
				CrossCheckModeOfOperationsTeam2MemberWriter.get_file_writer(cross_check, 1); 
				CrossCheckExtractDataTeam2MemberWriter.setWriterCreated(false);
				CrossCheckExtractDataTeam2MemberWriter.get_file_writer(cross_check, 1);
				CrossCheckLoggerTeam2MemberWriter.setWriterCreated(false); 
				CrossCheckLoggerTeam2MemberWriter.get_file_writer(cross_check, 1); 
			}
			else if(playerAssociationToSchool.size() == 4) {
				CrossCheckTeam1MemberSpellsWriter.setWriterCreated(false);
				CrossCheckTeam1MemberSpellsWriter.get_file_writer(cross_check, 1); 
				CrossCheckTeam1MemberSpellsWriter.setWriterCreated(false); 
				CrossCheckTeam1MemberSpellsWriter.get_file_writer(cross_check, 2); 
				CrossCheckTeam2MemberSpellsWriter.setWriterCreated(false); 
				CrossCheckTeam2MemberSpellsWriter.get_file_writer(cross_check, 1);
				CrossCheckTeam2MemberSpellsWriter.setWriterCreated(false); 
				CrossCheckTeam2MemberSpellsWriter.get_file_writer(cross_check, 2); 
			}
			else if(playerAssociationToSchool.size() == 6) {
				CrossCheckTeam1MemberSpellsWriter.setWriterCreated(false);
				CrossCheckTeam1MemberSpellsWriter.get_file_writer(cross_check, 1); 
				CrossCheckTeam1MemberSpellsWriter.setWriterCreated(false); 
				CrossCheckTeam1MemberSpellsWriter.get_file_writer(cross_check, 2); 
				CrossCheckTeam1MemberSpellsWriter.setWriterCreated(false); 
				CrossCheckTeam1MemberSpellsWriter.get_file_writer(cross_check, 3); 
				CrossCheckTeam2MemberSpellsWriter.setWriterCreated(false); 
				CrossCheckTeam2MemberSpellsWriter.get_file_writer(cross_check, 1); 
				CrossCheckTeam2MemberSpellsWriter.setWriterCreated(false); 
				CrossCheckTeam2MemberSpellsWriter.get_file_writer(cross_check, 2); 
				CrossCheckTeam2MemberSpellsWriter.setWriterCreated(false); 
				CrossCheckTeam2MemberSpellsWriter.get_file_writer(cross_check, 3); 
			}
			else if(playerAssociationToSchool.size() == 8) {
				CrossCheckTeam1MemberSpellsWriter.setWriterCreated(false);
				CrossCheckTeam1MemberSpellsWriter.get_file_writer(cross_check, 1); 
				CrossCheckTeam1MemberSpellsWriter.setWriterCreated(false); 
				CrossCheckTeam1MemberSpellsWriter.get_file_writer(cross_check, 2); 
				CrossCheckTeam1MemberSpellsWriter.setWriterCreated(false); 
				CrossCheckTeam1MemberSpellsWriter.get_file_writer(cross_check, 3); 
				CrossCheckTeam1MemberSpellsWriter.setWriterCreated(false); 
				CrossCheckTeam1MemberSpellsWriter.get_file_writer(cross_check, 4); 
				CrossCheckTeam2MemberSpellsWriter.setWriterCreated(false); 
				CrossCheckTeam2MemberSpellsWriter.get_file_writer(cross_check, 1); 
				CrossCheckTeam2MemberSpellsWriter.setWriterCreated(false); 
				CrossCheckTeam2MemberSpellsWriter.get_file_writer(cross_check, 2); 
				CrossCheckTeam2MemberSpellsWriter.setWriterCreated(false); 
				CrossCheckTeam2MemberSpellsWriter.get_file_writer(cross_check, 3); 
				CrossCheckTeam2MemberSpellsWriter.setWriterCreated(false); 
				CrossCheckTeam2MemberSpellsWriter.get_file_writer(cross_check, 4); 
			}
			System.out.println("Caught Stream Closed Exception"); 
			InterrogativeWordCombineWriter.setWriterCreated(false); 
			productCombineWriter = InterrogativeWordCombineWriter.get_file_writer();
			CrossCheckByCrossCheckWriter.setWriterCreated(false);
			productcross_checkBycross_checkWriter = CrossCheckByCrossCheckWriter.get_file_writer();
			InterrogativeWordDiscardSpellsWriter.setWriterCreated(false);
			productExcessSpellsWriter = InterrogativeWordDiscardSpellsWriter.get_file_writer();
			InterrogativeWordDiscardSpellsTeam1Writer.setWriterCreated(false); 
			productExcessSpellsTeam1Writer = InterrogativeWordDiscardSpellsTeam1Writer.get_file_writer();
			InterrogativeWordDiscardSpellsTeam2Writer.setWriterCreated(false);
			productExcessSpellsTeam2Writer = InterrogativeWordDiscardSpellsTeam2Writer.get_file_writer();
			InterrogativeWordLeftOverSpellsWriter.setWriterCreated(false); 
			productRemainingSpellsWriter = InterrogativeWordLeftOverSpellsWriter.get_file_writer();
			InterrogativeWordLeftOverSpellsTeam1Writer.setWriterCreated(false); 
			productRemainingSpellsTeam1Writer = InterrogativeWordLeftOverSpellsTeam1Writer.get_file_writer();
			InterrogativeWordLeftOverSpellsTeam2Writer.setWriterCreated(false); 
			productRemainingSpellsTeam2Writer = InterrogativeWordLeftOverSpellsTeam2Writer.get_file_writer();
			InterrogativeWordSelectionWriter.setWriterCreated(false);
			productSelectionLineWriter = InterrogativeWordSelectionWriter.get_file_writer();
			InterrogativeWordSelectionTeam1Writer.setWriterCreated(false); 
			productSelectionLineTeam1Writer = InterrogativeWordSelectionTeam1Writer.get_file_writer();
			InterrogativeWordSelectionTeam2Writer.setWriterCreated(false);
			productSelectionLineTeam2Writer = InterrogativeWordSelectionTeam2Writer.get_file_writer();
			CrossCheckPrGraphWriter.setWriterCreated(false); 
			cross_checkPrGraphWriter = CrossCheckPrGraphWriter.get_file_writer(cross_check);
			CrossCheckPrGraphTeam1Writer.setWriterCreated(false); 
			cross_checkPrGraphTeam1Writer = CrossCheckPrGraphTeam1Writer.get_file_writer(cross_check); 
			CrossCheckPrGraphTeam2Writer.setWriterCreated(false);
			cross_checkPrGraphTeam2Writer = CrossCheckPrGraphTeam2Writer.get_file_writer(cross_check); 
			CrossCheckPrFactsWriter.setWriterCreated(false); 
			cross_checkPrFactsWriter = CrossCheckPrFactsWriter.get_file_writer(cross_check); 
			CrossCheckPrFactsTeam1Writer.setWriterCreated(false);
			cross_checkPrFactsTeam1Writer = CrossCheckPrFactsTeam1Writer.get_file_writer(cross_check);
			CrossCheckPrFactsTeam2Writer.setWriterCreated(false); 
			cross_checkPrFactsTeam2Writer = CrossCheckPrFactsTeam2Writer.get_file_writer(cross_check);
			CrossCheckPrRulesWriter.setWriterCreated(false); 
			cross_checkPrRulesWriter = CrossCheckPrRulesWriter.get_file_writer(cross_check);
			CrossCheckPrRulesTeam1Writer.setWriterCreated(false); 
			cross_checkPrRulesTeam1Writer = CrossCheckPrRulesTeam1Writer.get_file_writer(cross_check); 
			CrossCheckPrRulesTeam2Writer.setWriterCreated(false); 
			cross_checkPrRulesTeam2Writer = CrossCheckPrRulesTeam2Writer.get_file_writer(cross_check); 
			CrossCheckPrInterpretationsWriter.setWriterCreated(false); 
			cross_checkPrInterpretationsWriter = CrossCheckPrInterpretationsWriter.get_file_writer(cross_check); 
			CrossCheckPrInterpretationsTeam1Writer.get_file_writer(cross_check); 
			cross_checkPrInterpretationsTeam1Writer = CrossCheckPrInterpretationsTeam1Writer.get_file_writer(cross_check);
			CrossCheckPrInterpretationsTeam2Writer.setWriterCreated(false);
			cross_checkPrInterpretationsTeam2Writer = CrossCheckPrInterpretationsTeam2Writer.get_file_writer(cross_check); 
			CrossCheckStaticLanguageWriter.setWriterCreated(false); 
			cross_checkStaticLanguageWriter = CrossCheckStaticLanguageWriter.get_file_writer(cross_check); 
			CrossCheckStaticLanguageTeam1Writer.setWriterCreated(false); 
			cross_checkStaticLanguageTeam1Writer = CrossCheckStaticLanguageTeam1Writer.get_file_writer(cross_check);
			CrossCheckStaticLanguageTeam2Writer.setWriterCreated(false); 
			cross_checkStaticLanguageTeam2Writer = CrossCheckStaticLanguageTeam2Writer.get_file_writer(cross_check);
			CrossCheckChangingLanguageWriter.setWriterCreated(false); 
			cross_checkChangingLanguageWriter = CrossCheckChangingLanguageWriter.get_file_writer(cross_check);
			CrossCheckChangingLanguageTeam1Writer.setWriterCreated(false); 
			cross_checkChangingLanguageTeam1Writer = CrossCheckChangingLanguageTeam1Writer.get_file_writer(cross_check); 
			CrossCheckChangingLanguageTeam2Writer.setWriterCreated(false); 
			cross_checkChangingLanguageTeam2Writer = CrossCheckChangingLanguageTeam2Writer.get_file_writer(cross_check); 
			CrossCheckStaticGrammarWriter.setWriterCreated(false); 
			cross_checkStaticGrammarWriter = CrossCheckStaticGrammarWriter.get_file_writer(cross_check); 
			CrossCheckStaticGrammarTeam1Writer.setWriterCreated(false); 
			cross_checkStaticGrammarTeam1Writer = CrossCheckStaticGrammarTeam1Writer.get_file_writer(cross_check); 
			CrossCheckStaticGrammarTeam2Writer.setWriterCreated(false); 
			cross_checkStaticGrammarTeam2Writer = CrossCheckStaticGrammarTeam2Writer.get_file_writer(cross_check); 
			CrossCheckChangingGrammarWriter.setWriterCreated(false); 
			cross_checkChangingGrammarWriter = CrossCheckChangingGrammarWriter.get_file_writer(cross_check); 
			CrossCheckChangingGrammarTeam1Writer.setWriterCreated(false); 
			cross_checkChangingGrammarTeam1Writer = CrossCheckChangingGrammarTeam1Writer.get_file_writer(cross_check); 
			CrossCheckChangingGrammarTeam2Writer.setWriterCreated(false); 
			cross_checkChangingGrammarTeam2Writer = CrossCheckChangingGrammarTeam2Writer.get_file_writer(cross_check); 
			CrossCheckGenerationWriter.setWriterCreated(false); 
			cross_checkGenerationWriter = CrossCheckGenerationWriter.get_file_writer(cross_check); 
			CrossCheckGenerationTeam1Writer.setWriterCreated(false); 
			cross_checkGenerationTeam1Writer = CrossCheckGenerationTeam1Writer.get_file_writer(cross_check); 
			CrossCheckGenerationTeam2Writer.setWriterCreated(false); 
			cross_checkGenerationTeam2Writer = CrossCheckGenerationTeam2Writer.get_file_writer(cross_check); 
			CrossCheckOrderingPlacementsWriter.setWriterCreated(false);
			cross_checkOrderingPlacementsWriter = CrossCheckOrderingPlacementsWriter.get_file_writer(cross_check); 
			CrossCheckOrderingPlacementsTeam1Writer.setWriterCreated(false); 
			cross_checkOrderingPlacementsTeam1Writer = CrossCheckOrderingPlacementsTeam1Writer.get_file_writer(cross_check); 
			CrossCheckOrderingPlacementsTeam2Writer.setWriterCreated(false); 
			cross_checkOrderingPlacementsTeam2Writer = CrossCheckOrderingPlacementsTeam2Writer.get_file_writer(cross_check); 
			CrossCheckCombineWriter.setWriterCreated(false); 
			cross_checkCombineWriter = CrossCheckCombineWriter.get_file_writer(cross_check); 
			CrossCheckTeam1SpellsWriter.setWriterCreated(false);
			cross_checkTeam1SpellsWriter = CrossCheckTeam1SpellsWriter.get_file_writer(cross_check);
			CrossCheckTeam2SpellsWriter.setWriterCreated(false);
			cross_checkTeam2SpellsWriter = CrossCheckTeam2SpellsWriter.get_file_writer(cross_check);
			CrossCheckOfSpellsWriter.setWriterCreated(false); 
			cross_checkDefaultWriter = CrossCheckOfSpellsWriter.get_file_writer(cross_check); 
			CrossCheckSelectionWriter.setWriterCreated(false);
			cross_checkSelectionLineWriter = CrossCheckSelectionWriter.get_file_writer(cross_check); 
			CrossCheckSelectionTeam1Writer.setWriterCreated(false);
			cross_checkSelectionLineTeam1Writer = CrossCheckSelectionTeam1Writer.get_file_writer(cross_check); 
			CrossCheckSelectionTeam2Writer.setWriterCreated(false); 
			cross_checkSelectionLineTeam2Writer = CrossCheckSelectionTeam2Writer.get_file_writer(cross_check); 
			CrossCheckLeftOverSpellsWriter.setWriterCreated(false); 
			cross_checkRemainingSpellsWriter = CrossCheckLeftOverSpellsWriter.get_file_writer(cross_check); 
			CrossCheckLeftOverSpellsTeam1Writer.setWriterCreated(false); 
			cross_checkRemainingTeam1SpellsWriter = CrossCheckLeftOverSpellsTeam1Writer.get_file_writer(cross_check); 
			CrossCheckLeftOverSpellsTeam2Writer.setWriterCreated(false); 
			cross_checkRemainingTeam2SpellsWriter = CrossCheckLeftOverSpellsTeam2Writer.get_file_writer(cross_check); 
			CrossCheckDiscardSpellsWriter.setWriterCreated(false);
			cross_checkExcessSpellsWriter = CrossCheckDiscardSpellsWriter.get_file_writer(cross_check);
			CrossCheckDiscardSpellsTeam1Writer.setWriterCreated(false); 
			cross_checkExcessSpellsTeam1Writer = CrossCheckDiscardSpellsTeam1Writer.get_file_writer(cross_check); 
			CrossCheckDiscardSpellsTeam2Writer.setWriterCreated(false); 
			cross_checkExcessSpellsTeam2Writer = CrossCheckDiscardSpellsTeam2Writer.get_file_writer(cross_check); 
			CrossCheckGarbageCollectionWriter.setWriterCreated(false); 
			cross_checkGarbageCollectionWriter = CrossCheckGarbageCollectionWriter.get_file_writer(cross_check); 
			CrossCheckGarbageCollectionTeam1Writer.setWriterCreated(false); 
			cross_checkGarbageCollectionTeam1Writer = CrossCheckGarbageCollectionTeam1Writer.get_file_writer(cross_check); 
			CrossCheckGarbageCollectionTeam2Writer.setWriterCreated(false); 
			cross_checkGarbageCollectionTeam2Writer = CrossCheckGarbageCollectionTeam2Writer.get_file_writer(cross_check); 
			CrossCheckLexicalAnalyzerWriter.setWriterCreated(false); 
			cross_checkLexicalAnalyzerWriter = CrossCheckLexicalAnalyzerWriter.get_file_writer(cross_check); 
			CrossCheckLexicalAnalyzerTeam1Writer.setWriterCreated(false); 
			cross_checkLexicalAnalyzerTeam1Writer = CrossCheckLexicalAnalyzerTeam1Writer.get_file_writer(cross_check); 
			CrossCheckLexicalAnalyzerTeam2Writer.setWriterCreated(false);
			cross_checkLexicalAnalyzerTeam2Writer = CrossCheckLexicalAnalyzerTeam2Writer.get_file_writer(cross_check); 
			CrossCheckDFAWriter.setWriterCreated(false); 
			cross_checkDFAWriter = CrossCheckDFAWriter.get_file_writer(cross_check); 
			CrossCheckDFATeam1Writer.setWriterCreated(false); 
			cross_checkDFATeam1Writer = CrossCheckDFATeam1Writer.get_file_writer(cross_check); 
			CrossCheckDFATeam2Writer.setWriterCreated(false); 
			cross_checkDFATeam2Writer = CrossCheckDFATeam2Writer.get_file_writer(cross_check); 
			CrossCheckNFAWriter.setWriterCreated(false); 
			cross_checkNFAWriter = CrossCheckNFAWriter.get_file_writer(cross_check); 
			CrossCheckNFATeam1Writer.setWriterCreated(false); 
			cross_checkNFATeam1Writer = CrossCheckNFATeam1Writer.get_file_writer(cross_check); 
			CrossCheckNFATeam2Writer.setWriterCreated(false); 
			cross_checkNFATeam2Writer = CrossCheckNFATeam2Writer.get_file_writer(cross_check); 
			CrossCheckRunTimeWriter.setWriterCreated(false); 
			cross_checkRunTimeWriter = CrossCheckRunTimeWriter.get_file_writer(cross_check); 
			CrossCheckRunTimeTeam1Writer.setWriterCreated(false);
			cross_checkRunTimeTeam1Writer = CrossCheckRunTimeTeam1Writer.get_file_writer(cross_check); 
			CrossCheckRunTimeTeam2Writer.setWriterCreated(false); 
			cross_checkRunTimeTeam2Writer = CrossCheckRunTimeTeam2Writer.get_file_writer(cross_check); 
			CrossCheckReferencePointersWriter.setWriterCreated(false); 
			cross_checkReferencePointersWriter = CrossCheckReferencePointersWriter.get_file_writer(cross_check); 
			CrossCheckReferencePointersTeam1Writer.setWriterCreated(false); 
			cross_checkReferencePointersTeam1Writer = CrossCheckReferencePointersTeam1Writer.get_file_writer(cross_check); 
			CrossCheckOutputSpellsWriter.setWriterCreated(false); 
			cross_checkComputationSpellsWriter = CrossCheckOutputSpellsWriter.get_file_writer(cross_check); 
			CrossCheckOutputSpellsTeam1Writer.setWriterCreated(false);
			cross_checkComputationSpellsTeam1Writer = CrossCheckOutputSpellsTeam1Writer.get_file_writer(cross_check); 
			CrossCheckOutputSpellsTeam2Writer.setWriterCreated(false); 
			cross_checkComputationSpellsTeam2Writer = CrossCheckOutputSpellsTeam2Writer.get_file_writer(cross_check); 
			CrossCheckPathTraceWriter.setWriterCreated(false); 
			cross_checkPathTraceWriter = CrossCheckPathTraceWriter.get_file_writer(cross_check); 
			CrossCheckPathTraceTeam1Writer.setWriterCreated(false); 
			cross_checkPathTraceTeam1Writer = CrossCheckPathTraceTeam1Writer.get_file_writer(cross_check); 
			CrossCheckPathTraceTeam2Writer.setWriterCreated(false); 
			cross_checkPathTraceTeam2Writer = CrossCheckPathTraceTeam2Writer.get_file_writer(cross_check); 
			CrossCheckTraceToStartWriter.setWriterCreated(false); 
			cross_checkTraceToStartWriter = CrossCheckTraceToStartWriter.get_file_writer(cross_check); 
			CrossCheckTraceToStartTeam1Writer.setWriterCreated(false); 
			cross_checkTraceToStartTeam1Writer = CrossCheckTraceToStartTeam1Writer.get_file_writer(cross_check); 
			CrossCheckTraceToStartTeam2Writer.setWriterCreated(false); 
			cross_checkTraceToStartTeam2Writer = CrossCheckTraceToStartTeam2Writer.get_file_writer(cross_check); 
			CrossCheckSatisfierWriter.setWriterCreated(false); 
			cross_checkSatisfierWriter = CrossCheckSatisfierWriter.get_file_writer(cross_check); 
			CrossCheckSatisfierTeam1Writer.setWriterCreated(false); 
			cross_checkSatisfierTeam1Writer = CrossCheckSatisfierTeam1Writer.get_file_writer(cross_check); 
			CrossCheckSatisfierTeam2Writer.setWriterCreated(false); 
			cross_checkSatisfierTeam2Writer = CrossCheckSatisfierTeam2Writer.get_file_writer(cross_check); 
			CrossCheckHistoryWriter.setWriterCreated(false); 
			cross_checkHistoryWriter = CrossCheckHistoryWriter.get_file_writer(cross_check); 
			CrossCheckHistoryTeam1Writer.setWriterCreated(false); 
			cross_checkHistoryTeam1Writer = CrossCheckHistoryTeam1Writer.get_file_writer(cross_check); 
			CrossCheckHistoryTeam2Writer.setWriterCreated(false); 
			cross_checkHistoryTeam2Writer = CrossCheckHistoryTeam2Writer.get_file_writer(cross_check); 
			CrossCheckIncorporationConceptWriter.setWriterCreated(false); 
			cross_checkIncorporationConceptWriter = CrossCheckIncorporationConceptWriter.get_file_writer(cross_check); 
			CrossCheckIncorporationConceptTeam1Writer.setWriterCreated(false);
			cross_checkIncorporationConceptTeam1Writer = CrossCheckIncorporationConceptTeam1Writer.get_file_writer(cross_check); 
			CrossCheckIncorporationConceptTeam2Writer.setWriterCreated(false); 
			cross_checkIncorporationConceptTeam2Writer = CrossCheckIncorporationConceptTeam2Writer.get_file_writer(cross_check); 
			CrossCheckCheckPointWriter.setWriterCreated(false); 
			cross_checkCheckPointWriter = CrossCheckCheckPointWriter.get_file_writer(cross_check); 
			CrossCheckCheckPointTeam1Writer.setWriterCreated(false); 
			cross_checkCheckPointTeam1Writer = CrossCheckCheckPointTeam1Writer.get_file_writer(cross_check); 
			CrossCheckCheckPointTeam2Writer.setWriterCreated(false); 
			cross_checkCheckPointTeam2Writer = CrossCheckCheckPointTeam2Writer.get_file_writer(cross_check);
			CrossCheckContributionalEstimateWriter.setWriterCreated(false); 
			cross_checkContributionalEstimateWriter = CrossCheckContributionalEstimateWriter.get_file_writer(cross_check); 
			CrossCheckContributionalEstimateTeam1Writer.setWriterCreated(false); 
			cross_checkContributionalEstimateTeam1Writer = CrossCheckContributionalEstimateTeam1Writer.get_file_writer(cross_check); 
			CrossCheckContributionalEstimateTeam2Writer.setWriterCreated(false); 
			cross_checkContributionalEstimateTeam2Writer = CrossCheckContributionalEstimateTeam2Writer.get_file_writer(cross_check); 
			CrossCheckAudienceWriter.setWriterCreated(false); 
			cross_checkAudienceWriter = CrossCheckAudienceWriter.get_file_writer(cross_check); 
			CrossCheckAudienceTeam1Writer.setWriterCreated(false); 
			cross_checkAudienceTeam1Writer = CrossCheckAudienceTeam1Writer.get_file_writer(cross_check); 
			CrossCheckAudienceTeam2Writer.setWriterCreated(false); 
			cross_checkAudienceTeam2Writer = CrossCheckAudienceTeam2Writer.get_file_writer(cross_check); 
			CrossCheckModeOfOperationsWriter.setWriterCreated(false); 
			cross_checkModeOfOperationsWriter = CrossCheckModeOfOperationsWriter.get_file_writer(cross_check); 
			CrossCheckModeOfOperationsTeam1Writer.setWriterCreated(false); 
			cross_checkModeOfOperationsTeam1Writer = CrossCheckModeOfOperationsTeam1Writer.get_file_writer(cross_check); 
			CrossCheckModeOfOperationsTeam2Writer.setWriterCreated(false); 
			cross_checkModeOfOperationsTeam2Writer = CrossCheckModeOfOperationsTeam2Writer.get_file_writer(cross_check); 
			CrossCheckExtractDataWriter.setWriterCreated(false); 
			cross_checkExtractDataWriter = CrossCheckExtractDataWriter.get_file_writer(cross_check); 
			CrossCheckExtractDataTeam1Writer.setWriterCreated(false); 
			cross_checkExtractDataTeam1Writer = CrossCheckExtractDataTeam1Writer.get_file_writer(cross_check); 
			CrossCheckExtractDataTeam2Writer.setWriterCreated(false); 
			cross_checkExtractDataTeam2Writer = CrossCheckExtractDataTeam2Writer.get_file_writer(cross_check); 
			CrossCheckLoggerWriter.setWriterCreated(false); 
			cross_checkLoggerWriter = CrossCheckLoggerWriter.get_file_writer(cross_check); 
			CrossCheckLoggerTeam1Writer.setWriterCreated(false); 
			cross_checkLoggerTeam1Writer = CrossCheckLoggerTeam1Writer.get_file_writer(cross_check); 
			CrossCheckLoggerTeam2Writer.setWriterCreated(false); 
			cross_checkLoggerTeam2Writer = CrossCheckLoggerTeam2Writer.get_file_writer(cross_check); 
		}
		// Blade, Blade, Blade, Trap 
		// Trap, Trap, Trap, Empower
		System.out.println("This is a cross_check casted of our match between team 1 and team 2"); 
		System.out.println("Team Players Size inclusive of both team 1 and team 2: " + teamPlayers.size()); 
		productcross_checkBycross_checkWriter.write("\n"); 
		productcross_checkBycross_checkWriter.write("ROUND # " + cross_check + " OF SPELLS" + "\n");
		productWriterFinalizer.write("ROUND # " + cross_check + " OF SPELLS" + "\n"); 
		cross_checkDefaultWriter.write("\n"); 
		cross_checkDefaultWriter.write("ROUND # " + cross_check + " OF SPELLS" + "\n"); 
		cross_checkCombineWriter.write("ROUND # " + cross_check + " OF SPELLS" + "\n");
		cross_checkComputationSpellsWriter.write("ROUND # " + cross_check + " COMPUTATION " + "\n"); 
		cross_checkComputationSpellsWriter.write("________________________________________\n"); 
		System.out.println("Size of player association to school: " + playerAssociationToSchool.size());
		// 2 players <-> 1:1
		// 4 players <-> 2:2
		// 6 players <-> 3:3
		// 8 players <-> 4:4
		int [][] agentSystemNoAssignments2DArray = new int[teamPlayers.size()][teamPlayers.size()]; 
		int[] agentSystemNoAssignments1DArray = new int[teamPlayers.size() / 2];
		int agentSystemNoStart = 0; 
		int agentIndividualNoStart = 0; 
		int agentNoFixedGenerationEntry = 0;
		int maxAgentSystemCap = teamPlayers.size() / 2; 
		for(String player: playerAssociationToSchool.keySet()) {
			if(agentNoFixedGenerationEntry == maxAgentSystemCap) {
				for(int i = 1; i <= agentNoFixedGenerationEntry; i++) {
					agentSystemNoAssignments1DArray[i-1] = i; 
				}
				++agentSystemNoStart;
				agentIndividualNoStart = 0; 
				agentNoFixedGenerationEntry = 0; 
				new Halt_Blocker(agentSystemNoAssignments1DArray, "fixed"); 
				//new MyAgentSystemRepository();
			}
			agentSystemNoAssignments2DArray[agentSystemNoStart][agentIndividualNoStart] = ++agentNoFixedGenerationEntry;

			/*if(agentSystemNoStart >= 1 && agentIndividualNoStart >= 1) {
				// Check previous entry 
				int agentNoGenerationPrevEntry = agentSystemNoAssignments[agentSystemNoStart-1][agentIndividualNoStart-1].get(player); 
				// Create the light-weight recursive mechanism
				if(agentNoGenerationPrevEntry == agentNoGenerationEntry) {
					Distinct_Number number = new Distinct_Number() {
						public int uniqueNumber(int valuePrev, int valueCurrent) {
							
						}
					};
					number.uniqueNumber(agentNoGenerationPrevEntry, agentNoGenerationEntry, 0);
				}
				else {
					agentSystemNoAssignments[agentSystemNoStart-1][agentIndividualNoStart-1].put(player, agentNoGenerationEntry);
					entryCheck++; 
				}
			}
			agentSystemCount--; */
			System.out.println("Player " + player + ": Select a manual."); 
			productcross_checkBycross_checkWriter.write("AGENT-" + player + "-UNITS SELECTION\n"); 
			productWriterFinalizer.write("AGENT-" + player + "-UNITS SELECTION\n"); 
			cross_checkDefaultWriter.write("AGENT-" + player + "-UNITS SELECTION\n");	
			cross_checkCombineWriter.write("AGENT-" + player + "-UNITS SELECTION\n"); 
			System.out.println("The following seven manuals have been generated."); 
			Element[] sevenCards = generateSevenCards(playerAssociationToSchool.get(player).toLowerCase(), index); 
			System.out.println("Printing out the seven manuals.");
			for(int z = 0; z < sevenCards.length; z++)
			{
				productcross_checkBycross_checkWriter.write("----------------------------\n");
				productWriterFinalizer.write("----------------------------\n"); 
				cross_checkDefaultWriter.write("----------------------------\n"); 
				cross_checkCombineWriter.write("----------------------------\n");
				System.out.println("Manual " + (z+1) + ": " + "{ "); 
				productcross_checkBycross_checkWriter.write("Manual " + (z+1) + ": " + "{\n "); 
				productWriterFinalizer.write("Manual " + (z+1) + ": " + "{\n "); 
				cross_checkDefaultWriter.write("Manual " + (z+1) + ": " + "{\n ");
				cross_checkCombineWriter.write("Manual " + (z+1) + ": " + "{\n ");
				System.out.println("Unit Tag: " + sevenCards[z].getSpellName()); 
				productcross_checkBycross_checkWriter.write("Unit Tag: " + sevenCards[z].getSpellName() + "\n"); 
				productWriterFinalizer.write("Unit Tag: " + sevenCards[z].getSpellName() + "\n"); 
			 	cross_checkDefaultWriter.write("Unit Tag: " + sevenCards[z].getSpellName() + "\n");
				cross_checkCombineWriter.write("Unit Tag: " + sevenCards[z].getSpellName() + "\n"); 
				//System.out.println("Unit Assembly # Of Steps: " + sevenCards[z].getPips()); 
				//productcross_checkBycross_checkWriter.write("Unit Assembly # Of Steps: " + sevenCards[z].getPips() + "\n"); 
				//productWriterFinalizer.write("Unit Assembly # Of Steps: " + sevenCards[z].getPips() + "\n"); 
				//cross_checkDefaultWriter.write("Unit Assembly # Of Steps: " + sevenCards[z].getPips() + "\n");
				//cross_checkCombineWriter.write("Unit Assembly # Of Steps: " + sevenCards[z].getPips() + "\n"); 
				//System.out.println("Unit Success Build Rate: " + sevenCards[z].getPipChance()); 
				//productcross_checkBycross_checkWriter.write("Unit Success Build Rate: " + sevenCards[z].getPipChance() + "\n"); 
				//productWriterFinalizer.write("Unit Success Build Rate: " + sevenCards[z].getPipChance() + "\n"); 
				//cross_checkDefaultWriter.write("Unit Success Build Rate: " + sevenCards[z].getPipChance() + "\n");
				//cross_checkCombineWriter.write("Unit Success Build Rate: " + sevenCards[z].getPipChance() + "\n"); 
				//System.out.println("Unit Industry Type: " + sevenCards[z].getTypeSpell()); 
				//productcross_checkBycross_checkWriter.write("Unit Industry Type: " + sevenCards[z].getTypeSpell() + "\n"); 
				//productWriterFinalizer.write("Unit Industry Type: " + sevenCards[z].getTypeSpell() + "\n"); 
				//cross_checkDefaultWriter.write("Unit Industry Type: " + sevenCards[z].getTypeSpell() + "\n"); 
				//cross_checkCombineWriter.write("Unit Industry Type: " + sevenCards[z].getTypeSpell() + "\n"); 
				//Type_Spell.startToFinish(sevenCards[z].getTypeSpell());
				//cross_checkComputationSpellsWriter.write("MANUAL GUIDE: " + Type_Spell.configureInUseToEnd[0] + " OUT OF " + Type_Spell.configureInUseToEnd[1] + " " + sevenCards[z].getTypeSpell().toUpperCase() + " UNITS\n");
				//System.out.println("Unit Supply Count: " + sevenCards[z].getCount()); 
				//productcross_checkBycross_checkWriter.write("Unit Supply Count: " + sevenCards[z].getCount() + "\n"); 
				//productWriterFinalizer.write("Unit Supply Count: " + sevenCards[z].getCount() + "\n"); 
				//cross_checkDefaultWriter.write("Unit Supply Count: " + sevenCards[z].getCount() + "\n");
				//cross_checkCombineWriter.write("Unit Supply Count: " + sevenCards[z].getCount() + "\n"); 
				//System.out.println("Unit Information: " + sevenCards[z].getDescription()); 
				//productcross_checkBycross_checkWriter.write("Unit Information: " + sevenCards[z].getDescription() + "\n"); 
				//productWriterFinalizer.write("Unit Information: " + sevenCards[z].getDescription() + "\n");
				//cross_checkDefaultWriter.write("Unit Information: " + sevenCards[z].getDescription() + "\n"); 
				//cross_checkCombineWriter.write("Unit Information: " + sevenCards[z].getDescription() + "\n"); 
				System.out.println("}");
				productcross_checkBycross_checkWriter.write("}\n"); 
				productWriterFinalizer.write("}\n"); 
				cross_checkDefaultWriter.write("}\n"); 
				cross_checkCombineWriter.write("}\n"); 
				System.out.println("Unit added to the Productwriter."); 
			}
			productcross_checkBycross_checkWriter.write("----------------------------\n");
			productWriterFinalizer.write("----------------------------\n"); 
			cross_checkDefaultWriter.write("----------------------------\n"); 
			cross_checkCombineWriter.write("----------------------------\n");
			
		}
		productcross_checkBycross_checkWriter.write("END OF cross_check\n");
		productWriterFinalizer.write("END OF cross_check\n"); 
		productWriterFinalizer.write("############################\n"); 
		cross_checkDefaultWriter.write("END OF cross_check\n"); 
		cross_checkCombineWriter.write("END OF cross_check\n"); 
		cross_checkComputationSpellsWriter.write("________________________________________\n"); 
		cross_checkComputationSpellsWriter.write("END OF COMPUTATION\n"); 
		cross_checkComputationSpellsWriter.close(); 
		System.out.println("Reading cross_check of units using reader. Decide between reading system 1 or system 2 first."); 

		productcross_checkBycross_checkWriter.close(); 
		cross_checkDefaultWriter.close(); 
		BufferedReader cross_checkComputeReader = null;
		try {
			cross_checkComputeReader = new BufferedReader(CrossCheckOfSpellsReader.get_file_reader()); 
			cross_checkComputeReader.readLine(); 
		} catch (Exception e) {
			CrossCheckOfSpellsReader.setReaderCreated(false); 
			cross_checkComputeReader = new BufferedReader(CrossCheckOfSpellsReader.get_file_reader()); 
		}
		cross_checkTeam1SpellsWriter.write("\n"); 
		cross_checkTeam2SpellsWriter.write("\n"); 
		String line; 
		boolean readFirstTeam = false; 
		boolean readSecondTeam = false; 
		String selectionStmtLine_t1 = null;
		String discardStmtLine_t1 = null;
		String remainingStmtLine_t1 = null;
		String selectionStmtLine_t2 = null;
		String discardStmtLine_t2 = null;
		String remainingStmtLine_t2 = null;
		while((line = cross_checkComputeReader.readLine()) != null) { 
			if(line.contains("(SYSTEM 1)")) {
				System.out.println("CONTAINS SYSTEM 1"); 
				readFirstTeam = true; 
				readSecondTeam = false; 
				
				line = line.replace("UNITS SELECTION", "UNIT SELECTED"); 
				cross_checkSelectionLineWriter.write(line + "\n"); 
				cross_checkSelectionLineTeam1Writer.write(line + "\n"); 
				//roundCombineWriter.write(line + "\n"); 
				selectionStmtLine_t1 = line;
				String discardLine = line; 
				discardLine = discardLine.replace("UNIT SELECTED", "UNITS DISCARDED"); 
				cross_checkExcessSpellsWriter.write(discardLine + "\n"); 
				cross_checkExcessSpellsTeam1Writer.write(discardLine + "\n"); 
				discardStmtLine_t1 = discardLine;
				//roundCombineWriter.write(discardLine + "\n"); 
				String remainingLine = line; 
				remainingLine = remainingLine.replace("UNIT SELECTED", "UNITS REMAINING"); 
				cross_checkRemainingSpellsWriter.write(remainingLine + "\n"); 
				cross_checkRemainingTeam1SpellsWriter.write(remainingLine + "\n"); 
				cross_checkRemainingTeam2SpellsWriter.write(remainingLine + "\n"); 
				remainingStmtLine_t1 = remainingLine;
				//roundCombineWriter.write(remainingLine + "\n"); 
			}
			if(line.contains("(SYSTEM 2)")) {
				readSecondTeam = true; 
				readFirstTeam = false;
				line = line.replace("UNITS SELECTION", "UNIT SELECTED");
				cross_checkSelectionLineWriter.write(line + "\n"); 
				cross_checkSelectionLineTeam2Writer.write(line + "\n");  
				selectionStmtLine_t2 = line;
				//roundCombineWriter.write(line + "\n"); 
				String discardLine = line; 
				discardLine = discardLine.replace("UNIT SELECTED", "UNIT DISCARDED"); 
				cross_checkExcessSpellsWriter.write(discardLine + "\n"); 
				cross_checkExcessSpellsTeam2Writer.write(discardLine + "\n"); 
				discardStmtLine_t2 = discardLine;
				//roundCombineWriter.write(discardLine + "\n"); 
				String remainingLine = line; 
				remainingLine = remainingLine.replace("UNIT SELECTED", "UNIT REMAINING"); 
				cross_checkRemainingSpellsWriter.write(remainingLine + "\n"); 
				cross_checkRemainingTeam1SpellsWriter.write(remainingLine + "\n"); 
				cross_checkRemainingTeam2SpellsWriter.write(remainingLine + "\n"); 
				remainingStmtLine_t2 = remainingLine;
				//roundCombineWriter.write(remainingLine + "\n"); 
			}
			if(readFirstTeam == true) {
				System.out.println("WRITING LINE: " + line + " FOR TEAM 1"); 
				cross_checkTeam1SpellsWriter.write(line + "\n"); 
				System.out.println("Extracting member_no information"); 
				if(line.contains("BOT")) {
					int memberCharLoc = line.indexOf("B");
					int stringNoLoc = line.indexOf(" ", memberCharLoc) + 1; 
					int memberNoLoc = Integer.parseInt(line.substring(stringNoLoc, stringNoLoc+1)); 
					System.out.println("memberNoLoc index: " + memberNoLoc); 
					CrossCheckTeam1MemberSpellsWriter.file_writers[memberNoLoc-1].write(line + "\n"); 
				}
			}
			if(readSecondTeam == true) {
				System.out.println("WRITING LINE: " + line + " FOR TEAM 2");
				cross_checkTeam2SpellsWriter.write(line + "\n"); 
				System.out.println("Extracting member_no information"); 
				if(line.contains("BOT")) {
					int memberCharLoc = line.indexOf("B"); 
					int stringNoLoc = line.indexOf(" ", memberCharLoc) + 1; 
					int memberNoLoc = Integer.parseInt(line.substring(stringNoLoc, stringNoLoc+1)); 
					System.out.println("memberNoLoc index: " + memberNoLoc); 
 					CrossCheckTeam2MemberSpellsWriter.file_writers[memberNoLoc-1].write(line + "\n");
				}
			}
		}
		cross_checkTeam1SpellsWriter.close(); 
		try {
			CrossCheckTeam1MemberSpellsWriter.file_writers[0].close(); 
			CrossCheckTeam1MemberSpellsWriter.file_writers[1].close(); 
			CrossCheckTeam1MemberSpellsWriter.file_writers[2].close(); 
			CrossCheckTeam1MemberSpellsWriter.file_writers[3].close(); 
		} catch (Exception e) {
			System.out.println("A member writer for team 1 failed to close"); ; 
		}
		cross_checkTeam2SpellsWriter.close();  
		try {
			CrossCheckTeam2MemberSpellsWriter.file_writers[0].close(); 
			CrossCheckTeam2MemberSpellsWriter.file_writers[1].close(); 
			CrossCheckTeam2MemberSpellsWriter.file_writers[2].close(); 
			CrossCheckTeam2MemberSpellsWriter.file_writers[3].close(); 
		} catch (Exception e) {
			System.out.println("A member writer for team 2 failed to close"); 
		}
		System.out.println("Creating two readers for selection_line of team 1 and team 2 cross_check of spells."); 
		BufferedReader readerTeam1Compute = null;
		BufferedReader readerTeam2Compute = null;
		try {
			readerTeam1Compute = new BufferedReader(CrossCheckSelectionReader.get_file_reader("t1", cross_check)); 
			readerTeam1Compute.readLine(); 
			System.out.println("Line Read By Team 1 Reader: " + line); 
			readerTeam2Compute = new BufferedReader(CrossCheckSelectionReader.get_file_reader("t2", cross_check)); 
			readerTeam2Compute.readLine(); 
			System.out.println("Line Read By Team 2 Reader: " + line); 
		} catch (Exception e) {
			CrossCheckSelectionReader.setReaderCreated(false);
			readerTeam1Compute = new BufferedReader(CrossCheckSelectionReader.get_file_reader("t1", cross_check)); 
			CrossCheckSelectionReader.setReaderCreated(false); 
			readerTeam2Compute = new BufferedReader(CrossCheckSelectionReader.get_file_reader("t2", cross_check)); 
		}
		new FileOperation(readerTeam1Compute, cross_checkSelectionLineTeam1Writer, cross_checkExcessSpellsTeam1Writer, cross_checkRemainingTeam1SpellsWriter, cross_checkCombineWriter, new FileReader(Interrogative_Word.initialFile), "t1", cross_check, selectionStmtLine_t1, discardStmtLine_t1, remainingStmtLine_t1, size).run(); 
		Thread.sleep(15000);
		new FileOperation(readerTeam2Compute, cross_checkSelectionLineTeam2Writer, cross_checkExcessSpellsTeam2Writer, cross_checkRemainingTeam2SpellsWriter, cross_checkCombineWriter, new FileReader(Interrogative_Word.initialFile), "t2", cross_check, selectionStmtLine_t2, discardStmtLine_t2, remainingStmtLine_t2, size).run(); 
		Thread.sleep(15000); 
		cross_checkComputeReader.close(); 
		readerTeam1Compute.close(); 
		readerTeam2Compute.close(); 
		cross_checkSelectionLineWriter.close();
		cross_checkSelectionLineTeam1Writer.close(); 
		cross_checkSelectionLineTeam2Writer.close(); 
		cross_checkExcessSpellsWriter.close(); 
		cross_checkExcessSpellsTeam1Writer.close(); 
		cross_checkExcessSpellsTeam2Writer.close(); 
		cross_checkRemainingSpellsWriter.close(); 
		cross_checkRemainingTeam1SpellsWriter.close(); 
		cross_checkRemainingTeam2SpellsWriter.close(); 
		cross_checkCombineWriter.close(); 
}
	
private static Element[] generateSevenCards(String school, int index) {
	Element[] sevenCards = new Element[7]; 

	System.out.println("School: " + school); 
	System.out.println("Index: " + index); 

	int number = 0; 
	while (number < 7) {
		int randomIndex = (int) (Math.random() * decks.get(school).get(index).size());

		if(!(decks.get(school).get(index).get(randomIndex).getSpellName().equals("X"))) {
			// Figure out a way to change the element retrieved 
			sevenCards[number] = decks.get(school).get(index).get(randomIndex); 
			number++; 
		}
	}

	return sevenCards;
}


public String randomizeHeadsOrTails()
{
	String[] inputs = {"Heads", "Tails"}; 
		
	int number = (int) ( (Math.random() * team.length) + 1);
		
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
	
	public String computePlayerInformation(String wizard, String school, int level, HashMap<Integer, List<String>> keywords, int count) throws IOException
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

		String[] listGear = {"c1", "c2", "c3", "c4", "c5", "c6", "c7", "c8", "pet"};  

		Bind_1 hat = (Bind_1)instantiateGearPiece(listGear[0], school, level, gearType1); 
		System.out.println("Hat gearType: " + gearType1);  
		Bind_2 robe = (Bind_2)instantiateGearPiece(listGear[1], school, level, gearType2); 
		System.out.println("Robe gearType: " + gearType2); 
		Bind_3 boot = (Bind_3)instantiateGearPiece(listGear[2], school, level, gearType3);
		System.out.println("Boot gearType: " + gearType3); 
		Bind_4 wand = (Bind_4)instantiateGearPiece(listGear[3], school, level, gearType4); 
		System.out.println("Wand gearType: " + gearType4); 
		Bind_5 athame = (Bind_5)instantiateGearPiece(listGear[4], school, level, gearType5);
		System.out.println("Athame gearType: " + gearType5); 
		Bind_6 amulet = (Bind_6)instantiateGearPiece(listGear[5], school, level, gearType6); 
		System.out.println("Amulet gearType: " + gearType6); 
		Bind_7 ring = (Bind_7)instantiateGearPiece(listGear[6], school, level, gearType7); 
		System.out.println("Ring gearType: " + gearType7); 
		
		Bind_8 deck = (Bind_8)instantiateGearPiece(listGear[7], school, level, gearType8); 
		System.out.println("Deck gearType: " + gearType8); 
		Pet pet = (Pet)instantiateGearPiece(listGear[8], school, level, gearType8);
		
		keywords.put(count, Arrays.asList(gearType1.toString(), gearType2.toString(), gearType3.toString(), gearType4.toString(), gearType5.toString(), gearType6.toString(), gearType7.toString(), gearType8.toString())); 

		Model gear = new Model(hat, robe, boot, wand, athame, amulet, ring, deck, pet); 

		System.out.println("The gear information for player "  + wizard + " is now completed."); 
		System.out.println(gear.toString()); 

		return gear.toString();  
	}

	public boolean verifyHealthRequirements(int health, int level)
	{
		return true; 
	}

	public void computeStatsInformation(HashMap<String, List<String>> gearSets, HashMap<Integer, List<String>> keywords) throws IOException
	{
		System.out.println("Before the loop.");
		String[] listItems = {"c1", "c2", "c3", "c4", "c5", "c6", "c7", "c8"};

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

	private void findGearClass(String word, String gearName, String pieceOfGear) throws IOException {
				if(word.toLowerCase().equals("aeon"))
				{
					new Configuration_Specifications_2_0.TitleClass(gearName, pieceOfGear); 
				}
				else if(word.toLowerCase().equals("eternal"))
				{
					new Configuration_Specifications_2_1.TitleClass(gearName, pieceOfGear); 
				}
				else if(word.toLowerCase().equals("dragoon"))
				{
					new Configuration_Specifications_1_0.TitleClass(gearName, pieceOfGear); 
				}	
				else if(word.toLowerCase().equals("spooky"))
				{
					new Configuration_Specifications_1_1.TitleClass(gearName, pieceOfGear); 
				}
				else if(word.toLowerCase().equals("night mire"))
				{
					new Configuration_Specifications_2_2.TitleClass(gearName, pieceOfGear); 
				}
				else if(word.toLowerCase().equals("jade"))
				{
					new Configuration_Specifications_1_2.TitleClass(gearName, pieceOfGear);
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

	public Object instantiateGearPiece(String gearName, String school, int level, StringBuilder extractGearType) throws IOException
	{
		Option.scannerOrfileOption();

		String hatName = new String(); 
		String robeName = new String(); 
		String bootName = new String(); 
		String wandName = new String(); 
		String athameName = new String(); 
		String amuletName = new String(); 
		String ringName = new String(); 
		String deckName = new String(); 
		String petName = new String(); 

		final String temp; 

		String[] jadeGear = {"Sword Of Kings", "Stone Of The Other Side", "Pepper Grass Blade", "Celestian Sliver Of Power", "Ring Of The Dying Star"}; 
	
		System.out.println("Please try to space out each word to ensure name of gear inputted can be fixed if written incorrectly."); 
		System.out.println("If you happen to fail to follow these instructions, you will be redirected back to the same page."); 
		System.out.println("Thank you for this understanding."); 
		System.out.println("Enter the name of your " + gearName); 

		switch(gearName) 
		{
			case "c1": 
				if(Option.getScannerInUse() == true) {
					hatName = sc.nextLine();
					if(!(sc.hasNextLine()))
					{
						sc.close(); 
					}
				}
				else if(Option.getFileInUse() == true) {
					Interrogative_Word.getBufferReader().readLine();
					Interrogative_Word.getBufferReader().readLine(); 
					hatName = Interrogative_Word.getBufferReader().readLine(); 
					hatName = hatName.trim(); 
					System.out.println("Hat Name Read: " + hatName); 
				}
				temp = hatName;
				boolean isJadeGear = Arrays.stream(jadeGear).anyMatch(gear->gear.equals(temp)); 
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
					Bind_1 hat = new Bind_1(hatName); 
					System.out.println("Hat: " + hatName + " created."); 
					return hat; 
				}
				extractGearType = new StringBuilder(""); 
				Bind_1 hat = (Bind_1)instantiateGearPiece(gearName, school, level, extractGearType);
				return hat;
			case "c2": 
				if(Option.getScannerInUse() == true) {
					robeName = sc.nextLine();
					if(!(sc.hasNextLine()))
					{
						sc.close(); 
					}
				}
				else {
					robeName = Interrogative_Word.getBufferReader().readLine(); 
					robeName = robeName.trim(); 
					System.out.println("Robe Name Read: " + robeName);  
				}
				temp = robeName; 
				isJadeGear = Arrays.stream(jadeGear).anyMatch(gear->gear.equals(temp)); 
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
					Bind_2 robe = new Bind_2(robeName); 
					System.out.println("Robe: " + robeName + " created."); 
					return robe;
				}
				extractGearType = new StringBuilder(""); 
				Bind_2 robe = (Bind_2)instantiateGearPiece(gearName, school, level,  extractGearType);
				return robe;
			case "c3": 
				if(Option.getScannerInUse() == true) {
					bootName = sc.nextLine();
					if(!(sc.hasNextLine()))
					{
						sc.close(); 
					}
				}
				else {
					bootName = Interrogative_Word.getBufferReader().readLine();
					bootName = bootName.trim(); 
					System.out.println("Boot Name Read: " + bootName); 
				}
				temp = bootName;
				isJadeGear = Arrays.stream(jadeGear).anyMatch(gear->gear.equals(temp)); 
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
					Bind_3 boot = new Bind_3(bootName); 
					System.out.println("Boot: " + bootName + " created."); 
					return boot;
				}
				extractGearType = new StringBuilder(""); 
				Bind_3 boot = (Bind_3)instantiateGearPiece(gearName, school, level, extractGearType);
				return boot;
			case "c4": 
				if(Option.getScannerInUse() == true) {
					wandName = sc.nextLine();
					if(!(sc.hasNextLine()))
					{
						sc.close(); 
					}
				}
				else {
					wandName = Interrogative_Word.getBufferReader().readLine(); 
					wandName = wandName.trim(); 
					System.out.println("Wand Name Read: " + wandName); 
				}
				temp = wandName; 
				isJadeGear = Arrays.stream(jadeGear).anyMatch(gear->gear.equals(temp)); 
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
					Bind_4 wand = new Bind_4(wandName); 
					System.out.println("Boot: " + wandName + " created."); 
					return wand;
				}
				extractGearType = new StringBuilder(""); 
				Bind_4 wand = (Bind_4)instantiateGearPiece(gearName, school, level, extractGearType);
				return wand;
			case "c5": 
				if(Option.getScannerInUse() == true) {
					athameName = sc.nextLine();
					if(!(sc.hasNextLine()))
					{
						sc.close(); 
					}
				}
				else {
					athameName = Interrogative_Word.getBufferReader().readLine();
					athameName = athameName.trim(); 
					System.out.println("Athame Name Read: " + athameName); 
				}
				temp = athameName; 
				isJadeGear = Arrays.stream(jadeGear).anyMatch(gear->gear.equals(temp)); 
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
					Bind_5 athame = new Bind_5(athameName); 
					System.out.println("Athame: " + athameName + " created."); 
					return athame;
				}
				extractGearType = new StringBuilder(""); 
				Bind_5 athame = (Bind_5)instantiateGearPiece(gearName, school, level, extractGearType);
				return athame;
			case "c6": 
				if(Option.getScannerInUse() == true) {
					amuletName = sc.nextLine();
					if(!(sc.hasNextLine()))
					{
						sc.close(); 
					}
				}
				else {
					amuletName = Interrogative_Word.getBufferReader().readLine(); 
					amuletName = amuletName.trim(); 
					System.out.println("Amulet Name Read: " + amuletName); 
				}
				temp = amuletName;
				isJadeGear = Arrays.stream(jadeGear).anyMatch(gear->gear.equals(temp)); 
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
					Bind_6 amulet = new Bind_6(amuletName); 
					System.out.println("Amulet: " + amuletName + " created."); 
					return amulet;
				}
				extractGearType = new StringBuilder(""); 
				Bind_6 amulet = (Bind_6)instantiateGearPiece(gearName, school, level, extractGearType);
				return amulet;
			case "c7": 
				if(Option.getScannerInUse() == true) {
					ringName = sc.nextLine();
					if(!(sc.hasNextLine()))
					{
						sc.close(); 
					}
				}
				else {
					ringName = Interrogative_Word.getBufferReader().readLine(); 
					ringName = ringName.trim(); 
					System.out.println("Ring Name: " + ringName);
				}
				temp = ringName;
				isJadeGear = Arrays.stream(jadeGear).anyMatch(gear->gear.equals(temp)); 
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
					Bind_7 ring = new Bind_7(ringName); 
					System.out.println("Ring: " + ringName + " created.");
					return ring;
				}
				extractGearType = new StringBuilder(""); 
				Bind_7 ring = (Bind_7)instantiateGearPiece(gearName, school, level, extractGearType);
				return ring;
			case "c8": 
				if(Option.getScannerInUse() == true) {
					deckName = sc.nextLine(); 
					if(!(sc.hasNextLine()))
					{
						sc.close(); 
					}
				}
				else {
					deckName = Interrogative_Word.getBufferReader().readLine(); 
					deckName = deckName.trim(); 
					System.out.println("Deck Name Read: " + deckName); 
				}
				temp = deckName;
				isJadeGear = Arrays.stream(jadeGear).anyMatch(gear->gear.equals(temp)); 
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
					Bind_8 deck = new Bind_8(deckName); 
					System.out.println("Deck: " + deckName + " created.");  
					return deck;
				}
				extractGearType = new StringBuilder(""); 
				Bind_8 deck = (Bind_8)instantiateGearPiece(gearName, school, level, extractGearType);
				return deck;
			case "pet": 
				if(Option.getScannerInUse() == true) {
					petName = sc.nextLine(); 
					if(!(sc.hasNextLine()))
					{
						sc.close(); 
					}
				}
				else {
					petName = Interrogative_Word.getBufferReader().readLine(); 
					petName = petName.trim(); 
					System.out.println("Pet Name Read: " + petName); 
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

	public boolean checkGearName(String gearName, String pieceOfGear, StringBuilder gearType, String school, int level) throws IOException
	{
		// Open connection to database 
		try {
			Connection conn1 = null; 
			String url1 = "jdbc:mysql://localhost:3306/wizard_schema";
			String user = "srik6724";
			String password = "28892K0shair!"; 

			if (Credentials.authenticate(user, password)) {
				System.out.println("Authentication successful");
			} else {
				System.out.println("Authentication failed");
			}

			conn1 = DriverManager.getConnection(url1, user, password); 

			if(conn1 != null) 
			{
				if(pieceOfGear.equals("pet"))
				{
					Option.scannerOrfileOption();
					Scanner sc = new Scanner(System.in); 
					String petType = new String(); 
					System.out.println("Enter the type of your pet here. Make sure to spell it correctly. Otherwise, an error will occur."); 
					if(Option.getScannerInUse() == true) {
						petType = sc.nextLine(); 
						if(!(sc.hasNextLine()))
						{
							sc.close();
						}		
					}
					else {
						petType = Interrogative_Word.getBufferReader().readLine(); 
						System.out.println("Pet Type Read: " + petType);
						Interrogative_Word.getBufferReader().readLine(); 
					}
					//Create a sql string
					ResultSet rs = null;
					try {
						String sqlToExecute = "SELECT typeName, school FROM wizard_schema.pets WHERE typename = ?";
						//Execute the sql string above, but create a statement first.
						PreparedStatement createStatement = conn1.prepareStatement(sqlToExecute); 
						createStatement.setString(1, petType.trim()); 
						//Store the result inside a result set to access the database column's data
						rs = createStatement.executeQuery();  
					} catch(SQLException e) {
						e.printStackTrace();
					}

					boolean iterate = false; 
					
					while(rs.next())
					{
						//Retrieve the typename of the pet
						String typeName = rs.getString("typeName"); 
						System.out.println("Type Name: " + typeName);
						if(petType.trim().equals(typeName.trim()))
						{
							Pet.typeName = typeName.trim(); 
						}
						else  
						{
							System.out.println("Sorry name in database for pet type: " + typeName + " does not match " + petType);
							break;
						}
						//Retrieve the school of the pet 
						String schoolOfPet = rs.getString("school"); 
						System.out.println("School Of Pet: " + schoolOfPet); 
						Pet.school = schoolOfPet; 

						iterate = true; 
					}
					conn1.close(); 
					System.out.println("Iterate bool value: " + iterate); 
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
		System.out.println(gearSets.size()); 
		System.out.println(person); 
		boolean var = false;
		for(String wizard: gearSets.keySet())
		{
			System.out.println("Wizard: " + wizard);
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