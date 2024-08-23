package Second_Process;

import java.io.FileReader;
import java.io.IOException;

interface Microsecond_Interpreter {
  static FileReader getFileReader() throws IOException {
    return new FileReader("second_compute.txt"); 
  }
}
