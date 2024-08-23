package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

interface Microsecond_Rule_List {
  static FileWriter getFileWriter(String team, int round) throws IOException {
    return new FileWriter("microsecond_" + round + "_rules_" + team + ".compute.txt"); 
  }

  static FileWriter getFileWriter(String team, int memberNo, int round) throws IOException {
    return new FileWriter("microsecond_" + round + "_rules_" + team + "_member_" + memberNo + "_compute.txt"); 
  }
}
