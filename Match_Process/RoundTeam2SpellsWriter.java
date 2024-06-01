package Match_Process;

import java.io.FileWriter;
import java.io.IOException;

class RoundTeam2SpellsWriter {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  RoundTeam2SpellsWriter(String team, int round) {
    try {
      file_writer = Round_Recorder.getFileWriter(team, round);
      RoundTeam2SpellsWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(RoundTeam2SpellsWriter.writerCreated == false) {
      System.out.println("Calling round_writer constructor."); 
      new RoundTeam2SpellsWriter("t2", round); 
    }
    return file_writer; 
  }

  static void setWriterCreated(boolean var) {
    RoundTeam2SpellsWriter.writerCreated = var; 
  }
  
}
