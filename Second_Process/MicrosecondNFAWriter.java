package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

class MicrosecondNFAWriter {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  MicrosecondNFAWriter(int round, String team) {
    try {
      file_writer = Microsecond_NFA.getFileWriter(team, round); 
      MicrosecondNFAWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(MicrosecondNFAWriter.writerCreated == false) {
      System.out.println("Calling round_nfa constructor."); 
      new MicrosecondNFAWriter(round, "default"); 
    }
    return file_writer;
  }

  public static void setWriterCreated(boolean var) {
    MicrosecondNFAWriter.writerCreated = var; 
  }
}
