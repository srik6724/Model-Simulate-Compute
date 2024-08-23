package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

class MicrosecondChangingLanguageTeam2Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  MicrosecondChangingLanguageTeam2Writer(String team, int round) {
    try {
      file_writer = Microsecond_Dynamic_Language.getFileWriter(team, round);
      MicrosecondChangingLanguageTeam2Writer.writerCreated = true; 
    } catch (IOException e) { 
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(MicrosecondChangingLanguageTeam2Writer.writerCreated == false) {
      System.out.println("Calling round_changing_language constructor."); 
      new MicrosecondChangingLanguageTeam2Writer("t2", round);
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    MicrosecondChangingLanguageTeam2Writer.writerCreated = var; 
  }
}
