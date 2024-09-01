package Verb_Process;

import java.io.FileWriter;
import java.io.IOException;

interface Cross_Check_Parser {
  static FileWriter getFileWriter(String team, int round) throws IOException {
    return new FileWriter("cross_check_" + round + "_parser_" + team + "_compute.txt"); 
  }

  static FileWriter getFileWriter(String team, int memberNo, int round) throws IOException {
    return new FileWriter("cross_check_" + round + "_parser_" + team + "_member_" + memberNo + "_compute.txt"); 
  }
}
