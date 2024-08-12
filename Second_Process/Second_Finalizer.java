package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

interface Second_Finalizer {
  static FileWriter getFileWriter() throws IOException {
    return new FileWriter("second_finalizer_compute.txt"); 
  }
}
