package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

interface Second_Remaining {
  static FileWriter getFileWriter(String team) throws IOException {
    return new FileWriter("second_remaining_" + team + "_compute.txt");
  }
}
