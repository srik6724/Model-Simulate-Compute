package wizPackage;

import java.io.FileWriter;
import java.io.IOException;

public class RoundSpellsWriter {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  RoundSpellsWriter() {
    try {
      file_writer = Match_Recorder.getFileWriter();
      RoundSpellsWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    } 
  }

  static FileWriter get_file_writer() {
    if(RoundSpellsWriter.writerCreated == false) {
      System.out.println("Calling match_writer constructor."); 
      new RoundSpellsWriter(); 
    }
    return file_writer;
  }
}
