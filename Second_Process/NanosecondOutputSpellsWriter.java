package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

class NanosecondOutputSpellsWriter {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer;

  NanosecondOutputSpellsWriter(String team, int round) {
    try {
      file_writer = Nanosecond_Transducer.getFileWriter(team, round); 
      NanosecondOutputSpellsWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(NanosecondOutputSpellsWriter.writerCreated == false) {
      System.out.println("Calling round_output constructor"); 
      new NanosecondOutputSpellsWriter("default", round); 
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    NanosecondOutputSpellsWriter.writerCreated = var; 
  }
}
