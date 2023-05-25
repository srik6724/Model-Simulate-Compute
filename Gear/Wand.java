package Gear;

import Stats.AeonWandStats;

public class Wand extends AeonWandStats implements StatsInfo {
  public String name; 

  public Wand(String name)
  {
    this.name = name; 
  }

  @Override
  public void statsInformation() {
    
    System.out.println("Here is the information about the wand chosen."); 
    System.out.println("Block: " + AeonWandStats.block); 
    System.out.println("Pierce: " + AeonWandStats.pierce); 
    System.out.println("Critical: " + AeonWandStats.critical);
    System.out.println("Damage: " + AeonWandStats.damage); 
    System.out.println("Pip Conversion: " + AeonWandStats.pip_conversion);
    System.out.println("Critical School: " + AeonWandStats.critical_school); 
    System.out.println("School Damage 1: " + AeonWandStats.school_damage1);
    System.out.println("School Damage 2: " + AeonWandStats.school_damage2);
    System.out.println("Pip Gain: " + AeonWandStats.pip_gain);
    System.out.println("School: " + AeonWandStats.school);
    System.out.println("Socket 1: " + AeonWandStats.socket1.getDescription());


  }
}
