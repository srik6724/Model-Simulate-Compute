package EternalStats;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import Credentials.WizCredentials;
import Gear.Amulet;
import Gear.StatsInfo;
import Sockets.Socket;

public class EternalAmuletStats extends Amulet implements StatsInfo {
  private int health;
  private int resist; 
  private int pip_conversion; 
  private int block; 
  private String school; 
  private int level; 
  private Socket socket1; 
  private Socket socket2; 
  private Connection conn1; 

  public EternalAmuletStats(String name)
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

      Connection conn1 = DriverManager.getConnection(db_url, user, password);

      if(conn1 != null)
      {
        String sql = "SELECT health, resist, pip_conversion, block, school, level, socket1, socket2 FROM wizard_schema.eternal_amulets WHERE name = ?"; 
        PreparedStatement stmt = conn1.prepareStatement(sql); 
        System.out.println(name); 
        stmt.setString(1, name);
        ResultSet rs = stmt.executeQuery();  

        while(rs.next())
        {
          health = Integer.parseInt(rs.getString("health")); 
          resist = Integer.parseInt(rs.getString("resist")); 
          pip_conversion = Integer.parseInt(rs.getString("pip_conversion")); 
          block = Integer.parseInt(rs.getString("block")); 
          school = rs.getString("school"); 
          level = Integer.parseInt(rs.getString("level")); 
          socket1 = new Socket(rs.getString("socket1"), "square", school);
          socket2 = new Socket(rs.getString("socket2"), "square", school);
        }
        EternalAmuletStats createObj = new EternalAmuletStats(name, health, resist, pip_conversion, block, school, level, socket1, socket2); 
        createObj.createSocketAttachment(socket1); 
        createObj.createSocketAttachment(socket2);
        createObj.statsInformation();
      }
    }
    catch(SQLException e)
    {
      System.out.println("Sorry an exception occurred."); 
    }
  }

  public EternalAmuletStats(String name, int health, int resist, int pip_conversion, int block, String school, int level, Socket socket1, Socket socket2)
  {
    super(name); 
    this.health = health; 
    this.resist = resist; 
    this.pip_conversion = pip_conversion; 
    this.block = block; 
    this.school = school; 
    this.level = level; 
    this.socket1 = socket1; 
    this.socket2 = socket2; 
  }

  @Override
  public void statsInformation() {
    System.out.println("Here is the following information about your amulet."); 
    System.out.println("Block: " + block); 
    System.out.println("Resist: " + resist); 
    System.out.println("Pip Conversion: " + pip_conversion);  
    System.out.println("Health: " + health);
    System.out.println("School: " + school); 
    System.out.println("Level: " + level); 
    System.out.println("Socket 1: " + socket1.getDescription()); 
    System.out.println("Socket 2: " + socket2.getDescription()); 
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
								else if(!(socket.getSchool().toLowerCase().equals(school)))
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
