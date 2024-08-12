package Second_Process;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

interface Second_Selection {
  
  static FileWriter getFileWriter(String team) throws IOException {
    return new FileWriter("second_selection_cast_" + team + "_compute.txt");
  }

  static FileReader getFileReader(String team) throws IOException {
    return new FileReader("second_selection_cast_" + team + ".compute.txt");
  }
}
