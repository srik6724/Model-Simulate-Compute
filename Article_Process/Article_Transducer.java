package Article_Process;

import java.io.FileWriter;
import java.io.IOException;

interface Article_Transducer {
  static FileWriter getFileWriter(String team) throws IOException {
    return new FileWriter("article_transducer_" + team + "_compute.txt");
  }
}
