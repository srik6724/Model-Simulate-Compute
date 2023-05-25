package Pets;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Pet {

private String typeName; 
private HashMap<Integer, List<String>> petTalents = new HashMap<Integer, List<String>>(); 


public Pet()
{
  System.out.println("Pet Type: " + typeName);
  int talentNumber = 1; 
  for(Integer number: petTalents.keySet())
  {
    String getTalent = petTalents.get(number).get(0); 
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



/**
 * Pet attributes: 
 * Name
 * Talents(5 Talents)
 * Socketed Talent
 */

}

