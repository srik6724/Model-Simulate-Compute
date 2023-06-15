package EternalStats;


import Gear.Boot;
import Gear.StatsInfo;
import Sockets.Socket;

public class EternalBootsStats extends Boot implements StatsInfo {
  
  private int health; 
  private int power_pip; 
  private int block; 
  private int resist; 
  private int accuracy; 
  private int critical; 
  private int damage; 
  private int shadowRating; 
  private String school; 
  private Socket socket1; 
  private Socket socket2; 
  private Socket socket3; 

  public EternalBootsStats(String name, int health, int power_pip, int block, int resist, int accuracy, int pierce, int critical, int damage, int shadowRating, String school, Socket socket1, Socket socket2, Socket socket3)
  {
    super(name); 
    this.health = health; 
    this.power_pip = power_pip; 
    this.block = block; 
    this.resist = resist; 
    this.accuracy = accuracy; 
    this.critical = critical; 
    this.damage = damage; 
    this.shadowRating = shadowRating; 
    this.school = school; 
    this.socket1 = socket1; 
    this.socket2 = socket2; 
    this.socket3 = socket3; 
  }

  @Override
  public void statsInformation() {
    System.out.println("Here is the following information about your boot."); 
    System.out.println("Health: " + health); 
    System.out.println("Power Pip: " + power_pip); 
    System.out.println("Block: " + block);
    System.out.println("Resist: " + resist); 
    System.out.println("Accuracy: " + accuracy); 
    System.out.println("Critical: " + critical); 
    System.out.println("Damage: " + damage); 
    System.out.println("Shadow Rating: "  + shadowRating); 
    System.out.println("School: " + school); 
    System.out.println("Socket 1: " + socket1); 
    System.out.println("Socket 2: " + socket2); 
    System.out.println("Socket 3: " + socket3); 
  }
}
