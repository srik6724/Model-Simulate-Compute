package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

class SecondLeftOverSpellsWriter {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer;

  SecondLeftOverSpellsWriter(String team) {
    try {
      file_writer = Second_Remaining.getFileWriter(team); 
      SecondLeftOverSpellsWriter.writerCreated = true;
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer() {
    if(SecondLeftOverSpellsWriter.writerCreated == false) {
      System.out.println("Calling domain_remaining constructor.");
      new SecondLeftOverSpellsWriter("t1");
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    SecondLeftOverSpellsWriter.writerCreated = var; 
  }
}
