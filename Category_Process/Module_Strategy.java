package Category_Process;

import java.io.FileWriter;
import java.io.IOException;

interface Module_Strategy {
  static FileWriter getFileWriter(String team, int round) throws IOException {
    return new FileWriter("module_" + round + "_approach_" + team + "_compute.txt"); 
  }

  static FileWriter getFileWriter(String team, int memberNo, int round) throws IOException {
    return new FileWriter("module_" + round + "_" + team + "_member_" + "approach_" + memberNo + "_compute.txt"); 
  }
}
