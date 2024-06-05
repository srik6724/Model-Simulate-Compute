package Configuration_Specifications_2_1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import Components.StatsInfo;
import Components.Wand;
import Credentials.WizCredentials;
import Model_Extensions.Socket;

public class EternalWandStats extends Wand implements StatsInfo {
  private int block; 
  private int critical; 
  private int damage; 
  private int pip_conversion; 
  private String block1; 
  private String block2; 
  private String pip_gain; 
  private String accuracy; 
  private String school; 
  private int level; 
  private Socket socket1; 
  private Connection conn1; 

  public EternalWandStats(String name)
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
        String sql = "SELECT block, critical, damage, pip_conversion, block1, block2, pip_gain, accuracy, school, level, socket1 FROM wizard_schema.eternal_wands WHERE name = ?"; 
        PreparedStatement stmt = conn1.prepareStatement(sql); 
        System.out.println(name); 
        stmt.setString(1, name);
        ResultSet rs = stmt.executeQuery(); 

        while(rs.next())
        {
          block = Integer.parseInt(rs.getString("block")); 
          critical = Integer.parseInt(rs.getString("critical")); 
          damage = Integer.parseInt(rs.getString("damage")); 
          pip_conversion = Integer.parseInt(rs.getString("pip_conversion")); 
          block1 = rs.getString("block1"); 
          block2 = rs.getString("block2"); 
          pip_gain = rs.getString("pip_gain"); 
          accuracy = rs.getString("accuracy"); 
          school = rs.getString("school");
          level = Integer.parseInt(rs.getString("level")); 
          socket1 = new Socket(rs.getString("socket1"), "square", school);
        }
        EternalWandStats createObj = new EternalWandStats(name, block, critical, damage, pip_conversion, block1, block2, pip_gain, accuracy, school, level, socket1); 
        createObj.createSocketAttachment(socket1); 
        createObj.statsInformation();
      }
    }
    catch(SQLException e)
    {
      System.out.println("Sorry an exception occurred."); 
    }
  }

  public EternalWandStats(String name, int block, int critical, int damage, int pip_conversion, String block1, String block2, String pip_gain, String accuracy, String school, int level, Socket socket1)
  {
    super(name); 
    this.block = block;
    this.critical = critical; 
    this.damage = damage; 
    this.pip_conversion = pip_conversion; 
    this.block1 = block1; 
    this.block2 = block2; 
    this.pip_gain = pip_gain; 
    this.accuracy = accuracy;
    this.school = school;
    this.level = level; 
    this.socket1 = socket1; 
  }

  @Override
  public void statsInformation() {
    System.out.println("Here is the following information about your wand."); 
    System.out.println("Block: " + block); 
    System.out.println("Critical: " + critical); 
    System.out.println("Damage: " + damage); 
    System.out.println("Pip Conversion: " + pip_conversion); 
    System.out.println("Block 1: " + block1); 
    System.out.println("Block 2: " + block2); 
    System.out.println("Pip Gain: " + pip_gain);
    System.out.println("Accuracy: " + accuracy);
    System.out.println("School: " + school); 
    System.out.println("Level: " + level); 
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
