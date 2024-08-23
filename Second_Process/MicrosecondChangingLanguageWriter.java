package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

class MicrosecondChangingLanguageWriter {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  MicrosecondChangingLanguageWriter(String team, int round) {
    try {
      file_writer = Microsecond_Dynamic_Language.getFileWriter(team, round);
      MicrosecondChangingLanguageWriter.writerCreated = true; 
    } catch (IOException e) { 
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(MicrosecondChangingLanguageWriter.writerCreated == false) {
      System.out.println("Calling round_changing_language constructor."); 
      new MicrosecondChangingLanguageWriter("default", round);
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    MicrosecondChangingLanguageWriter.writerCreated = var; 
  }
}
