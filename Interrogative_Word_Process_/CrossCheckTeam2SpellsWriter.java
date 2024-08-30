package Interrogative_Word_Process_;

import java.io.FileWriter;
import java.io.IOException;

class CrossCheckTeam2SpellsWriter {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  CrossCheckTeam2SpellsWriter(String team, int round) {
    try {
      file_writer = Cross_Check_Recorder.getFileWriter(team, round);
      CrossCheckTeam2SpellsWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(CrossCheckTeam2SpellsWriter.writerCreated == false) {
      System.out.println("Calling round_writer constructor."); 
      new CrossCheckTeam2SpellsWriter("t2", round); 
    }
    return file_writer; 
  }

  static void setWriterCreated(boolean var) {
    CrossCheckTeam2SpellsWriter.writerCreated = var; 
  }
  
}
