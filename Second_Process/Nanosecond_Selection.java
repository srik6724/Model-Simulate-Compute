package Second_Process;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

interface Nanosecond_Selection {

  static FileWriter getFileWriter(String team, int round) throws IOException {
    return new FileWriter("nanosecond_" + round + "_" + team + "_selection_cast" + "_compute.txt"); 
  }

  static FileWriter getFileWriter(String team, int memberNo, int round) throws IOException {
    return new FileWriter("nanosecond_" + round + "_" + team + "_selection_cast_" + "member_"+ memberNo + "_compute.txt"); 
  }

  static FileReader getFileReader(String team, int round) throws IOException {
    return new FileReader("nanosecond_" + round + "_" + team + "_compute.txt"); 
  }

}
