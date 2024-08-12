package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

class NanosecondDFATeam1Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  NanosecondDFATeam1Writer(String team, int round) {
    try {
      file_writer = Nanosecond_DFA.getFileWriter(team, round);
      NanosecondDFATeam1Writer.writerCreated = true; 
    } catch (IOException e) { 
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(NanosecondDFATeam1Writer.writerCreated == false) {
      System.out.println("Calling round_combine constructor."); 
      new NanosecondDFATeam1Writer("t1", round);
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) { 
    NanosecondDFATeam1Writer.writerCreated = var; 
  }
}
