package Match_Process;

import java.io.FileWriter;
import java.io.IOException;

class Round_Merge_Finalizer {
  static FileWriter getFileWriter(int round) throws IOException {
    return new FileWriter("round_" + round + "_merge_finalizer.compute.txt"); 
  }
}
