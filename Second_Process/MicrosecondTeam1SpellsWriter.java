package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

class MicrosecondTeam1SpellsWriter {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  MicrosecondTeam1SpellsWriter(String team, int round) {
    try {
      file_writer = Microsecond_Recorder.getFileWriter(team, round); 
      MicrosecondTeam1SpellsWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace(); 
    }
  }

  static FileWriter get_file_writer(int round) {
    if(MicrosecondTeam1SpellsWriter.writerCreated == false) {
      System.out.println("Calling round_writer constructor"); 
      new MicrosecondTeam1SpellsWriter("t1", round); 
    }
    return file_writer; 
  }

  static void setWriterCreated(boolean var) {
    MicrosecondTeam1SpellsWriter.writerCreated = var; 
  }
}
