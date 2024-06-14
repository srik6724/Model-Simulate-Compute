package Match_Process;

import java.io.FileWriter;
import java.io.IOException;

class RoundNFATeam1Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  RoundNFATeam1Writer(int round, String team) {
    try {
      file_writer = Round_NFA.getFileWriter(team, round); 
      RoundNFATeam1Writer.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(RoundNFATeam1Writer.writerCreated == false) {
      System.out.println("Calling round_nfa constructor."); 
      new RoundNFATeam1Writer(round, "t1"); 
    }
    return file_writer;
  }

  public static void setWriterCreated(boolean var) {
    RoundNFATeam1Writer.writerCreated = var; 
  }
}
