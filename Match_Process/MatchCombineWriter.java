package Match_Process;

import java.io.FileWriter;
import java.io.IOException;

class MatchCombineWriter {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer;
  
  MatchCombineWriter() {
    try {
      file_writer = Match_Merge_Finalizer.getFileWriter(); 
      MatchCombineWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer() {
    if(MatchCombineWriter.writerCreated == true) {
      System.out.println("Calling match_combine constructor."); 
      new MatchCombineWriter(); 
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    MatchCombineWriter.writerCreated = var;
  }
}
