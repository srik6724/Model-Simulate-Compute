package Gear;

import Stats.AeonRobeStats;

public class Robe extends AeonRobeStats implements StatsInfo {
  
  public String name; 

  public Robe(String name)
  {
    this.name = name; 
  }

  @Override
  public void statsInformation() {
    System.out.println("Here is the information about the robe chosen."); 
    System.out.println("Health: " + AeonRobeStats.health); 
    System.out.println("Power Pip: " + AeonRobeStats.power_pip); 
    System.out.println("Block: " + AeonRobeStats.block); 
    System.out.println("Resist: " + AeonRobeStats.resist); 
    System.out.println("Accuracy: " + AeonRobeStats.accuracy); 
    System.out.println("Pierce: " + AeonRobeStats.pierce); 
    System.out.println("Critical: " + AeonRobeStats.critical);
    System.out.println("Damage: " + AeonRobeStats.damage); 
    System.out.println("School: " + AeonRobeStats.school);
    System.out.println("Socket 1: " + AeonRobeStats.socket1.getDescription()); 
    System.out.println("Socket 2: " + AeonRobeStats.socket2.getDescription());
    System.out.println("Socket 3: " + AeonRobeStats.socket3.getDescription()); 
  }

  

}
