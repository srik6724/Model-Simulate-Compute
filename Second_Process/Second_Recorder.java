package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

interface Second_Recorder {
  static FileWriter getFileWriter() throws IOException {
    return new FileWriter("second_compute.txt"); 
  }

}
