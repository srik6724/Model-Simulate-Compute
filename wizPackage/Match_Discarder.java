package wizPackage;

import java.io.FileWriter;
import java.io.IOException;

interface Match_Discarder {
   
  static FileWriter getFileWriter(String team) throws IOException {
    return new FileWriter("match_excess_" + team + "_compute.txt");
  }

}
