package Object_Types_Parser;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.Stack;
import java.util.Vector;

import Collections.Type_Set;
import Data_Structures.Object_Types.Element;
import Object_Types_Parser.Token.TokenType;

public class LexicalAnalyzer {
  int index; 
  static boolean first_iteration = false; 
  private String description_of_spell = ""; 
  private int line_counter = 0; 
  private List<Token> token_list = new ArrayList<Token>(); 
  private Set<StringBuilder> types = Type_Set.getTypes(); 
  private File[] files = new File[types.size()]; 
  private FileWriter type_writer; 
  private FileWriter general_writer; 
  private Token tmp = new Token(); 

  public LexicalAnalyzer(List<String> inputLines) throws IOException
  {
    System.out.println("Looping through types defined by Type_Set implementation"); 
    int fIndex = 0; 
    general_writer = new FileWriter(new File("token_list_full_types_representation.txt")); 
    for(StringBuilder c: types) {
      // tokens list corresponding to spell (apply filter by type of spell)
      // Examples: token_list_
      String type_representation = c.toString().toLowerCase();
      System.out.println("Type_Set type: " + type_representation); 
      files[fIndex] = new File("token_list_" + type_representation + ".txt");  
    }
    System.out.println("Input Lines Length: " + inputLines.size()); 

    List<String> testLines = new ArrayList<String>(); 

    for(String line: inputLines)
    {
      testLines.add(line); 
    }

    //Initializes initial token to empty with token_type as ERROR
    tmp.lexeme = ""; 
    tmp.token_type = TokenType.ERROR; 

    while(tmp.token_type != TokenType.END_OF_FILE)
    { 
      System.out.println("Test Lines Length: " + testLines.size()); 

      if(testLines.size() > 0) {
        setTokenDefs(testLines.get(0));

        for(String line: testLines)
        {
          testLines.remove(line); 
          break;
        }
      }
      else {
        tmp.lexeme = ""; 
        tmp.token_type = TokenType.END_OF_FILE;
      }
    }
    token_list.add(tmp); 

    System.out.println("Finished parsing input lines and creating tokens."); 
    System.out.println("Token List Size: " + token_list.size()); 
    for(Token get_token: token_list) {
      System.out.println("Lexeme of token: "  + get_token.lexeme);
      System.out.println("TokenType of token: " + get_token.token_type); 
    } 
  }

  void token_def(String line)
  {
    // Take a line, analyze it and place the necessary words inside the input buffer
    InputBuffer buffer = new InputBuffer(line); 
    // Get the Input Buffer
    Vector<String> inputBuffer = buffer.get_input_buffer();
    // Popping element_name from the stack
    int vector_index = 0; 
    String line_descriptor = ""; 
    boolean first_iteration_action_verb = true; 
    boolean second_iteration_spell_occurrence = false; 
    System.out.println("Input Buffer Size: " + inputBuffer.size()); 
    List<Object> descriptionAnnotations = new ArrayList<Object>(); 
    Token token; 
    while(inputBuffer.size() > 0) {
      String element = inputBuffer.get(vector_index); 
      System.out.println("Element: " + element);
      if(element.equals("BALANCE")) {
        token = new Token(); 
        token.lexeme = ""; 
        token.token_type = TokenType.BALANCE; 
        token_list.add(token); 
      }
      else if(element.equals("LIFE")) {
        token = new Token(); 
        token.lexeme = ""; 
        token.token_type = TokenType.LIFE; 
        token_list.add(token); 
      }
      else if(element.equals("DEATH")) {
        token = new Token(); 
        token.lexeme = ""; 
        token.token_type = TokenType.DEATH; 
        token_list.add(token); 
      }
      else if(element.equals("ICE")) {
        token = new Token(); 
        token.lexeme = ""; 
        token.token_type = TokenType.ICE; 
        token_list.add(token); 
      }
      else if(element.equals("FIRE")) {
        token = new Token(); 
        token.lexeme = ""; 
        token.token_type = TokenType.FIRE; 
        token_list.add(token); 
      }
      else if(element.equals("STORM")) {
        token = new Token(); 
        token.lexeme = ""; 
        token.token_type = TokenType.STORM; 
        token_list.add(token); 
      }
      else if(element.equals("MYTH")) {
        token = new Token(); 
        token.lexeme = ""; 
        token.token_type = TokenType.MYTH; 
        token_list.add(token); 
      }
      else if(element.equals("DECK")) {
        token = new Token(); 
        token.lexeme = ""; 
        token.token_type = TokenType.DECK; 
        token_list.add(token); 
      }
      else if(element.equals("Spell")) {
        line_descriptor += element; 
        System.out.println("LINE DESCRIPTOR FOR SPELL: " + line_descriptor); 
        if(second_iteration_spell_occurrence) {
          line_descriptor += ": "; 
          second_iteration_spell_occurrence = false; 
        }
      }
      else if(element.equals("Name")) {
        line_descriptor += " "; 
        line_descriptor += element; 
        line_descriptor += ": "; 
      }
      else if(element.equals("Description")) {
        line_descriptor += element; 
        line_descriptor += ": "; 
      }
      else if(element.equals("Pip")) {
        line_descriptor += element;
        line_descriptor += " ";
      }
      else if(element.equals("Chance")) {
        line_descriptor += element; 
      }
      else if(element.equals("Pips")){
        line_descriptor += element;
      }
      else if(element.equals("School")) {
        line_descriptor += element;
      }
      else if(element.contains("Type")) {
        System.out.println("Line Descriptor for Type: " + line_descriptor); 
        line_descriptor += element;
        line_descriptor += " "; 
      }
      else if(element.contains("Of")) {
        System.out.println("Line Descriptor for Of: " + line_descriptor); 
        line_descriptor += element; 
        line_descriptor += " "; 
        second_iteration_spell_occurrence = true; 
      }
      else if(!element.isEmpty()) {
        if(line_descriptor.contains("Spell Name: "))  {
          if(inputBuffer.size() == 1) {
            line_descriptor += element; 
            line_descriptor = line_descriptor.replace("Spell Name: ", ""); 
            token = new Token(); 
            token.lexeme = line_descriptor; 
            token.token_type = TokenType.SPELL;
            token_list.add(token); 
            line_descriptor = ""; 
          }
          else {
            line_descriptor += element;
            line_descriptor += " "; 
          }
        }
        else if(line_descriptor.contains("Description: ")) {
            System.out.println("Line Descriptor for Description every iteration: " + line_descriptor); 
            if(first_iteration_action_verb) {
              if(element.equals("PvP") || element.equals("Only")) {
                first_iteration_action_verb = false; 
                continue; 
              }
              token = new Token(); 
              token.lexeme = element; 
              descriptionAnnotations.add(token.lexeme); 
              first_iteration_action_verb = false; 
              token.token_type = TokenType.ACTION; 
              token_list.add(token); 
              continue; 
            }
            try {
              Integer parsedValue = Integer.parseInt(element); 
              if(parsedValue instanceof Integer) {
                System.out.println("Found the number: " + parsedValue); 
                System.out.println("Setting the token type now.");
                token = new Token(); 
                token.lexeme = element; 
                descriptionAnnotations.add(token.lexeme); 
                token.token_type = TokenType.NUM; 
                token_list.add(token); 
              }
            }catch(Exception e) {
              System.out.println("The element: " + element + " is not a number."); 
            }
            if(element.toLowerCase().contains("enemy") || element.toLowerCase().contains("self")) {
              System.out.println("Element: " + element.toLowerCase());
              for(char c: element.toCharArray()) {
                if(c == 'e' || c == 'n' || c == 'm' || c == 'y' || c == 's' || c == 'l' || c == 'f') {
                  continue;
                } else {
                  element = element.replace(Character.toString(c), "");
                }
              }
              //#####################################//
             //String stmt = line_descriptor; 
              //int firstSpaceIndex = stmt.indexOf(" "); 
              //String firstWord = stmt.substring(0, firstSpaceIndex);
              //stmt = stmt.replace(firstWord, ""); 
              //String descriptiveNoun = stmt; 
              //descriptionAnnotations.add(descriptiveNoun); 
              //Action action = new Action(descriptionAnnotations.get(0).toString(), Integer.parseInt(descriptionAnnotations.get(1).toString()), descriptionAnnotations.get(3).toString(), descriptionAnnotations.get(2).toString());
              //action.curr_info();
              //#####################################//
              token = new Token(); 
              token.lexeme = element; 
              token.token_type = TokenType.TARGET; 
              token_list.add(token); 
              descriptionAnnotations.add(token.lexeme); 
              token = new Token(); 
              String stmt = line_descriptor; 
              stmt = stmt.replace("Description: ", "");
              int firstSpaceIndex = stmt.indexOf(" "); 
              String firstWord = stmt.substring(0, firstSpaceIndex);
              stmt = stmt.replace(firstWord, "");
              stmt = stmt.replace(element, ""); 
              token.lexeme = stmt;
              token.token_type = TokenType.STMT; 
              token_list.add(token); 
              line_descriptor = "Description: "; 
              first_iteration_action_verb = true; 
              inputBuffer.remove(element); 
              descriptionAnnotations.add(token.lexeme); 
              try {
                String nextElement = inputBuffer.get(vector_index);
                inputBuffer.remove(nextElement); 
                continue; 
              } catch (Exception e) { 
                System.out.println("No preposition words contained -> parsed description done.");
                continue; 
              }
            }
            else if(inputBuffer.size() == 1) {
              if(element.equals("Only") || element.equals("PvP")) {
                System.out.println("Done parsing description");
                inputBuffer.remove(element);
                continue; 
              }
              token = new Token(); 
              token.lexeme = "self"; 
              token.token_type = TokenType.TARGET; 
              descriptionAnnotations.add(token.lexeme); 
              token_list.add(token); 
              //#####################################//
              line_descriptor += element; 
              String stmt = line_descriptor; 
              stmt = stmt.replace("Description: ", "");
              //int firstSpaceIndex = stmt.indexOf(" "); 
              //String firstWord = stmt.substring(0, firstSpaceIndex);
              //stmt = stmt.replace(firstWord, ""); 
              //String descriptiveNoun = stmt; 
              //System.out.println("Descriptive Noun:" + descriptiveNoun);
              //descriptionAnnotations.add(descriptiveNoun); 
              // Action action = new Action(descriptionAnnotations.get(0).toString(), Integer.parseInt(descriptionAnnotations.get(1).toString()), descriptionAnnotations.get(3).toString(), descriptionAnnotations.get(2).toString()); 
              // action.curr_info();
              // [Player] [TEAM_NO] casts [SPELL_NAME] = [ACTION_VERB] 1 stun effect on [TARGET] ... [ACTION_VERB] 1 stun effect on [TARGET] # (ROUND 1)  
              // [Travis Waterblood] [TEAM_1] casts [Stun Block] = [resist] 1 stun effect on [self] [Travis Waterblood] [TEAM_1] ... [resist] 1 stun effect on [self] [Travis Waterblood] [TEAM_1] # (ROUND 1)
              // [Travis Waterblood] [TEAM_2] casts [Satyr] = [heal] 1 health on self ... [heal] 2 health on self ... [heal] 3 health on self ... ... [heal] 860 health on self # (ROUND 1)
              // [Travis Waterblood] [TEAM_1] casts [Fire Dragon] = [flame] 540 damage + 635 overtime damage on [enemy] [Blake Sparkleforge] [TEAM_2] ... [flame] 540 + 635 damage on [enemy] [Paul Duskglade] [TEAM_2] ... [flame] 540 + 635 damage on [enemy] [Paul Shadow] [TEAM_2] ... [flame] 540 + 635 damage on [enemy] [Travis Waterblood] [TEAM_2] # (ROUND 1)
              //#####################################//
              token = new Token(); 
              line_descriptor = line_descriptor.replace("Description: ", "");
              int firstSpaceIndex = stmt.indexOf(" "); 
              String firstWord = stmt.substring(0, firstSpaceIndex);
              line_descriptor = line_descriptor.replace(firstWord, "");
              token.lexeme = line_descriptor; 
              System.out.println("TOKEN LEXEME FOR DESCRIPTION: " + token.lexeme); 
              token.token_type = TokenType.STMT; 
              token_list.add(token);
              System.out.println("TOKEN TYPE FOR DESCRIPTION: " + token.token_type);
              description_of_spell = token.lexeme; 
              inputBuffer.remove(element); 
              System.out.println("Parsed the description."); 
              continue; 
            }
            line_descriptor += element;
            line_descriptor += " "; 
        }
        else if(line_descriptor.equals("Pip Chance")) {
          System.out.println("Pip Chance Here: " + line_descriptor); 
          line_descriptor += ": "; 
          if(element.contains("%")) {
            System.out.println("Pip Chance finished decoding."); 
            line_descriptor += element; 
            token = new Token(); 
            System.out.println("Line Descriptor for Pip Chance: " + line_descriptor);
            line_descriptor = line_descriptor.replace("Pip Chance: ", "");
            line_descriptor = line_descriptor.replace("%", "");
            token.lexeme = line_descriptor;
            token.token_type = TokenType.PERCENTAGE; 
            token_list.add(token); 
            line_descriptor = ""; 
          }
        }
        else if(line_descriptor.equals("Pips")) {
          System.out.println("Pips Here: " + line_descriptor);
          line_descriptor += ": "; 
          if(Integer.valueOf(Integer.parseInt(element)) instanceof Integer) {
            System.out.println("Pips of Spell finished decoding."); 
            line_descriptor += element;
            System.out.println("Final Line Descriptor: " + line_descriptor); 
            if(element.equals("0")) {
              token = new Token(); 
              line_descriptor = line_descriptor.replace("Pips: ", "");
              token.lexeme = line_descriptor;
              token.token_type = TokenType.ZERO; 
              token_list.add(token); 
            }
            else if(element.equals("1")) {
              token = new Token(); 
              line_descriptor = line_descriptor.replace("Pips: ", "");
              token.lexeme = line_descriptor;
              token.token_type = TokenType.ONE; 
              token_list.add(token); 
            }
            else if(element.equals("2")) {
              token = new Token(); 
              line_descriptor = line_descriptor.replace("Pips: ", "");
              token.lexeme = line_descriptor;
              token.token_type = TokenType.TWO; 
              token_list.add(token);
            }
            else if(element.equals("3")) {
              token = new Token(); 
              line_descriptor = line_descriptor.replace("Pips: ", "");
              token.lexeme = line_descriptor;
              token.token_type = TokenType.THREE;
              token_list.add(token); 
            }
            else if(element.equals("4")) {
              token = new Token(); 
              line_descriptor = line_descriptor.replace("Pips: ", "");
              token.lexeme = line_descriptor;
              token.token_type = TokenType.FOUR;
              token_list.add(token); 
            }
            else if(element.equals("5")) {
              token = new Token(); 
              line_descriptor = line_descriptor.replace("Pips: ", "");
              token.lexeme = line_descriptor;
              token.token_type = TokenType.FIVE;
              token_list.add(token); 
            }
            else if(element.equals("6")) {
              token = new Token(); 
              line_descriptor = line_descriptor.replace("Pips: ", "");
              token.lexeme = line_descriptor;
              token.token_type = TokenType.SIX;
              token_list.add(token); 
            } 
            else if(element.equals("7")) {
              token = new Token(); 
              line_descriptor = line_descriptor.replace("Pips: ", "");
              token.lexeme = line_descriptor;
              token.token_type = TokenType.SEVEN;
              token_list.add(token); 
            }
            else if(element.equals("8")) {
              token = new Token(); 
              line_descriptor = line_descriptor.replace("Pips: ", "");
              token.lexeme = line_descriptor;
              token.token_type = TokenType.EIGHT;
              token_list.add(token); 
            }
            else if(element.equals("9")) {
              token = new Token(); 
              line_descriptor = line_descriptor.replace("Pips: ", "");
              token.lexeme = line_descriptor;
              token.token_type = TokenType.NINE;
              token_list.add(token); 
            }
            else if(element.equals("10")) {
              token = new Token(); 
              line_descriptor = line_descriptor.replace("Pips: ", "");
              token.lexeme = line_descriptor;
              token.token_type = TokenType.TEN;
              token_list.add(token); 
            } 
            else if(element.equals("11")) {
              token = new Token(); 
              line_descriptor = line_descriptor.replace("Pips: ", "");
              token.lexeme = line_descriptor;
              token.token_type = TokenType.ELEVEN;
              token_list.add(token); 
            }
            else if(element.equals("12")) {
              token = new Token(); 
              line_descriptor = line_descriptor.replace("Pips: ", "");
              token.lexeme = line_descriptor;
              token.token_type = TokenType.TWELVE;
              token_list.add(token); 
            }
            else if(element.equals("13")) {
              token = new Token(); 
              line_descriptor = line_descriptor.replace("Pips: ", "");
              token.lexeme = line_descriptor;
              token.token_type = TokenType.THIRTEEN;
              token_list.add(token); 
            }
            else if(element.equals("X")) {
              token = new Token(); 
              line_descriptor = line_descriptor.replace("Pips: ", "");
              token.lexeme = line_descriptor;
              token.token_type = TokenType.X;
              token_list.add(token); 
            }
          }
        }
        else if(line_descriptor.contains("Type Of Spell: ")) {
          line_descriptor += element; 
          if(element.contains("Attack") || element.equals("Hit")){
            tmp.lexeme = element; 
            tmp.token_type = TokenType.ATTACK; 
            // parse the description
            for(String word: description_of_spell.split(" ")) {
              System.out.println("Word Inside Description for Attack Spell: " + word); 
            }
          }
          else if(element.contains("Trap") || element.contains("Blade") || element.contains("Utility") || element.contains("Shield") || element.contains("Weakness") || element.contains("Dispel") || element.contains("Bubble")) {
            tmp.lexeme = element; 
            tmp.token_type  = TokenType.UTILITY; 
            // parse the description
            for(String word: description_of_spell.split(" ")) {
              System.out.println("Word Inside Description for Utility Spell: " + word); 
            }
          }
          else if(element.equals("Heal")) {
            tmp.lexeme = element; 
            tmp.token_type = TokenType.REGENERATION; 
            // parse the description
            for(String word: description_of_spell.split(" ")) {
              System.out.println("Word Inside Description for Healing Spell: " + word);
            }
          }
          /*for(File f: files) {
            try {
              String fileName = f.getName(); 
              System.out.println("File Name: " + fileName); 
              System.out.println("Element: " + element); 
              if(fileName.contains(element.toLowerCase())) {
                type_writer = new FileWriter(f); 
                type_writer.write("TOKENS REPRESENTATION FOR TYPE OF SPELL: " + element + "\n"); 
                for(Token t: token_list) {
                  type_writer.write(t.lexeme + "," + t.token_type + "\n"); 
                }
                type_writer.write("END OF TOKENS REPRESENTATION FOR TYPE OF SPELL: " + element + "\n"); 
                type_writer.close(); 
              }
            } catch (Exception e) {
              System.out.println("Match from fileName to element could not be detected.");
              e.printStackTrace(); 
            }
          }*/
          System.out.println("Type Of Spell finished decoding.");
        }
      }
      inputBuffer.remove(element); 
      System.out.println("InputBuffer Size before next iteration: " + inputBuffer.size()); 
    }
    System.out.println("TOKEN_LIST SIZE: " + token_list.size()); 
    try {
      general_writer.write("TOKEN DEFINITIONS LIST\n");
      for(Token t: token_list) {
        general_writer.write("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n"); 
        general_writer.write("Token Lexeme: " + t.lexeme.toUpperCase() + "\n"); 
        general_writer.write("TokenType Of Token: " + t.token_type + "\n"); 
      }
      general_writer.write("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n"); 
      general_writer.write("TOKEN DEFINITIONS END\n");
      general_writer.write("############################################\n");
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  void setTokenDefs(String line) throws IOException
  {
    line_counter++; 
    System.out.println("Line Read Here: " + line); 
    token_def(line); 
    if(line_counter == 50) {
      general_writer.close();
      System.exit(0); 
    }
  }

  List<Token> get_token_list() {
    return token_list;
  }
}
