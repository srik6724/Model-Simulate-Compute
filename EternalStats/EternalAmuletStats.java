package EternalStats;

import Gear.Amulet;
import Gear.StatsInfo;
import Sockets.Socket;

public class EternalAmuletStats extends Amulet implements StatsInfo {
  private int health;
  private int resist; 
  private int pip_conversion; 
  private int block; 
  private String school; 
  private Socket socket1; 
  private Socket socket2; 

  public EternalAmuletStats(String name, int health, int resist, int pip_conversion, int block, String school, Socket socket1, Socket socket2)
  {
    super(name); 
    this.health = health; 
    this.resist = resist; 
    this.pip_conversion = pip_conversion; 
    this.block = block; 
    this.school = school; 
    this.socket1 = socket1; 
    this.socket2 = socket2; 
  }

  @Override
  public void statsInformation() {
    System.out.println("Here is the following information about your amulet."); 
    System.out.println("Block: " + block); 
    System.out.println("Resist: " + resist); 
    System.out.println("Pip Conversion: " + pip_conversion);  
    System.out.println("Health: " + health);
    System.out.println("School: " + school); 
    System.out.println("Socket 1: " + socket1); 
    System.out.println("Socket 2: " + socket2); 
  }


}
