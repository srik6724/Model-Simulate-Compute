package SpellParser;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.Vector;

public class InputBuffer {
  //declares private instance variable input_buffer
  private Vector<String> input_buffer;  

  InputBuffer(String line)
  {
    // Counts # of spaces in a line
    int countSpaces = count_spaces(line); 
    // Initializes input_buffer to a specified size based on number of spaces
    input_buffer = new Vector<>(countSpaces); 
    int initial = 0;
    int spaceIndex = line.indexOf(" "); 
    String str = ""; 
    for(int i = initial; i < spaceIndex; i++)
    {
      if(!(line.substring(i,i+1).equals(":"))) {
        str += line.substring(i, i+1); 
      }
      if((i+1) == spaceIndex) {
        System.out.println("String about to be added to input buffer: " + str); 
        if(!(str.toLowerCase().equals("count"))) {
          input_buffer.add(str); 
        }
        initial = spaceIndex; 
        spaceIndex = line.indexOf(" ", spaceIndex+1);
        if(spaceIndex == -1) {
          System.out.println("Space Index: " + spaceIndex); 
          str = ""; 
          for(int j = initial + 1; j < line.length(); j++) {
            str += line.substring(j, j+1); 
          }
          System.out.println("String str: " + str); 
          input_buffer.add(str); 
        }
        str = ""; 
      }
    }

  }

  Vector<String> get_input_buffer() {
    return input_buffer;
  }

  int count_spaces(String line) {
    int space_counter = 0; 
    for(int i = 0; i < line.length(); i++) {
      if(line.substring(i, i+1).equals(" ")) {
        space_counter++; 
      }
    }
    return space_counter; 
  }
  

}
