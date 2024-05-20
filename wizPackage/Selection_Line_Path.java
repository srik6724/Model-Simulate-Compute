package wizPackage;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

interface Selection_Line_Path {

  static FileWriter getFileWriter(String team, int round) throws IOException {
    return new FileWriter("round_" + round + "_" + team + "_selection_cast" + "_compute.txt"); 
  }

  static FileReader getFileReader(String team, int round) throws IOException {
    return new FileReader("round_" + round + "_" + team + "_compute.txt"); 
  }

}
