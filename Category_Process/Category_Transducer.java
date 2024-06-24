package Category_Process;

import java.io.FileWriter;
import java.io.IOException;

interface Category_Transducer {
  static FileWriter getFileWriter(String team) throws IOException {
    return new FileWriter("category_transducer_" + team + "_compute.txt");
  }
}
