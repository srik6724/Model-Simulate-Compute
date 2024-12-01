package Product_Process;

import java.io.FileWriter;
import java.io.IOException;

interface Product_Discarder {
   
  static FileWriter getFileWriter(String team) throws IOException {
    return new FileWriter("domain_excess_" + team + "_compute.txt");
  }

}
