package Gear;

import Stats.AeonBootsStats;

public class Boot extends AeonBootsStats implements StatsInfo {

  public String name; 

  public Boot(String name)
  {
    this.name = name; 
  }

  @Override
  public void statsInformation() {
    System.out.println("Here is the information about the boot chosen."); 
    System.out.println("Health: " + AeonBootsStats.health); 
    System.out.println("Power Pip: " + AeonBootsStats.power_pip); 
    System.out.println("Block: " + AeonBootsStats.block); 
    System.out.println("Resist: " + AeonBootsStats.resist); 
    System.out.println("Accuracy: " + AeonBootsStats.accuracy); 
    System.out.println("Pierce: " + AeonBootsStats.pierce); 
    System.out.println("Critical: " + AeonBootsStats.critical);
    System.out.println("Damage: " + AeonBootsStats.damage); 
    System.out.println("School: " + AeonBootsStats.school);
    System.out.println("Socket 1: " + AeonBootsStats.socket1.getDescription()); 
    System.out.println("Socket 2: " + AeonBootsStats.socket2.getDescription());
    System.out.println("Socket 3: " + AeonBootsStats.socket3.getDescription()); 
  }
  
}
