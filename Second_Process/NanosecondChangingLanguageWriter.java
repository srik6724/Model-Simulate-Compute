package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

class NanosecondChangingLanguageWriter {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  NanosecondChangingLanguageWriter(String team, int round) {
    try {
      file_writer = Nanosecond_Dynamic_Language.getFileWriter(team, round);
      NanosecondChangingLanguageWriter.writerCreated = true; 
    } catch (IOException e) { 
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(NanosecondChangingLanguageWriter.writerCreated == false) {
      System.out.println("Calling round_changing_language constructor."); 
      new NanosecondChangingLanguageWriter("default", round);
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    NanosecondChangingLanguageWriter.writerCreated = var; 
  }
}
