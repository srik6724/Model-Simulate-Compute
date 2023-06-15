package EternalStats;

import Gear.StatsInfo;
import Gear.Wand;
import Sockets.Socket;

public class EternalWandStats extends Wand implements StatsInfo {
  private int block; 
  private int critical; 
  private int damage; 
  private int pip_conversion; 
  private String block1; 
  private String block2; 
  private String pip_gain; 
  private String accuracy; 
  private String school; 
  private Socket socket1; 

  public EternalWandStats(String name, int block, int critical, int damage, int pip_conversion, String block1, String block2, String pip_gain, String accuracy, String school, Socket socket1)
  {
    super(name); 
    this.block = block;
    this.critical = critical; 
    this.damage = damage; 
    this.pip_conversion = pip_conversion; 
    this.block1 = block1; 
    this.block2 = block2; 
    this.pip_gain = pip_gain; 
    this.accuracy = accuracy;
    this.school = school;
    this.socket1 = socket1; 
  }

  @Override
  public void statsInformation() {
    System.out.println("Here is the following information about your wand."); 
    System.out.println("Block: " + block); 
    System.out.println("Critical: " + critical); 
    System.out.println("Damage: " + damage); 
    System.out.println("Pip Conversion: " + pip_conversion); 
    System.out.println("Block 1: " + block1); 
    System.out.println("Block 2: " + block2); 
    System.out.println("Pip Gain: " + pip_gain);
    System.out.println("Accuracy: " + accuracy);
    System.out.println("School: " + school); 
    System.out.println("Socket 1: " + socket1); 
  }

  
  
}
