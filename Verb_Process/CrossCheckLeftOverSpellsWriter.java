package Verb_Process;

import java.io.FileWriter;
import java.io.IOException;

class CrossCheckLeftOverSpellsWriter {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  CrossCheckLeftOverSpellsWriter(int round, String team) {
    try {
      file_writer = Cross_Check_Remaining.getFileWriter(team, round); 
      CrossCheckLeftOverSpellsWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(CrossCheckLeftOverSpellsWriter.writerCreated == false) {
      System.out.println("Calling round_remaining constructor."); 
      new CrossCheckLeftOverSpellsWriter(round, "default"); 
    }
    return file_writer;
  }

  public static void setWriterCreated(boolean var) {
    CrossCheckLeftOverSpellsWriter.writerCreated = var; 
  }
}
