package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

class NanosecondPrInterpretationsTeam1Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 
  

  NanosecondPrInterpretationsTeam1Writer(int round, String team) {
    try {
      file_writer = Nanosecond_pyreason_interpretations.getFileWriter(team, round);
      NanosecondPrInterpretationsTeam1Writer.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(NanosecondPrInterpretationsTeam1Writer.writerCreated == false) {
      System.out.println("Calling round_pr_interpretations constructor."); 
      new NanosecondPrInterpretationsTeam1Writer(round, "t1"); 
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    NanosecondPrInterpretationsTeam1Writer.writerCreated = var; 
  }
}
