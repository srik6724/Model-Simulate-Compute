package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

class MicrosecondModeOfOperationsTeam1Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  MicrosecondModeOfOperationsTeam1Writer(int round, String team) {
    try {
      file_writer = Microsecond_Hierarchy.getFileWriter(team, round);
      MicrosecondModeOfOperationsTeam1Writer.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(MicrosecondModeOfOperationsTeam1Writer.writerCreated == false) {
      System.out.println("Calling round_remaining constructor."); 
      new MicrosecondModeOfOperationsTeam1Writer(round, "t1"); 
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    MicrosecondModeOfOperationsTeam1Writer.writerCreated = var; 
  }
}
