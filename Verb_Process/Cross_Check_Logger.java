package Verb_Process;

import java.io.FileWriter;
import java.io.IOException;

interface Cross_Check_Logger {
   static FileWriter getFileWriter(String team, int round) throws IOException {
    return new FileWriter("cross_check_" + round + "_logger_" + team + ".compute.txt"); 
  }

  static FileWriter getFileWriter(String team, int memberNo, int round) throws IOException {
    return new FileWriter("cross_check_" + round + "_logger_" + team + "_member_" + memberNo + ".compute.txt"); 
  }
}
