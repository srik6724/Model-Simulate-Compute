package Category_Process;

import java.io.FileWriter;
import java.io.IOException;

interface Category_Finalizer {
  static FileWriter getFileWriter() throws IOException {
    return new FileWriter("category_finalizer_compute.txt"); 
  }
}
