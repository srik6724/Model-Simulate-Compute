package Domain_Process;

import java.io.FileWriter;
import java.io.IOException;

interface Domain_Transducer {
  static FileWriter getFileWriter(String team) throws IOException {
    return new FileWriter("domain_transducer_" + team + "_compute.txt");
  }
}
