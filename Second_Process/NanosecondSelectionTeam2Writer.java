package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

class NanosecondSelectionTeam2Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  NanosecondSelectionTeam2Writer(String team, int round) {
    try {
      file_writer = Nanosecond_Selection.getFileWriter(team, round);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(NanosecondSelectionTeam2Writer.writerCreated == false) {
      System.out.println("Calling selection line writer constructor."); 
      new NanosecondSelectionTeam2Writer("t2", round); 
    }
    return file_writer; 
  }

  static void setWriterCreated(boolean var) {
    NanosecondSelectionTeam2Writer.writerCreated = var; 
  }
}
