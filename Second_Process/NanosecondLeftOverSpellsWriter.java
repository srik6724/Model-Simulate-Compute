package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

class NanosecondLeftOverSpellsWriter {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  NanosecondLeftOverSpellsWriter(int round, String team) {
    try {
      file_writer = Nanosecond_Remaining.getFileWriter(team, round); 
      NanosecondLeftOverSpellsWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(NanosecondLeftOverSpellsWriter.writerCreated == false) {
      System.out.println("Calling round_remaining constructor."); 
      new NanosecondLeftOverSpellsWriter(round, "default"); 
    }
    return file_writer;
  }

  public static void setWriterCreated(boolean var) {
    NanosecondLeftOverSpellsWriter.writerCreated = var; 
  }
}
