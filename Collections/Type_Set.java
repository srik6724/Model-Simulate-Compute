package Collections;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import Data_Structures.Object_Types.Element;

public class Type_Set {
  /*
   * Set for storage of unique type spell definitions
   */
  private static Set<StringBuilder> types; 
  private static Map<String, Integer> UNIQUE_SPELL_TYPES_COUNT; 
  
  private Type_Set() {
    if(Type_Set.types == null) {
      types = new HashSet<StringBuilder>(); 
      UNIQUE_SPELL_TYPES_COUNT = new HashMap<String, Integer>(); 
    }
  }

  public Type_Set(String[] types) {
    this(); 
    this.insertType(types[0]); 
  }

  public void insertType(String type) {
    if(!(types.contains(new StringBuilder(type)))) {
      types.add(new StringBuilder(type)); 
    }
    System.out.println("Added type: " + type + " to " + Type_Set.class);
  }

  public static void initialize(String type, Element e) throws IOException {
    System.out.println("Fixed type of 1 by 1 insertion starting from initialize"); 
    String[] typeDefs = new String[1]; 
    typeDefs[0] = type;
    new Type_Set(typeDefs); 
    System.out.println("Creating file entry for type: " + type); 
    File file;
    String fileName = "category_type_" + type.toLowerCase() + ".txt";
		Path directory = Paths.get("C:/Users/srik6/OneDrive/Desktop/Match (Model, Simulate, Compute)");
    Path filePath = directory.resolve(fileName); 
    FileWriter file_writer; 
    if(!(Files.exists(filePath))) {
      file = new File(fileName);
      file_writer = new FileWriter(file); 
      file_writer.write("CATEGORY TYPE: " + type); 
      file_writer.write("-----------------------------------"); 
      file_writer.write("Spell Name:" + e.getSpellName()); 
      file_writer.write("Count: " + e.getCount()); 
      file_writer.write("Description: " + e.getDescription());
      file_writer.write("Pip Chance: " + e.getPipChance()); 
      file_writer.write("Pips: " + e.getPips()); 
      file_writer.write("School: " + e.getSchool()); 
      file_writer.write("Type Of Spell: " + e.getTypeSpell());
      Type_Set.UNIQUE_SPELL_TYPES_COUNT.put(e.getTypeSpell(), 11); 
      System.out.println("INITIAL PLACEMENT: " + UNIQUE_SPELL_TYPES_COUNT.get(e.getTypeSpell())); 
    }
    else {
      String objectContainer = "-----------------------------------\n"
                              + "Spell Name: " + e.getSpellName() + "\n"
                              + "Count: " + e.getCount() + "\n"
                              + "Description: " + e.getDescription() + "\n"
                              + "Pip Chance: " + e.getPipChance() + "\n"
                              + "Pips: " + e.getPips() + "\n"
                              + "School: " + e.getSchool() + "\n"
                              + "Type Of Spell: " + e.getTypeSpell() + "\n";
      Files.write(filePath, objectContainer.getBytes(StandardCharsets.UTF_8), StandardOpenOption.APPEND); 
      int count = UNIQUE_SPELL_TYPES_COUNT.get(e.getTypeSpell());
      System.out.println("COUNT RETRIEVAL: " + count); 
      String numberWord = String.valueOf(count); 
      System.out.println("NUMBER WORD: " + numberWord); 
      String digitWordForm = numberWord.substring(1); 
      System.out.println("DIGIT WORD FORM: " + digitWordForm); 
      int numberCount = Integer.parseInt(digitWordForm); 
      numberCount++; 
      String modifiedNumberWord = numberWord.substring(0,1) + numberCount;
      System.out.println("MODIFIED NUMBER WORD: " + modifiedNumberWord);
      Type_Set.UNIQUE_SPELL_TYPES_COUNT.put(e.getTypeSpell(), Integer.parseInt(modifiedNumberWord));
    }
  }

  public static Set<StringBuilder> getTypes() {
    return Type_Set.types; 
  }

  public static Map<String, Integer> getUniqueSpellsTypeCount() {
    return Type_Set.UNIQUE_SPELL_TYPES_COUNT;
  }

}
