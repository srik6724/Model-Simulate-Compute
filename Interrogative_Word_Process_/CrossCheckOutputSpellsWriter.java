package Interrogative_Word_Process_;

import java.io.FileWriter;
import java.io.IOException;

class CrossCheckOutputSpellsWriter {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer;

  CrossCheckOutputSpellsWriter(String team, int round) {
    try {
      file_writer = Cross_Check_Transducer.getFileWriter(team, round); 
      CrossCheckOutputSpellsWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(CrossCheckOutputSpellsWriter.writerCreated == false) {
      System.out.println("Calling round_output constructor"); 
      new CrossCheckOutputSpellsWriter("default", round); 
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    CrossCheckOutputSpellsWriter.writerCreated = var; 
  }
}
