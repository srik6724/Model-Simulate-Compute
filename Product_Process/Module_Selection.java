package Product_Process;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

interface Module_Selection {

  static FileWriter getFileWriter(String team, int round) throws IOException {
    return new FileWriter("module_" + round + "_" + team + "_selection_cast" + "_compute.txt"); 
  }

  static FileWriter getFileWriter(String team, int memberNo, int round) throws IOException {
    return new FileWriter("module_" + round + "_" + team + "_selection_cast_" + "member_"+ memberNo + "_compute.txt"); 
  }

  static FileReader getFileReader(String team, int round) throws IOException {
    return new FileReader("module_" + round + "_" + team + "_compute.txt"); 
  }

}
