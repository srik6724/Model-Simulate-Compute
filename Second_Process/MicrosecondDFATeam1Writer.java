package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

class MicrosecondDFATeam1Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  MicrosecondDFATeam1Writer(String team, int round) {
    try {
      file_writer = Microsecond_DFA.getFileWriter(team, round);
      MicrosecondDFATeam1Writer.writerCreated = true; 
    } catch (IOException e) { 
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(MicrosecondDFATeam1Writer.writerCreated == false) {
      System.out.println("Calling round_combine constructor."); 
      new MicrosecondDFATeam1Writer("t1", round);
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) { 
    MicrosecondDFATeam1Writer.writerCreated = var; 
  }
}
