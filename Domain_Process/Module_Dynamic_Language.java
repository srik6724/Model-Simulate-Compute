package Domain_Process;

import java.io.FileWriter;
import java.io.IOException;

interface Module_Dynamic_Language {
  static FileWriter getFileWriter(String team, int round) throws IOException {
    return new FileWriter("module_" + round + "_dynamic_language_" + team + ".compute.txt"); 
  }

  static FileWriter getFileWriter(String team, int memberNo, int round) throws IOException {
    return new FileWriter("module_" + round + "_dynamic_language_" + team + "_member_" + memberNo + ".compute.txt"); 
  }
}
