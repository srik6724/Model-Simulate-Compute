package wizPackage;

import java.io.FileWriter;
import java.io.IOException;

class RoundTeam1SpellsWriter {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  RoundTeam1SpellsWriter(String team, int round) {
    try {
      file_writer = Round_Recorder.getFileWriter(team, round); 
      RoundTeam1SpellsWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace(); 
    }
  }

  static FileWriter get_file_writer(int round) {
    if(RoundTeam1SpellsWriter.writerCreated == false) {
      System.out.println("Calling round_writer constructor"); 
      new RoundTeam1SpellsWriter("t1", round); 
    }
    return file_writer; 
  }

  static void setWriterCreated(boolean var) {
    RoundTeam1SpellsWriter.writerCreated = var; 
  }
}
