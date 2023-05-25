package Gear;

import Stats.AeonAthameStats;

public class Athame extends AeonAthameStats implements StatsInfo{

  public String name; 

  public Athame(String name)
  {
    this.name = name; 
  }
  
  @Override
  public void statsInformation() {
    System.out.println("Here is the information about the athame chosen."); 
    System.out.println("Health: " + AeonAthameStats.health); 
    System.out.println("Mana: " + AeonAthameStats.mana); 
    System.out.println("Power Pip: " + AeonAthameStats.power_pip);
    System.out.println("Block: " + AeonAthameStats.block); 
    System.out.println("Damage: " + AeonAthameStats.damage); 
    System.out.println("School Damage 1: " + AeonAthameStats.school_damage1); 
    System.out.println("School: " + AeonAthameStats.school); 
    System.out.println("Socket 1: " + AeonAthameStats.socket1.getDescription()); 
    System.out.println("Socket 2: " + AeonAthameStats.socket2.getDescription()); 
    System.out.println("Socket 3: " + AeonAthameStats.socket3.getDescription()); 
    System.out.println("Socket 4: " + AeonAthameStats.socket4.getDescription()); 

    //Create a socket generator that stores the talents inside a database of the list of available sockets up to date.
    //Use a randomizer algorithm. 


  }
  
}
