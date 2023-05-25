package Gear;

import Stats.AeonHatStats;

public class Hat extends AeonHatStats implements StatsInfo {
  public String name; 

  public Hat(String name)
  {
    this.name = name; 
  }

  @Override
  public void statsInformation() {
    System.out.println("Here is the following information about the hat chosen."); 
    System.out.println("Health: " + AeonHatStats.health); 
    System.out.println("Power Pip: " + AeonHatStats.power_pip); 
    System.out.println("Block: " + AeonHatStats.block); 
    System.out.println("Resist: " + AeonHatStats.resist); 
    System.out.println("Accuracy: " + AeonHatStats.accuracy); 
    System.out.println("Pierce: " + AeonHatStats.pierce); 
    System.out.println("Critical: " + AeonHatStats.critical);
    System.out.println("Damage: " + AeonHatStats.damage); 
    System.out.println("School: " + AeonHatStats.school);
    System.out.println("Socket 1: " + AeonHatStats.socket1.getDescription()); 
    System.out.println("Socket 2: " + AeonHatStats.socket2.getDescription());
    System.out.println("Socket 3: " + AeonHatStats.socket3.getDescription()); 
  }

}
