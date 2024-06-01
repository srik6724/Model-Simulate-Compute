package Match_Process;

import java.io.FileWriter;
import java.io.IOException;

interface Match_Finalizer {
  static FileWriter getFileWriter() throws IOException {
    return new FileWriter("match_finalizer_compute.txt"); 
  }
}
