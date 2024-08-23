package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

class MicrosecondSelectionTeam2Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  MicrosecondSelectionTeam2Writer(String team, int round) {
    try {
      file_writer = Microsecond_Selection.getFileWriter(team, round);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(MicrosecondSelectionTeam2Writer.writerCreated == false) {
      System.out.println("Calling selection line writer constructor."); 
      new MicrosecondSelectionTeam2Writer("t2", round); 
    }
    return file_writer; 
  }

  static void setWriterCreated(boolean var) {
    MicrosecondSelectionTeam2Writer.writerCreated = var; 
  }
}
