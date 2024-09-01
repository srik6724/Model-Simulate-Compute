package Verb_Process;

import java.io.FileWriter;
import java.io.IOException;

interface Verb_Finalizer {
  static FileWriter getFileWriter() throws IOException {
    return new FileWriter("verb_finalizer_compute.txt"); 
  }
}
