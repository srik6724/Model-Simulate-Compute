package Match_Process;

import java.io.FileWriter;
import java.io.IOException;

class RoundPrInterpretationsWriter {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 
  

  RoundPrInterpretationsWriter(int round, String team) {
    try {
      file_writer = Round_pyreason_interpretations.getFileWriter(team, round);
      RoundPrInterpretationsWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(RoundPrInterpretationsWriter.writerCreated == false) {
      System.out.println("Calling round_pr_interpretations constructor."); 
      new RoundPrInterpretationsWriter(round, "default"); 
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    RoundPrInterpretationsWriter.writerCreated = var; 
  }
}
