package Match_Process;

import java.io.FileWriter;
import java.io.IOException;

interface Round_Statistics {
  static FileWriter getFileWriter(String team, int round) throws IOException {
    return new FileWriter("round_" + round + "_statistics_" + team + ".compute.txt"); 
  }

  static FileWriter getFileWriter(String team, int memberNo, int round) throws IOException {
    return new FileWriter("round_" + round + "_statistics_" + team + "_member_" + memberNo + ".compute.txt"); 
  }
}