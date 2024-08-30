package Interrogative_Word_Process_;

import java.io.FileWriter;
import java.io.IOException;

interface Interrogative_Word_Finalizer {
  static FileWriter getFileWriter() throws IOException {
    return new FileWriter("interrogative_word_finalizer_compute.txt"); 
  }
}
