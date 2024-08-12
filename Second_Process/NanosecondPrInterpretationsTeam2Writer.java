package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

class NanosecondPrInterpretationsTeam2Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 
  

  NanosecondPrInterpretationsTeam2Writer(int round, String team) {
    try {
      file_writer = Nanosecond_pyreason_interpretations.getFileWriter(team, round);
      NanosecondPrInterpretationsTeam2Writer.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(NanosecondPrInterpretationsTeam2Writer.writerCreated == false) {
      System.out.println("Calling round_pr_interpretations constructor."); 
      new NanosecondPrInterpretationsTeam2Writer(round, "t2"); 
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    NanosecondPrInterpretationsTeam2Writer.writerCreated = var; 
  }
}
