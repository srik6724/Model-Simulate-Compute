package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

class MicrosecondDFAWriter {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  MicrosecondDFAWriter(String team, int round) {
    try {
      file_writer = Microsecond_DFA.getFileWriter(team, round);
      MicrosecondDFAWriter.writerCreated = true; 
    } catch (IOException e) { 
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(MicrosecondDFAWriter.writerCreated == false) {
      System.out.println("Calling round_dfa constructor."); 
      new MicrosecondDFAWriter("default", round);
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    MicrosecondDFAWriter.writerCreated = var; 
  }
}
