package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

interface Microsecond_DFA {
  static FileWriter getFileWriter(String team, int round) throws IOException {
    return new FileWriter("microsecond_" + round + "_dfa_" + team + ".compute.txt"); 
  }

  static FileWriter getFileWriter(String team, int memberNo, int round) throws IOException {
    return new FileWriter("microsecond_" + round + "_dfa_" + team + "_member_" + memberNo + ".compute.txt"); 
  }
}