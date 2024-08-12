package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

class NanosecondDFAWriter {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  NanosecondDFAWriter(String team, int round) {
    try {
      file_writer = Nanosecond_DFA.getFileWriter(team, round);
      NanosecondDFAWriter.writerCreated = true; 
    } catch (IOException e) { 
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(NanosecondDFAWriter.writerCreated == false) {
      System.out.println("Calling round_dfa constructor."); 
      new NanosecondDFAWriter("default", round);
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    NanosecondDFAWriter.writerCreated = var; 
  }
}
