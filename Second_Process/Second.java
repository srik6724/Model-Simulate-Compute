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
public class Second extends Demo_Installation_Terrain implements Microsecond, Second_Singleton, Second_Recorder {

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
			System.out.println("------AGENT_SYSTEM MEMBER-ORDERINGS-----"); 
			Thread.sleep(1000); 
			System.out.println("----------------1X1---------------------"); 
			Thread.sleep(1000); 
			System.out.println("----------------2X2---------------------");
			Thread.sleep(1000); 
			System.out.println("----------------3X3----------------------"); 
			Thread.sleep(1000); 
			System.out.println("----------------4X4----------------------");
			Thread.sleep(1000);  
			System.out.println("Choose which one to play based on those options."); 
			if(gameMode.contains("1X1"))
			{
				teamSize = _1X1_.teamSize(); 
				team = new String[teamSize]; 
				teamLevels = new String[teamSize]; 
				teamSchools = new String[teamSize]; 
				System.out.println("Team Size Value Set Here: " + teamSize); 
			}
			else if(gameMode.contains("2X2"))
			{
				teamSize = _2X2_.teamSize(); 
				team = new String[teamSize]; 
				teamLevels = new String[teamSize]; 
				teamSchools = new String[teamSize]; 
			}
			else if(gameMode.contains("3X3"))
			{
				teamSize = _3X3_.teamSize(); 
				team = new String[teamSize]; 
				teamLevels = new String[teamSize]; 
				teamSchools = new String[teamSize];
			}
			else if(gameMode.contains("4X4"))
			{
				teamSize = _4X4_.teamSize(); 
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
	
	public static void startMicrosecond(int index, FileWriter productWriterFinalizer, FileReader microsecondReading, FileWriter secondDataPersistor) throws IOException, InterruptedException
	{
		FileWriter microsecondTeam1SpellsWriter = null;
		FileWriter microsecondTeam2SpellsWriter = null;
		FileWriter secondCombineWriter = null;
		FileWriter secondModuleByModuleWriter = null; 
		FileWriter secondExcessSpellsWriter = null;
		FileWriter secondExcessSpellsTeam1Writer = null;
		FileWriter secondExcessSpellsTeam2Writer = null;
		FileWriter secondRemainingSpellsWriter = null;
		FileWriter secondRemainingSpellsTeam1Writer = null;
		FileWriter secondRemainingSpellsTeam2Writer = null;
		FileWriter secondSelectionLineWriter = null;
		FileWriter secondSelectionLineTeam1Writer = null;
		FileWriter secondSelectionLineTeam2Writer = null;
		FileWriter microsecondPrGraphWriter = null;
		FileWriter microsecondPrGraphTeam1Writer = null;
		FileWriter microsecondPrGraphTeam2Writer = null;
		FileWriter microsecondPrFactsWriter = null;
		FileWriter microsecondPrFactsTeam1Writer = null;
		FileWriter microsecondPrFactsTeam2Writer = null;
		FileWriter microsecondPrRulesWriter = null;
		FileWriter microsecondPrRulesTeam1Writer = null;
		FileWriter microsecondPrRulesTeam2Writer = null;
		FileWriter microsecondPrInterpretationsWriter = null;
		FileWriter microsecondPrInterpretationsTeam1Writer = null;
		FileWriter microsecondPrInterpretationsTeam2Writer = null;
		FileWriter microsecondStaticLanguageWriter = null;
		FileWriter microsecondStaticLanguageTeam1Writer = null;
		FileWriter microsecondStaticLanguageTeam2Writer = null;
		FileWriter microsecondChangingLanguageWriter = null;
		FileWriter microsecondChangingLanguageTeam1Writer = null;
		FileWriter microsecondChangingLanguageTeam2Writer = null;
		FileWriter microsecondStaticGrammarWriter = null;
		FileWriter microsecondStaticGrammarTeam1Writer = null;
		FileWriter microsecondStaticGrammarTeam2Writer = null;
		FileWriter microsecondChangingGrammarWriter = null;
		FileWriter microsecondChangingGrammarTeam1Writer = null;
		FileWriter microsecondChangingGrammarTeam2Writer = null;
		FileWriter microsecondGenerationWriter = null;
		FileWriter microsecondGenerationTeam1Writer = null;
		FileWriter microsecondGenerationTeam2Writer = null;
		FileWriter microsecondOrderingPlacementsWriter = null;
		FileWriter microsecondOrderingPlacementsTeam1Writer = null;
		FileWriter microsecondOrderingPlacementsTeam2Writer = null;
		FileWriter microsecondCombineWriter = null;
		FileWriter microsecondDefaultWriter = null;
		FileWriter microsecondTacticalApproachWriter = null;
		FileWriter microsecondTacticalApproachTeam1Writer = null;
		FileWriter microsecondTacticalApproachTeam2Writer = null;
		FileWriter microsecondSelectionLineWriter = null; 
		FileWriter microsecondSelectionLineTeam1Writer = null;
		FileWriter microsecondSelectionLineTeam2Writer = null;
		FileWriter microsecondRemainingSpellsWriter = null;
		FileWriter microsecondRemainingTeam1SpellsWriter = null;
		FileWriter microsecondRemainingTeam2SpellsWriter = null;
		FileWriter microsecondExcessSpellsWriter = null;
		FileWriter microsecondExcessSpellsTeam1Writer = null;
		FileWriter microsecondExcessSpellsTeam2Writer = null;
		FileWriter microsecondGarbageCollectionWriter = null;
		FileWriter microsecondGarbageCollectionTeam1Writer = null;
		FileWriter microsecondGarbageCollectionTeam2Writer = null;
		FileWriter microsecondLexicalAnalyzerWriter = null;
		FileWriter microsecondLexicalAnalyzerTeam1Writer = null;
		FileWriter microsecondLexicalAnalyzerTeam2Writer = null;
		FileWriter microsecondDFAWriter = null;
		FileWriter microsecondDFATeam1Writer = null;
		FileWriter microsecondDFATeam2Writer = null;
		FileWriter microsecondNFAWriter = null;
		FileWriter microsecondNFATeam1Writer = null;
		FileWriter microsecondNFATeam2Writer = null;
		FileWriter microsecondRunTimeWriter = null;
		FileWriter microsecondRunTimeTeam1Writer = null; 
		FileWriter microsecondRunTimeTeam2Writer = null;
		FileWriter microsecondReferencePointersWriter = null;
		FileWriter microsecondReferencePointersTeam1Writer = null;
		FileWriter microsecondReferencePointersTeam2Writer = null; 
		FileWriter microsecondComputationSpellsWriter = null;
		FileWriter microsecondComputationSpellsTeam1Writer = null; 
		FileWriter microsecondComputationSpellsTeam2Writer = null;
		FileWriter microsecondPathTraceWriter = null;
		FileWriter microsecondPathTraceTeam1Writer = null;
		FileWriter microsecondPathTraceTeam2Writer = null;
		FileWriter microsecondTraceToStartWriter = null;
		FileWriter microsecondTraceToStartTeam1Writer = null;
		FileWriter microsecondTraceToStartTeam2Writer = null;
		FileWriter microsecondSatisfierWriter = null;
		FileWriter microsecondSatisfierTeam1Writer = null;
		FileWriter microsecondSatisfierTeam2Writer = null;
		FileWriter microsecondHistoryWriter = null;
		FileWriter microsecondHistoryTeam1Writer = null;
		FileWriter microsecondHistoryTeam2Writer = null;
		FileWriter microsecondIncorporationConceptWriter = null;
		FileWriter microsecondIncorporationConceptTeam1Writer = null;
		FileWriter microsecondIncorporationConceptTeam2Writer = null;
		FileWriter microsecondCheckPointWriter = null;
		FileWriter microsecondCheckPointTeam1Writer = null;
		FileWriter microsecondCheckPointTeam2Writer= null;
		FileWriter microsecondCompletionTimeWriter = null;
		FileWriter microsecondCompletionTeam1Writer = null;
		FileWriter microsecondCompletionTeam2Writer = null;
		FileWriter microsecondContributionalEstimateWriter = null;
		FileWriter microsecondContributionalEstimateTeam1Writer = null;
		FileWriter microsecondContributionalEstimateTeam2Writer = null;
		FileWriter microsecondAudienceWriter = null;
		FileWriter microsecondAudienceTeam1Writer = null;
		FileWriter microsecondAudienceTeam2Writer = null;
		FileWriter microsecondModeOfOperationsWriter = null;
		FileWriter microsecondModeOfOperationsTeam1Writer = null; 
		FileWriter microsecondModeOfOperationsTeam2Writer = null;
		FileWriter microsecondExtractDataWriter = null;
		FileWriter microsecondExtractDataTeam1Writer = null;
		FileWriter microsecondExtractDataTeam2Writer = null;
		FileWriter microsecondLoggerWriter = null;
		FileWriter microsecondLoggerTeam1Writer = null;
		FileWriter microsecondLoggerTeam2Writer = null;
		FileWriter microsecondEventOccurrenceWriter = null;
		FileWriter microsecondEventOccurrenceTeam1Writer = null;
		FileWriter microsecondEventOccurrenceTeam2Writer = null;

		int microsecond = Microsecond.get_current_number(); 
		int size = 0;
		System.out.println("PLAYER ASSOCIATION TO SCHOOL SIZE: " + playerAssociationToSchool.size()); 

		try {
			if(playerAssociationToSchool.size() == 2) {
				MicrosecondPrGraphTeam1MemberWriter.get_file_writer(microsecond, 1); 
				MicrosecondPrGraphTeam1MemberWriter.file_writers[0].write(""); 
				MicrosecondPrFactsTeam1MemberWriter.get_file_writer(microsecond, 1);
				MicrosecondPrFactsTeam1MemberWriter.file_writers[0].write(""); 
				MicrosecondPrRulesTeam1MemberWriter.get_file_writer(microsecond, 1); 
				MicrosecondPrRulesTeam1MemberWriter.file_writers[0].write(""); 
				MicrosecondPrInterpretationsTeam1MemberWriter.get_file_writer(microsecond, 1); 
				MicrosecondPrInterpretationsTeam1MemberWriter.file_writers[0].write(""); 
				MicrosecondStaticLanguageTeam1MemberWriter.get_file_writer(microsecond, 1); 
				MicrosecondStaticLanguageTeam1MemberWriter.file_writers[0].write(""); 
				MicrosecondChangingLanguageTeam1MemberWriter.get_file_writer(microsecond, 1); 
				MicrosecondChangingLanguageTeam1MemberWriter.file_writers[0].write(""); 
			  MicrosecondStaticGrammarTeam1MemberWriter.get_file_writer(microsecond, 1); 
				MicrosecondStaticGrammarTeam1MemberWriter.file_writers[0].write(""); 
				MicrosecondChangingGrammarTeam1MemberWriter.get_file_writer(microsecond, 1); 
				MicrosecondChangingGrammarTeam1MemberWriter.file_writers[0].write(""); 
				MicrosecondGenerationTeam1MemberWriter.get_file_writer(microsecond, 1); 
				MicrosecondGenerationTeam1MemberWriter.file_writers[0].write(""); 
				MicrosecondOrderingPlacementsTeam1MemberWriter.get_file_writer(microsecond, 1);
				MicrosecondOrderingPlacementsTeam1MemberWriter.file_writers[0].write(""); 
				MicrosecondCombineTeam1MemberWriter.get_file_writer(microsecond, 1); 
				MicrosecondCombineTeam1MemberWriter.file_writers[0].write(""); 
				MicrosecondTeam1MemberSpellsWriter.get_file_writer(microsecond, 1); 
				MicrosecondTeam1MemberSpellsWriter.file_writers[0].write("");
				MicrosecondTacticalApproachTeam1MemberWriter.get_file_writer(microsecond, 1); 
				MicrosecondTacticalApproachTeam1MemberWriter.file_writers[0].write(""); 
				MicrosecondSelectionTeam1MemberSpellsWriter.get_file_writer(microsecond, 1); 
				MicrosecondSelectionTeam1MemberSpellsWriter.file_writers[0].write(""); 
				MicrosecondLeftOverTeam1MemberSpellsWriter.get_file_writer(microsecond, 1);
				MicrosecondLeftOverTeam1MemberSpellsWriter.file_writers[0].write(""); 
				MicrosecondDiscardTeam1MemberSpellsWriter.get_file_writer(microsecond, 1); 
				MicrosecondDiscardTeam1MemberSpellsWriter.file_writers[0].write(""); 
				MicrosecondGarbageCollectionTeam1MemberWriter.get_file_writer(microsecond, 1); 
				MicrosecondGarbageCollectionTeam1MemberWriter.file_writers[0].write(""); 
				MicrosecondLexicalAnalyzerTeam1MemberWriter.get_file_writer(microsecond, 1); 
				MicrosecondLexicalAnalyzerTeam1MemberWriter.file_writers[0].write(""); 
				MicrosecondDFATeam1MemberWriter.get_file_writer(microsecond, 1);
				MicrosecondDFATeam1MemberWriter.file_writers[0].write(""); 
				MicrosecondNFATeam1MemberWriter.get_file_writer(microsecond, 1);
				MicrosecondNFATeam1MemberWriter.file_writers[0].write(""); 
				MicrosecondRunTimeTeam1MemberWriter.get_file_writer(microsecond, 1); 
				MicrosecondRunTimeTeam1MemberWriter.file_writers[0].write("");
				MicrosecondReferencePointersTeam1MemberWriter.get_file_writer(microsecond, 1); 
				MicrosecondReferencePointersTeam1MemberWriter.file_writers[0].write(""); 
				MicrosecondOutputSpellsTeam1MemberWriter.get_file_writer(microsecond, 1); 
				MicrosecondOutputSpellsTeam1MemberWriter.file_writers[0].write(""); 
				MicrosecondPathTraceTeam1MemberWriter.get_file_writer(microsecond, 1);
				MicrosecondPathTraceTeam1MemberWriter.file_writers[0].write(""); 
				MicrosecondTraceToStartTeam1MemberWriter.get_file_writer(microsecond, 1); 
				MicrosecondTraceToStartTeam1MemberWriter.file_writers[0].write(""); 
				MicrosecondSatisfierTeam1MemberWriter.get_file_writer(microsecond, 1); 
				MicrosecondSatisfierTeam1MemberWriter.file_writers[0].write(""); 
				MicrosecondHistoryTeam1MemberWriter.get_file_writer(microsecond, 1); 
				MicrosecondHistoryTeam1MemberWriter.file_writers[0].write(""); 
				MicrosecondIncorporationConceptTeam1MemberWriter.get_file_writer(microsecond, 1); 
				MicrosecondIncorporationConceptTeam1MemberWriter.file_writers[0].write(""); 
				MicrosecondCheckPointTeam1MemberWriter.get_file_writer(microsecond, 1); 
				MicrosecondCheckPointTeam1MemberWriter.file_writers[0].write(""); 
				MicrosecondContributionalEstimateTeam1MemberWriter.get_file_writer(microsecond, 1); 
				MicrosecondContributionalEstimateTeam1MemberWriter.file_writers[0].write(""); 
				MicrosecondAudienceTeam1MemberWriter.get_file_writer(microsecond, 1); 
				MicrosecondAudienceTeam1MemberWriter.file_writers[0].write(""); 
				MicrosecondModeOfOperationsTeam1MemberWriter.get_file_writer(microsecond, 1); 
				MicrosecondModeOfOperationsTeam1MemberWriter.file_writers[0].write(""); 
				MicrosecondExtractDataTeam1MemberWriter.get_file_writer(microsecond, 1); 
				MicrosecondExtractDataTeam1MemberWriter.file_writers[0].write(""); 
				MicrosecondLoggerTeam1MemberWriter.get_file_writer(microsecond, 1); 
				MicrosecondLoggerTeam1MemberWriter.file_writers[0].write(""); 
				MicrosecondPrGraphTeam2MemberWriter.get_file_writer(microsecond, 1); 
				MicrosecondPrGraphTeam2MemberWriter.file_writers[0].write(""); 
				MicrosecondPrFactsTeam2MemberWriter.get_file_writer(microsecond, 1);
				MicrosecondPrFactsTeam2MemberWriter.file_writers[0].write(""); 
				MicrosecondPrRulesTeam2MemberWriter.get_file_writer(microsecond, 1); 
				MicrosecondPrRulesTeam2MemberWriter.file_writers[0].write(""); 
				MicrosecondPrInterpretationsTeam2MemberWriter.get_file_writer(microsecond, 1); 
				MicrosecondPrInterpretationsTeam2MemberWriter.file_writers[0].write(""); 
				MicrosecondStaticLanguageTeam2MemberWriter.get_file_writer(microsecond, 1); 
				MicrosecondStaticLanguageTeam2MemberWriter.file_writers[0].write(""); 
				MicrosecondChangingLanguageTeam2MemberWriter.get_file_writer(microsecond, 1); 
				MicrosecondChangingLanguageTeam2MemberWriter.file_writers[0].write(""); 
				MicrosecondStaticGrammarTeam2MemberWriter.get_file_writer(microsecond, 1); 
				MicrosecondStaticGrammarTeam2MemberWriter.file_writers[0].write(""); 
				MicrosecondChangingGrammarTeam2MemberWriter.get_file_writer(microsecond, 1); 
				MicrosecondChangingGrammarTeam2MemberWriter.file_writers[0].write(""); 
				MicrosecondGenerationTeam2MemberWriter.get_file_writer(microsecond, 1); 
				MicrosecondGenerationTeam2MemberWriter.file_writers[0].write(""); 
				MicrosecondOrderingPlacementsTeam2MemberWriter.get_file_writer(microsecond, 1);
				MicrosecondOrderingPlacementsTeam2MemberWriter.file_writers[0].write(""); 
				MicrosecondCombineTeam2MemberWriter.get_file_writer(microsecond, 1);
				MicrosecondCombineTeam2MemberWriter.file_writers[0].write(""); 
				MicrosecondTeam2MemberSpellsWriter.get_file_writer(microsecond, 1); 
				MicrosecondTeam2MemberSpellsWriter.file_writers[0].write(""); 
				MicrosecondTacticalApproachTeam2MemberWriter.get_file_writer(microsecond, 1); 
				MicrosecondTacticalApproachTeam2MemberWriter.file_writers[0].write(""); 
				MicrosecondSelectionTeam2MemberSpellsWriter.get_file_writer(microsecond, 1); 
				MicrosecondSelectionTeam2MemberSpellsWriter.file_writers[0].write(""); 
				MicrosecondLeftOverTeam2MemberSpellsWriter.get_file_writer(microsecond, 1); 
				MicrosecondLeftOverTeam2MemberSpellsWriter.file_writers[0].write("");
				MicrosecondDiscardTeam2MemberSpellsWriter.get_file_writer(microsecond, 1); 
				MicrosecondDiscardTeam2MemberSpellsWriter.file_writers[0].write(""); 
				MicrosecondGarbageCollectionTeam2MemberWriter.get_file_writer(microsecond, 1); 
				MicrosecondGarbageCollectionTeam2MemberWriter.file_writers[0].write(""); 
				MicrosecondLexicalAnalyzerTeam2MemberWriter.get_file_writer(microsecond, 1); 
				MicrosecondLexicalAnalyzerTeam2MemberWriter.file_writers[0].write(""); 
				MicrosecondDFATeam2MemberWriter.get_file_writer(microsecond, 1);
				MicrosecondDFATeam2MemberWriter.file_writers[0].write(""); 
				MicrosecondNFATeam2MemberWriter.get_file_writer(microsecond, 1);
				MicrosecondNFATeam2MemberWriter.file_writers[0].write(""); 
				MicrosecondRunTimeTeam2MemberWriter.get_file_writer(microsecond, 1);
				MicrosecondRunTimeTeam2MemberWriter.file_writers[0].write("");
				MicrosecondReferencePointersTeam2MemberWriter.get_file_writer(microsecond, 1); 
				MicrosecondReferencePointersTeam2MemberWriter.file_writers[0].write(""); 
				MicrosecondOutputSpellsTeam2MemberWriter.get_file_writer(microsecond, 1); 
				MicrosecondOutputSpellsTeam2MemberWriter.file_writers[0].write(""); 
				MicrosecondPathTraceTeam2MemberWriter.get_file_writer(microsecond, 1);
				MicrosecondPathTraceTeam2MemberWriter.file_writers[0].write(""); 
				MicrosecondTraceToStartTeam2MemberWriter.get_file_writer(microsecond, 1); 
				MicrosecondTraceToStartTeam2MemberWriter.file_writers[0].write(""); 
				MicrosecondSatisfierTeam2MemberWriter.get_file_writer(microsecond, 1); 
				MicrosecondSatisfierTeam2MemberWriter.file_writers[0].write(""); 
				MicrosecondHistoryTeam2MemberWriter.get_file_writer(microsecond, 1); 
				MicrosecondHistoryTeam2MemberWriter.file_writers[0].write(""); 
				MicrosecondIncorporationConceptTeam2MemberWriter.get_file_writer(microsecond, 1); 
				MicrosecondIncorporationConceptTeam2MemberWriter.file_writers[0].write(""); 
				MicrosecondCheckPointTeam2MemberWriter.get_file_writer(microsecond, 1); 
				MicrosecondCheckPointTeam2MemberWriter.file_writers[0].write(""); 
				MicrosecondContributionalEstimateTeam2MemberWriter.get_file_writer(microsecond, 1); 
				MicrosecondContributionalEstimateTeam2MemberWriter.file_writers[0].write(""); 
				MicrosecondAudienceTeam2MemberWriter.get_file_writer(microsecond, 1); 
				MicrosecondAudienceTeam2MemberWriter.file_writers[0].write(""); 
				MicrosecondModeOfOperationsTeam2MemberWriter.get_file_writer(microsecond, 1); 
				MicrosecondModeOfOperationsTeam2MemberWriter.file_writers[0].write(""); 
				MicrosecondExtractDataTeam2MemberWriter.get_file_writer(microsecond, 1); 
				MicrosecondExtractDataTeam2MemberWriter.file_writers[0].write(""); 
				MicrosecondLoggerTeam2MemberWriter.get_file_writer(microsecond, 1); 
				MicrosecondLoggerTeam2MemberWriter.file_writers[0].write(""); 
				size = 1; 
			}
			else if(playerAssociationToSchool.size() == 4) {
				MicrosecondTeam1MemberSpellsWriter.get_file_writer(microsecond, 1); 
				MicrosecondTeam1MemberSpellsWriter.file_writers[0].write(""); 
				MicrosecondTeam1MemberSpellsWriter.get_file_writer(microsecond, 2); 
				MicrosecondTeam1MemberSpellsWriter.file_writers[1].write(""); 
				MicrosecondTeam2MemberSpellsWriter.get_file_writer(microsecond, 1);
				MicrosecondTeam2MemberSpellsWriter.file_writers[0].write(""); 
				MicrosecondTeam2MemberSpellsWriter.get_file_writer(microsecond, 2); 
				MicrosecondTeam2MemberSpellsWriter.file_writers[1].write(""); 
				size = 4; 
			}
			else if(playerAssociationToSchool.size() == 6) {
				MicrosecondTeam1MemberSpellsWriter.get_file_writer(microsecond, 1); 
				MicrosecondTeam1MemberSpellsWriter.file_writers[0].write(""); 
				MicrosecondTeam1MemberSpellsWriter.get_file_writer(microsecond, 2); 
				MicrosecondTeam1MemberSpellsWriter.file_writers[1].write(""); 
				MicrosecondTeam1MemberSpellsWriter.get_file_writer(microsecond, 3); 
				MicrosecondTeam1MemberSpellsWriter.file_writers[2].write(""); 
				MicrosecondTeam2MemberSpellsWriter.get_file_writer(microsecond, 1); 
				MicrosecondTeam2MemberSpellsWriter.file_writers[0].write(""); 
				MicrosecondTeam2MemberSpellsWriter.get_file_writer(microsecond, 2); 
				MicrosecondTeam2MemberSpellsWriter.file_writers[1].write(""); 
				MicrosecondTeam2MemberSpellsWriter.get_file_writer(microsecond, 3); 
				MicrosecondTeam2MemberSpellsWriter.file_writers[2].write(""); 
				size = 6; 
			}
			else if(playerAssociationToSchool.size() == 8) {
				MicrosecondTeam1MemberSpellsWriter.get_file_writer(microsecond, 1); 
				MicrosecondTeam1MemberSpellsWriter.file_writers[0].write(""); 
				MicrosecondTeam1MemberSpellsWriter.get_file_writer(microsecond, 2); 
				MicrosecondTeam1MemberSpellsWriter.file_writers[1].write(""); 
				MicrosecondTeam1MemberSpellsWriter.get_file_writer(microsecond, 3); 
				MicrosecondTeam1MemberSpellsWriter.file_writers[2].write(""); 
				MicrosecondTeam1MemberSpellsWriter.get_file_writer(microsecond, 4); 
				MicrosecondTeam1MemberSpellsWriter.file_writers[3].write(""); 
				MicrosecondTeam2MemberSpellsWriter.get_file_writer(microsecond, 1); 
				MicrosecondTeam2MemberSpellsWriter.file_writers[0].write(""); 
				MicrosecondTeam2MemberSpellsWriter.get_file_writer(microsecond, 2); 
				MicrosecondTeam2MemberSpellsWriter.file_writers[1].write(""); 
				MicrosecondTeam2MemberSpellsWriter.get_file_writer(microsecond, 3); 
				MicrosecondTeam2MemberSpellsWriter.file_writers[2].write(""); 
				MicrosecondTeam2MemberSpellsWriter.get_file_writer(microsecond, 4); 
				MicrosecondTeam2MemberSpellsWriter.file_writers[3].write(""); 
				size = 8; 
			}
			secondCombineWriter = SecondCombineWriter.get_file_writer();
			secondCombineWriter.write(""); 
			secondModuleByModuleWriter = MicrosecondByMicrosecondWriter.get_file_writer();
			secondModuleByModuleWriter.write(""); 
			secondExcessSpellsWriter = SecondDiscardSpellsWriter.get_file_writer();
			secondExcessSpellsWriter.write(""); 
			secondExcessSpellsTeam1Writer = SecondDiscardSpellsTeam1Writer.get_file_writer();
			secondExcessSpellsTeam1Writer.write(""); 
			secondExcessSpellsTeam2Writer = SecondDiscardSpellsTeam2Writer.get_file_writer();
			secondExcessSpellsTeam2Writer.write("");
			secondRemainingSpellsWriter = SecondLeftOverSpellsWriter.get_file_writer();
			secondRemainingSpellsWriter.write(""); 
			secondRemainingSpellsTeam1Writer = SecondLeftOverSpellsTeam1Writer.get_file_writer();
			secondRemainingSpellsTeam1Writer.write(""); 
			secondRemainingSpellsTeam2Writer = SecondLeftOverSpellsTeam2Writer.get_file_writer();
			secondRemainingSpellsTeam2Writer.write(""); 
			secondSelectionLineWriter = SecondSelectionWriter.get_file_writer(); 
			secondSelectionLineWriter.write(""); 
			secondSelectionLineTeam1Writer = ProductSelectionTeam1Writer.get_file_writer();
			secondSelectionLineTeam1Writer.write(""); 
			secondSelectionLineTeam2Writer = SecondSelectionTeam2Writer.get_file_writer();
			secondSelectionLineTeam2Writer.write(""); 
			microsecondPrGraphWriter = MicrosecondPrGraphWriter.get_file_writer(microsecond); 
			microsecondPrGraphWriter.write(""); 
			microsecondPrGraphTeam1Writer = MicrosecondPrGraphTeam1Writer.get_file_writer(microsecond); 
			microsecondPrGraphTeam1Writer.write(""); 
			microsecondPrGraphTeam2Writer = MicrosecondPrGraphTeam2Writer.get_file_writer(microsecond); 
			microsecondPrGraphTeam2Writer.write(""); 
			microsecondPrFactsWriter = MicrosecondPrFactsWriter.get_file_writer(microsecond); 
			microsecondPrFactsWriter.write(""); 
			microsecondPrFactsTeam1Writer = MicrosecondPrFactsTeam1Writer.get_file_writer(microsecond); 
			microsecondPrFactsTeam1Writer.write(""); 
			microsecondPrFactsTeam2Writer = MicrosecondPrFactsTeam2Writer.get_file_writer(microsecond); 
			microsecondPrFactsTeam2Writer.write(""); 
			microsecondPrRulesWriter = MicrosecondPrRulesWriter.get_file_writer(microsecond); 
			microsecondPrRulesWriter.write(""); 
			microsecondPrRulesTeam1Writer = MicrosecondPrRulesTeam1Writer.get_file_writer(microsecond); 
			microsecondPrRulesTeam1Writer.write(""); 
			microsecondPrRulesTeam2Writer = MicrosecondPrRulesTeam2Writer.get_file_writer(microsecond); 
			microsecondPrRulesTeam2Writer.write(""); 
			microsecondPrInterpretationsWriter = MicrosecondPrInterpretationsWriter.get_file_writer(microsecond); 
			microsecondPrInterpretationsWriter.write(""); 
			microsecondPrInterpretationsTeam1Writer = MicrosecondPrInterpretationsTeam1Writer.get_file_writer(microsecond); 
			microsecondPrInterpretationsTeam1Writer.write(""); 
			microsecondPrInterpretationsTeam2Writer = MicrosecondPrInterpretationsTeam2Writer.get_file_writer(microsecond); 
			microsecondPrInterpretationsTeam2Writer.write(""); 
			microsecondStaticLanguageWriter = MicrosecondStaticLanguageWriter.get_file_writer(microsecond); 
			microsecondStaticLanguageWriter.write(""); 
			microsecondStaticLanguageTeam1Writer = MicrosecondStaticLanguageTeam1Writer.get_file_writer(microsecond); 
			microsecondStaticLanguageTeam1Writer.write(""); 
			microsecondStaticLanguageTeam2Writer = ModuleStaticLanguageTeam2Writer.get_file_writer(microsecond); 
			microsecondStaticLanguageTeam2Writer.write(""); 
			microsecondChangingLanguageWriter = MicrosecondChangingLanguageWriter.get_file_writer(microsecond);
			microsecondChangingLanguageWriter.write(""); 
			microsecondChangingLanguageTeam1Writer = MicrosecondChangingLanguageTeam1Writer.get_file_writer(microsecond); 
			microsecondChangingLanguageTeam1Writer.write(""); 
			microsecondChangingLanguageTeam2Writer = MicrosecondChangingLanguageTeam2Writer.get_file_writer(microsecond); 
			microsecondChangingLanguageTeam2Writer.write(""); 
			microsecondStaticGrammarWriter = MicrosecondStaticGrammarWriter.get_file_writer(microsecond); 
			microsecondStaticGrammarWriter.write(""); 
			microsecondStaticGrammarTeam1Writer = MicrosecondStaticGrammarTeam1Writer.get_file_writer(microsecond);
			microsecondStaticGrammarTeam1Writer.write(""); 
			microsecondStaticGrammarTeam2Writer = MicrosecondStaticGrammarTeam2Writer.get_file_writer(microsecond); 
			microsecondStaticGrammarTeam2Writer.write(""); 
			microsecondChangingGrammarWriter = MicrosecondChangingGrammarWriter.get_file_writer(microsecond); 
			microsecondChangingGrammarWriter.write(""); 
			microsecondChangingGrammarTeam1Writer = MicrosecondChangingGrammarTeam1Writer.get_file_writer(microsecond); 
			microsecondChangingGrammarTeam1Writer.write(""); 
			microsecondChangingGrammarTeam2Writer = MicrosecondChangingGrammarTeam2Writer.get_file_writer(microsecond); 
			microsecondChangingGrammarTeam2Writer.write(""); 
			microsecondGenerationWriter = MicrosecondGenerationWriter.get_file_writer(microsecond);
			microsecondGenerationWriter.write(""); 
			microsecondGenerationTeam1Writer = MicrosecondGenerationTeam1Writer.get_file_writer(microsecond); 
			microsecondGenerationTeam1Writer.write(""); 
			microsecondGenerationTeam2Writer = MicrosecondGenerationTeam2Writer.get_file_writer(microsecond); 
			microsecondGenerationTeam2Writer.write(""); 
			microsecondOrderingPlacementsWriter = MicrosecondOrderingPlacementsWriter.get_file_writer(microsecond); 
			microsecondOrderingPlacementsWriter.write(""); 
			microsecondOrderingPlacementsTeam1Writer = MicrosecondOrderingPlacementsTeam1Writer.get_file_writer(microsecond); 
			microsecondOrderingPlacementsTeam1Writer.write(""); 
			microsecondOrderingPlacementsTeam2Writer = MicrosecondOrderingPlacementsTeam2Writer.get_file_writer(microsecond); 
			microsecondOrderingPlacementsTeam2Writer.write(""); 
			microsecondCombineWriter = MicrosecondCombineWriter.get_file_writer(microsecond); 
			microsecondCombineWriter.write(""); 
			microsecondTeam1SpellsWriter = MicrosecondTeam1SpellsWriter.get_file_writer(microsecond); 
			microsecondTeam1SpellsWriter.write(""); 
			microsecondTeam2SpellsWriter = MicrosecondTeam2SpellsWriter.get_file_writer(microsecond); 
			microsecondTeam2SpellsWriter.write(""); 
			microsecondDefaultWriter = MicrosecondOfSpellsWriter.get_file_writer(microsecond);
			microsecondDefaultWriter.write(""); 
			microsecondTacticalApproachWriter = MicrosecondTacticalApproachWriter.get_file_writer(microsecond);
			microsecondTacticalApproachWriter.write(""); 
			microsecondTacticalApproachTeam1Writer = MicrosecondTacticalApproachTeam1Writer.get_file_writer(microsecond);  
			microsecondTacticalApproachTeam1Writer.write(""); 
			microsecondTacticalApproachTeam2Writer = MicrosecondTacticalApproachTeam2Writer.get_file_writer(microsecond); 
			microsecondTacticalApproachTeam2Writer.write(""); 
			microsecondSelectionLineWriter = MicrosecondSelectionWriter.get_file_writer(microsecond); 
			microsecondSelectionLineWriter.write(""); 
			microsecondSelectionLineTeam1Writer = MicrosecondSelectionTeam1Writer.get_file_writer(microsecond); 
			microsecondSelectionLineTeam1Writer.write(""); 
			microsecondSelectionLineTeam2Writer = MicrosecondSelectionTeam2Writer.get_file_writer(microsecond); 
			microsecondSelectionLineTeam2Writer.write(""); 
			microsecondRemainingSpellsWriter = MicrosecondLeftOverSpellsWriter.get_file_writer(microsecond);
			microsecondRemainingSpellsWriter.write(""); 
			microsecondRemainingTeam1SpellsWriter = MicrosecondLeftOverSpellsTeam1Writer.get_file_writer(microsecond); 
			microsecondRemainingTeam1SpellsWriter.write(""); 
			microsecondRemainingTeam2SpellsWriter = MicrosecondLeftOverSpellsTeam2Writer.get_file_writer(microsecond); 
			microsecondRemainingTeam2SpellsWriter.write(""); 
			microsecondExcessSpellsWriter = MicrosecondDiscardSpellsWriter.get_file_writer(microsecond); 
			microsecondExcessSpellsWriter.write(""); 
			microsecondExcessSpellsTeam1Writer = MicrosecondDiscardSpellsTeam1Writer.get_file_writer(microsecond); 
			microsecondExcessSpellsTeam1Writer.write(""); 
			microsecondExcessSpellsTeam2Writer = MicrosecondDiscardSpellsTeam2Writer.get_file_writer(microsecond); 
			microsecondExcessSpellsTeam2Writer.write(""); 
			microsecondGarbageCollectionWriter = MicrosecondGarbageCollectionWriter.get_file_writer(microsecond); 
			microsecondGarbageCollectionWriter.write(""); 
			microsecondGarbageCollectionTeam1Writer = MicrosecondGarbageCollectionTeam1Writer.get_file_writer(microsecond); 
			microsecondGarbageCollectionTeam1Writer.write(""); 
			microsecondGarbageCollectionTeam2Writer = MicrosecondGarbageCollectionTeam2Writer.get_file_writer(microsecond); 
			microsecondGarbageCollectionTeam2Writer.write(""); 
			microsecondLexicalAnalyzerWriter = MicrosecondLexicalAnalyzerWriter.get_file_writer(microsecond); 
			microsecondLexicalAnalyzerWriter.write(""); 
			microsecondLexicalAnalyzerTeam1Writer = MicrosecondLexicalAnalyzerTeam1Writer.get_file_writer(microsecond); 
			microsecondLexicalAnalyzerTeam1Writer.write(""); 
			microsecondLexicalAnalyzerTeam2Writer = MicrosecondLexicalAnalyzerTeam2Writer.get_file_writer(microsecond); 
			microsecondLexicalAnalyzerTeam2Writer.write(""); 
			microsecondDFAWriter = MicrosecondDFAWriter.get_file_writer(microsecond); 
			microsecondDFAWriter.write(""); 
			microsecondDFATeam1Writer = MicrosecondDFATeam1Writer.get_file_writer(microsecond); 
			microsecondDFATeam1Writer.write(""); 
			microsecondDFATeam2Writer = MicrosecondDFATeam2Writer.get_file_writer(microsecond); 
			microsecondDFATeam2Writer.write("");
			microsecondNFAWriter = MicrosecondNFAWriter.get_file_writer(microsecond); 
			microsecondNFAWriter.write(""); 
			microsecondNFATeam1Writer = MicrosecondNFATeam1Writer.get_file_writer(microsecond); 
			microsecondNFATeam1Writer.write(""); 
			microsecondNFATeam2Writer = MicrosecondNFATeam2Writer.get_file_writer(microsecond); 
			microsecondNFATeam2Writer.write(""); 
			microsecondRunTimeWriter = MicrosecondRunTimeWriter.get_file_writer(microsecond); 
			microsecondRunTimeWriter.write(""); 
			microsecondRunTimeTeam1Writer = MicrosecondRunTimeTeam1Writer.get_file_writer(microsecond); 
			microsecondRunTimeTeam1Writer.write(""); 
			microsecondRunTimeTeam2Writer = MicrosecondRunTimeTeam2Writer.get_file_writer(microsecond); 
			microsecondRunTimeTeam2Writer.write(""); 
			microsecondReferencePointersWriter = MicrosecondReferencePointersWriter.get_file_writer(microsecond); 
			microsecondReferencePointersWriter.write(""); 
			microsecondReferencePointersTeam1Writer = MicrosecondReferencePointersTeam1Writer.get_file_writer(microsecond); 
			microsecondReferencePointersTeam1Writer.write(""); 
			microsecondReferencePointersTeam2Writer = MicrosecondReferencePointersTeam2Writer.get_file_writer(microsecond); 
			microsecondReferencePointersTeam2Writer.write(""); 
			microsecondComputationSpellsWriter = MicrosecondOutputSpellsWriter.get_file_writer(microsecond); 
			microsecondComputationSpellsWriter.write(""); 
			microsecondComputationSpellsTeam1Writer = MicrosecondOutputSpellsTeam1Writer.get_file_writer(microsecond); 
			microsecondComputationSpellsTeam1Writer.write(""); 
			microsecondComputationSpellsTeam2Writer = MicrosecondOutputSpellsTeam2Writer.get_file_writer(microsecond); 
			microsecondComputationSpellsTeam2Writer.write(""); 
			microsecondPathTraceWriter = MicrosecondPathTraceWriter.get_file_writer(microsecond); 
			microsecondPathTraceWriter.write(""); 
			microsecondPathTraceTeam1Writer = MicrosecondPathTraceTeam1Writer.get_file_writer(microsecond); 
			microsecondPathTraceTeam1Writer.write(""); 
			microsecondPathTraceTeam2Writer = MicrosecondPathTraceTeam2Writer.get_file_writer(microsecond); 
			microsecondPathTraceTeam2Writer.write(""); 
			microsecondTraceToStartWriter = MicrosecondTraceToStartWriter.get_file_writer(microsecond); 
			microsecondTraceToStartWriter.write(""); 
			microsecondTraceToStartTeam1Writer = MicrosecondTraceToStartTeam1Writer.get_file_writer(microsecond); 
			microsecondTraceToStartTeam1Writer.write(""); 
			microsecondTraceToStartTeam2Writer = MicrosecondTraceToStartTeam2Writer.get_file_writer(microsecond); 
			microsecondTraceToStartTeam2Writer.write(""); 
			microsecondSatisfierWriter = MicrosecondSatisfierWriter.get_file_writer(microsecond); 
			microsecondSatisfierWriter.write(""); 
			microsecondSatisfierTeam1Writer = MicrosecondSatisfierTeam1Writer.get_file_writer(microsecond); 
			microsecondSatisfierTeam1Writer.write(""); 
			microsecondSatisfierTeam2Writer = MicrosecondSatisfierTeam2Writer.get_file_writer(microsecond); 
			microsecondSatisfierTeam2Writer.write(""); 
			microsecondHistoryWriter = MicrosecondHistoryWriter.get_file_writer(microsecond); 
			microsecondHistoryWriter.write(""); 
			microsecondHistoryTeam1Writer = MicrosecondHistoryTeam1Writer.get_file_writer(microsecond); 
			microsecondHistoryTeam1Writer.write(""); 
			microsecondHistoryTeam2Writer = MicrosecondHistoryTeam2Writer.get_file_writer(microsecond); 
			microsecondHistoryTeam2Writer.write(""); 
			microsecondIncorporationConceptWriter = MicrosecondIncorporationConceptTeam1Writer.get_file_writer(microsecond); 
			microsecondIncorporationConceptWriter.write(""); 
			microsecondIncorporationConceptTeam1Writer = MicrosecondIncorporationConceptTeam1Writer.get_file_writer(microsecond); 
			microsecondIncorporationConceptTeam1Writer.write(""); 
			microsecondIncorporationConceptTeam2Writer = MicrosecondIncorporationConceptTeam2Writer.get_file_writer(microsecond); 
			microsecondIncorporationConceptTeam2Writer.write(""); 
			microsecondCheckPointWriter = MicrosecondCheckPointWriter.get_file_writer(microsecond); 
			microsecondCheckPointWriter.write(""); 
			microsecondCheckPointTeam1Writer = MicrosecondCheckPointTeam1Writer.get_file_writer(microsecond); 
			microsecondCheckPointTeam1Writer.write(""); 
			microsecondCheckPointTeam2Writer = MicrosecondCheckPointTeam2Writer.get_file_writer(microsecond); 
			microsecondCheckPointTeam2Writer.write(""); 
			microsecondContributionalEstimateWriter = MicrosecondContributionalEstimateWriter.get_file_writer(microsecond);
			microsecondContributionalEstimateWriter.write(""); 
			microsecondContributionalEstimateTeam1Writer = MicrosecondContributionalEstimateTeam1Writer.get_file_writer(microsecond); 
			microsecondContributionalEstimateTeam1Writer.write(""); 
			microsecondContributionalEstimateTeam2Writer = MicrosecondContributionalEstimateTeam2Writer.get_file_writer(microsecond); 
			microsecondContributionalEstimateTeam2Writer.write(""); 
			microsecondAudienceWriter = MicrosecondAudienceWriter.get_file_writer(microsecond); 
			microsecondAudienceWriter.write(""); 
			microsecondAudienceTeam1Writer = MicrosecondAudienceTeam1Writer.get_file_writer(microsecond); 
			microsecondAudienceTeam1Writer.write(""); 
			microsecondAudienceTeam2Writer = MicrosecondAudienceTeam2Writer.get_file_writer(microsecond);
			microsecondAudienceTeam2Writer.write(""); 
			microsecondModeOfOperationsWriter = MicrosecondModeOfOperationsWriter.get_file_writer(microsecond);
			microsecondModeOfOperationsWriter.write(""); 
			microsecondModeOfOperationsTeam1Writer = MicrosecondModeOfOperationsTeam1Writer.get_file_writer(microsecond);
			microsecondModeOfOperationsTeam1Writer.write(""); 
			microsecondModeOfOperationsTeam2Writer = MicrosecondModeOfOperationsTeam2Writer.get_file_writer(microsecond); 
			microsecondModeOfOperationsTeam2Writer.write(""); 
			microsecondExtractDataWriter = MicrosecondExtractDataWriter.get_file_writer(microsecond);
			microsecondExtractDataWriter.write("");
			microsecondExtractDataTeam1Writer = MicrosecondExtractDataTeam1Writer.get_file_writer(microsecond);
			microsecondExtractDataTeam1Writer.write("");
			microsecondExtractDataTeam2Writer = MicrosecondExtractDataTeam2Writer.get_file_writer(microsecond);
			microsecondExtractDataTeam2Writer.write("");
			microsecondLoggerWriter = MicrosecondLoggerWriter.get_file_writer(microsecond);
			microsecondLoggerWriter.write("");
			microsecondLoggerTeam1Writer = MicrosecondLoggerTeam1Writer.get_file_writer(microsecond);
			microsecondLoggerTeam1Writer.write(""); 
			microsecondLoggerTeam2Writer = MicrosecondLoggerTeam2Writer.get_file_writer(microsecond); 
			microsecondLoggerTeam2Writer.write(""); 	
		} catch (Exception e) {
			if(playerAssociationToSchool.size() == 2) {
				MicrosecondStaticLanguageTeam1MemberWriter.setWriterCreated(false);
				MicrosecondStaticLanguageTeam1MemberWriter.get_file_writer(microsecond, 1); 
				MicrosecondChangingLanguageTeam1MemberWriter.setWriterCreated(false); 
				MicrosecondChangingLanguageTeam1MemberWriter.get_file_writer(microsecond, 1); 
				MicrosecondChangingLanguageTeam1MemberWriter.file_writers[0].write(""); 
				MicrosecondStaticGrammarTeam1MemberWriter.setWriterCreated(false); 
				MicrosecondStaticGrammarTeam1MemberWriter.get_file_writer(microsecond, 1); 
				MicrosecondChangingGrammarTeam1MemberWriter.setWriterCreated(false);
				MicrosecondChangingGrammarTeam1MemberWriter.get_file_writer(microsecond, 1); 
				MicrosecondGenerationTeam1MemberWriter.setWriterCreated(false); 
				MicrosecondGenerationTeam1MemberWriter.get_file_writer(microsecond, 1); 
				MicrosecondOrderingPlacementsTeam1MemberWriter.setWriterCreated(false);
				MicrosecondOrderingPlacementsTeam1MemberWriter.get_file_writer(microsecond, 1); 
				MicrosecondCombineTeam1MemberWriter.setWriterCreated(false);
				MicrosecondCombineTeam1MemberWriter.get_file_writer(microsecond, 1);
				MicrosecondTeam1MemberSpellsWriter.setWriterCreated(false); 
				MicrosecondTeam1MemberSpellsWriter.get_file_writer(microsecond, 1); 
				MicrosecondTacticalApproachTeam1MemberWriter.setWriterCreated(false); 
				MicrosecondTacticalApproachTeam1MemberWriter.get_file_writer(microsecond, 1); 
				MicrosecondSelectionTeam1MemberSpellsWriter.setWriterCreated(false); 
				MicrosecondSelectionTeam1MemberSpellsWriter.get_file_writer(microsecond, 1); 
				MicrosecondLeftOverTeam1MemberSpellsWriter.setWriterCreated(false); 
				MicrosecondLeftOverTeam1MemberSpellsWriter.get_file_writer(microsecond, 1);
				MicrosecondDiscardTeam1MemberSpellsWriter.setWriterCreated(false);
				MicrosecondDiscardTeam1MemberSpellsWriter.get_file_writer(microsecond, 1);
				MicrosecondGarbageCollectionTeam1MemberWriter.setWriterCreated(false); 
				MicrosecondGarbageCollectionTeam1MemberWriter.get_file_writer(microsecond, 1);
				MicrosecondLexicalAnalyzerTeam1MemberWriter.setWriterCreated(false); 
				MicrosecondLexicalAnalyzerTeam1MemberWriter.get_file_writer(microsecond, 1); 
				MicrosecondGarbageCollectionTeam1MemberWriter.setWriterCreated(false); 
				MicrosecondGarbageCollectionTeam1MemberWriter.get_file_writer(microsecond, 1); 
				MicrosecondLexicalAnalyzerTeam1MemberWriter.setWriterCreated(false); 
				MicrosecondLexicalAnalyzerTeam1MemberWriter.get_file_writer(microsecond, 1); 
				MicrosecondDFATeam1MemberWriter.setWriterCreated(false);
				MicrosecondDFATeam1MemberWriter.get_file_writer(microsecond, 1);
				MicrosecondNFATeam1MemberWriter.setWriterCreated(false);
				MicrosecondNFATeam1MemberWriter.get_file_writer(microsecond, 1);
				MicrosecondRunTimeTeam1MemberWriter.setWriterCreated(false); 
				MicrosecondRunTimeTeam1MemberWriter.get_file_writer(microsecond, 1); 
				MicrosecondReferencePointersTeam1MemberWriter.setWriterCreated(false); 
				MicrosecondReferencePointersTeam1MemberWriter.get_file_writer(microsecond, 1); 
				MicrosecondOutputSpellsTeam1MemberWriter.setWriterCreated(false);
				MicrosecondOutputSpellsTeam1MemberWriter.get_file_writer(microsecond, 1); 
				MicrosecondPathTraceTeam1MemberWriter.setWriterCreated(false);
				MicrosecondPathTraceTeam1MemberWriter.get_file_writer(microsecond, 1);
				MicrosecondTraceToStartTeam1MemberWriter.setWriterCreated(false); 
				MicrosecondTraceToStartTeam1MemberWriter.get_file_writer(microsecond, 1); 
				MicrosecondSatisfierTeam1MemberWriter.setWriterCreated(false);
				MicrosecondSatisfierTeam1MemberWriter.get_file_writer(microsecond, 1); 
				MicrosecondHistoryTeam1MemberWriter.setWriterCreated(false);
				MicrosecondHistoryTeam1MemberWriter.get_file_writer(microsecond, 1); 
				MicrosecondIncorporationConceptTeam1MemberWriter.setWriterCreated(false);
				MicrosecondIncorporationConceptTeam1MemberWriter.get_file_writer(microsecond, 1); 
				MicrosecondCheckPointTeam1MemberWriter.setWriterCreated(false);
				MicrosecondCheckPointTeam1MemberWriter.get_file_writer(microsecond, 1); 
				MicrosecondContributionalEstimateTeam1MemberWriter.setWriterCreated(false);
				MicrosecondContributionalEstimateTeam1MemberWriter.get_file_writer(microsecond, 1); 
				MicrosecondAudienceTeam1MemberWriter.setWriterCreated(false);
				MicrosecondAudienceTeam1MemberWriter.get_file_writer(microsecond, 1); 
				MicrosecondModeOfOperationsTeam1MemberWriter.setWriterCreated(false);
				MicrosecondModeOfOperationsTeam1MemberWriter.get_file_writer(microsecond, 1); 
				MicrosecondExtractDataTeam1MemberWriter.setWriterCreated(false);
				MicrosecondExtractDataTeam1MemberWriter.get_file_writer(microsecond, 1); 
				MicrosecondLoggerTeam1MemberWriter.setWriterCreated(false);
				MicrosecondLoggerTeam1MemberWriter.get_file_writer(microsecond, 1); 
				MicrosecondPrGraphTeam2MemberWriter.setWriterCreated(false);
				MicrosecondPrGraphTeam2MemberWriter.get_file_writer(microsecond, 1);
				MicrosecondPrFactsTeam2MemberWriter.setWriterCreated(false);
				MicrosecondPrFactsTeam2MemberWriter.get_file_writer(microsecond, 1);
				MicrosecondPrRulesTeam2MemberWriter.setWriterCreated(false);
				MicrosecondPrRulesTeam2MemberWriter.get_file_writer(microsecond, 1); 
				MicrosecondPrInterpretationsTeam2MemberWriter.setWriterCreated(false);
				MicrosecondPrInterpretationsTeam2MemberWriter.get_file_writer(microsecond, 1); 
				MicrosecondStaticLanguageTeam2MemberWriter.setWriterCreated(false);
				MicrosecondStaticLanguageTeam2MemberWriter.get_file_writer(microsecond, 1); 
				MicrosecondChangingLanguageTeam2MemberWriter.setWriterCreated(false);
				MicrosecondChangingLanguageTeam2MemberWriter.get_file_writer(microsecond, 1); 
				MicrosecondStaticGrammarTeam2MemberWriter.setWriterCreated(false);
				MicrosecondStaticGrammarTeam2MemberWriter.get_file_writer(microsecond, 1); 
				MicrosecondChangingGrammarTeam2MemberWriter.setWriterCreated(false);
				MicrosecondChangingGrammarTeam2MemberWriter.get_file_writer(microsecond, 1); 
				MicrosecondGenerationTeam2MemberWriter.setWriterCreated(false);
				MicrosecondGenerationTeam2MemberWriter.get_file_writer(microsecond, 1); 
				MicrosecondOrderingPlacementsTeam2MemberWriter.setWriterCreated(false);
				MicrosecondOrderingPlacementsTeam2MemberWriter.get_file_writer(microsecond, 1);
				MicrosecondCombineTeam2MemberWriter.setWriterCreated(false); 
				MicrosecondCombineTeam2MemberWriter.get_file_writer(microsecond, 1); 
				MicrosecondTeam2MemberSpellsWriter.setWriterCreated(false);
				MicrosecondTeam2MemberSpellsWriter.get_file_writer(microsecond, 1); 
				MicrosecondTacticalApproachTeam2MemberWriter.setWriterCreated(false); 
				MicrosecondTacticalApproachTeam2MemberWriter.get_file_writer(microsecond, 1); 
				MicrosecondSelectionTeam2MemberSpellsWriter.setWriterCreated(false);
				MicrosecondSelectionTeam2MemberSpellsWriter.get_file_writer(microsecond, 1);
				MicrosecondLeftOverTeam2MemberSpellsWriter.setWriterCreated(false);
				MicrosecondLeftOverTeam2MemberSpellsWriter.get_file_writer(microsecond, 1); 
				MicrosecondDiscardTeam2MemberSpellsWriter.setWriterCreated(false); 
				MicrosecondDiscardTeam2MemberSpellsWriter.get_file_writer(microsecond, 1); 
				MicrosecondGarbageCollectionTeam2MemberWriter.setWriterCreated(false); 
				MicrosecondGarbageCollectionTeam2MemberWriter.get_file_writer(microsecond, 1);
				MicrosecondLexicalAnalyzerTeam2MemberWriter.setWriterCreated(false);
				MicrosecondLexicalAnalyzerTeam2MemberWriter.get_file_writer(microsecond, 1); 
				MicrosecondDFATeam2MemberWriter.setWriterCreated(false);
				MicrosecondDFATeam2MemberWriter.get_file_writer(microsecond, 1);
				MicrosecondNFATeam2MemberWriter.setWriterCreated(false);
				MicrosecondNFATeam2MemberWriter.get_file_writer(microsecond, 1);
				MicrosecondRunTimeTeam2MemberWriter.setWriterCreated(false);
				MicrosecondRunTimeTeam2MemberWriter.get_file_writer(microsecond, 1); 
				MicrosecondReferencePointersTeam2MemberWriter.setWriterCreated(false);
				MicrosecondReferencePointersTeam2MemberWriter.get_file_writer(microsecond, 1); 
				MicrosecondOutputSpellsTeam2MemberWriter.setWriterCreated(false);
				MicrosecondOutputSpellsTeam2MemberWriter.get_file_writer(microsecond, 1); 
				MicrosecondPathTraceTeam2MemberWriter.setWriterCreated(false);
				MicrosecondPathTraceTeam2MemberWriter.get_file_writer(microsecond, 1);
				MicrosecondTraceToStartTeam2MemberWriter.setWriterCreated(false); 
				MicrosecondTraceToStartTeam2MemberWriter.get_file_writer(microsecond, 1); 
				MicrosecondSatisfierTeam2MemberWriter.setWriterCreated(false); 
				MicrosecondSatisfierTeam2MemberWriter.get_file_writer(microsecond, 1); 
				MicrosecondHistoryTeam2MemberWriter.setWriterCreated(false); 
				MicrosecondHistoryTeam2MemberWriter.get_file_writer(microsecond, 1); 
				MicrosecondIncorporationConceptTeam2MemberWriter.setWriterCreated(false); 
				MicrosecondIncorporationConceptTeam2MemberWriter.get_file_writer(microsecond, 1); 
				MicrosecondCheckPointTeam2MemberWriter.setWriterCreated(false);
				MicrosecondCheckPointTeam2MemberWriter.get_file_writer(microsecond, 1); 
				MicrosecondContributionalEstimateTeam2MemberWriter.setWriterCreated(false); 
				MicrosecondContributionalEstimateTeam2MemberWriter.get_file_writer(microsecond, 1); 
				MicrosecondAudienceTeam2MemberWriter.setWriterCreated(false); 
				MicrosecondAudienceTeam2MemberWriter.get_file_writer(microsecond, 1); 
				MicrosecondModeOfOperationsTeam2MemberWriter.setWriterCreated(false);
				MicrosecondModeOfOperationsTeam2MemberWriter.get_file_writer(microsecond, 1); 
				MicrosecondExtractDataTeam2MemberWriter.setWriterCreated(false);
				MicrosecondExtractDataTeam2MemberWriter.get_file_writer(microsecond, 1);
				MicrosecondLoggerTeam2MemberWriter.setWriterCreated(false); 
				MicrosecondLoggerTeam2MemberWriter.get_file_writer(microsecond, 1); 
			}
			else if(playerAssociationToSchool.size() == 4) {
				MicrosecondTeam1MemberSpellsWriter.setWriterCreated(false);
				MicrosecondTeam1MemberSpellsWriter.get_file_writer(microsecond, 1); 
				MicrosecondTeam1MemberSpellsWriter.setWriterCreated(false); 
				MicrosecondTeam1MemberSpellsWriter.get_file_writer(microsecond, 2); 
				MicrosecondTeam2MemberSpellsWriter.setWriterCreated(false); 
				MicrosecondTeam2MemberSpellsWriter.get_file_writer(microsecond, 1);
				MicrosecondTeam2MemberSpellsWriter.setWriterCreated(false); 
				MicrosecondTeam2MemberSpellsWriter.get_file_writer(microsecond, 2); 
			}
			else if(playerAssociationToSchool.size() == 6) {
				MicrosecondTeam1MemberSpellsWriter.setWriterCreated(false);
				MicrosecondTeam1MemberSpellsWriter.get_file_writer(microsecond, 1); 
				MicrosecondTeam1MemberSpellsWriter.setWriterCreated(false); 
				MicrosecondTeam1MemberSpellsWriter.get_file_writer(microsecond, 2); 
				MicrosecondTeam1MemberSpellsWriter.setWriterCreated(false); 
				MicrosecondTeam1MemberSpellsWriter.get_file_writer(microsecond, 3); 
				MicrosecondTeam2MemberSpellsWriter.setWriterCreated(false); 
				MicrosecondTeam2MemberSpellsWriter.get_file_writer(microsecond, 1); 
				MicrosecondTeam2MemberSpellsWriter.setWriterCreated(false); 
				MicrosecondTeam2MemberSpellsWriter.get_file_writer(microsecond, 2); 
				MicrosecondTeam2MemberSpellsWriter.setWriterCreated(false); 
				MicrosecondTeam2MemberSpellsWriter.get_file_writer(microsecond, 3); 
			}
			else if(playerAssociationToSchool.size() == 8) {
				MicrosecondTeam1MemberSpellsWriter.setWriterCreated(false);
				MicrosecondTeam1MemberSpellsWriter.get_file_writer(microsecond, 1); 
				MicrosecondTeam1MemberSpellsWriter.setWriterCreated(false); 
				MicrosecondTeam1MemberSpellsWriter.get_file_writer(microsecond, 2); 
				MicrosecondTeam1MemberSpellsWriter.setWriterCreated(false); 
				MicrosecondTeam1MemberSpellsWriter.get_file_writer(microsecond, 3); 
				MicrosecondTeam1MemberSpellsWriter.setWriterCreated(false); 
				MicrosecondTeam1MemberSpellsWriter.get_file_writer(microsecond, 4); 
				MicrosecondTeam2MemberSpellsWriter.setWriterCreated(false); 
				MicrosecondTeam2MemberSpellsWriter.get_file_writer(microsecond, 1); 
				MicrosecondTeam2MemberSpellsWriter.setWriterCreated(false); 
				MicrosecondTeam2MemberSpellsWriter.get_file_writer(microsecond, 2); 
				MicrosecondTeam2MemberSpellsWriter.setWriterCreated(false); 
				MicrosecondTeam2MemberSpellsWriter.get_file_writer(microsecond, 3); 
				MicrosecondTeam2MemberSpellsWriter.setWriterCreated(false); 
				MicrosecondTeam2MemberSpellsWriter.get_file_writer(microsecond, 4); 
			}
			System.out.println("Caught Stream Closed Exception"); 
			SecondCombineWriter.setWriterCreated(false); 
			secondCombineWriter = SecondCombineWriter.get_file_writer();
			MicrosecondByMicrosecondWriter.setWriterCreated(false);
			secondModuleByModuleWriter = MicrosecondByMicrosecondWriter.get_file_writer();
			SecondDiscardSpellsWriter.setWriterCreated(false);
			secondExcessSpellsWriter = SecondDiscardSpellsWriter.get_file_writer();
			SecondDiscardSpellsTeam1Writer.setWriterCreated(false); 
			secondExcessSpellsTeam1Writer = SecondDiscardSpellsTeam1Writer.get_file_writer();
			SecondDiscardSpellsTeam2Writer.setWriterCreated(false);
			secondExcessSpellsTeam2Writer = SecondDiscardSpellsTeam2Writer.get_file_writer();
			SecondLeftOverSpellsWriter.setWriterCreated(false); 
			secondRemainingSpellsWriter = SecondLeftOverSpellsWriter.get_file_writer();
			SecondLeftOverSpellsTeam1Writer.setWriterCreated(false); 
			secondRemainingSpellsTeam1Writer = SecondLeftOverSpellsTeam1Writer.get_file_writer();
			SecondLeftOverSpellsTeam2Writer.setWriterCreated(false); 
			secondRemainingSpellsTeam2Writer = SecondLeftOverSpellsTeam2Writer.get_file_writer();
			SecondSelectionWriter.setWriterCreated(false);
			secondSelectionLineWriter = SecondSelectionWriter.get_file_writer();
			ProductSelectionTeam1Writer.setWriterCreated(false); 
			secondSelectionLineTeam1Writer = ProductSelectionTeam1Writer.get_file_writer();
			SecondSelectionTeam2Writer.setWriterCreated(false);
			secondSelectionLineTeam2Writer = SecondSelectionTeam2Writer.get_file_writer();
			MicrosecondPrGraphWriter.setWriterCreated(false); 
			microsecondPrGraphWriter = MicrosecondPrGraphWriter.get_file_writer(microsecond);
			MicrosecondPrGraphTeam1Writer.setWriterCreated(false); 
			microsecondPrGraphTeam1Writer = MicrosecondPrGraphTeam1Writer.get_file_writer(microsecond); 
			MicrosecondPrGraphTeam2Writer.setWriterCreated(false);
			microsecondPrGraphTeam2Writer = MicrosecondPrGraphTeam2Writer.get_file_writer(microsecond); 
			MicrosecondPrFactsWriter.setWriterCreated(false); 
			microsecondPrFactsWriter = MicrosecondPrFactsWriter.get_file_writer(microsecond); 
			MicrosecondPrFactsTeam1Writer.setWriterCreated(false);
			microsecondPrFactsTeam1Writer = MicrosecondPrFactsTeam1Writer.get_file_writer(microsecond);
			MicrosecondPrFactsTeam2Writer.setWriterCreated(false); 
			microsecondPrFactsTeam2Writer = MicrosecondPrFactsTeam2Writer.get_file_writer(microsecond);
			MicrosecondPrRulesWriter.setWriterCreated(false); 
			microsecondPrRulesWriter = MicrosecondPrRulesWriter.get_file_writer(microsecond);
			MicrosecondPrRulesTeam1Writer.setWriterCreated(false); 
			microsecondPrRulesTeam1Writer = MicrosecondPrRulesTeam1Writer.get_file_writer(microsecond); 
			MicrosecondPrRulesTeam2Writer.setWriterCreated(false); 
			microsecondPrRulesTeam2Writer = MicrosecondPrRulesTeam2Writer.get_file_writer(microsecond); 
			MicrosecondPrInterpretationsWriter.setWriterCreated(false); 
			microsecondPrInterpretationsWriter = MicrosecondPrInterpretationsWriter.get_file_writer(microsecond); 
			MicrosecondPrInterpretationsTeam1Writer.get_file_writer(microsecond); 
			microsecondPrInterpretationsTeam1Writer = MicrosecondPrInterpretationsTeam1Writer.get_file_writer(microsecond);
			MicrosecondPrInterpretationsTeam2Writer.setWriterCreated(false);
			microsecondPrInterpretationsTeam2Writer = MicrosecondPrInterpretationsTeam2Writer.get_file_writer(microsecond); 
			MicrosecondStaticLanguageWriter.setWriterCreated(false); 
			microsecondStaticLanguageWriter = MicrosecondStaticLanguageWriter.get_file_writer(microsecond); 
			MicrosecondStaticLanguageTeam1Writer.setWriterCreated(false); 
			microsecondStaticLanguageTeam1Writer = MicrosecondStaticLanguageTeam1Writer.get_file_writer(microsecond);
			ModuleStaticLanguageTeam2Writer.setWriterCreated(false); 
			microsecondStaticLanguageTeam2Writer = ModuleStaticLanguageTeam2Writer.get_file_writer(microsecond);
			MicrosecondChangingLanguageWriter.setWriterCreated(false); 
			microsecondChangingLanguageWriter = MicrosecondChangingLanguageWriter.get_file_writer(microsecond);
			MicrosecondChangingLanguageTeam1Writer.setWriterCreated(false); 
			microsecondChangingLanguageTeam1Writer = MicrosecondChangingLanguageTeam1Writer.get_file_writer(microsecond); 
			MicrosecondChangingLanguageTeam2Writer.setWriterCreated(false); 
			microsecondChangingLanguageTeam2Writer = MicrosecondChangingLanguageTeam2Writer.get_file_writer(microsecond); 
			MicrosecondStaticGrammarWriter.setWriterCreated(false); 
			microsecondStaticGrammarWriter = MicrosecondStaticGrammarWriter.get_file_writer(microsecond); 
			MicrosecondStaticGrammarTeam1Writer.setWriterCreated(false); 
			microsecondStaticGrammarTeam1Writer = MicrosecondStaticGrammarTeam1Writer.get_file_writer(microsecond); 
			MicrosecondStaticGrammarTeam2Writer.setWriterCreated(false); 
			microsecondStaticGrammarTeam2Writer = MicrosecondStaticGrammarTeam2Writer.get_file_writer(microsecond); 
			MicrosecondChangingGrammarWriter.setWriterCreated(false); 
			microsecondChangingGrammarWriter = MicrosecondChangingGrammarWriter.get_file_writer(microsecond); 
			MicrosecondChangingGrammarTeam1Writer.setWriterCreated(false); 
			microsecondChangingGrammarTeam1Writer = MicrosecondChangingGrammarTeam1Writer.get_file_writer(microsecond); 
			MicrosecondChangingGrammarTeam2Writer.setWriterCreated(false); 
			microsecondChangingGrammarTeam2Writer = MicrosecondChangingGrammarTeam2Writer.get_file_writer(microsecond); 
			MicrosecondGenerationWriter.setWriterCreated(false); 
			microsecondGenerationWriter = MicrosecondGenerationWriter.get_file_writer(microsecond); 
			MicrosecondGenerationTeam1Writer.setWriterCreated(false); 
			microsecondGenerationTeam1Writer = MicrosecondGenerationTeam1Writer.get_file_writer(microsecond); 
			MicrosecondGenerationTeam2Writer.setWriterCreated(false); 
			microsecondGenerationTeam2Writer = MicrosecondGenerationTeam2Writer.get_file_writer(microsecond); 
			MicrosecondOrderingPlacementsWriter.setWriterCreated(false);
			microsecondOrderingPlacementsWriter = MicrosecondOrderingPlacementsWriter.get_file_writer(microsecond); 
			MicrosecondOrderingPlacementsTeam1Writer.setWriterCreated(false); 
			microsecondOrderingPlacementsTeam1Writer = MicrosecondOrderingPlacementsTeam1Writer.get_file_writer(microsecond); 
			MicrosecondOrderingPlacementsTeam2Writer.setWriterCreated(false); 
			microsecondOrderingPlacementsTeam2Writer = MicrosecondOrderingPlacementsTeam2Writer.get_file_writer(microsecond); 
			MicrosecondCombineWriter.setWriterCreated(false); 
			microsecondCombineWriter = MicrosecondCombineWriter.get_file_writer(microsecond); 
			MicrosecondTeam1SpellsWriter.setWriterCreated(false);
			microsecondTeam1SpellsWriter = MicrosecondTeam1SpellsWriter.get_file_writer(microsecond);
			MicrosecondTeam2SpellsWriter.setWriterCreated(false);
			microsecondTeam2SpellsWriter = MicrosecondTeam2SpellsWriter.get_file_writer(microsecond);
			MicrosecondTacticalApproachWriter.setWriterCreated(false); 
			microsecondTacticalApproachWriter = MicrosecondTacticalApproachWriter.get_file_writer(microsecond); 
			MicrosecondTacticalApproachTeam1Writer.setWriterCreated(false);
			microsecondTacticalApproachTeam1Writer = MicrosecondTacticalApproachTeam1Writer.get_file_writer(microsecond); 
			MicrosecondTacticalApproachTeam2Writer.setWriterCreated(false); 
			microsecondTacticalApproachTeam2Writer = MicrosecondTacticalApproachTeam2Writer.get_file_writer(microsecond); 
			MicrosecondOfSpellsWriter.setWriterCreated(false); 
			microsecondDefaultWriter = MicrosecondOfSpellsWriter.get_file_writer(microsecond); 
			MicrosecondSelectionWriter.setWriterCreated(false);
			microsecondSelectionLineWriter = MicrosecondSelectionWriter.get_file_writer(microsecond); 
			MicrosecondSelectionTeam1Writer.setWriterCreated(false);
			microsecondSelectionLineTeam1Writer = MicrosecondSelectionTeam1Writer.get_file_writer(microsecond); 
			MicrosecondSelectionTeam2Writer.setWriterCreated(false); 
			microsecondSelectionLineTeam2Writer = MicrosecondSelectionTeam2Writer.get_file_writer(microsecond); 
			MicrosecondLeftOverSpellsWriter.setWriterCreated(false); 
			microsecondRemainingSpellsWriter = MicrosecondLeftOverSpellsWriter.get_file_writer(microsecond); 
			MicrosecondLeftOverSpellsTeam1Writer.setWriterCreated(false); 
			microsecondRemainingTeam1SpellsWriter = MicrosecondLeftOverSpellsTeam1Writer.get_file_writer(microsecond); 
			MicrosecondLeftOverSpellsTeam2Writer.setWriterCreated(false); 
			microsecondRemainingTeam2SpellsWriter = MicrosecondLeftOverSpellsTeam2Writer.get_file_writer(microsecond); 
			MicrosecondDiscardSpellsWriter.setWriterCreated(false);
			microsecondExcessSpellsWriter = MicrosecondDiscardSpellsWriter.get_file_writer(microsecond);
			MicrosecondDiscardSpellsTeam1Writer.setWriterCreated(false); 
			microsecondExcessSpellsTeam1Writer = MicrosecondDiscardSpellsTeam1Writer.get_file_writer(microsecond); 
			MicrosecondDiscardSpellsTeam2Writer.setWriterCreated(false); 
			microsecondExcessSpellsTeam2Writer = MicrosecondDiscardSpellsTeam2Writer.get_file_writer(microsecond); 
			MicrosecondGarbageCollectionWriter.setWriterCreated(false); 
			microsecondGarbageCollectionWriter = MicrosecondGarbageCollectionWriter.get_file_writer(microsecond); 
			MicrosecondGarbageCollectionTeam1Writer.setWriterCreated(false); 
			microsecondGarbageCollectionTeam1Writer = MicrosecondGarbageCollectionTeam1Writer.get_file_writer(microsecond); 
			MicrosecondGarbageCollectionTeam2Writer.setWriterCreated(false); 
			microsecondGarbageCollectionTeam2Writer = MicrosecondGarbageCollectionTeam2Writer.get_file_writer(microsecond); 
			MicrosecondLexicalAnalyzerWriter.setWriterCreated(false); 
			microsecondLexicalAnalyzerWriter = MicrosecondLexicalAnalyzerWriter.get_file_writer(microsecond); 
			MicrosecondLexicalAnalyzerTeam1Writer.setWriterCreated(false); 
			microsecondLexicalAnalyzerTeam1Writer = MicrosecondLexicalAnalyzerTeam1Writer.get_file_writer(microsecond); 
			MicrosecondLexicalAnalyzerTeam2Writer.setWriterCreated(false);
			microsecondLexicalAnalyzerTeam2Writer = MicrosecondLexicalAnalyzerTeam2Writer.get_file_writer(microsecond); 
			MicrosecondDFAWriter.setWriterCreated(false); 
			microsecondDFAWriter = MicrosecondDFAWriter.get_file_writer(microsecond); 
			MicrosecondDFATeam1Writer.setWriterCreated(false); 
			microsecondDFATeam1Writer = MicrosecondDFATeam1Writer.get_file_writer(microsecond); 
			MicrosecondDFATeam2Writer.setWriterCreated(false); 
			microsecondDFATeam2Writer = MicrosecondDFATeam2Writer.get_file_writer(microsecond); 
			MicrosecondNFAWriter.setWriterCreated(false); 
			microsecondNFAWriter = MicrosecondNFAWriter.get_file_writer(microsecond); 
			MicrosecondNFATeam1Writer.setWriterCreated(false); 
			microsecondNFATeam1Writer = MicrosecondNFATeam1Writer.get_file_writer(microsecond); 
			MicrosecondNFATeam2Writer.setWriterCreated(false); 
			microsecondNFATeam2Writer = MicrosecondNFATeam2Writer.get_file_writer(microsecond); 
			MicrosecondRunTimeWriter.setWriterCreated(false); 
			microsecondRunTimeWriter = MicrosecondRunTimeWriter.get_file_writer(microsecond); 
			MicrosecondRunTimeTeam1Writer.setWriterCreated(false);
			microsecondRunTimeTeam1Writer = MicrosecondRunTimeTeam1Writer.get_file_writer(microsecond); 
			MicrosecondRunTimeTeam2Writer.setWriterCreated(false); 
			microsecondRunTimeTeam2Writer = MicrosecondRunTimeTeam2Writer.get_file_writer(microsecond); 
			MicrosecondReferencePointersWriter.setWriterCreated(false); 
			microsecondReferencePointersWriter = MicrosecondReferencePointersWriter.get_file_writer(microsecond); 
			MicrosecondReferencePointersTeam1Writer.setWriterCreated(false); 
			microsecondReferencePointersTeam1Writer = MicrosecondReferencePointersTeam1Writer.get_file_writer(microsecond); 
			MicrosecondOutputSpellsWriter.setWriterCreated(false); 
			microsecondComputationSpellsWriter = MicrosecondOutputSpellsWriter.get_file_writer(microsecond); 
			MicrosecondOutputSpellsTeam1Writer.setWriterCreated(false);
			microsecondComputationSpellsTeam1Writer = MicrosecondOutputSpellsTeam1Writer.get_file_writer(microsecond); 
			MicrosecondOutputSpellsTeam2Writer.setWriterCreated(false); 
			microsecondComputationSpellsTeam2Writer = MicrosecondOutputSpellsTeam2Writer.get_file_writer(microsecond); 
			MicrosecondPathTraceWriter.setWriterCreated(false); 
			microsecondPathTraceWriter = MicrosecondPathTraceWriter.get_file_writer(microsecond); 
			MicrosecondPathTraceTeam1Writer.setWriterCreated(false); 
			microsecondPathTraceTeam1Writer = MicrosecondPathTraceTeam1Writer.get_file_writer(microsecond); 
			MicrosecondPathTraceTeam2Writer.setWriterCreated(false); 
			microsecondPathTraceTeam2Writer = MicrosecondPathTraceTeam2Writer.get_file_writer(microsecond); 
			MicrosecondTraceToStartWriter.setWriterCreated(false); 
			microsecondTraceToStartWriter = MicrosecondTraceToStartWriter.get_file_writer(microsecond); 
			MicrosecondTraceToStartTeam1Writer.setWriterCreated(false); 
			microsecondTraceToStartTeam1Writer = MicrosecondTraceToStartTeam1Writer.get_file_writer(microsecond); 
			MicrosecondTraceToStartTeam2Writer.setWriterCreated(false); 
			microsecondTraceToStartTeam2Writer = MicrosecondTraceToStartTeam2Writer.get_file_writer(microsecond); 
			MicrosecondSatisfierWriter.setWriterCreated(false); 
			microsecondSatisfierWriter = MicrosecondSatisfierWriter.get_file_writer(microsecond); 
			MicrosecondSatisfierTeam1Writer.setWriterCreated(false); 
			microsecondSatisfierTeam1Writer = MicrosecondSatisfierTeam1Writer.get_file_writer(microsecond); 
			MicrosecondSatisfierTeam2Writer.setWriterCreated(false); 
			microsecondSatisfierTeam2Writer = MicrosecondSatisfierTeam2Writer.get_file_writer(microsecond); 
			MicrosecondHistoryWriter.setWriterCreated(false); 
			microsecondHistoryWriter = MicrosecondHistoryWriter.get_file_writer(microsecond); 
			MicrosecondHistoryTeam1Writer.setWriterCreated(false); 
			microsecondHistoryTeam1Writer = MicrosecondHistoryTeam1Writer.get_file_writer(microsecond); 
			MicrosecondHistoryTeam2Writer.setWriterCreated(false); 
			microsecondHistoryTeam2Writer = MicrosecondHistoryTeam2Writer.get_file_writer(microsecond); 
			MicrosecondIncorporationConceptWriter.setWriterCreated(false); 
			microsecondIncorporationConceptWriter = MicrosecondIncorporationConceptWriter.get_file_writer(microsecond); 
			MicrosecondIncorporationConceptTeam1Writer.setWriterCreated(false);
			microsecondIncorporationConceptTeam1Writer = MicrosecondIncorporationConceptTeam1Writer.get_file_writer(microsecond); 
			MicrosecondIncorporationConceptTeam2Writer.setWriterCreated(false); 
			microsecondIncorporationConceptTeam2Writer = MicrosecondIncorporationConceptTeam2Writer.get_file_writer(microsecond); 
			MicrosecondCheckPointWriter.setWriterCreated(false); 
			microsecondCheckPointWriter = MicrosecondCheckPointWriter.get_file_writer(microsecond); 
			MicrosecondCheckPointTeam1Writer.setWriterCreated(false); 
			microsecondCheckPointTeam1Writer = MicrosecondCheckPointTeam1Writer.get_file_writer(microsecond); 
			MicrosecondCheckPointTeam2Writer.setWriterCreated(false); 
			microsecondCheckPointTeam2Writer = MicrosecondCheckPointTeam2Writer.get_file_writer(microsecond);
			MicrosecondContributionalEstimateWriter.setWriterCreated(false); 
			microsecondContributionalEstimateWriter = MicrosecondContributionalEstimateWriter.get_file_writer(microsecond); 
			MicrosecondContributionalEstimateTeam1Writer.setWriterCreated(false); 
			microsecondContributionalEstimateTeam1Writer = MicrosecondContributionalEstimateTeam1Writer.get_file_writer(microsecond); 
			MicrosecondContributionalEstimateTeam2Writer.setWriterCreated(false); 
			microsecondContributionalEstimateTeam2Writer = MicrosecondContributionalEstimateTeam2Writer.get_file_writer(microsecond); 
			MicrosecondAudienceWriter.setWriterCreated(false); 
			microsecondAudienceWriter = MicrosecondAudienceWriter.get_file_writer(microsecond); 
			MicrosecondAudienceTeam1Writer.setWriterCreated(false); 
			microsecondAudienceTeam1Writer = MicrosecondAudienceTeam1Writer.get_file_writer(microsecond); 
			MicrosecondAudienceTeam2Writer.setWriterCreated(false); 
			microsecondAudienceTeam2Writer = MicrosecondAudienceTeam2Writer.get_file_writer(microsecond); 
			MicrosecondModeOfOperationsWriter.setWriterCreated(false); 
			microsecondModeOfOperationsWriter = MicrosecondModeOfOperationsWriter.get_file_writer(microsecond); 
			MicrosecondModeOfOperationsTeam1Writer.setWriterCreated(false); 
			microsecondModeOfOperationsTeam1Writer = MicrosecondModeOfOperationsTeam1Writer.get_file_writer(microsecond); 
			MicrosecondModeOfOperationsTeam2Writer.setWriterCreated(false); 
			microsecondModeOfOperationsTeam2Writer = MicrosecondModeOfOperationsTeam2Writer.get_file_writer(microsecond); 
			MicrosecondExtractDataWriter.setWriterCreated(false); 
			microsecondExtractDataWriter = MicrosecondExtractDataWriter.get_file_writer(microsecond); 
			MicrosecondExtractDataTeam1Writer.setWriterCreated(false); 
			microsecondExtractDataTeam1Writer = MicrosecondExtractDataTeam1Writer.get_file_writer(microsecond); 
			MicrosecondExtractDataTeam2Writer.setWriterCreated(false); 
			microsecondExtractDataTeam2Writer = MicrosecondExtractDataTeam2Writer.get_file_writer(microsecond); 
			MicrosecondLoggerWriter.setWriterCreated(false); 
			microsecondLoggerWriter = MicrosecondLoggerWriter.get_file_writer(microsecond); 
			MicrosecondLoggerTeam1Writer.setWriterCreated(false); 
			microsecondLoggerTeam1Writer = MicrosecondLoggerTeam1Writer.get_file_writer(microsecond); 
			MicrosecondLoggerTeam2Writer.setWriterCreated(false); 
			microsecondLoggerTeam2Writer = MicrosecondLoggerTeam2Writer.get_file_writer(microsecond); 
		}
		// Blade, Blade, Blade, Trap 
		// Trap, Trap, Trap, Empower
		System.out.println("This is a microsecond casted of our match between team 1 and team 2"); 
		System.out.println("Team Players Size inclusive of both team 1 and team 2: " + teamPlayers.size()); 
		secondDataPersistor.write("MICROSECOND " + microsecond + "\n"); 
		secondDataPersistor.write("------------------------\n");
		secondDataPersistor.write("INTERNAL AND EXTERNAL METRICS OF MEASURE\n"); 
		secondDataPersistor.write("Metric Bactrack\n"); 
		secondDataPersistor.write("Metric Description\n"); 
		secondDataPersistor.write("Metric DFA\n"); 
		secondDataPersistor.write("Metric Discarder\n"); 
		secondDataPersistor.write("Metric Documentation\n"); 
		secondDataPersistor.write("Metric Duration\n"); 
		secondDataPersistor.write("Metric Dynamic_Grammar\n");
		secondDataPersistor.write("Metric Dynamic_Language\n");
		secondDataPersistor.write("Metric Engagement\n");
		secondDataPersistor.write("Metric Executable\n");
		secondDataPersistor.write("Metric File_Count\n");
		secondDataPersistor.write("Metric Fixed_Grammar\n");
		secondDataPersistor.write("Metric Fixed_Language\n"); 
		secondDataPersistor.write("Metric Garbage_Collector\n"); 
		secondDataPersistor.write("Metric Generator\n"); 
		secondDataPersistor.write("Metric Hierarchy\n"); 
		secondDataPersistor.write("Metric Incorporation_Concept\n"); 
		secondDataPersistor.write("Metric Induce\n"); 
		secondDataPersistor.write("Metric Interpretation_List\n"); 
		secondDataPersistor.write("Metric Interpreter\n"); 
		secondDataPersistor.write("Metric Jargon\n"); 
		secondDataPersistor.write("Metric Logger\n"); 
		secondDataPersistor.write("Metric Merge_Finalizer\n"); 
		secondDataPersistor.write("Metric NFA\n"); 
		secondDataPersistor.write("Metric Parser\n"); 
		secondDataPersistor.write("Metric Permutations\n"); 
		secondDataPersistor.write("Metric Process\n"); 
		secondDataPersistor.write("Metric pyreason_facts\n"); 
		secondDataPersistor.write("Metric pyreason_graph\n"); 
		secondDataPersistor.write("Metric pyreason_interpretations\n"); 
		secondDataPersistor.write("Metric pyreason_rules\n"); 
		secondDataPersistor.write("Metric recorder\n"); 
		secondDataPersistor.write("Metric relevance\n"); 
		secondDataPersistor.write("Metric remaining\n");
		secondDataPersistor.write("Metric rule_list\n"); 
		secondDataPersistor.write("Metric selection\n"); 
		secondDataPersistor.write("Metric simulation\n"); 
		secondDataPersistor.write("Metric singleton\n"); 
		secondDataPersistor.write("Metric solution\n"); 
		secondDataPersistor.write("Metric state\n"); 
		secondDataPersistor.write("Metric statistics\n"); 
		secondDataPersistor.write("Metric strategy\n"); 
		secondDataPersistor.write("Metric timestamp\n"); 
		secondDataPersistor.write("Metric transducer\n"); 
		secondDataPersistor.write("------------------------\n"); 
		secondModuleByModuleWriter.write("\n"); 
		secondModuleByModuleWriter.write("ROUND # " + microsecond + " OF SPELLS" + "\n");
		productWriterFinalizer.write("ROUND # " + microsecond + " OF SPELLS" + "\n"); 
		microsecondDefaultWriter.write("\n"); 
		microsecondDefaultWriter.write("ROUND # " + microsecond + " OF SPELLS" + "\n"); 
		microsecondCombineWriter.write("ROUND # " + microsecond + " OF SPELLS" + "\n");
		microsecondComputationSpellsWriter.write("ROUND # " + microsecond + " COMPUTATION " + "\n"); 
		microsecondComputationSpellsWriter.write("________________________________________\n"); 
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
			secondModuleByModuleWriter.write("AGENT-" + player + "-UNITS SELECTION\n"); 
			productWriterFinalizer.write("AGENT-" + player + "-UNITS SELECTION\n"); 
			microsecondDefaultWriter.write("AGENT-" + player + "-UNITS SELECTION\n");	
			microsecondCombineWriter.write("AGENT-" + player + "-UNITS SELECTION\n"); 
			System.out.println("The following seven manuals have been generated."); 
			Element[] sevenCards = generateSevenCards(playerAssociationToSchool.get(player).toLowerCase(), index); 
			System.out.println("Printing out the seven manuals.");
			for(int z = 0; z < sevenCards.length; z++)
			{
				secondModuleByModuleWriter.write("----------------------------\n");
				productWriterFinalizer.write("----------------------------\n"); 
				microsecondDefaultWriter.write("----------------------------\n"); 
				microsecondCombineWriter.write("----------------------------\n");
				System.out.println("Manual " + (z+1) + ": " + "{ "); 
				secondModuleByModuleWriter.write("Manual " + (z+1) + ": " + "{\n "); 
				productWriterFinalizer.write("Manual " + (z+1) + ": " + "{\n "); 
				microsecondDefaultWriter.write("Manual " + (z+1) + ": " + "{\n ");
				microsecondCombineWriter.write("Manual " + (z+1) + ": " + "{\n ");
				System.out.println("Unit Tag: " + sevenCards[z].getSpellName()); 
				secondModuleByModuleWriter.write("Unit Tag: " + sevenCards[z].getSpellName() + "\n"); 
				productWriterFinalizer.write("Unit Tag: " + sevenCards[z].getSpellName() + "\n"); 
			 	microsecondDefaultWriter.write("Unit Tag: " + sevenCards[z].getSpellName() + "\n");
				microsecondCombineWriter.write("Unit Tag: " + sevenCards[z].getSpellName() + "\n"); 
				System.out.println("Unit Assembly # Of Steps: " + sevenCards[z].getPips()); 
				secondModuleByModuleWriter.write("Unit Assembly # Of Steps: " + sevenCards[z].getPips() + "\n"); 
				productWriterFinalizer.write("Unit Assembly # Of Steps: " + sevenCards[z].getPips() + "\n"); 
				microsecondDefaultWriter.write("Unit Assembly # Of Steps: " + sevenCards[z].getPips() + "\n");
				microsecondCombineWriter.write("Unit Assembly # Of Steps: " + sevenCards[z].getPips() + "\n"); 
				System.out.println("Unit Success Build Rate: " + sevenCards[z].getPipChance()); 
				secondModuleByModuleWriter.write("Unit Success Build Rate: " + sevenCards[z].getPipChance() + "\n"); 
				productWriterFinalizer.write("Unit Success Build Rate: " + sevenCards[z].getPipChance() + "\n"); 
				microsecondDefaultWriter.write("Unit Success Build Rate: " + sevenCards[z].getPipChance() + "\n");
				microsecondCombineWriter.write("Unit Success Build Rate: " + sevenCards[z].getPipChance() + "\n"); 
				System.out.println("Unit Industry Type: " + sevenCards[z].getTypeSpell()); 
				secondModuleByModuleWriter.write("Unit Industry Type: " + sevenCards[z].getTypeSpell() + "\n"); 
				productWriterFinalizer.write("Unit Industry Type: " + sevenCards[z].getTypeSpell() + "\n"); 
				microsecondDefaultWriter.write("Unit Industry Type: " + sevenCards[z].getTypeSpell() + "\n"); 
				microsecondCombineWriter.write("Unit Industry Type: " + sevenCards[z].getTypeSpell() + "\n"); 
				Type_Spell.startToFinish(sevenCards[z].getTypeSpell());
				microsecondComputationSpellsWriter.write("MANUAL GUIDE: " + Type_Spell.configureInUseToEnd[0] + " OUT OF " + Type_Spell.configureInUseToEnd[1] + " " + sevenCards[z].getTypeSpell().toUpperCase() + " UNITS\n");
				System.out.println("Unit Supply Count: " + sevenCards[z].getCount()); 
				secondModuleByModuleWriter.write("Unit Supply Count: " + sevenCards[z].getCount() + "\n"); 
				productWriterFinalizer.write("Unit Supply Count: " + sevenCards[z].getCount() + "\n"); 
				microsecondDefaultWriter.write("Unit Supply Count: " + sevenCards[z].getCount() + "\n");
				microsecondCombineWriter.write("Unit Supply Count: " + sevenCards[z].getCount() + "\n"); 
				System.out.println("Unit Information: " + sevenCards[z].getDescription()); 
				secondModuleByModuleWriter.write("Unit Information: " + sevenCards[z].getDescription() + "\n"); 
				productWriterFinalizer.write("Unit Information: " + sevenCards[z].getDescription() + "\n");
				microsecondDefaultWriter.write("Unit Information: " + sevenCards[z].getDescription() + "\n"); 
				microsecondCombineWriter.write("Unit Information: " + sevenCards[z].getDescription() + "\n"); 
				System.out.println("}");
				secondModuleByModuleWriter.write("}\n"); 
				productWriterFinalizer.write("}\n"); 
				microsecondDefaultWriter.write("}\n"); 
				microsecondCombineWriter.write("}\n"); 
				System.out.println("Unit added to the Productwriter."); 
			}
			secondModuleByModuleWriter.write("----------------------------\n");
			productWriterFinalizer.write("----------------------------\n"); 
			microsecondDefaultWriter.write("----------------------------\n"); 
			microsecondCombineWriter.write("----------------------------\n");
			
		}
		secondModuleByModuleWriter.write("END OF MODULE\n");
		productWriterFinalizer.write("END OF MODULE\n"); 
		productWriterFinalizer.write("############################\n"); 
		microsecondDefaultWriter.write("END OF MODULE\n"); 
		microsecondCombineWriter.write("END OF MODULE\n"); 
		microsecondComputationSpellsWriter.write("________________________________________\n"); 
		microsecondComputationSpellsWriter.write("END OF COMPUTATION\n"); 
		microsecondComputationSpellsWriter.close(); 
		System.out.println("Reading microsecond of units using reader. Decide between reading system 1 or system 2 first."); 

		secondModuleByModuleWriter.close(); 
		microsecondDefaultWriter.close(); 
		BufferedReader microsecondComputeReader = null;
		try {
			microsecondComputeReader = new BufferedReader(MicrosecondOfSpellsReader.get_file_reader()); 
			microsecondComputeReader.readLine(); 
		} catch (Exception e) {
			MicrosecondOfSpellsReader.setReaderCreated(false); 
			microsecondComputeReader = new BufferedReader(MicrosecondOfSpellsReader.get_file_reader()); 
		}
		microsecondTeam1SpellsWriter.write("\n"); 
		microsecondTeam2SpellsWriter.write("\n"); 
		String line; 
		boolean readFirstTeam = false; 
		boolean readSecondTeam = false; 
		String selectionStmtLine_t1 = null;
		String discardStmtLine_t1 = null;
		String remainingStmtLine_t1 = null;
		String selectionStmtLine_t2 = null;
		String discardStmtLine_t2 = null;
		String remainingStmtLine_t2 = null;
		while((line = microsecondComputeReader.readLine()) != null) { 
			if(line.contains("(SYSTEM 1)")) {
				System.out.println("CONTAINS SYSTEM 1"); 
				readFirstTeam = true; 
				readSecondTeam = false; 
				
				line = line.replace("UNITS SELECTION", "UNIT SELECTED"); 
				microsecondSelectionLineWriter.write(line + "\n"); 
				microsecondSelectionLineTeam1Writer.write(line + "\n"); 
				//roundCombineWriter.write(line + "\n"); 
				selectionStmtLine_t1 = line;
				String discardLine = line; 
				discardLine = discardLine.replace("UNIT SELECTED", "UNITS DISCARDED"); 
				microsecondExcessSpellsWriter.write(discardLine + "\n"); 
				microsecondExcessSpellsTeam1Writer.write(discardLine + "\n"); 
				discardStmtLine_t1 = discardLine;
				//roundCombineWriter.write(discardLine + "\n"); 
				String remainingLine = line; 
				remainingLine = remainingLine.replace("UNIT SELECTED", "UNITS REMAINING"); 
				microsecondRemainingSpellsWriter.write(remainingLine + "\n"); 
				microsecondRemainingTeam1SpellsWriter.write(remainingLine + "\n"); 
				microsecondRemainingTeam2SpellsWriter.write(remainingLine + "\n"); 
				remainingStmtLine_t1 = remainingLine;
				//roundCombineWriter.write(remainingLine + "\n"); 
			}
			if(line.contains("(SYSTEM 2)")) {
				readSecondTeam = true; 
				readFirstTeam = false;
				line = line.replace("UNITS SELECTION", "UNIT SELECTED");
				microsecondSelectionLineWriter.write(line + "\n"); 
				microsecondSelectionLineTeam2Writer.write(line + "\n");  
				selectionStmtLine_t2 = line;
				//roundCombineWriter.write(line + "\n"); 
				String discardLine = line; 
				discardLine = discardLine.replace("UNIT SELECTED", "UNIT DISCARDED"); 
				microsecondExcessSpellsWriter.write(discardLine + "\n"); 
				microsecondExcessSpellsTeam2Writer.write(discardLine + "\n"); 
				discardStmtLine_t2 = discardLine;
				//roundCombineWriter.write(discardLine + "\n"); 
				String remainingLine = line; 
				remainingLine = remainingLine.replace("UNIT SELECTED", "UNIT REMAINING"); 
				microsecondRemainingSpellsWriter.write(remainingLine + "\n"); 
				microsecondRemainingTeam1SpellsWriter.write(remainingLine + "\n"); 
				microsecondRemainingTeam2SpellsWriter.write(remainingLine + "\n"); 
				remainingStmtLine_t2 = remainingLine;
				//roundCombineWriter.write(remainingLine + "\n"); 
			}
			if(readFirstTeam == true) {
				System.out.println("WRITING LINE: " + line + " FOR TEAM 1"); 
				microsecondTeam1SpellsWriter.write(line + "\n"); 
				System.out.println("Extracting member_no information"); 
				if(line.contains("BOT")) {
					int memberCharLoc = line.indexOf("B");
					int stringNoLoc = line.indexOf(" ", memberCharLoc) + 1; 
					int memberNoLoc = Integer.parseInt(line.substring(stringNoLoc, stringNoLoc+1)); 
					System.out.println("memberNoLoc index: " + memberNoLoc); 
					MicrosecondTeam1MemberSpellsWriter.file_writers[memberNoLoc-1].write(line + "\n"); 
				}
			}
			if(readSecondTeam == true) {
				System.out.println("WRITING LINE: " + line + " FOR TEAM 2");
				microsecondTeam2SpellsWriter.write(line + "\n"); 
				System.out.println("Extracting member_no information"); 
				if(line.contains("BOT")) {
					int memberCharLoc = line.indexOf("B"); 
					int stringNoLoc = line.indexOf(" ", memberCharLoc) + 1; 
					int memberNoLoc = Integer.parseInt(line.substring(stringNoLoc, stringNoLoc+1)); 
					System.out.println("memberNoLoc index: " + memberNoLoc); 
 					MicrosecondTeam2MemberSpellsWriter.file_writers[memberNoLoc-1].write(line + "\n");
				}
			}
		}
		microsecondTeam1SpellsWriter.close(); 
		try {
			MicrosecondTeam1MemberSpellsWriter.file_writers[0].close(); 
			MicrosecondTeam1MemberSpellsWriter.file_writers[1].close(); 
			MicrosecondTeam1MemberSpellsWriter.file_writers[2].close(); 
			MicrosecondTeam1MemberSpellsWriter.file_writers[3].close(); 
		} catch (Exception e) {
			System.out.println("A member writer for team 1 failed to close"); ; 
		}
		microsecondTeam2SpellsWriter.close();  
		try {
			MicrosecondTeam2MemberSpellsWriter.file_writers[0].close(); 
			MicrosecondTeam2MemberSpellsWriter.file_writers[1].close(); 
			MicrosecondTeam2MemberSpellsWriter.file_writers[2].close(); 
			MicrosecondTeam2MemberSpellsWriter.file_writers[3].close(); 
		} catch (Exception e) {
			System.out.println("A member writer for team 2 failed to close"); 
		}
		System.out.println("Creating two readers for selection_line of team 1 and team 2 microsecond of spells."); 
		BufferedReader readerTeam1Compute = null;
		BufferedReader readerTeam2Compute = null;
		try {
			readerTeam1Compute = new BufferedReader(MicrosecondSelectionReader.get_file_reader("t1", microsecond)); 
			readerTeam1Compute.readLine(); 
			System.out.println("Line Read By Team 1 Reader: " + line); 
			readerTeam2Compute = new BufferedReader(MicrosecondSelectionReader.get_file_reader("t2", microsecond)); 
			readerTeam2Compute.readLine(); 
			System.out.println("Line Read By Team 2 Reader: " + line); 
		} catch (Exception e) {
			MicrosecondSelectionReader.setReaderCreated(false);
			readerTeam1Compute = new BufferedReader(MicrosecondSelectionReader.get_file_reader("t1", microsecond)); 
			MicrosecondSelectionReader.setReaderCreated(false); 
			readerTeam2Compute = new BufferedReader(MicrosecondSelectionReader.get_file_reader("t2", microsecond)); 
		}
		new FileOperation(readerTeam1Compute, microsecondSelectionLineTeam1Writer, microsecondExcessSpellsTeam1Writer, microsecondRemainingTeam1SpellsWriter, microsecondCombineWriter, new FileReader(Second.initialFile), "t1", microsecond, selectionStmtLine_t1, discardStmtLine_t1, remainingStmtLine_t1, size).run(); 
		//Thread.sleep(30000);
		new FileOperation(readerTeam2Compute, microsecondSelectionLineTeam2Writer, microsecondExcessSpellsTeam2Writer, microsecondRemainingTeam2SpellsWriter, microsecondCombineWriter, new FileReader(Second.initialFile), "t2", microsecond, selectionStmtLine_t2, discardStmtLine_t2, remainingStmtLine_t2, size).run(); 
		//Thread.sleep(30000); 
		microsecondComputeReader.close(); 
		readerTeam1Compute.close(); 
		readerTeam2Compute.close(); 
		microsecondSelectionLineWriter.close();
		microsecondSelectionLineTeam1Writer.close(); 
		microsecondSelectionLineTeam2Writer.close(); 
		microsecondExcessSpellsWriter.close(); 
		microsecondExcessSpellsTeam1Writer.close(); 
		microsecondExcessSpellsTeam2Writer.close(); 
		microsecondRemainingSpellsWriter.close(); 
		microsecondRemainingTeam1SpellsWriter.close(); 
		microsecondRemainingTeam2SpellsWriter.close(); 
		microsecondCombineWriter.close(); 
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