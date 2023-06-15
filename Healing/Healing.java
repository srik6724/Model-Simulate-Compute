package Healing;

public class Healing {
  
  private String type; 
  private int amount; 

  public Healing(String type, int amount)
  {
    this.type = type; 
    this.amount = amount; 
  }

  public String getType()
  {
    return type; 
  }

  public int getAmount()
  {
    return amount; 
  }
}
