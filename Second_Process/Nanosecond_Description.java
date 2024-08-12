package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

interface Nanosecond_Description {
  static FileWriter getFileWriter(String team, int round) throws IOException {
    return new FileWriter("nanosecond_" + round + "_description_" + team + ".compute.txt"); 
  }

  static FileWriter getFileWriter(String team, int memberNo, int round) throws IOException {
    return new FileWriter("nanosecond_" + round + "_description_" + team + "_member_" + memberNo + ".compute.txt"); 
  } 
}
