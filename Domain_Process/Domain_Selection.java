package Domain_Process;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

interface Domain_Selection {
  
  static FileWriter getFileWriter(String team) throws IOException {
    return new FileWriter("domain_selection_cast_" + team + "_compute.txt");
  }

  static FileReader getFileReader(String team) throws IOException {
    return new FileReader("domain_selection_cast_" + team + ".compute.txt");
  }
}
