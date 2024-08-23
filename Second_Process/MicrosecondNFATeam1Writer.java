package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

class MicrosecondNFATeam1Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  MicrosecondNFATeam1Writer(int round, String team) {
    try {
      file_writer = Microsecond_NFA.getFileWriter(team, round); 
      MicrosecondNFATeam1Writer.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(MicrosecondNFATeam1Writer.writerCreated == false) {
      System.out.println("Calling round_nfa constructor."); 
      new MicrosecondNFATeam1Writer(round, "t1"); 
    }
    return file_writer;
  }

  public static void setWriterCreated(boolean var) {
    MicrosecondNFATeam1Writer.writerCreated = var; 
  }
}
