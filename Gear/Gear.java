package Gear;

import Customizations.Pet;

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
    return this.hat.getName() + "," + this.robe.getName() + "," + this.boot.getName() + "," + this.wand.getName() + "," + this.athame.getName() + "," + this.amulet.getName() + "," + this.ring.getName() + "," + this.deck.getName() + "," + pet.getPetName(); 
  }

  public void calculateFinalStats(String wizardName, int damage, int resist, int accuracy, int critical, int block, int power_pip)
  {
    System.out.println("Here are the final stats of the gear for wizard " + wizardName); 
    System.out.println("Final damage: " + damage); 
    System.out.println("Final resist: " + resist); 
    System.out.println("Final accuracy: " + accuracy);
    System.out.println("Final critical: " + critical);
    System.out.println("Final block: " + block); 
    System.out.println("Final power_pip: " + power_pip); 

  }

}
