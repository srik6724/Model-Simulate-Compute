package Article_Process;

import java.io.FileReader;
import java.io.IOException;

interface Article_Interpreter {
  static FileReader getFileReader() throws IOException {
    return new FileReader("article_compute.txt"); 
  }
}
