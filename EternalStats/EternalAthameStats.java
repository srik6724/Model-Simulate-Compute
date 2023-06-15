package EternalStats;

import Gear.Athame;
import Gear.StatsInfo;
import Sockets.Socket;

public class EternalAthameStats extends Athame implements StatsInfo {
  private int health; 
  private int mana; 
  private int power_pip; 
  private int block; 
  private int damage; 
  private String block1; 
  private String school; 
  private Socket socket1; 
  private Socket socket2; 
  private Socket socket3; 
  private Socket socket4; 

  public EternalAthameStats(String name, int health, int mana, int power_pip, int block, int damage, String block1, String school, Socket socket1, Socket socket2, Socket socket3, Socket socket4)
  {
    super(name); 
    this.health = health; 
    this.mana = mana; 
    this.power_pip = power_pip; 
    this.block = block; 
    this.damage = damage; 
    this.block1 = block1;  
    this.school = school; 
    this.socket1 = socket1; 
    this.socket2 = socket2; 
    this.socket3 = socket3; 
    this.socket4 = socket4; 
  }

  @Override
  public void statsInformation() {
    System.out.println("Here is the following information about your athame."); 
    System.out.println("Health: " + health); 
    System.out.println("Mana: " + mana); 
    System.out.println("Power Pip: " + power_pip); 
    System.out.println("Block: " + block); 
    System.out.println("Damage: " + damage); 
    System.out.println("Block 1: " + block1); 
    System.out.println("School: " + school); 
    System.out.println("Socket 1: " + socket1); 
    System.out.println("Socket 2: " + socket2);
    System.out.println("Socket 3: " + socket3);
    System.out.println("Socket 4: " + socket4); 
  }

  

}
