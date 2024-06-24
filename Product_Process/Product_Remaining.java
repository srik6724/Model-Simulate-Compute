package Product_Process;

import java.io.FileWriter;
import java.io.IOException;

interface Product_Remaining {
  static FileWriter getFileWriter(String team) throws IOException {
    return new FileWriter("product_remaining_" + team + "_compute.txt");
  }
}
