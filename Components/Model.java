package Components;

import Customizations.Pet;

public class Model {

  private Bind_1 hat; 
  private Bind_2 robe; 
  private Bind_3 boot; 
  private Bind_4 wand; 
  private Bind_5 athame; 
  private Bind_6 amulet; 
  private Bind_7 ring; 
  private Bind_8 deck; 
  private Pet pet; 

  public Model(Bind_1 hat, Bind_2 robe, Bind_3 boot, Bind_4 wand, Bind_5 athame, Bind_6 amulet, Bind_7 ring, Bind_8 deck, Pet pet)
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

  public Bind_1 retrieveHat()
  {
    return hat; 
  }

  public Bind_2 retrieveRobe()
  {
    return robe; 
  }

  public Bind_3 retrieveBoot()
  {
    return boot; 
  }

  public Bind_4 retrieveWand()
  {
    return wand; 
  }

  public Bind_5 retrieveAthame()
  {
    return athame; 
  }

  public Bind_6 retrieveAmulet()
  {
    return amulet; 
  }

  public Bind_7 retrieveRing()
  {
    return ring; 
  }

  public Bind_8 retrieveDeck()
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
