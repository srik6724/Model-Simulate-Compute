package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

class NanosecondNFATeam1Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  NanosecondNFATeam1Writer(int round, String team) {
    try {
      file_writer = Nanosecond_NFA.getFileWriter(team, round); 
      NanosecondNFATeam1Writer.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(NanosecondNFATeam1Writer.writerCreated == false) {
      System.out.println("Calling round_nfa constructor."); 
      new NanosecondNFATeam1Writer(round, "t1"); 
    }
    return file_writer;
  }

  public static void setWriterCreated(boolean var) {
    NanosecondNFATeam1Writer.writerCreated = var; 
  }
}
