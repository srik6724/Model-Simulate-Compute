package Category_Process;

import java.io.FileWriter;
import java.io.IOException;

interface Module_Garbage_Collector {
  static FileWriter getFileWriter(String team, int round) throws IOException {
    return new FileWriter("module_" + round + "_garbage_collector_" + team + ".compute.txt"); 
  }

  static FileWriter getFileWriter(String team, int memberNo, int round) throws IOException {
    return new FileWriter("module_" + round + "_garbage_collector_" + team + "_member_" + memberNo + ".compute.txt"); 
  }
}
