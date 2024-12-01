package Product_Process;

import java.io.FileWriter;
import java.io.IOException;

interface Module_Incorporation_Concept {
  static FileWriter getFileWriter(String team, int round) throws IOException {
    return new FileWriter("module_" + round + "_incorporation_concept_" + team + ".compute.txt"); 
  }

  static FileWriter getFileWriter(String team, int memberNo, int round) throws IOException {
    return new FileWriter("module_" + round + "_incorporation_concept_" + team + "_member_" + memberNo + ".compute.txt"); 
  }
}
