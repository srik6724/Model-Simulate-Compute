package Article_Process;

import java.io.FileWriter;
import java.io.IOException;

class CrossCheckNFATeam2Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  CrossCheckNFATeam2Writer(int round, String team) {
    try {
      file_writer = Cross_Check_NFA.getFileWriter(team, round); 
      CrossCheckNFATeam2Writer.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(CrossCheckNFATeam2Writer.writerCreated == false) {
      System.out.println("Calling round_nfa constructor."); 
      new CrossCheckNFATeam2Writer(round, "t2"); 
    }
    return file_writer;
  }

  public static void setWriterCreated(boolean var) {
    CrossCheckNFATeam2Writer.writerCreated = var; 
  }
}
