package AeonStats;

import Gear.StatsInfo;
import Gear.Wand;
import Sockets.Socket;

public class AeonWandStats extends Wand implements StatsInfo {

  private int block; 
  private int pierce;
  private int critical;
  private int damage;
  private int pip_conversion; 
  private String critical_school;
  private String school_damage1; 
  private String school_damage2; 
  private String pip_gain; 
  private String school; 
  private Socket socket1;

  public AeonWandStats(String name, int block, int pierce, int critical, int damage, int pip_conversion, String critical_school, String school_damage1, String school_damage2, String pip_gain, String school, Socket socket1)
  {
    super(name); 
    this.block = block; 
    this.pierce = pierce; 
    this.critical = critical; 
    this.damage = damage; 
    this.pip_conversion = pip_conversion; 
    this.critical_school = critical_school;
    this.school_damage1 = school_damage1; 
    this.school_damage2 = school_damage2; 
    this.pip_gain = pip_gain; 
    this.school = school; 
    this.socket1 = socket1; 
  }

  public int getBlock()
  {
    return block; 
  }

  public int getPierce()
  {
    return pierce; 
  }

  public int getCritical()
  {
    return critical; 
  }

  public int getDamage()
  {
    return damage; 
  }

  public int getPipConversion()
  {
    return pip_conversion; 
  }

  public String getCriticalSchool()
  {
    return critical_school; 
  }

  public String schoolDamage1()
  {
    return school_damage1; 
  }

  public String schoolDamage2()
  {
    return school_damage2; 
  }

  public String getPipGain()
  {
    return pip_gain; 
  }

  public String getSchool()
  {
    return school; 
  }

  public Socket getSocket1()
  {
    return socket1; 
  }

  @Override
  public void statsInformation() {
    System.out.println("Here is the following information about the hat chosen."); 
    System.out.println("Block: " + block); 
    System.out.println("Pierce: " + pierce); 
    System.out.println("Critical: " + critical);
    System.out.println("Damage: " + damage); 
    System.out.println("Pip conversion: " + pip_conversion); 
    System.out.println("Critical school: " + critical_school); 
    System.out.println("School Damage 1: " + school_damage1);
    System.out.println("School Damage 2: " + school_damage2); 
    System.out.println("Pip Gain: " + pip_gain); 
    System.out.println("School: " + school); 
    System.out.println("Socket 1: " + socket1.getDescription()); 
  }



  
}
