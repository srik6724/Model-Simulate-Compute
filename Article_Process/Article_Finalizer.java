package Article_Process;

import java.io.FileWriter;
import java.io.IOException;

interface Article_Finalizer {
  static FileWriter getFileWriter() throws IOException {
    return new FileWriter("article_finalizer_compute.txt"); 
  }
}
