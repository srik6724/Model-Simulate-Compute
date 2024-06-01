package DragoonStats;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Credentials.WizCredentials;
import Gear.Robe;
import Gear.StatsInfo;
import Regeneration.Healing;

public class DragoonRobeStats extends Robe implements StatsInfo {

  private int health; 
  private int power_pip; 
  private int block; 
  private int resist; 
  private int accuracy; 
  private int pierce; 
  private Healing healing;   
  private int shadowRating; 

  public DragoonRobeStats(String name) {
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
        String sql = "SELECT health, power_pip, block, resist, accuracy, pierce, healing, shadowRating FROM wizard_schema.dragoon_robes WHERE name = ?"; 
        PreparedStatement stmt = conn1.prepareStatement(sql); 
        System.out.println(name); 
        stmt.setString(1, name); 
        ResultSet rs = stmt.executeQuery(); 

        while(rs.next())
        {
          health = Integer.parseInt(rs.getString("health")); 
          power_pip = Integer.parseInt(rs.getString("power_pip")); 
          block = Integer.parseInt(rs.getString("block")); 
          resist = Integer.parseInt(rs.getString("resist")); 
          accuracy = Integer.parseInt(rs.getString("accuracy")); 
          pierce = Integer.parseInt(rs.getString("pierce")); 
          String healing_description = rs.getString("healing"); 
          healing = new Healing(healing_description);
          shadowRating = Integer.parseInt(rs.getString("shadowRating")); 
        }
        DragoonRobeStats createObj = new DragoonRobeStats(name, health, power_pip, block, resist, accuracy, pierce, healing, shadowRating); 
        createObj.statsInformation();
      }
    }
    catch(SQLException e)
    {
      System.out.println("Sorry an exception occurred."); 
    }
  }

  public DragoonRobeStats(String name, int health, int power_pip, int block, int resist, int accuracy, int pierce, Healing healing, int shadowRating)
  {
    super(name); 
    this.health = health; 
    this.power_pip = power_pip; 
    this.block = block; 
    this.resist = resist; 
    this.accuracy = accuracy; 
    this.pierce = pierce; 
    this.healing = healing; 
    this.shadowRating = shadowRating; 
  }

  @Override
  public void statsInformation() {
    System.out.println("Health: " + health); 
    System.out.println("Power Pip: " + power_pip); 
    System.out.println("Block: " + block); 
    System.out.println("Resist: " + resist); 
    System.out.println("Accuracy: " + accuracy); 
    System.out.println("Pierce: " + pierce); 
    System.out.println("Healing Description: " + healing.getDescription()); 
    System.out.println("Shadow Rating: " + shadowRating); 
  }
  
}
