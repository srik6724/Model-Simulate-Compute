package Domain_Process;

import java.io.FileWriter;
import java.io.IOException;

interface Domain_Recorder {
  static FileWriter getFileWriter() throws IOException {
    return new FileWriter("domain_compute.txt"); 
  }

}
