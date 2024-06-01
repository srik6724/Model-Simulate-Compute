package Match_Process;

import java.io.FileWriter;
import java.io.IOException;

interface Match_Remaining {
  static FileWriter getFileWriter(String team) throws IOException {
    return new FileWriter("match_remaining_" + team + "_compute.txt");
  }

}
