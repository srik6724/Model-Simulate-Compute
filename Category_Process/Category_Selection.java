package Category_Process;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

interface Category_Selection {
  
  static FileWriter getFileWriter(String team) throws IOException {
    return new FileWriter("category_selection_cast_" + team + "_compute.txt");
  }

  static FileReader getFileReader(String team) throws IOException {
    return new FileReader("category_selection_cast_" + team + ".compute.txt");
  }
}
