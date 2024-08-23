package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

class MicrosecondChangingLanguageTeam1Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  MicrosecondChangingLanguageTeam1Writer(String team, int round) {
    try {
      file_writer = Microsecond_Dynamic_Language.getFileWriter(team, round);
      MicrosecondChangingLanguageTeam1Writer.writerCreated = true; 
    } catch (IOException e) { 
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(MicrosecondChangingLanguageTeam1Writer.writerCreated == false) {
      System.out.println("Calling round_changing_language constructor."); 
      new MicrosecondChangingLanguageTeam1Writer("t1", round);
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    MicrosecondChangingLanguageTeam1Writer.writerCreated = var; 
  }
}
