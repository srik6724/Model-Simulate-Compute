package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

class MicrosecondDFATeam2Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  MicrosecondDFATeam2Writer(String team, int round) {
    try {
      file_writer = Microsecond_DFA.getFileWriter(team, round);
      MicrosecondDFATeam2Writer.writerCreated = true; 
    } catch (IOException e) { 
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(MicrosecondDFATeam2Writer.writerCreated == false) {
      System.out.println("Calling round_dfa constructor."); 
      new MicrosecondDFATeam2Writer("t2", round);
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) { 
    MicrosecondDFATeam2Writer.writerCreated = var; 
  }
}
