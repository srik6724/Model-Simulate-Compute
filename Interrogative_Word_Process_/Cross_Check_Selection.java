package Interrogative_Word_Process_;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

interface Cross_Check_Selection {

  static FileWriter getFileWriter(String team, int round) throws IOException {
    return new FileWriter("cross_check_" + round + "_" + team + "_selection_cast" + "_compute.txt"); 
  }

  static FileWriter getFileWriter(String team, int memberNo, int round) throws IOException {
    return new FileWriter("cross_check_" + round + "_" + team + "_selection_cast_" + "member_"+ memberNo + "_compute.txt"); 
  }

  static FileReader getFileReader(String team, int round) throws IOException {
    return new FileReader("cross_check_" + round + "_" + team + "_compute.txt"); 
  }

}
