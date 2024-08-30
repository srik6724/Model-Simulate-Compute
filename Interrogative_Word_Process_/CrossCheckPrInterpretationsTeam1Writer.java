package Interrogative_Word_Process_;

import java.io.FileWriter;
import java.io.IOException;

class CrossCheckPrInterpretationsTeam1Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 
  

  CrossCheckPrInterpretationsTeam1Writer(int round, String team) {
    try {
      file_writer = Cross_Check_pyreason_interpretations.getFileWriter(team, round);
      CrossCheckPrInterpretationsTeam1Writer.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(CrossCheckPrInterpretationsTeam1Writer.writerCreated == false) {
      System.out.println("Calling round_pr_interpretations constructor."); 
      new CrossCheckPrInterpretationsTeam1Writer(round, "t1"); 
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    CrossCheckPrInterpretationsTeam1Writer.writerCreated = var; 
  }
}
