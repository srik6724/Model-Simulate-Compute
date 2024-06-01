package Match_Process;

import java.io.FileWriter;
import java.io.IOException;

interface Match_Recorder {
  static FileWriter getFileWriter() throws IOException {
    return new FileWriter("match_compute.txt"); 
  }

}
