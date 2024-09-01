package Verb_Process;

import java.io.FileWriter;
import java.io.IOException;

interface Verb_Recorder {
  static FileWriter getFileWriter() throws IOException {
    return new FileWriter("verb_compute.txt"); 
  }

}
