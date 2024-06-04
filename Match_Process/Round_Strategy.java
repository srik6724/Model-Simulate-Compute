package Match_Process;

import java.io.FileWriter;
import java.io.IOException;

interface Round_Strategy {
  static FileWriter getFileWriter(String team, int round) throws IOException {
    return new FileWriter("round_" + round + "_approach_" + team + "_compute.txt"); 
  }

  static FileWriter getFileWriter(String team, int memberNo, int round) throws IOException {
    return new FileWriter("round_" + round + "_" + team + "_member_" + "approach_" + memberNo + "_compute.txt"); 
  }
}
