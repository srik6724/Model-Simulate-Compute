package Domain_Process;

import java.io.FileWriter;
import java.io.IOException;

interface Domain_Discarder {
   
  static FileWriter getFileWriter(String team) throws IOException {
    return new FileWriter("domain_excess_" + team + "_compute.txt");
  }

}
