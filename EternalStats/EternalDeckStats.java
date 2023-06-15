package EternalStats;

import Gear.Deck;
import Gear.StatsInfo;
import Sockets.Socket;

public class EternalDeckStats extends Deck implements StatsInfo {
  private int max_spells;
  private int max_copies;
  private int max_schoolCopies; 
  private int sideboard;
  private int health;
  private int block; 
  private int critical;
  private String pip_conversion; 
  private String school;
  private String pip_gain; 
  private int archmastery_rating;
  private Socket socket1; 

  public EternalDeckStats(String name, int max_spells, int max_copies, int max_schoolCopies, int sideboard, int health, int block, int critical, String pip_conversion, String school, String pip_gain, int archmastery_rating, Socket socket1)
  {
    super(name); 
    this.max_spells = max_spells; 
    this.max_copies = max_copies; 
    this.max_schoolCopies = max_schoolCopies; 
    this.sideboard = sideboard; 
    this.health = health; 
    this.block = block; 
    this.critical = critical; 
    this.pip_conversion = pip_conversion; 
    this.school = school; 
    this.pip_gain = pip_gain; 
    this.archmastery_rating = archmastery_rating; 
    this.socket1 = socket1; 

  }

  @Override
  public void statsInformation() {
    System.out.println("Here is the following information about your deck.");
    System.out.println("Max Spells: " + max_spells); 
    System.out.println("Max Copies: " + max_copies); 
    System.out.println("Max School Copies: " + max_schoolCopies);
    System.out.println("Sideboard: " + sideboard); 
    System.out.println("Health: " + health); 
    System.out.println("Block: " + block); 
    System.out.println("Critical: " + critical); 
    System.out.println("Pip Conversion: " + pip_conversion);
    System.out.println("School: " + school); 
    System.out.println("Pip Gain: " + pip_gain);
    System.out.println("Archmastery Rating: " + archmastery_rating); 
    System.out.println("Socket 1: " + socket1); 
    
  }
}
