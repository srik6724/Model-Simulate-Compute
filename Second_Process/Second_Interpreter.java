package Second_Process;

import java.io.FileReader;
import java.io.IOException;

interface Second_Interpreter {
  static FileReader getFileReader() throws IOException {
    return new FileReader("second_compute.txt"); 
  }
}
