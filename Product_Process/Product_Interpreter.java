package Product_Process;

import java.io.FileReader;
import java.io.IOException;

interface Product_Interpreter {
  static FileReader getFileReader() throws IOException {
    return new FileReader("product_compute.txt"); 
  }
}
