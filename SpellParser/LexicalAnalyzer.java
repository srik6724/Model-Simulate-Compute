package SpellParser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;
import java.util.Vector;

import SpellParser.Token.TokenType;

public class LexicalAnalyzer {
  int index; 
  static boolean first_iteration = false; 
  private String[] reserved_tokens = {"DECK", "SPELL", "LIFE", "DEATH", "BALANCE", "ICE", "MYTH", "FIRE", "STORM", 
                                      "ZERO", "ONE", "TWO", "THREE", "FOUR", "FIVE", "SIX", "SEVEN", 
                                      "EIGHT", "NINE", "TEN", "ELEVEN", "TWELVE", "THIRTEEN", "X", 
                                      "TEXT", "NUM", "ATTACK", "DEFENSE", "REGENERATION", "DAMAGE", "HEALING", 
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
      else 
      {
        token.lexeme = ""; 
        token.token_type = TokenType.END_OF_FILE;
      }
    }
    System.out.println("Finished parsing input lines and creating tokens."); 

  }

  boolean SkipSpace(String line)
  {
    boolean ret = false; 
    // Take a line, analyze it and place the necessary words inside the input buffer
    InputBuffer buffer = new InputBuffer(line); 
    System.out.println("Splitting of line completed. Words split by space are placed inside input buffer."); 
    // Get the Input Buffer
    Vector<String> inputBuffer = buffer.get_input_buffer();
    // Popping element_name from the stack
    int vector_index = 0; 
    while(inputBuffer.size() > 0) {

      String line_descriptor = ""; 
      String value = ""; 
      String element = inputBuffer.get(vector_index); 

      if(element.equals("BALANCE")) {
        tmp.lexeme = element; 
        tmp.token_type = TokenType.BALANCE; 
      }
      else if(element.equals("DECK")) {
        tmp.lexeme = element; 
        tmp.token_type = TokenType.DECK; 
      }
      else if(element.equals("Spell")) {
        line_descriptor += element; 
        inputBuffer.remove(element); 
        if(line_descriptor.equals("Spell Name")) {
          inputBuffer.remove(element); 
          continue; 
        }
        else if(!element.isEmpty()) {
          line_descriptor += element; 
          value += element; 
          inputBuffer.remove(element); 
          System.out.println("Value Of Element based on given line descriptor is: " + value); 
          System.out.println("Spell successfully exists. Therefore, we set its token to SPELL."); 
          tmp.lexeme = line_descriptor; 
          tmp.token_type = TokenType.SPELL; 
          line_descriptor = ""; 
        }
        else 
        {
          continue; 
        }
      }
      else if(element.equals("Description")) {
        
      }
      else if(element.equals("Pip")){

      }
      else if(element.equals("School")) {

      }

      inputBuffer.remove(element); 
    }

    return ret; 
  }

  Token GetTokenMain(String line)
  {
    System.out.println("Line Read: " + line); 
    char c; 

    SkipSpace(line); 
    //tmp.lexeme = ""; 
    //tmp.token_type = TokenType.END_OF_FILE; 

    return tmp; 
  }
}
