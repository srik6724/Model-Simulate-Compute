package Gear;

import Stats.AeonAmuletStats;

public class Amulet extends AeonAmuletStats implements StatsInfo {

  public String name; 

  public Amulet(String name)
  {
    this.name = name; 
  }


  @Override
  public void statsInformation() {
    System.out.println("Here is the information about the amulet chosen."); 
    System.out.println("Block: " + AeonAmuletStats.block); 
    System.out.println("Resist: " + AeonAmuletStats.resist); 
    System.out.println("Pip Conversion: " + AeonAmuletStats.pip_conversion); 
    System.out.println("Health: " + AeonAmuletStats.health); 
    System.out.println("School: " + AeonAmuletStats.school); 
    System.out.println("Socket 1: " + AeonAmuletStats.socket1.getDescription());
    System.out.println("Socket 2: " + AeonAmuletStats.socket2.getDescription()); 
  }
  
}
