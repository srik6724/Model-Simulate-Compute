package Product_Process;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

interface Product_Selection {
  
  static FileWriter getFileWriter(String team) throws IOException {
    return new FileWriter("match_selection_cast_" + team + "_compute.txt");
  }

  static FileReader getFileReader(String team) throws IOException {
    return new FileReader("match_selection_cast_" + team + ".compute.txt");
  }
}
