package Product_Process;

import java.io.FileWriter;
import java.io.IOException;

interface Module_Remaining {
  static FileWriter getFileWriter(String team, int round) throws IOException {
    return new FileWriter("module_" + round + "_remaining_" + team + "_compute.txt"); 
  }

  static FileWriter getFileWriter(String team, int memberNo, int round) throws IOException {
    return new FileWriter("module_" + round + "_remaining_" + team + "_member_" + memberNo + "_compute.txt"); 
  }
}
