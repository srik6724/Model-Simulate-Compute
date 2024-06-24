package Category_Process;

import java.io.FileWriter;
import java.io.IOException;

interface Module_pyreason_graph {
  static FileWriter getFileWriter(String team, int round) throws IOException {
    return new FileWriter("module_" + round + "_pyreason_graph_" + team + ".compute.txt"); 
  }

  static FileWriter getFileWriter(String team, int memberNo, int round) throws IOException {
    return new FileWriter("module_" + round + "_pyreason_graph_" + team + "_member_" + memberNo + ".compute.txt"); 
  }
}
