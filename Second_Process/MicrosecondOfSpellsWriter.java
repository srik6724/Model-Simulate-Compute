package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

class MicrosecondOfSpellsWriter {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  MicrosecondOfSpellsWriter(int round, String team) {
    try {
      file_writer = Microsecond_Recorder.getFileWriter(team, round);
      MicrosecondOfSpellsWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    } 
  }

  static FileWriter get_file_writer(int round) {
    if(MicrosecondOfSpellsWriter.writerCreated == false) {
      System.out.println("Calling match_writer constructor."); 
      new MicrosecondOfSpellsWriter(round, "default"); 
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    MicrosecondOfSpellsWriter.writerCreated = var; 
  }
  
}
