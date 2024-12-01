package Product_Process;

import java.util.HashMap;

import Mechanisms.Type_Set;


interface Type_Spell {
  int[] configureInUseToEnd = new int[2]; 
  
  static void startToFinish(String type_of_spell) {
  
    int numberEntry = Type_Set.getUniqueSpellsTypeCount().get(type_of_spell); 
    String dataEntry = String.valueOf(numberEntry); 
    int firstValue = Integer.parseInt(dataEntry.substring(0,1)); 
    configureInUseToEnd[0] = firstValue; 
    int secondValue = Integer.parseInt(dataEntry.substring(1)); 
    configureInUseToEnd[1] = secondValue; 

    String modifiedDataEntry = String.valueOf(++firstValue) + String.valueOf(secondValue); 
    Type_Set.getUniqueSpellsTypeCount().put(type_of_spell, Integer.parseInt(modifiedDataEntry)); 
  }
}
