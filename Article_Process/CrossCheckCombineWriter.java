package Article_Process;

import java.io.FileWriter;
import java.io.IOException;

class CrossCheckCombineWriter {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  CrossCheckCombineWriter(String team, int round) {
    try {
      file_writer = Cross_Check_Merge_Finalizer.getFileWriter(round, team);
      CrossCheckCombineWriter.writerCreated = true; 
    } catch (IOException e) { 
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(CrossCheckCombineWriter.writerCreated == false) {
      System.out.println("Calling round_combine constructor."); 
      new CrossCheckCombineWriter("default", round);
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    CrossCheckCombineWriter.writerCreated = var; 
  }
}
