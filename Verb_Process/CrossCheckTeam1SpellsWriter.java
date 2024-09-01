package Verb_Process;

import java.io.FileWriter;
import java.io.IOException;

class CrossCheckTeam1SpellsWriter {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  CrossCheckTeam1SpellsWriter(String team, int round) {
    try {
      file_writer = Cross_Check_Recorder.getFileWriter(team, round); 
      CrossCheckTeam1SpellsWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace(); 
    }
  }

  static FileWriter get_file_writer(int round) {
    if(CrossCheckTeam1SpellsWriter.writerCreated == false) {
      System.out.println("Calling round_writer constructor"); 
      new CrossCheckTeam1SpellsWriter("t1", round); 
    }
    return file_writer; 
  }

  static void setWriterCreated(boolean var) {
    CrossCheckTeam1SpellsWriter.writerCreated = var; 
  }
}
