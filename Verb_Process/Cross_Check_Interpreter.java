package Verb_Process;

import java.io.FileReader;
import java.io.IOException;

interface Cross_Check_Interpreter {
  static FileReader getFileReader() throws IOException {
    return new FileReader("verb_compute.txt"); 
  }
}
