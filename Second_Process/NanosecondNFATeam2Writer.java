package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

class NanosecondNFATeam2Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  NanosecondNFATeam2Writer(int round, String team) {
    try {
      file_writer = Nanosecond_NFA.getFileWriter(team, round); 
      NanosecondNFATeam2Writer.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(NanosecondNFATeam2Writer.writerCreated == false) {
      System.out.println("Calling round_nfa constructor."); 
      new NanosecondNFATeam2Writer(round, "t2"); 
    }
    return file_writer;
  }

  public static void setWriterCreated(boolean var) {
    NanosecondNFATeam2Writer.writerCreated = var; 
  }
}
