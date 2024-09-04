package Article_Process;

import java.io.FileWriter;
import java.io.IOException;

interface Article_Discarder {
   
  static FileWriter getFileWriter(String team) throws IOException {
    return new FileWriter("article_excess_" + team + "_compute.txt");
  }

}
