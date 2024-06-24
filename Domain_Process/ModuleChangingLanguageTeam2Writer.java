package Domain_Process;

import java.io.FileWriter;
import java.io.IOException;

class ModuleChangingLanguageTeam2Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 

  ModuleChangingLanguageTeam2Writer(String team, int round) {
    try {
      file_writer = Module_Dynamic_Grammar.getFileWriter(team, round);
      ModuleChangingLanguageTeam2Writer.writerCreated = true; 
    } catch (IOException e) { 
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(ModuleChangingLanguageTeam2Writer.writerCreated == false) {
      System.out.println("Calling round_changing_language constructor."); 
      new ModuleChangingLanguageTeam2Writer("t2", round);
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    ModuleChangingLanguageTeam2Writer.writerCreated = var; 
  }
}
