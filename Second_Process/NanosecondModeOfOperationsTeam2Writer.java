package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

class NanosecondModeOfOperationsTeam2Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  NanosecondModeOfOperationsTeam2Writer(int round, String team) {
    try {
      file_writer = Nanosecond_Hierarchy.getFileWriter(team, round);
      NanosecondModeOfOperationsTeam2Writer.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(NanosecondModeOfOperationsTeam2Writer.writerCreated == false) {
      System.out.println("Calling round_mode_of_operations constructor."); 
      new NanosecondModeOfOperationsTeam2Writer(round, "t2"); 
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    NanosecondModeOfOperationsTeam2Writer.writerCreated = var; 
  }
}
