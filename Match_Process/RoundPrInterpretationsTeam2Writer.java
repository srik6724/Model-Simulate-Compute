package Match_Process;

import java.io.FileWriter;
import java.io.IOException;

class RoundPrInterpretationsTeam2Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 
  

  RoundPrInterpretationsTeam2Writer(int round, String team) {
    try {
      file_writer = Round_pyreason_interpretations.getFileWriter(team, round);
      RoundPrInterpretationsTeam2Writer.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(RoundPrInterpretationsTeam2Writer.writerCreated == false) {
      System.out.println("Calling round_pr_interpretations constructor."); 
      new RoundPrInterpretationsTeam2Writer(round, "t2"); 
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    RoundPrInterpretationsTeam2Writer.writerCreated = var; 
  }
}
