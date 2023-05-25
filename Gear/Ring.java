package Gear;

import Stats.AeonRingStats;

public class Ring extends AeonRingStats implements StatsInfo{
  
  public String name; 

  public Ring(String name)
  {
    this.name = name; 
  }

  @Override
  public void statsInformation() {

    System.out.println("Here is the following information about the ring chosen."); 
    System.out.println("Health: " + AeonRingStats.health); 
    System.out.println("Mana: " + AeonRingStats.mana); 
    System.out.println("Power Pip: " + AeonRingStats.power_pip); 
    System.out.println("Critical: " + AeonRingStats.critical);
    System.out.println("Damage: " + AeonRingStats.damage); 
    System.out.println("School Damage 1: " + AeonRingStats.school_damage1);
    System.out.println("School: " + AeonRingStats.school); 
    System.out.println("Socket 1: " + AeonRingStats.socket1.getDescription());
    System.out.println("Socket 2: " + AeonRingStats.socket2.getDescription()); 
    System.out.println("Socket 3: " + AeonRingStats.socket3.getDescription()); 
    
  }

}
