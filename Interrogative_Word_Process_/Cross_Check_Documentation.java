package Interrogative_Word_Process_;

import java.io.FileWriter;
import java.io.IOException;

interface Cross_Check_Documentation {
  static FileWriter getFileWriter(String team, int round) throws IOException {
    return new FileWriter("interrogative_word_" + round + "_documentation_" + team + ".compute.txt"); 
  }

  static FileWriter getFileWriter(String team, int memberNo, int round) throws IOException {
    return new FileWriter("interrogative_word_" + round + "_documentation_" + team + "_member_" + memberNo + ".compute.txt"); 
  }
}
