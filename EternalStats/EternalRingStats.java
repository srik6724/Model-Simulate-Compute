package EternalStats;

import Gear.Ring;
import Gear.StatsInfo;
import Sockets.Socket;

public class EternalRingStats extends Ring implements StatsInfo {
  private int health; 
  private int mana; 
  private int power_pip; 
  private int critical; 
  private int damage;
  private String outgoing; 
  private String school; 
  private Socket socket1;
  private Socket socket2; 
  private Socket socket3; 

  public EternalRingStats(String name, int health, int mana, int power_pip, int critical, int damage, String outgoing, String school, Socket socket1, Socket socket2, Socket socket3)
  {
    super(name); 
    this.health = health; 
    this.mana = mana; 
    this.power_pip = power_pip; 
    this.critical = critical; 
    this.damage = damage; 
    this.outgoing = outgoing; 
    this.school = school; 
    this.socket1 = socket1; 
    this.socket2 = socket2; 
    this.socket3 = socket3; 
  }

  @Override
  public void statsInformation() {
    System.out.println("Here is the following information about your ring."); 
    System.out.println("Health: " + health); 
    System.out.println("Mana: " + mana); 
    System.out.println("Power Pip: " + power_pip);  
    System.out.println("Critical: " + critical); 
    System.out.println("Damage: " + damage); 
    System.out.println("Outgoing: " + outgoing); 
    System.out.println("School: " + school); 
    System.out.println("Socket 1: " + socket1); 
    System.out.println("Socket 2: " + socket2); 
    System.out.println("Socket 3: " + socket3); 
  }

  
}
