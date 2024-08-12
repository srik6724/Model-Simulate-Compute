package Second_Process;
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
import Second_Threading.*;
import RunTime.Disruption.TypeException;
import Logging_Process.LoggingStorage;
import System_State.*;
import System_Variables.*;
public class Second extends Demo_Installation_Terrain implements Nanosecond, Second_Singleton, Second_Recorder {

	private static File initialFile; 

	Second(File file) {
		Second.initialFile = file;
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
		playerStatsState = new ApplicationState<Object>(Second.gearSets, playerStatsPath); 
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
		playerDecksState = new ApplicationState<Object>(Second.decks, playerDecksPath);
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
		Second.schoolsOfTeam.add(Arrays.asList(teamSchools)); 
	}

	void selectPlayerLevelsForTeam() {
		for(int i = 0; i < teamLevels.length; i++) {
			System.out.println("Added " + teamLevels[i] + " level of " + "player " + team[i]); 
		}
		LoggingStorage.getLogger().log(Level.INFO, "Levels for each player on team selected."); 
		BreakpointVariables.setPlayerLevels(true);  
		playerLevelsState = new ApplicationState<Object>(Second.teamLevels, playerLevelsPath); 
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
				line_curr = Second.getBufferReader().readLine();
				gameModeSelection(line_curr);
			}
			else {
				System.out.println("Testing the load state function. Accessing the queue");
				gameModeState = pollQueue(gameModePath); 
			}
		} else {
			line_curr = Second.getBufferReader().readLine();
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
			matchRecorder = Second_Recorder.getFileWriter(); 
		} catch (IOException e) {
			e.printStackTrace(); 
		}
		return matchRecorder;
	}
	
	public static void startModule(int index, FileWriter productWriterFinalizer, FileReader moduleReading) throws IOException, InterruptedException
	{
		FileWriter moduleTeam1SpellsWriter = null;
		FileWriter moduleTeam2SpellsWriter = null;
		FileWriter productCombineWriter = null;
		FileWriter productModuleByModuleWriter = null; 
		FileWriter productExcessSpellsWriter = null;
		FileWriter productExcessSpellsTeam1Writer = null;
		FileWriter productExcessSpellsTeam2Writer = null;
		FileWriter productRemainingSpellsWriter = null;
		FileWriter productRemainingSpellsTeam1Writer = null;
		FileWriter productRemainingSpellsTeam2Writer = null;
		FileWriter productSelectionLineWriter = null;
		FileWriter productSelectionLineTeam1Writer = null;
		FileWriter productSelectionLineTeam2Writer = null;
		FileWriter modulePrGraphWriter = null;
		FileWriter modulePrGraphTeam1Writer = null;
		FileWriter modulePrGraphTeam2Writer = null;
		FileWriter modulePrFactsWriter = null;
		FileWriter modulePrFactsTeam1Writer = null;
		FileWriter modulePrFactsTeam2Writer = null;
		FileWriter modulePrRulesWriter = null;
		FileWriter modulePrRulesTeam1Writer = null;
		FileWriter modulePrRulesTeam2Writer = null;
		FileWriter modulePrInterpretationsWriter = null;
		FileWriter modulePrInterpretationsTeam1Writer = null;
		FileWriter modulePrInterpretationsTeam2Writer = null;
		FileWriter moduleStaticLanguageWriter = null;
		FileWriter moduleStaticLanguageTeam1Writer = null;
		FileWriter moduleStaticLanguageTeam2Writer = null;
		FileWriter moduleChangingLanguageWriter = null;
		FileWriter moduleChangingLanguageTeam1Writer = null;
		FileWriter moduleChangingLanguageTeam2Writer = null;
		FileWriter moduleStaticGrammarWriter = null;
		FileWriter moduleStaticGrammarTeam1Writer = null;
		FileWriter moduleStaticGrammarTeam2Writer = null;
		FileWriter moduleChangingGrammarWriter = null;
		FileWriter moduleChangingGrammarTeam1Writer = null;
		FileWriter moduleChangingGrammarTeam2Writer = null;
		FileWriter moduleGenerationWriter = null;
		FileWriter moduleGenerationTeam1Writer = null;
		FileWriter moduleGenerationTeam2Writer = null;
		FileWriter moduleOrderingPlacementsWriter = null;
		FileWriter moduleOrderingPlacementsTeam1Writer = null;
		FileWriter moduleOrderingPlacementsTeam2Writer = null;
		FileWriter moduleCombineWriter = null;
		FileWriter moduleDefaultWriter = null;
		FileWriter moduleTacticalApproachWriter = null;
		FileWriter moduleTacticalApproachTeam1Writer = null;
		FileWriter moduleTacticalApproachTeam2Writer = null;
		FileWriter moduleSelectionLineWriter = null; 
		FileWriter moduleSelectionLineTeam1Writer = null;
		FileWriter moduleSelectionLineTeam2Writer = null;
		FileWriter moduleRemainingSpellsWriter = null;
		FileWriter moduleRemainingTeam1SpellsWriter = null;
		FileWriter moduleRemainingTeam2SpellsWriter = null;
		FileWriter moduleExcessSpellsWriter = null;
		FileWriter moduleExcessSpellsTeam1Writer = null;
		FileWriter moduleExcessSpellsTeam2Writer = null;
		FileWriter moduleGarbageCollectionWriter = null;
		FileWriter moduleGarbageCollectionTeam1Writer = null;
		FileWriter moduleGarbageCollectionTeam2Writer = null;
		FileWriter moduleLexicalAnalyzerWriter = null;
		FileWriter moduleLexicalAnalyzerTeam1Writer = null;
		FileWriter moduleLexicalAnalyzerTeam2Writer = null;
		FileWriter moduleDFAWriter = null;
		FileWriter moduleDFATeam1Writer = null;
		FileWriter moduleDFATeam2Writer = null;
		FileWriter moduleNFAWriter = null;
		FileWriter moduleNFATeam1Writer = null;
		FileWriter moduleNFATeam2Writer = null;
		FileWriter moduleRunTimeWriter = null;
		FileWriter moduleRunTimeTeam1Writer = null; 
		FileWriter moduleRunTimeTeam2Writer = null;
		FileWriter moduleReferencePointersWriter = null;
		FileWriter moduleReferencePointersTeam1Writer = null;
		FileWriter moduleReferencePointersTeam2Writer = null; 
		FileWriter moduleComputationSpellsWriter = null;
		FileWriter moduleComputationSpellsTeam1Writer = null; 
		FileWriter moduleComputationSpellsTeam2Writer = null;
		FileWriter modulePathTraceWriter = null;
		FileWriter modulePathTraceTeam1Writer = null;
		FileWriter modulePathTraceTeam2Writer = null;
		FileWriter moduleTraceToStartWriter = null;
		FileWriter moduleTraceToStartTeam1Writer = null;
		FileWriter moduleTraceToStartTeam2Writer = null;
		FileWriter moduleSatisfierWriter = null;
		FileWriter moduleSatisfierTeam1Writer = null;
		FileWriter moduleSatisfierTeam2Writer = null;
		FileWriter moduleHistoryWriter = null;
		FileWriter moduleHistoryTeam1Writer = null;
		FileWriter moduleHistoryTeam2Writer = null;
		FileWriter moduleIncorporationConceptWriter = null;
		FileWriter moduleIncorporationConceptTeam1Writer = null;
		FileWriter moduleIncorporationConceptTeam2Writer = null;
		FileWriter moduleCheckPointWriter = null;
		FileWriter moduleCheckPointTeam1Writer = null;
		FileWriter moduleCheckPointTeam2Writer= null;
		FileWriter moduleCompletionTimeWriter = null;
		FileWriter moduleCompletionTeam1Writer = null;
		FileWriter moduleCompletionTeam2Writer = null;
		FileWriter moduleContributionalEstimateWriter = null;
		FileWriter moduleContributionalEstimateTeam1Writer = null;
		FileWriter moduleContributionalEstimateTeam2Writer = null;
		FileWriter moduleAudienceWriter = null;
		FileWriter moduleAudienceTeam1Writer = null;
		FileWriter moduleAudienceTeam2Writer = null;
		FileWriter moduleModeOfOperationsWriter = null;
		FileWriter moduleModeOfOperationsTeam1Writer = null; 
		FileWriter moduleModeOfOperationsTeam2Writer = null;
		FileWriter moduleExtractDataWriter = null;
		FileWriter moduleExtractDataTeam1Writer = null;
		FileWriter moduleExtractDataTeam2Writer = null;
		FileWriter moduleLoggerWriter = null;
		FileWriter moduleLoggerTeam1Writer = null;
		FileWriter moduleLoggerTeam2Writer = null;
		FileWriter moduleEventOccurrenceWriter = null;
		FileWriter moduleEventOccurrenceTeam1Writer = null;
		FileWriter moduleEventOccurrenceTeam2Writer = null;

		int module = Nanosecond.get_current_number(); 
		int size = 0;
		System.out.println("PLAYER ASSOCIATION TO SCHOOL SIZE: " + playerAssociationToSchool.size()); 

		try {
			if(playerAssociationToSchool.size() == 2) {
				NanosecondPrGraphTeam1MemberWriter.get_file_writer(module, 1); 
				NanosecondPrGraphTeam1MemberWriter.file_writers[0].write(""); 
				NanosecondPrFactsTeam1MemberWriter.get_file_writer(module, 1);
				NanosecondPrFactsTeam1MemberWriter.file_writers[0].write(""); 
				NanosecondPrRulesTeam1MemberWriter.get_file_writer(module, 1); 
				NanosecondPrRulesTeam1MemberWriter.file_writers[0].write(""); 
				NanosecondPrInterpretationsTeam1MemberWriter.get_file_writer(module, 1); 
				NanosecondPrInterpretationsTeam1MemberWriter.file_writers[0].write(""); 
				NanosecondStaticLanguageTeam1MemberWriter.get_file_writer(module, 1); 
				NanosecondStaticLanguageTeam1MemberWriter.file_writers[0].write(""); 
				NanosecondChangingLanguageTeam1MemberWriter.get_file_writer(module, 1); 
				NanosecondChangingLanguageTeam1MemberWriter.file_writers[0].write(""); 
			  NanosecondStaticGrammarTeam1MemberWriter.get_file_writer(module, 1); 
				NanosecondStaticGrammarTeam1MemberWriter.file_writers[0].write(""); 
				NanosecondChangingGrammarTeam1MemberWriter.get_file_writer(module, 1); 
				NanosecondChangingGrammarTeam1MemberWriter.file_writers[0].write(""); 
				NanosecondGenerationTeam1MemberWriter.get_file_writer(module, 1); 
				NanosecondGenerationTeam1MemberWriter.file_writers[0].write(""); 
				NanosecondOrderingPlacementsTeam1MemberWriter.get_file_writer(module, 1);
				NanosecondOrderingPlacementsTeam1MemberWriter.file_writers[0].write(""); 
				NanosecondCombineTeam1MemberWriter.get_file_writer(module, 1); 
				NanosecondCombineTeam1MemberWriter.file_writers[0].write(""); 
				NanosecondTeam1MemberSpellsWriter.get_file_writer(module, 1); 
				NanosecondTeam1MemberSpellsWriter.file_writers[0].write("");
				NanosecondTacticalApproachTeam1MemberWriter.get_file_writer(module, 1); 
				NanosecondTacticalApproachTeam1MemberWriter.file_writers[0].write(""); 
				NanosecondSelectionTeam1MemberSpellsWriter.get_file_writer(module, 1); 
				NanosecondSelectionTeam1MemberSpellsWriter.file_writers[0].write(""); 
				NanosecondLeftOverTeam1MemberSpellsWriter.get_file_writer(module, 1);
				NanosecondLeftOverTeam1MemberSpellsWriter.file_writers[0].write(""); 
				NanosecondDiscardTeam1MemberSpellsWriter.get_file_writer(module, 1); 
				NanosecondDiscardTeam1MemberSpellsWriter.file_writers[0].write(""); 
				NanosecondGarbageCollectionTeam1MemberWriter.get_file_writer(module, 1); 
				NanosecondGarbageCollectionTeam1MemberWriter.file_writers[0].write(""); 
				NanosecondLexicalAnalyzerTeam1MemberWriter.get_file_writer(module, 1); 
				NanosecondLexicalAnalyzerTeam1MemberWriter.file_writers[0].write(""); 
				NanosecondDFATeam1MemberWriter.get_file_writer(module, 1);
				NanosecondDFATeam1MemberWriter.file_writers[0].write(""); 
				NanosecondNFATeam1MemberWriter.get_file_writer(module, 1);
				NanosecondNFATeam1MemberWriter.file_writers[0].write(""); 
				NanosecondRunTimeTeam1MemberWriter.get_file_writer(module, 1); 
				NanosecondRunTimeTeam1MemberWriter.file_writers[0].write("");
				NanosecondReferencePointersTeam1MemberWriter.get_file_writer(module, 1); 
				NanosecondReferencePointersTeam1MemberWriter.file_writers[0].write(""); 
				NanosecondOutputSpellsTeam1MemberWriter.get_file_writer(module, 1); 
				NanosecondOutputSpellsTeam1MemberWriter.file_writers[0].write(""); 
				NanosecondPathTraceTeam1MemberWriter.get_file_writer(module, 1);
				NanosecondPathTraceTeam1MemberWriter.file_writers[0].write(""); 
				NanosecondTraceToStartTeam1MemberWriter.get_file_writer(module, 1); 
				NanosecondTraceToStartTeam1MemberWriter.file_writers[0].write(""); 
				NanosecondSatisfierTeam1MemberWriter.get_file_writer(module, 1); 
				NanosecondSatisfierTeam1MemberWriter.file_writers[0].write(""); 
				NanosecondHistoryTeam1MemberWriter.get_file_writer(module, 1); 
				NanosecondHistoryTeam1MemberWriter.file_writers[0].write(""); 
				NanosecondIncorporationConceptTeam1MemberWriter.get_file_writer(module, 1); 
				NanosecondIncorporationConceptTeam1MemberWriter.file_writers[0].write(""); 
				NanosecondCheckPointTeam1MemberWriter.get_file_writer(module, 1); 
				NanosecondCheckPointTeam1MemberWriter.file_writers[0].write(""); 
				NanosecondContributionalEstimateTeam1MemberWriter.get_file_writer(module, 1); 
				NanosecondContributionalEstimateTeam1MemberWriter.file_writers[0].write(""); 
				NanosecondAudienceTeam1MemberWriter.get_file_writer(module, 1); 
				NanosecondAudienceTeam1MemberWriter.file_writers[0].write(""); 
				NanosecondModeOfOperationsTeam1MemberWriter.get_file_writer(module, 1); 
				NanosecondModeOfOperationsTeam1MemberWriter.file_writers[0].write(""); 
				NanosecondExtractDataTeam1MemberWriter.get_file_writer(module, 1); 
				NanosecondExtractDataTeam1MemberWriter.file_writers[0].write(""); 
				NanosecondLoggerTeam1MemberWriter.get_file_writer(module, 1); 
				NanosecondLoggerTeam1MemberWriter.file_writers[0].write(""); 
				NanosecondPrGraphTeam2MemberWriter.get_file_writer(module, 1); 
				NanosecondPrGraphTeam2MemberWriter.file_writers[0].write(""); 
				NanosecondPrFactsTeam2MemberWriter.get_file_writer(module, 1);
				NanosecondPrFactsTeam2MemberWriter.file_writers[0].write(""); 
				NanosecondPrRulesTeam2MemberWriter.get_file_writer(module, 1); 
				NanosecondPrRulesTeam2MemberWriter.file_writers[0].write(""); 
				NanosecondPrInterpretationsTeam2MemberWriter.get_file_writer(module, 1); 
				NanosecondPrInterpretationsTeam2MemberWriter.file_writers[0].write(""); 
				NanosecondStaticLanguageTeam2MemberWriter.get_file_writer(module, 1); 
				NanosecondStaticLanguageTeam2MemberWriter.file_writers[0].write(""); 
				NanosecondChangingLanguageTeam2MemberWriter.get_file_writer(module, 1); 
				NanosecondChangingLanguageTeam2MemberWriter.file_writers[0].write(""); 
				NanosecondStaticGrammarTeam2MemberWriter.get_file_writer(module, 1); 
				NanosecondStaticGrammarTeam2MemberWriter.file_writers[0].write(""); 
				NanosecondChangingGrammarTeam2MemberWriter.get_file_writer(module, 1); 
				NanosecondChangingGrammarTeam2MemberWriter.file_writers[0].write(""); 
				NanosecondGenerationTeam2MemberWriter.get_file_writer(module, 1); 
				NanosecondGenerationTeam2MemberWriter.file_writers[0].write(""); 
				NanosecondOrderingPlacementsTeam2MemberWriter.get_file_writer(module, 1);
				NanosecondOrderingPlacementsTeam2MemberWriter.file_writers[0].write(""); 
				NanosecondCombineTeam2MemberWriter.get_file_writer(module, 1);
				NanosecondCombineTeam2MemberWriter.file_writers[0].write(""); 
				NanosecondTeam2MemberSpellsWriter.get_file_writer(module, 1); 
				NanosecondTeam2MemberSpellsWriter.file_writers[0].write(""); 
				NanosecondTacticalApproachTeam2MemberWriter.get_file_writer(module, 1); 
				NanosecondTacticalApproachTeam2MemberWriter.file_writers[0].write(""); 
				NanosecondSelectionTeam2MemberSpellsWriter.get_file_writer(module, 1); 
				NanosecondSelectionTeam2MemberSpellsWriter.file_writers[0].write(""); 
				NanosecondLeftOverTeam2MemberSpellsWriter.get_file_writer(module, 1); 
				NanosecondLeftOverTeam2MemberSpellsWriter.file_writers[0].write("");
				NanosecondDiscardTeam2MemberSpellsWriter.get_file_writer(module, 1); 
				NanosecondDiscardTeam2MemberSpellsWriter.file_writers[0].write(""); 
				NanosecondGarbageCollectionTeam2MemberWriter.get_file_writer(module, 1); 
				NanosecondGarbageCollectionTeam2MemberWriter.file_writers[0].write(""); 
				NanosecondLexicalAnalyzerTeam2MemberWriter.get_file_writer(module, 1); 
				NanosecondLexicalAnalyzerTeam2MemberWriter.file_writers[0].write(""); 
				NanosecondDFATeam2MemberWriter.get_file_writer(module, 1);
				NanosecondDFATeam2MemberWriter.file_writers[0].write(""); 
				NanosecondNFATeam2MemberWriter.get_file_writer(module, 1);
				NanosecondNFATeam2MemberWriter.file_writers[0].write(""); 
				NanosecondRunTimeTeam2MemberWriter.get_file_writer(module, 1);
				NanosecondRunTimeTeam2MemberWriter.file_writers[0].write("");
				NanosecondReferencePointersTeam2MemberWriter.get_file_writer(module, 1); 
				NanosecondReferencePointersTeam2MemberWriter.file_writers[0].write(""); 
				NanosecondOutputSpellsTeam2MemberWriter.get_file_writer(module, 1); 
				NanosecondOutputSpellsTeam2MemberWriter.file_writers[0].write(""); 
				NanosecondPathTraceTeam2MemberWriter.get_file_writer(module, 1);
				NanosecondPathTraceTeam2MemberWriter.file_writers[0].write(""); 
				NanosecondTraceToStartTeam2MemberWriter.get_file_writer(module, 1); 
				NanosecondTraceToStartTeam2MemberWriter.file_writers[0].write(""); 
				NanosecondSatisfierTeam2MemberWriter.get_file_writer(module, 1); 
				NanosecondSatisfierTeam2MemberWriter.file_writers[0].write(""); 
				NanosecondHistoryTeam2MemberWriter.get_file_writer(module, 1); 
				NanosecondHistoryTeam2MemberWriter.file_writers[0].write(""); 
				NanosecondIncorporationConceptTeam2MemberWriter.get_file_writer(module, 1); 
				NanosecondIncorporationConceptTeam2MemberWriter.file_writers[0].write(""); 
				NanosecondCheckPointTeam2MemberWriter.get_file_writer(module, 1); 
				NanosecondCheckPointTeam2MemberWriter.file_writers[0].write(""); 
				NanosecondContributionalEstimateTeam2MemberWriter.get_file_writer(module, 1); 
				NanosecondContributionalEstimateTeam2MemberWriter.file_writers[0].write(""); 
				NanosecondAudienceTeam2MemberWriter.get_file_writer(module, 1); 
				NanosecondAudienceTeam2MemberWriter.file_writers[0].write(""); 
				NanosecondModeOfOperationsTeam2MemberWriter.get_file_writer(module, 1); 
				NanosecondModeOfOperationsTeam2MemberWriter.file_writers[0].write(""); 
				NanosecondExtractDataTeam2MemberWriter.get_file_writer(module, 1); 
				NanosecondExtractDataTeam2MemberWriter.file_writers[0].write(""); 
				NanosecondLoggerTeam2MemberWriter.get_file_writer(module, 1); 
				NanosecondLoggerTeam2MemberWriter.file_writers[0].write(""); 
				size = 1; 
			}
			else if(playerAssociationToSchool.size() == 4) {
				NanosecondTeam1MemberSpellsWriter.get_file_writer(module, 1); 
				NanosecondTeam1MemberSpellsWriter.file_writers[0].write(""); 
				NanosecondTeam1MemberSpellsWriter.get_file_writer(module, 2); 
				NanosecondTeam1MemberSpellsWriter.file_writers[1].write(""); 
				NanosecondTeam2MemberSpellsWriter.get_file_writer(module, 1);
				NanosecondTeam2MemberSpellsWriter.file_writers[0].write(""); 
				NanosecondTeam2MemberSpellsWriter.get_file_writer(module, 2); 
				NanosecondTeam2MemberSpellsWriter.file_writers[1].write(""); 
				size = 4; 
			}
			else if(playerAssociationToSchool.size() == 6) {
				NanosecondTeam1MemberSpellsWriter.get_file_writer(module, 1); 
				NanosecondTeam1MemberSpellsWriter.file_writers[0].write(""); 
				NanosecondTeam1MemberSpellsWriter.get_file_writer(module, 2); 
				NanosecondTeam1MemberSpellsWriter.file_writers[1].write(""); 
				NanosecondTeam1MemberSpellsWriter.get_file_writer(module, 3); 
				NanosecondTeam1MemberSpellsWriter.file_writers[2].write(""); 
				NanosecondTeam2MemberSpellsWriter.get_file_writer(module, 1); 
				NanosecondTeam2MemberSpellsWriter.file_writers[0].write(""); 
				NanosecondTeam2MemberSpellsWriter.get_file_writer(module, 2); 
				NanosecondTeam2MemberSpellsWriter.file_writers[1].write(""); 
				NanosecondTeam2MemberSpellsWriter.get_file_writer(module, 3); 
				NanosecondTeam2MemberSpellsWriter.file_writers[2].write(""); 
				size = 6; 
			}
			else if(playerAssociationToSchool.size() == 8) {
				NanosecondTeam1MemberSpellsWriter.get_file_writer(module, 1); 
				NanosecondTeam1MemberSpellsWriter.file_writers[0].write(""); 
				NanosecondTeam1MemberSpellsWriter.get_file_writer(module, 2); 
				NanosecondTeam1MemberSpellsWriter.file_writers[1].write(""); 
				NanosecondTeam1MemberSpellsWriter.get_file_writer(module, 3); 
				NanosecondTeam1MemberSpellsWriter.file_writers[2].write(""); 
				NanosecondTeam1MemberSpellsWriter.get_file_writer(module, 4); 
				NanosecondTeam1MemberSpellsWriter.file_writers[3].write(""); 
				NanosecondTeam2MemberSpellsWriter.get_file_writer(module, 1); 
				NanosecondTeam2MemberSpellsWriter.file_writers[0].write(""); 
				NanosecondTeam2MemberSpellsWriter.get_file_writer(module, 2); 
				NanosecondTeam2MemberSpellsWriter.file_writers[1].write(""); 
				NanosecondTeam2MemberSpellsWriter.get_file_writer(module, 3); 
				NanosecondTeam2MemberSpellsWriter.file_writers[2].write(""); 
				NanosecondTeam2MemberSpellsWriter.get_file_writer(module, 4); 
				NanosecondTeam2MemberSpellsWriter.file_writers[3].write(""); 
				size = 8; 
			}
			productCombineWriter = SecondCombineWriter.get_file_writer();
			productCombineWriter.write(""); 
			productModuleByModuleWriter = ModuleByModuleWriter.get_file_writer();
			productModuleByModuleWriter.write(""); 
			productExcessSpellsWriter = SecondDiscardSpellsWriter.get_file_writer();
			productExcessSpellsWriter.write(""); 
			productExcessSpellsTeam1Writer = SecondDiscardSpellsTeam1Writer.get_file_writer();
			productExcessSpellsTeam1Writer.write(""); 
			productExcessSpellsTeam2Writer = SecondDiscardSpellsTeam2Writer.get_file_writer();
			productExcessSpellsTeam2Writer.write("");
			productRemainingSpellsWriter = SecondLeftOverSpellsWriter.get_file_writer();
			productRemainingSpellsWriter.write(""); 
			productRemainingSpellsTeam1Writer = SecondLeftOverSpellsTeam1Writer.get_file_writer();
			productRemainingSpellsTeam1Writer.write(""); 
			productRemainingSpellsTeam2Writer = SecondLeftOverSpellsTeam2Writer.get_file_writer();
			productRemainingSpellsTeam2Writer.write(""); 
			productSelectionLineWriter = SecondSelectionWriter.get_file_writer(); 
			productSelectionLineWriter.write(""); 
			productSelectionLineTeam1Writer = ProductSelectionTeam1Writer.get_file_writer();
			productSelectionLineTeam1Writer.write(""); 
			productSelectionLineTeam2Writer = SecondSelectionTeam2Writer.get_file_writer();
			productSelectionLineTeam2Writer.write(""); 
			modulePrGraphWriter = NanosecondPrGraphWriter.get_file_writer(module); 
			modulePrGraphWriter.write(""); 
			modulePrGraphTeam1Writer = NanosecondPrGraphTeam1Writer.get_file_writer(module); 
			modulePrGraphTeam1Writer.write(""); 
			modulePrGraphTeam2Writer = NanosecondPrGraphTeam2Writer.get_file_writer(module); 
			modulePrGraphTeam2Writer.write(""); 
			modulePrFactsWriter = NanosecondPrFactsWriter.get_file_writer(module); 
			modulePrFactsWriter.write(""); 
			modulePrFactsTeam1Writer = NanosecondPrFactsTeam1Writer.get_file_writer(module); 
			modulePrFactsTeam1Writer.write(""); 
			modulePrFactsTeam2Writer = NanosecondPrFactsTeam2Writer.get_file_writer(module); 
			modulePrFactsTeam2Writer.write(""); 
			modulePrRulesWriter = NanosecondPrRulesWriter.get_file_writer(module); 
			modulePrRulesWriter.write(""); 
			modulePrRulesTeam1Writer = NanosecondPrRulesTeam1Writer.get_file_writer(module); 
			modulePrRulesTeam1Writer.write(""); 
			modulePrRulesTeam2Writer = NanosecondPrRulesTeam2Writer.get_file_writer(module); 
			modulePrRulesTeam2Writer.write(""); 
			modulePrInterpretationsWriter = NanosecondPrInterpretationsWriter.get_file_writer(module); 
			modulePrInterpretationsWriter.write(""); 
			modulePrInterpretationsTeam1Writer = NanosecondPrInterpretationsTeam1Writer.get_file_writer(module); 
			modulePrInterpretationsTeam1Writer.write(""); 
			modulePrInterpretationsTeam2Writer = NanosecondPrInterpretationsTeam2Writer.get_file_writer(module); 
			modulePrInterpretationsTeam2Writer.write(""); 
			moduleStaticLanguageWriter = NanosecondStaticLanguageWriter.get_file_writer(module); 
			moduleStaticLanguageWriter.write(""); 
			moduleStaticLanguageTeam1Writer = NanosecondStaticLanguageTeam1Writer.get_file_writer(module); 
			moduleStaticLanguageTeam1Writer.write(""); 
			moduleStaticLanguageTeam2Writer = ModuleStaticLanguageTeam2Writer.get_file_writer(module); 
			moduleStaticLanguageTeam2Writer.write(""); 
			moduleChangingLanguageWriter = NanosecondChangingLanguageWriter.get_file_writer(module);
			moduleChangingLanguageWriter.write(""); 
			moduleChangingLanguageTeam1Writer = NanosecondChangingLanguageTeam1Writer.get_file_writer(module); 
			moduleChangingLanguageTeam1Writer.write(""); 
			moduleChangingLanguageTeam2Writer = NanosecondChangingLanguageTeam2Writer.get_file_writer(module); 
			moduleChangingLanguageTeam2Writer.write(""); 
			moduleStaticGrammarWriter = NanosecondStaticGrammarWriter.get_file_writer(module); 
			moduleStaticGrammarWriter.write(""); 
			moduleStaticGrammarTeam1Writer = NanosecondStaticGrammarTeam1Writer.get_file_writer(module);
			moduleStaticGrammarTeam1Writer.write(""); 
			moduleStaticGrammarTeam2Writer = NanosecondStaticGrammarTeam2Writer.get_file_writer(module); 
			moduleStaticGrammarTeam2Writer.write(""); 
			moduleChangingGrammarWriter = NanosecondChangingGrammarWriter.get_file_writer(module); 
			moduleChangingGrammarWriter.write(""); 
			moduleChangingGrammarTeam1Writer = NanosecondChangingGrammarTeam1Writer.get_file_writer(module); 
			moduleChangingGrammarTeam1Writer.write(""); 
			moduleChangingGrammarTeam2Writer = NanosecondChangingGrammarTeam2Writer.get_file_writer(module); 
			moduleChangingGrammarTeam2Writer.write(""); 
			moduleGenerationWriter = NanosecondGenerationWriter.get_file_writer(module);
			moduleGenerationWriter.write(""); 
			moduleGenerationTeam1Writer = NanosecondGenerationTeam1Writer.get_file_writer(module); 
			moduleGenerationTeam1Writer.write(""); 
			moduleGenerationTeam2Writer = NanosecondGenerationTeam2Writer.get_file_writer(module); 
			moduleGenerationTeam2Writer.write(""); 
			moduleOrderingPlacementsWriter = NanosecondOrderingPlacementsWriter.get_file_writer(module); 
			moduleOrderingPlacementsWriter.write(""); 
			moduleOrderingPlacementsTeam1Writer = NanosecondOrderingPlacementsTeam1Writer.get_file_writer(module); 
			moduleOrderingPlacementsTeam1Writer.write(""); 
			moduleOrderingPlacementsTeam2Writer = NanosecondOrderingPlacementsTeam2Writer.get_file_writer(module); 
			moduleOrderingPlacementsTeam2Writer.write(""); 
			moduleCombineWriter = NanosecondCombineWriter.get_file_writer(module); 
			moduleCombineWriter.write(""); 
			moduleTeam1SpellsWriter = NanosecondTeam1SpellsWriter.get_file_writer(module); 
			moduleTeam1SpellsWriter.write(""); 
			moduleTeam2SpellsWriter = NanosecondTeam2SpellsWriter.get_file_writer(module); 
			moduleTeam2SpellsWriter.write(""); 
			moduleDefaultWriter = NanosecondOfSpellsWriter.get_file_writer(module);
			moduleDefaultWriter.write(""); 
			moduleTacticalApproachWriter = NanosecondTacticalApproachWriter.get_file_writer(module);
			moduleTacticalApproachWriter.write(""); 
			moduleTacticalApproachTeam1Writer = NanosecondTacticalApproachTeam1Writer.get_file_writer(module);  
			moduleTacticalApproachTeam1Writer.write(""); 
			moduleTacticalApproachTeam2Writer = NanosecondTacticalApproachTeam2Writer.get_file_writer(module); 
			moduleTacticalApproachTeam2Writer.write(""); 
			moduleSelectionLineWriter = NanosecondSelectionWriter.get_file_writer(module); 
			moduleSelectionLineWriter.write(""); 
			moduleSelectionLineTeam1Writer = NanosecondSelectionTeam1Writer.get_file_writer(module); 
			moduleSelectionLineTeam1Writer.write(""); 
			moduleSelectionLineTeam2Writer = NanosecondSelectionTeam2Writer.get_file_writer(module); 
			moduleSelectionLineTeam2Writer.write(""); 
			moduleRemainingSpellsWriter = NanosecondLeftOverSpellsWriter.get_file_writer(module);
			moduleRemainingSpellsWriter.write(""); 
			moduleRemainingTeam1SpellsWriter = NanosecondLeftOverSpellsTeam1Writer.get_file_writer(module); 
			moduleRemainingTeam1SpellsWriter.write(""); 
			moduleRemainingTeam2SpellsWriter = NanosecondLeftOverSpellsTeam2Writer.get_file_writer(module); 
			moduleRemainingTeam2SpellsWriter.write(""); 
			moduleExcessSpellsWriter = NanosecondDiscardSpellsWriter.get_file_writer(module); 
			moduleExcessSpellsWriter.write(""); 
			moduleExcessSpellsTeam1Writer = NanosecondDiscardSpellsTeam1Writer.get_file_writer(module); 
			moduleExcessSpellsTeam1Writer.write(""); 
			moduleExcessSpellsTeam2Writer = NanosecondDiscardSpellsTeam2Writer.get_file_writer(module); 
			moduleExcessSpellsTeam2Writer.write(""); 
			moduleGarbageCollectionWriter = NanosecondGarbageCollectionWriter.get_file_writer(module); 
			moduleGarbageCollectionWriter.write(""); 
			moduleGarbageCollectionTeam1Writer = NanosecondGarbageCollectionTeam1Writer.get_file_writer(module); 
			moduleGarbageCollectionTeam1Writer.write(""); 
			moduleGarbageCollectionTeam2Writer = NanosecondGarbageCollectionTeam2Writer.get_file_writer(module); 
			moduleGarbageCollectionTeam2Writer.write(""); 
			moduleLexicalAnalyzerWriter = NanosecondLexicalAnalyzerWriter.get_file_writer(module); 
			moduleLexicalAnalyzerWriter.write(""); 
			moduleLexicalAnalyzerTeam1Writer = NanosecondLexicalAnalyzerTeam1Writer.get_file_writer(module); 
			moduleLexicalAnalyzerTeam1Writer.write(""); 
			moduleLexicalAnalyzerTeam2Writer = NanosecondLexicalAnalyzerTeam2Writer.get_file_writer(module); 
			moduleLexicalAnalyzerTeam2Writer.write(""); 
			moduleDFAWriter = NanosecondDFAWriter.get_file_writer(module); 
			moduleDFAWriter.write(""); 
			moduleDFATeam1Writer = NanosecondDFATeam1Writer.get_file_writer(module); 
			moduleDFATeam1Writer.write(""); 
			moduleDFATeam2Writer = NanosecondDFATeam2Writer.get_file_writer(module); 
			moduleDFATeam2Writer.write("");
			moduleNFAWriter = NanosecondNFAWriter.get_file_writer(module); 
			moduleNFAWriter.write(""); 
			moduleNFATeam1Writer = NanosecondNFATeam1Writer.get_file_writer(module); 
			moduleNFATeam1Writer.write(""); 
			moduleNFATeam2Writer = NanosecondNFATeam2Writer.get_file_writer(module); 
			moduleNFATeam2Writer.write(""); 
			moduleRunTimeWriter = NanosecondRunTimeWriter.get_file_writer(module); 
			moduleRunTimeWriter.write(""); 
			moduleRunTimeTeam1Writer = NanosecondRunTimeTeam1Writer.get_file_writer(module); 
			moduleRunTimeTeam1Writer.write(""); 
			moduleRunTimeTeam2Writer = NanosecondRunTimeTeam2Writer.get_file_writer(module); 
			moduleRunTimeTeam2Writer.write(""); 
			moduleReferencePointersWriter = NanosecondReferencePointersWriter.get_file_writer(module); 
			moduleReferencePointersWriter.write(""); 
			moduleReferencePointersTeam1Writer = NanosecondReferencePointersTeam1Writer.get_file_writer(module); 
			moduleReferencePointersTeam1Writer.write(""); 
			moduleReferencePointersTeam2Writer = NanosecondReferencePointersTeam2Writer.get_file_writer(module); 
			moduleReferencePointersTeam2Writer.write(""); 
			moduleComputationSpellsWriter = NanosecondOutputSpellsWriter.get_file_writer(module); 
			moduleComputationSpellsWriter.write(""); 
			moduleComputationSpellsTeam1Writer = NanosecondOutputSpellsTeam1Writer.get_file_writer(module); 
			moduleComputationSpellsTeam1Writer.write(""); 
			moduleComputationSpellsTeam2Writer = NanosecondOutputSpellsTeam2Writer.get_file_writer(module); 
			moduleComputationSpellsTeam2Writer.write(""); 
			modulePathTraceWriter = NanosecondPathTraceWriter.get_file_writer(module); 
			modulePathTraceWriter.write(""); 
			modulePathTraceTeam1Writer = NanosecondPathTraceTeam1Writer.get_file_writer(module); 
			modulePathTraceTeam1Writer.write(""); 
			modulePathTraceTeam2Writer = NanosecondPathTraceTeam2Writer.get_file_writer(module); 
			modulePathTraceTeam2Writer.write(""); 
			moduleTraceToStartWriter = NanosecondTraceToStartWriter.get_file_writer(module); 
			moduleTraceToStartWriter.write(""); 
			moduleTraceToStartTeam1Writer = NanosecondTraceToStartTeam1Writer.get_file_writer(module); 
			moduleTraceToStartTeam1Writer.write(""); 
			moduleTraceToStartTeam2Writer = NanosecondTraceToStartTeam2Writer.get_file_writer(module); 
			moduleTraceToStartTeam2Writer.write(""); 
			moduleSatisfierWriter = NanosecondSatisfierWriter.get_file_writer(module); 
			moduleSatisfierWriter.write(""); 
			moduleSatisfierTeam1Writer = NanosecondSatisfierTeam1Writer.get_file_writer(module); 
			moduleSatisfierTeam1Writer.write(""); 
			moduleSatisfierTeam2Writer = NanosecondSatisfierTeam2Writer.get_file_writer(module); 
			moduleSatisfierTeam2Writer.write(""); 
			moduleHistoryWriter = NanosecondHistoryWriter.get_file_writer(module); 
			moduleHistoryWriter.write(""); 
			moduleHistoryTeam1Writer = NanosecondHistoryTeam1Writer.get_file_writer(module); 
			moduleHistoryTeam1Writer.write(""); 
			moduleHistoryTeam2Writer = NanosecondHistoryTeam2Writer.get_file_writer(module); 
			moduleHistoryTeam2Writer.write(""); 
			moduleIncorporationConceptWriter = NanosecondIncorporationConceptTeam1Writer.get_file_writer(module); 
			moduleIncorporationConceptWriter.write(""); 
			moduleIncorporationConceptTeam1Writer = NanosecondIncorporationConceptTeam1Writer.get_file_writer(module); 
			moduleIncorporationConceptTeam1Writer.write(""); 
			moduleIncorporationConceptTeam2Writer = NanosecondIncorporationConceptTeam2Writer.get_file_writer(module); 
			moduleIncorporationConceptTeam2Writer.write(""); 
			moduleCheckPointWriter = NanosecondCheckPointWriter.get_file_writer(module); 
			moduleCheckPointWriter.write(""); 
			moduleCheckPointTeam1Writer = NanosecondCheckPointTeam1Writer.get_file_writer(module); 
			moduleCheckPointTeam1Writer.write(""); 
			moduleCheckPointTeam2Writer = NanosecondCheckPointTeam2Writer.get_file_writer(module); 
			moduleCheckPointTeam2Writer.write(""); 
			moduleContributionalEstimateWriter = NanosecondContributionalEstimateWriter.get_file_writer(module);
			moduleContributionalEstimateWriter.write(""); 
			moduleContributionalEstimateTeam1Writer = NanosecondContributionalEstimateTeam1Writer.get_file_writer(module); 
			moduleContributionalEstimateTeam1Writer.write(""); 
			moduleContributionalEstimateTeam2Writer = NanosecondContributionalEstimateTeam2Writer.get_file_writer(module); 
			moduleContributionalEstimateTeam2Writer.write(""); 
			moduleAudienceWriter = NanosecondAudienceWriter.get_file_writer(module); 
			moduleAudienceWriter.write(""); 
			moduleAudienceTeam1Writer = NanosecondAudienceTeam1Writer.get_file_writer(module); 
			moduleAudienceTeam1Writer.write(""); 
			moduleAudienceTeam2Writer = NanosecondAudienceTeam2Writer.get_file_writer(module);
			moduleAudienceTeam2Writer.write(""); 
			moduleModeOfOperationsWriter = NanosecondModeOfOperationsWriter.get_file_writer(module);
			moduleModeOfOperationsWriter.write(""); 
			moduleModeOfOperationsTeam1Writer = NanosecondModeOfOperationsTeam1Writer.get_file_writer(module);
			moduleModeOfOperationsTeam1Writer.write(""); 
			moduleModeOfOperationsTeam2Writer = NanosecondModeOfOperationsTeam2Writer.get_file_writer(module); 
			moduleModeOfOperationsTeam2Writer.write(""); 
			moduleExtractDataWriter = NanosecondExtractDataWriter.get_file_writer(module);
			moduleExtractDataWriter.write("");
			moduleExtractDataTeam1Writer = NanosecondExtractDataTeam1Writer.get_file_writer(module);
			moduleExtractDataTeam1Writer.write("");
			moduleExtractDataTeam2Writer = NanosecondExtractDataTeam2Writer.get_file_writer(module);
			moduleExtractDataTeam2Writer.write("");
			moduleLoggerWriter = NanosecondLoggerWriter.get_file_writer(module);
			moduleLoggerWriter.write("");
			moduleLoggerTeam1Writer = NanosecondLoggerTeam1Writer.get_file_writer(module);
			moduleLoggerTeam1Writer.write(""); 
			moduleLoggerTeam2Writer = NanosecondLoggerTeam2Writer.get_file_writer(module); 
			moduleLoggerTeam2Writer.write(""); 	
		} catch (Exception e) {
			if(playerAssociationToSchool.size() == 2) {
				NanosecondStaticLanguageTeam1MemberWriter.setWriterCreated(false);
				NanosecondStaticLanguageTeam1MemberWriter.get_file_writer(module, 1); 
				NanosecondChangingLanguageTeam1MemberWriter.setWriterCreated(false); 
				NanosecondChangingLanguageTeam1MemberWriter.get_file_writer(module, 1); 
				NanosecondChangingLanguageTeam1MemberWriter.file_writers[0].write(""); 
				NanosecondStaticGrammarTeam1MemberWriter.setWriterCreated(false); 
				NanosecondStaticGrammarTeam1MemberWriter.get_file_writer(module, 1); 
				NanosecondChangingGrammarTeam1MemberWriter.setWriterCreated(false);
				NanosecondChangingGrammarTeam1MemberWriter.get_file_writer(module, 1); 
				NanosecondGenerationTeam1MemberWriter.setWriterCreated(false); 
				NanosecondGenerationTeam1MemberWriter.get_file_writer(module, 1); 
				NanosecondOrderingPlacementsTeam1MemberWriter.setWriterCreated(false);
				NanosecondOrderingPlacementsTeam1MemberWriter.get_file_writer(module, 1); 
				NanosecondCombineTeam1MemberWriter.setWriterCreated(false);
				NanosecondCombineTeam1MemberWriter.get_file_writer(module, 1);
				NanosecondTeam1MemberSpellsWriter.setWriterCreated(false); 
				NanosecondTeam1MemberSpellsWriter.get_file_writer(module, 1); 
				NanosecondTacticalApproachTeam1MemberWriter.setWriterCreated(false); 
				NanosecondTacticalApproachTeam1MemberWriter.get_file_writer(module, 1); 
				NanosecondSelectionTeam1MemberSpellsWriter.setWriterCreated(false); 
				NanosecondSelectionTeam1MemberSpellsWriter.get_file_writer(module, 1); 
				NanosecondLeftOverTeam1MemberSpellsWriter.setWriterCreated(false); 
				NanosecondLeftOverTeam1MemberSpellsWriter.get_file_writer(module, 1);
				NanosecondDiscardTeam1MemberSpellsWriter.setWriterCreated(false);
				NanosecondDiscardTeam1MemberSpellsWriter.get_file_writer(module, 1);
				NanosecondGarbageCollectionTeam1MemberWriter.setWriterCreated(false); 
				NanosecondGarbageCollectionTeam1MemberWriter.get_file_writer(module, 1);
				NanosecondLexicalAnalyzerTeam1MemberWriter.setWriterCreated(false); 
				NanosecondLexicalAnalyzerTeam1MemberWriter.get_file_writer(module, 1); 
				NanosecondGarbageCollectionTeam1MemberWriter.setWriterCreated(false); 
				NanosecondGarbageCollectionTeam1MemberWriter.get_file_writer(module, 1); 
				NanosecondLexicalAnalyzerTeam1MemberWriter.setWriterCreated(false); 
				NanosecondLexicalAnalyzerTeam1MemberWriter.get_file_writer(module, 1); 
				NanosecondDFATeam1MemberWriter.setWriterCreated(false);
				NanosecondDFATeam1MemberWriter.get_file_writer(module, 1);
				NanosecondNFATeam1MemberWriter.setWriterCreated(false);
				NanosecondNFATeam1MemberWriter.get_file_writer(module, 1);
				NanosecondRunTimeTeam1MemberWriter.setWriterCreated(false); 
				NanosecondRunTimeTeam1MemberWriter.get_file_writer(module, 1); 
				NanosecondReferencePointersTeam1MemberWriter.setWriterCreated(false); 
				NanosecondReferencePointersTeam1MemberWriter.get_file_writer(module, 1); 
				NanosecondOutputSpellsTeam1MemberWriter.setWriterCreated(false);
				NanosecondOutputSpellsTeam1MemberWriter.get_file_writer(module, 1); 
				NanosecondPathTraceTeam1MemberWriter.setWriterCreated(false);
				NanosecondPathTraceTeam1MemberWriter.get_file_writer(module, 1);
				NanosecondTraceToStartTeam1MemberWriter.setWriterCreated(false); 
				NanosecondTraceToStartTeam1MemberWriter.get_file_writer(module, 1); 
				NanosecondSatisfierTeam1MemberWriter.setWriterCreated(false);
				NanosecondSatisfierTeam1MemberWriter.get_file_writer(module, 1); 
				NanosecondHistoryTeam1MemberWriter.setWriterCreated(false);
				NanosecondHistoryTeam1MemberWriter.get_file_writer(module, 1); 
				NanosecondIncorporationConceptTeam1MemberWriter.setWriterCreated(false);
				NanosecondIncorporationConceptTeam1MemberWriter.get_file_writer(module, 1); 
				NanosecondCheckPointTeam1MemberWriter.setWriterCreated(false);
				NanosecondCheckPointTeam1MemberWriter.get_file_writer(module, 1); 
				NanosecondContributionalEstimateTeam1MemberWriter.setWriterCreated(false);
				NanosecondContributionalEstimateTeam1MemberWriter.get_file_writer(module, 1); 
				NanosecondAudienceTeam1MemberWriter.setWriterCreated(false);
				NanosecondAudienceTeam1MemberWriter.get_file_writer(module, 1); 
				NanosecondModeOfOperationsTeam1MemberWriter.setWriterCreated(false);
				NanosecondModeOfOperationsTeam1MemberWriter.get_file_writer(module, 1); 
				NanosecondExtractDataTeam1MemberWriter.setWriterCreated(false);
				NanosecondExtractDataTeam1MemberWriter.get_file_writer(module, 1); 
				NanosecondLoggerTeam1MemberWriter.setWriterCreated(false);
				NanosecondLoggerTeam1MemberWriter.get_file_writer(module, 1); 
				NanosecondPrGraphTeam2MemberWriter.setWriterCreated(false);
				NanosecondPrGraphTeam2MemberWriter.get_file_writer(module, 1);
				NanosecondPrFactsTeam2MemberWriter.setWriterCreated(false);
				NanosecondPrFactsTeam2MemberWriter.get_file_writer(module, 1);
				NanosecondPrRulesTeam2MemberWriter.setWriterCreated(false);
				NanosecondPrRulesTeam2MemberWriter.get_file_writer(module, 1); 
				NanosecondPrInterpretationsTeam2MemberWriter.setWriterCreated(false);
				NanosecondPrInterpretationsTeam2MemberWriter.get_file_writer(module, 1); 
				NanosecondStaticLanguageTeam2MemberWriter.setWriterCreated(false);
				NanosecondStaticLanguageTeam2MemberWriter.get_file_writer(module, 1); 
				NanosecondChangingLanguageTeam2MemberWriter.setWriterCreated(false);
				NanosecondChangingLanguageTeam2MemberWriter.get_file_writer(module, 1); 
				NanosecondStaticGrammarTeam2MemberWriter.setWriterCreated(false);
				NanosecondStaticGrammarTeam2MemberWriter.get_file_writer(module, 1); 
				NanosecondChangingGrammarTeam2MemberWriter.setWriterCreated(false);
				NanosecondChangingGrammarTeam2MemberWriter.get_file_writer(module, 1); 
				NanosecondGenerationTeam2MemberWriter.setWriterCreated(false);
				NanosecondGenerationTeam2MemberWriter.get_file_writer(module, 1); 
				NanosecondOrderingPlacementsTeam2MemberWriter.setWriterCreated(false);
				NanosecondOrderingPlacementsTeam2MemberWriter.get_file_writer(module, 1);
				NanosecondCombineTeam2MemberWriter.setWriterCreated(false); 
				NanosecondCombineTeam2MemberWriter.get_file_writer(module, 1); 
				NanosecondTeam2MemberSpellsWriter.setWriterCreated(false);
				NanosecondTeam2MemberSpellsWriter.get_file_writer(module, 1); 
				NanosecondSelectionTeam2MemberSpellsWriter.setWriterCreated(false);
				NanosecondSelectionTeam2MemberSpellsWriter.get_file_writer(module, 1);
				NanosecondLeftOverTeam2MemberSpellsWriter.setWriterCreated(false);
				NanosecondLeftOverTeam2MemberSpellsWriter.get_file_writer(module, 1); 
				NanosecondDiscardTeam2MemberSpellsWriter.setWriterCreated(false); 
				NanosecondDiscardTeam2MemberSpellsWriter.get_file_writer(module, 1); 
				NanosecondGarbageCollectionTeam2MemberWriter.setWriterCreated(false); 
				NanosecondGarbageCollectionTeam2MemberWriter.get_file_writer(module, 1);
				NanosecondLexicalAnalyzerTeam2MemberWriter.setWriterCreated(false);
				NanosecondLexicalAnalyzerTeam2MemberWriter.get_file_writer(module, 1); 
				NanosecondDFATeam2MemberWriter.setWriterCreated(false);
				NanosecondDFATeam2MemberWriter.get_file_writer(module, 1);
				NanosecondNFATeam2MemberWriter.setWriterCreated(false);
				NanosecondNFATeam2MemberWriter.get_file_writer(module, 1);
				NanosecondRunTimeTeam2MemberWriter.setWriterCreated(false);
				NanosecondRunTimeTeam2MemberWriter.get_file_writer(module, 1); 
				NanosecondReferencePointersTeam2MemberWriter.setWriterCreated(false);
				NanosecondReferencePointersTeam2MemberWriter.get_file_writer(module, 1); 
				NanosecondOutputSpellsTeam2MemberWriter.setWriterCreated(false);
				NanosecondOutputSpellsTeam2MemberWriter.get_file_writer(module, 1); 
				NanosecondPathTraceTeam2MemberWriter.setWriterCreated(false);
				NanosecondPathTraceTeam2MemberWriter.get_file_writer(module, 1);
				NanosecondTraceToStartTeam2MemberWriter.setWriterCreated(false); 
				NanosecondTraceToStartTeam2MemberWriter.get_file_writer(module, 1); 
				NanosecondSatisfierTeam2MemberWriter.setWriterCreated(false); 
				NanosecondSatisfierTeam2MemberWriter.get_file_writer(module, 1); 
				NanosecondHistoryTeam2MemberWriter.setWriterCreated(false); 
				NanosecondHistoryTeam2MemberWriter.get_file_writer(module, 1); 
				NanosecondIncorporationConceptTeam2MemberWriter.setWriterCreated(false); 
				NanosecondIncorporationConceptTeam2MemberWriter.get_file_writer(module, 1); 
				NanosecondCheckPointTeam2MemberWriter.setWriterCreated(false);
				NanosecondCheckPointTeam2MemberWriter.get_file_writer(module, 1); 
				NanosecondContributionalEstimateTeam2MemberWriter.setWriterCreated(false); 
				NanosecondContributionalEstimateTeam2MemberWriter.get_file_writer(module, 1); 
				NanosecondAudienceTeam2MemberWriter.setWriterCreated(false); 
				NanosecondAudienceTeam2MemberWriter.get_file_writer(module, 1); 
				NanosecondModeOfOperationsTeam2MemberWriter.setWriterCreated(false);
				NanosecondModeOfOperationsTeam2MemberWriter.get_file_writer(module, 1); 
				NanosecondExtractDataTeam2MemberWriter.setWriterCreated(false);
				NanosecondExtractDataTeam2MemberWriter.get_file_writer(module, 1);
				NanosecondLoggerTeam2MemberWriter.setWriterCreated(false); 
				NanosecondLoggerTeam2MemberWriter.get_file_writer(module, 1); 
			}
			else if(playerAssociationToSchool.size() == 4) {
				NanosecondTeam1MemberSpellsWriter.setWriterCreated(false);
				NanosecondTeam1MemberSpellsWriter.get_file_writer(module, 1); 
				NanosecondTeam1MemberSpellsWriter.setWriterCreated(false); 
				NanosecondTeam1MemberSpellsWriter.get_file_writer(module, 2); 
				NanosecondTeam2MemberSpellsWriter.setWriterCreated(false); 
				NanosecondTeam2MemberSpellsWriter.get_file_writer(module, 1);
				NanosecondTeam2MemberSpellsWriter.setWriterCreated(false); 
				NanosecondTeam2MemberSpellsWriter.get_file_writer(module, 2); 
			}
			else if(playerAssociationToSchool.size() == 6) {
				NanosecondTeam1MemberSpellsWriter.setWriterCreated(false);
				NanosecondTeam1MemberSpellsWriter.get_file_writer(module, 1); 
				NanosecondTeam1MemberSpellsWriter.setWriterCreated(false); 
				NanosecondTeam1MemberSpellsWriter.get_file_writer(module, 2); 
				NanosecondTeam1MemberSpellsWriter.setWriterCreated(false); 
				NanosecondTeam1MemberSpellsWriter.get_file_writer(module, 3); 
				NanosecondTeam2MemberSpellsWriter.setWriterCreated(false); 
				NanosecondTeam2MemberSpellsWriter.get_file_writer(module, 1); 
				NanosecondTeam2MemberSpellsWriter.setWriterCreated(false); 
				NanosecondTeam2MemberSpellsWriter.get_file_writer(module, 2); 
				NanosecondTeam2MemberSpellsWriter.setWriterCreated(false); 
				NanosecondTeam2MemberSpellsWriter.get_file_writer(module, 3); 
			}
			else if(playerAssociationToSchool.size() == 8) {
				NanosecondTeam1MemberSpellsWriter.setWriterCreated(false);
				NanosecondTeam1MemberSpellsWriter.get_file_writer(module, 1); 
				NanosecondTeam1MemberSpellsWriter.setWriterCreated(false); 
				NanosecondTeam1MemberSpellsWriter.get_file_writer(module, 2); 
				NanosecondTeam1MemberSpellsWriter.setWriterCreated(false); 
				NanosecondTeam1MemberSpellsWriter.get_file_writer(module, 3); 
				NanosecondTeam1MemberSpellsWriter.setWriterCreated(false); 
				NanosecondTeam1MemberSpellsWriter.get_file_writer(module, 4); 
				NanosecondTeam2MemberSpellsWriter.setWriterCreated(false); 
				NanosecondTeam2MemberSpellsWriter.get_file_writer(module, 1); 
				NanosecondTeam2MemberSpellsWriter.setWriterCreated(false); 
				NanosecondTeam2MemberSpellsWriter.get_file_writer(module, 2); 
				NanosecondTeam2MemberSpellsWriter.setWriterCreated(false); 
				NanosecondTeam2MemberSpellsWriter.get_file_writer(module, 3); 
				NanosecondTeam2MemberSpellsWriter.setWriterCreated(false); 
				NanosecondTeam2MemberSpellsWriter.get_file_writer(module, 4); 
			}
			System.out.println("Caught Stream Closed Exception"); 
			SecondCombineWriter.setWriterCreated(false); 
			productCombineWriter = SecondCombineWriter.get_file_writer();
			ModuleByModuleWriter.setWriterCreated(false);
			productModuleByModuleWriter = ModuleByModuleWriter.get_file_writer();
			SecondDiscardSpellsWriter.setWriterCreated(false);
			productExcessSpellsWriter = SecondDiscardSpellsWriter.get_file_writer();
			SecondDiscardSpellsTeam1Writer.setWriterCreated(false); 
			productExcessSpellsTeam1Writer = SecondDiscardSpellsTeam1Writer.get_file_writer();
			SecondDiscardSpellsTeam2Writer.setWriterCreated(false);
			productExcessSpellsTeam2Writer = SecondDiscardSpellsTeam2Writer.get_file_writer();
			SecondLeftOverSpellsWriter.setWriterCreated(false); 
			productRemainingSpellsWriter = SecondLeftOverSpellsWriter.get_file_writer();
			SecondLeftOverSpellsTeam1Writer.setWriterCreated(false); 
			productRemainingSpellsTeam1Writer = SecondLeftOverSpellsTeam1Writer.get_file_writer();
			SecondLeftOverSpellsTeam2Writer.setWriterCreated(false); 
			productRemainingSpellsTeam2Writer = SecondLeftOverSpellsTeam2Writer.get_file_writer();
			SecondSelectionWriter.setWriterCreated(false);
			productSelectionLineWriter = SecondSelectionWriter.get_file_writer();
			ProductSelectionTeam1Writer.setWriterCreated(false); 
			productSelectionLineTeam1Writer = ProductSelectionTeam1Writer.get_file_writer();
			SecondSelectionTeam2Writer.setWriterCreated(false);
			productSelectionLineTeam2Writer = SecondSelectionTeam2Writer.get_file_writer();
			NanosecondPrGraphWriter.setWriterCreated(false); 
			modulePrGraphWriter = NanosecondPrGraphWriter.get_file_writer(module);
			NanosecondPrGraphTeam1Writer.setWriterCreated(false); 
			modulePrGraphTeam1Writer = NanosecondPrGraphTeam1Writer.get_file_writer(module); 
			NanosecondPrGraphTeam2Writer.setWriterCreated(false);
			modulePrGraphTeam2Writer = NanosecondPrGraphTeam2Writer.get_file_writer(module); 
			NanosecondPrFactsWriter.setWriterCreated(false); 
			modulePrFactsWriter = NanosecondPrFactsWriter.get_file_writer(module); 
			NanosecondPrFactsTeam1Writer.setWriterCreated(false);
			modulePrFactsTeam1Writer = NanosecondPrFactsTeam1Writer.get_file_writer(module);
			NanosecondPrFactsTeam2Writer.setWriterCreated(false); 
			modulePrFactsTeam2Writer = NanosecondPrFactsTeam2Writer.get_file_writer(module);
			NanosecondPrRulesWriter.setWriterCreated(false); 
			modulePrRulesWriter = NanosecondPrRulesWriter.get_file_writer(module);
			NanosecondPrRulesTeam1Writer.setWriterCreated(false); 
			modulePrRulesTeam1Writer = NanosecondPrRulesTeam1Writer.get_file_writer(module); 
			NanosecondPrRulesTeam2Writer.setWriterCreated(false); 
			modulePrRulesTeam2Writer = NanosecondPrRulesTeam2Writer.get_file_writer(module); 
			NanosecondPrInterpretationsWriter.setWriterCreated(false); 
			modulePrInterpretationsWriter = NanosecondPrInterpretationsWriter.get_file_writer(module); 
			NanosecondPrInterpretationsTeam1Writer.get_file_writer(module); 
			modulePrInterpretationsTeam1Writer = NanosecondPrInterpretationsTeam1Writer.get_file_writer(module);
			NanosecondPrInterpretationsTeam2Writer.setWriterCreated(false);
			modulePrInterpretationsTeam2Writer = NanosecondPrInterpretationsTeam2Writer.get_file_writer(module); 
			NanosecondStaticLanguageWriter.setWriterCreated(false); 
			moduleStaticLanguageWriter = NanosecondStaticLanguageWriter.get_file_writer(module); 
			NanosecondStaticLanguageTeam1Writer.setWriterCreated(false); 
			moduleStaticLanguageTeam1Writer = NanosecondStaticLanguageTeam1Writer.get_file_writer(module);
			ModuleStaticLanguageTeam2Writer.setWriterCreated(false); 
			moduleStaticLanguageTeam2Writer = ModuleStaticLanguageTeam2Writer.get_file_writer(module);
			NanosecondChangingLanguageWriter.setWriterCreated(false); 
			moduleChangingLanguageWriter = NanosecondChangingLanguageWriter.get_file_writer(module);
			NanosecondChangingLanguageTeam1Writer.setWriterCreated(false); 
			moduleChangingLanguageTeam1Writer = NanosecondChangingLanguageTeam1Writer.get_file_writer(module); 
			NanosecondChangingLanguageTeam2Writer.setWriterCreated(false); 
			moduleChangingLanguageTeam2Writer = NanosecondChangingLanguageTeam2Writer.get_file_writer(module); 
			NanosecondStaticGrammarWriter.setWriterCreated(false); 
			moduleStaticGrammarWriter = NanosecondStaticGrammarWriter.get_file_writer(module); 
			NanosecondStaticGrammarTeam1Writer.setWriterCreated(false); 
			moduleStaticGrammarTeam1Writer = NanosecondStaticGrammarTeam1Writer.get_file_writer(module); 
			NanosecondStaticGrammarTeam2Writer.setWriterCreated(false); 
			moduleStaticGrammarTeam2Writer = NanosecondStaticGrammarTeam2Writer.get_file_writer(module); 
			NanosecondChangingGrammarWriter.setWriterCreated(false); 
			moduleChangingGrammarWriter = NanosecondChangingGrammarWriter.get_file_writer(module); 
			NanosecondChangingGrammarTeam1Writer.setWriterCreated(false); 
			moduleChangingGrammarTeam1Writer = NanosecondChangingGrammarTeam1Writer.get_file_writer(module); 
			NanosecondChangingGrammarTeam2Writer.setWriterCreated(false); 
			moduleChangingGrammarTeam2Writer = NanosecondChangingGrammarTeam2Writer.get_file_writer(module); 
			NanosecondGenerationWriter.setWriterCreated(false); 
			moduleGenerationWriter = NanosecondGenerationWriter.get_file_writer(module); 
			NanosecondGenerationTeam1Writer.setWriterCreated(false); 
			moduleGenerationTeam1Writer = NanosecondGenerationTeam1Writer.get_file_writer(module); 
			NanosecondGenerationTeam2Writer.setWriterCreated(false); 
			moduleGenerationTeam2Writer = NanosecondGenerationTeam2Writer.get_file_writer(module); 
			NanosecondOrderingPlacementsWriter.setWriterCreated(false);
			moduleOrderingPlacementsWriter = NanosecondOrderingPlacementsWriter.get_file_writer(module); 
			NanosecondOrderingPlacementsTeam1Writer.setWriterCreated(false); 
			moduleOrderingPlacementsTeam1Writer = NanosecondOrderingPlacementsTeam1Writer.get_file_writer(module); 
			NanosecondOrderingPlacementsTeam2Writer.setWriterCreated(false); 
			moduleOrderingPlacementsTeam2Writer = NanosecondOrderingPlacementsTeam2Writer.get_file_writer(module); 
			NanosecondCombineWriter.setWriterCreated(false); 
			moduleCombineWriter = NanosecondCombineWriter.get_file_writer(module); 
			NanosecondTeam1SpellsWriter.setWriterCreated(false);
			moduleTeam1SpellsWriter = NanosecondTeam1SpellsWriter.get_file_writer(module);
			NanosecondTeam2SpellsWriter.setWriterCreated(false);
			moduleTeam2SpellsWriter = NanosecondTeam2SpellsWriter.get_file_writer(module);
			NanosecondOfSpellsWriter.setWriterCreated(false); 
			moduleDefaultWriter = NanosecondOfSpellsWriter.get_file_writer(module); 
			NanosecondSelectionWriter.setWriterCreated(false);
			moduleSelectionLineWriter = NanosecondSelectionWriter.get_file_writer(module); 
			NanosecondSelectionTeam1Writer.setWriterCreated(false);
			moduleSelectionLineTeam1Writer = NanosecondSelectionTeam1Writer.get_file_writer(module); 
			NanosecondSelectionTeam2Writer.setWriterCreated(false); 
			moduleSelectionLineTeam2Writer = NanosecondSelectionTeam2Writer.get_file_writer(module); 
			NanosecondLeftOverSpellsWriter.setWriterCreated(false); 
			moduleRemainingSpellsWriter = NanosecondLeftOverSpellsWriter.get_file_writer(module); 
			NanosecondLeftOverSpellsTeam1Writer.setWriterCreated(false); 
			moduleRemainingTeam1SpellsWriter = NanosecondLeftOverSpellsTeam1Writer.get_file_writer(module); 
			NanosecondLeftOverSpellsTeam2Writer.setWriterCreated(false); 
			moduleRemainingTeam2SpellsWriter = NanosecondLeftOverSpellsTeam2Writer.get_file_writer(module); 
			NanosecondDiscardSpellsWriter.setWriterCreated(false);
			moduleExcessSpellsWriter = NanosecondDiscardSpellsWriter.get_file_writer(module);
			NanosecondDiscardSpellsTeam1Writer.setWriterCreated(false); 
			moduleExcessSpellsTeam1Writer = NanosecondDiscardSpellsTeam1Writer.get_file_writer(module); 
			NanosecondDiscardSpellsTeam2Writer.setWriterCreated(false); 
			moduleExcessSpellsTeam2Writer = NanosecondDiscardSpellsTeam2Writer.get_file_writer(module); 
			NanosecondGarbageCollectionWriter.setWriterCreated(false); 
			moduleGarbageCollectionWriter = NanosecondGarbageCollectionWriter.get_file_writer(module); 
			NanosecondGarbageCollectionTeam1Writer.setWriterCreated(false); 
			moduleGarbageCollectionTeam1Writer = NanosecondGarbageCollectionTeam1Writer.get_file_writer(module); 
			NanosecondGarbageCollectionTeam2Writer.setWriterCreated(false); 
			moduleGarbageCollectionTeam2Writer = NanosecondGarbageCollectionTeam2Writer.get_file_writer(module); 
			NanosecondLexicalAnalyzerWriter.setWriterCreated(false); 
			moduleLexicalAnalyzerWriter = NanosecondLexicalAnalyzerWriter.get_file_writer(module); 
			NanosecondLexicalAnalyzerTeam1Writer.setWriterCreated(false); 
			moduleLexicalAnalyzerTeam1Writer = NanosecondLexicalAnalyzerTeam1Writer.get_file_writer(module); 
			NanosecondLexicalAnalyzerTeam2Writer.setWriterCreated(false);
			moduleLexicalAnalyzerTeam2Writer = NanosecondLexicalAnalyzerTeam2Writer.get_file_writer(module); 
			NanosecondDFAWriter.setWriterCreated(false); 
			moduleDFAWriter = NanosecondDFAWriter.get_file_writer(module); 
			NanosecondDFATeam1Writer.setWriterCreated(false); 
			moduleDFATeam1Writer = NanosecondDFATeam1Writer.get_file_writer(module); 
			NanosecondDFATeam2Writer.setWriterCreated(false); 
			moduleDFATeam2Writer = NanosecondDFATeam2Writer.get_file_writer(module); 
			NanosecondNFAWriter.setWriterCreated(false); 
			moduleNFAWriter = NanosecondNFAWriter.get_file_writer(module); 
			NanosecondNFATeam1Writer.setWriterCreated(false); 
			moduleNFATeam1Writer = NanosecondNFATeam1Writer.get_file_writer(module); 
			NanosecondNFATeam2Writer.setWriterCreated(false); 
			moduleNFATeam2Writer = NanosecondNFATeam2Writer.get_file_writer(module); 
			NanosecondRunTimeWriter.setWriterCreated(false); 
			moduleRunTimeWriter = NanosecondRunTimeWriter.get_file_writer(module); 
			NanosecondRunTimeTeam1Writer.setWriterCreated(false);
			moduleRunTimeTeam1Writer = NanosecondRunTimeTeam1Writer.get_file_writer(module); 
			NanosecondRunTimeTeam2Writer.setWriterCreated(false); 
			moduleRunTimeTeam2Writer = NanosecondRunTimeTeam2Writer.get_file_writer(module); 
			NanosecondReferencePointersWriter.setWriterCreated(false); 
			moduleReferencePointersWriter = NanosecondReferencePointersWriter.get_file_writer(module); 
			NanosecondReferencePointersTeam1Writer.setWriterCreated(false); 
			moduleReferencePointersTeam1Writer = NanosecondReferencePointersTeam1Writer.get_file_writer(module); 
			NanosecondOutputSpellsWriter.setWriterCreated(false); 
			moduleComputationSpellsWriter = NanosecondOutputSpellsWriter.get_file_writer(module); 
			NanosecondOutputSpellsTeam1Writer.setWriterCreated(false);
			moduleComputationSpellsTeam1Writer = NanosecondOutputSpellsTeam1Writer.get_file_writer(module); 
			NanosecondOutputSpellsTeam2Writer.setWriterCreated(false); 
			moduleComputationSpellsTeam2Writer = NanosecondOutputSpellsTeam2Writer.get_file_writer(module); 
			NanosecondPathTraceWriter.setWriterCreated(false); 
			modulePathTraceWriter = NanosecondPathTraceWriter.get_file_writer(module); 
			NanosecondPathTraceTeam1Writer.setWriterCreated(false); 
			modulePathTraceTeam1Writer = NanosecondPathTraceTeam1Writer.get_file_writer(module); 
			NanosecondPathTraceTeam2Writer.setWriterCreated(false); 
			modulePathTraceTeam2Writer = NanosecondPathTraceTeam2Writer.get_file_writer(module); 
			NanosecondTraceToStartWriter.setWriterCreated(false); 
			moduleTraceToStartWriter = NanosecondTraceToStartWriter.get_file_writer(module); 
			NanosecondTraceToStartTeam1Writer.setWriterCreated(false); 
			moduleTraceToStartTeam1Writer = NanosecondTraceToStartTeam1Writer.get_file_writer(module); 
			NanosecondTraceToStartTeam2Writer.setWriterCreated(false); 
			moduleTraceToStartTeam2Writer = NanosecondTraceToStartTeam2Writer.get_file_writer(module); 
			NanosecondSatisfierWriter.setWriterCreated(false); 
			moduleSatisfierWriter = NanosecondSatisfierWriter.get_file_writer(module); 
			NanosecondSatisfierTeam1Writer.setWriterCreated(false); 
			moduleSatisfierTeam1Writer = NanosecondSatisfierTeam1Writer.get_file_writer(module); 
			NanosecondSatisfierTeam2Writer.setWriterCreated(false); 
			moduleSatisfierTeam2Writer = NanosecondSatisfierTeam2Writer.get_file_writer(module); 
			NanosecondHistoryWriter.setWriterCreated(false); 
			moduleHistoryWriter = NanosecondHistoryWriter.get_file_writer(module); 
			NanosecondHistoryTeam1Writer.setWriterCreated(false); 
			moduleHistoryTeam1Writer = NanosecondHistoryTeam1Writer.get_file_writer(module); 
			NanosecondHistoryTeam2Writer.setWriterCreated(false); 
			moduleHistoryTeam2Writer = NanosecondHistoryTeam2Writer.get_file_writer(module); 
			NanosecondIncorporationConceptWriter.setWriterCreated(false); 
			moduleIncorporationConceptWriter = NanosecondIncorporationConceptWriter.get_file_writer(module); 
			NanosecondIncorporationConceptTeam1Writer.setWriterCreated(false);
			moduleIncorporationConceptTeam1Writer = NanosecondIncorporationConceptTeam1Writer.get_file_writer(module); 
			NanosecondIncorporationConceptTeam2Writer.setWriterCreated(false); 
			moduleIncorporationConceptTeam2Writer = NanosecondIncorporationConceptTeam2Writer.get_file_writer(module); 
			NanosecondCheckPointWriter.setWriterCreated(false); 
			moduleCheckPointWriter = NanosecondCheckPointWriter.get_file_writer(module); 
			NanosecondCheckPointTeam1Writer.setWriterCreated(false); 
			moduleCheckPointTeam1Writer = NanosecondCheckPointTeam1Writer.get_file_writer(module); 
			NanosecondCheckPointTeam2Writer.setWriterCreated(false); 
			moduleCheckPointTeam2Writer = NanosecondCheckPointTeam2Writer.get_file_writer(module);
			NanosecondContributionalEstimateWriter.setWriterCreated(false); 
			moduleContributionalEstimateWriter = NanosecondContributionalEstimateWriter.get_file_writer(module); 
			NanosecondContributionalEstimateTeam1Writer.setWriterCreated(false); 
			moduleContributionalEstimateTeam1Writer = NanosecondContributionalEstimateTeam1Writer.get_file_writer(module); 
			NanosecondContributionalEstimateTeam2Writer.setWriterCreated(false); 
			moduleContributionalEstimateTeam2Writer = NanosecondContributionalEstimateTeam2Writer.get_file_writer(module); 
			NanosecondAudienceWriter.setWriterCreated(false); 
			moduleAudienceWriter = NanosecondAudienceWriter.get_file_writer(module); 
			NanosecondAudienceTeam1Writer.setWriterCreated(false); 
			moduleAudienceTeam1Writer = NanosecondAudienceTeam1Writer.get_file_writer(module); 
			NanosecondAudienceTeam2Writer.setWriterCreated(false); 
			moduleAudienceTeam2Writer = NanosecondAudienceTeam2Writer.get_file_writer(module); 
			NanosecondModeOfOperationsWriter.setWriterCreated(false); 
			moduleModeOfOperationsWriter = NanosecondModeOfOperationsWriter.get_file_writer(module); 
			NanosecondModeOfOperationsTeam1Writer.setWriterCreated(false); 
			moduleModeOfOperationsTeam1Writer = NanosecondModeOfOperationsTeam1Writer.get_file_writer(module); 
			NanosecondModeOfOperationsTeam2Writer.setWriterCreated(false); 
			moduleModeOfOperationsTeam2Writer = NanosecondModeOfOperationsTeam2Writer.get_file_writer(module); 
			NanosecondExtractDataWriter.setWriterCreated(false); 
			moduleExtractDataWriter = NanosecondExtractDataWriter.get_file_writer(module); 
			NanosecondExtractDataTeam1Writer.setWriterCreated(false); 
			moduleExtractDataTeam1Writer = NanosecondExtractDataTeam1Writer.get_file_writer(module); 
			NanosecondExtractDataTeam2Writer.setWriterCreated(false); 
			moduleExtractDataTeam2Writer = NanosecondExtractDataTeam2Writer.get_file_writer(module); 
			NanosecondLoggerWriter.setWriterCreated(false); 
			moduleLoggerWriter = NanosecondLoggerWriter.get_file_writer(module); 
			NanosecondLoggerTeam1Writer.setWriterCreated(false); 
			moduleLoggerTeam1Writer = NanosecondLoggerTeam1Writer.get_file_writer(module); 
			NanosecondLoggerTeam2Writer.setWriterCreated(false); 
			moduleLoggerTeam2Writer = NanosecondLoggerTeam2Writer.get_file_writer(module); 
		}
		// Blade, Blade, Blade, Trap 
		// Trap, Trap, Trap, Empower
		System.out.println("This is a module casted of our match between team 1 and team 2"); 
		System.out.println("Team Players Size inclusive of both team 1 and team 2: " + teamPlayers.size()); 
		productModuleByModuleWriter.write("\n"); 
		productModuleByModuleWriter.write("ROUND # " + module + " OF SPELLS" + "\n");
		productWriterFinalizer.write("ROUND # " + module + " OF SPELLS" + "\n"); 
		moduleDefaultWriter.write("\n"); 
		moduleDefaultWriter.write("ROUND # " + module + " OF SPELLS" + "\n"); 
		moduleCombineWriter.write("ROUND # " + module + " OF SPELLS" + "\n");
		moduleComputationSpellsWriter.write("ROUND # " + module + " COMPUTATION " + "\n"); 
		moduleComputationSpellsWriter.write("________________________________________\n"); 
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
			productModuleByModuleWriter.write("AGENT-" + player + "-UNITS SELECTION\n"); 
			productWriterFinalizer.write("AGENT-" + player + "-UNITS SELECTION\n"); 
			moduleDefaultWriter.write("AGENT-" + player + "-UNITS SELECTION\n");	
			moduleCombineWriter.write("AGENT-" + player + "-UNITS SELECTION\n"); 
			System.out.println("The following seven manuals have been generated."); 
			Element[] sevenCards = generateSevenCards(playerAssociationToSchool.get(player).toLowerCase(), index); 
			System.out.println("Printing out the seven manuals.");
			for(int z = 0; z < sevenCards.length; z++)
			{
				productModuleByModuleWriter.write("----------------------------\n");
				productWriterFinalizer.write("----------------------------\n"); 
				moduleDefaultWriter.write("----------------------------\n"); 
				moduleCombineWriter.write("----------------------------\n");
				System.out.println("Manual " + (z+1) + ": " + "{ "); 
				productModuleByModuleWriter.write("Manual " + (z+1) + ": " + "{\n "); 
				productWriterFinalizer.write("Manual " + (z+1) + ": " + "{\n "); 
				moduleDefaultWriter.write("Manual " + (z+1) + ": " + "{\n ");
				moduleCombineWriter.write("Manual " + (z+1) + ": " + "{\n ");
				System.out.println("Unit Tag: " + sevenCards[z].getSpellName()); 
				productModuleByModuleWriter.write("Unit Tag: " + sevenCards[z].getSpellName() + "\n"); 
				productWriterFinalizer.write("Unit Tag: " + sevenCards[z].getSpellName() + "\n"); 
			 	moduleDefaultWriter.write("Unit Tag: " + sevenCards[z].getSpellName() + "\n");
				moduleCombineWriter.write("Unit Tag: " + sevenCards[z].getSpellName() + "\n"); 
				System.out.println("Unit Assembly # Of Steps: " + sevenCards[z].getPips()); 
				productModuleByModuleWriter.write("Unit Assembly # Of Steps: " + sevenCards[z].getPips() + "\n"); 
				productWriterFinalizer.write("Unit Assembly # Of Steps: " + sevenCards[z].getPips() + "\n"); 
				moduleDefaultWriter.write("Unit Assembly # Of Steps: " + sevenCards[z].getPips() + "\n");
				moduleCombineWriter.write("Unit Assembly # Of Steps: " + sevenCards[z].getPips() + "\n"); 
				System.out.println("Unit Success Build Rate: " + sevenCards[z].getPipChance()); 
				productModuleByModuleWriter.write("Unit Success Build Rate: " + sevenCards[z].getPipChance() + "\n"); 
				productWriterFinalizer.write("Unit Success Build Rate: " + sevenCards[z].getPipChance() + "\n"); 
				moduleDefaultWriter.write("Unit Success Build Rate: " + sevenCards[z].getPipChance() + "\n");
				moduleCombineWriter.write("Unit Success Build Rate: " + sevenCards[z].getPipChance() + "\n"); 
				System.out.println("Unit Industry Type: " + sevenCards[z].getTypeSpell()); 
				productModuleByModuleWriter.write("Unit Industry Type: " + sevenCards[z].getTypeSpell() + "\n"); 
				productWriterFinalizer.write("Unit Industry Type: " + sevenCards[z].getTypeSpell() + "\n"); 
				moduleDefaultWriter.write("Unit Industry Type: " + sevenCards[z].getTypeSpell() + "\n"); 
				moduleCombineWriter.write("Unit Industry Type: " + sevenCards[z].getTypeSpell() + "\n"); 
				Type_Spell.startToFinish(sevenCards[z].getTypeSpell());
				moduleComputationSpellsWriter.write("MANUAL GUIDE: " + Type_Spell.configureInUseToEnd[0] + " OUT OF " + Type_Spell.configureInUseToEnd[1] + " " + sevenCards[z].getTypeSpell().toUpperCase() + " UNITS\n");
				System.out.println("Unit Supply Count: " + sevenCards[z].getCount()); 
				productModuleByModuleWriter.write("Unit Supply Count: " + sevenCards[z].getCount() + "\n"); 
				productWriterFinalizer.write("Unit Supply Count: " + sevenCards[z].getCount() + "\n"); 
				moduleDefaultWriter.write("Unit Supply Count: " + sevenCards[z].getCount() + "\n");
				moduleCombineWriter.write("Unit Supply Count: " + sevenCards[z].getCount() + "\n"); 
				System.out.println("Unit Information: " + sevenCards[z].getDescription()); 
				productModuleByModuleWriter.write("Unit Information: " + sevenCards[z].getDescription() + "\n"); 
				productWriterFinalizer.write("Unit Information: " + sevenCards[z].getDescription() + "\n");
				moduleDefaultWriter.write("Unit Information: " + sevenCards[z].getDescription() + "\n"); 
				moduleCombineWriter.write("Unit Information: " + sevenCards[z].getDescription() + "\n"); 
				System.out.println("}");
				productModuleByModuleWriter.write("}\n"); 
				productWriterFinalizer.write("}\n"); 
				moduleDefaultWriter.write("}\n"); 
				moduleCombineWriter.write("}\n"); 
				System.out.println("Unit added to the Productwriter."); 
			}
			productModuleByModuleWriter.write("----------------------------\n");
			productWriterFinalizer.write("----------------------------\n"); 
			moduleDefaultWriter.write("----------------------------\n"); 
			moduleCombineWriter.write("----------------------------\n");
			
		}
		productModuleByModuleWriter.write("END OF MODULE\n");
		productWriterFinalizer.write("END OF MODULE\n"); 
		productWriterFinalizer.write("############################\n"); 
		moduleDefaultWriter.write("END OF MODULE\n"); 
		moduleCombineWriter.write("END OF MODULE\n"); 
		moduleComputationSpellsWriter.write("________________________________________\n"); 
		moduleComputationSpellsWriter.write("END OF COMPUTATION\n"); 
		moduleComputationSpellsWriter.close(); 
		System.out.println("Reading module of units using reader. Decide between reading system 1 or system 2 first."); 

		productModuleByModuleWriter.close(); 
		moduleDefaultWriter.close(); 
		BufferedReader moduleComputeReader = null;
		try {
			moduleComputeReader = new BufferedReader(NanosecondOfSpellsReader.get_file_reader()); 
			moduleComputeReader.readLine(); 
		} catch (Exception e) {
			NanosecondOfSpellsReader.setReaderCreated(false); 
			moduleComputeReader = new BufferedReader(NanosecondOfSpellsReader.get_file_reader()); 
		}
		moduleTeam1SpellsWriter.write("\n"); 
		moduleTeam2SpellsWriter.write("\n"); 
		String line; 
		boolean readFirstTeam = false; 
		boolean readSecondTeam = false; 
		String selectionStmtLine_t1 = null;
		String discardStmtLine_t1 = null;
		String remainingStmtLine_t1 = null;
		String selectionStmtLine_t2 = null;
		String discardStmtLine_t2 = null;
		String remainingStmtLine_t2 = null;
		while((line = moduleComputeReader.readLine()) != null) { 
			if(line.contains("(SYSTEM 1)")) {
				System.out.println("CONTAINS SYSTEM 1"); 
				readFirstTeam = true; 
				readSecondTeam = false; 
				
				line = line.replace("UNITS SELECTION", "UNIT SELECTED"); 
				moduleSelectionLineWriter.write(line + "\n"); 
				moduleSelectionLineTeam1Writer.write(line + "\n"); 
				//roundCombineWriter.write(line + "\n"); 
				selectionStmtLine_t1 = line;
				String discardLine = line; 
				discardLine = discardLine.replace("UNIT SELECTED", "UNITS DISCARDED"); 
				moduleExcessSpellsWriter.write(discardLine + "\n"); 
				moduleExcessSpellsTeam1Writer.write(discardLine + "\n"); 
				discardStmtLine_t1 = discardLine;
				//roundCombineWriter.write(discardLine + "\n"); 
				String remainingLine = line; 
				remainingLine = remainingLine.replace("UNIT SELECTED", "UNITS REMAINING"); 
				moduleRemainingSpellsWriter.write(remainingLine + "\n"); 
				moduleRemainingTeam1SpellsWriter.write(remainingLine + "\n"); 
				moduleRemainingTeam2SpellsWriter.write(remainingLine + "\n"); 
				remainingStmtLine_t1 = remainingLine;
				//roundCombineWriter.write(remainingLine + "\n"); 
			}
			if(line.contains("(SYSTEM 2)")) {
				readSecondTeam = true; 
				readFirstTeam = false;
				line = line.replace("UNITS SELECTION", "UNIT SELECTED");
				moduleSelectionLineWriter.write(line + "\n"); 
				moduleSelectionLineTeam2Writer.write(line + "\n");  
				selectionStmtLine_t2 = line;
				//roundCombineWriter.write(line + "\n"); 
				String discardLine = line; 
				discardLine = discardLine.replace("UNIT SELECTED", "UNIT DISCARDED"); 
				moduleExcessSpellsWriter.write(discardLine + "\n"); 
				moduleExcessSpellsTeam2Writer.write(discardLine + "\n"); 
				discardStmtLine_t2 = discardLine;
				//roundCombineWriter.write(discardLine + "\n"); 
				String remainingLine = line; 
				remainingLine = remainingLine.replace("UNIT SELECTED", "UNIT REMAINING"); 
				moduleRemainingSpellsWriter.write(remainingLine + "\n"); 
				moduleRemainingTeam1SpellsWriter.write(remainingLine + "\n"); 
				moduleRemainingTeam2SpellsWriter.write(remainingLine + "\n"); 
				remainingStmtLine_t2 = remainingLine;
				//roundCombineWriter.write(remainingLine + "\n"); 
			}
			if(readFirstTeam == true) {
				System.out.println("WRITING LINE: " + line + " FOR TEAM 1"); 
				moduleTeam1SpellsWriter.write(line + "\n"); 
				System.out.println("Extracting member_no information"); 
				if(line.contains("BOT")) {
					int memberCharLoc = line.indexOf("B");
					int stringNoLoc = line.indexOf(" ", memberCharLoc) + 1; 
					int memberNoLoc = Integer.parseInt(line.substring(stringNoLoc, stringNoLoc+1)); 
					System.out.println("memberNoLoc index: " + memberNoLoc); 
					NanosecondTeam1MemberSpellsWriter.file_writers[memberNoLoc-1].write(line + "\n"); 
				}
			}
			if(readSecondTeam == true) {
				System.out.println("WRITING LINE: " + line + " FOR TEAM 2");
				moduleTeam2SpellsWriter.write(line + "\n"); 
				System.out.println("Extracting member_no information"); 
				if(line.contains("BOT")) {
					int memberCharLoc = line.indexOf("B"); 
					int stringNoLoc = line.indexOf(" ", memberCharLoc) + 1; 
					int memberNoLoc = Integer.parseInt(line.substring(stringNoLoc, stringNoLoc+1)); 
					System.out.println("memberNoLoc index: " + memberNoLoc); 
 					NanosecondTeam2MemberSpellsWriter.file_writers[memberNoLoc-1].write(line + "\n");
				}
			}
		}
		moduleTeam1SpellsWriter.close(); 
		try {
			NanosecondTeam1MemberSpellsWriter.file_writers[0].close(); 
			NanosecondTeam1MemberSpellsWriter.file_writers[1].close(); 
			NanosecondTeam1MemberSpellsWriter.file_writers[2].close(); 
			NanosecondTeam1MemberSpellsWriter.file_writers[3].close(); 
		} catch (Exception e) {
			System.out.println("A member writer for team 1 failed to close"); ; 
		}
		moduleTeam2SpellsWriter.close();  
		try {
			NanosecondTeam2MemberSpellsWriter.file_writers[0].close(); 
			NanosecondTeam2MemberSpellsWriter.file_writers[1].close(); 
			NanosecondTeam2MemberSpellsWriter.file_writers[2].close(); 
			NanosecondTeam2MemberSpellsWriter.file_writers[3].close(); 
		} catch (Exception e) {
			System.out.println("A member writer for team 2 failed to close"); 
		}
		System.out.println("Creating two readers for selection_line of team 1 and team 2 module of spells."); 
		BufferedReader readerTeam1Compute = null;
		BufferedReader readerTeam2Compute = null;
		try {
			readerTeam1Compute = new BufferedReader(NanosecondSelectionReader.get_file_reader("t1", module)); 
			readerTeam1Compute.readLine(); 
			System.out.println("Line Read By Team 1 Reader: " + line); 
			readerTeam2Compute = new BufferedReader(NanosecondSelectionReader.get_file_reader("t2", module)); 
			readerTeam2Compute.readLine(); 
			System.out.println("Line Read By Team 2 Reader: " + line); 
		} catch (Exception e) {
			NanosecondSelectionReader.setReaderCreated(false);
			readerTeam1Compute = new BufferedReader(NanosecondSelectionReader.get_file_reader("t1", module)); 
			NanosecondSelectionReader.setReaderCreated(false); 
			readerTeam2Compute = new BufferedReader(NanosecondSelectionReader.get_file_reader("t2", module)); 
		}
		new FileOperation(readerTeam1Compute, moduleSelectionLineTeam1Writer, moduleExcessSpellsTeam1Writer, moduleRemainingTeam1SpellsWriter, moduleCombineWriter, new FileReader(Second.initialFile), "t1", module, selectionStmtLine_t1, discardStmtLine_t1, remainingStmtLine_t1, size).run(); 
		//Thread.sleep(30000);
		new FileOperation(readerTeam2Compute, moduleSelectionLineTeam2Writer, moduleExcessSpellsTeam2Writer, moduleRemainingTeam2SpellsWriter, moduleCombineWriter, new FileReader(Second.initialFile), "t2", module, selectionStmtLine_t2, discardStmtLine_t2, remainingStmtLine_t2, size).run(); 
		//Thread.sleep(30000); 
		moduleComputeReader.close(); 
		readerTeam1Compute.close(); 
		readerTeam2Compute.close(); 
		moduleSelectionLineWriter.close();
		moduleSelectionLineTeam1Writer.close(); 
		moduleSelectionLineTeam2Writer.close(); 
		moduleExcessSpellsWriter.close(); 
		moduleExcessSpellsTeam1Writer.close(); 
		moduleExcessSpellsTeam2Writer.close(); 
		moduleRemainingSpellsWriter.close(); 
		moduleRemainingTeam1SpellsWriter.close(); 
		moduleRemainingTeam2SpellsWriter.close(); 
		moduleCombineWriter.close(); 
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
					Second.getBufferReader().readLine();
					Second.getBufferReader().readLine(); 
					hatName = Second.getBufferReader().readLine(); 
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
					robeName = Second.getBufferReader().readLine(); 
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
					bootName = Second.getBufferReader().readLine();
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
					wandName = Second.getBufferReader().readLine(); 
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
					athameName = Second.getBufferReader().readLine();
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
					amuletName = Second.getBufferReader().readLine(); 
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
					ringName = Second.getBufferReader().readLine(); 
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
					deckName = Second.getBufferReader().readLine(); 
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
					petName = Second.getBufferReader().readLine(); 
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
						petType = Second.getBufferReader().readLine(); 
						System.out.println("Pet Type Read: " + petType);
						Second.getBufferReader().readLine(); 
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