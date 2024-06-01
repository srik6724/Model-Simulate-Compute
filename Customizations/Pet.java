package Customizations;

import java.util.HashMap;
import java.util.List;

public class Pet {

private String nameOfPet; 
public static String typeName; 
public static String school;
protected static HashMap<Integer, List<Talent>> petTalents = new HashMap<Integer, List<Talent>>(); 

public Pet()
{
  if(Pet.typeName != null && Pet.school != null)
  {
    System.out.println("Pet Type: " + Pet.typeName);
    System.out.println("Pet school: " + Pet.school); 
  }
  int talentNumber = 1; 
  for(Integer number: petTalents.keySet())
  {
    Talent getTalent = petTalents.get(number).get(0); 
    talentNumber = talentNumber + 1; 
    if(talentNumber == 6 && number == 6)
    {
      System.out.println("Socketed Talent Name: " + talentNumber + " " + getTalent);
      System.out.println("Socketed Talent Description: " + petTalents.get(number).get(1)); 
    }
    else 
    {
      System.out.println("Talent Name: " + talentNumber + " " + getTalent); 
      System.out.println("Talent Description: " + petTalents.get(talentNumber).get(1));
    }
  }
  
}

public Pet(String petName)
{
  this(); 
  this.nameOfPet = petName;
  System.out.println("Name of Pet: " + this.nameOfPet);
}

public String getPetName()
{
  return nameOfPet;
}



}

