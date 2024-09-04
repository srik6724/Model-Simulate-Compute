package Article_Process;

import java.io.FileWriter;
import java.io.IOException;

interface Cross_Check_Strategy {
  static FileWriter getFileWriter(String team, int round) throws IOException {
    return new FileWriter("cross_check_" + round + "_approach_" + team + "_compute.txt"); 
  }

  static FileWriter getFileWriter(String team, int memberNo, int round) throws IOException {
    return new FileWriter("cross_check_" + round + "_" + team + "_member_" + "approach_" + memberNo + "_compute.txt"); 
  }
}
