package Article_Process;

import java.io.FileWriter;
import java.io.IOException;

interface Article_Remaining {
  static FileWriter getFileWriter(String team) throws IOException {
    return new FileWriter("article_remaining_" + team + "_compute.txt");
  }
}
