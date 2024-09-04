package Article_Process;

import java.io.FileWriter;
import java.io.IOException;

class CrossCheckHistoryTeam1Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 
  

  CrossCheckHistoryTeam1Writer(int round, String team) {
    try {
      file_writer = Cross_Check_Documentation.getFileWriter(team, round);
      CrossCheckHistoryTeam1Writer.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(CrossCheckHistoryTeam1Writer.writerCreated == false) {
      System.out.println("Calling round_documentation constructor."); 
      new CrossCheckHistoryTeam1Writer(round, "t1"); 
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    CrossCheckHistoryTeam1Writer.writerCreated = var; 
  }
}
