package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

class NanosecondTeam2SpellsWriter {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  NanosecondTeam2SpellsWriter(String team, int round) {
    try {
      file_writer = Nanosecond_Recorder.getFileWriter(team, round);
      NanosecondTeam2SpellsWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(NanosecondTeam2SpellsWriter.writerCreated == false) {
      System.out.println("Calling round_writer constructor."); 
      new NanosecondTeam2SpellsWriter("t2", round); 
    }
    return file_writer; 
  }

  static void setWriterCreated(boolean var) {
    NanosecondTeam2SpellsWriter.writerCreated = var; 
  }
  
}
