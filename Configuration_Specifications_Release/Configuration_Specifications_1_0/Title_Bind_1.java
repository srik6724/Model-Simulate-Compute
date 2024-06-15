package Configuration_Specifications_1_0;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Components.Bind_1;
import Components.Binding_Specifications;
import Database.Credentials;

public class Title_Bind_1 extends Bind_1 implements Binding_Specifications 
{
  private int health; 
  private int power_pip; 
  private int accuracy; 
  private int pierce; 
  private int critical; 
  private int damage; 
  private int shadowRating; 

  public Title_Bind_1(String name)
  {
    super(name); 
    try
    {
      String db_url = Credentials.getDB_URL(); 
      String user = Credentials.getDB_USERNAME(); 
      String password = Credentials.getDB_PASSWORD(); 

      if(Credentials.authenticate(user, password))
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
        String sql = "SELECT health, power_pip, accuracy, pierce, critical, damage, shadowRating FROM wizard_schema.dragoon_hats WHERE name = " + name; 
        Statement stmt = conn1.createStatement(); 
        ResultSet rs = stmt.executeQuery(sql); 

        while(rs.next())
        {
          health = Integer.parseInt(rs.getString("health")); 
          power_pip = Integer.parseInt(rs.getString("power_pip")); 
          accuracy = Integer.parseInt(rs.getString("accuracy")); 
          pierce = Integer.parseInt(rs.getString("pierce")); 
          critical = Integer.parseInt(rs.getString("critical")); 
          damage = Integer.parseInt(rs.getString("damage")); 
          shadowRating = Integer.parseInt(rs.getString("shadowRating")); 
        }
        Title_Bind_1 createObj = new Title_Bind_1(name, health, power_pip, accuracy, pierce, critical, damage, shadowRating); 
        createObj.statsInformation();
      }
    }
    catch(SQLException e)
    {
      System.out.println("Sorry an exception occurred."); 
    }
  }

  public Title_Bind_1(String name, int health, int power_pip, int accuracy, int pierce, int critical, int damage, int shadowRating)
  {
    super(name); 
    this.health = health; 
    this.power_pip = power_pip; 
    this.accuracy = accuracy; 
    this.pierce = pierce; 
    this.critical = critical; 
    this.damage = damage; 
    this.shadowRating = shadowRating; 
  }

  @Override
  public void statsInformation() {
    System.out.println("Here is the following information about the hat chosen."); 
    System.out.println("Health: " + health); 
    System.out.println("Power Pip: " + power_pip); 
    System.out.println("Accuracy: " + accuracy); 
    System.out.println("Pierce: " + pierce); 
    System.out.println("Critical: " + critical); 
    System.out.println("Damage: " + damage); 
    System.out.println("Shadow Rating: " + shadowRating); 
  }

  

}