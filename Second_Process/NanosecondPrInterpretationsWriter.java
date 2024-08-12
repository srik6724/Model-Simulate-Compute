package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

class NanosecondPrInterpretationsWriter {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 
  

  NanosecondPrInterpretationsWriter(int round, String team) {
    try {
      file_writer = Nanosecond_pyreason_interpretations.getFileWriter(team, round);
      NanosecondPrInterpretationsWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(NanosecondPrInterpretationsWriter.writerCreated == false) {
      System.out.println("Calling round_pr_interpretations constructor."); 
      new NanosecondPrInterpretationsWriter(round, "default"); 
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    NanosecondPrInterpretationsWriter.writerCreated = var; 
  }
}
