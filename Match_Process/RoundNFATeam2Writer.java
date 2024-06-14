package Match_Process;

import java.io.FileWriter;
import java.io.IOException;

class RoundNFATeam2Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  RoundNFATeam2Writer(int round, String team) {
    try {
      file_writer = Round_NFA.getFileWriter(team, round); 
      RoundNFATeam2Writer.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(RoundNFATeam2Writer.writerCreated == false) {
      System.out.println("Calling round_nfa constructor."); 
      new RoundNFATeam2Writer(round, "t2"); 
    }
    return file_writer;
  }

  public static void setWriterCreated(boolean var) {
    RoundNFATeam2Writer.writerCreated = var; 
  }
}
