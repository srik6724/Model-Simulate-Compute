package Second_Process;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

interface Microsecond_Selection {

  static FileWriter getFileWriter(String team, int round) throws IOException {
    return new FileWriter("microsecond_" + round + "_selection_cast" + team + "_compute.txt"); 
  }

  static FileWriter getFileWriter(String team, int memberNo, int round) throws IOException {
    return new FileWriter("microsecond_" + round + "_" + team + "_selection_cast_" + "member_"+ memberNo + "_compute.txt"); 
  }

  static FileReader getFileReader(String team, int round) throws IOException {
    return new FileReader("microsecond_" + round + "_" + team + "_compute.txt"); 
  }

}
