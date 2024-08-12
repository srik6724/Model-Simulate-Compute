package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

class NanosecondDFATeam2Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  NanosecondDFATeam2Writer(String team, int round) {
    try {
      file_writer = Nanosecond_DFA.getFileWriter(team, round);
      NanosecondDFATeam2Writer.writerCreated = true; 
    } catch (IOException e) { 
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(NanosecondDFATeam2Writer.writerCreated == false) {
      System.out.println("Calling round_dfa constructor."); 
      new NanosecondDFATeam2Writer("t2", round);
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) { 
    NanosecondDFATeam2Writer.writerCreated = var; 
  }
}
