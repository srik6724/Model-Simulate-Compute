package Match_Process;

import java.io.FileWriter;
import java.io.IOException;

class RoundNFAWriter {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  RoundNFAWriter(int round, String team) {
    try {
      file_writer = Round_NFA.getFileWriter(team, round); 
      RoundNFAWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(RoundNFAWriter.writerCreated == false) {
      System.out.println("Calling round_nfa constructor."); 
      new RoundNFAWriter(round, "default"); 
    }
    return file_writer;
  }

  public static void setWriterCreated(boolean var) {
    RoundNFAWriter.writerCreated = var; 
  }
}
