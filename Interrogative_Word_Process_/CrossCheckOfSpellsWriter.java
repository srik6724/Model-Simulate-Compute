package Interrogative_Word_Process_;

import java.io.FileWriter;
import java.io.IOException;

class CrossCheckOfSpellsWriter {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  CrossCheckOfSpellsWriter(int round, String team) {
    try {
      file_writer = Cross_Check_Recorder.getFileWriter(team, round);
      CrossCheckOfSpellsWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    } 
  }

  static FileWriter get_file_writer(int round) {
    if(CrossCheckOfSpellsWriter.writerCreated == false) {
      System.out.println("Calling match_writer constructor."); 
      new CrossCheckOfSpellsWriter(round, "default"); 
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    CrossCheckOfSpellsWriter.writerCreated = var; 
  }
  
}
