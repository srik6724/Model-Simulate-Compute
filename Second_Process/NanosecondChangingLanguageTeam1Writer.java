package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

class NanosecondChangingLanguageTeam1Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  NanosecondChangingLanguageTeam1Writer(String team, int round) {
    try {
      file_writer = Nanosecond_Dynamic_Grammar.getFileWriter(team, round);
      NanosecondChangingLanguageTeam1Writer.writerCreated = true; 
    } catch (IOException e) { 
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(NanosecondChangingLanguageTeam1Writer.writerCreated == false) {
      System.out.println("Calling round_changing_language constructor."); 
      new NanosecondChangingLanguageTeam1Writer("t1", round);
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    NanosecondChangingLanguageTeam1Writer.writerCreated = var; 
  }
}
