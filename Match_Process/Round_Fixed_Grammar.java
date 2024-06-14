package Match_Process;

import java.io.FileWriter;
import java.io.IOException;

interface Round_Fixed_Grammar {
  static FileWriter getFileWriter(String team, int round) throws IOException {
    return new FileWriter("round_" + round + "_fixed_grammmar_" + team + ".compute.txt"); 
  }

  static FileWriter getFileWriter(String team, int memberNo, int round) throws IOException {
    return new FileWriter("round_" + round + "_fixed__grammar_" + team + "_member_" + memberNo + ".compute.txt"); 
  }
}
