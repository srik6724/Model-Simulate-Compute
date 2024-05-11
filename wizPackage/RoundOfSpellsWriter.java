package wizPackage;

import java.io.FileWriter;
import java.io.IOException;

class RoundOfSpellsWriter {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  RoundOfSpellsWriter(int round, String team) {
    try {
      file_writer = Round_Recorder.getFileWriter(team, round);
      RoundOfSpellsWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    } 
  }

  static FileWriter get_file_writer(int round) {
    if(RoundOfSpellsWriter.writerCreated == false) {
      System.out.println("Calling match_writer constructor."); 
      new RoundOfSpellsWriter(round, "default"); 
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    RoundOfSpellsWriter.writerCreated = var; 
  }
  
}
