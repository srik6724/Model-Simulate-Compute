package Interrogative_Word_Process_;

import java.io.FileWriter;
import java.io.IOException;

interface Interrogative_Word_Transducer {
  static FileWriter getFileWriter(String team) throws IOException {
    return new FileWriter("interrogative_word_transducer_" + team + "_compute.txt");
  }
}
