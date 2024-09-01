package Verb_Process;

import java.io.FileWriter;
import java.io.IOException;

class CrossCheckDiscardSpellsWriter {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  CrossCheckDiscardSpellsWriter(int round, String team) {
    try {
      file_writer = Cross_Check_Discarder.getFileWriter(team, round); 
      CrossCheckDiscardSpellsWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(CrossCheckDiscardSpellsWriter.writerCreated == false) {
      System.out.println("Calling round_remaining constructor.");
      new CrossCheckDiscardSpellsWriter(round, "default");
    }
    return file_writer;
  }

  public static void setWriterCreated(boolean var) {
    CrossCheckDiscardSpellsWriter.writerCreated = var; 
  }
}
