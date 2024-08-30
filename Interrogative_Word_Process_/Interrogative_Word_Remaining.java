package Interrogative_Word_Process_;

import java.io.FileWriter;
import java.io.IOException;

interface Interrogative_Word_Remaining {
  static FileWriter getFileWriter(String team) throws IOException {
    return new FileWriter("interrogative_word_remaining_" + team + "_compute.txt");
  }
}
