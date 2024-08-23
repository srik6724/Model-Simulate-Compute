package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

class MicrosecondTeam2SpellsWriter {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  MicrosecondTeam2SpellsWriter(String team, int round) {
    try {
      file_writer = Microsecond_Recorder.getFileWriter(team, round);
      MicrosecondTeam2SpellsWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(MicrosecondTeam2SpellsWriter.writerCreated == false) {
      System.out.println("Calling round_writer constructor."); 
      new MicrosecondTeam2SpellsWriter("t2", round); 
    }
    return file_writer; 
  }

  static void setWriterCreated(boolean var) {
    MicrosecondTeam2SpellsWriter.writerCreated = var; 
  }
  
}
