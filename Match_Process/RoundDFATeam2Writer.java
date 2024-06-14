package Match_Process;

import java.io.FileWriter;
import java.io.IOException;

class RoundDFATeam2Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  RoundDFATeam2Writer(String team, int round) {
    try {
      file_writer = Round_DFA.getFileWriter(team, round);
      RoundDFATeam2Writer.writerCreated = true; 
    } catch (IOException e) { 
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(RoundDFATeam2Writer.writerCreated == false) {
      System.out.println("Calling round_dfa constructor."); 
      new RoundDFATeam1Writer("t2", round);
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) { 
    RoundDFATeam2Writer.writerCreated = var; 
  }
}
