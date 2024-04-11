package wizPackage;

import java.io.FileWriter;
import java.io.IOException;

public interface Match_Recorder {
  static FileWriter getFileWriter() throws IOException {
    return new FileWriter("match_compute.txt"); 
  }
}
