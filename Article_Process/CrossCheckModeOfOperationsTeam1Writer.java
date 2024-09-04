package Article_Process;

import java.io.FileWriter;
import java.io.IOException;

class CrossCheckModeOfOperationsTeam1Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  CrossCheckModeOfOperationsTeam1Writer(int round, String team) {
    try {
      file_writer = Cross_Check_Hierarchy.getFileWriter(team, round);
      CrossCheckModeOfOperationsTeam1Writer.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(CrossCheckModeOfOperationsTeam1Writer.writerCreated == false) {
      System.out.println("Calling round_remaining constructor."); 
      new CrossCheckModeOfOperationsTeam1Writer(round, "t1"); 
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    CrossCheckModeOfOperationsTeam1Writer.writerCreated = var; 
  }
}
