package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

class MicrosecondPrInterpretationsWriter {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 
  

  MicrosecondPrInterpretationsWriter(int round, String team) {
    try {
      file_writer = Microsecond_pyreason_interpretations.getFileWriter(team, round);
      MicrosecondPrInterpretationsWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(MicrosecondPrInterpretationsWriter.writerCreated == false) {
      System.out.println("Calling round_pr_interpretations constructor."); 
      new MicrosecondPrInterpretationsWriter(round, "default"); 
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    MicrosecondPrInterpretationsWriter.writerCreated = var; 
  }
}
