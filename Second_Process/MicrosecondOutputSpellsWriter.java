package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

class MicrosecondOutputSpellsWriter {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer;

  MicrosecondOutputSpellsWriter(String team, int round) {
    try {
      file_writer = Microsecond_Transducer.getFileWriter(team, round); 
      MicrosecondOutputSpellsWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(MicrosecondOutputSpellsWriter.writerCreated == false) {
      System.out.println("Calling round_output constructor"); 
      new MicrosecondOutputSpellsWriter("default", round); 
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    MicrosecondOutputSpellsWriter.writerCreated = var; 
  }
}
