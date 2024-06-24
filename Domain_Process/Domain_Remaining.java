package Domain_Process;

import java.io.FileWriter;
import java.io.IOException;

interface Domain_Remaining {
  static FileWriter getFileWriter(String team) throws IOException {
    return new FileWriter("domain_remaining_" + team + "_compute.txt");
  }
}
