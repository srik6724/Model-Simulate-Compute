package Interrogative_Word_Process_;

import java.io.FileWriter;
import java.io.IOException;

class Cross_Check_Merge_Finalizer {
  static FileWriter getFileWriter(int round, String team) throws IOException {
    return new FileWriter("cross_check_" + round + "_merge_finalizer_" + team + "_compute.txt"); 
  }

  static FileWriter getFileWriter(String team, int memberNo, int round) throws IOException {
    return new FileWriter("cross_check_" + round + "_merge_finalizer_" + team + "_member_" + memberNo + "_compute.txt"); 
  }
}
