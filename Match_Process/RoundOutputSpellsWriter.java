package Match_Process;

import java.io.FileWriter;
import java.io.IOException;

class RoundOutputSpellsWriter {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer;

  RoundOutputSpellsWriter(String team, int round) {
    try {
      file_writer = Round_Transducer.getFileWriter(team, round); 
      RoundOutputSpellsWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(RoundOutputSpellsWriter.writerCreated == false) {
      System.out.println("Calling round_output constructor"); 
      new RoundOutputSpellsWriter("default", round); 
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    RoundOutputSpellsWriter.writerCreated = var; 
  }
}
