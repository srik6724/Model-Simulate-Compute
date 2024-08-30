package Interrogative_Word_Process_;

import java.io.FileWriter;
import java.io.IOException;

interface Interrogative_Word_Recorder {
  static FileWriter getFileWriter() throws IOException {
    return new FileWriter("interrogative_word_compute.txt"); 
  }

}
