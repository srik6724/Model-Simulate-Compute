package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

class MicrosecondModeOfOperationsTeam2Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  MicrosecondModeOfOperationsTeam2Writer(int round, String team) {
    try {
      file_writer = Microsecond_Hierarchy.getFileWriter(team, round);
      MicrosecondModeOfOperationsTeam2Writer.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(MicrosecondModeOfOperationsTeam2Writer.writerCreated == false) {
      System.out.println("Calling round_mode_of_operations constructor."); 
      new MicrosecondModeOfOperationsTeam2Writer(round, "t2"); 
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    MicrosecondModeOfOperationsTeam2Writer.writerCreated = var; 
  }
}
