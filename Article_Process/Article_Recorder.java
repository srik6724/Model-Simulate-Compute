package Article_Process; 

import java.io.FileWriter;
import java.io.IOException;

interface Article_Recorder {
  static FileWriter getFileWriter() throws IOException {
    return new FileWriter("article_compute.txt"); 
  }

}
