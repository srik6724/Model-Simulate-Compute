package Category_Process;

import java.io.FileWriter;
import java.io.IOException;

interface Category_Discarder {
   
  static FileWriter getFileWriter(String team) throws IOException {
    return new FileWriter("category_excess_" + team + "_compute.txt");
  }

}
