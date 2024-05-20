package wizPackage;

import java.io.FileWriter;
import java.io.IOException;

interface Round_Remaining {
  static FileWriter getFileWriter(String team, int round) throws IOException {
    return new FileWriter("round_" + round + "_" + "remaining_" + team + "_compute.txt"); 
  }
}
