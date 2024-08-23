package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

class MicrosecondPrInterpretationsTeam1Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 
  

  MicrosecondPrInterpretationsTeam1Writer(int round, String team) {
    try {
      file_writer = Microsecond_pyreason_interpretations.getFileWriter(team, round);
      MicrosecondPrInterpretationsTeam1Writer.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(MicrosecondPrInterpretationsTeam1Writer.writerCreated == false) {
      System.out.println("Calling round_pr_interpretations constructor."); 
      new MicrosecondPrInterpretationsTeam1Writer(round, "t1"); 
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    MicrosecondPrInterpretationsTeam1Writer.writerCreated = var; 
  }
}
