package wizPackage;

import java.io.FileWriter;
import java.io.IOException;

interface Round_Discarder {
  static FileWriter getFileWriter(String team, int round) throws IOException {
    return new FileWriter("round_" + round + "_" + "excess_" + team + "compute.txt"); 
  }
}
