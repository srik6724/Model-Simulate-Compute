package Category_Process;

import java.io.FileWriter;
import java.io.IOException;

interface Category_Remaining {
  static FileWriter getFileWriter(String team) throws IOException {
    return new FileWriter("category_remaining_" + team + "_compute.txt");
  }
}
