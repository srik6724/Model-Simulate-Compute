package Interrogative_Word_Process_;

import java.io.FileWriter;
import java.io.IOException;

class CrossCheckNFAWriter {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  CrossCheckNFAWriter(int round, String team) {
    try {
      file_writer = Cross_Check_NFA.getFileWriter(team, round); 
      CrossCheckNFAWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(CrossCheckNFAWriter.writerCreated == false) {
      System.out.println("Calling round_nfa constructor."); 
      new CrossCheckNFAWriter(round, "default"); 
    }
    return file_writer;
  }

  public static void setWriterCreated(boolean var) {
    CrossCheckNFAWriter.writerCreated = var; 
  }
}
