package Interrogative_Word_Process_;

import java.io.FileReader;
import java.io.IOException;

interface Interrogative_Word_Interpreter {
  static FileReader getFileReader() throws IOException {
    return new FileReader("interrogative_word_compute.txt"); 
  }
}
