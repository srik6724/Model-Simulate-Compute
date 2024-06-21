package Configuration_Specifications_1_0;

import Agent_Restore.Healing;
import Components.Bind_3;
import Components.Model_Specifications;

public class Title_Bind_3 extends Bind_3 implements Model_Specifications {

  private int health; 
  private int power_pip; 
  private int resist; 
  private int critical; 
  private int damage; 
  private Healing healing; 
  private int shadowRating; 

  public Title_Bind_3(String name)
  {
    super(name); 
    
  }

  public Title_Bind_3(String name, int health, int power_pip, int resist, int critical, int damage, Healing healing, int shadowRating)
  {
    super(name); 
    this.health = health; 
    this.power_pip = power_pip; 
    this.resist = resist; 
    this.critical = critical; 
    this.damage = damage; 
    this.healing = healing; 
    this.shadowRating = shadowRating; 
  }

  @Override
  public void statsInformation() {
    System.out.println("Here is the following information about the boot chosen."); 
    System.out.println("Health: " + health); 
    System.out.println("Power Pip: " + power_pip); 
    System.out.println("Resist: " + resist); 
    System.out.println("Critical: " + critical);
    System.out.println("Damage: " + damage);  
    System.out.println("Healing Description: " + healing.getDescription());   
    System.out.println("Shadow Rating: " + shadowRating); 
  }
  
}
