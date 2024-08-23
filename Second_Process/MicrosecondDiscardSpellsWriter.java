package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

class MicrosecondDiscardSpellsWriter {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  MicrosecondDiscardSpellsWriter(int round, String team) {
    try {
      file_writer = Microsecond_Discarder.getFileWriter(team, round); 
      MicrosecondDiscardSpellsWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(MicrosecondDiscardSpellsWriter.writerCreated == false) {
      System.out.println("Calling round_remaining constructor.");
      new MicrosecondDiscardSpellsWriter(round, "default");
    }
    return file_writer;
  }

  public static void setWriterCreated(boolean var) {
    MicrosecondDiscardSpellsWriter.writerCreated = var; 
  }
}
