package Gear;

import Pets.Pet;

public class Gear {

  private Hat hat; 
  private Robe robe; 
  private Boot boot; 
  private Wand wand; 
  private Athame athame; 
  private Amulet amulet; 
  private Ring ring; 
  private Deck deck; 
  private Pet pet; 

  public Gear()
  {
    System.out.println("Calcuating final stats. Please be patient.");
    calculateFinalStats(); 
  }

  public Gear(Hat hat, Robe robe, Boot boot, Wand wand, Athame athame, Amulet amulet, Ring ring, Deck deck, Pet pet)
  {
    this.hat = hat; 
    this.robe = robe; 
    this.boot = boot; 
    this.wand = wand; 
    this.athame = athame; 
    this.amulet = amulet; 
    this.ring = ring; 
    this.deck = deck; 
    this.pet = pet; 
  }

  public Hat retrieveHat()
  {
    return hat; 
  }

  public Robe retrieveRobe()
  {
    return robe; 
  }

  public Boot retrieveBoot()
  {
    return boot; 
  }

  public Wand retrieveWand()
  {
    return wand; 
  }

  public Athame retrieveAthame()
  {
    return athame; 
  }

  public Amulet retrieveAmulet()
  {
    return amulet; 
  }

  public Ring retrieveRing()
  {
    return ring; 
  }

  public Deck retrieveDeck()
  {
    return deck; 
  }

  public Pet retrievePet()
  {
    return pet; 
  }

  public String toString()
  {
    return this.hat.name + "," + this.robe.name + "," + this.boot.name + "," + this.wand.name + "," + this.athame.name + "," + this.amulet.name + "," + this.ring.name + "," + this.deck.name; 
  }

  public void calculateFinalStats()
  {
    System.out.println("Here are the final stats of the gear."); 
    int damage = Hat.damage + Robe.damage + Boot.damage + Wand.damage + Athame.damage + Ring.damage; 
    int resist = Hat.resist + Robe.resist + Boot.resist + Amulet.resist; 
    int accuracy = Hat.accuracy + Robe.accuracy + Boot.accuracy; 
    int critical = Hat.critical + Robe.critical + Boot.critical + Wand.critical + Ring.critical + Deck.critical; 
    int block = Hat.block + Robe.block + Boot.block + Wand.block + Athame.block + Amulet.block + Deck.block; 
    int power_pip = Hat.power_pip + Robe.power_pip + Boot.power_pip + Athame.power_pip + Ring.power_pip; 

    System.out.println("Final damage: " + damage); 
    System.out.println("Final resist: " + resist); 
    System.out.println("Final accuracy: " + accuracy);
    System.out.println("Final critical: " + critical);
    System.out.println("Final block: " + block); 
    System.out.println("Final power_pip: " + power_pip); 

  }

}
