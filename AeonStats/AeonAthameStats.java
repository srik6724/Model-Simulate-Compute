package AeonStats;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import Credentials.WizCredentials;
import Gear.Athame;
import Gear.StatsInfo;
import Sockets.Socket;

public class AeonAthameStats extends Athame implements StatsInfo {
  private int health; 
  private int mana;
  private int power_pip; 
  private int block;
  private int damage; 
  private String school_damage1; 
  private String school; 
  private Socket socket1; 
  private Socket socket2; 
  private Socket socket3; 
  private Socket socket4; 
  private Connection conn1; 

  public AeonAthameStats(String name)
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
        String sql = "SELECT health, mana, power_pip, block, damage, school_damage1, school, socket1, socket2, socket3, socket4 FROM wizard_schema.aeon_athames WHERE name = ?"; 
        PreparedStatement stmt = conn1.prepareStatement(sql); 
        System.out.println(name); 
        stmt.setString(1, name);
        ResultSet rs = stmt.executeQuery(); 

        while(rs.next())
        {
          health = Integer.parseInt(rs.getString("health")); 
          mana = Integer.parseInt(rs.getString("mana")); 
          power_pip = Integer.parseInt(rs.getString("power_pip")); 
          damage = Integer.parseInt(rs.getString("damage")); 
          school_damage1 = rs.getString("school_damage1"); 
          block = Integer.parseInt(rs.getString("block")); 
          school = rs.getString("school");
          socket1 = new Socket(rs.getString("socket1"), "tear", school);
          socket2 = new Socket(rs.getString("socket2"), "circle", school);
          socket3 = new Socket(rs.getString("socket3"), "circle", school);
          socket4 = new Socket(rs.getString("socket4"), "triangle", school);
        }
        AeonAthameStats createObj = new AeonAthameStats(name, health, mana, power_pip, block, damage, school_damage1, school, socket1, socket2, socket3, socket4); 
        createObj.createSocketAttachment(socket1); 
        createObj.createSocketAttachment(socket2); 
        createObj.createSocketAttachment(socket3); 
        createObj.createSocketAttachment(socket4); 
        createObj.statsInformation();
      }
      conn1.close(); 
    }
    catch(SQLException e)
    {
      System.out.println("Sorry an exception occurred."); 
    }
  }

  public AeonAthameStats(String name, int health, int mana, int power_pip, int block, int damage, String school_damage1, String school, Socket socket1, Socket socket2, Socket socket3, Socket socket4)
  {
    super(name); 
    this.health = health; 
    this.mana = mana; 
    this.power_pip = power_pip; 
    this.block = block; 
    this.damage = damage; 
    this.school_damage1 = school_damage1; 
    this.school = school; 
    this.socket1 = socket1; 
    this.socket2 = socket2; 
    this.socket3 = socket3; 
    this.socket4 = socket4; 
  }

  @Override
  public void statsInformation() {
    System.out.println("Here is the following information about the athame chosen."); 
    System.out.println("Health: " + health); 
    System.out.println("Mana: " + mana); 
    System.out.println("Power Pip: " + power_pip); 
    System.out.println("Block: " + block); 
    System.out.println("Damage: " + damage); 
    System.out.println("School Damage 1: " + school_damage1); 
    System.out.println("School: " + school); 
    System.out.println("Socket 1: " + socket1.getDescription()); 
    System.out.println("Socket 2: " + socket2.getDescription()); 
    System.out.println("Socket 3: " + socket3.getDescription()); 
    System.out.println("Socket 4: " + socket4.getDescription()); 
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
							String tableName = socket.getType() + "_sockets";
              System.out.println(tableName); 
              String sqlString = "SELECT * FROM wizard_schema." + tableName;
              System.out.println(sqlString); 
              PreparedStatement statement = conn1.prepareStatement(sqlString);
              ResultSet rs = statement.executeQuery();
							while(rs.next())
							{
								nameOfSocket = rs.getString("name"); 
								school = rs.getString("school");
								description = rs.getString("description"); 
								if((nameOfSocket.toLowerCase().equals(addAttachment.toLowerCase())))
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
            System.out.println("Name Of Socket: " + nameOfSocket);
            System.out.println("Description: " + description); 
            System.out.println("School: " + school);
            socket.setDescription(description);
            socket.setDescription(school);
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
