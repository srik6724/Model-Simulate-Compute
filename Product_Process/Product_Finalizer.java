package Product_Process;

import java.io.FileWriter;
import java.io.IOException;

interface Product_Finalizer {
  static FileWriter getFileWriter() throws IOException {
    return new FileWriter("match_finalizer_compute.txt"); 
  }
}
