package Match_Process;

import java.io.FileWriter;
import java.io.IOException;

class RoundDFAWriter {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  RoundDFAWriter(String team, int round) {
    try {
      file_writer = Round_DFA.getFileWriter(team, round);
      RoundDFAWriter.writerCreated = true; 
    } catch (IOException e) { 
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(RoundDFAWriter.writerCreated == false) {
      System.out.println("Calling round_dfa constructor."); 
      new RoundDFAWriter("default", round);
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    RoundDFAWriter.writerCreated = var; 
  }
}
