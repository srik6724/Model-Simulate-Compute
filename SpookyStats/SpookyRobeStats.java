package SpookyStats;

import Healing.Healing;
import ItemCards.ItemCard;

public class SpookyRobeStats {
  
  private String name; 
  private int health;
  private int power_pip;
  private int shadowRating;
  private int accuracy; 
  private int block; 
  private int resist; 
  private Healing healing; 
  private ItemCard card; 

  public SpookyRobeStats(String name, int health, int power_pip, int shadowRating, int accuracy, int block, int resist, Healing healing, ItemCard card)
  {
    this.name = name; 
    this.health = health; 
    this.power_pip = power_pip; 
    this.shadowRating = shadowRating; 
    this.accuracy = accuracy; 
    this.block = block; 
    this.resist = resist; 
    this.healing = healing; 
    this.card = card; 
  }

  public String getName()
  {
    return name; 
  }

  public int getHealth()
  {
    return health; 
  }

  public int getPowerPip()
  {
    return power_pip;
  }

  public int getShadowRating()
  {
    return shadowRating; 
  }

  public int getAccuracy()
  {
    return accuracy; 
  }

  public int getBlock()
  {
    return block; 
  }

  public int getResist()
  {
    return resist; 
  }

  public Healing getHealing()
  {
    return healing; 
  }

  public ItemCard getCard()
  {
    return card; 
  }
}
