package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

class NanosecondCombineWriter {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  NanosecondCombineWriter(String team, int round) {
    try {
      file_writer = Nanosecond_Merge_Finalizer.getFileWriter(round, team);
      NanosecondCombineWriter.writerCreated = true; 
    } catch (IOException e) { 
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(NanosecondCombineWriter.writerCreated == false) {
      System.out.println("Calling round_combine constructor."); 
      new NanosecondCombineWriter("default", round);
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    NanosecondCombineWriter.writerCreated = var; 
  }
}
