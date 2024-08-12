package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

class NanosecondDiscardSpellsWriter {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  NanosecondDiscardSpellsWriter(int round, String team) {
    try {
      file_writer = Nanosecond_Discarder.getFileWriter(team, round); 
      NanosecondDiscardSpellsWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(NanosecondDiscardSpellsWriter.writerCreated == false) {
      System.out.println("Calling round_remaining constructor.");
      new NanosecondDiscardSpellsWriter(round, "default");
    }
    return file_writer;
  }

  public static void setWriterCreated(boolean var) {
    NanosecondDiscardSpellsWriter.writerCreated = var; 
  }
}
