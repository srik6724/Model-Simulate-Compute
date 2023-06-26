package AeonStats;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import Credentials.WizCredentials;
import Gear.Ring;
import Gear.StatsInfo;
import Sockets.Socket;

public class AeonRingStats extends Ring implements StatsInfo {
  private int health; 
  private int mana; 
  private int power_pip; 
  private int critical; 
  private int damage; 
  private String school_damage1; 
  private Socket socket1; 
  private Socket socket2; 
  private Socket socket3; 
  private Connection conn1; 

  public AeonRingStats(String name)
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
        String sql = "SELECT health, power_pip, block, resist, accuracy, pierce, critical, damage, school, socket1, socket2, socket3 FROM wizard_schema.aeon_rings WHERE name = " + name; 
        Statement stmt = conn1.createStatement(); 
        ResultSet rs = stmt.executeQuery(sql); 

        while(rs.next())
        {
          health = Integer.parseInt(rs.getString("health")); 
          mana = Integer.parseInt(rs.getString("mana")); 
          power_pip = Integer.parseInt(rs.getString("power_pip")); 
          critical = Integer.parseInt(rs.getString("critical")); 
          damage = Integer.parseInt(rs.getString("damage")); 
          school_damage1 = rs.getString("school_damage1"); 
          socket1.setDescription(rs.getString("socket1"));
          socket2.setDescription(rs.getString("socket2"));
          socket3.setDescription(rs.getString("socket3"));
        }

        AeonRingStats createObj = new AeonRingStats(name, health, mana, power_pip, critical, damage, school_damage1, socket1, socket2, socket3); 
        createObj.createSocketAttachment(socket1); 
        createObj.createSocketAttachment(socket2); 
        createObj.createSocketAttachment(socket3); 
        createObj.statsInformation();
      }
    }
    catch(SQLException e)
    {
      System.out.println("Sorry an exception occurred."); 
    }
  }

  public AeonRingStats(String name, int health, int  mana, int power_pip, int critical, int damage, String school_damage1, Socket socket1, Socket socket2, Socket socket3)
  {
    super(name); 
    this.health = health; 
    this.mana = mana; 
    this.power_pip = power_pip; 
    this.critical = critical; 
    this.damage = damage; 
    this.school_damage1 = school_damage1; 
    this.socket1 = socket1; 
    this.socket2 = socket2; 
    this.socket3 = socket3; 
  }

  @Override
  public void statsInformation() {
    System.out.println("Here is the following information about the hat chosen."); 
    System.out.println("Health: " + health); 
    System.out.println("Mana: " + mana); 
    System.out.println("Power Pip: " + power_pip);
    System.out.println("Critical: " + critical); 
    System.out.println("Damage: " + damage); 
    System.out.println("School Damage 1: " + school_damage1); 
    System.out.println("Socket 1: " + socket1); 
    System.out.println("Socket 2: " + socket2); 
    System.out.println("Socket 3: " + socket3); 
  }

  private Socket createSocketAttachment(Socket socket) {

		if(socket.getDescription().equals("unused"))
		{
			try {

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


}
