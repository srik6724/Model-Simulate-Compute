package Category_Process;

import java.io.FileWriter;
import java.io.IOException;

interface Category_Recorder {
  static FileWriter getFileWriter() throws IOException {
    return new FileWriter("category_compute.txt"); 
  }

}
