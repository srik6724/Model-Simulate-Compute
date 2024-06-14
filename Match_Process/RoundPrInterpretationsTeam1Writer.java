package Match_Process;

import java.io.FileWriter;
import java.io.IOException;

class RoundPrInterpretationsTeam1Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 
  

  RoundPrInterpretationsTeam1Writer(int round, String team) {
    try {
      file_writer = Round_pyreason_interpretations.getFileWriter(team, round);
      RoundPrInterpretationsTeam1Writer.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(RoundPrInterpretationsTeam1Writer.writerCreated == false) {
      System.out.println("Calling round_pr_interpretations constructor."); 
      new RoundPrInterpretationsTeam1Writer(round, "t1"); 
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    RoundPrInterpretationsTeam1Writer.writerCreated = var; 
  }
}
