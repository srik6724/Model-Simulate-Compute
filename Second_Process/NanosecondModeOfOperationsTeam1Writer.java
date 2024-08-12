package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

class NanosecondModeOfOperationsTeam1Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  NanosecondModeOfOperationsTeam1Writer(int round, String team) {
    try {
      file_writer = Nanosecond_Hierarchy.getFileWriter(team, round);
      NanosecondModeOfOperationsTeam1Writer.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(NanosecondModeOfOperationsTeam1Writer.writerCreated == false) {
      System.out.println("Calling round_remaining constructor."); 
      new NanosecondModeOfOperationsTeam1Writer(round, "t1"); 
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    NanosecondModeOfOperationsTeam1Writer.writerCreated = var; 
  }
}
