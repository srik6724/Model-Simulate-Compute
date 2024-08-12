package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

interface Nanosecond_Timestamp {

  static FileWriter getFileWriter(String team, int module) throws IOException {
    return new FileWriter("nanosecond_" + module + "_timestamp_" + team + "_compute.txt"); 
  }

  static FileWriter getFileWriter(String team, int memberNo, int module) throws IOException {
    return new FileWriter("nanosecond_" + module + "_timestamp_" + team + "_member_" + memberNo + ".compute.txt");
  }
}
