package Configuration_Specifications_1_1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Components.Robe;
import Components.StatsInfo;
import Credentials.WizCredentials;
import Features.ItemCard;
import Regeneration.Healing;

public class SpookyRobeStats extends Robe implements StatsInfo {
  private int health;
  private int power_pip;
  private int shadowRating;
  private int accuracy; 
  private int block; 
  private int resist; 
  private Healing healing; 
  private ItemCard card; 
  private int level; 
  private String school; 
  private Connection conn1; 

  public SpookyRobeStats(String name)
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
        String sql = "SELECT health, power_pip, shadowRating, accuracy, block, resist, healing, item_card, level, school FROM wizard_schema.spooky_robes WHERE name = " + name; 
        Statement stmt = conn1.createStatement(); 
        ResultSet rs = stmt.executeQuery(sql); 

        while(rs.next())
        {
          health = Integer.parseInt(rs.getString("health")); 
          power_pip = Integer.parseInt(rs.getString("power_pip")); 
          shadowRating = Integer.parseInt(rs.getString("shadowRating")); 
          accuracy = Integer.parseInt(rs.getString("accuracy")); 
          block = Integer.parseInt(rs.getString("block"));
          resist = Integer.parseInt(rs.getString("resist")); 
          String healing_description = rs.getString("healing"); 
          healing = new Healing(healing_description);
          card.setDescription(rs.getString("item_card"));
          level = Integer.parseInt(rs.getString("level")); 
          school = rs.getString("school"); 
        }
        SpookyRobeStats createObj = new SpookyRobeStats(name, health, power_pip, shadowRating, accuracy, block, resist, healing, card, level, school); 
        createObj.statsInformation();
    }
  }catch(SQLException e)
  {
    System.out.println("Sorry an exception occurred."); 
  }
}

  public SpookyRobeStats(String name, int health, int power_pip, int shadowRating, int accuracy, int block, int resist, Healing healing, ItemCard card, int level, String school)
  {
    super(name); 
    this.health = health; 
    this.power_pip = power_pip; 
    this.shadowRating = shadowRating; 
    this.accuracy = accuracy; 
    this.block = block; 
    this.resist = resist; 
    this.healing = healing; 
    this.card = card; 
    this.level = level; 
    this.school = school; 
  }

  @Override
  public void statsInformation() {
    System.out.println("Health: " + health); 
    System.out.println("Power Pip: " + power_pip); 
    System.out.println("Shadow Rating: " + shadowRating); 
    System.out.println("Accuracy: " + accuracy); 
    System.out.println("Block: " + block); 
    System.out.println("Resist: " + resist); 
    System.out.println("Healing Description: " + healing.getDescription()); 
    System.out.println("Card: " + card.getDescription()); 
    System.out.println("Level: " + level); 
    System.out.println("School: " + school); 
  }
}