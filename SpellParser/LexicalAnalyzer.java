package SpellParser;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;
import java.util.Vector;

import SpellParser.Token.TokenType;
import dataStructures.Element;

public class LexicalAnalyzer {
  int index; 
  static boolean first_iteration = false; 
  private String description_of_spell = ""; 
  private String[] reserved_tokens = {"DECK", "SPELL", "LIFE", "DEATH", "BALANCE", "ICE", "MYTH", "FIRE", "STORM", 
                                      "ZERO", "ONE", "TWO", "THREE", "FOUR", "FIVE", "SIX", "SEVEN", 
                                      "EIGHT", "NINE", "TEN", "ELEVEN", "TWELVE", "THIRTEEN", "X", 
                                      "NUM", "ATTACK", "DEFENSE", "REGENERATION", "DAMAGE", "HEALING", 
                                      "SPELL_PERCENTAGE", "PERCENTAGE", "ACTION", "STMT", "TARGET", "ERROR", "END_OF_FILE"};
 
  private List<Token> token_list = new ArrayList<Token>(); 
  private Token tmp = new Token(); 

  public LexicalAnalyzer(List<String> inputLines) 
  {
    System.out.println("Input Lines Length: " + inputLines.size()); 
    List<String> testLines = new ArrayList<String>(); 

    for(String line: inputLines)
    {
      System.out.println("Line Description: " + line); 
      testLines.add(line); 
    }
    //Initializes initial token to empty with token_type as ERROR
    tmp.lexeme = ""; 
    tmp.token_type = TokenType.ERROR; 

    Token token = GetTokenMain(testLines.get(0)); 

    for(String line: testLines)
    {
      testLines.remove(line); 
      break;
    }
    index = 0; 

    while(token.token_type != TokenType.END_OF_FILE)
    { 
      if(testLines.size() > 0) {
        token = GetTokenMain(testLines.get(0));

        for(String line: testLines)
        {
          testLines.remove(line); 
          break;
        }
      }
    }
    token.lexeme = ""; 
    token.token_type = TokenType.END_OF_FILE;
    token_list.add(token); 

    System.out.println("Finished parsing input lines and creating tokens."); 
    System.out.println("Token List Size: " + token_list.size()); 
    for(Token get_token: token_list) {
      System.out.println("Lexeme of token: "  + get_token.lexeme);
      System.out.println("TokenType of token: " + get_token.token_type); 
    }
    
  }

  boolean SkipSpace(String line)
  {
    boolean ret = false; 
    // Take a line, analyze it and place the necessary words inside the input buffer
    InputBuffer buffer = new InputBuffer(line); 
    // Get the Input Buffer
    Vector<String> inputBuffer = buffer.get_input_buffer();
    // Popping element_name from the stack
    int vector_index = 0; 
    String line_descriptor = ""; 
    boolean first_iteration_action_verb = true; 
    boolean second_iteration_spell_occurrence = true; 
    System.out.println("Input Buffer Size: " + inputBuffer.size()); 
    while(inputBuffer.size() > 0) {
      String element = inputBuffer.get(vector_index); 
      System.out.println("Element: " + element);
      if(element.equals("BALANCE")) {
        tmp.lexeme = element; 
        tmp.token_type = TokenType.BALANCE; 
        token_list.add(tmp); 
      }
      else if(element.equals("LIFE")) {
        tmp.lexeme = element; 
        tmp.token_type = TokenType.LIFE; 
        token_list.add(tmp); 
      }
      else if(element.equals("DEATH")) {
        tmp.lexeme = element; 
        tmp.token_type = TokenType.DEATH; 
        token_list.add(tmp); 
      }
      else if(element.equals("ICE")) {
        tmp.lexeme = element; 
        tmp.token_type = TokenType.ICE; 
        token_list.add(tmp); 
      }
      else if(element.equals("FIRE")) {
        tmp.lexeme = element; 
        tmp.token_type = TokenType.FIRE; 
        token_list.add(tmp); 
      }
      else if(element.equals("STORM")) {
        tmp.lexeme = element; 
        tmp.token_type = TokenType.STORM; 
        token_list.add(tmp); 
      }
      else if(element.equals("MYTH")) {
        tmp.lexeme = element; 
        tmp.token_type = TokenType.MYTH; 
        token_list.add(tmp); 
      }
      else if(element.equals("DECK")) {
        tmp.lexeme = element; 
        tmp.token_type = TokenType.DECK; 
        token_list.add(tmp); 
      }
      else if(element.equals("Spell")) {
        line_descriptor += element; 
        System.out.println("Line Descriptor for Spell: " + line_descriptor); 
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
      }
      else if(!element.isEmpty()) {
        if(line_descriptor.contains("Spell Name: "))  {
          if(inputBuffer.size() == 1) {
            line_descriptor += element; 
            tmp.lexeme = line_descriptor; 
            tmp.token_type = TokenType.SPELL;
            token_list.add(tmp); 
            line_descriptor = ""; 
          }
          else {
            line_descriptor += element;
            line_descriptor += " "; 
          }
        }
        else if(line_descriptor.contains("Description: ")) {
            System.out.println("Line Descriptor for Description every iteration: " + line_descriptor); 
            Token t = new Token(); 

            if(first_iteration_action_verb) {
              t.lexeme = element; 
              first_iteration_action_verb = false; 
              t.token_type = TokenType.ACTION; 
              token_list.add(t); 
              continue; 
            }
            try {
              Integer parsedValue = Integer.parseInt(element); 
              if(parsedValue instanceof Integer) {
                System.out.println("Found the number: " + parsedValue); 
                System.out.println("Setting the token type now.");
                t.lexeme = element; 
                t.token_type = TokenType.NUM; 
                token_list.add(t); 
              }
            }catch(Exception e) {
              System.out.println("The element: " + element + " is not a number."); 
            }
            if(element.toLowerCase().equals("enemy") || element.toLowerCase().equals("self")) {
              t.lexeme = element; 
              t.token_type = TokenType.TARGET; 
              token_list.add(t); 
            }
            if(inputBuffer.size() == 1) {
              t.lexeme = "self"; 
              t.token_type = TokenType.TARGET; 
              token_list.add(t); 
              line_descriptor += element; 
              t.lexeme = line_descriptor; 
              t.token_type = TokenType.STMT; 
              description_of_spell = t.lexeme;
              System.out.println("Parsed the description."); 
              inputBuffer.remove(element); 
              continue;
            }
            line_descriptor += element;
            line_descriptor += " "; 
        }
        else if(line_descriptor.equals("Pip Chance")) {
          line_descriptor += ": "; 
          if(element.contains("%")) {
            System.out.println("Pip Chance finished decoding."); 
            line_descriptor += element; 
            tmp.token_type = TokenType.SPELL_PERCENTAGE; 
            token_list.add(tmp); 
            line_descriptor = ""; 
          }
        }
        else if(line_descriptor.equals("Pips")) {
          line_descriptor += ": "; 
          if(Integer.valueOf(Integer.parseInt(element)) instanceof Integer){
            System.out.println("Pips of Spell finished decoding."); 
            line_descriptor += element;
            System.out.println("Final Line Descriptor: " + line_descriptor); 
            tmp.lexeme = line_descriptor; 
            if(element == "0") {
              tmp.token_type = TokenType.ZERO; 
            }
            else if(element == "1") {
              tmp.token_type = TokenType.ONE; 
            }
            else if(element == "2") {
              tmp.token_type = TokenType.TWO; 
            }
            else if(element == "3") {
              tmp.token_type = TokenType.THREE; 
            }
            else if(element == "4") {
              tmp.token_type = TokenType.FOUR; 
            }
            else if(element == "5") {
              tmp.token_type = TokenType.FIVE; 
            }
            else if(element == "6") {
              tmp.token_type = TokenType.SIX; 
            } 
            else if(element == "7") {
              tmp.token_type = TokenType.SEVEN; 
            }
            else if(element == "8") {
              tmp.token_type = TokenType.EIGHT; 
            }
            else if(element == "9") {
              tmp.token_type = TokenType.NINE; 
            }
            else if(element == "10") {
              tmp.token_type = TokenType.TEN; 
            } 
            else if(element == "11") {
              tmp.token_type = TokenType.ELEVEN; 
            }
            else if(element == "12") {
              tmp.token_type = TokenType.TWELVE; 
            }
            else if(element == "13") {
              tmp.token_type = TokenType.THIRTEEN; 
            }
            else if(element == "X") {
              tmp.token_type = TokenType.X; 
            }
            token_list.add(tmp); 
          }
        }
        else if(line_descriptor.contains("Type Of Spell: ")) {
          line_descriptor += element; 

          if(element.contains("Attack")){
            tmp.lexeme = element; 
            tmp.token_type = TokenType.ATTACK; 
            // parse the description
            for(String word: description_of_spell.split(" ")) {
              System.out.println("Word Inside Description for Attack Spell: " + word); 
            }
          }
          else if(element.contains("Trap") || element.contains("Blade") || element.equals("Utility") || element.contains("Shield") || element.contains("Weakness") || element.contains("Dispel") || element.contains("Bubble") || element.contains("Hit")) {
            tmp.lexeme = element; 
            tmp.token_type  = TokenType.UTILITY; 
            // parse the description
            for(String word: description_of_spell.split(" ")) {
              System.out.println("Word Inside Description for Utility Spell: " + word); 
            }
          }
          else if(element.contains("Heal")) {
            tmp.lexeme = element; 
            tmp.token_type = TokenType.REGENERATION; 
            // parse the description
            for(String word: description_of_spell.split(" ")) {
              System.out.println("Word Inside Description for Healing Spell: " + word);
            }
          }
          System.out.println("Type Of Spell finished decoding.");
        }
      }
      inputBuffer.remove(element); 
      System.out.println("InputBuffer Size before next iteration: " + inputBuffer.size()); 
    }
    return ret; 
  }

  Token GetTokenMain(String line)
  {
    System.out.println("Line Read Here: " + line); 

    SkipSpace(line); 
    //tmp.lexeme = ""; 
    //tmp.token_type = TokenType.END_OF_FILE; 

    return tmp; 
  }

  public List<Token> get_token_list() {
    return token_list;
  }
}
