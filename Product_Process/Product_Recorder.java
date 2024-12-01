package Product_Process;

import java.io.FileWriter;
import java.io.IOException;

interface Product_Recorder {
  static FileWriter getFileWriter() throws IOException {
    return new FileWriter("product_compute.txt"); 
  }

}
