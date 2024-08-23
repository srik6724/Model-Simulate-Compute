package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

class MicrosecondPrInterpretationsTeam2Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 
  

  MicrosecondPrInterpretationsTeam2Writer(int round, String team) {
    try {
      file_writer = Microsecond_pyreason_interpretations.getFileWriter(team, round);
      MicrosecondPrInterpretationsTeam2Writer.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(MicrosecondPrInterpretationsTeam2Writer.writerCreated == false) {
      System.out.println("Calling round_pr_interpretations constructor."); 
      new MicrosecondPrInterpretationsTeam2Writer(round, "t2"); 
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    MicrosecondPrInterpretationsTeam2Writer.writerCreated = var; 
  }
}
