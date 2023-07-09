package AeonStats;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import Credentials.WizCredentials;
import Gear.Deck;
import Gear.StatsInfo;
import Sockets.Socket;

public class AeonDeckStats extends Deck implements StatsInfo {
  private int max_spells; 
  private int max_copies; 
  private int max_schoolCopies; 
  private int sideboard; 
  private int health; 
  private int block; 
  private int critical; 
  private int pip_conversion; 
  private String school; 
  private String pip_gain; 
  private int archmastery_rating; 
  private Socket socket1;
  private Connection conn1; 

  public AeonDeckStats(String name)
  {
    super(name);
    try
    {
      String db_url = WizCredentials.getDB_URL(); 
      String user = WizCredentials.getDB_USERNAME(); 
      String password = WizCredentials.getDB_PASSWORD(); 

      if(WizCredentials.authenticate(user, password))
      {
        System.out.println("Authentication successful"); 
      }
      else 
      {
        System.out.println("Authentication failed"); 
      }

      conn1 = DriverManager.getConnection(db_url, user, password);

      if(conn1 != null)
      {
        String sql = "SELECT max_spells, max_copies, max_schoolCopies, sideboard, health, block, critical, pip_conversion, school, pip_gain, archmastery_rating, socket1 FROM wizard_schema.aeon_decks WHERE name = ?"; 
        PreparedStatement stmt = conn1.prepareStatement(sql); 
        System.out.println(name); 
        stmt.setString(1, name);
        ResultSet rs = stmt.executeQuery(); 

        while(rs.next())
        {
          max_spells = Integer.parseInt(rs.getString("max_spells")); 
          max_copies = Integer.parseInt(rs.getString("max_copies")); 
          max_schoolCopies = Integer.parseInt(rs.getString("max_schoolCopies")); 
          sideboard = Integer.parseInt(rs.getString("sideboard")); 
          health = Integer.parseInt(rs.getString("health")); 
          block = Integer.parseInt(rs.getString("block")); 
          critical = Integer.parseInt(rs.getString("critical")); 
          pip_conversion = Integer.parseInt(rs.getString("pip_conversion")); 
          school = rs.getString("school"); 
          pip_gain = rs.getString("pip_gain");  
          archmastery_rating  = Integer.parseInt(rs.getString("archmastery_rating")); 
          socket1 = new Socket(rs.getString("socket1"), "triangle", school);
        }
        AeonDeckStats createObj = new AeonDeckStats(name, max_spells, max_copies, max_schoolCopies, sideboard, health, block, critical, pip_conversion, school, pip_gain, archmastery_rating, socket1); 
        createObj.createSocketAttachment(socket1); 
        createObj.statsInformation();
      }
    }
    catch(SQLException e)
    {
      System.out.println("Sorry an exception occurred."); 
    }
  }


  public AeonDeckStats(String name, int max_spells, int max_copies, int max_schoolCopies, int sideboard, int health, int block, int critical, int pip_conversion, String school, String pip_gain, int archmastery_rating, Socket socket1)
  {
    super(name); 
    this.max_spells = max_spells; 
    this.max_copies = max_copies; 
    this.max_schoolCopies = max_schoolCopies; 
    this.sideboard = sideboard; 
    this.health = health; 
    this.block = block; 
    this.critical = critical; 
    this.pip_conversion = pip_conversion; 
    this.school = school;
    this.pip_gain = pip_gain; 
    this.archmastery_rating = archmastery_rating;
    this.socket1 = socket1; 
  }

  @Override
  public void statsInformation() {
    System.out.println("Here is the following information about the deck chosen."); 
    System.out.println("Max Spells: " + max_spells); 
    System.out.println("Max Copies: " + max_copies); 
    System.out.println("Max School Copies: " + max_schoolCopies);
    System.out.println("Sideboard: " + sideboard); 
    System.out.println("Health: " + health); 
    System.out.println("Block: " + block); 
    System.out.println("Critical: " + critical); 
    System.out.println("Pip Conversion: " + pip_conversion); 
    System.out.println("School: " + school); 
    System.out.println("Pip Gain: " + pip_gain); 
    System.out.println("Archmastery Rating: " + archmastery_rating);
    System.out.println("Socket 1: " + socket1.getDescription()); 
  } 


  private Socket createSocketAttachment(Socket socket) {
    if(socket.getDescription().equals("unused"))
    {
    try
    {
      String db_url = WizCredentials.getDB_URL(); 
      String user = WizCredentials.getDB_USERNAME(); 
      String password = WizCredentials.getDB_PASSWORD(); 

      if(WizCredentials.authenticate(user, password))
      {
        System.out.println("Authentication successful"); 
      }
      else 
      {
        System.out.println("Authentication failed"); 
      }

      conn1 = DriverManager.getConnection(db_url, user, password);

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
            conn1.close(); 
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
              sc = new Scanner(System.in); 
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
								if(nameOfSocket.toLowerCase().equals(addAttachment.toLowerCase()))
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
                if(school.equals("Any School"))
                {
                  System.out.println("Name of socket school in database: " + " is compatible with any school."); 
                } 
								else if(!(socket.getSchool().toLowerCase().equals(school.toLowerCase())))
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
            conn1.close(); 
						return socket;
					}
		}
    conn1.close();
		return null;
    }catch(SQLException e)
    {
      System.out.println("Sorry, an exception occurred.");
      return null; 
    }
  }
  else 
  {
    return socket; 
  }
	}




}
