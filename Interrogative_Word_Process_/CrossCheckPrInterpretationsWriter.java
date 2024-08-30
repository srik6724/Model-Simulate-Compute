package  Interrogative_Word_Process_;

import java.io.FileWriter;
import java.io.IOException;

class CrossCheckPrInterpretationsWriter {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 
  

  CrossCheckPrInterpretationsWriter(int round, String team) {
    try {
      file_writer = Cross_Check_pyreason_interpretations.getFileWriter(team, round);
      CrossCheckPrInterpretationsWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(CrossCheckPrInterpretationsWriter.writerCreated == false) {
      System.out.println("Calling round_pr_interpretations constructor."); 
      new CrossCheckPrInterpretationsWriter(round, "default"); 
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    CrossCheckPrInterpretationsWriter.writerCreated = var; 
  }
}
