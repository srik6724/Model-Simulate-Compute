package Product_Process;

import java.io.FileWriter;
import java.io.IOException;

interface Product_Transducer {
  static FileWriter getFileWriter(String team) throws IOException {
    return new FileWriter("product_transducer_" + team + "_compute.txt");
  }
}
