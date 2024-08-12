package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

interface Second_Discarder {
   
  static FileWriter getFileWriter(String team) throws IOException {
    return new FileWriter("second_excess_" + team + "_compute.txt");
  }

}
