package Pets;

import java.util.Arrays;

public class Talent {
  private String name; 
  private String description; 
  private static int countTalents; 
  private Talent talent; 

  public Talent(String name, String description)
  {
    Talent.countTalents += 1; 
    if(Talent.countTalents > 5)
    {
      System.out.println("Maximum number of talents that can only be added is " + Talent.countTalents); 
      Talent.countTalents = 0; 
      System.out.println("Note that you can also add a star socket to your pet, but that isn't part of your 5 talents."); 
    }
    this.name = name; 
    this.description = description; 
    
    Pet.petTalents.put(Talent.countTalents, Arrays.asList(talent));
    System.out.println("Talent of " + this.name + "," +  this.description + " added."); 
  }
}
