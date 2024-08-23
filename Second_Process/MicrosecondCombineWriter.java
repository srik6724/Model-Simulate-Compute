package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

class MicrosecondCombineWriter {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  MicrosecondCombineWriter(String team, int round) {
    try {
      file_writer = Microsecond_Merge_Finalizer.getFileWriter(round, team);
      MicrosecondCombineWriter.writerCreated = true; 
    } catch (IOException e) { 
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(MicrosecondCombineWriter.writerCreated == false) {
      System.out.println("Calling round_combine constructor."); 
      new MicrosecondCombineWriter("default", round);
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    MicrosecondCombineWriter.writerCreated = var; 
  }
}
