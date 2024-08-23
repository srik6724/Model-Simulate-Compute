package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

class MicrosecondNFATeam2Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  MicrosecondNFATeam2Writer(int round, String team) {
    try {
      file_writer = Microsecond_NFA.getFileWriter(team, round); 
      MicrosecondNFATeam2Writer.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(MicrosecondNFATeam2Writer.writerCreated == false) {
      System.out.println("Calling round_nfa constructor."); 
      new MicrosecondNFATeam2Writer(round, "t2"); 
    }
    return file_writer;
  }

  public static void setWriterCreated(boolean var) {
    MicrosecondNFATeam2Writer.writerCreated = var; 
  }
}
