package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

class NanosecondTeam1SpellsWriter {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  NanosecondTeam1SpellsWriter(String team, int round) {
    try {
      file_writer = Nanosecond_Recorder.getFileWriter(team, round); 
      NanosecondTeam1SpellsWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace(); 
    }
  }

  static FileWriter get_file_writer(int round) {
    if(NanosecondTeam1SpellsWriter.writerCreated == false) {
      System.out.println("Calling round_writer constructor"); 
      new NanosecondTeam1SpellsWriter("t1", round); 
    }
    return file_writer; 
  }

  static void setWriterCreated(boolean var) {
    NanosecondTeam1SpellsWriter.writerCreated = var; 
  }
}
