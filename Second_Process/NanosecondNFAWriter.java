package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

class NanosecondNFAWriter {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  NanosecondNFAWriter(int round, String team) {
    try {
      file_writer = Nanosecond_NFA.getFileWriter(team, round); 
      NanosecondNFAWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(NanosecondNFAWriter.writerCreated == false) {
      System.out.println("Calling round_nfa constructor."); 
      new NanosecondNFAWriter(round, "default"); 
    }
    return file_writer;
  }

  public static void setWriterCreated(boolean var) {
    NanosecondNFAWriter.writerCreated = var; 
  }
}
