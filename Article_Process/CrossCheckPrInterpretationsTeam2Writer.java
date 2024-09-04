package Article_Process;

import java.io.FileWriter;
import java.io.IOException;

class CrossCheckPrInterpretationsTeam2Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 
  

  CrossCheckPrInterpretationsTeam2Writer(int round, String team) {
    try {
      file_writer = Cross_Check_pyreason_interpretations.getFileWriter(team, round);
      CrossCheckPrInterpretationsTeam2Writer.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(CrossCheckPrInterpretationsTeam2Writer.writerCreated == false) {
      System.out.println("Calling round_pr_interpretations constructor."); 
      new CrossCheckPrInterpretationsTeam2Writer(round, "t2"); 
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    CrossCheckPrInterpretationsTeam2Writer.writerCreated = var; 
  }
}
