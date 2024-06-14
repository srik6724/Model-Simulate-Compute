package Match_Process;

import java.io.FileWriter;
import java.io.IOException;

interface Round_NFA {
  static FileWriter getFileWriter(String team, int round) throws IOException {
    return new FileWriter("round_" + round + "_nfa_" + team + ".compute.txt"); 
  }

  static FileWriter getFileWriter(String team, int memberNo, int round) throws IOException {
    return new FileWriter("round_" + round + "_nfa_" + team + "_member_" + memberNo + ".compute.txt"); 
  }
}
