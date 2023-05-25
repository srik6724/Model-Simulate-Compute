package Gear;

import Stats.AeonDeckStats;

public class Deck extends AeonDeckStats implements StatsInfo {

  public String name; 

  public Deck(String name)
  {
    this.name = name; 
  }

  @Override
  public void statsInformation() {
    System.out.println("Here is the following information about the deck chosen."); 
    System.out.println("Max Spells: " + AeonDeckStats.max_spells); 
    System.out.println("Max Copies: " + AeonDeckStats.max_copies); 
    System.out.println("Max School Copies: " + AeonDeckStats.max_schoolCopies);
    System.out.println("Sideboard: " + AeonDeckStats.sideboard); 
    System.out.println("Health: " + AeonDeckStats.health);
    System.out.println("Block: " + AeonDeckStats.block); 
    System.out.println("Critical: " + AeonDeckStats.critical);
    System.out.println("School: " + AeonDeckStats.school);
    System.out.println("Pip Gain: " + AeonDeckStats.pip_gain);
    System.out.println("Archmastery Rating: " + AeonDeckStats.archmastery_rating);
    System.out.println("Socket 1: " + AeonDeckStats.socket1.getDescription());

  }
  
}
