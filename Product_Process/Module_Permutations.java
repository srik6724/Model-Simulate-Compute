package Product_Process;

import java.io.FileWriter;
import java.io.IOException;

interface Module_Permutations {
  static FileWriter getFileWriter(String team, int round) throws IOException {
    return new FileWriter("module_" + round + "_permutations_" + team + ".compute.txt"); 
  }

  static FileWriter getFileWriter(String team, int memberNo, int round) throws IOException {
    return new FileWriter("module_" + round + "_permutations_" + team + "_member_" + memberNo + ".compute.txt"); 
  }
}
