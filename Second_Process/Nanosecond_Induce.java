package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

interface Nanosecond_Induce {
  static FileWriter getFileWriter(String team, int round) throws IOException {
    return new FileWriter("nanosecond_" + round + "_induce_" + team + ".compute.txt"); 
  }

  static FileWriter getFileWriter(String team, int memberNo, int round) throws IOException {
    return new FileWriter("nanosecond_" + round + "_induce_" + team + "_member_" + memberNo + ".compute.txt"); 
  }
}
