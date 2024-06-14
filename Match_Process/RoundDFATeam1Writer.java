package Match_Process;

import java.io.FileWriter;
import java.io.IOException;

class RoundDFATeam1Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  RoundDFATeam1Writer(String team, int round) {
    try {
      file_writer = Round_DFA.getFileWriter(team, round);
      RoundDFATeam1Writer.writerCreated = true; 
    } catch (IOException e) { 
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(RoundDFATeam1Writer.writerCreated == false) {
      System.out.println("Calling round_combine constructor."); 
      new RoundDFATeam1Writer("t1", round);
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) { 
    RoundDFATeam1Writer.writerCreated = var; 
  }
}
