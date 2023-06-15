package AeonStats;

import Gear.Hat;
import Gear.StatsInfo;
import Sockets.Socket;

public class AeonHatStats extends Hat implements StatsInfo{

  private int health; 
  private int power_pip; 
  private int block; 
  private int resist; 
  private int accuracy; 
  private int pierce; 
  private int critical; 
  private int damage; 
  private String school; 
  private Socket socket1; 
  private Socket socket2; 
  private Socket socket3; 

  public AeonHatStats(String name, int health, int power_pip, int block, int resist, int accuracy, int pierce, int critical, int damage, String school, Socket socket1, Socket socket2, Socket socket3) {
    super(name);
    this.health = health; 
    this.power_pip = power_pip; 
    this.block = block; 
    this.resist = resist; 
    this.accuracy = accuracy; 
    this.pierce = pierce; 
    this.critical = critical; 
    this.damage = damage; 
    this.school = school; 
    this.socket1 = socket1; 
    this.socket2 = socket2; 
    this.socket3 = socket3; 
  }

  @Override
  public void statsInformation() {
    System.out.println("Here is the following information about the hat chosen."); 
    System.out.println("Health: " + health); 
    System.out.println("Power Pip: " + power_pip); 
    System.out.println("Block: " + block); 
    System.out.println("Resist: " + resist); 
    System.out.println("Accuracy: " + accuracy); 
    System.out.println("Pierce: " + pierce); 
    System.out.println("Critical: " + critical);
    System.out.println("Damage: " + damage); 
    System.out.println("School: " + school);
    System.out.println("Socket 1: " + socket1.getDescription()); 
    System.out.println("Socket 2: " + socket2.getDescription());
    System.out.println("Socket 3: " + socket3.getDescription()); 
  }
  
}
