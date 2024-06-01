package Match_Process;

import java.io.FileReader;
import java.io.IOException;

interface Round_Interpreter {
  static FileReader getFileReader() throws IOException {
    return new FileReader("match_compute.txt"); 
  }
}
