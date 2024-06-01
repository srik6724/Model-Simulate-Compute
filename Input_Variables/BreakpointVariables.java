package Input_Variables;

public class BreakpointVariables {
  // Creating boolean variables for each break-point
  private static boolean gameModeSelection = false; 
  private static boolean nameOfTeam = false; 
  private static boolean playerNames = false; 
  private static boolean playerLevels = false; 
  private static boolean playerSchools = false; 
  private static boolean playerDecks = false; 
  private static boolean playerStats = false; 
  private static boolean playerOrder = false; 
  private static boolean arenaSelection = false; 
  private static boolean matchCountDown = false; 
  private static boolean matchBegins = false; 
  private static boolean bothTeamsRegistered = false; 

  // So with these breakpoints, we want to be able to skip certain breakpoints that have executed already.
  // Not only that, the data from each breakpoint transition to another breakpoint transition should 
  // be saved ideally. 

  // Creating getter methods

  public static boolean getGameModeSelection() {
    return BreakpointVariables.gameModeSelection;
  }

  public static boolean getNameOfTeam() {
    return BreakpointVariables.nameOfTeam;
  }

  public static boolean getPlayerNames() {
    return BreakpointVariables.playerNames; 
  }

  public static boolean getPlayerLevels() {
    return BreakpointVariables.playerLevels; 
  }

  public static boolean getPlayerSchools() {
    return BreakpointVariables.playerSchools;
  }

  public static boolean getPlayerDecks() {
    return BreakpointVariables.playerDecks;
  }

  public static boolean getPlayerStats() {
    return BreakpointVariables.playerStats;
  }

  public static boolean getPlayerOrder() {
    return BreakpointVariables.playerOrder; 
  }

  public static boolean getArenaSelection() {
    return BreakpointVariables.arenaSelection;
  }

  public static boolean getMatchCountDown() {
    return BreakpointVariables.matchCountDown;
  }

  public static boolean getMatchBegins() {
    return BreakpointVariables.matchBegins;
  }

  public static boolean getBothTeamsRegistered() {
    return BreakpointVariables.bothTeamsRegistered;
  }

  // Creating setting methods
  public static void setGameModeSelection(boolean value) {
    BreakpointVariables.gameModeSelection = value; 
  }

  public static void setNameOfTeam(boolean value) {
    BreakpointVariables.nameOfTeam = value;
  }

  public static void setPlayerNames(boolean value) {
    BreakpointVariables.playerNames = value; 
  }

  public static void setPlayerLevels(boolean value) {
    BreakpointVariables.playerLevels = value;
  }

  public static void setPlayerSchools(boolean value) {
    BreakpointVariables.playerSchools = value; 
  }

  public static void setPlayerDecks(boolean value) {
    BreakpointVariables.playerDecks = value; 
  }

  public static void setPlayerStats(boolean value) {
    BreakpointVariables.playerDecks = value; 
  }

  public static void setPlayerOrder(boolean value) {
    BreakpointVariables.playerDecks = value; 
  }

  public static void setArenaSelection(boolean value) {
    BreakpointVariables.playerDecks = value; 
  }

  public static void setMatchCountDown(boolean value) {
    BreakpointVariables.matchCountDown = value; 
  }

  public static void setMatchBegins(boolean value) {
    BreakpointVariables.matchBegins = value; 
  }

  public static void setBothTeamsRegistered(boolean value) {
    BreakpointVariables.bothTeamsRegistered = value; 
  }

}
