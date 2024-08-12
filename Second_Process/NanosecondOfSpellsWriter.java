package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

class NanosecondOfSpellsWriter {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  NanosecondOfSpellsWriter(int round, String team) {
    try {
      file_writer = Nanosecond_Recorder.getFileWriter(team, round);
      NanosecondOfSpellsWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    } 
  }

  static FileWriter get_file_writer(int round) {
    if(NanosecondOfSpellsWriter.writerCreated == false) {
      System.out.println("Calling match_writer constructor."); 
      new NanosecondOfSpellsWriter(round, "default"); 
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    NanosecondOfSpellsWriter.writerCreated = var; 
  }
  
}
