package Interrogative_Word_Process_;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

interface Interrogative_Word_Selection {
  
  static FileWriter getFileWriter(String team) throws IOException {
    return new FileWriter("interrogative_word_selection_cast_" + team + "_compute.txt");
  }

  static FileReader getFileReader(String team) throws IOException {
    return new FileReader("interrogative_word_selection_cast_" + team + ".compute.txt");
  }
}
