package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

class MicrosecondLeftOverSpellsWriter {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  MicrosecondLeftOverSpellsWriter(int round, String team) {
    try {
      file_writer = Microsecond_Remaining.getFileWriter(team, round); 
      MicrosecondLeftOverSpellsWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(MicrosecondLeftOverSpellsWriter.writerCreated == false) {
      System.out.println("Calling round_remaining constructor."); 
      new MicrosecondLeftOverSpellsWriter(round, "default"); 
    }
    return file_writer;
  }

  public static void setWriterCreated(boolean var) {
    MicrosecondLeftOverSpellsWriter.writerCreated = var; 
  }
}
