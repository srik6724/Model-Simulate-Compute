package DragoonStats;

import Gear.Boot;
import Gear.StatsInfo;
import Healing.Healing;

public class DragoonBootsStats extends Boot implements StatsInfo {

  private int health; 
  private int power_pip; 
  private int resist; 
  private int critical; 
  private int damage; 
  private Healing healing; 
  private int shadowRating; 

  public DragoonBootsStats(String name)
  {
    super(name); 
    
  }

  public DragoonBootsStats(String name, int health, int power_pip, int resist, int critical, int damage, Healing healing, int shadowRating)
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
